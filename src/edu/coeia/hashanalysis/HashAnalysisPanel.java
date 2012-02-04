/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HashAnalysisPanel.java
 *
 * Created on Oct 5, 2011, 11:22:57 AM
 */
package edu.coeia.hashanalysis;

import edu.coeia.items.Item;
import edu.coeia.items.ItemFactory;
import edu.coeia.viewer.SearchResultParamter;
import edu.coeia.viewer.SourceViewerDialog;
import edu.coeia.cases.Case;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.searching.LuceneSearcher;
import edu.coeia.filesystem.FileSystemPanel;
import edu.coeia.reports.DatasourceXml;
import edu.coeia.reports.RawResultFile;
import edu.coeia.reports.ReportOptionDialog;
import edu.coeia.task.CaseDuplicationTask;
import edu.coeia.task.HashLibraryDuplicationTask;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;

import org.apache.lucene.document.Document ;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import edu.coeia.gutil.LabelCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author wajdyessam
 */
public class HashAnalysisPanel extends javax.swing.JPanel {

    private final Case aCase ;
    private final List<HashCategory> hashCategories ;   // contain all categories
    private final List<MatchingResult> hashLibraryDuplicationResult;   // contain the result of hash library duplication anaylsis
    private final Multimap<String, String> caseDuplicationsMap;      // contain the result of case duplication analysis
    private final JFrame parentFrame;
    
    /** Creates new form HashAnalysisPanel */
    public HashAnalysisPanel(final JPanel parentPanel) {
        initComponents();
        
        this.aCase =  ((FileSystemPanel) parentPanel).getCase();
        this.parentFrame = ( (FileSystemPanel) parentPanel).getCaseFrame();
        this.hashCategories = new ArrayList<HashCategory>();
        this.hashLibraryDuplicationResult = new ArrayList<MatchingResult>();
        this.caseDuplicationsMap = ArrayListMultimap.create(); 
        
        try {
            this.initializingHashCategoriesJList();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        TableColumn tableColumn = this.matchedTable.getColumnModel().getColumn(3);
        tableColumn.setCellRenderer(new LabelCellRenderer());
        
        TableColumn tableColumn2 = this.caseDuplicationResultTable.getColumnModel().getColumn(3);
        tableColumn2.setCellRenderer(new LabelCellRenderer());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        hashLibraryDuplicationPanel = new javax.swing.JPanel();
        hashSetPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hashSetJList = new javax.swing.JList();
        hashAnalysisButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        analysisResultTable = new javax.swing.JTable();
        matchedFilesPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        matchedTable = new javax.swing.JTable();
        caseDuplicationPanel = new javax.swing.JPanel();
        resultPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        caseDuplicationTable = new javax.swing.JTable();
        findDuplicationButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        matchedFilesPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        caseDuplicationResultTable = new javax.swing.JTable();

        hashLibraryDuplicationPanel.setLayout(new java.awt.BorderLayout());

        hashSetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hash Library"));

        jScrollPane2.setViewportView(hashSetJList);

        hashAnalysisButton.setText("Hash Analysis");
        hashAnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashAnalysisButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Generate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hashSetPanelLayout = new javax.swing.GroupLayout(hashSetPanel);
        hashSetPanel.setLayout(hashSetPanelLayout);
        hashSetPanelLayout.setHorizontalGroup(
            hashSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hashSetPanelLayout.createSequentialGroup()
                .addComponent(hashAnalysisButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        hashSetPanelLayout.setVerticalGroup(
            hashSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hashSetPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hashSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hashAnalysisButton)
                    .addComponent(jButton1)))
        );

        hashLibraryDuplicationPanel.add(hashSetPanel, java.awt.BorderLayout.WEST);

        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Anlaysis Result"));

        analysisResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "File path", "Hash Set", "Case Name", "Case Path", "Hash Value", "Investigator Name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        analysisResultTable.setFillsViewportHeight(true);
        analysisResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analysisResultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(analysisResultTable);

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );

        hashLibraryDuplicationPanel.add(resultPanel, java.awt.BorderLayout.CENTER);

        matchedFilesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Matched Files in Case"));

        matchedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "File Name", "Date", "Type", "File Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        matchedTable.setFillsViewportHeight(true);
        matchedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matchedTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(matchedTable);

