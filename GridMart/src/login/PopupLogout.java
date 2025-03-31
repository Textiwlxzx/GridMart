package login;

import ManageUser.LoginLogout;
import ManageUser.StorageLog;
import java.awt.Cursor;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingUtilities;
import raven.glasspanepopup.GlassPanePopup;

public class PopupLogout extends javax.swing.JPanel {

    public String time;
    public String date;
    
    public PopupLogout() {
        initComponents();
        times();
        setOpaque(false);
    }
    
    public void times() {
        Date dt = new Date();
        SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
        time = st.format(dt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleSolid1 = new Rectangle.RectangleSolid();
        l_logout = new CustomFont.LabelText();
        b_yes = new button.Button1();

        rectangleSolid1.setRadius(55);

        l_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_logout.setText("Log out");
        l_logout.setFont(new java.awt.Font("Afacad", 1, 30)); // NOI18N

        b_yes.setBorder(null);
        b_yes.setForeground(new java.awt.Color(54, 54, 54));
        b_yes.setText("Yes");
        b_yes.setFocusPainted(false);
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

        javax.swing.GroupLayout rectangleSolid1Layout = new javax.swing.GroupLayout(rectangleSolid1);
        rectangleSolid1.setLayout(rectangleSolid1Layout);
        rectangleSolid1Layout.setHorizontalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_yes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        rectangleSolid1Layout.setVerticalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(l_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(b_yes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        StorageLog x = new StorageLog();
        x.clearStorage();
        StorageLog.loadFromFile();
        ArrayList<LoginLogout> allLog = StorageLog.getAllLog();
        allLog.get(allLog.size()-1).setLogout(time);
        StorageLog.clearFileLog();
        StorageLog.saveToFile();
        System.out.println("SaveSuccess");
        /*GlassPanePopup.closePopupLast();
        Login fr_login = new Login();
        fr_login.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(b_yes);
        window.dispose();*/
        System.exit(0);
    }//GEN-LAST:event_b_yesActionPerformed

    private void b_yesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_yesMouseEntered
        b_yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_yesMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button1 b_yes;
    private CustomFont.LabelText l_logout;
    private Rectangle.RectangleSolid rectangleSolid1;
    // End of variables declaration//GEN-END:variables
}
