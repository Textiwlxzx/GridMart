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


public class QR extends javax.swing.JPanel {

    public QR() {
        initComponents();
        setOpaque(false);
        Storage.loadFromFileReceipt();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectanglepoom1 = new Rectangle.Rectanglepoom();
        labelText1 = new CustomFont.LabelText();
        jLabel1 = new javax.swing.JLabel();
        button11 = new button.Button1();

        setBackground(new java.awt.Color(255, 255, 255));

        rectanglepoom1.setRadius(55);

        labelText1.setText("QR Code");
        labelText1.setFont(new java.awt.Font("Afacad", 0, 32)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/QR3.png"))); // NOI18N

        button11.setBorder(null);
        button11.setForeground(new java.awt.Color(54, 54, 54));
        button11.setFont(new java.awt.Font("Afacad", 0, 32)); // NOI18N
        button11.setLabel("OK");
        button11.setPreferredSize(new java.awt.Dimension(129, 71));
        button11.setRadius(55);
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectanglepoom1Layout = new javax.swing.GroupLayout(rectanglepoom1);
        rectanglepoom1.setLayout(rectanglepoom1Layout);
        rectanglepoom1Layout.setHorizontalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectanglepoom1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rectanglepoom1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel1))
                    .addGroup(rectanglepoom1Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(295, 295, 295))
        );
        rectanglepoom1Layout.setVerticalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            total += d.getTotal();
        }
        
        Storage.saveToFileReceipt();
        
        String formatted = String.format("%04d", lastOrder);
        
        GlassPanePopup.closePopupLast();
        Receipt mainFrame = new Receipt(formatted,total);
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button1 button11;
    private javax.swing.JLabel jLabel1;
    private CustomFont.LabelText labelText1;
    private Rectangle.Rectanglepoom rectanglepoom1;
    // End of variables declaration//GEN-END:variables
} 
