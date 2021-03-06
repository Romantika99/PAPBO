import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ackyras-Laptop
 */
public class DataMaba extends javax.swing.JFrame {
    public DefaultTableModel tabModel;
    Connection con;
    Statement stat;
    ResultSet rs,rsb, rsa;
    String sql, ktp;
    /**
     * Creates new form DataMaba
     * @param rsd
     * @throws java.sql.SQLException
     */
    public DataMaba(ResultSet rsd) throws SQLException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Konek db=new Konek();
        db.config();
        con =db.con;
        stat =db.stm;
        this.rs=rsd;
        this.rsa=rsd;
        try{
            sql="SELECT * FROM akun WHERE `nomor ktp`='"+rs.getString("nomor ktp")+"'";
            rs=stat.executeQuery(sql);
            if(rs.next()){
                setname(rs.getString("nama"));
            }
        }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
        }isitabel();
    }
    
    private void setname(String n){
        profil.setText(profil.getText()+n);
    }
    
    private void isitabel() throws SQLException{
        DefaultTableModel model = (DefaultTableModel)tblm .getModel();
        model.setRowCount(0);
        Object row[]= new Object[9];
        sql="select * from mahasiswa";
        rsb=stat.executeQuery(sql);
        String[] data = new String [9];
        ArrayList<User> ars=new ArrayList<>();
        User user;
        while(rsb.next()){
            user=new User(rsb.getString("No. pendaftaran"),rsb.getString("nama"),rsb.getString("jenis kelamin"), rsb.getString("nomor ktp"), rsb.getString("nomor hp"), rsb.getString("Tempat lahir"), rsb.getString("tanggal lahir"), rsb.getString("lengkap"), rsb.getString("validasi"));
            ars.add(user);
        }JOptionPane.showMessageDialog(null, ars.size()+" mahasiswa yang terdaftar");
        for(int i=0; i<ars.size();i++){
            row[0]=ars.get(i).getnp();
            row[1]=ars.get(i).getname();
            row[2]=ars.get(i).getjk();
            row[3]=ars.get(i).getnk();
            row[4]=ars.get(i).getnh();
            row[5]=ars.get(i).gettl();
            row[6]=ars.get(i).getttl();
            row[7]=ars.get(i).getlengkap();
            row[8]=ars.get(i).getnvalid();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblmaba = new javax.swing.JScrollPane();
        tblm = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        profil = new javax.swing.JLabel();
        valid = new javax.swing.JButton();
        lenkap = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        tblmaba.setBackground(new java.awt.Color(0, 0, 0));
        tblmaba.setToolTipText("Nama Mahasiswa\nLengkap\nValidasi\n");
        tblmaba.setName("tblmaba"); // NOI18N

        tblm.setBackground(new java.awt.Color(0, 0, 0));
        tblm.setForeground(new java.awt.Color(227, 132, 1));
        tblm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor Pendaftaran", "Nama maba", "Jenis Kelamin", "No. KTP", "No. HP", "Tempat Lahir", "Tanggal Lahir", "Lengkap", "Validasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblm.setColumnSelectionAllowed(true);
        tblm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblm.setGridColor(new java.awt.Color(0, 0, 0));
        tblm.getTableHeader().setReorderingAllowed(false);
        tblmaba.setViewportView(tblm);
        tblm.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jScrollPane1.setViewportView(tblmaba);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 940, 230));

        jPanel4.setBackground(new java.awt.Color(227, 132, 1));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel9.setText("DIM Baru Universitas Kace");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 290, 40));

        profil.setText("Data Admin ");
        jPanel4.add(profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 70));

        valid.setText("Validasi");
        valid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validActionPerformed(evt);
            }
        });
        getContentPane().add(valid, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, -1, -1));

        lenkap.setText("Lengkap");
        lenkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenkapActionPerformed(evt);
            }
        });
        getContentPane().add(lenkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, -1, -1));

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 940, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lenkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenkapActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblm.getModel();
        int i=tblm.getSelectedRow();
        String cek=model.getValueAt(i,0).toString();
        String cek1=model.getValueAt(i,7).toString();
        String ank;
        if("lengkap".equals(cek1)){
            ank="0";
        }else{
            ank="1";
        }sql="UPDATE `mahasiswa` SET `Lengkap`='"+ank+"' WHERE `No. Pendaftaran`='"+cek+"'";
        try {
            stat.execute(sql);
            isitabel();
        } catch (SQLException ex) {
            Logger.getLogger(DataMaba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lenkapActionPerformed

    private void validActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblm.getModel();
        int i=tblm.getSelectedRow();
        String cek=model.getValueAt(i,0).toString();
        String cek1=model.getValueAt(i,7).toString();
        String ank;
        if("Tervalidasi".equals(cek1)){
            ank="0";
        }else{
            ank="1";
        }sql="UPDATE `mahasiswa` SET `validasi`='"+ank+"' WHERE `No. Pendaftaran`='"+cek+"'";
        try {
            stat.execute(sql);
            isitabel();
        } catch (SQLException ex) {
            Logger.getLogger(DataMaba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_validActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {
            // TODO add your handling code here:
            Adminframe af=new Adminframe(rsa);
            af.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DataMaba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(DataMaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMaba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lenkap;
    private javax.swing.JLabel profil;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tblm;
    private static javax.swing.JScrollPane tblmaba;
    private javax.swing.JButton valid;
    // End of variables declaration//GEN-END:variables
}
