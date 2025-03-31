
package Order;

import Main.RunHere;
import StorageOrder.Storage;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ProductOrder extends javax.swing.JPanel {

    private String name;
    private String des;
    private Double price;
    private int quantity;
    private String path;
    
    public ProductOrder(String name, String des, Double price, int quantity, String path) {
        initComponents();
        setOpaque(false);
        this.name = name;
        this.des = des;
        this.price = price;
        this.quantity = quantity;
        this.path = path;

        l_name.setText(name);
        l_des.setText(des);
        l_quantity.setText(String.valueOf(quantity));
        l_image.setIcon(displayImage(path));
        l_image.setText("");
    }

    private ImageIcon displayImage(String imagePath){
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));
            ImageIcon imageIcon = new ImageIcon(img);
            return imageIcon;
        } catch (IOException e){
            e.printStackTrace();
        } return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangle11 = new Rectangle.Rectangle1();
        l_name = new CustomFont.LabelText();
        l_des = new CustomFont.LabelText();
        left = new CustomFont.LabelText();
        l_image = new CustomFont.LabelText();
        l_quantity = new CustomFont.LabelText();

        setPreferredSize(new java.awt.Dimension(287, 288));
        setRequestFocusEnabled(false);

        rectangle11.setRadius(35);
        rectangle11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rectangle11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rectangle11MouseEntered(evt);
            }
        });

        l_name.setText("ProductName");
        l_name.setPreferredSize(new java.awt.Dimension(152, 32));

        l_des.setText("Description");
        l_des.setFont(new java.awt.Font("Afacad", 0, 16)); // NOI18N
        l_des.setPreferredSize(new java.awt.Dimension(103, 20));

        left.setText("left");
        left.setFont(new java.awt.Font("Afacad", 0, 18)); // NOI18N
        left.setMaximumSize(new java.awt.Dimension(2, 24));

        l_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_image.setText("image");
        l_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_imageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_imageMouseEntered(evt);
            }
        });

        l_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_quantity.setText("0");
        l_quantity.setFont(new java.awt.Font("Afacad", 0, 18)); // NOI18N
        l_quantity.setMaximumSize(new java.awt.Dimension(2, 24));

        javax.swing.GroupLayout rectangle11Layout = new javax.swing.GroupLayout(rectangle11);
        rectangle11.setLayout(rectangle11Layout);
        rectangle11Layout.setHorizontalGroup(
            rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangle11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectangle11Layout.createSequentialGroup()
                        .addGroup(rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle11Layout.createSequentialGroup()
                        .addGroup(rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_image, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rectangle11Layout.createSequentialGroup()
                                .addComponent(l_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );
        rectangle11Layout.setVerticalGroup(
            rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(l_image, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(rectangle11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        System.out.println(name + "-" +price);
        RunHere.addOrder(name,price);
        Storage.saveToFile();
    }//GEN-LAST:event_rectangle11MouseClicked

    private void l_imageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_imageMouseEntered
        l_image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_l_imageMouseEntered

    private void rectangle11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangle11MouseEntered
        rectangle11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_rectangle11MouseEntered

    private void l_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_imageMouseClicked
        System.out.println(name + "-" +price);
        RunHere.addOrder(name,price);
        Storage.saveToFile();
    }//GEN-LAST:event_l_imageMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomFont.LabelText l_des;
    private CustomFont.LabelText l_image;
    private CustomFont.LabelText l_name;
    private CustomFont.LabelText l_quantity;
    private CustomFont.LabelText left;
    private Rectangle.Rectangle1 rectangle11;
    // End of variables declaration//GEN-END:variables

}
