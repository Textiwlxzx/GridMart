public class Test extends javax.swing.JFrame {

   
    public Test() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundblur1 = new Background.backgroundblur();
        comboBoxSuggestion1 = new ComboBox.ComboBoxSuggestion();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundblur1.setBackground(new java.awt.Color(255, 255, 255));

        comboBoxSuggestion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "b", "c", "d", "e", "r", "t", "g", "f", "s", " " }));

        javax.swing.GroupLayout backgroundblur1Layout = new javax.swing.GroupLayout(backgroundblur1);
        backgroundblur1.setLayout(backgroundblur1Layout);
        backgroundblur1Layout.setHorizontalGroup(
            backgroundblur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundblur1Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        backgroundblur1Layout.setVerticalGroup(
            backgroundblur1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundblur1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundblur1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundblur1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Background.backgroundblur backgroundblur1;
    private ComboBox.ComboBoxSuggestion comboBoxSuggestion1;
    // End of variables declaration//GEN-END:variables
}
