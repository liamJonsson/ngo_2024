/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import javax.swing.DefaultListModel;
import java.util.ArrayList;
/**
 *
 * @author limme
 */
public class AllaAvdelningar extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    //Skapa en DefaultModel
    private DefaultListModel<String> listModelID = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelNamn = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    /**
     * Creates new form AllaAvdelningar
     */
    public AllaAvdelningar(InfDB idb, String inloggadAnvandare) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        initComponents();
        populateListFromDatabase();
    }
    
    public void populateListFromDatabase() {
        // Skapa en ArrayList för att hålla data från databasen
        ArrayList<String> avdelningsID = new ArrayList<>();
        ArrayList<String> avdelningsnamn = new ArrayList<>();
        try{
            // SQL-fråga för att hämta id
            String selectAvdid = "select avdid from avdelning;";
            avdelningsID = idb.fetchColumn(selectAvdid);
            // SQL-fråga för att hämta namnet
            String selectAvdelningsnamn = "select namn from avdelning;";
            avdelningsnamn = idb.fetchColumn(selectAvdelningsnamn);
        } 
        catch (InfException ex) {
            ex.printStackTrace();
        }
        // Lägg till data från ArrayList till modellen
        for(String ettID:avdelningsID){
            listModelID.addElement(ettID); //Loopar igenom listan avdelningsID
        }
        for(String ettNamn:avdelningsnamn){
            listModelNamn.addElement(ettNamn); //Loopar igenom listan avdelningsNamn
        }
        listAvdelningsID.setModel(listModelID); //Uppdaterar modellerna som nu innehåller data
        listAvdelningsnamn.setModel(listModelNamn); //Uppdaterar modellerna som nu innehåller data
        
        
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
        listAvdelningsID = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAvdelningsnamn = new javax.swing.JList<>();
        btnTillbaka = new javax.swing.JButton();
        btnLaggTill = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listAvdelningsID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAvdelningsID);

        listAvdelningsnamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listAvdelningsnamn);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnLaggTill.setText("Lägg Till");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        btnSok.setText("OBS SOK!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(btnLaggTill, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSok)
                        .addGap(248, 248, 248)
                        .addComponent(btnTillbaka))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTillbaka)
                    .addComponent(btnSok)
                    .addComponent(btnLaggTill))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
        new LaggTillAvdelning(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyAdmin(idb,inloggadAnvandare).setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(AllaAvdelningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllaAvdelningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllaAvdelningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllaAvdelningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AllaAvdelningar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listAvdelningsID;
    private javax.swing.JList<String> listAvdelningsnamn;
    // End of variables declaration//GEN-END:variables
}
