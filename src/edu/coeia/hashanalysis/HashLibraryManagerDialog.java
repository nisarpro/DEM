/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.hashanalysis;

import edu.coeia.util.FileUtil;
import edu.coeia.constants.ApplicationConstants;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author wajdyessam
 */
public class HashLibraryManagerDialog extends javax.swing.JDialog {

    private List<HashCategory> hashCategories ;
    
    private HashSetItemsPanel hashSetItemsPanel ;
    private JFrame parent; 
    
    /** Creates new form HashLibraryManagerDialog */
    public HashLibraryManagerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        this.parent = (JFrame) parent ;
        this.hashCategories = new ArrayList<HashCategory>();
        this.checkButtonAndInitialize();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hashSetsComboBox = new javax.swing.JComboBox();
        loadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/hashanalysis/Bundle"); // NOI18N
        setTitle(bundle.getString("HashLibraryManagerDialog.title")); // NOI18N

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("HashLibraryManagerDialog.viewPanel.border.title"))); // NOI18N
        viewPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("HashLibraryManagerDialog.jPanel2.border.title"))); // NOI18N

        importButton.setText(bundle.getString("HashLibraryManagerDialog.importButton.text")); // NOI18N
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        exportButton.setText(bundle.getString("HashLibraryManagerDialog.exportButton.text")); // NOI18N
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        removeButton.setText(bundle.getString("HashLibraryManagerDialog.removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        closeButton.setText(bundle.getString("HashLibraryManagerDialog.closeButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("HashLibraryManagerDialog.jPanel3.border.title"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("HashLibraryManagerDialog.jLabel1.text")); // NOI18N

        loadButton.setText(bundle.getString("HashLibraryManagerDialog.loadButton.text")); // NOI18N
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hashSetsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(hashSetsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        HashCategory hashCategory = this.getSelectedHashCategory();
        
        this.hashSetItemsPanel = new HashSetItemsPanel(hashCategory.getItems());
        this.viewPanel.removeAll();
        this.viewPanel.add(this.hashSetItemsPanel);
        this.viewPanel.revalidate();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        try { 
            this.importHashCategory();
            this.checkButtonAndInitialize();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        try {
            exportHashCategory(this.getSelectedHashCategory());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        HashCategory hashCategory = this.getSelectedHashCategory();
        HashLibraryManager.removeHashCategory(hashCategory);
        this.checkButtonAndInitialize();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    private HashCategory getSelectedHashCategory() {
        int index = this.hashSetsComboBox.getSelectedIndex();
        HashCategory hashCategory = this.hashCategories.get(index);
        
        return (hashCategory);
    }
    
    private void checkButtonAndInitialize() {
        try {
            this.resetItems();
            this.initializingHashCategoriesComboBox();
            this.checkGUIEelemntsToDisable();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
        
    private void resetItems() {
        this.hashCategories.clear();
        this.hashSetsComboBox.removeAllItems();
        this.viewPanel.removeAll();
        this.viewPanel.revalidate();
    }
        
    private void initializingHashCategoriesComboBox() throws Exception {
        for(HashCategory hashCategory: HashLibraryManager.getHashCategories()) {
            this.hashCategories.add(hashCategory);
            this.hashSetsComboBox.addItem(hashCategory.getName());
        }
    }
    
    private void checkGUIEelemntsToDisable() {
        if (this.hashCategories.isEmpty() ) {
            this.hashSetsComboBox.setEnabled(false);
            this.loadButton.setEnabled(false);
            this.exportButton.setEnabled(false);
            this.removeButton.setEnabled(false);
        }
        else {
            this.hashSetsComboBox.setEnabled(true);
            this.loadButton.setEnabled(true);
            this.exportButton.setEnabled(true);
            this.removeButton.setEnabled(true);
        }
    }
    
    private void importHashCategory() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(HashLibraryManager.SWING_HASH_EXTENSION_FILTER);
        
        int result = fileChooser.showOpenDialog(this.parent);
        if ( result == JFileChooser.APPROVE_OPTION ) {
            File file = fileChooser.getSelectedFile();
            
            String filePath = ApplicationConstants.APPLICATION_HASH_LIBRARY_PATH + "\\" + file.getName();
            FileUtil.saveObject(new FileInputStream(file), filePath);
        }
    }
    
    private void exportHashCategory(final HashCategory hashCategory) throws Exception {
        String filePath = HashLibraryManager.getPathForHashCategory(hashCategory.getName());
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(hashCategory.getName() + ApplicationConstants.CASE_HASH_SET_EXTENSION));
        
        int result = fileChooser.showSaveDialog(this.parent);
        if ( result == JFileChooser.APPROVE_OPTION ) {
            File file = fileChooser.getSelectedFile();
            FileUtil.saveObject(new FileInputStream(filePath), file.getAbsolutePath());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox hashSetsComboBox;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
