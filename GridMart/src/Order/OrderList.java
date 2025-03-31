
package Order;

import CustomFont.LabelText;
import Main.RunHere;
import StorageOrder.DataOrder;
import StorageOrder.Storage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import textfield.TextField;

public class OrderList extends javax.swing.JPanel {

    private String productName;
    private JPanel parentPanel;
    
    
    public OrderList() {
        initComponents();
        Quantity.setText("1");
    }

    public OrderList(String name, double price) {
        initComponents();
        this.productName = name;
        ProductName.setText(name);
        Quantity.setText("1");
        Storage.addItem(new DataOrder(name,price,0,0,0," "));
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
        updateUI();
    }
     
    @Override
    public void updateUI() {
        this.removeAll();
        this.add(new JLabel(productName));
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255,255,255));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 80, 80));
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    public LabelText getProductName() {
        return ProductName;
    }

    public TextField getTextField2() {
        return Quantity;
    }

    public void setParentPanel(JPanel panel) {
        this.parentPanel = panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new textfield.TextField();
        rectanglepoom1 = new Rectangle.Rectanglepoom();
        ProductName = new CustomFont.LabelText();
        labelText6 = new CustomFont.LabelText();
        Bin = new button.ButtonIcon();
        Quantity = new textfield.TextField();

        textField1.setText("textField1");

        setPreferredSize(new java.awt.Dimension(273, 32));

        rectanglepoom1.setPreferredSize(new java.awt.Dimension(273, 32));

        ProductName.setText("Product Name");

        labelText6.setText("x");

        Bin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N
        Bin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BinMouseEntered(evt);
            }
        });
        Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BinActionPerformed(evt);
            }
        });

        Quantity.setBackground(new java.awt.Color(239, 239, 239));
        Quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Quantity.setPreferredSize(new java.awt.Dimension(40, 40));
        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectanglepoom1Layout = new javax.swing.GroupLayout(rectanglepoom1);
        rectanglepoom1.setLayout(rectanglepoom1Layout);
        rectanglepoom1Layout.setHorizontalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rectanglepoom1Layout.setVerticalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
    
    }//GEN-LAST:event_QuantityActionPerformed

    private void BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BinActionPerformed
        JPanel parentPanel = (JPanel) Bin.getParent();
        setParentPanel(parentPanel);
        RunHere.removeOrder(this);
        Storage.removeByName(productName);
        Storage.saveToFile();
    }//GEN-LAST:event_BinActionPerformed

    private void BinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BinMouseEntered
        Bin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_BinMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonIcon Bin;
    private CustomFont.LabelText ProductName;
    private textfield.TextField Quantity;
    private CustomFont.LabelText labelText6;
    private Rectangle.Rectanglepoom rectanglepoom1;
    private textfield.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
