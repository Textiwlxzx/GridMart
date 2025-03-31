package ManageUser;

import MainManagement.Mainnnnn;
import ManageUser.MainUser;
import ManageUser.StorageUserPassPo;
import ManageUser.StorageUserPassPo;
import ManageUser.UserPassPo;
import ManageUser.UserPassPo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import raven.glasspanepopup.GlassPanePopup;


public class AddUser extends javax.swing.JPanel {
       
    public AddUser() {
        initComponents();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255,255,255));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 55, 55));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Done = new button.Button1();
        Cancel = new button.ButtonIcon();
        t_password = new passwordfield.PasswordField();
        t_username = new textfield.TextField();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();
        labelText4 = new CustomFont.LabelText();
        UIManager.put("ComboBox.lightweightKeyboardNavigation", false);
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        t_position = new ComboBox.ComboBoxSuggestion();

        Done.setForeground(new java.awt.Color(0, 0, 0));
        Done.setText("Done");
        Done.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        Done.setPreferredSize(new java.awt.Dimension(123, 47));
        Done.setRadius(30);
        Done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DoneMouseEntered(evt);
            }
        });
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        Cancel.setPreferredSize(new java.awt.Dimension(123, 47));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelMouseEntered(evt);
            }
        });
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        t_password.setBackground(new java.awt.Color(217, 217, 217));
        t_password.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N
        t_password.setMinimumSize(new java.awt.Dimension(24, 57));

        t_username.setBackground(new java.awt.Color(217, 217, 217));
        t_username.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        labelText1.setText("Username");

        labelText2.setText("Position");

        labelText3.setText("Add Username");
        labelText3.setFont(new java.awt.Font("Afacad", 0, 34)); // NOI18N

        labelText4.setText("Password");

        t_position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Employee" }));
        t_position.setToolTipText("");
        t_position.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N
        t_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_positionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_username, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(t_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_position, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(Done, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Done, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        GlassPanePopup.closePopupLast();
    }//GEN-LAST:event_CancelActionPerformed

    private void DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneActionPerformed
        UserPassPo UserAdd = new UserPassPo(t_username.getText(),t_password.getText(),t_position.getSelectedItem().toString());
        StorageUserPassPo.addUserPassPo(UserAdd);
        StorageUserPassPo.saveToFile();
        GlassPanePopup.closePopupLast();
        MainUser newFrame = new MainUser();
        newFrame.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(Done);
        window.dispose();
    }//GEN-LAST:event_DoneActionPerformed

    private void t_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_positionActionPerformed

    private void CancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseEntered
        Cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_CancelMouseEntered

    private void DoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoneMouseEntered
        Done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_DoneMouseEntered

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonIcon Cancel;
    public button.Button1 Done;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText4;
    private passwordfield.PasswordField t_password;
    private ComboBox.ComboBoxSuggestion t_position;
    private textfield.TextField t_username;
    // End of variables declaration//GEN-END:variables
}
