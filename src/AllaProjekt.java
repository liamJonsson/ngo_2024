/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //Ska importeras till alla klasser
import oru.inf.InfException; //Samma sak här som ovan
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author iftinserar
 */
public class AllaProjekt extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    
    /**
     * Creates new form Projekt
     */
    public AllaProjekt(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        hanteraSearchListener(); //separat metod för sök
        fyllTabell();
    }
        
/**
     * Fyller JTable med data från databasen.
     */
    public void fyllTabell() {
        try {
            String[] kolumnNamn = {"pid", "projektnamn", "beskrivning", "startdatum", "slutdatum", "status", "prioritet", "projektchef", "land"};
            DefaultTableModel projektTabellModel = new DefaultTableModel(kolumnNamn, 0);

            // Hämta alla projekt-ID
            String selectPid = "SELECT pid FROM projekt ORDER BY pid;";
            ArrayList<String> pidLista = idb.fetchColumn(selectPid);

            if (pidLista != null) {
                for (String ettPID : pidLista) {
                    String selectInfo = "SELECT * FROM projekt WHERE pid = " + ettPID + ";";
                    HashMap<String, String> info = idb.fetchRow(selectInfo);

                    Object[] enRad = new Object[kolumnNamn.length];
                    int index = 0;

                    for (String enKolumn : kolumnNamn) {
                        enRad[index++] = info.get(enKolumn);
                    }
                    projektTabellModel.addRow(enRad);
                }

                tblProjekt.setModel(projektTabellModel);
            }

            // Anpassa kolumnbredd
            tblProjekt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int[] kolumnBredd = {50, 150, 200, 100, 100, 100, 100, 150, 100};
            for (int i = 0; i < kolumnBredd.length; i++) {
                TableColumn col = tblProjekt.getColumnModel().getColumn(i);
                col.setPreferredWidth(kolumnBredd[i]);
            }

        } catch (InfException ex) {
            System.out.println("Ett fel uppstod: " + ex.getMessage());
        }
    }
    
  /** 
     *Hanterar sökknappen
     */
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

                DefaultTableModel modell = (DefaultTableModel) tblProjekt.getModel();
                DefaultTableModel filtreradModell = new DefaultTableModel(modell.getColumnIdentifiers(), 0);

                for (int i = 0; i < modell.getRowCount(); i++) {
                    String projektStart = modell.getValueAt(i, 3).toString();
                    String projektSlut = modell.getValueAt(i, 4).toString();

                    if (projektStart.compareTo(startDatum) >= 0 && projektSlut.compareTo(slutDatum) <= 0) {
                        filtreradModell.addRow(new Object[]{
                                modell.getValueAt(i, 0),
                                modell.getValueAt(i, 1),
                                modell.getValueAt(i, 2),
                                projektStart,
                                projektSlut,
                                modell.getValueAt(i, 5),
                                modell.getValueAt(i, 6),
                                modell.getValueAt(i, 7),
                                modell.getValueAt(i, 8)
                        });
                    }
                }

                tblProjekt.setModel(filtreradModell);
            } else {
                JOptionPane.showMessageDialog(null, "Felaktigt format för datumspann. Använd 'yyyy-MM-dd till yyyy-MM-dd'.");
            }
        }
    }    
            

    
    private void hanteraStatusSok(String sokTerm) {
        DefaultTableModel modell = (DefaultTableModel) tblProjekt.getModel();
        DefaultTableModel filtreradModell = new DefaultTableModel(modell.getColumnIdentifiers(), 0);

        for (int i = 0; i < modell.getRowCount(); i++) {
            String status = modell.getValueAt(i, 5).toString();
            if (status.equalsIgnoreCase(sokTerm)) {
                filtreradModell.addRow(new Object[]{
                        modell.getValueAt(i, 0),
                        modell.getValueAt(i, 1),
                        modell.getValueAt(i, 2),
                        modell.getValueAt(i, 3),
                        modell.getValueAt(i, 4),
                        status,
                        modell.getValueAt(i, 6),
                        modell.getValueAt(i, 7),
                        modell.getValueAt(i, 8)
                });
            }
        }

        tblProjekt.setModel(filtreradModell);
    }

    private JTable tblProjekt;
    private JButton btnSok;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTillbaka = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProjekt = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnSok.setText("Sök");

        TblProjekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(TblProjekt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTillbaka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 652, Short.MAX_VALUE)
                .addComponent(btnSok)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JTable TblProjekt;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
