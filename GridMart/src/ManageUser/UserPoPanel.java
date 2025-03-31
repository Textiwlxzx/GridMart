package ManageUser;

public class UserPoPanel extends javax.swing.JPanel {


    public UserPoPanel(String username,String position) {
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

        setPreferredSize(new java.awt.Dimension(241, 257));

        UserText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserText.setText("Username");

        PositionText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PositionText.setText("Manager");

        javax.swing.GroupLayout logoUser1Layout = new javax.swing.GroupLayout(logoUser1);
        logoUser1.setLayout(logoUser1Layout);
        logoUser1Layout.setHorizontalGroup(
            logoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        logoUser1Layout.setVerticalGroup(
            logoUser1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText PositionText;
    private CustomFont.LabelText UserText;
    private images.LogoUser logoUser1;
    // End of variables declaration//GEN-END:variables
}
