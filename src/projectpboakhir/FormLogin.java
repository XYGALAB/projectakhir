package projectpboakhir;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Koneksi.conek;
public class FormLogin extends javax.swing.JFrame {

    public FormLogin() {
        initComponents();
        
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lihat = new javax.swing.JCheckBox();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/rsz_login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 150));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 183, 234));
        jLabel3.setText("password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 183, 234));
        jLabel4.setText("L O G I N");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 10, 90, 23));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 153, 153));
        jButton1.setText("LOGIN");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 50, -1));

        lihat.setBackground(new java.awt.Color(255, 255, 255));
        lihat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lihatMouseClicked(evt);
            }
        });
        jPanel1.add(lihat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 20, -1));

        txtPass.setToolTipText("password");
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 183, 234));
        jLabel5.setText("username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Statement statement = (Statement)conek.configDB().createStatement();
            ResultSet result=statement.executeQuery("SELECT*FROM tb_users WHERE username='" + txtUser.getText()
                    + "'AND password=('" + txtPass.getText() + "')");
            if(result.next()){
                if(txtPass.getText().equals(result.getString("password"))){
                    new F_main();
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(rootPane,"Password salah");
                    txtPass.setText("");
                    txtUser.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane,"User tidak ditemukan");
                txtUser.setText("");
                txtPass.setText("");
                txtUser.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"gagal");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lihatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lihatMouseClicked
         if (lihat.isSelected()) {
      txtPass.setEchoChar((char)0); //password = JPasswordField
   } else {
      txtPass.setEchoChar('*');
   }
    }//GEN-LAST:event_lihatMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox lihat;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
