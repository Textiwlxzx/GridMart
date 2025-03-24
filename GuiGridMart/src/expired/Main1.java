
package expired;


import MainManagement.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


public class main1 extends javax.swing.JFrame {

    
    public main1() {
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
        buttonClear1 = new button.ButtonClear();
        buttonClear3 = new button.ButtonClear();
        buttonClear4 = new button.ButtonClear();
        rectangleBorder2 = new Rectangle.RectangleBorder();
        buttonClear5 = new button.ButtonClear();
        labelText2 = new CustomFont.LabelText();
        buttonNoFillNoStroke2 = new button.ButtonNoFillNoStroke();
        labelText3 = new CustomFont.LabelText();
        date = new CustomFont.LabelText();
        labelText5 = new CustomFont.LabelText();
        time = new CustomFont.LabelText();
        buttonIcon1 = new button.ButtonIcon();
        rectangle1 = new Rectangle.Rectangle();
        rectangle2 = new Rectangle.Rectangle();
        label2 = new java.awt.Label();
        label1 = new java.awt.Label();
        label4 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background1.setPreferredSize(new java.awt.Dimension(1440, 1024));

        rectangleBorder1.setPreferredSize(new java.awt.Dimension(321, 817));
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

        buttonClear1.setText("Order");
        buttonClear1.setFont(new java.awt.Font("Afacad", 0, 28)); // NOI18N
        buttonClear1.setPreferredSize(new java.awt.Dimension(278, 60));
        buttonClear1.setRadius(55);
        buttonClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClear1ActionPerformed(evt);
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

        javax.swing.GroupLayout rectangleBorder1Layout = new javax.swing.GroupLayout(rectangleBorder1);
        rectangleBorder1.setLayout(rectangleBorder1Layout);
        rectangleBorder1Layout.setHorizontalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangleBorder1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonClear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        rectangleBorder1Layout.setVerticalGroup(
            rectangleBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangleBorder1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(buttonClear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonClear3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonClear4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(407, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
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

        rectangle1.setMinimumSize(new java.awt.Dimension(443, 179));
        rectangle1.setRadius(60);

        javax.swing.GroupLayout rectangle1Layout = new javax.swing.GroupLayout(rectangle1);
        rectangle1.setLayout(rectangle1Layout);
        rectangle1Layout.setHorizontalGroup(
            rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rectangle1Layout.setVerticalGroup(
            rectangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rectangle2.setPreferredSize(new java.awt.Dimension(443, 179));
        rectangle2.setRadius(60);
        rectangle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rectangle2MouseExited(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label2.setText("expired:");

        label1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label1.setText("date:");

        label4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        label4.setText("left");

        javax.swing.GroupLayout rectangle2Layout = new javax.swing.GroupLayout(rectangle2);
        rectangle2.setLayout(rectangle2Layout);
        rectangle2Layout.setHorizontalGroup(
            rectangle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rectangle2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(rectangle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rectangle2Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(370, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle2Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        rectangle2Layout.setVerticalGroup(
            rectangle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rectangle2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(rectangle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rectangle2Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
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
                        .addGap(43, 43, 43)
                        .addComponent(rectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rectangleBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rectangleBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(rectangle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClear1ActionPerformed

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

    private void rectangle2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangle2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rectangle2MouseExited

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
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Background.background background1;
    private button.ButtonClear buttonClear1;
    private button.ButtonClear buttonClear2;
    private button.ButtonClear buttonClear3;
    private button.ButtonClear buttonClear4;
    private button.ButtonClear buttonClear5;
    private button.ButtonIcon buttonIcon1;
    private button.ButtonNoFillNoStroke buttonNoFillNoStroke2;
    private CustomFont.LabelText date;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private CustomFont.LabelText labelText2;
    private CustomFont.LabelText labelText3;
    private CustomFont.LabelText labelText5;
    private Rectangle.Rectangle rectangle1;
    private Rectangle.Rectangle rectangle2;
    private Rectangle.RectangleBorder rectangleBorder1;
    private Rectangle.RectangleBorder rectangleBorder2;
    private CustomFont.LabelText time;
    // End of variables declaration//GEN-END:variables
}
