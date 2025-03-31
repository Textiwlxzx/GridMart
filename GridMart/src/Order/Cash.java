package Order;

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
import StorageOrder.DataOrder;
import StorageOrder.Storage;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;

public class Cash extends javax.swing.JPanel {
    
    public Cash() {
        initComponents();
        setOpaque(false);
        Storage.loadFromFileReceipt();
        int x = 0;
        int lastOrder = Storage.getLastOrderNumber();
        ArrayList<DataOrder> lastOrderData = Storage.getAllDataReceipt().get(lastOrder);

        for (DataOrder d : lastOrderData) {
            x += d.getTotal();
        }

        Total.setText(String.valueOf(x));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectanglepoom1 = new Rectangle.Rectanglepoom();
        labelText1 = new CustomFont.LabelText();
        button11 = new button.Button1();
        Total = new textfield.TextField();
        CashRecieved = new textfield.TextField();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();

        setBackground(new java.awt.Color(255, 255, 255));

        rectanglepoom1.setRadius(55);

        labelText1.setText("Cash");
        labelText1.setFont(new java.awt.Font("Afacad", 1, 36)); // NOI18N

        button11.setBorder(null);
        button11.setForeground(new java.awt.Color(54, 54, 54));
        button11.setText("OK");
        button11.setFont(new java.awt.Font("Afacad", 0, 30)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(92, 50));
        button11.setRadius(55);
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        Total.setBackground(new java.awt.Color(235, 235, 235));
        Total.setEnabled(false);
        Total.setPreferredSize(new java.awt.Dimension(207, 54));
        Total.setShadowColor(new java.awt.Color(255, 255, 255));
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        CashRecieved.setBackground(new java.awt.Color(206, 192, 236));
        CashRecieved.setPreferredSize(new java.awt.Dimension(207, 54));

        labelText2.setText("Total");

        labelText3.setText("Cash Recieved");

        javax.swing.GroupLayout rectanglepoom1Layout = new javax.swing.GroupLayout(rectanglepoom1);
        rectanglepoom1.setLayout(rectanglepoom1Layout);
        rectanglepoom1Layout.setHorizontalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectanglepoom1Layout.createSequentialGroup()
                        .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectanglepoom1Layout.createSequentialGroup()
                        .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CashRecieved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(163, 163, 163))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectanglepoom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        rectanglepoom1Layout.setVerticalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CashRecieved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        int lastOrder = Storage.getLastOrderNumber();
        double total = 0;
        ArrayList<DataOrder> lastOrderData = Storage.getAllDataReceipt().get(lastOrder);

        for (DataOrder d : lastOrderData) {
            d.setCash(Double.parseDouble(CashRecieved.getText()));
            total += d.getTotal();
        }
        
        Storage.saveToFileReceipt();
        
        double cash = lastOrderData.get(0).getCash();
        String formatted = String.format("%04d", lastOrder);
        
        GlassPanePopup.closePopupLast();
        Receipt mainFrame = new Receipt(formatted, total, cash, cash-total);
        mainFrame.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
        
        Storage.loadFromFileReceipt();
        ArrayList<DataOrder> data = Storage.getAllDataReceipt().get(lastOrder);
        
        for (DataOrder d : data) {
            //j.getQuantity()- d.getQuantity()
            StorageDrink.loadFromFile();
            for (Drink j : StorageDrink.getAllDrinks()) {
                if (j.getName().equals(d.getName())){
                    j.setQuantity(j.getQuantity()- d.getQuantity());
                }
            }
            StorageDrink.saveToFile();
            
            StorageSnack.loadFromFile();
            for (Snack j : StorageSnack.getAllSnacks()) {
                if (j.getName().equals(d.getName())){
                    j.setQuantity(j.getQuantity()- d.getQuantity());
                }
            }
            StorageSnack.saveToFile();
            
            StorageFood.loadFromFile();
            for (ProcessFood j : StorageFood.getAll()) {
                if (j.getName().equals(d.getName())){
                    j.setQuantity(j.getQuantity()- d.getQuantity());
                }
            }
            StorageFood.saveToFile();
            
            StorageEss.loadFromFile();
            for (Essentials j : StorageEss.getAll()) {
                if (j.getName().equals(d.getName())){
                    j.setQuantity(j.getQuantity()- d.getQuantity());
                }
            }
            StorageEss.saveToFile();
            
            StorageOthers.loadFromFile();
            for (Others j : StorageOthers.getAll()) {
                if (j.getName().equals(d.getName())){
                    j.setQuantity(j.getQuantity()- d.getQuantity());
                }
            }
            StorageOthers.saveToFile();
        }
               
    }//GEN-LAST:event_button11ActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed

    }//GEN-LAST:event_TotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static textfield.TextField CashRecieved;
    private textfield.TextField Total;
    private button.Button1 button11;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private Rectangle.Rectanglepoom rectanglepoom1;
    // End of variables declaration//GEN-END:variables
}
