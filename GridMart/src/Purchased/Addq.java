
package Purchased;

import DataProduct.Drinks.StorageDrink;
import DataProduct.Essentials.StorageEss;
import DataProduct.Others.StorageOthers;
import DataProduct.ProcessFood.StorageFood;
import DataProduct.Snack.StorageSnack;
import Main.RunHere;
import java.awt.Cursor;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import raven.glasspanepopup.GlassPanePopup;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Addq extends javax.swing.JPanel {

    public Addq() {
        initComponents();
        setOpaque(false);
        dt();
    }
    
    public void dt(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dd = sdf.format(d);
        t_date.setText(dd);
    }
    
    public void updateProduct(String lot, String name, int q, String exp) {
        if (c_cate.getSelectedItem().toString().equals("Drinks")) {
            StorageDrink.loadFromFile();
            StorageDrink.updateData(lot, name, q, exp);
            StorageDrink.saveToFile();
        }
        else if (c_cate.getSelectedItem().toString().equals("Snack")) {
            StorageSnack.loadFromFile();
            StorageSnack.updateData(lot, name, q, exp);
            StorageSnack.saveToFile();
        }
        else if (c_cate.getSelectedItem().toString().equals("Process food")) {
            StorageFood.loadFromFile();
            StorageFood.updateData(lot, name, q, exp);
            StorageFood.saveToFile();
        }
        else if (c_cate.getSelectedItem().toString().equals("Essentials")) {
            StorageEss.loadFromFile();
            StorageEss.updateData(lot, name, q, exp);
            StorageEss.saveToFile();
        }
        else if (c_cate.getSelectedItem().toString().equals("Others")) {
            StorageOthers.loadFromFile();
            StorageOthers.updateData(lot, name, q, exp);
            StorageOthers.saveToFile();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleSolid1 = new Rectangle.RectangleSolid();
        t_date = new textfield.TextField();
        labelText1 = new CustomFont.LabelText();
        labelText2 = new CustomFont.LabelText();
        labelText3 = new CustomFont.LabelText();
        labelText4 = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        labelText6 = new CustomFont.LabelText();
        t_name = new textfield.TextField();
        t_q = new textfield.TextField();
        t_exp = new textfield.TextField();
        UIManager.put("ComboBox.lightweightKeyboardNavigation", false);
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        c_cate = new ComboBox.ComboBoxSuggestion();
        b_ok = new button.Button1();
        b_cancel = new button.ButtonClear();

        rectangleSolid1.setRadius(55);

        t_date.setBackground(new java.awt.Color(217, 217, 217));
        t_date.setText("dd/MM/yyyy");
        t_date.setFont(new java.awt.Font("Afacad", 1, 18)); // NOI18N
        t_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_dateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_dateFocusLost(evt);
            }
        });

        labelText1.setText("Add Inventory");
        labelText1.setFont(new java.awt.Font("Afacad", 1, 26)); // NOI18N

        labelText2.setText("Date");
        labelText2.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        labelText3.setText("Product's Name");
        labelText3.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        labelText4.setText("Quantity (units)");
        labelText4.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        labelText5.setText("EXP Date");
        labelText5.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        labelText6.setText("Category");
        labelText6.setFont(new java.awt.Font("Afacad", 0, 20)); // NOI18N

        t_name.setBackground(new java.awt.Color(217, 217, 217));
        t_name.setFont(new java.awt.Font("Afacad", 1, 18)); // NOI18N

        t_q.setBackground(new java.awt.Color(217, 217, 217));
        t_q.setFont(new java.awt.Font("Afacad", 1, 18)); // NOI18N

        t_exp.setBackground(new java.awt.Color(217, 217, 217));
        t_exp.setText("dd/MM/yyyy");
        t_exp.setFont(new java.awt.Font("Afacad", 1, 18)); // NOI18N
        t_exp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_expFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_expFocusLost(evt);
            }
        });
        t_exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_expActionPerformed(evt);
            }
        });

        c_cate.setForeground(new java.awt.Color(54, 54, 54));
        c_cate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Drinks", "Snack", "Process food", "Essentials", "Others" }));
        c_cate.setFont(new java.awt.Font("Afacad", 1, 18)); // NOI18N

        b_ok.setText("OK");
        b_ok.setFont(new java.awt.Font("Afacad", 1, 22)); // NOI18N
        b_ok.setPreferredSize(new java.awt.Dimension(103, 44));
        b_ok.setRadius(35);
        b_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_okMouseEntered(evt);
            }
        });
        b_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okActionPerformed(evt);
            }
        });

        b_cancel.setText("Cancel");
        b_cancel.setFont(new java.awt.Font("Afacad", 0, 22)); // NOI18N
        b_cancel.setPreferredSize(new java.awt.Dimension(103, 44));
        b_cancel.setRadius(35);
        b_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_cancelMouseEntered(evt);
            }
        });
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleSolid1Layout = new javax.swing.GroupLayout(rectangleSolid1);
        rectangleSolid1.setLayout(rectangleSolid1Layout);
        rectangleSolid1Layout.setHorizontalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_date, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_q, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleSolid1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(c_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleSolid1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        rectangleSolid1Layout.setVerticalGroup(
            rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleSolid1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelText6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(rectangleSolid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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

    private void b_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_okMouseEntered
        b_ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_okMouseEntered

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
        StoragePurchasedDate.clearFile();
        StoragePurchasedDate.loadFromFile();
        updateProduct(t_date.getText(), t_name.getText(), Integer.parseInt(t_q.getText()), t_exp.getText());
        AddStockData d = new AddStockData(t_date.getText(), t_name.getText(), Integer.parseInt(t_q.getText()));
        StoragePurchasedDate.addItem(d);
        StoragePurchasedDate.saveToFile();
        
        GlassPanePopup.closePopupLast();
        
        RunHere fr = new RunHere();
        fr.setVisible(true);
        Window w = SwingUtilities.getWindowAncestor(b_ok);
        w.dispose();
    }//GEN-LAST:event_b_okActionPerformed

    private void b_cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_cancelMouseEntered
        b_cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_b_cancelMouseEntered

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        GlassPanePopup.closePopupLast();

    }//GEN-LAST:event_b_cancelActionPerformed

    private void t_dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_dateFocusGained
        if (t_date.getText().equals("dd/MM/yyyy")) {
            t_date.setText("");
        }
    }//GEN-LAST:event_t_dateFocusGained

    private void t_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_dateFocusLost
        if (t_date.getText().isEmpty()) {
            t_date.setText("dd/MM/yyyy");
        }
    }//GEN-LAST:event_t_dateFocusLost

    private void t_expFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_expFocusGained
        if (t_exp.getText().equals("dd/MM/yyyy")) {
            t_exp.setText("");
        }
    }//GEN-LAST:event_t_expFocusGained

    private void t_expFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_expFocusLost
        if (t_exp.getText().isEmpty()) {
            t_exp.setText("dd/MM/yyyy");
        }
    }//GEN-LAST:event_t_expFocusLost

    private void t_expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_expActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_expActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonClear b_cancel;
    private button.Button1 b_ok;
    private ComboBox.ComboBoxSuggestion c_cate;
    private CustomFont.LabelText labelText1;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText4;
    private CustomFont.LabelText labelText5;
    private CustomFont.LabelText labelText6;
    private Rectangle.RectangleSolid rectangleSolid1;
    private textfield.TextField t_date;
    private textfield.TextField t_exp;
    private textfield.TextField t_name;
    private textfield.TextField t_q;
    // End of variables declaration//GEN-END:variables
}
