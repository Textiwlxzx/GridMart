package MainManagement;

import login.PopupLogout;
import ManageUser.MainUser;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Cursor;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;


public class Mainnnnn extends javax.swing.JFrame {


    public Mainnnnn() {
        initComponents();
        setTitle("GridMart");
        dt();
        times();
        
        GlassPanePopup.install(this);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        MainManagement = new Background.background();
        con2 = new Rectangle.RectangleBorder();
        Order = new button.ButtonClear();
        Expired = new button.ButtonClear();
        Purchased = new button.ButtonClear();
        Prodect = new button.ButtonClear();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        b_total = new button.ButtonClear();
        Employeename = new CustomFont.LabelText();
        b_logout = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        b_setting = new button.ButtonIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setResizable(false);

        MainPanel.setMaximumSize(new java.awt.Dimension(1440, 1024));
        MainPanel.setMinimumSize(new java.awt.Dimension(1440, 1024));
        MainPanel.setLayout(new java.awt.CardLayout());

        MainManagement.setPreferredSize(new java.awt.Dimension(1440, 1024));

        con2.setPreferredSize(new java.awt.Dimension(321, 817));
        con2.setRadius(65);

        Order.setText("Order");
        Order.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Order.setPreferredSize(new java.awt.Dimension(278, 60));
        Order.setRadius(55);
        Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Orderb_orderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderMouseEntered(evt);
            }
        });
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });

        Expired.setText("Expired");
        Expired.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Expired.setPreferredSize(new java.awt.Dimension(278, 60));
        Expired.setRadius(55);
        Expired.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Expiredb_expiredMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpiredMouseEntered(evt);
            }
        });

        Purchased.setText("Purchased");
        Purchased.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Purchased.setPreferredSize(new java.awt.Dimension(278, 60));
        Purchased.setRadius(55);
        Purchased.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Purchasedb_purchasedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PurchasedMouseEntered(evt);
            }
        });

        Prodect.setText("Product");
        Prodect.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Prodect.setPreferredSize(new java.awt.Dimension(278, 60));
        Prodect.setRadius(55);
        Prodect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prodectb_productMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProdectMouseEntered(evt);
            }
        });
        Prodect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout con2Layout = new javax.swing.GroupLayout(con2);
        con2.setLayout(con2Layout);
        con2Layout.setHorizontalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, con2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Prodect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Purchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Expired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        con2Layout.setVerticalGroup(
            con2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(con2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(Prodect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Expired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Purchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        rectangleBorder2.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder2.setRadius(65);

        b_total.setText("Total");
        b_total.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        b_total.setPreferredSize(new java.awt.Dimension(143, 54));
        b_total.setRadius(55);
        b_total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_totalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_totalMouseEntered(evt);
            }
        });
        b_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_totalActionPerformed(evt);
            }
        });

        Employeename.setText("Employee's name");

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
                .addComponent(b_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Employeename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(Employeename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout MainManagementLayout = new javax.swing.GroupLayout(MainManagement);
        MainManagement.setLayout(MainManagementLayout);
        MainManagementLayout.setHorizontalGroup(
            MainManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainManagementLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(MainManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(con2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        MainManagementLayout.setVerticalGroup(
            MainManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainManagementLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(con2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        MainPanel.add(MainManagement, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Orderb_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Orderb_orderMouseClicked
        //handleButtonClick(b_order);
    }//GEN-LAST:event_Orderb_orderMouseClicked

    private void Expiredb_expiredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Expiredb_expiredMouseClicked
        //handleButtonClick(b_expired);
    }//GEN-LAST:event_Expiredb_expiredMouseClicked

    private void Purchasedb_purchasedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Purchasedb_purchasedMouseClicked
        //handleButtonClick(b_purchased);
    }//GEN-LAST:event_Purchasedb_purchasedMouseClicked

    private void Prodectb_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prodectb_productMouseClicked
        //handleButtonClick2(b_product);
    }//GEN-LAST:event_Prodectb_productMouseClicked

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderActionPerformed

    private void b_settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_settingMouseEntered
        b_setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_settingMouseEntered

    private void b_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logoutActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new PopupLogout(), option);
    }//GEN-LAST:event_b_logoutActionPerformed

    private void b_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logoutMouseEntered
        b_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logoutMouseEntered

    private void b_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_totalActionPerformed

    }//GEN-LAST:event_b_totalActionPerformed

    private void b_totalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_totalMouseEntered
        b_total.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_totalMouseEntered

    private void b_totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_totalMouseClicked
        //handleButtonClick(b_total);
    }//GEN-LAST:event_b_totalMouseClicked

    private void ProdectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdectActionPerformed

    private void ProdectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdectMouseEntered
        Prodect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ProdectMouseEntered

    private void OrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseEntered
        Order.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_OrderMouseEntered

    private void ExpiredMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpiredMouseEntered
        Expired.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ExpiredMouseEntered

    private void PurchasedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchasedMouseEntered
        Purchased.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_PurchasedMouseEntered

    private void b_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_settingActionPerformed
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(b_setting);
        window.dispose();
    }//GEN-LAST:event_b_settingActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainnnnn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText Employeename;
    private button.ButtonClear Expired;
    private Background.background MainManagement;
    private javax.swing.JPanel MainPanel;
    private button.ButtonClear Order;
    private button.ButtonClear Prodect;
    private button.ButtonClear Purchased;
    private button.ButtonNoFillNoStroke b_logout;
    private button.ButtonIcon b_setting;
    private button.ButtonClear b_total;
    private Rectangle.RectangleBorder con2;
    private CustomFont.LabelText date;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText5;
    private Rectangle.RectangleBorder rectangleBorder2;
    private CustomFont.LabelText time;
    // End of variables declaration//GEN-END:variables
}
