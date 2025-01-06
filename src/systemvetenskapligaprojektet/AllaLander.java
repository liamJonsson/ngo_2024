/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SpringLayout;
/**
 *
 * @author limme
 */
public class AllaLander extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    private DefaultListModel<String> listModelID = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelNamn = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelSprak = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelValuta = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelTidzon = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelPolitiskStruktur = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelEkonomi = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet

    /**
     * Creates new form AllaLander
     */
    public AllaLander(InfDB idb, String inloggadAnvandare) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        initComponents();
        allaLander();
    }

    public void allaLander(){
        ArrayList<String> landsID = new ArrayList<>();
        ArrayList<String> land = new ArrayList<>();
        ArrayList<String> sprak = new ArrayList<>();
        ArrayList<String> valuta = new ArrayList<>();
        ArrayList<String> tidzon = new ArrayList<>();
        ArrayList<String> politiskStruktur = new ArrayList<>();
        ArrayList<String> ekonomi = new ArrayList<>();
        
        try{
            // SQL-fråga för att hämta id
            String selectLid = "select lid from land order by(lid) asc;";
            landsID = idb.fetchColumn(selectLid);
            // SQL-fråga för att hämta namnet
            String selectLand = "select namn from land;";
            land = idb.fetchColumn(selectLand);
            
            String selectSprak = "select sprak from land;";
            sprak = idb.fetchColumn(selectSprak);
            
            String selectValuta = "select valuta from land;";
            valuta = idb.fetchColumn(selectValuta);
            
            String selectTidzon = "select tidzon from land;";
            tidzon = idb.fetchColumn(selectTidzon);
            
            String selectPolitiskStruktur = "select politisk_struktur from land;";
            politiskStruktur = idb.fetchColumn(selectPolitiskStruktur);
            
            String selectEkonomi = "select ekonomi from land;";
            ekonomi = idb.fetchColumn(selectEkonomi);         
        
        // Lägg till data från ArrayList till modellen
        for(String ettID:landsID){
            listModelID.addElement(ettID);
        }
        for(String ettLand:land){
            listModelNamn.addElement(ettLand); 
        }
        for(String ettSprak:sprak){
            listModelSprak.addElement(ettSprak);
        }
        for(String enValuta:valuta){
            listModelValuta.addElement(enValuta); 
        }
        for(String enTidzon:tidzon){
            listModelTidzon.addElement(enTidzon); 
        }
        for(String enPolitiskStruktur:politiskStruktur){
            listModelPolitiskStruktur.addElement(enPolitiskStruktur);
        }
        for(String enEkonomi:ekonomi){
            listModelEkonomi.addElement(enEkonomi);
        }
        /*for(String enAvdelning:allaAvdelningar){
            int ettAvdelningsID = Integer.parseInt(enAvdelning);
            String selectStad = "select stad from avdelning where avdid = " + ettAvdelningsID + ";";
            String stad = idb.fetchSingle(selectStad);
            int stadsID = Integer.parseInt(stad);
            String selectStadsNamn = "select namn from stad where sid = " + stadsID + ";";
            String stadsNamn = idb.fetchSingle(selectStadsNamn);
            listModelStad.addElement(stadsNamn);
        }
        for(String enAvdelning:allaAvdelningar){
            int ettAvdelningsID = Integer.parseInt(enAvdelning);
            String selectChef = "select chef from avdelning where avdid = " + ettAvdelningsID + ";";
            String chef = idb.fetchSingle(selectChef);
            int chefsID = Integer.parseInt(chef);
            String selectChefsFornamn = "select fornamn from anstalld where aid = " + chefsID + ";";
            String chefsFornamn = idb.fetchSingle(selectChefsFornamn);
            listModelAvdelningschefFNamn.addElement(chefsFornamn); //Loopar igenom listan avdelningsNamn
        }
        for(String enAvdelning:allaAvdelningar){
            int ettAvdelningsID = Integer.parseInt(enAvdelning);
            String selectChef = "select chef from avdelning where avdid = " + ettAvdelningsID + ";";
            String chef = idb.fetchSingle(selectChef);
            int chefsID = Integer.parseInt(chef);
            String selectChefsEfternamn = "select efternamn from anstalld where aid = " + chefsID + ";";
            String chefsEfternamn = idb.fetchSingle(selectChefsEfternamn);
            listModelAvdelningschefENamn.addElement(chefsEfternamn); //Loopar igenom listan avdelningsNamn
        }*/
        listID.setModel(listModelID);
        listNamn.setModel(listModelNamn);     
        listSprak.setModel(listModelSprak);
        listValuta.setModel(listModelValuta);
        listTidzon.setModel(listModelTidzon);
        listPolitiskStruktur.setModel(listModelPolitiskStruktur);
        listEkonomi.setModel(listModelEkonomi); 
        }
        catch (InfException ex) {
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblSprak = new javax.swing.JLabel();
        lblValuta = new javax.swing.JLabel();
        lblTidzon = new javax.swing.JLabel();
        lblPolitiskStruktur = new javax.swing.JLabel();
        lblEkonomi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listID = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNamn = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSprak = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listValuta = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTidzon = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listPolitiskStruktur = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listEkonomi = new javax.swing.JList<>();
        btnLaggTIll = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();
        btnRedigera = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Alla Länder");

        lblID.setText("ID");

        lblNamn.setText("Namn");

        lblSprak.setText("Språk");

        lblValuta.setText("Valuta");

        lblTidzon.setText("Tidzon");

        lblPolitiskStruktur.setText("Politisk struktur");

        lblEkonomi.setText("Ekonomi");

        listID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listID);

        listNamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listNamn);

        listSprak.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listSprak);

        listValuta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listValuta);

        listTidzon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listTidzon);

        listPolitiskStruktur.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(listPolitiskStruktur);

        listEkonomi.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(listEkonomi);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addGap(18, 18, 18)
                                .addComponent(lblNamn)
                                .addGap(18, 18, 18)
                                .addComponent(lblSprak)
                                .addGap(18, 18, 18)
                                .addComponent(lblValuta)
                                .addGap(18, 18, 18)
                                .addComponent(lblTidzon)
                                .addGap(18, 18, 18)
                                .addComponent(lblPolitiskStruktur))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEkonomi)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLaggTIll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRedigera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTillbaka)))
                .addContainerGap(610, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(lblNamn)
                            .addComponent(lblSprak)
                            .addComponent(lblValuta)
                            .addComponent(lblTidzon)
                            .addComponent(lblPolitiskStruktur)
                            .addComponent(lblEkonomi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLaggTIll)
                    .addComponent(btnSok)
                    .addComponent(btnRedigera)
                    .addComponent(btnTillbaka))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblEkonomi;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPolitiskStruktur;
    private javax.swing.JLabel lblSprak;
    private javax.swing.JLabel lblTidzon;
    private javax.swing.JLabel lblValuta;
    private javax.swing.JList<String> listEkonomi;
    private javax.swing.JList<String> listID;
    private javax.swing.JList<String> listNamn;
    private javax.swing.JList<String> listPolitiskStruktur;
    private javax.swing.JList<String> listSprak;
    private javax.swing.JList<String> listTidzon;
    private javax.swing.JList<String> listValuta;
    // End of variables declaration//GEN-END:variables
}
