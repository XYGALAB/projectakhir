package projectpboakhir;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Koneksi.conek;
public class FormUser extends javax.swing.JFrame {
Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Statement statBrg;
	Boolean ada = false;
        

private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("no");
        model.addColumn("ID");
        model.addColumn("USERNAME");
        model.addColumn("PASSWORD");
        model.addColumn("LEVEL");
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from tb_users";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabel_data.setModel(model);
        } catch (Exception e) {
        }}

public void lebarKolom(){ 
        TableColumn column;
        tabel_data.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabel_data.getColumnModel().getColumn(0); 
        column.setPreferredWidth(45);
        column = tabel_data.getColumnModel().getColumn(1); 
        column.setPreferredWidth(48); 
        column = tabel_data.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = tabel_data.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = tabel_data.getColumnModel().getColumn(4); 
        column.setPreferredWidth(50);
    }

private void kosong(){

    txtUser.enable(false);
    txtPass.enable(false);

    cmbLevel.enable(false);

        txtUser.setText(null);
        txtPass.setText(null);

        
    }
private void clear(){

    txtUser.enable(true);
    txtPass.enable(true);

    cmbLevel.enable(true);
        txtUser.setText(null);
        txtPass.setText(null);
        
        
}
    public FormUser() {
        initComponents();
        setVisible(true); 
        load_table();
        lebarKolom();
        kosong();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        cmbLevel = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(null);

        jScrollPane1.setForeground(new java.awt.Color(40, 70, 70));

        tabel_data.setBackground(new java.awt.Color(255, 204, 204));
        tabel_data.setForeground(new java.awt.Color(0, 183, 234));
        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "USERNAME", "LEVEL"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_data);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 52, 346, 90);

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setForeground(new java.awt.Color(40, 70, 70));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(189, 231, 71, 23);

        btnHapus.setBackground(new java.awt.Color(255, 204, 204));
        btnHapus.setForeground(new java.awt.Color(40, 70, 70));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus);
        btnHapus.setBounds(266, 231, 71, 23);

        btnRefresh.setBackground(new java.awt.Color(255, 204, 204));
        btnRefresh.setForeground(new java.awt.Color(40, 70, 70));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);
        btnRefresh.setBounds(35, 231, 71, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 70, 70));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(73, 155, 54, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 70, 70));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(76, 181, 51, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 70, 70));
        jLabel5.setText("Level User");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(71, 207, 56, 15);

        txtUser.setForeground(new java.awt.Color(40, 70, 70));
        jPanel1.add(txtUser);
        txtUser.setBounds(137, 153, 140, 20);

        txtPass.setForeground(new java.awt.Color(40, 70, 70));
        jPanel1.add(txtPass);
        txtPass.setBounds(137, 179, 140, 20);

        cmbLevel.setBackground(new java.awt.Color(255, 204, 204));
        cmbLevel.setEditable(true);
        cmbLevel.setForeground(new java.awt.Color(40, 70, 70));
        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "ROOT", "OWNER", "KASIR", "GUDANG" }));
        jPanel1.add(cmbLevel);
        cmbLevel.setBounds(137, 205, 140, 20);

        btnSimpan.setBackground(new java.awt.Color(255, 204, 204));
        btnSimpan.setForeground(new java.awt.Color(40, 70, 70));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);
        btnSimpan.setBounds(112, 231, 71, 23);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("DATA USER");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(143, 11, 94, 22);

        btnTambah.setBackground(new java.awt.Color(204, 255, 255));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/icons8-plus-+-24.png"))); // NOI18N
        btnTambah.setBorder(null);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah);
        btnTambah.setBounds(0, 0, 23, 24);

        btnEdit.setBackground(new java.awt.Color(204, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/icons8-edit-24.png"))); // NOI18N
        btnEdit.setBorder(null);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(30, 0, 23, 24);

        btnKembali.setBackground(new java.awt.Color(204, 255, 255));
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/rsz_icons8-x-men-48.png"))); // NOI18N
        btnKembali.setBorder(null);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali);
        btnKembali.setBounds(350, 0, 20, 23);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 260));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int baris = tabel_data.getSelectedRow();
            String id =tabel_data.getValueAt(baris, 1).toString();
            String sql ="UPDATE `tb_users` SET `username`='"+txtUser.getText()+"',`password`='"+txtPass.getText()+"',`level`='"+cmbLevel.getSelectedItem()+"'WHERE id = '"+ id +"' ";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        int baris = tabel_data.rowAtPoint(evt.getPoint());
        String username =tabel_data.getValueAt(baris, 2).toString();
        txtUser.setText(username);
        String pass = tabel_data.getValueAt(baris,3).toString();
        txtPass.setText(pass);
    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            int baris = tabel_data.getSelectedRow();
            String id =tabel_data.getValueAt(baris, 1).toString();
            String sql ="delete from tb_users WHERE id = '"+ id +"'";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        load_table();
        kosong();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
            try {
            String sql = "INSERT INTO `tb_users`(`username`, `password`, `level`) "
                    + "VALUES ('"+txtUser.getText()+"','"+txtPass.getText()+"','"+cmbLevel.getSelectedItem()+"')";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
            
   
       load_table();
       kosong();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        load_table();
        clear();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        load_table();
        clear();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new F_main();
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
