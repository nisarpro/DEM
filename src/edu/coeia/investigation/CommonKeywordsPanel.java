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
package edu.coeia.investigation;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.gutil.WrapLayout;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.searching.AdvancedSearchPanel;
import edu.coeia.searching.InvestigateDialog;
import edu.coeia.tasks.CommonKeywordsTask;
import edu.coeia.util.ApplicationLogging;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.mcavallo.opencloud.Tag;

/**
 *
 * @author wajdyessam
 */

public class CommonKeywordsPanel extends javax.swing.JPanel {
    private final Case caseObj;
    private final InvestigateDialog parentDialog;
    private final AdvancedSearchPanel advancedSearchPanel;
    private final CaseFacade caseFacade ;
    
    private final static Logger logger = ApplicationLogging.getLogger();
    
    /** Creates new form CommonKeywordsPanel */
    public CommonKeywordsPanel(final InvestigateDialog dialog, final AdvancedSearchPanel panel) {
        initComponents();

        this.parentDialog = dialog;
        this.caseFacade = dialog.getCaseFacade();
        this.caseObj = dialog.getCaseFacade().getCase();
        this.advancedSearchPanel = panel;
        this.tagsPanel.setLayout(new WrapLayout());
        this.cloudsFilterTextField.getDocument().addDocumentListener(new CloudsInputListener());
        
        JTableUtil.setTableAlignmentValue(cloudsTable, 1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        commonKeywordPanel = new javax.swing.JPanel();
        textCloudsPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        tagSelectButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tagsNumberTextField = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        tagsExcludeTextField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tagsDisplayComboBox = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        tagsPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        cloudsTable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        cloudsFilterTextField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        commonKeywordPanel.setLayout(new java.awt.BorderLayout());

        textCloudsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        textCloudsPanel.setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/investigation/Bundle"); // NOI18N
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("CommonKeywordsPanel.jPanel15.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tagSelectButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tagSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/textCloud.png"))); // NOI18N
        tagSelectButton.setText(bundle.getString("CommonKeywordsPanel.tagSelectButton.text")); // NOI18N
        tagSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagSelectButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(bundle.getString("CommonKeywordsPanel.jLabel2.text")); // NOI18N

