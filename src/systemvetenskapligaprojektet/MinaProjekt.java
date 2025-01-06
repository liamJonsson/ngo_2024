/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.*;

/**
 *
 * @author limme
 */
public class MinaProjekt extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    private DefaultListModel<String> listModelNamn = new DefaultListModel<>();
    private JComboBox<String> comboStatusFilter;



    
    public MinaProjekt(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        initComp();
        populateListFromDatabase();
    }
    
private void initComp() {
    // Skapa och konfigurera comboStatusFilter
    comboStatusFilter = new JComboBox<>();
    comboStatusFilter.setBounds(150, 20, 150, 25); // Anpassa placering och storlek
    
    // Lägg till i fönstret
    getContentPane().add(comboStatusFilter);
    
    // Hämta status från databasen och fyll JComboBox
    try {
        String query = "SELECT DISTINCT status FROM projekt";
        ArrayList<String> statusList = idb.fetchColumn(query);
        
        if (statusList != null) {
            for (String status : statusList) {
                comboStatusFilter.addItem(status);
            }
        }
    } catch (InfException ex) {
        JOptionPane.showMessageDialog(null, "Kunde inte hämta status från databasen: " + ex.getMessage());
        ex.printStackTrace();
    }
    
    // Lägg till ActionListener för filtrering
    comboStatusFilter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedStatus = (String) comboStatusFilter.getSelectedItem();
            if (selectedStatus != null && !selectedStatus.isEmpty()) {
                filtreraStatus(selectedStatus);
            } else {
                populateListFromDatabase();
            }
        }
    });
}
    
public void populateListFromDatabase() {
    ArrayList<String> Projektnamn = new ArrayList<>();

    try {
        String selectProjektnamn = 
            "SELECT p.projektnamn " +
            "FROM projekt p " +
            "INNER JOIN ans_proj pa ON p.pid = pa.pid " +
            "INNER JOIN anstalld a ON pa.aid = a.aid " +
            "WHERE a.epost = '" + inloggadAnvandare + "'";

        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(selectProjektnamn);

        if (resultat != null && !resultat.isEmpty()) {
            for (HashMap<String, String> row : resultat) {
                String projektnamn = row.get("projektnamn") != null ? row.get("projektnamn") : "Okänt namn";
                Projektnamn.add(projektnamn);
            }
        } else {
            System.out.println("Inga projekt hittades för användaren: " + inloggadAnvandare + "@example.com");
        }

    } catch (InfException ex) {
        System.out.println("Fel i SQL-fråga: " + ex.getMessage());
        ex.printStackTrace();
    }

    // Rensa och uppdatera listmodellen
    listModelNamn.clear();
    for (String ettNamn : Projektnamn) {
        listModelNamn.addElement(ettNamn);
    }

    listProjektnamn.setModel(listModelNamn);
}
    
private void filtreraStatus(String valdStatus) {
    if (valdStatus == null || valdStatus.isEmpty()) {
        populateListFromDatabase();
        return;
    }
    
    DefaultListModel<String> filtreradeNamn = new DefaultListModel<>();
    
    try {
        String sqlFraga = 
            "SELECT p.projektnamn " +
            "FROM projekt p " +
            "INNER JOIN ans_proj pa ON p.pid = pa.pid " +
            "INNER JOIN anstalld a ON pa.aid = a.aid " +
            "WHERE a.epost = '" + inloggadAnvandare + "' AND p.status = '" + valdStatus + "'";
        
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(sqlFraga);

        if (resultat != null && !resultat.isEmpty()) {
            for (HashMap<String, String> row : resultat) {
                String projektnamn = row.get("projektnamn") != null ? row.get("projektnamn") : "Okänt namn";
                filtreradeNamn.addElement(projektnamn);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inga projekt hittades med status: " + valdStatus);
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Ett fel uppstod: " + e.getMessage());
        e.printStackTrace();
    }

    listProjektnamn.setModel(filtreradeNamn);
}

    private boolean arProjektchefForProjekt(String projektID) {
    try {
        String query = "SELECT projektchef FROM projekt WHERE pid = '" + projektID + "'";
        String projektchef = idb.fetchSingle(query);
        return inloggadAnvandare.equals(projektchef);
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Kunde inte verifiera projektchef: " + e.getMessage());
        return false;
    }
}
    
    private void konfigurerKnappSynlighet() {
    // Kontrollera roller
    boolean arProjektchef = anvandarRoller.contains("projektchef");
    boolean arHandlaggare = anvandarRoller.contains("handläggare");
    
    // Lägg till: Synlig endast för projektchef
    btnLaggTillProjekt.setVisible(arProjektchef);

    // Ta bort & ändra beroende på projektansvar
    if (arProjektchef) {
        btnTaBortProjekt.setVisible(true);
        btnAndraProjekt.setVisible(true);
    } else {
        btnTaBortProjekt.setVisible(false);
        btnAndraProjekt.setVisible(false);
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

        lblProjektnamn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProjektnamn = new javax.swing.JList<>();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjektnamn.setText("Projektnamn");

        listProjektnamn.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listProjektnamn);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTillbaka))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProjektnamn)
                                .addGap(84, 277, Short.MAX_VALUE)))))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblProjektnamn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
    new MenyHandlaggare(idb, inloggadAnvandare).setVisible(true);
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
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MinaProjekt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProjektnamn;
    private javax.swing.JList<String> listProjektnamn;
    // End of variables declaration//GEN-END:variables
}
