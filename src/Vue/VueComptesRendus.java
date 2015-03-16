/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controleur.CtrlAbstrait;
import Controleur.CtrlComptesRendus;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author btssio
 */
public class VueComptesRendus extends VueAbstrait {
    
    protected CtrlComptesRendus ctrlCR;

    /**
     * Creates new form VueVisiteur
     */
    public VueComptesRendus(CtrlAbstrait ctrlA) {
        super(ctrlA);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelTitre = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPraticien = new javax.swing.JLabel();
        jLabelMotifVisite = new javax.swing.JLabel();
        jLabelBilan = new javax.swing.JLabel();
        jTextFieldDateRapport = new javax.swing.JTextField();
        jTextFieldMotifVis = new javax.swing.JTextField();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabelDateRapport = new javax.swing.JLabel();
        jTextFieldNumRapport = new javax.swing.JTextField();
        jLabelNumeroRapport = new javax.swing.JLabel();
        jComboBoxPracticien = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBilan = new javax.swing.JTextArea();
        jButtonNew = new javax.swing.JButton();
        jButtonDetails = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonSauvegarder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTitre.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Rapports de Visites");

        javax.swing.GroupLayout jPanelTitreLayout = new javax.swing.GroupLayout(jPanelTitre);
        jPanelTitre.setLayout(jPanelTitreLayout);
        jPanelTitreLayout.setHorizontalGroup(
            jPanelTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitreLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel1)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanelTitreLayout.setVerticalGroup(
            jPanelTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabelPraticien.setText("Practicien");

        jLabelMotifVisite.setText("Motif Visite");

        jLabelBilan.setText("Bilan");

        jButtonPrevious.setText("Précédent");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jButtonNext.setText("Suivant");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonClose.setText("Fermer");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabelDateRapport.setText("Date Rapport");

        jLabelNumeroRapport.setText("Numéro Rapport");

        jTextAreaBilan.setColumns(20);
        jTextAreaBilan.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBilan);

        jButtonNew.setText("Nouveau");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Détails");
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Médicament", "Nb. Echantillons"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButtonSauvegarder.setText("Sauvegarder");
        jButtonSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSauvegarderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMotifVisite)
                            .addComponent(jLabelBilan)
                            .addComponent(jLabelPraticien)
                            .addComponent(jLabelNumeroRapport)
                            .addComponent(jLabelDateRapport))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxPracticien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDateRapport, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMotifVis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNumRapport, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrevious)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNew)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDetails)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonSauvegarder)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClose))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNumeroRapport)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPraticien)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDateRapport)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMotifVisite)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelBilan))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNumRapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPracticien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDetails))
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDateRapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMotifVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrevious)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonNew)
                    .addComponent(jButtonSauvegarder)
                    .addComponent(jButtonClose))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        ctrlCR.nouveauRapport();
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSauvegarderActionPerformed
        ctrlCR.sauvegarderRapport();
    }//GEN-LAST:event_jButtonSauvegarderActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        ctrlCR.close();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    public CtrlComptesRendus getCtrl() {
        return ctrlCR;
    }

    public void setCtrl(CtrlComptesRendus ctrlCR) {
        this.ctrlCR = ctrlCR;
    }    

    public JButton getjButtonClose() {
        return jButtonClose;
    }

    public void setjButtonClose(JButton jButtonClose) {
        this.jButtonClose = jButtonClose;
    }

    public JButton getjButtonDetails() {
        return jButtonDetails;
    }

    public void setjButtonDetails(JButton jButtonDetails) {
        this.jButtonDetails = jButtonDetails;
    }

    public JButton getjButtonNew() {
        return jButtonNew;
    }

    public void setjButtonNew(JButton jButtonNew) {
        this.jButtonNew = jButtonNew;
    }

    public JButton getjButtonNext() {
        return jButtonNext;
    }

    public void setjButtonNext(JButton jButtonNext) {
        this.jButtonNext = jButtonNext;
    }

    public JButton getjButtonPrevious() {
        return jButtonPrevious;
    }

    public void setjButtonPrevious(JButton jButtonPrevious) {
        this.jButtonPrevious = jButtonPrevious;
    }

    public JButton getjButtonSauvegarder() {
        return jButtonSauvegarder;
    }

    public void setjButtonSauvegarder(JButton jButtonSauvegarder) {
        this.jButtonSauvegarder = jButtonSauvegarder;
    }

    public JComboBox getjComboBoxPracticien() {
        return jComboBoxPracticien;
    }

    public void setjComboBoxPracticien(JComboBox jComboBoxPracticien) {
        this.jComboBoxPracticien = jComboBoxPracticien;
    }

    public JTextArea getjTextAreaBilan() {
        return jTextAreaBilan;
    }

    public void setjTextAreaBilan(JTextArea jTextAreaBilan) {
        this.jTextAreaBilan = jTextAreaBilan;
    }

    public JTextField getjTextFieldDateRapport() {
        return jTextFieldDateRapport;
    }

    public void setjTextFieldDateRapport(JTextField jTextFieldDateRapport) {
        this.jTextFieldDateRapport = jTextFieldDateRapport;
    }

    public JTextField getjTextFieldMotifVis() {
        return jTextFieldMotifVis;
    }

    public void setjTextFieldMotifVis(JTextField jTextFieldMotifVis) {
        this.jTextFieldMotifVis = jTextFieldMotifVis;
    }

    public JTextField getjTextFieldNumRapport() {
        return jTextFieldNumRapport;
    }

    public void setjTextFieldNumRapport(JTextField jTextFieldNumRapport) {
        this.jTextFieldNumRapport = jTextFieldNumRapport;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSauvegarder;
    private javax.swing.JComboBox jComboBoxPracticien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBilan;
    private javax.swing.JLabel jLabelDateRapport;
    private javax.swing.JLabel jLabelMotifVisite;
    private javax.swing.JLabel jLabelNumeroRapport;
    private javax.swing.JLabel jLabelPraticien;
    private javax.swing.JPanel jPanelTitre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaBilan;
    private javax.swing.JTextField jTextFieldDateRapport;
    private javax.swing.JTextField jTextFieldMotifVis;
    private javax.swing.JTextField jTextFieldNumRapport;
    // End of variables declaration//GEN-END:variables
}
