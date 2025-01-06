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
 * @author lisas
 */
public class AllaAnstallda extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    
    private DefaultListModel<String> listModelID = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelFornamn = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelEfternamn = new DefaultListModel<>();
    private DefaultListModel<String> listModelAdress = new DefaultListModel<>();
    private DefaultListModel<String> listModelEpost = new DefaultListModel<>();
    private DefaultListModel<String> listModelTelefon = new DefaultListModel<>();
    private DefaultListModel<String> listModelAnstallningsdatum = new DefaultListModel<>();
    private DefaultListModel<String> listModelLosenord = new DefaultListModel<>();
    private DefaultListModel<String> listModelAvdelning = new DefaultListModel<>();
    
    public AllaAnstallda(InfDB idb, String inloggadAnvandare) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        initComponents();
        populateListFromDatabase();
    }
    
    public void populateListFromDatabase() {
        // Skapa en ArrayList för att hålla data från databasen
        ArrayList<String> anstallningsID = new ArrayList<>();
        ArrayList<String> anstallningsFornamn = new ArrayList<>();
        ArrayList<String> anstallningsEfternamn = new ArrayList<>();
        ArrayList<String> anstallningsAdress = new ArrayList<>();
        ArrayList<String> anstallningsEpost = new ArrayList<>();
        ArrayList<String> anstallningsTelefon = new ArrayList<>();
        ArrayList<String> anstallningsDatum = new ArrayList<>();
        ArrayList<String> anstallningsLosenord = new ArrayList<>();
        ArrayList<String> anstallningsAvdelning = new ArrayList<>();
        

    try{
            // SQL-fråga för att hämta id
            String selectAdid = "select aid from anstalld order by (aid) asc;";
            anstallningsID = idb.fetchColumn(selectAdid);
            // SQL-fråga för att hämta namnet
            String selectFornamn = "select fornamn from anstalld;";
            anstallningsFornamn = idb.fetchColumn(selectFornamn);
            
            String selectEfternamn = "select efternamn from anstalld;";
            anstallningsEfternamn = idb.fetchColumn(selectEfternamn);
            
            String selectAnstallningsadress = "select adress from anstalld";
            anstallningsAdress = idb.fetchColumn(selectAnstallningsadress);
            
            String selectAnstallningsEpost = "select epost from anstalld";
            anstallningsEpost = idb.fetchColumn(selectAnstallningsEpost);
            
            String selectAnstallningsTelefon = "select telefon from anstalld";
            anstallningsTelefon = idb.fetchColumn(selectAnstallningsTelefon);
            
            String selectAnstallningsDatum = "select anstallningsdatum from anstalld";
            anstallningsDatum = idb.fetchColumn(selectAnstallningsDatum);
            
            String selectAnstallningsLosenord = "select losenord from anstalld";
            anstallningsLosenord = idb.fetchColumn(selectAnstallningsLosenord);
            
            String selectAvdelning = "select avdelning from anstalld order by(aid) asc;";
            anstallningsAvdelning = idb.fetchColumn(selectAvdelning);
            } 
        
        catch (InfException ex) {
            ex.printStackTrace();
            
        }
    
        // Lägg till data från ArrayList till modellen
        for(String ettID:anstallningsID){
            listModelID.addElement(ettID); //Loopar igenom listan anstallningsID
        }
        
        
        for(String ettFornamn:anstallningsFornamn){
            listModelFornamn.addElement(ettFornamn); //Loopar igenom listan anstallningsNamn
        }
        
        
        for(String ettEfternamn:anstallningsEfternamn){
            listModelEfternamn.addElement(ettEfternamn);
        }
        
        
        for(String enAdress:anstallningsAdress){
            listModelAdress.addElement(enAdress); //Loopar igenom listan anstallningsAdress
        }
        
        for(String enEpost:anstallningsEpost){
            listModelEpost.addElement(enEpost); //Loopar igenom listan anstallningsEpost
        }
        
        
        for(String enTelefon:anstallningsTelefon){
            listModelTelefon.addElement(enTelefon); //Loopar igenom listan anstallningsTelefon
        }
        
        for(String ettDatum:anstallningsDatum){
            listModelAnstallningsdatum.addElement(ettDatum); //Loopar igenom listan anstallningsDatum
        }
        
        
        for(String ettLosenord:anstallningsLosenord){
            listModelLosenord.addElement(ettLosenord); //Loopar igenom listan anstallningsLosenord
        }
        
        for(String enAvdelning:anstallningsAvdelning){
            listModelAvdelning.addElement(enAvdelning); //Loopar igenom listan anstallningsAvdelning
        }
   
        
        
        listAnstallningsID.setModel(listModelID); //Uppdaterar modellerna som nu innehåller data
        listFornamn.setModel(listModelFornamn); //Uppdaterar modellerna som nu innehåller data
        listEfternamn.setModel(listModelEfternamn);
        listAnstallningsAdress.setModel(listModelAdress);
        listAnstallningsEpost.setModel(listModelEpost);
        listAnstallningsTelefon.setModel(listModelTelefon);
        listAnstallningsDatum.setModel(listModelAnstallningsdatum);
        listAnstallningsLosenord.setModel(listModelLosenord);
        listAnstallningsAvdelning.setModel(listModelAvdelning);
        
        //addasdas
      //  listAllt.setModel(listModelAllt);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAnstallningsID = new javax.swing.JList<>();
        lblID = new javax.swing.JLabel();
        lblFornamn = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblAvdelning = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEfternamn = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAnstallningsAvdelning = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listAnstallningsDatum = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listAnstallningsAdress = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listAnstallningsEpost = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listAnstallningsTelefon = new javax.swing.JList<>();
        lblEpost = new javax.swing.JLabel();
        btnLaggTill = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        lblAllaAnstallda = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        listAnstallningsLosenord = new javax.swing.JList<>();
        lblAdress1 = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        listFornamn = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        listAllt = new javax.swing.JList<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane8.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listAnstallningsID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAnstallningsID);

        lblID.setText("ID");

        lblFornamn.setText("Förnamn");

        lblAdress.setText(" Adress");

        lblAvdelning.setText("Avdelning");

        lblTelefon.setText("Telefon");

        lblLosenord.setText("Lösenord");

        listEfternamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listEfternamn);

        listAnstallningsAvdelning.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listAnstallningsAvdelning);

        listAnstallningsDatum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listAnstallningsDatum);

        listAnstallningsAdress.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listAnstallningsAdress);

        listAnstallningsEpost.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(listAnstallningsEpost);

        listAnstallningsTelefon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(listAnstallningsTelefon);

        lblEpost.setText("Epost");

        btnLaggTill.setText("Lägg Till");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        btnSok.setText("Sök");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        lblAllaAnstallda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllaAnstallda.setText("Alla anställda");

        listAnstallningsLosenord.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(listAnstallningsLosenord);

        lblAdress1.setText(" Anst. datum");

        lblEfternamn.setText("Efternamn");

        listFornamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane11.setViewportView(listFornamn);

        listAllt.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(listAllt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(lblAllaAnstallda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLaggTill)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSok))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lblID)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(lblFornamn)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(lblEfternamn)
                                                .addGap(82, 82, 82)
                                                .addComponent(lblAdress))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblEpost)
                                                .addGap(38, 38, 38)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTelefon)
                                                .addGap(63, 63, 63)
                                                .addComponent(lblAdress1)
                                                .addGap(63, 63, 63)
                                                .addComponent(lblLosenord)
                                                .addGap(43, 43, 43)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAvdelning)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTillbaka)
                                        .addGap(6, 6, 6)))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAllaAnstallda)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornamn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblAdress1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLosenord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAvdelning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEfternamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTelefon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEpost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLaggTill)
                            .addComponent(btnTillbaka)
                            .addComponent(btnSok))
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Tillbaka till förgående sida
    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyAdmin(idb,inloggadAnvandare).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    //Lägg till en Anställd
    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
       new LaggTillAnstalld(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaggTillActionPerformed

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(AllaAnstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllaAnstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllaAnstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllaAnstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllaAnstallda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAdress1;
    private javax.swing.JLabel lblAllaAnstallda;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JList<String> listAllt;
    private javax.swing.JList<String> listAnstallningsAdress;
    private javax.swing.JList<String> listAnstallningsAvdelning;
    private javax.swing.JList<String> listAnstallningsDatum;
    private javax.swing.JList<String> listAnstallningsEpost;
    private javax.swing.JList<String> listAnstallningsID;
    private javax.swing.JList<String> listAnstallningsLosenord;
    private javax.swing.JList<String> listAnstallningsTelefon;
    private javax.swing.JList<String> listEfternamn;
    private javax.swing.JList<String> listFornamn;
    // End of variables declaration//GEN-END:variables
}
