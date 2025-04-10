
package login;

public class PopupIncorrect extends javax.swing.JPanel {


    public PopupIncorrect() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleSolid1 = new Rectangle.RectangleSolid();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();

        labelText1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/incorrect.png"))); // NOI18N

        labelText2.setForeground(new java.awt.Color(198, 22, 22));
        labelText2.setText("Incorrect");
        labelText2.setFont(new java.awt.Font("Afacad", 1, 34)); // NOI18N

        labelText3.setForeground(new java.awt.Color(198, 22, 22));
        labelText3.setText("Username or Password !");
        labelText3.setFont(new java.awt.Font("Afacad", 1, 32)); // NOI18N

        javax.swing.GroupLayout rectangleSolid1Layout = new javax.swing.GroupLayout(rectangleSolid1);
        rectangleSolid1.setLayout(rectangleSolid1Layout);
        rectangleSolid1Layout.setHorizontalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectangleSolid1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rectangleSolid1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rectangleSolid1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        rectangleSolid1Layout.setVerticalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private Rectangle.RectangleSolid rectangleSolid1;
    // End of variables declaration//GEN-END:variables
}
