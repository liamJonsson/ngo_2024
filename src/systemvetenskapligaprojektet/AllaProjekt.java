/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //Ska importeras till alla klasser
import oru.inf.InfException; //Samma sak här som ovan
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.awt.event.ActionEvent; //Importeras för sökfunktionen
import javax.swing.JFrame; //Importeras för att skapa nya fönster för visning av sökresultatet
import javax.swing.JList; //Importeras för att skapa en lista av alla listor
import javax.swing.JOptionPane; //Importeras för att ta emot input från sökfunktionen
import javax.swing.JScrollPane; //Importeras för för att lägga till en rullningsbar vy för JList

/**
 *
 * @author iftinserar
 */
public class AllaProjekt extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    private DefaultListModel<String> listModelID = new DefaultListModel<>();
    private DefaultListModel<String> listModelNamn = new DefaultListModel<>();
    private DefaultListModel<String> listModelBeskrivning = new DefaultListModel<>();
    private DefaultListModel<String> listModelStatus = new DefaultListModel<>();
    private DefaultListModel<String> listModelStartdatum = new DefaultListModel<>();
    private DefaultListModel<String> listModelSlutdatum = new DefaultListModel<>();
    private DefaultListModel<String> listModelPrioritet = new DefaultListModel<>();
    private DefaultListModel<String> listModelProjektchef = new DefaultListModel<>();
    private DefaultListModel<String> listModelLand = new DefaultListModel<>();
    
    /**
     * Creates new form Projekt
     */
    public AllaProjekt(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        populateListFromDatabase();
        hanteraSearchListener(); //separat metod för sök
    }
        
    public void populateListFromDatabase()
    {
        ArrayList<String> ProjektID = new ArrayList<>();
        ArrayList<String> Projektnamn = new ArrayList<>();
        ArrayList<String> Beskrivning = new ArrayList<>();
        ArrayList<String> Status = new ArrayList<>();
        ArrayList<String> Startdatum = new ArrayList<>();
        ArrayList<String> Slutdatum = new ArrayList<>();
        ArrayList<String> Prioritet = new ArrayList<>();
        ArrayList<String> Projektchef = new ArrayList<>();
        ArrayList<String> Land = new ArrayList<>();
       
        try{
            String selectpid = "select pid from projekt;";
            ProjektID = idb.fetchColumn(selectpid);

            String selectprojektnamn = "select projektnamn from projekt;";
            Projektnamn = idb.fetchColumn(selectprojektnamn);

            String selectbeskrivning = "select beskrivning from projekt;";
            Beskrivning = idb.fetchColumn(selectbeskrivning);

            String selectstatus = "select status from projekt;";
            Status = idb.fetchColumn(selectstatus);

            String selectstartdatum = "select startdatum from projekt;";
            Startdatum = idb.fetchColumn(selectstartdatum);
            
            String selectslutdatum = "select slutdatum from projekt;";
            Slutdatum = idb.fetchColumn(selectslutdatum);
            
            String selectprioritet = "select prioritet from projekt;";
            Prioritet = idb.fetchColumn(selectprioritet);
            
            String selectprojektchef = "select projektchef from projekt;";
            Projektchef = idb.fetchColumn(selectprojektchef);
            
            String selectland = "select land from projekt;";
            Land = idb.fetchColumn(selectland);
               
        }
        catch (InfException ex) {
            ex.printStackTrace();
        }

        for(String ettID:ProjektID)
        {
            listModelID.addElement(ettID);
        }
        for(String ettNamn:Projektnamn)
        {
            listModelNamn.addElement(ettNamn);
        }
        for(String ettbeskrivning:Beskrivning)
        {
            listModelBeskrivning.addElement(ettbeskrivning);
        }
        for(String ettstatus:Status)
        {
            listModelStatus.addElement(ettstatus);
        }
        for(String ettstartdatum:Startdatum)
        {
            listModelStartdatum.addElement(ettstartdatum);
        }
        for(String ettslutdatum:Slutdatum)
        {
            listModelSlutdatum.addElement(ettslutdatum);
        }
        for(String ettprioritet:Prioritet)
        {
            listModelPrioritet.addElement(ettprioritet);
        }
        for(String ettprojektchef:Projektchef)
        {
            listModelProjektchef.addElement(ettprojektchef);
        }
        for(String ettland:Land)
        {
            listModelLand.addElement(ettland);
        }
        listProjektID.setModel(listModelID);
        listProjektnamn.setModel(listModelNamn);
        listBeskrivning.setModel(listModelBeskrivning);
        listStatus.setModel(listModelStatus);
        listStartdatum.setModel(listModelStartdatum);
        listSlutdatum.setModel(listModelSlutdatum);
        listPrioritet.setModel(listModelPrioritet);
        listProjektchef.setModel(listModelProjektchef);
        listLand.setModel(listModelLand);
    }
    
    private void hanteraSearchListener() {
        btnSok.addActionListener((ActionEvent e) -> {
            String sokTerm = JOptionPane.showInputDialog("Ange datumspann (yyyy-MM-dd till yyyy-MM-dd) eller status:");
            if (sokTerm == null || sokTerm.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Du måste ange en sökterm.");
                return;
            }
            if (sokTerm.contains("till")) {
                hanteraDatumSpannSok(sokTerm);
            } else {
                hanteraStatusSok(sokTerm);
            }
        });
    }

     //Sökfunktion för datumspann
    private void hanteraDatumSpannSok(String sokTerm) {
        if (sokTerm.contains("till")) {
            String[] datum = sokTerm.split("till");
            if (datum.length == 2) {
                String startDatum = datum[0].trim();
                String slutDatum = datum[1].trim();

                DefaultListModel<String> matchandeProjekt = new DefaultListModel<>();

                for (int i = 0; i < listStartdatum.getModel().getSize(); i++) {
                    String projektStart = listStartdatum.getModel().getElementAt(i);
                    String projektSlut = listSlutdatum.getModel().getElementAt(i);

                    if (projektStart.compareTo(startDatum) >= 0 && projektSlut.compareTo(slutDatum) <= 0) {
                        String projektInfo = String.format(
                                "ID: %s, Namn: %s, Start: %s, Slut: %s",
                                listProjektID.getModel().getElementAt(i),
                                listProjektnamn.getModel().getElementAt(i),
                                projektStart,
                                projektSlut
                        );
                        matchandeProjekt.addElement(projektInfo);
                    }
                }

                if (!matchandeProjekt.isEmpty()) {
                    JFrame resultatFönster = new JFrame("Sökresultat för datumspann");
                    JList<String> resultatLista = new JList<>(matchandeProjekt);
                    resultatFönster.add(new JScrollPane(resultatLista));
                    resultatFönster.setSize(500, 400);
                    resultatFönster.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Inget projekt hittades i angivet datumspann.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Felaktigt format för datumspann. Använd 'yyyy-MM-dd till yyyy-MM-dd'.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Felaktigt format för datumspann. Använd 'yyyy-MM-dd till yyyy-MM-dd'.");
        }
}       
            

    
    private void hanteraStatusSok(String sokTerm) {
        //Sökfunktion för status
        DefaultListModel<String> matchandeProjekt = new DefaultListModel<>();

        for (int i = 0; i < listStatus.getModel().getSize(); i++) {
            if (listStatus.getModel().getElementAt(i).equalsIgnoreCase(sokTerm)) {
                String projektInfo = String.format("ID: %s, Namn: %s, Start: %s, Slut: %s, Status: %s",
                        listProjektID.getModel().getElementAt(i),
                        listProjektnamn.getModel().getElementAt(i),
                        listStartdatum.getModel().getElementAt(i),
                        listSlutdatum.getModel().getElementAt(i),
                        listStatus.getModel().getElementAt(i));
                matchandeProjekt.addElement(projektInfo);
            }
        }

        if (!matchandeProjekt.isEmpty()) {
            JFrame resultatFönster = new JFrame("Sökresultat för status");
            JList<String> resultatLista = new JList<>(matchandeProjekt);
            resultatFönster.add(new JScrollPane(resultatLista));
            resultatFönster.setSize(500, 400);
            resultatFönster.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Inga projekt hittades med status: " + sokTerm);
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

        lblProjektID = new javax.swing.JLabel();
        lblProjektNamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblStartdatum = new javax.swing.JLabel();
        lblSlutdatum = new javax.swing.JLabel();
        lblPrioritet = new javax.swing.JLabel();
        lblProjektChef = new javax.swing.JLabel();
        lblLand = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProjektID = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProjektnamn = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listBeskrivning = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listStatus = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listStartdatum = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listSlutdatum = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listPrioritet = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listProjektchef = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        listLand = new javax.swing.JList<>();
        btnSok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjektID.setText("ProjektID");

        lblProjektNamn.setText("Projektnamn");

        lblBeskrivning.setText("Beskrivning");

        lblStatus.setText("Status");

        lblStartdatum.setText("Startdatum");

        lblSlutdatum.setText("Slutdatum");

        lblPrioritet.setText("Prioritet");

        lblProjektChef.setText("Projektchef");

        lblLand.setText("Land");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        listProjektID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listProjektID);

        listProjektnamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listProjektnamn);

        listBeskrivning.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listBeskrivning);

        listStatus.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listStatus);

        listStartdatum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listStartdatum);

        listSlutdatum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(listSlutdatum);

        listPrioritet.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(listPrioritet);

        listProjektchef.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(listProjektchef);

        listLand.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(listLand);

        btnSok.setText("Sök");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSok))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSlutdatum)
                                    .addComponent(lblProjektID)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblProjektNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBeskrivning)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrioritet))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProjektChef)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLand))
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartdatum))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblProjektID)
                                    .addComponent(lblProjektNamn))
                                .addComponent(lblBeskrivning, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblStartdatum, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSlutdatum)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPrioritet)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProjektChef)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblLand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btnTillbaka)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSok)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
    new MenyAdmin(idb, inloggadAnvandare).setVisible(true);
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
            java.util.logging.Logger.getLogger(AllaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Projekt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblPrioritet;
    private javax.swing.JLabel lblProjektChef;
    private javax.swing.JLabel lblProjektID;
    private javax.swing.JLabel lblProjektNamn;
    private javax.swing.JLabel lblSlutdatum;
    private javax.swing.JLabel lblStartdatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<String> listBeskrivning;
    private javax.swing.JList<String> listLand;
    private javax.swing.JList<String> listPrioritet;
    private javax.swing.JList<String> listProjektID;
    private javax.swing.JList<String> listProjektchef;
    private javax.swing.JList<String> listProjektnamn;
    private javax.swing.JList<String> listSlutdatum;
    private javax.swing.JList<String> listStartdatum;
    private javax.swing.JList<String> listStatus;
    // End of variables declaration//GEN-END:variables
}