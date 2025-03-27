
package Order;
import Order.Main1.MyPanelContainer;

public class ProductPanel1 extends javax.swing.JPanel {
private MyPanelContainer container;
    public ProductPanel1(MyPanelContainer container) {
        this.container = container; 
        initComponents();
        setOpaque(false);
        
    }

public String getProductName() {
        return labelText1.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangle11 = new Rectangle.Rectangle1();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();

        setPreferredSize(new java.awt.Dimension(287, 288));
        setRequestFocusEnabled(false);

        rectangle11.setRadius(35);
        rectangle11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rectangle11MouseClicked(evt);
            }
        });

        labelText1.setText("Coke");
        labelText1.setPreferredSize(new java.awt.Dimension(152, 32));

        labelText2.setText("description");
        labelText2.setFont(new java.awt.Font("Afacad", 0, 16)); // NOI18N
        labelText2.setPreferredSize(new java.awt.Dimension(103, 20));

        labelText3.setText("left");
        labelText3.setFont(new java.awt.Font("Afacad", 0, 18)); // NOI18N
        labelText3.setMaximumSize(new java.awt.Dimension(2, 24));
        labelText3.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout rectangle11Layout = new javax.swing.GroupLayout(rectangle11);
        rectangle11.setLayout(rectangle11Layout);
        rectangle11Layout.setHorizontalGroup(
            rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangle11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle11Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        rectangle11Layout.setVerticalGroup(
            rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle11Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectangle11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rectangle11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rectangle11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangle11MouseClicked
       String productName = getProductName();
        addProductToOrderList(productName);
       
    }//GEN-LAST:event_rectangle11MouseClicked
// void addProductToOrderList1(String proname){
//   OrderList orderlist = new OrderList(proname);
    
    //container.getNewJPanel2().add(orderlist);
    //newJPanel2.repaint();
    //newJPanel2.revalidate();
//}         
private void addProductToOrderList(String productName) {
    OrderList orderList = new OrderList(productName); // สร้างอ็อบเจ็กต์ OrderList
    orderList.setProductName(productName); // เซ็ตค่าชื่อสินค้า
    
    container.getNewJPanel2().add(orderList); // เพิ่มเข้า Panel
    container.getNewJPanel2().repaint();
    container.getNewJPanel2().revalidate();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private Rectangle.Rectangle1 rectangle11;
    // End of variables declaration//GEN-END:variables

}
