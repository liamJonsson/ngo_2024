/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import java.lang.NumberFormatException;
 //*
// * @author limme
 //*/
public class LaggTillLand extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    private int lid;
    private double enValuta;
    /**
     * Creates new form LaggTillLand
     */
    public LaggTillLand(InfDB idb, String inloggadAnvandare) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        initComponents();
        lblIDFel.setVisible(false); 
        lblValutaFel.setVisible(false);
        lblLaggTillLandLyckat.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLaggTillEttLand = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblSprak = new javax.swing.JLabel();
        lblValuta = new javax.swing.JLabel();
        lblTidszon = new javax.swing.JLabel();
        lblPolitiskStruktur = new javax.swing.JLabel();
        lblEkonomi = new javax.swing.JLabel();
        tfPolitiskStruktur = new javax.swing.JTextField();
        tfEkonomi = new javax.swing.JTextField();
        tfTidszon = new javax.swing.JTextField();
        tfValuta = new javax.swing.JTextField();
        tfSprak = new javax.swing.JTextField();
        tfNamn = new javax.swing.JTextField();
        tfID = new javax.swing.JTextField();
        btnSpara = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        lblIDFel = new javax.swing.JLabel();
        lblValutaFel = new javax.swing.JLabel();
        lblLaggTillLandLyckat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLaggTillEttLand.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLaggTillEttLand.setText("Lägg till ett land");

        lblID.setText("ID");

        lblNamn.setText("Namn");

        lblSprak.setText("Språk");

        lblValuta.setText("Valuta");

        lblTidszon.setText("Tidszon");

        lblPolitiskStruktur.setText("Politisk struktur");

        lblEkonomi.setText("Ekonomi");

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        lblIDFel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblIDFel.setForeground(new java.awt.Color(255, 0, 0));
        lblIDFel.setText("ID:t existerar redan");

        lblValutaFel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblValutaFel.setForeground(new java.awt.Color(255, 0, 0));
        lblValutaFel.setText("Ange en valuta i korrekt format");

        lblLaggTillLandLyckat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblLaggTillLandLyckat.setForeground(new java.awt.Color(0, 153, 0));
        lblLaggTillLandLyckat.setText("Landet har lagts till");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLaggTillEttLand)
                            .addComponent(lblValuta))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLaggTillLandLyckat)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSpara)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblID)
                                    .addGap(103, 103, 103)
                                    .addComponent(tfID))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPolitiskStruktur)
                                        .addComponent(lblEkonomi)
                                        .addComponent(lblTidszon)
                                        .addComponent(lblSprak)
                                        .addComponent(lblNamn))
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblValutaFel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnTillbaka)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tfValuta)
                                                .addComponent(tfPolitiskStruktur)
                                                .addComponent(tfEkonomi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                                .addComponent(tfTidszon)
                                                .addComponent(tfSprak)
                                                .addComponent(tfNamn)
                                                .addComponent(lblIDFel)))))))
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblLaggTillEttLand)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblIDFel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblNamn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSprak)
                    .addComponent(tfSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValuta)
                    .addComponent(tfValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTidszon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblValutaFel)
                        .addGap(18, 18, 18)
                        .addComponent(tfTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolitiskStruktur)
                    .addComponent(tfPolitiskStruktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEkonomi)
                    .addComponent(tfEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblLaggTillLandLyckat)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTillbaka)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSpara)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new AllaLander(idb,inloggadAnvandare).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        try{
            lblIDFel.setVisible(false); 
            lblValutaFel.setVisible(false);
            lblLaggTillLandLyckat.setVisible(false);
            String textLID = tfID.getText();
            String namn = tfNamn.getText();
            String sprak = tfSprak.getText();
            String textValuta = tfValuta.getText();
            String tidszon = tfTidszon.getText();
            String politiskStruktur = tfPolitiskStruktur.getText();
            String ekonomi = tfEkonomi.getText();
            try{
                lid = Integer.parseInt(textLID);
            }
            catch(NumberFormatException ex){
                lblIDFel.setVisible(true); 
            }
            try{
                enValuta = Double.parseDouble(textValuta);
            }
            catch(NumberFormatException ex){
                lblValutaFel.setVisible(true);
            }
            String valuta = String.valueOf(enValuta);
            String checkaLID = "select lid from land where lid = " + lid + ";";
            String idFinns = idb.fetchSingle(checkaLID); 
            
            if(idFinns != null){
                lblIDFel.setVisible(true); 
            }
            

        String insertNyttLand = "insert into land (lid, namn, sprak, valuta, tidszon, politisk_struktur, ekonomi) values (" + lid + ", '" + namn + "', '" + sprak + "', '" + valuta + "', '" + tidszon + "', '" + politiskStruktur + "', '" + ekonomi + "');";
        idb.insert(insertNyttLand);

        lblLaggTillLandLyckat.setVisible(true);
        
        /*new AllaLander(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);   */ 
        }
            
        catch(InfException ex){ 
            System.out.println(ex);
        }
            
    }//GEN-LAST:event_btnSparaActionPerformed

    
    
    
    
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
            java.util.logging.Logger.getLogger(LaggTillLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaggTillLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaggTillLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaggTillLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LaggTillLand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel lblEkonomi;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDFel;
    private javax.swing.JLabel lblLaggTillEttLand;
    private javax.swing.JLabel lblLaggTillLandLyckat;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPolitiskStruktur;
    private javax.swing.JLabel lblSprak;
    private javax.swing.JLabel lblTidszon;
    private javax.swing.JLabel lblValuta;
    private javax.swing.JLabel lblValutaFel;
    private javax.swing.JTextField tfEkonomi;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNamn;
    private javax.swing.JTextField tfPolitiskStruktur;
    private javax.swing.JTextField tfSprak;
    private javax.swing.JTextField tfTidszon;
    private javax.swing.JTextField tfValuta;
    // End of variables declaration//GEN-END:variables
}
