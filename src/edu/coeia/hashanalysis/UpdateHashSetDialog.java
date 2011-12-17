/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UpdateHashSetDialog.java
 *
 * Created on Dec 17, 2011, 1:58:17 PM
 */
package edu.coeia.hashanalysis;

import edu.coeia.util.FilesPath;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wajdyessam
 */
public class UpdateHashSetDialog extends javax.swing.JDialog {
    
    private boolean status = false; // if adding correctly or not
    private List<HashItem> items; 
    private List<HashCategory> hashCategories ;
    private HashLibraryManager hashLibraryManager ;
    private HashSetItemsPanel hashSetItemsPanel ;
    
    /** Creates new form UpdateHashSetDialog */
    public UpdateHashSetDialog(java.awt.Frame parent, boolean modal, List<HashItem> hashItems) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        
        this.items = hashItems;
        this.hashLibraryManager = new HashLibraryManager();
        this.hashSetItemsPanel = new HashSetItemsPanel(hashItems);
        this.hashItemsPanel.add(this.hashSetItemsPanel);
        this.hashItemsPanel.revalidate();
        this.hashCategories = new ArrayList<HashCategory>();
        
        this.initializeHashSet();
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
        jLabel1 = new javax.swing.JLabel();
        hashSetComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        hashItemsPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adding to Existing Hash Set");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Adding to Existing Hash Set"));

        jLabel1.setText("Hash Set Name:");

        hashSetComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashSetComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Note:");

        noteTextArea.setColumns(20);
        noteTextArea.setEditable(false);
        noteTextArea.setRows(5);
        noteTextArea.setEnabled(false);
        jScrollPane1.setViewportView(noteTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(hashSetComboBox, 0, 499, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hashSetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap())
        );

        hashItemsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("New Items to be Added"));
        hashItemsPanel.setLayout(new java.awt.BorderLayout());

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hashItemsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       HashCategory hashCategory = this.getSelectedHashCategory();
       this.hashLibraryManager.update(this.items, hashCategory.getName());
       this.status = true;
       this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void hashSetComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashSetComboBoxActionPerformed
        HashCategory hashCategory = this.getSelectedHashCategory();
        this.noteTextArea.setText(hashCategory.getNote());
        
        this.hashSetItemsPanel = new HashSetItemsPanel(hashCategory.getItems());
        
        this.hashItemsPanel.removeAll();
        this.hashItemsPanel.add(this.hashSetItemsPanel);
        this.hashItemsPanel.revalidate();
    }//GEN-LAST:event_hashSetComboBoxActionPerformed

    public boolean getStatus() { return this.status; }
    
    private HashCategory getSelectedHashCategory() {
        int index = this.hashSetComboBox.getSelectedIndex();
        HashCategory hashCategory = this.hashCategories.get(index);
        
        return (hashCategory);
    }
        
    private void initializeHashSet() {
        String hashSetLocation = FilesPath.HASH_LIBRARY_PATH;
        List<File> hashSetsLocation = hashLibraryManager.getHashSets(hashSetLocation);
        
        for(File file: hashSetsLocation) {
            HashCategory hashCategory = hashLibraryManager.getHashCategory(file);
            this.hashCategories.add(hashCategory);
            this.hashSetComboBox.addItem(hashCategory.getName());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel hashItemsPanel;
    private javax.swing.JComboBox hashSetComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea noteTextArea;
    // End of variables declaration//GEN-END:variables
}
