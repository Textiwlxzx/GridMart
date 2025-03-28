
package Order;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderList extends javax.swing.JPanel {
private String productName;
private JPanel parentPanel;

    public OrderList(String labelText1) {
        initComponents();
        labelText4.setText(labelText1);
        textField2.setText("1");  
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
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new textfield.TextField();
        rectanglepoom1 = new Rectangle.Rectanglepoom();
        labelText4 = new CustomFont.LabelText();
        labelText6 = new CustomFont.LabelText();
        buttonIcon1 = new button.ButtonIcon();
        textField2 = new textfield.TextField();

        textField1.setText("textField1");

        setPreferredSize(new java.awt.Dimension(273, 32));

        rectanglepoom1.setPreferredSize(new java.awt.Dimension(273, 32));

        labelText4.setText("Product Name");

        labelText6.setText("x");

        buttonIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N
        buttonIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonIcon1MouseClicked(evt);
            }
        });
        buttonIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIcon1ActionPerformed(evt);
            }
        });

        textField2.setBackground(new java.awt.Color(239, 239, 239));
        textField2.setPreferredSize(new java.awt.Dimension(38, 38));
        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectanglepoom1Layout = new javax.swing.GroupLayout(rectanglepoom1);
        rectanglepoom1.setLayout(rectanglepoom1Layout);
        rectanglepoom1Layout.setHorizontalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rectanglepoom1Layout.setVerticalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectanglepoom1Layout.createSequentialGroup()
                        .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(rectanglepoom1Layout.createSequentialGroup()
                        .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rectanglepoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIcon1MouseClicked
        parentPanel.remove(this);
        parentPanel.revalidate();
        parentPanel.repaint();
    }//GEN-LAST:event_buttonIcon1MouseClicked

    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
    
    }//GEN-LAST:event_textField2ActionPerformed

    private void buttonIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIcon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIcon1ActionPerformed
public void setParentPanel(JPanel panel) {
        this.parentPanel = panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonIcon buttonIcon1;
    private CustomFont.LabelText labelText4;
    private CustomFont.LabelText labelText6;
    private Rectangle.Rectanglepoom rectanglepoom1;
    private textfield.TextField textField1;
    private textfield.TextField textField2;
    // End of variables declaration//GEN-END:variables
}
