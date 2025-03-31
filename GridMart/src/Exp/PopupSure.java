
package Exp;

import DataProduct.Drinks.StorageDrink;
import DataProduct.Essentials.StorageEss;
import DataProduct.Others.StorageOthers;
import DataProduct.ProcessFood.StorageFood;
import DataProduct.Snack.StorageSnack;
import Main.RunHere;
import java.awt.Cursor;
import java.awt.Window;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;

public class PopupSure extends javax.swing.JPanel {
    
    private String name ;
    private String exp;

    public PopupSure(String name, String exp) {       
        initComponents();
        setOpaque(false);
        this.name = name;
        this.exp = exp;
    }
    
    private void removePanel(String name, String exp) {
        //Drink
        StorageDrink.resetExp(name, exp);
        StorageDrink.saveToFile();
        //Snack
        StorageSnack.resetExp(name, exp);
        StorageSnack.saveToFile();
        //ProcessFood
        StorageFood.resetExp(name, exp);
        StorageFood.saveToFile();
        //Essentials
        StorageEss.resetExp(name, exp);
        StorageEss.saveToFile();
        //Others
        StorageOthers.resetExp(name, exp);
        StorageOthers.saveToFile();
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleSolid1 = new Rectangle.RectangleSolid();
        labelText1 = new CustomFont.LabelText();
        b_yes = new button.Button1();
        b_no = new button.ButtonNoFillNoStroke();

        setPreferredSize(new java.awt.Dimension(430, 239));

        rectangleSolid1.setRadius(55);

        labelText1.setText("Are you sure ?");
        labelText1.setFont(new java.awt.Font("Afacad", 1, 32)); // NOI18N

        b_yes.setText("Yes");
        b_yes.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_yes.setPreferredSize(new java.awt.Dimension(105, 49));
        b_yes.setRadius(45);
        b_yes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_yesMouseEntered(evt);
            }
        });
        b_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_yesActionPerformed(evt);
            }
        });

        b_no.setText("No");
        b_no.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_noMouseEntered(evt);
            }
        });
        b_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleSolid1Layout = new javax.swing.GroupLayout(rectangleSolid1);
        rectangleSolid1.setLayout(rectangleSolid1Layout);
        rectangleSolid1Layout.setHorizontalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                        .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                        .addComponent(b_yes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(b_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        rectangleSolid1Layout.setVerticalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectangleSolid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectangleSolid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void b_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_yesActionPerformed
        removePanel(name, exp);
        GlassPanePopup.closePopupLast();

        RunHere fr = new RunHere();
        fr.setVisible(true);
        Window w = SwingUtilities.getWindowAncestor(b_yes);
        w.dispose();
    }//GEN-LAST:event_b_yesActionPerformed

    private void b_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_noActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_b_noActionPerformed

    private void b_yesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_yesMouseEntered
        b_yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_yesMouseEntered

    private void b_noMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_noMouseEntered
        b_no.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_noMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonNoFillNoStroke b_no;
    private button.Button1 b_yes;
    private CustomFont.LabelText labelText1;
    private Rectangle.RectangleSolid rectangleSolid1;
    // End of variables declaration//GEN-END:variables
}
