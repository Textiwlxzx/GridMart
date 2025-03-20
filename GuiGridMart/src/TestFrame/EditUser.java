package TestFrame;

import ManageUser.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import raven.glasspanepopup.GlassPanePopup;


public class EditUser extends javax.swing.JPanel {


    public EditUser() {
        initComponents();
        setOpaque(false);
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

        button11 = new button.Button1();
        buttonIcon1 = new button.ButtonIcon();
        passwordField1 = new passwordfield.PasswordField();
        textField1 = new textfield.TextField();
        passwordField2 = new passwordfield.PasswordField();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();
        labelText4 = new CustomFont.LabelText();

        button11.setForeground(new java.awt.Color(0, 0, 0));
        button11.setText("Done");
        button11.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(123, 47));
        button11.setRadius(30);

        buttonIcon1.setText("Cancel");
        buttonIcon1.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonIcon1.setPreferredSize(new java.awt.Dimension(123, 47));
        buttonIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIcon1ActionPerformed(evt);
            }
        });

        passwordField1.setBackground(new java.awt.Color(217, 217, 217));

        textField1.setBackground(new java.awt.Color(217, 217, 217));

        passwordField2.setBackground(new java.awt.Color(217, 217, 217));

        labelText1.setText("Username");

        labelText2.setText("Position");

        labelText3.setText("Edit User");
        labelText3.setFont(new java.awt.Font("Afacad", 0, 34)); // NOI18N

        labelText4.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIcon1ActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_buttonIcon1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button1 button11;
    private button.ButtonIcon buttonIcon1;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText4;
    private passwordfield.PasswordField passwordField1;
    private passwordfield.PasswordField passwordField2;
    private textfield.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
