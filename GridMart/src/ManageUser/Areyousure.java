/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ManageUser;

import ManageUser.MainUser;
import ManageUser.StorageUserPassPo;
import java.awt.Cursor;
import java.awt.Window;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;

public class Areyousure extends javax.swing.JPanel {

    private String usernamee;
    
    public Areyousure(String username) {
        this.usernamee = username;
        initComponents();
        setOpaque(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleSolid1 = new Rectangle.RectangleSolid();
        l_logout = new CustomFont.LabelText();
        b_yes = new button.Button1();
        b_no = new button.ButtonNoFillNoStroke();

        rectangleSolid1.setRadius(55);

        l_logout.setText("Are you sure?");
        l_logout.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N

        b_yes.setForeground(new java.awt.Color(54, 54, 54));
        b_yes.setText("Yes");
        b_yes.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        b_yes.setPreferredSize(new java.awt.Dimension(105, 49));
        b_yes.setRadius(50);
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
                .addGap(103, 103, 103)
                .addComponent(b_yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(b_no, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        rectangleSolid1Layout.setVerticalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(l_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
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
        StorageUserPassPo.removeUsername(usernamee);
        StorageUserPassPo.saveToFile();
        GlassPanePopup.closePopupLast();
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(b_yes);
        window.dispose();
    }//GEN-LAST:event_b_yesActionPerformed

    private void b_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_noActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_b_noActionPerformed

    private void b_noMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_noMouseEntered
        b_no.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_noMouseEntered

    private void b_yesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_yesMouseEntered
        b_yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_yesMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonNoFillNoStroke b_no;
    private button.Button1 b_yes;
    private CustomFont.LabelText l_logout;
    private Rectangle.RectangleSolid rectangleSolid1;
    // End of variables declaration//GEN-END:variables
}
