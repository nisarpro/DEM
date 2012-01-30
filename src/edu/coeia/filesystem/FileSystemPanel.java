
package edu.coeia.filesystem;

import edu.coeia.hashanalysis.HashAnalysisPanel;
import edu.coeia.cases.Case;
import edu.coeia.cases.CaseManager;
import edu.coeia.filesignature.FileSignaturePanel;
import edu.coeia.main.CaseFrame;
import javax.swing.JFrame;

/*
 * FileSystemPanel.java
 *
 * @author wajdyessam
 * 
 * Created on Aug 10, 2011, 4:14:30 PM
 * 
 */

public class FileSystemPanel extends javax.swing.JPanel {
    
    private final CaseFrame caseFrame ;
    private final Case aCase ;
    
    /** Creates new form FileSystemPanel */
    public FileSystemPanel(final JFrame parentFrame) {
        initComponents();

        this.caseFrame = (CaseFrame) parentFrame;
        this.aCase = this.caseFrame.getCaseManager().getCase();
        
        //SearchFileSystemPanel searchPanel = new SearchFileSystemPanel(aIndex, parentFrame);
        //FileBrowsingPanel fileBrowsingPanel = new FileBrowsingPanel();
        FileSignaturePanel fileSignaturePanel = new FileSignaturePanel(this.aCase);
        HashAnalysisPanel hashAnalysisPanel = new HashAnalysisPanel(this);
        
        //this.fileSystemTappedPane.add("Searching", searchPanel);
        //this.fileSystemTappedPane.add("Browse", fileBrowsingPanel);
        this.fileSystemTappedPane.add("File Signature", fileSignaturePanel);
        this.fileSystemTappedPane.add("Hash Analysis", hashAnalysisPanel);
    }

    public void showSearchWithKeyword (String text) {
        fileSystemTappedPane.setSelectedIndex(0);
        //((SearchFileSystemPanel)fileSystemTappedPane.getComponentAt(0)).setSearchKeyword(text);
    }
    
    public CaseFrame getCaseFrame() { return this.caseFrame ; }
    public Case getCase() { return this.aCase ; }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileSystemTappedPane = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());
        add(fileSystemTappedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane fileSystemTappedPane;
    // End of variables declaration//GEN-END:variables
}
