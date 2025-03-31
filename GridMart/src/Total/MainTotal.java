package Total;

import DataProduct.Drinks.Drink;
import DataProduct.Drinks.StorageDrink;
import DataProduct.Essentials.Essentials;
import DataProduct.Essentials.StorageEss;
import DataProduct.Others.Others;
import DataProduct.Others.StorageOthers;
import DataProduct.ProcessFood.ProcessFood;
import DataProduct.ProcessFood.StorageFood;
import DataProduct.Snack.Snack;
import DataProduct.Snack.StorageSnack;
import Main.RunHere;
import ManageUser.MainUser;
import ManageUser.StorageLog;
import StorageOrder.DataOrder;
import StorageOrder.Storage;
import java.awt.Cursor;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingUtilities;
import login.LogoutMDI;
import login.PopupLogout;
import raven.glasspanepopup.GlassPanePopup;


public class MainTotal extends javax.swing.JFrame {

    private double total ;
    private double net = 0;
    private double profit ;
    private double profitperorder ;
    
    public MainTotal() {
        initComponents();
        dt();
        times();
        setTitle("GridMart");
        setUsernamee();
        GlassPanePopup.install(this);
        
        Storage.loadFromFileReceipt();
        int x = Storage.getAllDataReceipt().size();
        for (int i=1; i <=x; i++){
            
            profitperorder = 0;
            net = 0;
            ArrayList<DataOrder> orders = Storage.getAllDataReceipt().get(i);

            for (DataOrder d : orders) {
                net += d.getTotal();
                total += d.getTotal();
                
                profit += addProfit(d.getQuantity(),d.getName());
                profitperorder += addProfit(d.getQuantity(),d.getName());
            }

            String formatted = String.format("%04d", i);
            TotalOrder.add(new Order(formatted,net,orders,profitperorder));
        }
        l_total.setText(String.valueOf(total));
        l_profit.setText(String.valueOf(profit));
        scrollPaneWin111.revalidate();
        scrollPaneWin111.repaint();
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


    private void setUsernamee() {
        String x ;
        StorageLog.loadFromFile();
        x = StorageLog.getAllLog().get(StorageLog.getAllLog().size()-1).getName();
        l_name.setText(x);
    }
    
    public double addProfit(int quan , String name){
        int x = 0;
        StorageDrink.loadFromFile();
        ArrayList<Drink> datadrink = StorageDrink.getAllDrinks();
        //Drink
        for (Drink d : datadrink) {
            if (d.getName().equals(name)){
                //x += (d.getPrice() * quan) - (d.getCost()*quan);
                x += Profit.calProfitPerProduct(d,quan);
            }
        }
        StorageDrink.saveToFile();
        
        //Snack
        StorageSnack.loadFromFile();
        ArrayList<Snack> datasnack = StorageSnack.getAllSnacks();
        for (Snack d : datasnack) {
            if (d.getName().equals(name)){
               // x += (d.getPrice() * quan) - (d.getCost()*quan);
                x += Profit.calProfitPerProduct(d,quan);
            }
        }
        StorageSnack.saveToFile();
        
        //Process Food
        StorageFood.loadFromFile();
        ArrayList<ProcessFood> datafood = StorageFood.getAll();        
        for (ProcessFood d : datafood) {
            if (d.getName().equals(name)){
                //x += (d.getPrice() * quan) - (d.getCost()*quan);
                x += Profit.calProfitPerProduct(d,quan);
            }
        }
        StorageFood.saveToFile();
        
        //Essential
        StorageEss.loadFromFile();
        ArrayList<Essentials> dataess = StorageEss.getAll();
        for (Essentials d : dataess) {
            if (d.getName().equals(name)){
                //x += (d.getPrice() * quan) - (d.getCost()*quan);
                x += Profit.calProfitPerProduct(d,quan);
            }
        }
        StorageEss.saveToFile();
        
        //Other
        StorageOthers.loadFromFile();
        ArrayList<Others> dataothers = StorageOthers.getAll();
        for (Others d : dataothers) {
            if (d.getName().equals(name)){
                //x += (d.getPrice() * quan) - (d.getCost()*quan);
                x += Profit.calProfitPerProduct(d,quan);
            }
        }
        StorageOthers.saveToFile();
        return x;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Main1 = new Background.background();
        con2 = new Rectangle.RectangleBorder();
        b_order1 = new button.ButtonClear();
        b_expired1 = new button.ButtonClear();
        b_purchased1 = new button.ButtonClear();
        b_product1 = new button.ButtonClear();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        l_name = new CustomFont.LabelText();
        b_logout = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        b_setting = new button.ButtonIcon();
        button11 = new button.Button1();
        rectangleBorder1 = new Rectangle.RectangleBorder();
        l_total = new CustomFont.LabelText();
        labelText20 = new CustomFont.LabelText();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        TotalOrder = new Rectangle.Panel();
        labelText21 = new CustomFont.LabelText();
        l_profit = new CustomFont.LabelText();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setLayout(new java.awt.CardLayout());

        Main1.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con2.setPreferredSize(new java.awt.Dimension(321, 817));
        con2.setRadius(65);

        b_order1.setText("Order");
        b_order1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_order1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_order1.setRadius(55);
        b_order1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_order1b_orderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_order1b_orderMouseEntered(evt);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_expired1b_expiredMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_expired1b_expiredMouseEntered(evt);
            }
        });

        b_purchased1.setText("Purchased");
        b_purchased1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_purchased1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_purchased1.setRadius(55);
        b_purchased1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_purchased1b_purchasedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_purchased1b_purchasedMouseEntered(evt);
            }
        });

        b_product1.setText("Product");
        b_product1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_product1.setPreferredSize(new java.awt.Dimension(278, 60));
        b_product1.setRadius(55);
        b_product1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_product1b_productMouseEntered(evt);
            }
        });
        b_product1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_product1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con2Layout = new javax.swing.GroupLayout(con2);
        con2.setLayout(con2Layout);
        con2Layout.setHorizontalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_purchased1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_expired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_order1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con2Layout.setVerticalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(b_product1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_order1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_expired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(b_purchased1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );

        rectangleBorder2.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder2.setRadius(65);

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

        button11.setText("Total");
        button11.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(143, 29));
        button11.setRadius(55);
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        rectangleBorder1.setRadius(65);

        l_total.setText("0000.0");
        l_total.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N

        labelText20.setText("Total");
        labelText20.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        TotalOrder.setPreferredSize(new java.awt.Dimension(986, 1400));
        TotalOrder.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 20));
        scrollPaneWin111.setViewportView(TotalOrder);

        labelText21.setText("Profit");
        labelText21.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N

        l_profit.setText("0000.0");
        l_profit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N

        javax.swing.GroupLayout rectangleBorder1Layout = new javax.swing.GroupLayout(rectangleBorder1);
        rectangleBorder1.setLayout(rectangleBorder1Layout);
        rectangleBorder1Layout.setHorizontalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelText21, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(labelText20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        rectangleBorder1Layout.setVerticalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Main1Layout = new javax.swing.GroupLayout(Main1);
        Main1.setLayout(Main1Layout);
        Main1Layout.setHorizontalGroup(
            Main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(Main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Main1Layout.createSequentialGroup()
                        .addComponent(con2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(rectangleBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        Main1Layout.setVerticalGroup(
            Main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(Main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(con2, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                    .addComponent(rectangleBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        MainPanel.add(Main1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_order1b_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order1b_orderMouseClicked
        //handleButtonClick(b_order);
    }//GEN-LAST:event_b_order1b_orderMouseClicked

    private void b_order1b_orderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_order1b_orderMouseEntered

    }//GEN-LAST:event_b_order1b_orderMouseEntered

    private void b_expired1b_expiredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired1b_expiredMouseClicked
        //handleButtonClick(b_expired);
    }//GEN-LAST:event_b_expired1b_expiredMouseClicked

    private void b_expired1b_expiredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_expired1b_expiredMouseEntered

    }//GEN-LAST:event_b_expired1b_expiredMouseEntered

    private void b_product1b_productMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_product1b_productMouseEntered
        b_product1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_product1b_productMouseEntered

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

    private void b_product1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_product1ActionPerformed
        RunHere newFrame = new RunHere();
        newFrame.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(b_product1);
        window.dispose();
    }//GEN-LAST:event_b_product1ActionPerformed

    private void b_order1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_order1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_order1ActionPerformed

    private void b_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_settingActionPerformed
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_b_settingActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button11ActionPerformed

    private void b_purchased1b_purchasedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased1b_purchasedMouseEntered

    }//GEN-LAST:event_b_purchased1b_purchasedMouseEntered

    private void b_purchased1b_purchasedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_purchased1b_purchasedMouseClicked
        //handleButtonClick(b_purchased);
    }//GEN-LAST:event_b_purchased1b_purchasedMouseClicked
        
    
    
    /*private void addMenuPanel(MenuItem item) {
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(item, BorderLayout.CENTER); 
        menuPanel.revalidate();
        menuPanel.repaint();
    }
    
    private ButtonClear current;
    
    private void handleButtonClick(ButtonClear b) {
        if (current == b) {
            b.setRadius(55);
            b.setBackground(new Color(0, 0, 0, 0));
            b.setBorderColor(new Color(0, 0, 0));
            b.setForeground(new Color(54, 54, 54));
            menuPanel.removeAll();
            menuPanel.revalidate();
            menuPanel.repaint();
            current = null;
        }
        else {
            if (current != null) {
                current.setRadius(55);
                current.setBackground(new Color(0, 0, 0, 0));
                current.setBorderColor(new Color(0, 0, 0));
                current.setForeground(new Color(54, 54, 54));
                menuPanel.removeAll();
                menuPanel.revalidate();
                menuPanel.repaint();
            }
            b.setRadius(55);
            b.setBackground(new Color(206, 192, 236));
            b.setBorderColor(new Color(206, 192, 236));
            b.setForeground(new Color(255, 255, 255));
            current = b;
        }
            
    }
    private void handleButtonClick2(ButtonClear b) {
        MenuItem item = new MenuItem();
        if (current == b) {
            b.setRadius(55);
            b.setBackground(new Color(0, 0, 0, 0));
            b.setBorderColor(new Color(0, 0, 0));
            b.setForeground(new Color(54, 54, 54));
            menuPanel.removeAll();
            menuPanel.revalidate();
            menuPanel.repaint();
            current = null;
        }
        else {
            if (current != null) {
                current.setRadius(55);
                current.setBackground(new Color(0, 0, 0, 0));
                current.setBorderColor(new Color(0, 0, 0));
                current.setForeground(new Color(54, 54, 54));
                menuPanel.removeAll();
                menuPanel.revalidate();
                menuPanel.repaint();
            }
            b.setRadius(55);
            b.setBackground(new Color(206, 192, 236));
            b.setBorderColor(new Color(206, 192, 236));
            b.setForeground(new Color(255, 255, 255));
            addMenuPanel(item);
            current = b;
        } 
    }*/
    
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
            java.util.logging.Logger.getLogger(MainTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainTotal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Background.background Main1;
    private javax.swing.JPanel MainPanel;
    private Rectangle.Panel TotalOrder;
    private button.ButtonClear b_expired1;
    private button.ButtonNoFillNoStroke b_logout;
    private button.ButtonClear b_order1;
    private button.ButtonClear b_product1;
    private button.ButtonClear b_purchased1;
    private button.ButtonIcon b_setting;
    private button.Button1 button11;
    private Rectangle.RectangleBorder con2;
    private CustomFont.LabelText date;
    private CustomFont.LabelText l_name;
    private CustomFont.LabelText l_profit;
    private CustomFont.LabelText l_total;
    private CustomFont.LabelText labelText20;
    private CustomFont.LabelText labelText21;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText5;
    private Rectangle.RectangleBorder rectangleBorder1;
    private Rectangle.RectangleBorder rectangleBorder2;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    private CustomFont.LabelText time;
    // End of variables declaration//GEN-END:variables

}
