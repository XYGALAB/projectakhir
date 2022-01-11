package projectpboakhir;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Koneksi.conek;
public class FormMenu extends javax.swing.JFrame {
Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Statement statBrg;
	Boolean ada = false;
  
public void autokodeMakanan(){
    try {
        String sql = "SELECT * FROM tb_makanan order by kode desc";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
    if (res.next()){
        String kode = res.getString("kode").substring(1);
        String AN = "" +(Integer.parseInt(kode) + 1);
        String Nol = "";
        
        if (AN.length()==1)
        {Nol = "00";}
        else if (AN.length()==2)
        {Nol = "0";}
        else if(AN.length()==3)
        {Nol = "";}
        
        txtKode.setText( Nol + AN);
    } else {
        txtKode.setText("001");
    }
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
public void autokodeMinuman(){
    try {
        String sql = "SELECT * FROM tb_minuman order by kode desc";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
    if (res.next()){
        String kode = res.getString("kode").substring(1);
        String AN = "" +(Integer.parseInt(kode) + 1);
        String Nol = "";
        
        if (AN.length()==1)
        {Nol = "00";}
        else if (AN.length()==2)
        {Nol = "0";}
        else if(AN.length()==3)
        {Nol = "";}
        
        txtKode.setText( Nol + AN);
    } else {
        txtKode.setText("001");
    }
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}      
private void load_tablemakanan(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("KODE");
        model.addColumn("MAKANAN");
        model.addColumn("HARGA");
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from tb_makanan";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabel_menu.setModel(model);
        } catch (Exception e) {
        }}
private void load_tableminuman(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("KODE");
        model.addColumn("MINUMAN");
        model.addColumn("HARGA");
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from tb_minuman";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabel_menu.setModel(model);
        } catch (Exception e) {
        }}
    public void lebarKolom(){ 
        TableColumn column;
        tabel_menu.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabel_menu.getColumnModel().getColumn(0); 
        column.setPreferredWidth(45);
        column = tabel_menu.getColumnModel().getColumn(1); 
        column.setPreferredWidth(48); 
        column = tabel_menu.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = tabel_menu.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = tabel_menu.getColumnModel().getColumn(4); 
        column.setPreferredWidth(50);
    }
    private void kosong(){

    txtKode.enable(false);
    txtNama.enable(false);
    txtHarga.enable(false);
    txtKode.setText(null);
    txtNama.setText(null);
    txtHarga.setText(null);
    btnSimpan.enable(false);
    btnUpdate.enable(false);

    }
    
private void clear(){
    txtKode.enable(false);
    txtNama.enable(true);
    txtHarga.enable(true);
        
        txtNama.setText(null);
        txtHarga.setText(null);
        
}
public void prosesSimpan1(){
    try {
            String sql = "INSERT INTO `tb_makanan`(`kode`, `makanan`, `harga`) "
                    + "VALUES ('"+txtKode.getText()+"','"+txtNama.getText()+"','"+txtHarga.getText()+"')";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
public void prosesSimpan2(){
    try {
            String sql = "INSERT INTO `tb_minuman`(`kode`, `minuman`, `harga`) "
                    + "VALUES ('"+txtKode.getText()+"','"+txtNama.getText()+"','"+txtHarga.getText()+"')";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
public void prosesUpdate1(){
    try {
            int baris = tabel_menu.getSelectedRow();
            String id =tabel_menu.getValueAt(baris, 1).toString();
            String sql ="UPDATE `tb_makanan` SET `kode`='"+txtKode.getText()+"',`makanan`='"+txtNama.getText()+"',`harga`='"+txtHarga.getText()+"'WHERE id = '"+ id +"' ";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
}
public void prosesUpdate2(){
    try {
            int baris = tabel_menu.getSelectedRow();
            String id =tabel_menu.getValueAt(baris, 1).toString();
            String sql ="UPDATE `tb_minuman` SET `kode`='"+txtKode.getText()+"',`minuman`='"+txtMakanan.getText()+"',`harga`='"+txtHarga.getText()+"'WHERE id = '"+ id +"' ";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
}
public void prosesHapus1(){
    try {
            int baris = tabel_menu.getSelectedRow();
            String id =tabel_menu.getValueAt(baris, 1).toString();
            String sql ="delete from tb_makanan WHERE id = '"+ id +"'";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
public void prosesHapus2(){
    try {
            int baris = tabel_menu.getSelectedRow();
            String id =tabel_menu.getValueAt(baris, 1).toString();
            String sql ="delete from tb_minuman WHERE id = '"+ id +"'";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    public FormMenu() {
        initComponents();
        setVisible(true);
        
        
        kosong();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMakanan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_menu = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMakanan = new javax.swing.JMenu();
        btnTambah1 = new javax.swing.JMenuItem();
        btnEdit1 = new javax.swing.JMenuItem();
        btnMinuman = new javax.swing.JMenu();
        btnTambah2 = new javax.swing.JMenuItem();
        btnEdit2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        txtMakanan.setForeground(new java.awt.Color(40, 70, 70));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 70, 70));
        jLabel1.setText("Kode");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 70, 70));
        jLabel2.setText("Nama Makanan");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 70, 70));
        jLabel3.setText("Harga");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 70, 70));
        jLabel4.setText("Cari Makanan");

        txtKode.setForeground(new java.awt.Color(40, 70, 70));

        txtNama.setForeground(new java.awt.Color(40, 70, 70));

        txtHarga.setForeground(new java.awt.Color(40, 70, 70));

        btnSimpan.setBackground(new java.awt.Color(255, 204, 204));
        btnSimpan.setForeground(new java.awt.Color(40, 70, 70));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(255, 204, 204));
        btnTutup.setForeground(new java.awt.Color(40, 70, 70));
        btnTutup.setText("Tutup");
        btnTutup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        tabel_menu.setBackground(new java.awt.Color(255, 204, 204));
        tabel_menu.setForeground(new java.awt.Color(40, 70, 70));
        tabel_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_menu);

        btnUpdate.setBackground(new java.awt.Color(255, 204, 204));
        btnUpdate.setForeground(new java.awt.Color(40, 70, 70));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 204, 204));
        btnHapus.setForeground(new java.awt.Color(40, 70, 70));
        btnHapus.setText("Hapus");
        btnHapus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(30, 30, 30))
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTutup)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnMakanan.setText("Makanan");
        btnMakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMakananMouseClicked(evt);
            }
        });

        btnTambah1.setText("Tambah");
        btnTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah1ActionPerformed(evt);
            }
        });
        btnMakanan.add(btnTambah1);

        btnEdit1.setText("Edit");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });
        btnMakanan.add(btnEdit1);

        jMenuBar1.add(btnMakanan);

        btnMinuman.setText("Minuman");
        btnMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinumanMouseClicked(evt);
            }
        });
        btnMinuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinumanActionPerformed(evt);
            }
        });

        btnTambah2.setText("Tambah");
        btnTambah2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambah2MouseClicked(evt);
            }
        });
        btnTambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah2ActionPerformed(evt);
            }
        });
        btnMinuman.add(btnTambah2);

        btnEdit2.setText("edit");
        btnEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit2ActionPerformed(evt);
            }
        });
        btnMinuman.add(btnEdit2);

        jMenuBar1.add(btnMinuman);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinumanActionPerformed
        
    }//GEN-LAST:event_btnMinumanActionPerformed
 
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (btnSimpan.getName() == "Simpan1"){
           prosesSimpan1();
           load_tablemakanan();
           
        }else if (btnSimpan.getName() == "Simpan2"){
            prosesSimpan2();
            load_tableminuman();
            
        }
        kosong();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinumanMouseClicked
        load_tableminuman();
        btnHapus.setName("Hapus2");
        lebarKolom();
    }//GEN-LAST:event_btnMinumanMouseClicked

    private void btnTambah2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambah2MouseClicked
        
    }//GEN-LAST:event_btnTambah2MouseClicked

    private void btnTambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah2ActionPerformed
        btnSimpan.setName("Simpan2");
        btnSimpan.enable(true);
        autokodeMinuman();
        clear();
    }//GEN-LAST:event_btnTambah2ActionPerformed

    private void tabel_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_menuMouseClicked
        int baris = tabel_menu.rowAtPoint(evt.getPoint());
        String kode =tabel_menu.getValueAt(baris, 2).toString();
        txtKode.setText(kode);
        String nama = tabel_menu.getValueAt(baris,3).toString();
        txtNama.setText(nama);
        String harga = tabel_menu.getValueAt(baris,4).toString();
        txtHarga.setText(harga);
    }//GEN-LAST:event_tabel_menuMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (btnUpdate.getName() == "Update1"){
           prosesUpdate1();
           load_tablemakanan();
        }else if (btnUpdate.getName() == "Update2"){
            prosesUpdate2();
            load_tableminuman();
        }kosong();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit2ActionPerformed
        btnUpdate.setName("Update2");
        btnUpdate.enable(true);
        clear();
    }//GEN-LAST:event_btnEdit2ActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (btnHapus.getName() == "Hapus1"){
           prosesHapus1();
           load_tablemakanan();
        }else if (btnHapus.getName() == "Hapus2"){
            prosesHapus2();
            load_tableminuman();
        }kosong();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah1ActionPerformed
        btnSimpan.setName("Simpan1");
        btnSimpan.enable(true);
        autokodeMakanan();
        clear();
    }//GEN-LAST:event_btnTambah1ActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        btnUpdate.setName("Update1");
        btnUpdate.enable(true);
        clear();
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnMakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMakananMouseClicked
       load_tablemakanan();
        btnHapus.setName("Hapus1");
        lebarKolom();
        
    }//GEN-LAST:event_btnMakananMouseClicked

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        new F_main();
        this.dispose();
    }//GEN-LAST:event_btnTutupActionPerformed
    
   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnEdit1;
    private javax.swing.JMenuItem btnEdit2;
    private javax.swing.JButton btnHapus;
    private javax.swing.JMenu btnMakanan;
    private javax.swing.JMenu btnMinuman;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JMenuItem btnTambah1;
    private javax.swing.JMenuItem btnTambah2;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_menu;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMakanan;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
