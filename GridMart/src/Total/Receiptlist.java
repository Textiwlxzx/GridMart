package Total;

public class Receiptlist extends javax.swing.JPanel {
    
    public Receiptlist() {
        initComponents();
    }
    
    public Receiptlist(String name, int quantity) {
        initComponents();
        setOpaque(false);
        l_name.setText(name);
        l_quantity.setText(String.valueOf(quantity));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectanglepoom1 = new Rectangle.Rectanglepoom();
        l_name = new CustomFont.LabelText();
        l_quantity = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();

        l_name.setText("name");

        l_quantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        l_quantity.setText("1");

        labelText3.setText("x");

        javax.swing.GroupLayout rectanglepoom1Layout = new javax.swing.GroupLayout(rectanglepoom1);
        rectanglepoom1.setLayout(rectanglepoom1Layout);
        rectanglepoom1Layout.setHorizontalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        rectanglepoom1Layout.setVerticalGroup(
            rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectanglepoom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText l_name;
    private CustomFont.LabelText l_quantity;
    private CustomFont.LabelText labelText3;
    private Rectangle.Rectanglepoom rectanglepoom1;
    // End of variables declaration//GEN-END:variables
}
