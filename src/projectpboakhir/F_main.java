package projectpboakhir;


public class F_main extends javax.swing.JFrame {


    public F_main() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        datauser = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/Galaxy.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 360, 250);

        jMenuBar2.setBackground(new java.awt.Color(255, 204, 204));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jMenu3.setText("File");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuItem2.setText("Tambah Menu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Order");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Pengaturan");
        jMenu4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        datauser.setBackground(new java.awt.Color(255, 204, 204));
        datauser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        datauser.setText("DataUser");
        datauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datauserActionPerformed(evt);
            }
        });
        jMenu4.add(datauser);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Tutup");
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void datauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datauserActionPerformed
        new FormUser();
        this.dispose();
    }//GEN-LAST:event_datauserActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FormMenu();
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new F_Order();
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem datauser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
