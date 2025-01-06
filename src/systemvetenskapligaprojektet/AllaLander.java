/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author lisk
 */
public class AllaLander extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;


    /**
     * Creates new form AllaLander
     */
    public AllaLander(InfDB idb, String inloggadAnvandare) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        initComponents();
        fyllTabell();
        
    }

    public void fyllTabell(){
        try{
            String[] kolumnNamn = {"lid", "namn", "sprak", "valuta", "tidszon", "politisk_struktur", "ekonomi"};
            DefaultTableModel allaLander = new DefaultTableModel(kolumnNamn, 0);
            
            String selectLid = "select lid from land order by(lid);";
            ArrayList<String> lid = idb.fetchColumn(selectLid);
                if(lid != null){
                    for(String ettID:lid){
                        String selectInfo = "select * from land where lid = " + ettID + ";";
                        HashMap<String, String> info = idb.fetchRow(selectInfo);
                        
                        Object[] enRad = new Object[kolumnNamn.length];
                        int index = 0;
                        
                        for(String enKolumn:kolumnNamn){
                            enRad[index++] = info.get(enKolumn);
                        }
                        allaLander.addRow(enRad);
                    }
                    tblAllaLander.setModel(allaLander);
                }
                tblAllaLander.setAutoResizeMode(tblAllaLander.AUTO_RESIZE_OFF);
                TableColumn col = tblAllaLander.getColumnModel().getColumn(0);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(1);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(2);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(3);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(4);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(5);
                col.setPreferredWidth(100);
                col = tblAllaLander.getColumnModel().getColumn(6);
                col.setPreferredWidth(100);
            }
            catch(InfException ex){
                System.out.println(ex);
        }        
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLaggTIll = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();
        btnRedigera = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        lblAllaLander = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllaLander = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLaggTIll.setText("Lägg till");
        btnLaggTIll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTIllActionPerformed(evt);
            }
        });

        btnSok.setText("OBS SOK!!");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        btnRedigera.setText("Redigera");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        lblAllaLander.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllaLander.setText("Alla länder");

        tblAllaLander.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(tblAllaLander);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLaggTIll)
                        .addGap(18, 18, 18)
                        .addComponent(btnRedigera)
                        .addGap(18, 18, 18)
                        .addComponent(btnSok)
                        .addGap(18, 18, 18)
                        .addComponent(btnTillbaka))
                    .addComponent(lblAllaLander)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblAllaLander)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLaggTIll)
                    .addComponent(btnRedigera)
                    .addComponent(btnTillbaka)
                    .addComponent(btnSok))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTIllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTIllActionPerformed
        new LaggTillLand(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaggTIllActionPerformed

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        new RedigeraLand(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRedigeraActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyAdmin(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    
    
    
    
    
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
            java.util.logging.Logger.getLogger(AllaLander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllaLander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllaLander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllaLander.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AllaLander().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTIll;
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAllaLander;
    private javax.swing.JTable tblAllaLander;
    // End of variables declaration//GEN-END:variables
}
