package login;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import raven.glasspanepopup.GlassPanePopup;

public class LogoutMDI extends javax.swing.JFrame {
    
    public String time;
    public String date;
    
    public LogoutMDI() {
        initComponents();
        setTitle("GridMart");
        dt();
        times();
        GlassPanePopup.install(this);
        JInternalFrame internalFrame = new JInternalFrame("Incorrecct", false, false, false, false);
        internalFrame.getContentPane().setBackground(new Color(0, 0, 0, 0));
        internalFrame.add(new PopupLogout());
        internalFrame.setSize(431, 239);
        internalFrame.setLocation(505, 486);
        internalFrame.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame.getUI()).setNorthPane(null); // เอาแถบหัวออก
        internalFrame.setOpaque(false);
        internalFrame.setVisible(true);
        BGLogin.add(internalFrame);
        internalFrame.toFront();
        internalFrame.requestFocus();
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

        BGLogin = new images.BGLogin();
        gridMartThank1 = new images.GridMartThank();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1440, 1024));
        setResizable(false);

        gridMartThank1.setPreferredSize(new java.awt.Dimension(613, 187));

        javax.swing.GroupLayout gridMartThank1Layout = new javax.swing.GroupLayout(gridMartThank1);
        gridMartThank1.setLayout(gridMartThank1Layout);
        gridMartThank1Layout.setHorizontalGroup(
            gridMartThank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        gridMartThank1Layout.setVerticalGroup(
            gridMartThank1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        BGLogin.setLayer(gridMartThank1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout BGLoginLayout = new javax.swing.GroupLayout(BGLogin);
        BGLogin.setLayout(BGLoginLayout);
        BGLoginLayout.setHorizontalGroup(
            BGLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGLoginLayout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(gridMartThank1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(414, 414, 414))
        );
        BGLoginLayout.setVerticalGroup(
            BGLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGLoginLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(gridMartThank1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        FlatLightLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogoutMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private images.BGLogin BGLogin;
    private images.GridMartThank gridMartThank1;
    // End of variables declaration//GEN-END:variables
}
