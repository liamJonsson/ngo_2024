/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import java.util.ArrayList;
import java.lang.NumberFormatException;
/**
 *
 * @author limme
 */
public class LaggTillAvdelning extends javax.swing.JFrame {

    private InfDB idb;
    private String inloggadAnvandare;
    /**
     * Creates new form LaggTillAvdelning
     */
    public LaggTillAvdelning(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        lblAvdelningschefID = new javax.swing.JLabel();
        tfNamn = new javax.swing.JTextField();
        tfAdress = new javax.swing.JTextField();
        tfBeskrivning = new javax.swing.JTextField();
        tfEpost = new javax.swing.JTextField();
        tfTelefonnummer = new javax.swing.JTextField();
        tfStad = new javax.swing.JTextField();
        tfAvdelningschefID = new javax.swing.JTextField();
        tfID = new javax.swing.JTextField();
        btnLaggTill = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lägg till ny avdelning");

        lblID.setText("ID");

        lblNamn.setText("Namn");

        lblBeskrivning.setText("Beskrivning");

        lblAdress.setText("Adress");

        lblEpost.setText("Epost");

        lblTel.setText("Telefonnummer");

        lblStad.setText("Stad");

        lblAvdelningschefID.setText("Avdelningschef");

        tfNamn.setEditable(false);
        tfNamn.setText("Ex. Avdelning för miljöfrågor");
        tfNamn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfNamnMouseClicked(evt);
            }
        });
        tfNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamnActionPerformed(evt);
            }
        });

        tfAdress.setEditable(false);
        tfAdress.setText("Ex. NGO-gatan 3");
        tfAdress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAdressMouseClicked(evt);
            }
        });
        tfAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdressActionPerformed(evt);
            }
        });

        tfBeskrivning.setEditable(false);
        tfBeskrivning.setText("Ex. Fokuserar på att ta fram metoder för att lösa miljöproblematiken");
        tfBeskrivning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfBeskrivningMouseClicked(evt);
            }
        });

        tfEpost.setEditable(false);
        tfEpost.setText("Ex. hej@example.com");
        tfEpost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfEpostMouseClicked(evt);
            }
        });

        tfTelefonnummer.setEditable(false);
        tfTelefonnummer.setText("Ex 342-234-2344");
        tfTelefonnummer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfTelefonnummerMouseClicked(evt);
            }
        });

        tfStad.setEditable(false);
        tfStad.setText("Ex. 1");
        tfStad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfStadMouseClicked(evt);
            }
        });

        tfAvdelningschefID.setEditable(false);
        tfAvdelningschefID.setText("Ex. 1");
        tfAvdelningschefID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAvdelningschefIDMouseClicked(evt);
            }
        });

        tfID.setEditable(false);
        tfID.setText("Ex. 1");
        tfID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfIDMouseClicked(evt);
            }
        });

        btnLaggTill.setText("Lägg till");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnLaggTill)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTillbaka))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblAvdelningschefID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEpost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAdress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBeskrivning, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNamn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfID)
                                .addComponent(tfNamn)
                                .addComponent(tfBeskrivning)
                                .addComponent(tfAdress)
                                .addComponent(tfEpost)
                                .addComponent(tfTelefonnummer)
                                .addComponent(tfStad)
                                .addComponent(tfAvdelningschefID)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn)
                    .addComponent(tfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeskrivning)
                    .addComponent(tfBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpost)
                    .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTel)
                    .addComponent(tfTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStad)
                    .addComponent(tfStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvdelningschefID)
                    .addComponent(tfAvdelningschefID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLaggTill)
                    .addComponent(btnTillbaka))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new AllaAvdelningar(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void tfAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAdressActionPerformed

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
        try{
        String textID = tfID.getText();
        String namn = tfNamn.getText();
        String beskrivning = tfBeskrivning.getText();
        String adress = tfAdress.getText();
        String epost = tfEpost.getText(); //Kolla så att det verkligen är en epost-adress!
        String telefon = tfTelefonnummer.getText();
        String stad = tfStad.getText();
        String chef = tfAvdelningschefID.getText();
        
        int avdid = Integer.parseInt(textID);
        int stadsID = Integer.parseInt(stad);
        int chefsID = Integer.parseInt(chef);


        String selectStader = "select namn from stad;";
        ArrayList<String> stader = idb.fetchColumn(selectStader);
        
        for(String enStad:stader){
            if(stad.equals(enStad)){
                String selectStad = "select sid from stad where namn = '" + enStad + "';";
                stadsID = idb.fetchSingle(selectStad);
            }
        }
        
        String selectChefer = "select fornamn from anstalld;";
        ArrayList<String> chefFNamn = idb.fetchColumn(selectChefer);
              
        for(String enChef:chefFNamn){
            if(fornamn.equals(enChef)){
                String selectChef = "select aid from anstalld where epost = '" + inloggadAnvandare + "';";
                chefsID = idb.fetchSingle(selectChef);
            }
        }
        
        
        String insertNyAvdelning = "insert into avdelning (avdid,namn,beskrivning,adress,epost,telefon,stad,chef) values "
                + "(" + avdid + ",'" + namn + "','" + beskrivning + "','" + adress + "','" + epost + "','" + telefon + "',"
                + stadsID + "," + chefsID +");";
        idb.insert(insertNyAvdelning);
        }
        catch(InfException | NumberFormatException ex){ //Catch InfExceptions?
            System.out.println(ex);
        }
        new AllaAvdelningar(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void tfNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamnActionPerformed

    private void tfIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfIDMouseClicked
        tfID.setEditable(true);
        tfID.setText("");
    }//GEN-LAST:event_tfIDMouseClicked

    private void tfNamnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfNamnMouseClicked
        tfNamn.setEditable(true);
        tfNamn.setText("");
    }//GEN-LAST:event_tfNamnMouseClicked

    private void tfBeskrivningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBeskrivningMouseClicked
        tfBeskrivning.setEditable(true);
        tfBeskrivning.setText("");
    }//GEN-LAST:event_tfBeskrivningMouseClicked

    private void tfAdressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAdressMouseClicked
        tfAdress.setEditable(true);
        tfAdress.setText("");
    }//GEN-LAST:event_tfAdressMouseClicked

    private void tfEpostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEpostMouseClicked
        tfEpost.setEditable(true);
        tfEpost.setText("");
    }//GEN-LAST:event_tfEpostMouseClicked

    private void tfTelefonnummerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfTelefonnummerMouseClicked
        tfTelefonnummer.setEditable(true);
        tfTelefonnummer.setText("");
    }//GEN-LAST:event_tfTelefonnummerMouseClicked

    private void tfStadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfStadMouseClicked
        tfStad.setEditable(true);
        tfStad.setText("");
    }//GEN-LAST:event_tfStadMouseClicked

    private void tfAvdelningschefIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAvdelningschefIDMouseClicked
        tfAvdelningschefID.setEditable(true);
        tfAvdelningschefID.setText("");
    }//GEN-LAST:event_tfAvdelningschefIDMouseClicked

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
            java.util.logging.Logger.getLogger(LaggTillAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaggTillAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaggTillAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaggTillAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LaggTillAvdelning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAvdelningschefID;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfAvdelningschefID;
    private javax.swing.JTextField tfBeskrivning;
    private javax.swing.JTextField tfEpost;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNamn;
    private javax.swing.JTextField tfStad;
    private javax.swing.JTextField tfTelefonnummer;
    // End of variables declaration//GEN-END:variables
}
