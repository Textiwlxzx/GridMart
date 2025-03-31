package ManageUser;

import login.PopupLogout;
import java.awt.Cursor;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;

public class UserPoEditPanel extends javax.swing.JPanel {

    private String usernamee;
    
    public UserPoEditPanel(String username,String position) {
        this.usernamee = username;
        initComponents();
        setOpaque(false);
        UserText.setText(username);
        PositionText.setText(position);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserText = new CustomFont.LabelText();
        PositionText = new CustomFont.LabelText();
        logoUser1 = new images.LogoUser();
        EditIcon = new button.ButtonIcon();

        setPreferredSize(new java.awt.Dimension(241, 257));

        UserText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserText.setText("Username");

        PositionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PositionText.setText("Manager");

        EditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Edit.png"))); // NOI18N
        EditIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditIconMouseEntered(evt);
            }
        });
        EditIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditIconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logoUser1Layout = new javax.swing.GroupLayout(logoUser1);
        logoUser1.setLayout(logoUser1Layout);
        logoUser1Layout.setHorizontalGroup(
            logoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoUser1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        logoUser1Layout.setVerticalGroup(
            logoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EditIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
            .addComponent(PositionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(UserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PositionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EditIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditIconActionPerformed
        Option option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return false;
            }
        };
        GlassPanePopup.showPopup(new EditUser(usernamee), option);
    }//GEN-LAST:event_EditIconActionPerformed

    private void EditIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditIconMouseEntered
        EditIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_EditIconMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonIcon EditIcon;
    private CustomFont.LabelText PositionText;
    private CustomFont.LabelText UserText;
    private images.LogoUser logoUser1;
    // End of variables declaration//GEN-END:variables
}
