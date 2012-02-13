/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdvancedSearchPanel.java
 *
 * Created on Oct 22, 2011, 8:17:54 AM
 */
package edu.coeia.searching;

import edu.coeia.cases.CaseFacade;
import edu.coeia.items.Item;
import edu.coeia.items.ItemFactory;
import edu.coeia.searching.CaseSearchPanel.SearchHistory;
import edu.coeia.util.ApplicationLogging;
import edu.coeia.util.DateUtil;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JOptionPane ;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.List; 
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
public class AdvancedSearchPanel extends javax.swing.JPanel {
    private final JFrame parentFrame ;
    private final CaseSearchPanel caseSearchPanel ;
    private final SearchResultPanel searchResultPanel ;
    private final CaseFacade caseFacade ;
    
    private final List<Integer> resultId ;
    private int currentId = 0;
     
    private final static Logger logger = ApplicationLogging.getLogger();
    
    /** Creates new form AdvancedSearchPanel */
    public AdvancedSearchPanel(JPanel parentPanel) {
        initComponents();
        
        this.caseSearchPanel = (CaseSearchPanel) parentPanel;
        this.caseFacade = this.caseSearchPanel.getCaseFacade();
        this.parentFrame = this.caseSearchPanel.getParentJFrame();
        
        this.resultId = new ArrayList<Integer>();
        this.searchResultPanel = new SearchResultPanel(parentFrame);
        
        this.CenterPanel.removeAll();
        this.CenterPanel.add(this.searchResultPanel);
        this.CenterPanel.revalidate();
        
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

        LeftPanel = new javax.swing.JPanel();
        searchScopePanel = new javax.swing.JPanel();
        fileSystemCheckBox = new javax.swing.JCheckBox();
        fileSystemMetadataCheckBox = new javax.swing.JCheckBox();
        fileSystemContentCheckBox = new javax.swing.JCheckBox();
        emailCheckBox = new javax.swing.JCheckBox();
        emailHeaderCheckBox = new javax.swing.JCheckBox();
        emailContentCheckBox = new javax.swing.JCheckBox();
        chatCheckBox = new javax.swing.JCheckBox();
        chatContentCheckBox = new javax.swing.JCheckBox();
        headerPanel = new javax.swing.JPanel();
        queryTextField = new javax.swing.JTextField();
        advancedSearchLabelButton = new javax.swing.JLabel();
        startSearchingButton = new javax.swing.JButton();
        clearLabelButton = new javax.swing.JLabel();
        investigateButton = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchProgressBard = new javax.swing.JProgressBar();
        resultSavingButton = new javax.swing.JButton();
        CenterPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        searchScopePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Scope"));

        fileSystemCheckBox.setSelected(true);
        fileSystemCheckBox.setText("File System:");
        fileSystemCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSystemCheckBoxActionPerformed(evt);
            }
        });

        fileSystemMetadataCheckBox.setText("Metadata");

        fileSystemContentCheckBox.setSelected(true);
        fileSystemContentCheckBox.setText("Content");

        emailCheckBox.setSelected(true);
        emailCheckBox.setText("Email:");
        emailCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailCheckBoxActionPerformed(evt);
            }
        });

        emailHeaderCheckBox.setText("Headers");

        emailContentCheckBox.setSelected(true);
        emailContentCheckBox.setText("Content");

        chatCheckBox.setSelected(true);
        chatCheckBox.setText("Instant Messaging:");
        chatCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatCheckBoxActionPerformed(evt);
            }
        });

        chatContentCheckBox.setSelected(true);
        chatContentCheckBox.setText("Content");

        javax.swing.GroupLayout searchScopePanelLayout = new javax.swing.GroupLayout(searchScopePanel);
        searchScopePanel.setLayout(searchScopePanelLayout);
        searchScopePanelLayout.setHorizontalGroup(
            searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchScopePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileSystemCheckBox)
                    .addComponent(emailCheckBox)
                    .addGroup(searchScopePanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchScopePanelLayout.createSequentialGroup()
                                .addComponent(emailHeaderCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailContentCheckBox))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchScopePanelLayout.createSequentialGroup()
                                .addComponent(fileSystemMetadataCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fileSystemContentCheckBox))))
                    .addGroup(searchScopePanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(chatContentCheckBox))
                    .addComponent(chatCheckBox))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        searchScopePanelLayout.setVerticalGroup(
            searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchScopePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileSystemCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileSystemMetadataCheckBox)
                    .addComponent(fileSystemContentCheckBox))
                .addGap(18, 18, 18)
                .addComponent(emailCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchScopePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailHeaderCheckBox)
                    .addComponent(emailContentCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(chatCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chatContentCheckBox)
                .addContainerGap())
        );

        headerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Options"));

        queryTextField.setText(" ");
        queryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryTextFieldActionPerformed(evt);
            }
        });

        advancedSearchLabelButton.setForeground(new java.awt.Color(0, 51, 255));
        advancedSearchLabelButton.setText("Advanced Search..");
        advancedSearchLabelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advancedSearchLabelButtonMouseClicked(evt);
            }
        });

        startSearchingButton.setText("Search");
        startSearchingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSearchingButtonActionPerformed(evt);
            }
        });

        clearLabelButton.setForeground(new java.awt.Color(0, 0, 255));
        clearLabelButton.setText("Clear");
        clearLabelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearLabelButtonMouseClicked(evt);
            }
        });

        investigateButton.setForeground(new java.awt.Color(0, 0, 255));
        investigateButton.setText("Investigate..");
        investigateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                investigateButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(queryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startSearchingButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(advancedSearchLabelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(investigateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(clearLabelButton)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startSearchingButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearLabelButton)
                    .addComponent(advancedSearchLabelButton)
                    .addComponent(investigateButton)))
        );

        jPanel1.add(searchProgressBard);

        resultSavingButton.setText("Save Results");
        resultSavingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultSavingButtonActionPerformed(evt);
            }
        });
        jPanel1.add(resultSavingButton);

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchScopePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchScopePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(LeftPanel, java.awt.BorderLayout.WEST);

        CenterPanel.setLayout(new java.awt.BorderLayout());
        add(CenterPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void startSearchingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSearchingButtonActionPerformed
        this.startSearching();
    }//GEN-LAST:event_startSearchingButtonActionPerformed

    private void clearLabelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearLabelButtonMouseClicked
        this.removeSearchField(true);
    }//GEN-LAST:event_clearLabelButtonMouseClicked

    private void advancedSearchLabelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advancedSearchLabelButtonMouseClicked
        this.showAdvancedSearchDialog();
    }//GEN-LAST:event_advancedSearchLabelButtonMouseClicked

    private void resultSavingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultSavingButtonActionPerformed
        try {
            this.saveSearchResult();
        } catch (Exception ex) {
            Logger.getLogger(AdvancedSearchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resultSavingButtonActionPerformed

    private void fileSystemCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSystemCheckBoxActionPerformed
        if ( this.fileSystemCheckBox.isSelected() ) {
            this.fileSystemContentCheckBox.setEnabled(true);
            this.fileSystemMetadataCheckBox.setEnabled(true);
        }
        else {
            this.fileSystemContentCheckBox.setEnabled(false);
            this.fileSystemMetadataCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_fileSystemCheckBoxActionPerformed

    private void emailCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailCheckBoxActionPerformed
        if ( this.emailCheckBox.isSelected() ) {
            this.emailContentCheckBox.setEnabled(true);
            this.emailHeaderCheckBox.setEnabled(true);
        }
        else {
            this.emailContentCheckBox.setEnabled(false);
            this.emailHeaderCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_emailCheckBoxActionPerformed

    private void chatCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatCheckBoxActionPerformed
        if ( this.chatCheckBox.isSelected() ) {
            this.chatContentCheckBox.setEnabled(true);
        }
        else {
            this.chatContentCheckBox.setEnabled(false);
        }        
    }//GEN-LAST:event_chatCheckBoxActionPerformed

    private void queryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryTextFieldActionPerformed
        this.startSearching();
    }//GEN-LAST:event_queryTextFieldActionPerformed

    private void investigateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_investigateButtonMouseClicked
       this.showInvestigateDialog();
    }//GEN-LAST:event_investigateButtonMouseClicked
    
    private void showAdvancedSearchDialog() {
        AdvancedSearchDialog advancedSearchDialog = new AdvancedSearchDialog(this.parentFrame, true);
        advancedSearchDialog.setVisible(true);

        String query = advancedSearchDialog.getQuery() ;

        if ( query == null || query.isEmpty() )
            return ;

        this.setQueryText(query);
        this.startSearching();
    }
    
    private void showInvestigateDialog() {
        InvestigateDialog investigateDialog = new InvestigateDialog(this.parentFrame, true, this);
        investigateDialog.setVisible(true);
    }
    
    SearchScope getSearchScope() {
        SearchScope.Builder builder = new SearchScope.Builder();
        
        if ( this.fileSystemCheckBox.isSelected() ) {
            if ( this.fileSystemContentCheckBox.isSelected() ) {
                builder = builder.fileSystemContent(true);
            }
            
            if ( this.fileSystemMetadataCheckBox.isSelected() ) {
                builder = builder.fileSystemMetadata(true);
            }
        }
        
        if ( this.emailCheckBox.isSelected() ) {
            if ( this.emailContentCheckBox.isSelected() ) {
                builder = builder.emailContent(true);
            }
            
            if ( this.emailHeaderCheckBox.isSelected() ) {
                builder = builder.emailHeader(true);
            }
        }
        
        if ( this.chatCheckBox.isSelected() ) {
            if ( this.chatContentCheckBox.isSelected() ) {
                builder = builder.chatContent(true);
            }
        }
        
        return builder.build();
    }
        
    private void startSearching () {
        removeSearchField(false);
            
        if ( ! this.caseFacade.getCaseHistory().getIsCaseIndexed() ) {
            JOptionPane.showMessageDialog(this, "please do the indexing operation first before do any operation",
                    "Case is not indexed",JOptionPane.ERROR_MESSAGE );
            return ;
        }

        String queryString = getQueryText();
        if ( queryString.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "please fill the query string and choose an index location");
            return  ;
        }

        this.searchProgressBard.setIndeterminate(true);
        
        SearcherThread sThread = new SearcherThread(this);
        sThread.execute();
    }
    
    private void removeSearchField (boolean all) {
        this.searchProgressBard.setIndeterminate(false); 
        this.searchResultPanel.clearSearchTable();
        
        if ( all ) {
            this.queryTextField.setText("");
        }
    }
    
    private void saveSearchResult() throws Exception {
        String query = this.getQueryText();
        SearchScope scope = this.getSearchScope();
        String time = DateUtil.getCurrentDate();
        
        if ( this.resultId.isEmpty() ) {
            JOptionPane.showMessageDialog(this.caseSearchPanel, "Please do search then try to save the result");
            return;
        }
        
        SearchHistory option = new SearchHistory(query, time, scope, this.getDocuments());
        this.caseSearchPanel.addSearchOption(option);
        
        JOptionPane.showMessageDialog(this.caseSearchPanel, "Search Result is Saved Succesfully");
    }
    
    private List<Item> getDocuments() throws Exception {
        List<Item> items = new ArrayList<Item>();
        LuceneSearcher searcher = new LuceneSearcher(this.caseFacade.getCase());
        
        for(Integer id: this.resultId) {
            Document currentDocument = searcher.getLuceneDocumentById(String.valueOf(id));
            Item fileItem = ItemFactory.newInstance(currentDocument, this.caseFacade);
            items.add(fileItem);
        }
        
        searcher.closeSearcher();
        return items;
    }
    
    //methods for handling the current document id, and the result id
    void setResultId (final List<Integer> ids) { 
        this.resultId.clear();
        this.resultId.addAll(Collections.unmodifiableList(ids)); 
        this.setResultTableIds(ids);
    }
    
    void setResultTableIds(final List<Integer> ids) { this.searchResultPanel.setResultIds(ids); }
    void setSearchTableFocusable() { this.searchResultPanel.setSearchTableFocusable(); }
    void setResultTableText(final String text) { this.searchResultPanel.setQueryText(text); }
    
    // result ids
    public List<Integer> getIds() { return Collections.unmodifiableList(this.resultId) ; }
    public void setCurrentId (int id) { this.currentId = id ; }
    public int getCurrentId() { return this.currentId ; }
    
    // get GUI elements so the thread can access it
    JFrame getParentFrame() { return this.parentFrame ; }
    JProgressBar getSearchProgressBar () { return this.searchProgressBard ; }
    JTable getSearchTable() { return this.searchResultPanel.getSearchTable(); }
    
    // query text filed accessing
    public void setQueryText(final String queryText) {  this.queryTextField.setText(queryText); }
    String getQueryText() { return queryTextField.getText().trim() ; }
    void setQueryTextFeildFocusable () {  this.queryTextField.requestFocusInWindow(); }
    
    public CaseFacade getCaseFacade() { return this.caseFacade; }
    
    private void disableNotIndexedComponent () {
        if ( this.caseFacade.getCase().getEvidenceSourceLocation().isEmpty() ) {
            startSearchingButton.setEnabled(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel advancedSearchLabelButton;
    private javax.swing.JCheckBox chatCheckBox;
    private javax.swing.JCheckBox chatContentCheckBox;
    private javax.swing.JLabel clearLabelButton;
    private javax.swing.JCheckBox emailCheckBox;
    private javax.swing.JCheckBox emailContentCheckBox;
    private javax.swing.JCheckBox emailHeaderCheckBox;
    private javax.swing.JCheckBox fileSystemCheckBox;
    private javax.swing.JCheckBox fileSystemContentCheckBox;
    private javax.swing.JCheckBox fileSystemMetadataCheckBox;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel investigateButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField queryTextField;
    private javax.swing.JButton resultSavingButton;
    private javax.swing.JProgressBar searchProgressBard;
    private javax.swing.JPanel searchScopePanel;
    private javax.swing.JButton startSearchingButton;
    // End of variables declaration//GEN-END:variables
}
