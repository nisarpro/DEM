/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChatSourceViewerPanel.java
 *
 * Created on Nov 30, 2011, 7:42:02 AM
 */
package edu.coeia.viewer;

import edu.coeia.gutil.JTableUtil;
import edu.coeia.indexing.IndexingConstant;
import edu.coeia.searching.LuceneSearcher;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
class ChatSourceViewerPanel extends javax.swing.JPanel {

    private Document document ;
    private Document parentDocument ;
    
    private String keyword ;
    private SourceViewerDialog dialog ;
    private LuceneSearcher searcher ;
    private String currentId ;
    
    /** Creates new form ChatSourceViewerPanel */
    public ChatSourceViewerPanel(SourceViewerDialog dialog) {
        initComponents();
        
        this.dialog = dialog;
        this.keyword = dialog.getQueryString();
        this.searcher = dialog.getLuceneSearch();
        this.currentId = dialog.getCurrentId() ;
        
        try {
             this.document = this.searcher.getDocument(String.valueOf(this.currentId));
             this.parentDocument = this.searcher.getParentDocument(this.document.get(IndexingConstant.DOCUMENT_PARENT_ID));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        displayDocumentInformation();
    }

    private void displayDocumentInformation () {        
        try {
            // show file properities
            String chatAgent = this.document.get(IndexingConstant.CHAT_AGENT);
            String chatPath = this.document.get(IndexingConstant.CHAT_FILE);
            String date = this.document.get(IndexingConstant.CHAT_TIME);
            String from = this.document.get(IndexingConstant.CHAT_FROM);
            String to = this.document.get(IndexingConstant.CHAT_TO);
            String message = this.document.get(IndexingConstant.CHAT_MESSAGE);
            
            String doc = this.document.get(IndexingConstant.DOCUMENT);
            String docId = this.document.get(IndexingConstant.DOCUMENT_ID);
            String parentId = this.document.get(IndexingConstant.DOCUMENT_PARENT_ID);
            
            chatAgentTextField.setText(chatAgent);
            chatPathTextField.setText(chatPath);
            dateTextField.setText(date);
            chatFromTextField.setText(from);
            chatToTextField.setText(to);
            messageTextField.setText(message);
            
            // show all conversatoin here
            // by bring all the document that have parent-id as parent
            // then display it here as converstion
            int count = this.searcher.searchParentById(parentId);
            for (int i=0; i<count; i++) {
                try {
                    Document chatDoc = this.searcher.getDocHits(i);
                    if ( ! chatDoc.get(IndexingConstant.DOCUMENT).equals(IndexingConstant.getDocumentType(IndexingConstant.DOCUMENT_TYPE.CHAT)))
                        continue ;
                    
                    String tmpChatPath = chatDoc.get(IndexingConstant.CHAT_FILE);
                    String tmpDate = chatDoc.get(IndexingConstant.CHAT_TIME);
                    String tmpFrom = chatDoc.get(IndexingConstant.CHAT_FROM);
                    String tmpTo = chatDoc.get(IndexingConstant.CHAT_TO);
                    String tmpMessage = chatDoc.get(IndexingConstant.CHAT_MESSAGE);
                    
                    // add this to table
                    Object[] data = {tmpFrom, tmpTo, tmpDate, tmpMessage} ;
                    JTableUtil.addRowToJTable(chatTable, data);
                }
                catch(Exception e) { e.printStackTrace(); }
            }
            
            chatRenderPanel.validate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        chatRenderPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTable = new javax.swing.JTable();
        chatMetaDataPanel = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        metaDataTextArea = new javax.swing.JTextArea();
        properitiesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chatAgentTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chatPathTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        chatFromTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chatToTextField = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        chatRenderPanel.setLayout(new java.awt.BorderLayout());

        chatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "Date", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        chatTable.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(chatTable);

        chatRenderPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Conversation", chatRenderPanel);

        metaDataTextArea.setColumns(20);
        metaDataTextArea.setFont(new java.awt.Font("Tahoma", 0, 14));
        metaDataTextArea.setRows(5);
        jScrollPane28.setViewportView(metaDataTextArea);

        javax.swing.GroupLayout chatMetaDataPanelLayout = new javax.swing.GroupLayout(chatMetaDataPanel);
        chatMetaDataPanel.setLayout(chatMetaDataPanelLayout);
        chatMetaDataPanelLayout.setHorizontalGroup(
            chatMetaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );
        chatMetaDataPanelLayout.setVerticalGroup(
            chatMetaDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("MetaData", chatMetaDataPanel);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(viewPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Chat Agent:");

        chatAgentTextField.setEditable(false);
        chatAgentTextField.setText(" ");

        jLabel2.setText("Chat Path:");

        chatPathTextField.setEditable(false);
        chatPathTextField.setText(" ");

        jLabel3.setText("Last Modification:");

        dateTextField.setEditable(false);
        dateTextField.setText(" ");

        jLabel4.setText("Message:");

        messageTextField.setEditable(false);
        messageTextField.setText(" ");

        jLabel5.setText("Message From:");

        chatFromTextField.setEditable(false);
        chatFromTextField.setText(" ");

        jLabel6.setText("Chat To:");

        chatToTextField.setEditable(false);
        chatToTextField.setText(" ");

        javax.swing.GroupLayout properitiesPanelLayout = new javax.swing.GroupLayout(properitiesPanel);
        properitiesPanel.setLayout(properitiesPanelLayout);
        properitiesPanelLayout.setHorizontalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(chatPathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(chatAgentTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(chatFromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addComponent(chatToTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
        );
        properitiesPanelLayout.setVerticalGroup(
            properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(properitiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chatAgentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chatPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chatFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(properitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chatToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(properitiesPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField chatAgentTextField;
    private javax.swing.JTextField chatFromTextField;
    private javax.swing.JPanel chatMetaDataPanel;
    private javax.swing.JTextField chatPathTextField;
    private javax.swing.JPanel chatRenderPanel;
    private javax.swing.JTable chatTable;
    private javax.swing.JTextField chatToTextField;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JTextArea metaDataTextArea;
    private javax.swing.JPanel properitiesPanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}