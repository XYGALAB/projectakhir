package projectpboakhir;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Koneksi.conek;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
public class F_Order extends javax.swing.JFrame {
        Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Statement statBrg;
	Boolean ada = false;

        private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("WAKTU");
        model.addColumn("ORDER");
        model.addColumn("TOTALHARGA");
        model.addColumn("BAYAR");
        model.addColumn("KEMBALI");
        //menampilkan data database kedalam tabel
        try {
            
            String sql = "select * from tb_order";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            tabelOrder.setModel(model);
        } catch (Exception e) {
        }} 
        public void load_listmakanan(){
            DefaultListModel model = new DefaultListModel();
            try {
            
            String sql = "select * from tb_makanan";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                String nama = res.getString("makanan");
                model.addElement(nama);       
            }
            jList1.setModel(model);
        } catch (Exception e) {
        }
        }
        public void load_listminuman(){
            DefaultListModel model = new DefaultListModel();
            try {
            
            String sql = "select * from tb_minuman";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                String nama = res.getString("minuman");
                model.addElement(nama);
            }
            jList1.setModel(model);
        } catch (Exception e) {
        }
        }
        public void lebarKolom(){ 
        TableColumn column;
        tabelOrder.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabelOrder.getColumnModel().getColumn(0); 
        column.setPreferredWidth(40);
        column = tabelOrder.getColumnModel().getColumn(1); 
        column.setPreferredWidth(80); 
        column = tabelOrder.getColumnModel().getColumn(2); 
        column.setPreferredWidth(80); 
        column = tabelOrder.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100);
        column = tabelOrder.getColumnModel().getColumn(4); 
        column.setPreferredWidth(100);
        column = tabelOrder.getColumnModel().getColumn(5); 
        column.setPreferredWidth(80);
    }
        private void kosong(){
        cmbMenu.enable(true);
        cmbOrder.enable(false);
        txtHarga.enable(false);
        jumlah.enable(false);
        txtBayar.enable(false);
        txtKembali.enable(false);
        jumlah.setValue(0);
        txtBayar.setText(null);
    
        txtKembali.setText(null);
        btnSimpan.setEnabled(false);
        btnHitung.setEnabled(false);
        btnAdd.setEnabled(false);
    }
        private void clear(){
        cmbMenu.enable(true);
        cmbOrder.enable(true);
        txtHarga.enable(false);
        jumlah.enable(true);
        txtBayar.enable(true);
        txtKembali.enable(false);
        jumlah.setValue(1);
        txtBayar.setText(null);
     
        txtKembali.setText(null);
        btnSimpan.setEnabled(true);
        btnHitung.setEnabled(true);
        
    }
    public void prosesSimpan(){
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     String tanggal = String.valueOf(format.format(date.getDate()));
    try {
            String sql = "INSERT INTO `tb_order`(`waktu`, `order`, `totalharga`,`bayar`,`kembali`) "
                    + "VALUES ('"+tanggal+"','"+cmbOrder.getSelectedItem()+"','"+txtHarga.getText()+"','"+txtBayar.getText()+"','"+txtKembali.getText()+"')";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di simpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    public void prosesHapus(){
    try {
            int baris = tabelOrder.getSelectedRow();
            String id =tabelOrder.getValueAt(baris, 0).toString();
            String sql ="delete from tb_order WHERE id = '"+ id +"'";
            java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    public void proseshitung(){
        try {
           String SQL = "SELECT * FROM tb_makanan WHERE makanan = '" + jList1.getSelectedValue() + "'";
           java.sql.Connection conn=(Connection)conek.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(SQL);
            while(res.next()){
                int harga = res.getInt("harga");
                int jml = Integer.parseInt(jumlah.getValue().toString());
                int total = jml * harga;
                String jtotal = String.valueOf(total + total);
                txtHarga.setText(jtotal);
            }
         } catch (Exception e) {}   
    }
    public F_Order() {
        initComponents();
        setVisible(true);
        kosong();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cmbMenu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbOrder = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelOrder = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jumlah = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        date.setForeground(new java.awt.Color(40, 70, 70));

        jLabel1.setForeground(new java.awt.Color(40, 70, 70));
        jLabel1.setText("DATE");

        cmbMenu.setForeground(new java.awt.Color(40, 70, 70));
        cmbMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------------", "MAKANAN", "MINUMAN" }));
        cmbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(40, 70, 70));
        jLabel2.setText("MENU");

        jLabel3.setForeground(new java.awt.Color(40, 70, 70));
        jLabel3.setText("ORDER");

        cmbOrder.setForeground(new java.awt.Color(40, 70, 70));
        cmbOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------------", "DINE IN", "DELIVERY", "TAKE AWAY" }));

        jLabel4.setForeground(new java.awt.Color(40, 70, 70));
        jLabel4.setText("Jumlah");

        btnAdd.setBackground(new java.awt.Color(255, 204, 204));
        btnAdd.setForeground(new java.awt.Color(40, 70, 70));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(40, 70, 70));

        tabelOrder.setBackground(new java.awt.Color(255, 204, 204));
        tabelOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelOrder);

        btnKembali.setBackground(new java.awt.Color(204, 255, 255));
        btnKembali.setForeground(new java.awt.Color(40, 70, 70));
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectpboakhir/rsz_icons8-x-men-48.png"))); // NOI18N
        btnKembali.setBorder(null);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(40, 70, 70));
        jLabel5.setText("Total Harga");

        jLabel6.setForeground(new java.awt.Color(40, 70, 70));
        jLabel6.setText("Bayar");

        jLabel7.setForeground(new java.awt.Color(40, 70, 70));
        jLabel7.setText("Kembali");

        txtHarga.setForeground(new java.awt.Color(40, 70, 70));

        txtBayar.setForeground(new java.awt.Color(40, 70, 70));

        txtKembali.setForeground(new java.awt.Color(40, 70, 70));

        btnSimpan.setBackground(new java.awt.Color(255, 204, 204));
        btnSimpan.setForeground(new java.awt.Color(40, 70, 70));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHitung.setBackground(new java.awt.Color(255, 204, 204));
        btnHitung.setForeground(new java.awt.Color(40, 70, 70));
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 204, 204));
        btnHapus.setForeground(new java.awt.Color(40, 70, 70));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbOrder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHitung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnHapus)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6))
                            .addComponent(cmbOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(9, 9, 9)))))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new F_main();
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void cmbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuActionPerformed
       if (cmbMenu.getSelectedItem() == "MAKANAN"){
           load_listmakanan();
          
       }else if (cmbMenu.getSelectedItem() == "MINUMAN"){
           load_listminuman();
           
       }btnAdd.setEnabled(true);
       load_table();
       lebarKolom();
       clear();
    }//GEN-LAST:event_cmbMenuActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        proseshitung();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        int harga = Integer.parseInt(txtHarga.getText());
        int bayar = Integer.parseInt(txtBayar.getText());
        txtKembali.setText(String.valueOf(bayar-harga));
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       String tanggal = String.valueOf(format.format(date.getDate()));
       if (txtBayar.getText() == "" && tanggal == null ){
           JOptionPane.showMessageDialog(this, "data belum lengkap !!!");
       }else {
           prosesSimpan();
       }
        load_table();
       lebarKolom();
       clear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        prosesHapus();
        load_table();
        lebarKolom();
    }//GEN-LAST:event_btnHapusActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbMenu;
    private javax.swing.JComboBox<String> cmbOrder;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jumlah;
    private javax.swing.JTable tabelOrder;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKembali;
    // End of variables declaration//GEN-END:variables
}
