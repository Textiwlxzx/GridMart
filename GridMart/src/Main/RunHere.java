package Main;

import DataProduct.Drinks.Drink;
import DataProduct.Drinks.StorageDrink;
import DataProduct.Essentials.Essentials;
import DataProduct.Essentials.StorageEss;
import DataProduct.Others.Others;
import DataProduct.Others.StorageOthers;
import DataProduct.ProcessFood.ProcessFood;
import DataProduct.ProcessFood.StorageFood;
import DataProduct.Product.AboutExp;
import DataProduct.Snack.Snack;
import DataProduct.Snack.StorageSnack;
import Exp.ExpPanel;
import ManageUser.MainUser;
import ManageUser.StorageLog;
import Order.Cash;
import Order.OrderList;
import Order.ProductOrder;
import Order.QR;
import Purchased.AddStockData;
import Purchased.Addq;
import Purchased.StockDataPanel;
import Purchased.StoragePurchasedDate;
import StorageOrder.DataOrder;
import StorageOrder.Storage;
import Total.MainTotal;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import login.Login;
import login.LogoutMDI;
import login.PopupLogout;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;

public class RunHere extends javax.swing.JFrame {
    
    public int Orderno = Storage.getLastOrderNumber() ;

    public RunHere() {
        initComponents();
        dt();
        times();
        addProduct();
        addNotiExp();
        addPurchased();
        setUsernamee();
        setTitle("GridMart");
        GlassPanePopup.install(this);
        revalidate();
        repaint();
    }
    
    public void dt() {
        Thread dateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dd = sdf.format(d);
                    date.setText(dd);
                    date1.setText(dd);
                    date2.setText(dd);
                    date3.setText(dd);
                    date4.setText(dd);
                    date5.setText(dd);
                    date6.setText(dd);
                    date7.setText(dd);
                    date8.setText(dd);
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        dateThread.start();
    }

    public void times() {
        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date dt = new Date();
                    SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss a");
                    String tt = st.format(dt);
                    time.setText(tt);
                    time1.setText(tt);
                    time2.setText(tt);
                    time3.setText(tt);
                    time4.setText(tt);
                    time5.setText(tt);
                    time6.setText(tt);
                    time7.setText(tt);
                    time8.setText(tt);
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timeThread.start();
    }   
    
    private void addProduct() {
        //Drinks
        StorageDrink.loadFromFile();        
        ArrayList<Drink> allDrinks = StorageDrink.getAllDrinks();
        for (Drink d : allDrinks) {

            ProductPanel p = new ProductPanel(d.getName(), d.getDescription(), 
                    d.getCost(), d.getPrice(), d.getQuantity(), d.getExp(), d.getCategory(), d.getImagePath());
            
            ProductOrder x = new ProductOrder(d.getName(), d.getDescription(), d.getPrice(),d.getQuantity(),d.getImagePath());
            
            mainPanel.add(p);
            ProductOrder.add(x);
        } 
        //Snacks
        StorageSnack.loadFromFile();        
        ArrayList<Snack> allSnacks = StorageSnack.getAllSnacks();
        for (Snack s : allSnacks) {

            ProductPanel p = new ProductPanel(s.getName(), s.getDescription(), 
                    s.getCost(), s.getPrice(), s.getQuantity(), s.getExp(), s.getCategory(), s.getImagePath());
            
            ProductOrder x = new ProductOrder(s.getName(), s.getDescription(), s.getPrice(),s.getQuantity(),s.getImagePath());
            
            mainPanel1.add(p);
            ProductOrder.add(x);
        }
        //ProcessFood
        StorageFood.loadFromFile();        
        ArrayList<ProcessFood> allFoods = StorageFood.getAll();
        for (ProcessFood s : allFoods) {
            ProductPanel p = new ProductPanel(s.getName(), s.getDescription(), 
                    s.getCost(), s.getPrice(), s.getQuantity(),s.getExp(), s.getCategory(), s.getImagePath());
            
            ProductOrder x = new ProductOrder(s.getName(), s.getDescription(), s.getPrice(),s.getQuantity(),s.getImagePath());
            
            panelMain2.add(p);
            ProductOrder.add(x);
        }
        //Essentials
        StorageEss.loadFromFile();
        ArrayList<Essentials> allEss = StorageEss.getAll();
        for (Essentials e : allEss) {
            ProductPanel p = new ProductPanel(e.getName(), e.getDescription(), 
                    e.getCost(), e.getPrice(), e.getQuantity(), e.getExp(), e.getCategory(), e.getImagePath());
            
            ProductOrder x = new ProductOrder(e.getName(), e.getDescription(), e.getPrice(),e.getQuantity(),e.getImagePath());
            
            panelMain3.add(p);
            ProductOrder.add(x);
        }
        //Others
        StorageOthers.loadFromFile();
        ArrayList<Others> allOt = StorageOthers.getAll();
        for (Others o : allOt) {
            ProductPanel p = new ProductPanel(o.getName(), o.getDescription(), 
                    o.getCost(), o.getPrice(), o.getQuantity(),o.getExp(), o.getCategory(), o.getImagePath());
            
            ProductOrder x = new ProductOrder(o.getName(), o.getDescription(), o.getPrice(),o.getQuantity(),o.getImagePath());
          
            panelMain4.add(p);
            ProductOrder.add(x);
        }
    }
    
    private void addNotiExp() {
        //Drink
        StorageDrink.loadFromFile();
        ArrayList<Drink> allDrinks = StorageDrink.getAllDrinks();
        for (Drink d : allDrinks) {
            if (d.isExpProduct(d.getExp())) {
                if(AboutExp.checkDayToNotify(d)) {                
                    ExpPanel e = new ExpPanel(d.getImagePath(), d.getLot(), d.getName(), d.getExp(), d.getDaysUntilExp());
                    mainPanelExp.add(e);
                }
            }               
        }
        //Snack
        StorageSnack.loadFromFile();    
        ArrayList<Snack> allSnacks = StorageSnack.getAllSnacks();
        for (Snack d : allSnacks) {
            if (d.isExpProduct(d.getExp())) {
                if(AboutExp.checkDayToNotify(d)) {
                    ExpPanel e = new ExpPanel(d.getImagePath(), d.getLot(), d.getName(), d.getExp(), d.getDaysUntilExp());
                    mainPanelExp.add(e);
                }
            }               
        }
        //ProcessFood
        StorageFood.loadFromFile();    
        ArrayList<ProcessFood> allFoods = StorageFood.getAll();
        for (ProcessFood d : allFoods) {
            if (d.isExpProduct(d.getExp())) {
                if(AboutExp.checkDayToNotify(d)) {
                    ExpPanel e = new ExpPanel(d.getImagePath(), d.getLot(), d.getName(), d.getExp(), d.getDaysUntilExp());
                    mainPanelExp.add(e);
                }
            }               
        }
        //Essentials
        StorageEss.loadFromFile();
        ArrayList<Essentials> allEss = StorageEss.getAll();
        for (Essentials d : allEss) {
            if (d.isExpProduct(d.getExp())) {
                if(AboutExp.checkDayToNotify(d)) {
                    ExpPanel e = new ExpPanel(d.getImagePath(), d.getLot(), d.getName(), d.getExp(), d.getDaysUntilExp());
                    mainPanelExp.add(e);
                }
            }               
        }
        //Others
        StorageOthers.loadFromFile();    
        ArrayList<Others> allOt = StorageOthers.getAll();
        for (Others d : allOt) {
            if (d.isExpProduct(d.getExp())) {
                if(AboutExp.checkDayToNotify(d)) {
                    ExpPanel e = new ExpPanel(d.getImagePath(), d.getLot(), d.getName(), d.getExp(), d.getDaysUntilExp());
                    mainPanelExp.add(e);
                }
            }               
        }
    }

    private void setUsernamee() {
        String x ;
        StorageLog.loadFromFile();
        x = StorageLog.getAllLog().get(StorageLog.getAllLog().size()-1).getName();
        l_name.setText(x);
        l_name1.setText(x);
        l_name2.setText(x);
        l_name3.setText(x);
        l_name4.setText(x);
        l_name5.setText(x);
        l_name6.setText(x);
        l_name7.setText(x);
        l_name8.setText(x);
    }
    
    public static void addOrder(String name, Double price){
        OrderPanel.add(new OrderList(name,price));
        OrderPanel.revalidate();
        OrderPanel.repaint();
        System.out.println("Add Success");
    }
    
    public static void removeOrder(JPanel o_remove){
        OrderPanel.remove(o_remove);
        OrderPanel.revalidate();
        OrderPanel.repaint();
    }
    
