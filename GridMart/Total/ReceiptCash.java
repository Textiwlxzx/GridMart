package Total;

import ManageUser.StorageLog;
import StorageOrder.DataOrder;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import raven.glasspanepopup.GlassPanePopup;

public class ReceiptCash extends javax.swing.JPanel {
    
    public double change;

    public ReceiptCash(String orderno, double total, ArrayList<DataOrder> list) {
        initComponents();
        dt();
        times();
        l_orderno.setText(String.valueOf(orderno));
        l_total.setText(String.valueOf(total));
        l_cash.setText(String.valueOf(list.get(0).getCash()));
        change = list.get(0).getCash() - total;
        l_change.setText(String.valueOf(change));
        setUsernamee();
        
        for (DataOrder d : list) {
            CashPanel.add(new Cashlist(d.getName(),d.getQuantity()));
        }
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReceiptCash = new Background.background();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        l_name = new CustomFont.LabelText();
        b_logout = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        b_setting = new button.ButtonIcon();
        button11 = new button.Button1();
        Back3 = new button.ButtonClear();
        Receipt = new Rectangle.RectangleBorder();
        Orderno = new CustomFont.LabelText();
        Receiptt = new CustomFont.LabelText();
        Change = new CustomFont.LabelText();
        Cash = new CustomFont.LabelText();
        Total = new CustomFont.LabelText();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        CashPanel = new Rectangle.Panel();
        l_total = new CustomFont.LabelText();
        l_cash = new CustomFont.LabelText();
        l_change = new CustomFont.LabelText();
        l_orderno = new CustomFont.LabelText();

        ReceiptCash.setPreferredSize(new java.awt.Dimension(1440, 1024));

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

        button11.setText("Total");
        button11.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(143, 29));
        button11.setRadius(55);

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

        Back3.setText("Back");
        Back3.setFont(new java.awt.Font("Afacad", 0, 32)); // NOI18N
        Back3.setPreferredSize(new java.awt.Dimension(127, 51));
        Back3.setRadius(55);
        Back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Back3MouseEntered(evt);
            }
        });
        Back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back3ActionPerformed(evt);
            }
        });

        Receipt.setPreferredSize(new java.awt.Dimension(536, 707));

        Orderno.setText("#OrderNo.");

        Receiptt.setText("Receipt");
        Receiptt.setFont(new java.awt.Font("Afacad", 0, 32)); // NOI18N

        Change.setText("Change");

        Cash.setText("Cash");

        Total.setText("Total");
        Total.setFont(new java.awt.Font("Afacad", 0, 32)); // NOI18N

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CashPanel.setFont(new java.awt.Font("Afacad", 0, 12)); // NOI18N
        CashPanel.setPreferredSize(new java.awt.Dimension(534, 1400));
        CashPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        scrollPaneWin111.setViewportView(CashPanel);

        l_total.setText("0000.0");

        l_cash.setText("00.0");

        l_change.setText("00.0");

        l_orderno.setText("0000.0");

        javax.swing.GroupLayout ReceiptLayout = new javax.swing.GroupLayout(Receipt);
        Receipt.setLayout(ReceiptLayout);
        ReceiptLayout.setHorizontalGroup(
            ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceiptLayout.createSequentialGroup()
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceiptLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReceiptLayout.createSequentialGroup()
                                .addComponent(Cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(l_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReceiptLayout.createSequentialGroup()
                                .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(l_change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReceiptLayout.createSequentialGroup()
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReceiptLayout.createSequentialGroup()
                                .addComponent(Orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(l_orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReceiptLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(Receiptt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceiptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        ReceiptLayout.setVerticalGroup(
            ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceiptLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Receiptt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_cash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(ReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout ReceiptCashLayout = new javax.swing.GroupLayout(ReceiptCash);
        ReceiptCash.setLayout(ReceiptCashLayout);
        ReceiptCashLayout.setHorizontalGroup(
            ReceiptCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceiptCashLayout.createSequentialGroup()
                .addGroup(ReceiptCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceiptCashLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(ReceiptCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReceiptCashLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Back3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReceiptCashLayout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ReceiptCashLayout.setVerticalGroup(
            ReceiptCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceiptCashLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(Back3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ReceiptCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ReceiptCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_settingMouseEntered
        b_setting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_settingMouseEntered

    private void b_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logoutActionPerformed
        //GlassPanePopup.showPopup(new PopupLogout());
    }//GEN-LAST:event_b_logoutActionPerformed

    private void b_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_logoutMouseEntered
        b_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_logoutMouseEntered

    private void Back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back3ActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_Back3ActionPerformed

    private void Back3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back3MouseEntered
        Back3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_Back3MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonClear Back3;
    private CustomFont.LabelText Cash;
    private Rectangle.Panel CashPanel;
    private CustomFont.LabelText Change;
    private CustomFont.LabelText Orderno;
    private Rectangle.RectangleBorder Receipt;
    private Background.background ReceiptCash;
    private CustomFont.LabelText Receiptt;
    private CustomFont.LabelText Total;
    private button.ButtonNoFillNoStroke b_logout;
    private button.ButtonIcon b_setting;
    private button.Button1 button11;
    private CustomFont.LabelText date;
    private CustomFont.LabelText l_cash;
    private CustomFont.LabelText l_change;
    private CustomFont.LabelText l_name;
    private CustomFont.LabelText l_orderno;
    private CustomFont.LabelText l_total;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText5;
    private Rectangle.RectangleBorder rectangleBorder2;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    private CustomFont.LabelText time;
    // End of variables declaration//GEN-END:variables
}
