/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemvetenskapligaprojektet;
import oru.inf.InfDB; //importeras i alla klasser som vi ska använda
import oru.inf.InfException; //importeras i alla klasser som vi ska använda
import systemvetenskapligaprojektet.MenyAdmin;
/**
 *
 * @author limme
 */
public class MenyAdmin extends javax.swing.JFrame {
    private static InfDB idb;
    private String inloggadAnvandare;
    private AllaAvdelningar avdelningar;
    private MenyAdmin admin;
    /**
     * Creates new form MenyAdmin
     */
    public MenyAdmin(InfDB idb, String inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        avdelningar = new AllaAvdelningar(idb,inloggadAnvandare);
        initComponents();
        lblInloggadAnvandare.setText(inloggadAnvandare);
        avdelningar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinaSidor = new javax.swing.JButton();
        btnAllaAnstallda = new javax.swing.JButton();
        btnAllaAvdelningar = new javax.swing.JButton();
        btnAllaPartners = new javax.swing.JButton();
        btnAllaLander = new javax.swing.JButton();
        btnAllaProjekt = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        lblInloggadAnvandare = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMinaSidor.setText("Mina Sidor");
        btnMinaSidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinaSidorActionPerformed(evt);
            }
        });

        btnAllaAnstallda.setText("Alla Anställda");
        btnAllaAnstallda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaAnstalldaActionPerformed(evt);
            }
        });

        btnAllaAvdelningar.setText("Alla Avdelningar");
        btnAllaAvdelningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaAvdelningarActionPerformed(evt);
            }
        });

        btnAllaPartners.setText("Alla Partners");
        btnAllaPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaPartnersActionPerformed(evt);
            }
        });

        btnAllaLander.setText("Alla Länder");
        btnAllaLander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaLanderActionPerformed(evt);
            }
        });

        btnAllaProjekt.setText("Alla Projekt");
        btnAllaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaProjektActionPerformed(evt);
            }
        });

        btnLoggaUt.setText("Logga Ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLoggaUt)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInloggadAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAllaPartners, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllaLander, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllaProjekt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinaSidor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnAllaAnstallda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(btnAllaAvdelningar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblInloggadAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMinaSidor)
                .addGap(18, 18, 18)
                .addComponent(btnAllaAnstallda)
                .addGap(18, 18, 18)
                .addComponent(btnAllaAvdelningar)
                .addGap(18, 18, 18)
                .addComponent(btnAllaProjekt)
                .addGap(18, 18, 18)
                .addComponent(btnAllaLander)
                .addGap(18, 18, 18)
                .addComponent(btnAllaPartners)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnLoggaUt)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAllaAvdelningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaAvdelningarActionPerformed
        new AllaAvdelningar(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAllaAvdelningarActionPerformed

    private void btnAllaPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaPartnersActionPerformed
        new AllaPartners(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAllaPartnersActionPerformed

    private void btnMinaSidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinaSidorActionPerformed
        new MinaSidor(idb).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMinaSidorActionPerformed

    private void btnAllaAnstalldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaAnstalldaActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnAllaAnstalldaActionPerformed

    private void btnAllaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaProjektActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_btnAllaProjektActionPerformed

    private void btnAllaLanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaLanderActionPerformed
        new AllaLander(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAllaLanderActionPerformed

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        new Inloggning(idb).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLoggaUtActionPerformed

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
            java.util.logging.Logger.getLogger(MenyAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenyAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllaAnstallda;
    private javax.swing.JButton btnAllaAvdelningar;
    private javax.swing.JButton btnAllaLander;
    private javax.swing.JButton btnAllaPartners;
    private javax.swing.JButton btnAllaProjekt;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnMinaSidor;
    private javax.swing.JLabel lblInloggadAnvandare;
    // End of variables declaration//GEN-END:variables
}