    private void addPurchased() {
        panel1.removeAll();
        StoragePurchasedDate.clearPurchased();
        StoragePurchasedDate.loadFromFile();
        ArrayList<AddStockData> allStockAdd = StoragePurchasedDate.getAllStockData();
        for (AddStockData d : allStockAdd) {
            System.out.println(d.getName());
            StockDataPanel p = new StockDataPanel(d.getDate(), d.getName(), d.getQuantity());
            panel1.add(p);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CardPanel = new Rectangle.Panel();
        Default = new Background.background();
        con1 = new Rectangle.RectangleBorder();
        b_order = new button.ButtonClear();
        b_expired = new button.ButtonClear();
        b_purchased = new button.ButtonClear();
        b_product = new button.ButtonClear();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        b_total = new button.ButtonClear();
        l_name = new CustomFont.LabelText();
        b_logout = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        b_setting = new button.ButtonIcon();
        ProductD = new Background.background();
        con2 = new Rectangle.RectangleBorder();
        b_order1 = new button.ButtonClear();
        b_expired1 = new button.ButtonClear();
        b_purchased1 = new button.ButtonClear();
        button11 = new button.Button1();
        rectangleBorder3 = new Rectangle.RectangleBorder();
        b_total1 = new button.ButtonClear();
        l_name1 = new CustomFont.LabelText();
        b_logout1 = new button.ButtonNoFillNoStroke();
        labelText4 = new CustomFont.LabelText();
        date1 = new CustomFont.LabelText();
        labelText6 = new CustomFont.LabelText();
        time1 = new CustomFont.LabelText();
        b_setting1 = new button.ButtonIcon();
        b_drinks = new button.ButtonNoFillNoStroke();
        b_snack = new button.ButtonNoFillNoStroke();
        b_food = new button.ButtonNoFillNoStroke();
        b_ess = new button.ButtonNoFillNoStroke();
        b_others = new button.ButtonNoFillNoStroke();
        b_add = new button.ButtonRaven();
        scrollPane = new Scroll.ScrollPaneWin11();
        mainPanel = new Rectangle.Panel();
        ProductS = new Background.background();
        con3 = new Rectangle.RectangleBorder();
        b_order2 = new button.ButtonClear();
        b_expired2 = new button.ButtonClear();
        b_purchased2 = new button.ButtonClear();
        b_product2 = new button.Button1();
        b_drinks2 = new button.ButtonNoFillNoStroke();
        b_snack2 = new button.ButtonNoFillNoStroke();
        b_food2 = new button.ButtonNoFillNoStroke();
        b_ess2 = new button.ButtonNoFillNoStroke();
        b_others2 = new button.ButtonNoFillNoStroke();
        b_add1 = new button.ButtonRaven();
        scrollPane1 = new Scroll.ScrollPaneWin11();
        mainPanel1 = new Rectangle.Panel();
        rectangleBorder11 = new Rectangle.RectangleBorder();
        b_total2 = new button.ButtonClear();
        l_name2 = new CustomFont.LabelText();
        b_logout2 = new button.ButtonNoFillNoStroke();
        labelText21 = new CustomFont.LabelText();
        date2 = new CustomFont.LabelText();
        labelText22 = new CustomFont.LabelText();
        time2 = new CustomFont.LabelText();
        b_setting2 = new button.ButtonIcon();
        ProductP = new Background.background();
        con4 = new Rectangle.RectangleBorder();
        b_order3 = new button.ButtonClear();
        b_expired3 = new button.ButtonClear();
        b_purchased3 = new button.ButtonClear();
        button13 = new button.Button1();
        l_drink = new button.ButtonNoFillNoStroke();
        l_snack = new button.ButtonNoFillNoStroke();
        l_food = new button.ButtonNoFillNoStroke();
        l_ess = new button.ButtonNoFillNoStroke();
        l_ot = new button.ButtonNoFillNoStroke();
        b_add2 = new button.ButtonRaven();
        scrollPane2 = new Scroll.ScrollPaneWin11();
        panelMain2 = new Rectangle.Panel();
        rectangleBorder9 = new Rectangle.RectangleBorder();
        b_total3 = new button.ButtonClear();
        l_name3 = new CustomFont.LabelText();
        b_logout3 = new button.ButtonNoFillNoStroke();
        labelText17 = new CustomFont.LabelText();
        date3 = new CustomFont.LabelText();
        labelText18 = new CustomFont.LabelText();
        time3 = new CustomFont.LabelText();
        b_setting3 = new button.ButtonIcon();
        ProductE = new Background.background();
        con5 = new Rectangle.RectangleBorder();
        b_order4 = new button.ButtonClear();
        b_expired4 = new button.ButtonClear();
        b_purchased4 = new button.ButtonClear();
        button14 = new button.Button1();
        rectangleBorder6 = new Rectangle.RectangleBorder();
        b_total4 = new button.ButtonClear();
        l_name4 = new CustomFont.LabelText();
        b_logout4 = new button.ButtonNoFillNoStroke();
        labelText11 = new CustomFont.LabelText();
        date4 = new CustomFont.LabelText();
        labelText12 = new CustomFont.LabelText();
        time4 = new CustomFont.LabelText();
        b_setting4 = new button.ButtonIcon();
        buttonNoFillNoStroke16 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke17 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke18 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke19 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke20 = new button.ButtonNoFillNoStroke();
        b_add3 = new button.ButtonRaven();
        scrollPane3 = new Scroll.ScrollPaneWin11();
        panelMain3 = new Rectangle.Panel();
        ProductO = new Background.background();
        con6 = new Rectangle.RectangleBorder();
        b_order5 = new button.ButtonClear();
        b_expired5 = new button.ButtonClear();
        b_purchased5 = new button.ButtonClear();
        button15 = new button.Button1();
        rectangleBorder7 = new Rectangle.RectangleBorder();
        b_total5 = new button.ButtonClear();
        l_name5 = new CustomFont.LabelText();
        b_logout5 = new button.ButtonNoFillNoStroke();
        labelText13 = new CustomFont.LabelText();
        date5 = new CustomFont.LabelText();
        labelText14 = new CustomFont.LabelText();
        time5 = new CustomFont.LabelText();
        b_setting5 = new button.ButtonIcon();
        buttonNoFillNoStroke21 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke22 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke23 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke24 = new button.ButtonNoFillNoStroke();
        buttonNoFillNoStroke25 = new button.ButtonNoFillNoStroke();
        b_add4 = new button.ButtonRaven();
        scrollPane4 = new Scroll.ScrollPaneWin11();
        panelMain4 = new Rectangle.Panel();
        NotifyEXP = new Background.background();
        con7 = new Rectangle.RectangleBorder();
        b_order6 = new button.ButtonClear();
        b_purchased6 = new button.ButtonClear();
        b_product1 = new button.ButtonClear();
        button12 = new button.Button1();
        rectangleBorder8 = new Rectangle.RectangleBorder();
        b_total6 = new button.ButtonClear();
        l_name6 = new CustomFont.LabelText();
        b_logout6 = new button.ButtonNoFillNoStroke();
        labelText15 = new CustomFont.LabelText();
        date6 = new CustomFont.LabelText();
        labelText16 = new CustomFont.LabelText();
        time6 = new CustomFont.LabelText();
        b_setting6 = new button.ButtonIcon();
        scrollExp = new Scroll.ScrollPaneWin11();
        mainPanelExp = new Rectangle.Panel();
        Order = new Background.background();
        rectangleBorder1 = new Rectangle.RectangleBorder();
        b_order7 = new button.ButtonClear();
        b_expired7 = new button.ButtonClear();
        b_purchased7 = new button.ButtonClear();
        b_product7 = new button.Button1();
        rectangleBorder10 = new Rectangle.RectangleBorder();
        buttonClear5 = new button.ButtonClear();
        l_name7 = new CustomFont.LabelText();
        buttonNoFillNoStroke2 = new button.ButtonNoFillNoStroke();
        labelText19 = new CustomFont.LabelText();
        date7 = new CustomFont.LabelText();
        labelText20 = new CustomFont.LabelText();
        time7 = new CustomFont.LabelText();
        buttonIcon1 = new button.ButtonIcon();
        rectangleBorder12 = new Rectangle.RectangleBorder1();
        labelText1 = new CustomFont.LabelText();
        labelText23 = new CustomFont.LabelText();
        payment2 = new Order.Payment();
        scrollPaneWin112 = new Scroll.ScrollPaneWin11();
        OrderPanel = new Rectangle.Panel();
        Pay = new button.Button1();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        ProductOrder = new Rectangle.Panel();
        Purchased2 = new Background.background();
        con11 = new Rectangle.RectangleBorder();
        b_order10 = new button.ButtonClear();
        b_expired8 = new button.ButtonClear();
        b_product4 = new button.ButtonClear();
        b_purchased8 = new button.Button1();
        rectangleBorder13 = new Rectangle.RectangleBorder();
        b_total8 = new button.ButtonClear();
        l_name8 = new CustomFont.LabelText();
        b_logout8 = new button.ButtonNoFillNoStroke();
        labelText24 = new CustomFont.LabelText();
        date8 = new CustomFont.LabelText();
        labelText25 = new CustomFont.LabelText();
        time8 = new CustomFont.LabelText();
        b_setting8 = new button.ButtonIcon();
        rectangleBorder4 = new Rectangle.RectangleBorder();
        scrollPaneWin113 = new Scroll.ScrollPaneWin11();
        panel1 = new Rectangle.Panel();
        button16 = new button.Button1();
        labelText7 = new CustomFont.LabelText();
        labelText8 = new CustomFont.LabelText();
        labelText26 = new CustomFont.LabelText();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        CardPanel.setLayout(new java.awt.CardLayout());

        Default.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con1.setPreferredSize(new java.awt.Dimension(321, 817));
        con1.setRadius(65);

        b_order.setText("Order");
        b_order.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order.setRadius(55);
        b_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_orderMouseEntered(evt);
            }
        });
        b_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_orderActionPerformed(evt);
            }
        });

        b_expired.setText("Notify EXP");
        b_expired.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired.setRadius(55);
        b_expired.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expiredMouseEntered(evt);
            }
        });
        b_expired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expiredActionPerformed(evt);
            }
        });

        b_purchased.setText("Purchased");
        b_purchased.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased.setRadius(55);
        b_purchased.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchasedMouseEntered(evt);
            }
        });
        b_purchased.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchasedActionPerformed(evt);
            }
        });

        b_product.setText("Product");
        b_product.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product.setRadius(55);
        b_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_productMouseEntered(evt);
            }
        });
        b_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_productActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con1Layout = new javax.swing.GroupLayout(con1);
        con1.setLayout(con1Layout);
        con1Layout.setHorizontalGroup(
            con1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con1Layout.setVerticalGroup(
            con1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder2.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder2.setRadius(65);

        b_total.setText("Total");
        b_total.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total.setRadius(55);
        b_total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_totalMouseEntered(evt);
            }
        });
        b_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_totalActionPerformed(evt);
            }
        });

        l_name.setText("Employee's name");

        b_logout.setText("Log out");
        b_logout.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logoutMouseEntered(evt);
            }
        });
        b_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logoutActionPerformed(evt);
            }
        });

        labelText3.setText("Date");
        labelText3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelText3MouseClicked(evt);
            }
        });

        date.setText("0");

        labelText5.setText("Time");

        time.setText("0");

        b_setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_settingMouseEntered(evt);
            }
        });
        b_setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_settingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder2Layout = new javax.swing.GroupLayout(rectangleBorder2);
        rectangleBorder2.setLayout(rectangleBorder2Layout);
        rectangleBorder2Layout.setHorizontalGroup(
            rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder2Layout.setVerticalGroup(
            rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout DefaultLayout = new javax.swing.GroupLayout(Default);
        Default.setLayout(DefaultLayout);
        DefaultLayout.setHorizontalGroup(
            DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DefaultLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(con1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        DefaultLayout.setVerticalGroup(
            DefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DefaultLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(con1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        CardPanel.add(Default, "card2");

        ProductD.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con2.setPreferredSize(new java.awt.Dimension(321, 817));
        con2.setRadius(65);

        b_order1.setText("Order");
        b_order1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order1.setRadius(55);
        b_order1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order1MouseEntered(evt);
            }
        });
        b_order1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order1ActionPerformed(evt);
            }
        });

        b_expired1.setText("Notify EXP");
        b_expired1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired1.setRadius(55);
        b_expired1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired1MouseEntered(evt);
            }
        });
        b_expired1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired1ActionPerformed(evt);
            }
        });

        b_purchased1.setText("Purchased");
        b_purchased1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased1.setRadius(55);
        b_purchased1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased1MouseEntered(evt);
            }
        });
        b_purchased1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased1ActionPerformed(evt);
            }
        });

        button11.setText("Product");
        button11.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(278, 60));
        button11.setRadius(55);
        button11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button11MouseEntered(evt);
            }
        });
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con2Layout = new javax.swing.GroupLayout(con2);
        con2.setLayout(con2Layout);
        con2Layout.setHorizontalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con2Layout.setVerticalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder3.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder3.setRadius(65);

        b_total1.setText("Total");
        b_total1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total1.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total1.setRadius(55);
        b_total1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total1MouseEntered(evt);
            }
        });
        b_total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total1ActionPerformed(evt);
            }
        });

        l_name1.setText("Employee's name");

        b_logout1.setText("Log out");
        b_logout1.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout1MouseEntered(evt);
            }
        });
        b_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout1ActionPerformed(evt);
            }
        });

        labelText4.setText("Date");

        date1.setText("0");

        labelText6.setText("Time");

        time1.setText("0");

        b_setting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting1MouseEntered(evt);
            }
        });
        b_setting1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder3Layout = new javax.swing.GroupLayout(rectangleBorder3);
        rectangleBorder3.setLayout(rectangleBorder3Layout);
        rectangleBorder3Layout.setHorizontalGroup(
            rectangleBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder3Layout.setVerticalGroup(
            rectangleBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        b_drinks.setText("Drinks");
        b_drinks.setFont(new java.awt.Font("Afacad", 1, 24)); // NOI18N
        b_drinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_drinksMouseEntered(evt);
            }
        });

        b_snack.setText("Snack");
        b_snack.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_snack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_snackMouseEntered(evt);
            }
        });
        b_snack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_snackActionPerformed(evt);
            }
        });

        b_food.setText("Process food");
        b_food.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_foodMouseEntered(evt);
            }
        });
        b_food.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_foodActionPerformed(evt);
            }
        });

        b_ess.setText("Essentials");
        b_ess.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_ess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_essMouseEntered(evt);
            }
        });
        b_ess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_essActionPerformed(evt);
            }
        });

        b_others.setText("Others");
        b_others.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_others.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_othersMouseEntered(evt);
            }
        });
        b_others.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_othersActionPerformed(evt);
            }
        });

        b_add.setText("Add");
        b_add.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_add.setPreferredSize(new java.awt.Dimension(90, 40));
        b_add.setRound(35);
        b_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_addMouseEntered(evt);
            }
        });
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });

        scrollPane.setBorder(null);

        mainPanel.setPreferredSize(new java.awt.Dimension(986, 1400));
        mainPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout ProductDLayout = new javax.swing.GroupLayout(ProductD);
        ProductD.setLayout(ProductDLayout);
        ProductDLayout.setHorizontalGroup(
            ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductDLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rectangleBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductDLayout.createSequentialGroup()
                        .addComponent(con2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductDLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(b_drinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_snack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_ess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_others, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(ProductDLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ProductDLayout.setVerticalGroup(
            ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductDLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductDLayout.createSequentialGroup()
                        .addGroup(ProductDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_drinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_snack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_ess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_others, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );

        CardPanel.add(ProductD, "card3");

        ProductS.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con3.setPreferredSize(new java.awt.Dimension(321, 817));
        con3.setRadius(65);

        b_order2.setText("Order");
        b_order2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order2.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order2.setRadius(55);
        b_order2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order2MouseEntered(evt);
            }
        });
        b_order2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order2ActionPerformed(evt);
            }
        });

        b_expired2.setText("Notify EXP");
        b_expired2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired2.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired2.setRadius(55);
        b_expired2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired2MouseEntered(evt);
            }
        });
        b_expired2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired2ActionPerformed(evt);
            }
        });

        b_purchased2.setText("Purchased");
        b_purchased2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased2.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased2.setRadius(55);
        b_purchased2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased2MouseEntered(evt);
            }
        });
        b_purchased2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased2ActionPerformed(evt);
            }
        });

        b_product2.setText("Product");
        b_product2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product2.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product2.setRadius(55);
        b_product2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_product2MouseEntered(evt);
            }
        });
        b_product2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_product2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con3Layout = new javax.swing.GroupLayout(con3);
        con3.setLayout(con3Layout);
        con3Layout.setHorizontalGroup(
            con3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_product2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con3Layout.setVerticalGroup(
            con3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_product2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        b_drinks2.setText("Drinks");
        b_drinks2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_drinks2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_drinks2MouseEntered(evt);
            }
        });
        b_drinks2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_drinks2ActionPerformed(evt);
            }
        });

        b_snack2.setText("Snack");
        b_snack2.setFont(new java.awt.Font("Afacad", 1, 24)); // NOI18N
        b_snack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_snack2MouseEntered(evt);
            }
        });

        b_food2.setText("Process food");
        b_food2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_food2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_food2MouseEntered(evt);
            }
        });
        b_food2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_food2ActionPerformed(evt);
            }
        });

        b_ess2.setText("Essentials");
        b_ess2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_ess2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_ess2MouseEntered(evt);
            }
        });
        b_ess2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ess2ActionPerformed(evt);
            }
        });

        b_others2.setText("Others");
        b_others2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_others2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_others2MouseEntered(evt);
            }
        });
        b_others2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_others2ActionPerformed(evt);
            }
        });

        b_add1.setText("Add");
        b_add1.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_add1.setPreferredSize(new java.awt.Dimension(90, 40));
        b_add1.setRound(35);
        b_add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_add1MouseEntered(evt);
            }
        });
        b_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add1ActionPerformed(evt);
            }
        });

        scrollPane1.setBorder(null);

        mainPanel1.setPreferredSize(new java.awt.Dimension(986, 1400));
        mainPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPane1.setViewportView(mainPanel1);

        rectangleBorder11.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder11.setRadius(65);

        b_total2.setText("Total");
        b_total2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total2.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total2.setRadius(55);
        b_total2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total2MouseEntered(evt);
            }
        });
        b_total2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total2ActionPerformed(evt);
            }
        });

        l_name2.setText("Employee's name");

        b_logout2.setText("Log out");
        b_logout2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout2MouseEntered(evt);
            }
        });
        b_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout2ActionPerformed(evt);
            }
        });

        labelText21.setText("Date");

        date2.setText("0");

        labelText22.setText("Time");

        time2.setText("0");

        b_setting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting2MouseEntered(evt);
            }
        });
        b_setting2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder11Layout = new javax.swing.GroupLayout(rectangleBorder11);
        rectangleBorder11.setLayout(rectangleBorder11Layout);
        rectangleBorder11Layout.setHorizontalGroup(
            rectangleBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder11Layout.setVerticalGroup(
            rectangleBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder11Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout ProductSLayout = new javax.swing.GroupLayout(ProductS);
        ProductS.setLayout(ProductSLayout);
        ProductSLayout.setHorizontalGroup(
            ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductSLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductSLayout.createSequentialGroup()
                        .addComponent(con3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ProductSLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProductSLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(b_drinks2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_snack2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_food2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_ess2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_others2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ProductSLayout.setVerticalGroup(
            ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductSLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductSLayout.createSequentialGroup()
                        .addGroup(ProductSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_drinks2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_snack2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_food2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_ess2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_others2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );

        CardPanel.add(ProductS, "card3");

        ProductP.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con4.setPreferredSize(new java.awt.Dimension(321, 817));
        con4.setRadius(65);

        b_order3.setText("Order");
        b_order3.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order3.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order3.setRadius(55);
        b_order3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order3MouseEntered(evt);
            }
        });

        b_expired3.setText("Notify EXP");
        b_expired3.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired3.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired3.setRadius(55);
        b_expired3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired3MouseEntered(evt);
            }
        });
        b_expired3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired3ActionPerformed(evt);
            }
        });

        b_purchased3.setText("Purchased");
        b_purchased3.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased3.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased3.setRadius(55);
        b_purchased3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased3MouseEntered(evt);
            }
        });
        b_purchased3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased3ActionPerformed(evt);
            }
        });

        button13.setText("Product");
        button13.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button13.setPreferredSize(new java.awt.Dimension(278, 60));
        button13.setRadius(55);
        button13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button13MouseEntered(evt);
            }
        });
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con4Layout = new javax.swing.GroupLayout(con4);
        con4.setLayout(con4Layout);
        con4Layout.setHorizontalGroup(
            con4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con4Layout.setVerticalGroup(
            con4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con4Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        l_drink.setText("Drinks");
        l_drink.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        l_drink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_drinkMouseEntered(evt);
            }
        });
        l_drink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_drinkActionPerformed(evt);
            }
        });

        l_snack.setText("Snack");
        l_snack.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        l_snack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_snackMouseEntered(evt);
            }
        });
        l_snack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_snackActionPerformed(evt);
            }
        });

        l_food.setText("Process food");
        l_food.setFont(new java.awt.Font("Afacad", 1, 24)); // NOI18N
        l_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_foodMouseEntered(evt);
            }
        });

        l_ess.setText("Essentials");
        l_ess.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        l_ess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_essMouseEntered(evt);
            }
        });
        l_ess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_essActionPerformed(evt);
            }
        });

        l_ot.setText("Others");
        l_ot.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        l_ot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_otMouseEntered(evt);
            }
        });

        b_add2.setText("Add");
        b_add2.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_add2.setPreferredSize(new java.awt.Dimension(90, 40));
        b_add2.setRound(35);
        b_add2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_add2MouseEntered(evt);
            }
        });
        b_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add2ActionPerformed(evt);
            }
        });

        scrollPane2.setBorder(null);

        panelMain2.setPreferredSize(new java.awt.Dimension(986, 1400));
        panelMain2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPane2.setViewportView(panelMain2);

        rectangleBorder9.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder9.setRadius(65);

        b_total3.setText("Total");
        b_total3.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total3.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total3.setRadius(55);
        b_total3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total3MouseEntered(evt);
            }
        });
        b_total3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total3ActionPerformed(evt);
            }
        });

        l_name3.setText("Employee's name");

        b_logout3.setText("Log out");
        b_logout3.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout3MouseEntered(evt);
            }
        });
        b_logout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout3ActionPerformed(evt);
            }
        });

        labelText17.setText("Date");

        date3.setText("0");

        labelText18.setText("Time");

        time3.setText("0");

        b_setting3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting3MouseEntered(evt);
            }
        });
        b_setting3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder9Layout = new javax.swing.GroupLayout(rectangleBorder9);
        rectangleBorder9.setLayout(rectangleBorder9Layout);
        rectangleBorder9Layout.setHorizontalGroup(
            rectangleBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder9Layout.setVerticalGroup(
            rectangleBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder9Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout ProductPLayout = new javax.swing.GroupLayout(ProductP);
        ProductP.setLayout(ProductPLayout);
        ProductPLayout.setHorizontalGroup(
            ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductPLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductPLayout.createSequentialGroup()
                        .addComponent(con4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductPLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(l_drink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(l_snack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(l_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(l_ess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(l_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ProductPLayout.setVerticalGroup(
            ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductPLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductPLayout.createSequentialGroup()
                        .addGroup(ProductPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_drink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_snack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_ess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_add2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );

        CardPanel.add(ProductP, "card3");

        ProductE.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con5.setPreferredSize(new java.awt.Dimension(321, 817));
        con5.setRadius(65);

        b_order4.setText("Order");
        b_order4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order4.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order4.setRadius(55);
        b_order4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order4MouseEntered(evt);
            }
        });
        b_order4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order4ActionPerformed(evt);
            }
        });

        b_expired4.setText("Notify EXP");
        b_expired4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired4.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired4.setRadius(55);
        b_expired4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired4MouseEntered(evt);
            }
        });
        b_expired4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired4ActionPerformed(evt);
            }
        });

        b_purchased4.setText("Purchased");
        b_purchased4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased4.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased4.setRadius(55);
        b_purchased4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased4MouseEntered(evt);
            }
        });
        b_purchased4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased4ActionPerformed(evt);
            }
        });

        button14.setText("Product");
        button14.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button14.setPreferredSize(new java.awt.Dimension(278, 60));
        button14.setRadius(55);
        button14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button14MouseEntered(evt);
            }
        });
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con5Layout = new javax.swing.GroupLayout(con5);
        con5.setLayout(con5Layout);
        con5Layout.setHorizontalGroup(
            con5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con5Layout.setVerticalGroup(
            con5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con5Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder6.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder6.setRadius(65);

        b_total4.setText("Total");
        b_total4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total4.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total4.setRadius(55);
        b_total4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total4MouseEntered(evt);
            }
        });
        b_total4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total4ActionPerformed(evt);
            }
        });

        l_name4.setText("Employee's name");

        b_logout4.setText("Log out");
        b_logout4.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout4MouseEntered(evt);
            }
        });
        b_logout4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout4ActionPerformed(evt);
            }
        });

        labelText11.setText("Date");

        date4.setText("0");

        labelText12.setText("Time");

        time4.setText("0");

        b_setting4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting4MouseEntered(evt);
            }
        });
        b_setting4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder6Layout = new javax.swing.GroupLayout(rectangleBorder6);
        rectangleBorder6.setLayout(rectangleBorder6Layout);
        rectangleBorder6Layout.setHorizontalGroup(
            rectangleBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder6Layout.setVerticalGroup(
            rectangleBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        buttonNoFillNoStroke16.setText("Drinks");
        buttonNoFillNoStroke16.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke16MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke16ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke17.setText("Snack");
        buttonNoFillNoStroke17.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke17MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke17ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke18.setText("Process food");
        buttonNoFillNoStroke18.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke18MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke18ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke19.setText("Essentials");
        buttonNoFillNoStroke19.setFont(new java.awt.Font("Afacad", 1, 24)); // NOI18N
        buttonNoFillNoStroke19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke19MouseEntered(evt);
            }
        });

        buttonNoFillNoStroke20.setText("Others");
        buttonNoFillNoStroke20.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke20MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke20ActionPerformed(evt);
            }
        });

        b_add3.setText("Add");
        b_add3.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_add3.setPreferredSize(new java.awt.Dimension(90, 40));
        b_add3.setRound(35);
        b_add3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_add3MouseEntered(evt);
            }
        });
        b_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add3ActionPerformed(evt);
            }
        });

        scrollPane3.setBorder(null);

        panelMain3.setPreferredSize(new java.awt.Dimension(986, 1400));
        panelMain3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPane3.setViewportView(panelMain3);

        javax.swing.GroupLayout ProductELayout = new javax.swing.GroupLayout(ProductE);
        ProductE.setLayout(ProductELayout);
        ProductELayout.setHorizontalGroup(
            ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductELayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductELayout.createSequentialGroup()
                        .addComponent(con5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductELayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(buttonNoFillNoStroke16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_add3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ProductELayout.setVerticalGroup(
            ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductELayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductELayout.createSequentialGroup()
                        .addGroup(ProductELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonNoFillNoStroke16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );

        CardPanel.add(ProductE, "card3");

        ProductO.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con6.setPreferredSize(new java.awt.Dimension(321, 817));
        con6.setRadius(65);

        b_order5.setText("Order");
        b_order5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order5.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order5.setRadius(55);
        b_order5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order5MouseEntered(evt);
            }
        });
        b_order5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order5ActionPerformed(evt);
            }
        });

        b_expired5.setText("Notify EXP");
        b_expired5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired5.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired5.setRadius(55);
        b_expired5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired5MouseEntered(evt);
            }
        });
        b_expired5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired5ActionPerformed(evt);
            }
        });

        b_purchased5.setText("Purchased");
        b_purchased5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased5.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased5.setRadius(55);
        b_purchased5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased5MouseEntered(evt);
            }
        });
        b_purchased5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased5ActionPerformed(evt);
            }
        });

        button15.setText("Product");
        button15.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button15.setPreferredSize(new java.awt.Dimension(278, 60));
        button15.setRadius(55);
        button15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button15MouseEntered(evt);
            }
        });
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con6Layout = new javax.swing.GroupLayout(con6);
        con6.setLayout(con6Layout);
        con6Layout.setHorizontalGroup(
            con6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con6Layout.setVerticalGroup(
            con6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder7.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder7.setRadius(65);

        b_total5.setText("Total");
        b_total5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total5.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total5.setRadius(55);
        b_total5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total5MouseEntered(evt);
            }
        });
        b_total5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total5ActionPerformed(evt);
            }
        });

        l_name5.setText("Employee's name");

        b_logout5.setText("Log out");
        b_logout5.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout5MouseEntered(evt);
            }
        });
        b_logout5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout5ActionPerformed(evt);
            }
        });

        labelText13.setText("Date");

        date5.setText("0");

        labelText14.setText("Time");

        time5.setText("0");

        b_setting5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting5MouseEntered(evt);
            }
        });
        b_setting5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder7Layout = new javax.swing.GroupLayout(rectangleBorder7);
        rectangleBorder7.setLayout(rectangleBorder7Layout);
        rectangleBorder7Layout.setHorizontalGroup(
            rectangleBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder7Layout.setVerticalGroup(
            rectangleBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder7Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        buttonNoFillNoStroke21.setText("Drinks");
        buttonNoFillNoStroke21.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke21MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke21ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke22.setText("Snack");
        buttonNoFillNoStroke22.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke22MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke22ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke23.setText("Process food");
        buttonNoFillNoStroke23.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke23MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke23ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke24.setText("Essentials");
        buttonNoFillNoStroke24.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke24MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke24ActionPerformed(evt);
            }
        });

        buttonNoFillNoStroke25.setText("Others");
        buttonNoFillNoStroke25.setFont(new java.awt.Font("Afacad", 1, 24)); // NOI18N
        buttonNoFillNoStroke25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke25MouseEntered(evt);
            }
        });

        b_add4.setText("Add");
        b_add4.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_add4.setPreferredSize(new java.awt.Dimension(90, 40));
        b_add4.setRound(35);
        b_add4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_add4MouseEntered(evt);
            }
        });
        b_add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_add4ActionPerformed(evt);
            }
        });

        scrollPane4.setBorder(null);

        panelMain4.setPreferredSize(new java.awt.Dimension(986, 1400));
        panelMain4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPane4.setViewportView(panelMain4);

        javax.swing.GroupLayout ProductOLayout = new javax.swing.GroupLayout(ProductO);
        ProductO.setLayout(ProductOLayout);
        ProductOLayout.setHorizontalGroup(
            ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductOLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rectangleBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductOLayout.createSequentialGroup()
                        .addComponent(con6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ProductOLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(scrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProductOLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(buttonNoFillNoStroke21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonNoFillNoStroke25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_add4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ProductOLayout.setVerticalGroup(
            ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductOLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(con6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductOLayout.createSequentialGroup()
                        .addGroup(ProductOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonNoFillNoStroke21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonNoFillNoStroke25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_add4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        CardPanel.add(ProductO, "card3");

        NotifyEXP.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con7.setPreferredSize(new java.awt.Dimension(321, 817));
        con7.setRadius(65);

        b_order6.setText("Order");
        b_order6.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order6.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order6.setRadius(55);
        b_order6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order6MouseEntered(evt);
            }
        });
        b_order6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order6ActionPerformed(evt);
            }
        });

        b_purchased6.setText("Purchased");
        b_purchased6.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased6.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased6.setRadius(55);
        b_purchased6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased6MouseEntered(evt);
            }
        });
        b_purchased6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased6ActionPerformed(evt);
            }
        });

        b_product1.setText("Product");
        b_product1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product1.setRadius(55);
        b_product1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_product1MouseEntered(evt);
            }
        });
        b_product1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_product1ActionPerformed(evt);
            }
        });

        button12.setText("Notify EXP");
        button12.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button12.setPreferredSize(new java.awt.Dimension(278, 60));
        button12.setRadius(55);
        button12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button12MouseEntered(evt);
            }
        });
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con7Layout = new javax.swing.GroupLayout(con7);
        con7.setLayout(con7Layout);
        con7Layout.setHorizontalGroup(
            con7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con7Layout.setVerticalGroup(
            con7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con7Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder8.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder8.setRadius(65);

        b_total6.setText("Total");
        b_total6.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total6.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total6.setRadius(55);
        b_total6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total6MouseEntered(evt);
            }
        });
        b_total6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total6ActionPerformed(evt);
            }
        });

        l_name6.setText("Employee's name");

        b_logout6.setText("Log out");
        b_logout6.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout6MouseEntered(evt);
            }
        });
        b_logout6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout6ActionPerformed(evt);
            }
        });

        labelText15.setText("Date");

        date6.setText("0");

        labelText16.setText("Time");

        time6.setText("0");

        b_setting6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting6MouseEntered(evt);
            }
        });
        b_setting6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder8Layout = new javax.swing.GroupLayout(rectangleBorder8);
        rectangleBorder8.setLayout(rectangleBorder8Layout);
        rectangleBorder8Layout.setHorizontalGroup(
            rectangleBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder8Layout.setVerticalGroup(
            rectangleBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder8Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        scrollExp.setBorder(null);
        scrollExp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanelExp.setPreferredSize(new java.awt.Dimension(500, 1500));
        mainPanelExp.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 44, 45));
        scrollExp.setViewportView(mainPanelExp);

        javax.swing.GroupLayout NotifyEXPLayout = new javax.swing.GroupLayout(NotifyEXP);
        NotifyEXP.setLayout(NotifyEXPLayout);
        NotifyEXPLayout.setHorizontalGroup(
            NotifyEXPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotifyEXPLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(NotifyEXPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(con7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(NotifyEXPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotifyEXPLayout.createSequentialGroup()
                    .addContainerGap(414, Short.MAX_VALUE)
                    .addComponent(scrollExp, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );
        NotifyEXPLayout.setVerticalGroup(
            NotifyEXPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotifyEXPLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(con7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(NotifyEXPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotifyEXPLayout.createSequentialGroup()
                    .addContainerGap(224, Short.MAX_VALUE)
                    .addComponent(scrollExp, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        CardPanel.add(NotifyEXP, "card2");

        Order.setMaximumSize(new java.awt.Dimension(1440, 1024));
        Order.setName(""); // NOI18N
        Order.setPreferredSize(new java.awt.Dimension(1440, 1024));

        rectangleBorder1.setPreferredSize(new java.awt.Dimension(321, 817));
        rectangleBorder1.setRadius(65);

        b_order7.setText("Product");
        b_order7.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order7.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order7.setRadius(55);
        b_order7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order7MouseEntered(evt);
            }
        });
        b_order7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order7ActionPerformed(evt);
            }
        });

        b_expired7.setText("Notify EXP");
        b_expired7.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired7.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired7.setRadius(55);
        b_expired7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired7MouseEntered(evt);
            }
        });
        b_expired7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired7ActionPerformed(evt);
            }
        });

        b_purchased7.setText("Purchased");
        b_purchased7.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased7.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased7.setRadius(55);
        b_purchased7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased7MouseEntered(evt);
            }
        });
        b_purchased7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased7ActionPerformed(evt);
            }
        });

        b_product7.setText("Order");
        b_product7.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product7.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product7.setRadius(55);
        b_product7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_product7MouseEntered(evt);
            }
        });
        b_product7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_product7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder1Layout = new javax.swing.GroupLayout(rectangleBorder1);
        rectangleBorder1.setLayout(rectangleBorder1Layout);
        rectangleBorder1Layout.setHorizontalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_purchased7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_product7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        rectangleBorder1Layout.setVerticalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_order7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_product7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rectangleBorder10.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder10.setRadius(65);

        buttonClear5.setText("Total");
        buttonClear5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear5.setPreferredSize(new java.awt.Dimension(143, 54));
        buttonClear5.setRadius(55);
        buttonClear5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonClear5MouseEntered(evt);
            }
        });
        buttonClear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear5ActionPerformed(evt);
            }
        });

        l_name7.setText("Employee's name");

        buttonNoFillNoStroke2.setText("Log out");
        buttonNoFillNoStroke2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonNoFillNoStroke2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNoFillNoStroke2MouseEntered(evt);
            }
        });
        buttonNoFillNoStroke2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFillNoStroke2ActionPerformed(evt);
            }
        });

        labelText19.setText("Date");

        date7.setText("0");

        labelText20.setText("Time");

        time7.setText("0");

        buttonIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        buttonIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonIcon1MouseEntered(evt);
            }
        });
        buttonIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIcon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder10Layout = new javax.swing.GroupLayout(rectangleBorder10);
        rectangleBorder10.setLayout(rectangleBorder10Layout);
        rectangleBorder10Layout.setHorizontalGroup(
            rectangleBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClear5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(buttonNoFillNoStroke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder10Layout.setVerticalGroup(
            rectangleBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder10Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClear5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonNoFillNoStroke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        rectangleBorder12.setPreferredSize(new java.awt.Dimension(327, 801));

        labelText1.setText("Order");
        labelText1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        labelText1.setPreferredSize(new java.awt.Dimension(79, 32));

        labelText23.setText("Payment");
        labelText23.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N

        scrollPaneWin112.setBorder(null);
        scrollPaneWin112.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin112.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneWin112.setPreferredSize(new java.awt.Dimension(295, 447));

        OrderPanel.setPreferredSize(new java.awt.Dimension(295, 800));
        OrderPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));
        scrollPaneWin112.setViewportView(OrderPanel);

        Pay.setForeground(new java.awt.Color(0, 0, 0));
        Pay.setText("Pay");
        Pay.setFont(new java.awt.Font("Afacad", 1, 36)); // NOI18N
        Pay.setPreferredSize(new java.awt.Dimension(269, 74));
        Pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PayMouseEntered(evt);
            }
        });
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder12Layout = new javax.swing.GroupLayout(rectangleBorder12);
        rectangleBorder12.setLayout(rectangleBorder12Layout);
        rectangleBorder12Layout.setHorizontalGroup(
            rectangleBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder12Layout.createSequentialGroup()
                .addGroup(rectangleBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectangleBorder12Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(rectangleBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payment2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelText23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rectangleBorder12Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rectangleBorder12Layout.setVerticalGroup(
            rectangleBorder12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ProductOrder.setPreferredSize(new java.awt.Dimension(633, 4000));
        ProductOrder.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 50));
        scrollPaneWin111.setViewportView(ProductOrder);

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rectangleBorder10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(OrderLayout.createSequentialGroup()
                        .addComponent(rectangleBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rectangleBorder12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rectangleBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rectangleBorder12, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        CardPanel.add(Order, "card8");

        Purchased2.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con11.setPreferredSize(new java.awt.Dimension(321, 817));
        con11.setRadius(65);

        b_order10.setText("Order");
        b_order10.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order10.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order10.setRadius(55);
        b_order10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order10MouseEntered(evt);
            }
        });
        b_order10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_order10ActionPerformed(evt);
            }
        });

        b_expired8.setText("Notify EXP");
        b_expired8.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_expired8.setPreferredSize(new java.awt.Dimension(278, 60));
        b_expired8.setRadius(55);
        b_expired8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired8MouseEntered(evt);
            }
        });
        b_expired8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_expired8ActionPerformed(evt);
            }
        });

        b_product4.setText("Product");
        b_product4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product4.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product4.setRadius(55);
        b_product4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_product4MouseEntered(evt);
            }
        });
        b_product4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_product4ActionPerformed(evt);
            }
        });

        b_purchased8.setText("Purchased");
        b_purchased8.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased8.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased8.setRadius(55);
        b_purchased8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased8MouseEntered(evt);
            }
        });
        b_purchased8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_purchased8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con11Layout = new javax.swing.GroupLayout(con11);
        con11.setLayout(con11Layout);
        con11Layout.setHorizontalGroup(
            con11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con11Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_purchased8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_product4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con11Layout.setVerticalGroup(
            con11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con11Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_product4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rectangleBorder13.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder13.setRadius(65);

        b_total8.setText("Total");
        b_total8.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total8.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total8.setRadius(55);
        b_total8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_total8MouseEntered(evt);
            }
        });
        b_total8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_total8ActionPerformed(evt);
            }
        });

        l_name8.setText("Employee's name");

        b_logout8.setText("Log out");
        b_logout8.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_logout8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_logout8MouseEntered(evt);
            }
        });
        b_logout8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logout8ActionPerformed(evt);
            }
        });

        labelText24.setText("Date");

        date8.setText("0");

        labelText25.setText("Time");

        time8.setText("0");

        b_setting8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        b_setting8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_setting8MouseEntered(evt);
            }
        });
        b_setting8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_setting8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder13Layout = new javax.swing.GroupLayout(rectangleBorder13);
        rectangleBorder13.setLayout(rectangleBorder13Layout);
        rectangleBorder13Layout.setHorizontalGroup(
            rectangleBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(b_total8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(l_name8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(b_logout8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_setting8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder13Layout.setVerticalGroup(
            rectangleBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder13Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_setting8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_total8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_name8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        rectangleBorder4.setRadius(65);

        scrollPaneWin113.setBorder(null);
        scrollPaneWin113.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin113.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel1.setPreferredSize(new java.awt.Dimension(929, 1200));
        panel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));
        scrollPaneWin113.setViewportView(panel1);

        button16.setText("Add");
        button16.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        button16.setRadius(40);
        button16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button16MouseEntered(evt);
            }
        });
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button16ActionPerformed(evt);
            }
        });

        labelText7.setText("Date");
        labelText7.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N

        labelText8.setText("Product's Name");
        labelText8.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N

        labelText26.setText("Quantity");
        labelText26.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N

        javax.swing.GroupLayout rectangleBorder4Layout = new javax.swing.GroupLayout(rectangleBorder4);
        rectangleBorder4.setLayout(rectangleBorder4Layout);
        rectangleBorder4Layout.setHorizontalGroup(
            rectangleBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(rectangleBorder4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(scrollPaneWin113, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(rectangleBorder4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelText7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(labelText8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelText26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        rectangleBorder4Layout.setVerticalGroup(
            rectangleBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(rectangleBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelText7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneWin113, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Purchased2Layout = new javax.swing.GroupLayout(Purchased2);
        Purchased2.setLayout(Purchased2Layout);
        Purchased2Layout.setHorizontalGroup(
            Purchased2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Purchased2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(Purchased2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rectangleBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Purchased2Layout.createSequentialGroup()
                        .addComponent(con11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(rectangleBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        Purchased2Layout.setVerticalGroup(
            Purchased2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Purchased2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(Purchased2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(con11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rectangleBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        CardPanel.add(Purchased2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_orderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_orderMouseEntered
        b_order.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_orderMouseEntered

    private void b_expiredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expiredMouseEntered
        b_expired.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expiredMouseEntered

    private void b_purchasedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchasedMouseEntered
        b_purchased.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchasedMouseEntered

    private void b_productMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_productMouseEntered
        b_product.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_productMouseEntered

    private void b_totalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_totalMouseEntered
        b_total.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_totalMouseEntered

    private void b_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logoutMouseEntered
        b_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logoutMouseEntered

    private void b_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logoutActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logoutActionPerformed

    private void b_settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_settingMouseEntered
        b_setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_settingMouseEntered

    private void b_expired1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired1MouseEntered
        b_expired1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired1MouseEntered

    private void b_purchased1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased1MouseEntered
        b_purchased1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased1MouseEntered

    private void b_total1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total1MouseEntered
        b_total1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total1MouseEntered

    private void b_logout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout1MouseEntered
        b_logout1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout1MouseEntered

    private void b_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout1ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout1ActionPerformed

    private void b_setting1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting1MouseEntered
        b_setting1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting1MouseEntered

    private void b_order1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order1MouseEntered
        b_order1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order1MouseEntered

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed

        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new AddProduct(), option);
    }//GEN-LAST:event_b_addActionPerformed

    private void b_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_productActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_productActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_button11ActionPerformed

    private void b_snackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_snackActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductS);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_snackActionPerformed

    private void b_foodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_foodActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_foodActionPerformed

    private void b_essActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_essActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductE);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_essActionPerformed

    private void b_othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_othersActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductO);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_othersActionPerformed

    private void button11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button11MouseEntered
        button11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button11MouseEntered

    private void b_purchased1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased1ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased1ActionPerformed

    private void b_drinksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_drinksMouseEntered
        b_drinks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_drinksMouseEntered

    private void b_snackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_snackMouseEntered
        b_snack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_snackMouseEntered

    private void b_foodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_foodMouseEntered
        b_food.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_foodMouseEntered

    private void b_essMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_essMouseEntered
        b_ess.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_essMouseEntered

    private void b_othersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_othersMouseEntered
        b_others.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_othersMouseEntered

    private void b_add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add4ActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new AddProduct(), option);
    }//GEN-LAST:event_b_add4ActionPerformed

    private void buttonNoFillNoStroke24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke24ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductE);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke24ActionPerformed

    private void buttonNoFillNoStroke23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke23ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke23ActionPerformed

    private void buttonNoFillNoStroke22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke22ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductS);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke22ActionPerformed

    private void buttonNoFillNoStroke21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke21ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke21ActionPerformed

    private void b_setting5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting5MouseEntered
        b_setting5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting5MouseEntered

    private void b_logout5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout5ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout5ActionPerformed

    private void b_logout5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout5MouseEntered
        b_logout5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout5MouseEntered

    private void b_total5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total5MouseEntered
       b_total5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total5MouseEntered

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_button15ActionPerformed

    private void b_purchased5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased5MouseEntered
        b_purchased5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased5MouseEntered

    private void b_expired5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired5MouseEntered
        b_expired5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired5MouseEntered

    private void b_order5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order5MouseEntered
        b_order5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order5MouseEntered

    private void b_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add3ActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new AddProduct(), option);
    }//GEN-LAST:event_b_add3ActionPerformed

    private void buttonNoFillNoStroke20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke20ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductO);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke20ActionPerformed

    private void buttonNoFillNoStroke18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke18ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke18ActionPerformed

    private void buttonNoFillNoStroke17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke17ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductS);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke17ActionPerformed

    private void buttonNoFillNoStroke16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke16ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_buttonNoFillNoStroke16ActionPerformed

    private void b_setting4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting4MouseEntered
        b_setting4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting4MouseEntered

    private void b_logout4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout4ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout4ActionPerformed

    private void b_logout4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout4MouseEntered
        b_logout4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout4MouseEntered

    private void b_total4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total4MouseEntered
        b_total4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total4MouseEntered

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_button14ActionPerformed

    private void b_purchased4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased4MouseEntered
        b_purchased4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased4MouseEntered

    private void b_expired4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired4MouseEntered
        b_expired4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired4MouseEntered

    private void b_order4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order4MouseEntered
        b_order4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order4MouseEntered

    private void b_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add2ActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new AddProduct(), option);
    }//GEN-LAST:event_b_add2ActionPerformed

    private void l_essActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_essActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductE);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_l_essActionPerformed

    private void l_snackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_snackActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductS);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_l_snackActionPerformed

    private void l_drinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_drinkActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_l_drinkActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_button13ActionPerformed

    private void b_expired3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired3MouseEntered
        b_expired3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired3MouseEntered

    private void b_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_add1ActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new AddProduct(), option);
    }//GEN-LAST:event_b_add1ActionPerformed

    private void b_others2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_others2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductO);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_others2ActionPerformed

    private void b_others2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_others2MouseEntered
        b_others2 .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_others2MouseEntered

    private void b_ess2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ess2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductE);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_ess2ActionPerformed

    private void b_ess2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ess2MouseEntered
        b_ess2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_ess2MouseEntered

    private void b_food2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_food2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_food2ActionPerformed

    private void b_food2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_food2MouseEntered
        b_food2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_food2MouseEntered

    private void b_snack2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_snack2MouseEntered
        b_snack2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_snack2MouseEntered

    private void b_drinks2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_drinks2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_drinks2ActionPerformed

    private void b_drinks2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_drinks2MouseEntered
        b_drinks2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_drinks2MouseEntered

    private void b_product2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_product2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_product2ActionPerformed

    private void b_product2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_product2MouseEntered
        b_product2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_product2MouseEntered

    private void b_purchased2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased2MouseEntered
        b_purchased2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased2MouseEntered

    private void b_expired2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired2MouseEntered
        b_expired2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired2MouseEntered

    private void b_order2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order2MouseEntered
        b_order2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order2MouseEntered

    private void b_add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add1MouseEntered
        b_add1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_add1MouseEntered

    private void b_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_addMouseEntered
        b_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_addMouseEntered

    private void b_add2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add2MouseEntered
         b_add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_add2MouseEntered

    private void l_otMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_otMouseEntered
         l_ot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_otMouseEntered

    private void l_essMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_essMouseEntered
         l_ess.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_essMouseEntered

    private void l_foodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_foodMouseEntered
        l_food.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_foodMouseEntered

    private void l_snackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_snackMouseEntered
        l_snack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_snackMouseEntered

    private void l_drinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_drinkMouseEntered
        l_drink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_drinkMouseEntered

    private void button13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button13MouseEntered
        button13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button13MouseEntered

    private void b_order6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order6MouseEntered
        b_order6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order6MouseEntered

    private void b_product1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_product1MouseEntered
        b_product1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_product1MouseEntered

    private void b_product1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_product1ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_product1ActionPerformed

    private void b_total6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total6MouseEntered
        b_total6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total6MouseEntered

    private void b_logout6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout6MouseEntered
        b_logout6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout6MouseEntered

    private void b_logout6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout6ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout6ActionPerformed

    private void b_setting6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting6MouseEntered
        b_setting6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting6MouseEntered

    private void button12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button12MouseEntered
        button12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button12MouseEntered

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_button12ActionPerformed

    private void b_purchased6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased6MouseEntered
        b_purchased6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased6MouseEntered

    private void b_expired1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired1ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired1ActionPerformed

    private void b_expired2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired2ActionPerformed

    private void b_expired3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired3ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired3ActionPerformed

    private void b_expired4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired4ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired4ActionPerformed

    private void b_expired5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired5ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired5ActionPerformed

    private void b_purchased6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased6ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased6ActionPerformed

    private void b_expiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expiredActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expiredActionPerformed

    private void buttonNoFillNoStroke16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke16MouseEntered
        buttonNoFillNoStroke16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke16MouseEntered

    private void buttonNoFillNoStroke17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke17MouseEntered
       buttonNoFillNoStroke17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke17MouseEntered

    private void buttonNoFillNoStroke18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke18MouseEntered
        buttonNoFillNoStroke18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke18MouseEntered

    private void buttonNoFillNoStroke19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke19MouseEntered
        buttonNoFillNoStroke19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke19MouseEntered

    private void buttonNoFillNoStroke20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke20MouseEntered
        buttonNoFillNoStroke20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke20MouseEntered

    private void b_add3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add3MouseEntered
        b_add3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_add3MouseEntered

    private void button14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button14MouseEntered
        button14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button14MouseEntered

    private void buttonNoFillNoStroke21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke21MouseEntered
        buttonNoFillNoStroke21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke21MouseEntered

    private void buttonNoFillNoStroke22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke22MouseEntered
        buttonNoFillNoStroke22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke22MouseEntered

    private void buttonNoFillNoStroke23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke23MouseEntered
        buttonNoFillNoStroke23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke23MouseEntered

    private void buttonNoFillNoStroke24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke24MouseEntered
        buttonNoFillNoStroke24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke24MouseEntered

    private void buttonNoFillNoStroke25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke25MouseEntered
        buttonNoFillNoStroke25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke25MouseEntered

    private void b_add4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_add4MouseEntered
        b_add4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_add4MouseEntered

    private void button15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button15MouseEntered
        button15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button15MouseEntered

    private void b_total3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total3MouseEntered
        b_total3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total3MouseEntered

    private void b_logout3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout3MouseEntered
        b_logout3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout3MouseEntered

    private void b_logout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout3ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout3ActionPerformed

    private void b_setting3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting3MouseEntered
        b_setting3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting3MouseEntered

    private void b_total2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total2MouseEntered
        b_total2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total2MouseEntered

    private void b_logout2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout2MouseEntered
        b_logout2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout2MouseEntered

    private void b_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout2ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout2ActionPerformed

    private void b_setting2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting2MouseEntered
        b_setting2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting2MouseEntered

    private void b_setting5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting5ActionPerformed
        MainUser fr = new MainUser();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting5ActionPerformed

    private void b_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_settingActionPerformed
        MainUser fr = new MainUser();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_settingActionPerformed

    private void b_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_totalActionPerformed
        this.setVisible(false);
        MainTotal fr = new MainTotal();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_totalActionPerformed

    private void b_order7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order7MouseEntered
        b_order7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order7MouseEntered

    private void b_order7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order7ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order7ActionPerformed

    private void b_expired7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired7MouseEntered
        b_expired7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired7MouseEntered

    private void b_expired7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired7ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired7ActionPerformed

    private void b_purchased7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased7MouseEntered
        b_purchased7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased7MouseEntered

    private void b_product7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_product7ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Default);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_product7ActionPerformed

    private void buttonClear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear5ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonClear5ActionPerformed

    private void PayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayMouseEntered
        Pay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_PayMouseEntered

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        int componentCount = OrderPanel.getComponentCount();
        System.out.println(componentCount);

        for (int i=0 ; i < componentCount ; i++) {
            JPanel panel = (JPanel) OrderPanel.getComponent(i);
            JPanel panel1 = (JPanel) panel.getComponent(1);
            JLabel x = (JLabel) panel1.getComponent(0);
            JTextField y = (JTextField) panel1.getComponent(1);
            Storage.EditQuantity(x.getText(), Integer.parseInt(y.getText()));
            Storage.EditPayment(x.getText(),"Cash");
        }

        if (payment2.isCashSelected()) {
            for (int i=0 ; i < componentCount ; i++) {
                JPanel panel = (JPanel) OrderPanel.getComponent(i);
                JPanel panel1 = (JPanel) panel.getComponent(1);
                JLabel x = (JLabel) panel1.getComponent(0);
                Storage.EditPayment(x.getText(), "Cash");
            }
        } else if (payment2.isQRSelected()) {
            for (int i=0 ; i < componentCount ; i++) {
                JPanel panel = (JPanel) OrderPanel.getComponent(i);
                JPanel panel1 = (JPanel) panel.getComponent(1);
                JLabel x = (JLabel) panel1.getComponent(0);
                Storage.EditPayment(x.getText(), "QR");
            }
        }

        Storage.saveToFile();
        Storage.loadFromFile();
        Orderno++;

        ArrayList<DataOrder> orders = Storage.getAllDataOrder();

        Storage.loadFromFileReceipt();
        Storage.addReceipt(Orderno,orders);
        Storage.saveToFileReceipt();

        Storage.clearFile();

        if (payment2.isCashSelected()) {
            for (int i=0 ; i < componentCount ; i++) {
            }
            GlassPanePopup.showPopup(new Cash());

        } else if (payment2.isQRSelected()) {
            GlassPanePopup.showPopup(new QR());
        }
    }//GEN-LAST:event_PayActionPerformed

    private void b_order6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order6ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order6ActionPerformed

    private void b_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_orderActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_orderActionPerformed

    private void b_order1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order1ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order1ActionPerformed

    private void b_total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total1ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total1ActionPerformed

    private void b_setting1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting1ActionPerformed
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting1ActionPerformed

    private void b_total2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total2ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total2ActionPerformed

    private void b_setting2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting2ActionPerformed
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting2ActionPerformed

    private void b_total3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total3ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total3ActionPerformed

    private void b_setting3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting3ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting3ActionPerformed

    private void b_total4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total4ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total4ActionPerformed

    private void b_setting4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting4ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting4ActionPerformed

    private void b_total5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total5ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total5ActionPerformed

    private void b_total6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total6ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total6ActionPerformed

    private void b_setting6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting6ActionPerformed
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting6ActionPerformed

    private void buttonIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIcon1ActionPerformed
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonIcon1ActionPerformed

    private void b_purchased7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased7ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased7ActionPerformed

    private void buttonNoFillNoStroke2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke2ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonNoFillNoStroke2ActionPerformed

    private void b_product7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_product7MouseEntered
        b_product7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_product7MouseEntered

    private void buttonClear5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClear5MouseEntered
        buttonClear5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonClear5MouseEntered

    private void buttonNoFillNoStroke2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNoFillNoStroke2MouseEntered
        buttonNoFillNoStroke2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonNoFillNoStroke2MouseEntered

    private void buttonIcon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIcon1MouseEntered
        buttonIcon1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonIcon1MouseEntered

    private void b_order3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order3MouseEntered
        b_order3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order3MouseEntered

    private void b_purchased3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased3MouseEntered
        b_purchased3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_purchased3MouseEntered

    private void b_order2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order2ActionPerformed

    private void b_order4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order4ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order4ActionPerformed

    private void b_order5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order5ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order5ActionPerformed

    private void b_order10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order10MouseEntered
        b_order10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_order10MouseEntered

    private void b_expired8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired8MouseEntered
        b_expired8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_expired8MouseEntered

    private void b_expired8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_expired8ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(NotifyEXP);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_expired8ActionPerformed

    private void b_product4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_product4MouseEntered
        b_product4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_product4MouseEntered

    private void b_product4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_product4ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(ProductD);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_product4ActionPerformed

    private void b_total8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_total8MouseEntered
        b_total8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_total8MouseEntered

    private void b_logout8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logout8MouseEntered
        b_logout8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logout8MouseEntered

    private void b_logout8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logout8ActionPerformed
        this.setVisible(false);
        LogoutMDI newFrame = new LogoutMDI();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_logout8ActionPerformed

    private void b_setting8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_setting8MouseEntered
        b_setting8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_setting8MouseEntered

    private void button16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button16ActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new Addq(), option);
    }//GEN-LAST:event_button16ActionPerformed

    private void b_purchasedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchasedActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchasedActionPerformed

    private void b_order10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order10ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Order);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_order10ActionPerformed

    private void b_total8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_total8ActionPerformed
        this.setVisible(false);
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_total8ActionPerformed

    private void b_setting8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_setting8ActionPerformed
        this.setVisible(false);
        MainTotal newFrame = new MainTotal();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_setting8ActionPerformed

    private void b_purchased2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased2ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased2ActionPerformed

    private void b_purchased3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased3ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased3ActionPerformed

    private void b_purchased4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased4ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased4ActionPerformed

    private void b_purchased5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased5ActionPerformed
        CardPanel.removeAll();
        CardPanel.add(Purchased2);
        CardPanel.repaint();
        CardPanel.revalidate();
    }//GEN-LAST:event_b_purchased5ActionPerformed

    private void button16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button16MouseEntered
        button16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button16MouseEntered

    private void labelText3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelText3MouseClicked
        this.setVisible(false);
        Login newFrame = new Login ();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_labelText3MouseClicked

    private void b_purchased8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_b_purchased8MouseEntered

    private void b_purchased8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_purchased8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_purchased8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RunHere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RunHere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RunHere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RunHere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RunHere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Rectangle.Panel CardPanel;
    private Background.background Default;
    private Background.background NotifyEXP;
    private Background.background Order;
    private static Rectangle.Panel OrderPanel;
    private button.Button1 Pay;
    private Background.background ProductD;
    private Background.background ProductE;
    private Background.background ProductO;
    private Rectangle.Panel ProductOrder;
    private Background.background ProductP;
    private Background.background ProductS;
    private Background.background Purchased2;
    private button.ButtonRaven b_add;
    private button.ButtonRaven b_add1;
    private button.ButtonRaven b_add2;
    private button.ButtonRaven b_add3;
    private button.ButtonRaven b_add4;
    private button.ButtonNoFillNoStroke b_drinks;
    private button.ButtonNoFillNoStroke b_drinks2;
    private button.ButtonNoFillNoStroke b_ess;
    private button.ButtonNoFillNoStroke b_ess2;
    private button.ButtonClear b_expired;
    private button.ButtonClear b_expired1;
    private button.ButtonClear b_expired2;
    private button.ButtonClear b_expired3;
    private button.ButtonClear b_expired4;
    private button.ButtonClear b_expired5;
    private button.ButtonClear b_expired7;
    private button.ButtonClear b_expired8;
    private button.ButtonNoFillNoStroke b_food;
    private button.ButtonNoFillNoStroke b_food2;
    private button.ButtonNoFillNoStroke b_logout;
    private button.ButtonNoFillNoStroke b_logout1;
    private button.ButtonNoFillNoStroke b_logout2;
    private button.ButtonNoFillNoStroke b_logout3;
    private button.ButtonNoFillNoStroke b_logout4;
    private button.ButtonNoFillNoStroke b_logout5;
    private button.ButtonNoFillNoStroke b_logout6;
    private button.ButtonNoFillNoStroke b_logout8;
    private button.ButtonClear b_order;
    private button.ButtonClear b_order1;
    private button.ButtonClear b_order10;
    private button.ButtonClear b_order2;
    private button.ButtonClear b_order3;
    private button.ButtonClear b_order4;
    private button.ButtonClear b_order5;
    private button.ButtonClear b_order6;
    private button.ButtonClear b_order7;
    private button.ButtonNoFillNoStroke b_others;
    private button.ButtonNoFillNoStroke b_others2;
    private button.ButtonClear b_product;
    private button.ButtonClear b_product1;
    private button.Button1 b_product2;
    private button.ButtonClear b_product4;
    private button.Button1 b_product7;
    private button.ButtonClear b_purchased;
    private button.ButtonClear b_purchased1;
    private button.ButtonClear b_purchased2;
    private button.ButtonClear b_purchased3;
    private button.ButtonClear b_purchased4;
    private button.ButtonClear b_purchased5;
    private button.ButtonClear b_purchased6;
    private button.ButtonClear b_purchased7;
    private button.Button1 b_purchased8;
    private button.ButtonIcon b_setting;
    private button.ButtonIcon b_setting1;
    private button.ButtonIcon b_setting2;
    private button.ButtonIcon b_setting3;
    private button.ButtonIcon b_setting4;
    private button.ButtonIcon b_setting5;
    private button.ButtonIcon b_setting6;
    private button.ButtonIcon b_setting8;
    private button.ButtonNoFillNoStroke b_snack;
    private button.ButtonNoFillNoStroke b_snack2;
    private button.ButtonClear b_total;
    private button.ButtonClear b_total1;
    private button.ButtonClear b_total2;
    private button.ButtonClear b_total3;
    private button.ButtonClear b_total4;
    private button.ButtonClear b_total5;
    private button.ButtonClear b_total6;
    private button.ButtonClear b_total8;
    private button.Button1 button11;
    private button.Button1 button12;
    private button.Button1 button13;
    private button.Button1 button14;
    private button.Button1 button15;
    private button.Button1 button16;
    private button.ButtonClear buttonClear5;
    private button.ButtonIcon buttonIcon1;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke16;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke17;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke18;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke19;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke2;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke20;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke21;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke22;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke23;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke24;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke25;
    private Rectangle.RectangleBorder con1;
    private Rectangle.RectangleBorder con11;
    private Rectangle.RectangleBorder con2;
    private Rectangle.RectangleBorder con3;
    private Rectangle.RectangleBorder con4;
    private Rectangle.RectangleBorder con5;
    private Rectangle.RectangleBorder con6;
    private Rectangle.RectangleBorder con7;
    private CustomFont.LabelText date;
    private CustomFont.LabelText date1;
    private CustomFont.LabelText date2;
    private CustomFont.LabelText date3;
    private CustomFont.LabelText date4;
    private CustomFont.LabelText date5;
    private CustomFont.LabelText date6;
    private CustomFont.LabelText date7;
    private CustomFont.LabelText date8;
    private button.ButtonNoFillNoStroke l_drink;
    private button.ButtonNoFillNoStroke l_ess;
    private button.ButtonNoFillNoStroke l_food;
    private CustomFont.LabelText l_name;
    private CustomFont.LabelText l_name1;
    private CustomFont.LabelText l_name2;
    private CustomFont.LabelText l_name3;
    private CustomFont.LabelText l_name4;
    private CustomFont.LabelText l_name5;
    private CustomFont.LabelText l_name6;
    private CustomFont.LabelText l_name7;
    private CustomFont.LabelText l_name8;
    private button.ButtonNoFillNoStroke l_ot;
    private button.ButtonNoFillNoStroke l_snack;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText11;
    private CustomFont.LabelText labelText12;
    private CustomFont.LabelText labelText13;
    private CustomFont.LabelText labelText14;
    private CustomFont.LabelText labelText15;
    private CustomFont.LabelText labelText16;
    private CustomFont.LabelText labelText17;
    private CustomFont.LabelText labelText18;
    private CustomFont.LabelText labelText19;
    private CustomFont.LabelText labelText20;
    private CustomFont.LabelText labelText21;
    private CustomFont.LabelText labelText22;
    private CustomFont.LabelText labelText23;
    private CustomFont.LabelText labelText24;
    private CustomFont.LabelText labelText25;
    private CustomFont.LabelText labelText26;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText4;
    private CustomFont.LabelText labelText5;
    private CustomFont.LabelText labelText6;
    private CustomFont.LabelText labelText7;
    private CustomFont.LabelText labelText8;
    private Rectangle.Panel mainPanel;
    private Rectangle.Panel mainPanel1;
    private Rectangle.Panel mainPanelExp;
    private Rectangle.Panel panel1;
    private Rectangle.Panel panelMain2;
    private Rectangle.Panel panelMain3;
    private Rectangle.Panel panelMain4;
    private Order.Payment payment2;
    private Rectangle.RectangleBorder rectangleBorder1;
    private Rectangle.RectangleBorder rectangleBorder10;
    private Rectangle.RectangleBorder rectangleBorder11;
    private Rectangle.RectangleBorder1 rectangleBorder12;
    private Rectangle.RectangleBorder rectangleBorder13;
    private Rectangle.RectangleBorder rectangleBorder2;
    private Rectangle.RectangleBorder rectangleBorder3;
    private Rectangle.RectangleBorder rectangleBorder4;
    private Rectangle.RectangleBorder rectangleBorder6;
    private Rectangle.RectangleBorder rectangleBorder7;
    private Rectangle.RectangleBorder rectangleBorder8;
    private Rectangle.RectangleBorder rectangleBorder9;
    private Scroll.ScrollPaneWin11 scrollExp;
    private Scroll.ScrollPaneWin11 scrollPane;
    private Scroll.ScrollPaneWin11 scrollPane1;
    private Scroll.ScrollPaneWin11 scrollPane2;
    private Scroll.ScrollPaneWin11 scrollPane3;
    private Scroll.ScrollPaneWin11 scrollPane4;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    private Scroll.ScrollPaneWin11 scrollPaneWin112;
    private Scroll.ScrollPaneWin11 scrollPaneWin113;
    private CustomFont.LabelText time;
    private CustomFont.LabelText time1;
    private CustomFont.LabelText time2;
    private CustomFont.LabelText time3;
    private CustomFont.LabelText time4;
    private CustomFont.LabelText time5;
    private CustomFont.LabelText time6;
    private CustomFont.LabelText time7;
    private CustomFont.LabelText time8;
    // End of variables declaration//GEN-END:variables
}
