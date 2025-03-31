package Total;

import StorageOrder.DataOrder;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import raven.glasspanepopup.GlassPanePopup;

public class Order extends javax.swing.JPanel {
    
    public ArrayList<DataOrder> list;
    public double total;
    public String orderno;
    public String payment;
    public String date ; 

    public Order(String orderno, double total, ArrayList<DataOrder> list, double profit) {
        this.list = list;
        this.total = total;
        this.orderno = orderno;
        initComponents();
        setOpaque(false);
        l_orderno.setText("#"+orderno);
        l_total.setText(String.valueOf(total));
        l_profit.setText(String.valueOf(profit));
        payment = list.get(0).getPayment();
        dt();
    }
    
    public void dt(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(d);
        l_date.setText(dd);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Order = new Rectangle.RectangleOrder();
        l_orderno = new CustomFont.LabelText();
        l_total = new CustomFont.LabelText();
        labelText4 = new CustomFont.LabelText();
        l_date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        l_profit = new CustomFont.LabelText();

        Order.setRadius(55);
        Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderMouseEntered(evt);
            }
        });

        l_orderno.setText("0000");

        l_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_total.setText("0000.0");

        labelText4.setText("Net.");

        l_date.setText("0");

        labelText5.setText("Profit.");

        l_profit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_profit.setText("0000.0");

        javax.swing.GroupLayout OrderLayout = new javax.swing.GroupLayout(Order);
        Order.setLayout(OrderLayout);
        OrderLayout.setHorizontalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        OrderLayout.setVerticalGroup(
            OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_orderno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseClicked
        if (payment.equals("Cash")){
            GlassPanePopup.showPopup(new ReceiptCash(orderno, total, list));
        } else {
            GlassPanePopup.showPopup(new ReceiptQR(orderno, total, list));
        }
    }//GEN-LAST:event_OrderMouseClicked

    private void OrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderMouseEntered
        Order.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_OrderMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Rectangle.RectangleOrder Order;
    private CustomFont.LabelText l_date;
    private CustomFont.LabelText l_orderno;
    private CustomFont.LabelText l_profit;
    private CustomFont.LabelText l_total;
    private CustomFont.LabelText labelText4;
    private CustomFont.LabelText labelText5;
    // End of variables declaration//GEN-END:variables
}