        tagsNumberTextField.setText(bundle.getString("CommonKeywordsPanel.tagsNumberTextField.text")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText(bundle.getString("CommonKeywordsPanel.jLabel36.text")); // NOI18N

        tagsExcludeTextField.setText(bundle.getString("CommonKeywordsPanel.tagsExcludeTextField.text")); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText(bundle.getString("CommonKeywordsPanel.jLabel37.text")); // NOI18N

        tagsDisplayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alphabetically Sort - Ascending", "Alphabetically Sort - descending ", "Score Sort - Ascending", "Score Sort - descending" }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(tagsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(tagsExcludeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tagsDisplayComboBox, 0, 373, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(tagSelectButton))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(tagsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(tagsExcludeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(tagsDisplayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(tagSelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        textCloudsPanel.add(jPanel15, java.awt.BorderLayout.NORTH);

        tagsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tagsPanelLayout = new javax.swing.GroupLayout(tagsPanel);
        tagsPanel.setLayout(tagsPanelLayout);
        tagsPanelLayout.setHorizontalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1757, Short.MAX_VALUE)
        );
        tagsPanelLayout.setVerticalGroup(
            tagsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        jScrollPane10.setViewportView(tagsPanel);

        jTabbedPane2.addTab(bundle.getString("CommonKeywordsPanel.jScrollPane10.TabConstraints.tabTitle"), jScrollPane10); // NOI18N

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cloudsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cloudsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Word", "Frequency"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cloudsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cloudsTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cloudsTableMouseReleased(evt);
            }
        });
        jScrollPane22.setViewportView(cloudsTable);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 70, 213));
        jLabel33.setText(bundle.getString("CommonKeywordsPanel.jLabel33.text")); // NOI18N

        cloudsFilterTextField.setText(bundle.getString("CommonKeywordsPanel.cloudsFilterTextField.text")); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cloudsFilterTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cloudsFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab(bundle.getString("CommonKeywordsPanel.jPanel19.TabConstraints.tabTitle"), jPanel19); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        textCloudsPanel.add(jPanel16, java.awt.BorderLayout.CENTER);

        commonKeywordPanel.add(textCloudsPanel, java.awt.BorderLayout.CENTER);

        add(commonKeywordPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tagSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagSelectButtonActionPerformed
        try {
            generateTextCloud();
        } 
        catch(Exception e) {
            logger.log(Level.SEVERE, "Cannot Generate Tag Clouds", e);
        }
    }//GEN-LAST:event_tagSelectButtonActionPerformed

    private void cloudsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMousePressed
        GuiUtil.showPopUpForTableIfEnabled(this.cloudsTable, evt);
    }//GEN-LAST:event_cloudsTableMousePressed

    private void cloudsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloudsTableMouseReleased
        GuiUtil.showPopUpForTableIfEnabled(this.cloudsTable, evt);
    }//GEN-LAST:event_cloudsTableMouseReleased
        
    private void generateTextCloud(){
        if ( !caseFacade.getCaseHistory().getIsCaseIndexed() ) {
            JOptionPane.showMessageDialog(this, "please do the indexing operation first before do any operation",
                    "Case is not indexed",JOptionPane.ERROR_MESSAGE );
            return ;
        }

        JTableUtil.removeAllRows(cloudsTable);
        
        CommonKeywordsTask task = new CommonKeywordsTask(caseObj, this);
        task.startTask();
        
//        try {
//
//            
//        } catch (NumberFormatException n) {
//            JOptionPane.showMessageDialog(this, "number is not correct",
//                    "integer number is no correct", JOptionPane.ERROR_MESSAGE);
//            logger.log(Level.SEVERE, "Uncaught exception", n);
//        }
    }
    
    public void renderTags(final List<Tag> tags) {
        this.tagsPanel.removeAll();
            
        for (Tag tag : tags) {
            JLabel lbl = new JLabel(tag.getName());
            lbl.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, tag.getWeightInt()));
            lbl.addMouseListener(new CloudLabelAction());
            lbl.setToolTipText(tag.getName() + " repeated: " + tag.getScoreInt());
            lbl.setForeground(java.awt.Color.BLUE.darker());
            lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            this.tagsPanel.add(lbl);
        }
        
        this.tagsPanel.validate();
        this.tagsPanel.revalidate();
    }
    
    private void closeDialog() {
        this.parentDialog.dispose();
    }
    
    private void filterCloudTable() {
        String text = cloudsFilterTextField.getText().trim();
        JTableUtil.filterTable(cloudsTable, text);
    }

//    public void run() {
//        jButton1.setEnabled(false);
//        DatasourceXml objXmlSource = new DatasourceXml();
//        objXmlSource = RawResultFile.getTextClouds(cloudsTable, caseObj);
//        ReportOptionDialog dialogue = new ReportOptionDialog(caseObj);
//        dialogue.SetDataSource(objXmlSource);
//        dialogue.RunProgressDialogue();
//        jButton1.setEnabled(true);
//    }

    private class CloudLabelAction extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel m = (JLabel) e.getSource();
            doSearch(m.getText());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JLabel m = (JLabel) e.getSource();
            doSearch(m.getText());
        }

        public void doSearch(String text) {
            advancedSearchPanel.setQueryText(text);
            closeDialog();
        }
    }
    
    private class CloudsInputListener implements DocumentListener {
        public void changedUpdate(DocumentEvent e) {
            filterCloudTable();
        }
        
        public void removeUpdate(DocumentEvent e) {
            filterCloudTable();
        }
        
        public void insertUpdate(DocumentEvent e) {
            filterCloudTable();
        }
    }
    
    public JComboBox getTagsDisplayMode() { return this.tagsDisplayComboBox; }
    public JTextField getTagsNumber() { return this.tagsNumberTextField; }
    public JTextField getTagsExclude() { return this.tagsExcludeTextField; }
    public JTable getCloudTable() { return this.cloudsTable; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cloudsFilterTextField;
    private javax.swing.JTable cloudsTable;
    private javax.swing.JPanel commonKeywordPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton tagSelectButton;
    private javax.swing.JComboBox tagsDisplayComboBox;
    private javax.swing.JTextField tagsExcludeTextField;
    private javax.swing.JTextField tagsNumberTextField;
    private javax.swing.JPanel tagsPanel;
    private javax.swing.JPanel textCloudsPanel;
    // End of variables declaration//GEN-END:variables
}
