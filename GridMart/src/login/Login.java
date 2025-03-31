package login;

import Main.RunHere;
import ManageUser.LoginLogout;
import ManageUser.StorageLog;
import ManageUser.StorageUserPassPo;
import ManageUser.UserPassPo;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import raven.glasspanepopup.GlassPanePopup;

public class Login extends javax.swing.JFrame {
    
    public String time;
    public String date;
    
    public Login() {
        initComponents();
        setTitle("GridMart");
        dt();
        times();
        GlassPanePopup.install(this);
    }
    
    public void dt() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(d);
    }

    public void times() {
        Date dt = new Date();
        SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
        time = st.format(dt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new Background.backgroundlogin();
        logoIcon1 = new images.LogoIcon();
        rectangle1 = new Rectangle.Rectangle();
        t_user = new textfield.TextField();
        b_login = new button.Button1();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        t_pass = new passwordfield.PasswordField();
        logoName1 = new images.LogoName();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1440, 1024));
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setResizable(false);

        Login.setPreferredSize(new java.awt.Dimension(1440, 1024));

        logoIcon1.setPreferredSize(new java.awt.Dimension(414, 427));

        javax.swing.GroupLayout logoIcon1Layout = new javax.swing.GroupLayout(logoIcon1);
        logoIcon1.setLayout(logoIcon1Layout);
        logoIcon1Layout.setHorizontalGroup(
            logoIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        logoIcon1Layout.setVerticalGroup(
            logoIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        rectangle1.setPreferredSize(new java.awt.Dimension(536, 487));
        rectangle1.setRadius(110);

        t_user.setFont(new java.awt.Font("Afacad", 0, 22)); // NOI18N
        t_user.setPreferredSize(new java.awt.Dimension(407, 78));
        t_user.setRound(65);

        b_login.setForeground(new java.awt.Color(54, 54, 54));
        b_login.setText("Login");
        b_login.setFont(new java.awt.Font("Afacad", 1, 32)); // NOI18N
        b_login.setPreferredSize(new java.awt.Dimension(407, 78));
        b_login.setRadius(70);
        b_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_loginMouseEntered(evt);
            }
        });
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });

        labelText1.setText("Username");

        labelText2.setText("Password");

        t_pass.setFont(new java.awt.Font("Afacad", 0, 22)); // NOI18N
        t_pass.setPreferredSize(new java.awt.Dimension(407, 78));
        t_pass.setRound(65);
        t_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_passActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangle1Layout = new javax.swing.GroupLayout(rectangle1);
        rectangle1.setLayout(rectangle1Layout);
        rectangle1Layout.setHorizontalGroup(
            rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangle1Layout.createSequentialGroup()
                .addGroup(rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectangle1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rectangle1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(rectangle1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        rectangle1Layout.setVerticalGroup(
            rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangle1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        logoName1.setPreferredSize(new java.awt.Dimension(379, 74));

        javax.swing.GroupLayout logoName1Layout = new javax.swing.GroupLayout(logoName1);
        logoName1.setLayout(logoName1Layout);
        logoName1Layout.setHorizontalGroup(
            logoName1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );
        logoName1Layout.setVerticalGroup(
            logoName1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(logoIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(logoName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
        PopupIncorrect p = new PopupIncorrect();
        StorageUserPassPo.loadFromFile();
        ArrayList<UserPassPo> storage = (ArrayList<UserPassPo>) StorageUserPassPo.getAllUserPass();
        String username = t_user.getText();
        char[] passwordd = t_pass.getPassword();
        for (int i = 0; i < storage.size() ; i++){
            if (username.equals(storage.get(i).getUsername()) && new String(passwordd).equals(storage.get(i).getPassword())) {
                StorageLog x = new StorageLog();
                x.clearStorage();

                StorageLog.loadFromFile();
                StorageLog.addLog(new LoginLogout(date,storage.get(i).getUsername(),time));
                StorageLog.saveToFile();
                this.setVisible(false);
                RunHere fr = new RunHere();
                fr.setVisible(true);
                dispose();
                break;
            }
            else if (i == storage.size()-1){
                JDialog dialog = new JDialog(this, "", true);
                dialog.setSize(460, 300);
                dialog.setLocationRelativeTo(this);
                dialog.setContentPane(p);
                dialog.setVisible(true);
                t_user.setText("");
                t_pass.setText("");
            }
        }
    }//GEN-LAST:event_b_loginActionPerformed

    private void t_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passActionPerformed

    private void b_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_loginMouseEntered
        b_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_loginMouseEntered

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Background.backgroundlogin Login;
    private button.Button1 b_login;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private images.LogoIcon logoIcon1;
    private images.LogoName logoName1;
    private Rectangle.Rectangle rectangle1;
    private passwordfield.PasswordField t_pass;
    private textfield.TextField t_user;
    // End of variables declaration//GEN-END:variables
}