        javax.swing.GroupLayout matchedFilesPanelLayout = new javax.swing.GroupLayout(matchedFilesPanel);
        matchedFilesPanel.setLayout(matchedFilesPanelLayout);
        matchedFilesPanelLayout.setHorizontalGroup(
            matchedFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchedFilesPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        matchedFilesPanelLayout.setVerticalGroup(
            matchedFilesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        hashLibraryDuplicationPanel.add(matchedFilesPanel, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Files Duplication within Hash Library", hashLibraryDuplicationPanel);

        caseDuplicationPanel.setLayout(new java.awt.BorderLayout());

        resultPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Anlaysis Result"));

        caseDuplicationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hash Value", "Number of Duplication"
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
        caseDuplicationTable.setFillsViewportHeight(true);
        caseDuplicationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caseDuplicationTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(caseDuplicationTable);

        findDuplicationButton.setText("Find Duplication");
        findDuplicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findDuplicationButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Generate Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultPanel1Layout = new javax.swing.GroupLayout(resultPanel1);
        resultPanel1.setLayout(resultPanel1Layout);
        resultPanel1Layout.setHorizontalGroup(
            resultPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(resultPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findDuplicationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        resultPanel1Layout.setVerticalGroup(
            resultPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanel1Layout.createSequentialGroup()
                .addComponent(findDuplicationButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(103, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );

        caseDuplicationPanel.add(resultPanel1, java.awt.BorderLayout.CENTER);

        matchedFilesPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matched Files in Case"));

        caseDuplicationResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "File Name", "Date", "Type", "File Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        caseDuplicationResultTable.setFillsViewportHeight(true);
        caseDuplicationResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caseDuplicationResultTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(caseDuplicationResultTable);

        javax.swing.GroupLayout matchedFilesPanel1Layout = new javax.swing.GroupLayout(matchedFilesPanel1);
        matchedFilesPanel1.setLayout(matchedFilesPanel1Layout);
        matchedFilesPanel1Layout.setHorizontalGroup(
            matchedFilesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(matchedFilesPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        matchedFilesPanel1Layout.setVerticalGroup(
            matchedFilesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        caseDuplicationPanel.add(matchedFilesPanel1, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Files Duplication in the same Case", caseDuplicationPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hashAnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashAnalysisButtonActionPerformed
        this.resetHashLibraryDuplicationElements();
        HashLibraryDuplicationTask task = new HashLibraryDuplicationTask(aCase, this);
        task.startTask();
    }//GEN-LAST:event_hashAnalysisButtonActionPerformed

    private void analysisResultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analysisResultTableMouseClicked
        int row = this.analysisResultTable.getSelectedRow();
        if ( row < 0 ) return;
                
        JTableUtil.removeAllRows(this.matchedTable);
        
        MatchingResult result = this.hashLibraryDuplicationResult.get(row);
        for(Document document: result.matchingDocuments) {
            Item item = ItemFactory.newInstance(document, this.aCase);
            JTableUtil.addRowToJTable(this.matchedTable, item.getDisplayData());
        }
    }//GEN-LAST:event_analysisResultTableMouseClicked

    private void findDuplicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findDuplicationButtonActionPerformed
        this.resetCaseDuplicationElements();
        CaseDuplicationTask task = new CaseDuplicationTask(aCase, this);
        task.startTask();
    }//GEN-LAST:event_findDuplicationButtonActionPerformed

    private void caseDuplicationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caseDuplicationTableMouseClicked
        try {
            int row = this.caseDuplicationTable.getSelectedRow();
            if ( row < 0 ) return ;
            
            JTableUtil.removeAllRows(this.caseDuplicationResultTable);
            LuceneSearcher searcher = new LuceneSearcher(aCase);
            
            String key = String.valueOf(this.caseDuplicationTable.getValueAt(row, 0));
            Collection<String> documentsId = this.caseDuplicationsMap.get(key);
            for(String documentId: documentsId) {
                Document document = searcher.getLuceneDocumentById(documentId);
                Item item = ItemFactory.newInstance(document, this.aCase);
                JTableUtil.addRowToJTable(this.caseDuplicationResultTable, item.getDisplayData());
            }
            
            searcher.closeSearcher();
        } catch (Exception ex) {
            Logger.getLogger(HashAnalysisPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_caseDuplicationTableMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    int rows = analysisResultTable.getRowCount();
    if (rows <= 0) {
        JOptionPane.showMessageDialog(this, "No Analaysis has been Performed", " Error Generating Report", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    DatasourceXml objXmlSource = new DatasourceXml();
    objXmlSource = RawResultFile.getHashAnalysisHashLibrary(analysisResultTable, aCase);
    ReportOptionDialog dialogue = new ReportOptionDialog(aCase);
    dialogue.SetDataSource(objXmlSource);
    dialogue.RunProgressDialogue();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    
    int rows = caseDuplicationResultTable.getRowCount();
    if (rows <= 0) {
        JOptionPane.showMessageDialog(this, "No Analaysis has been Performed", " Error Generating Report", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    DatasourceXml objXmlSource = new DatasourceXml();
    objXmlSource = RawResultFile.getHashAnalysisinCase(caseDuplicationResultTable, aCase);
    ReportOptionDialog dialogue = new ReportOptionDialog(aCase);
    dialogue.SetDataSource(objXmlSource);
    dialogue.RunProgressDialogue();
}//GEN-LAST:event_jButton2ActionPerformed

    private void caseDuplicationResultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caseDuplicationResultTableMouseClicked
        if ( JTableUtil.isDoubleClick(evt) ) {
            this.showSourceViewerDialog(this.caseDuplicationResultTable);
        }
    }//GEN-LAST:event_caseDuplicationResultTableMouseClicked

    private void matchedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matchedTableMouseClicked
        if ( JTableUtil.isDoubleClick(evt) ) {
            this.showSourceViewerDialog(this.matchedTable);
        }
    }//GEN-LAST:event_matchedTableMouseClicked

    private void showSourceViewerDialog(final JTable table) {
        int row = table.getSelectedRow();
        if ( row < 0 ) return;

        String documentId = String.valueOf(table.getValueAt(row, 0));
        int documentIdNumber = Integer.parseInt(documentId);

        List<Integer> ids = new ArrayList<Integer>();
        for(int i=0; i<table.getRowCount(); i++) {
            int value = Integer.parseInt(String.valueOf(table.getValueAt(i, 0)));
            ids.add(value);
        }

        SearchResultParamter searchResult = new SearchResultParamter("", documentIdNumber, ids);
        SourceViewerDialog dialog = new SourceViewerDialog(this.parentFrame, true, searchResult);
        dialog.setVisible(true);
    }
    
    public static class MatchingResult {
        public MatchingResult (HashCategory hashCategory, HashItem item, List<Document> docs) {
            this.hashCategory = hashCategory ;
            this.hashItem = item;
            this.matchingDocuments.addAll(Collections.unmodifiableList(docs));
        }
        
        HashCategory hashCategory;
        HashItem hashItem;
        List<Document> matchingDocuments = new ArrayList<Document>();
    }
    

    private void initializingHashCategoriesJList() throws Exception{
        DefaultListModel model = new DefaultListModel();
        
        for(HashCategory hashCategory: HashLibraryManager.getHashCategories()) {
            this.hashCategories.add(hashCategory);
            model.addElement(hashCategory.getName());
        }
        
        this.hashSetJList.setModel(model);
    }
        
    private void resetHashLibraryDuplicationElements() {
        JTableUtil.removeAllRows(this.analysisResultTable);
        JTableUtil.removeAllRows(this.matchedTable);
        this.hashLibraryDuplicationResult.clear();
    }
    
    private void resetCaseDuplicationElements() {
        this.caseDuplicationsMap.clear();
        JTableUtil.removeAllRows(this.caseDuplicationResultTable);
        JTableUtil.removeAllRows(this.caseDuplicationTable);
    }
    
    public List<HashCategory> getHashCateogries() { return this.hashCategories; }
    public List<MatchingResult> getHashLibraryDuplicationResult() { return this.hashLibraryDuplicationResult; }
    public Multimap<String, String> getCaseDuplicationMap() { return this.caseDuplicationsMap; }
    public JList getHashLibraryList() { return this.hashSetJList; }
    public JTable getAnalysisResultTable() { return this.analysisResultTable ;}
    public JTable getCaseDuplicationTable() { return this.caseDuplicationTable ; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable analysisResultTable;
    private javax.swing.JPanel caseDuplicationPanel;
    private javax.swing.JTable caseDuplicationResultTable;
    private javax.swing.JTable caseDuplicationTable;
    private javax.swing.JButton findDuplicationButton;
    private javax.swing.JButton hashAnalysisButton;
    private javax.swing.JPanel hashLibraryDuplicationPanel;
    private javax.swing.JList hashSetJList;
    private javax.swing.JPanel hashSetPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel matchedFilesPanel;
    private javax.swing.JPanel matchedFilesPanel1;
    private javax.swing.JTable matchedTable;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JPanel resultPanel1;
    // End of variables declaration//GEN-END:variables
}
