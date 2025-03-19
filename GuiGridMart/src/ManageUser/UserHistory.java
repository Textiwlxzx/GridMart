package ManageUser;

import com.formdev.flatlaf.FlatLightLaf;
import raven.glasspanepopup.GlassPanePopup;

public class UserHistory extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public UserHistory() {
        initComponents();
        GlassPanePopup.install(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgrounduser1 = new Background.backgrounduser();
        Iconuser = new javax.swing.JLabel();
        Add = new button.ButtonClear();
        Edit = new button.ButtonClear();
        Back = new button.Button1();
        History = new button.Button1();
        User = new CustomFont.LabelText();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Iconuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N

        Add.setText("Add");
        Add.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Add.setPreferredSize(new java.awt.Dimension(130, 50));
        Add.setRadius(55);
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Edit.setPreferredSize(new java.awt.Dimension(130, 50));
        Edit.setRadius(55);
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Back.setForeground(new java.awt.Color(54, 54, 54));
        Back.setText("Back");
        Back.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        Back.setPreferredSize(new java.awt.Dimension(130, 50));
        Back.setRadius(50);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        History.setText("History");
        History.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        History.setPreferredSize(new java.awt.Dimension(130, 50));
        History.setRadius(50);

        User.setText("User");
        User.setFont(new java.awt.Font("Afacad", 0, 65)); // NOI18N

        javax.swing.GroupLayout backgrounduser1Layout = new javax.swing.GroupLayout(backgrounduser1);
        backgrounduser1.setLayout(backgrounduser1Layout);
        backgrounduser1Layout.setHorizontalGroup(
            backgrounduser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgrounduser1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(Iconuser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(backgrounduser1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgrounduser1Layout.setVerticalGroup(
            backgrounduser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgrounduser1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(backgrounduser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgrounduser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Iconuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 856, Short.MAX_VALUE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgrounduser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgrounduser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        UserAddUser newFrame = new UserAddUser();
        newFrame.setVisible(true);
        GlassPanePopup.showPopup(new AddUser());
        dispose();
    }//GEN-LAST:event_AddActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        UserEdit newFrame = new UserEdit();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_EditActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        UserMain newFrame = new UserMain();
        newFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatLightLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonClear Add;
    private button.Button1 Back;
    private button.ButtonClear Edit;
    private button.Button1 History;
    private javax.swing.JLabel Iconuser;
    private CustomFont.LabelText User;
    private Background.backgrounduser backgrounduser1;
    // End of variables declaration//GEN-END:variables
}
