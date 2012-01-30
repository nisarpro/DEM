/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InvestigateDialog.java
 *
 * Created on Dec 20, 2011, 9:56:23 AM
 */
package edu.coeia.searching;

import edu.coeia.cases.CaseFacade;
import edu.coeia.investigation.CommonKeywordsPanel;
import edu.coeia.investigation.ExtensionFrequencyPanel;

import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 */
public class InvestigateDialog extends javax.swing.JDialog {

    private final CaseFacade caseFacade;
    private final AdvancedSearchPanel parentPanel;
    private final static Logger logger = Logger.getLogger(edu.coeia.util.FilesPath.LOG_NAMESPACE);
    
    /** Creates new form InvestigateDialog */
    public InvestigateDialog(java.awt.Frame parent, boolean modal, AdvancedSearchPanel panel) {
        super(parent, modal);
        initComponents();
        
        this.parentPanel = panel;
        this.caseFacade = this.parentPanel.getCaseFacade();
        
        CommonKeywordsPanel commonKeywordsPanel = new CommonKeywordsPanel(this, this.parentPanel);
        ExtensionFrequencyPanel extensionFrequencyPanel = new ExtensionFrequencyPanel(this);
        
        this.investigateTappedPane.add("Common Keywords", commonKeywordsPanel);
        this.investigateTappedPane.add("Extensions Frequencies", extensionFrequencyPanel);
        this.pack();
        
        this.setLocationRelativeTo(parent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        investigateTappedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Case Fast Investigation");
        getContentPane().add(investigateTappedPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public CaseFacade getCaseFacade() { return this.caseFacade; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane investigateTappedPane;
    // End of variables declaration//GEN-END:variables
}
