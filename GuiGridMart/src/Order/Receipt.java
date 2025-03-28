
package Order;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Receipt extends javax.swing.JFrame {

    
    public Receipt() {
        initComponents();
        dt();
        times();
    }
    
    public void dt() {
        
        Date d = new Date();
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
        String dd = sdf.format(d);
        date.setText(dd);
    }

    Timer t;
    SimpleDateFormat st;

    public void times() {
    
        t = new Timer(0, new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
            
            
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
            
                String tt = st.format(dt);
                time.setText(tt);
        
            }
        }); {
    
        t.start(); 
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

        background1 = new Background.background();
        rectangleBorder1 = new Rectangle.RectangleBorder();
        buttonClear2 = new button.ButtonClear();
        buttonClear3 = new button.ButtonClear();
        buttonClear4 = new button.ButtonClear();
        button11 = new button.Button1();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        buttonClear5 = new button.ButtonClear();
        labelText2 = new CustomFont.LabelText();
        buttonNoFillNoStroke2 = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        buttonIcon1 = new button.ButtonIcon();
        rectanglepoom2 = new Rectangle.Rectanglepoom();
        buttonClear6 = new button.ButtonClear();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonClear7 = new button.ButtonClear();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        newJPanel1 = new Rectangle.NewJPanel();
        receiptlist3 = new Order.Receiptlist();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background1.setPreferredSize(new java.awt.Dimension(1440, 1024));

        rectangleBorder1.setPreferredSize(new java.awt.Dimension(321, 792));
        rectangleBorder1.setRadius(65);

        buttonClear2.setText("Product");
        buttonClear2.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear2.setPreferredSize(new java.awt.Dimension(278, 60));
        buttonClear2.setRadius(55);
        buttonClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear2ActionPerformed(evt);
            }
        });

        buttonClear3.setText("Expired");
        buttonClear3.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear3.setPreferredSize(new java.awt.Dimension(278, 60));
        buttonClear3.setRadius(55);
        buttonClear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear3ActionPerformed(evt);
            }
        });

        buttonClear4.setText("Purchased");
        buttonClear4.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear4.setPreferredSize(new java.awt.Dimension(278, 60));
        buttonClear4.setRadius(55);
        buttonClear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear4ActionPerformed(evt);
            }
        });

        button11.setForeground(new java.awt.Color(0, 0, 0));
        button11.setText("Order");
        button11.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(278, 60));
        button11.setRadius(55);
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rectangleBorder1Layout = new javax.swing.GroupLayout(rectangleBorder1);
        rectangleBorder1.setLayout(rectangleBorder1Layout);
        rectangleBorder1Layout.setHorizontalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        rectangleBorder1Layout.setVerticalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(buttonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonClear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonClear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        rectangleBorder2.setPreferredSize(new java.awt.Dimension(1337, 99));
        rectangleBorder2.setRadius(65);

        buttonClear5.setText("Total");
        buttonClear5.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear5.setPreferredSize(new java.awt.Dimension(143, 54));
        buttonClear5.setRadius(55);
        buttonClear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear5ActionPerformed(evt);
            }
        });

        labelText2.setText("Employee's name");

        buttonNoFillNoStroke2.setText("Log out");
        buttonNoFillNoStroke2.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N

        labelText3.setText("Date");

        date.setText("0");

        labelText5.setText("Time");

        time.setText("0");

        buttonIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N

        javax.swing.GroupLayout rectangleBorder2Layout = new javax.swing.GroupLayout(rectangleBorder2);
        rectangleBorder2.setLayout(rectangleBorder2Layout);
        rectangleBorder2Layout.setHorizontalGroup(
            rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(buttonClear5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(buttonNoFillNoStroke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        rectangleBorder2Layout.setVerticalGroup(
            rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangleBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClear5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonNoFillNoStroke2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        rectanglepoom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rectanglepoom2.setPreferredSize(new java.awt.Dimension(969, 792));

        buttonClear6.setText("Print");
        buttonClear6.setToolTipText("");
        buttonClear6.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonClear6.setPreferredSize(new java.awt.Dimension(90, 50));
        buttonClear6.setRadius(35);
        buttonClear6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setText("Receipt");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setText("Total");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Change");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Cash");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("#OrderNo.");

        buttonClear7.setText("Done");
        buttonClear7.setToolTipText("");
        buttonClear7.setFont(new java.awt.Font("Afacad", 0, 24)); // NOI18N
        buttonClear7.setPreferredSize(new java.awt.Dimension(90, 50));
        buttonClear7.setRadius(35);
        buttonClear7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear7ActionPerformed(evt);
            }
        });

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin111.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        newJPanel1.setPreferredSize(new java.awt.Dimension(871, 900));
        newJPanel1.setLayout(new java.awt.FlowLayout());
        newJPanel1.add(receiptlist3);

        scrollPaneWin111.setViewportView(newJPanel1);

        javax.swing.GroupLayout rectanglepoom2Layout = new javax.swing.GroupLayout(rectanglepoom2);
        rectanglepoom2.setLayout(rectanglepoom2Layout);
        rectanglepoom2Layout.setHorizontalGroup(
            rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectanglepoom2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectanglepoom2Layout.createSequentialGroup()
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rectanglepoom2Layout.createSequentialGroup()
                        .addGroup(rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rectanglepoom2Layout.createSequentialGroup()
                                .addGap(381, 381, 381)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(158, 166, Short.MAX_VALUE)
                        .addComponent(buttonClear6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(buttonClear7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        rectanglepoom2Layout.setVerticalGroup(
            rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectanglepoom2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rectanglepoom2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(rectanglepoom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClear7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClear6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(rectangleBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(rectanglepoom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectanglepoom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear2ActionPerformed

    private void buttonClear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear3ActionPerformed

    private void buttonClear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear4ActionPerformed

    private void buttonClear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear5ActionPerformed

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button11ActionPerformed

    private void buttonClear6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear6ActionPerformed

    private void buttonClear7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear7ActionPerformed
    Main mainFrame = new Main(); 
    mainFrame.setVisible(true);

    SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_buttonClear7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Background.background background1;
    private button.Button1 button11;
    private button.ButtonClear buttonClear2;
    private button.ButtonClear buttonClear3;
    private button.ButtonClear buttonClear4;
    private button.ButtonClear buttonClear5;
    private button.ButtonClear buttonClear6;
    private button.ButtonClear buttonClear7;
    private button.ButtonIcon buttonIcon1;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke2;
    private CustomFont.LabelText date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText5;
    private Rectangle.NewJPanel newJPanel1;
    private Order.Receiptlist receiptlist3;
    private Rectangle.RectangleBorder rectangleBorder1;
    private Rectangle.RectangleBorder rectangleBorder2;
    private Rectangle.Rectanglepoom rectanglepoom2;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    private CustomFont.LabelText time;
    // End of variables declaration//GEN-END:variables
}
