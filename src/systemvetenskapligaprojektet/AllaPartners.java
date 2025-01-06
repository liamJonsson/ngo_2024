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
 * @author meam
 */
public class AllaPartners extends javax.swing.JFrame {

    private static InfDB idb;
    private String inloggadAnvandare;
    //Skapa en DefaultModel
    private DefaultListModel<String> listModelId = new DefaultListModel<>(); //Skapar list modeller som kan visas i gränssnittet
    private DefaultListModel<String> listModelNamn = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelKontaktperson = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelKontaktepost = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelTelefonnummer = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelAdress = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelBranch = new DefaultListModel<>(); 
    private DefaultListModel<String> listModelStad = new DefaultListModel<>();
    
    
    public AllaPartners(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        laggTillDataLista();
    }
    
    private void laggTillDataLista(){
         // Skapa en ArrayList för att hålla data från databasen
        ArrayList<String> partnerId = new ArrayList<>();
        ArrayList<String> partnerNamn = new ArrayList<>();
        ArrayList<String> partnerKontaktperson = new ArrayList<>();
        ArrayList<String> partnerKontaktepost = new ArrayList<>();
        ArrayList<String> partnerTelefonnummer = new ArrayList<>();
        ArrayList<String> partnerAdress = new ArrayList<>();
        ArrayList<String> partnerBranch = new ArrayList<>();
        ArrayList<String> partnerStad = new ArrayList<>();
        
        try{
            // SQL-fråga för att hämta id
            String selectPid = "select pid from partner;";
            partnerId = idb.fetchColumn(selectPid);
            // SQL-fråga för att hämta namnet
            String selectPartnerNamn = "select namn from partner;";
            partnerNamn = idb.fetchColumn(selectPartnerNamn);
            
            String selectKontaktperson = "select kontaktperson from partner;";
            partnerKontaktperson = idb.fetchColumn(selectKontaktperson);
            
            String selectKontaktepost = "select kontaktepost from partner;";
            partnerKontaktepost = idb.fetchColumn(selectKontaktepost);
            
            String selectTelefon = "select telefon from partner;";
            partnerTelefonnummer = idb.fetchColumn(selectTelefon);
            
            String selectAdress = "select adress from partner;";
            partnerAdress = idb.fetchColumn(selectAdress);
            
            String selectBranch = "select branch from partner;";
            partnerBranch = idb.fetchColumn(selectBranch);
            
            String selectStad = "select stad from partner;";
            partnerStad = idb.fetchColumn(selectStad);
            
            
        } 
        catch (InfException ex) {
            System.out.println(ex);
        }
        // Lägg till data från ArrayList till modellen
        for(String ettId: partnerId){
            listModelId.addElement(ettId); //Loopar igenom listan partnerIdö
        }
        for(String ettNamn : partnerNamn){
            listModelNamn.addElement(ettNamn); 
        }
        for(String enKontaktperson : partnerKontaktperson){
            listModelKontaktperson.addElement(enKontaktperson);
        }    
        for(String enKontaktepost : partnerKontaktepost){
            listModelKontaktepost.addElement(enKontaktepost);
        }    
        for(String ettTelefonnummer : partnerTelefonnummer){
            listModelTelefonnummer.addElement(ettTelefonnummer); 
        }
        for(String enAdress : partnerAdress){
            listModelAdress.addElement(enAdress);
        }   
        for(String enBranch : partnerBranch){
            listModelBranch.addElement(enBranch);  
        }
        for(String enStad : partnerStad){
            listModelStad.addElement(enStad);    
        }
        
        listId.setModel(listModelId); //Uppdaterar modellerna som nu innehåller data
        listNamn.setModel(listModelNamn); //Uppdaterar modellerna som nu innehåller data
        listKontaktperson.setModel(listModelKontaktperson);
        listKontaktepost.setModel(listModelKontaktepost);
        listTelefonnummer.setModel(listModelTelefonnummer);
        listAdress.setModel(listModelAdress);
        listBranch.setModel(listModelBranch);
        listStad.setModel(listModelStad);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblKontaktperson = new javax.swing.JLabel();
        lblKontaktepost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listId = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNamn = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listKontaktperson = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listKontaktepost = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listTelefonnummer = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listAdress = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        listBranch = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        listStad = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList6);

        jList8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Partners");

        lblID.setText("ID");

        lblNamn.setText("Namn");

        lblKontaktperson.setText("Kontaktperson");

        lblKontaktepost.setText("Kontaktepost");

        lblTelefon.setText("Telefonnummer");

        lblAdress.setText("Adress");

        lblBranch.setText("Branch");

        lblStad.setText("Stad");

        listId.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listId);

        listNamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listNamn);

        listKontaktperson.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listKontaktperson);

        listKontaktepost.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listKontaktepost);

        listTelefonnummer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listTelefonnummer);

        listAdress.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(listAdress);

        listBranch.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(listBranch);

        listStad.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(listStad);

        jButton1.setText("Redigera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Lägg till");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ta bort");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Tillbaka");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(lblKontaktperson)
                        .addGap(90, 90, 90)
                        .addComponent(lblKontaktepost, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(lblTelefon)
                        .addGap(98, 98, 98)
                        .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(lblBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(lblStad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblNamn)
                    .addComponent(lblKontaktperson)
                    .addComponent(lblBranch)
                    .addComponent(lblStad)
                    .addComponent(lblTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdress)
                    .addComponent(lblKontaktepost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane9)
                    .addComponent(jScrollPane10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new LaggTillPartner(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new MenyAdmin(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AllaPartners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllaPartners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllaPartners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllaPartners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AllaPartners().setVisible(true);.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblKontaktepost;
    private javax.swing.JLabel lblKontaktperson;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JList<String> listAdress;
    private javax.swing.JList<String> listBranch;
    private javax.swing.JList<String> listId;
    private javax.swing.JList<String> listKontaktepost;
    private javax.swing.JList<String> listKontaktperson;
    private javax.swing.JList<String> listNamn;
    private javax.swing.JList<String> listStad;
    private javax.swing.JList<String> listTelefonnummer;
    // End of variables declaration//GEN-END:variables
}

delete from anstalld  where aid = .....