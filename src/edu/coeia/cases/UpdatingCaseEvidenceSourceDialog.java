/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UpdatingCaseEvidenceSourceDialog.java
 *
 * Created on Jan 3, 2012, 11:13:24 AM
 */
package edu.coeia.cases;

import edu.coeia.gutil.JListUtil;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import chrriis.dj.nativeswing.swtimpl.components.JDirectoryDialog;
/**
 *
 * @author wajdyessam
 */
final class UpdatingCaseEvidenceSourceDialog extends javax.swing.JDialog {

    private final Case aCase; 
    private boolean result = false;
    private final DefaultListModel sourcesListModel;
    
    /** Creates new form UpdatingCaseEvidenceSourceDialog */
    public UpdatingCaseEvidenceSourceDialog(java.awt.Frame parent, boolean modal, final Case aCase) 
            throws IOException{
        
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        this.aCase = aCase;
        this.sourcesListModel = new DefaultListModel();
        this.fillListWithNotFoundedSources();
    }
    
    private void fillListWithNotFoundedSources() throws IOException{
        sourcesListModel.clear();
        
        // fill with missing case sources
        CasePathHandler pathHandler = CasePathHandler.newInstance(aCase.getCaseLocation());
        for(CasePathHandler.RelativeAndFullPathMapping entry: pathHandler.getChangedEntries()) {
             String data = entry.absolutePath;
             JListUtil.addToList(data, sourcesListModel, sourcesList);
        }
        
        // check if all paths are fixes
        if ( pathHandler.getChangedEntries().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All Sources have been fixed", "case sources have been founded", JOptionPane.INFORMATION_MESSAGE);
            this.result = true;
            this.dispose();
        }
    }
    
    public boolean getResult() {
        return this.result ;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourcesList = new javax.swing.JList();
        newSourceButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Updating Case Evidence Location");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Not Founded Case Sources"));

        jScrollPane1.setViewportView(sourcesList);

        newSourceButton.setText("Browse New Source...");
        newSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSourceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newSourceButton)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(newSourceButton))
                .addContainerGap())
        );

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeButton)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSourceButtonActionPerformed
        try {
            Object object = this.sourcesList.getSelectedValue();
            if ( object == null) {
                JOptionPane.showMessageDialog(this, "Select Source First", "select old source first", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String oldPath = String.valueOf(object);
            
            JDirectoryDialog directoryDialog = new JDirectoryDialog();
            directoryDialog.show(this);
            
            String newPath = directoryDialog.getSelectedDirectory();
            if (newPath == null) return;
            
            String relative = getRelativeMarkForPath(oldPath);
            CasePathHandler.RelativeAndFullPathMapping entry = new CasePathHandler.RelativeAndFullPathMapping(relative, newPath);
            CasePathHandler pathHandler = CasePathHandler.newInstance(aCase.getCaseLocation());
            pathHandler.updateFullPath(entry);
            
            // update case object
            aCase.removeEvidenceSourceLocation(oldPath);
            aCase.addEvidenceSourceLocation(newPath);
            CaseManager.updateCase(aCase);
            
            // update gui list
            this.fillListWithNotFoundedSources();
        } catch (IOException ex) {
            Logger.getLogger(UpdatingCaseEvidenceSourceDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newSourceButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private String getRelativeMarkForPath(final String fullPath) throws IOException{
        CasePathHandler pathHandler = CasePathHandler.newInstance(aCase.getCaseLocation());
        for(CasePathHandler.RelativeAndFullPathMapping entry: pathHandler.getChangedEntries()) {
             String data = entry.absolutePath;
             String relative = entry.relativePath;
             
             if ( fullPath.equals(data) ) 
                 return relative;
        }
        
        return "";
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newSourceButton;
    private javax.swing.JList sourcesList;
    // End of variables declaration//GEN-END:variables
}
