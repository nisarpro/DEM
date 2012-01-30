/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExtensionFrequencyPanel.java
 *
 * Created on Dec 20, 2011, 11:09:22 AM
 */
package edu.coeia.investigation;

import edu.coeia.cases.CaseFacade;
import edu.coeia.searching.InvestigateDialog;
import edu.coeia.task.ExtensionFrequencyTask;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 */
public class ExtensionFrequencyPanel extends javax.swing.JPanel {

    private CaseFacade caseManager; 
    private InvestigateDialog parentDialog;
    private final static Logger logger = Logger.getLogger(edu.coeia.util.FilesPath.LOG_NAMESPACE);
    
    /** Creates new form ExtensionFrequencyPanel */
    public ExtensionFrequencyPanel(InvestigateDialog dialog) {
        initComponents();
        
        this.caseManager = dialog.getCaseManager();
        this.parentDialog = dialog;
        this.disableNotIndexedComponent();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexVisualizationButtonPanel = new javax.swing.JPanel();
        indexVisulizingButton = new javax.swing.JButton();
        indexVisualizingPiePanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        indexVisualizationButtonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Files Extensions Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        indexVisulizingButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        indexVisulizingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/chart_pie.png"))); // NOI18N
        indexVisulizingButton.setText("Display File's Extensions Chart");
        indexVisulizingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexVisulizingButtonActionPerformed(evt);
            }
        });
        indexVisualizationButtonPanel.add(indexVisulizingButton);

        add(indexVisualizationButtonPanel, java.awt.BorderLayout.NORTH);

        indexVisualizingPiePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Statistical Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        indexVisualizingPiePanel.setLayout(new java.awt.BorderLayout());
        add(indexVisualizingPiePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void indexVisulizingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexVisulizingButtonActionPerformed
        this.generateVisualization();
    }//GEN-LAST:event_indexVisulizingButtonActionPerformed
    
    public void setIndexVisualizationPanel(JPanel panel) {
        indexVisualizingPiePanel.removeAll();
        indexVisualizingPiePanel.add(panel, BorderLayout.CENTER);
        indexVisualizingPiePanel.revalidate();
    }

    private void disableNotIndexedComponent() {
        if (!this.caseManager.getCase().doIndexingAfterCaseCreation()) {
            indexVisulizingButton.setEnabled(false);
        }
    }
    
    private void generateVisualization() {;
        if ( ! this.caseManager.getCaseHistory().getIsCaseIndexed() ) {
            JOptionPane.showMessageDialog(this, "please do the indexing operation first before do any operation",
                    "Case is not indexed",JOptionPane.ERROR_MESSAGE );
            return ;
        }
        
        ExtensionFrequencyTask task = new ExtensionFrequencyTask(this.caseManager, this);
        task.startTask();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel indexVisualizationButtonPanel;
    private javax.swing.JPanel indexVisualizingPiePanel;
    private javax.swing.JButton indexVisulizingButton;
    // End of variables declaration//GEN-END:variables
}
