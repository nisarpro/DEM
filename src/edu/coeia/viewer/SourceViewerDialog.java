/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SourceViewerDialog.java
 *
 * Created on Nov 28, 2011, 2:20:54 PM
 */
package edu.coeia.viewer;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.indexing.IndexingConstant;
import edu.coeia.items.FileItem;
import edu.coeia.items.Item;
import edu.coeia.items.ItemFactory;
import edu.coeia.main.CaseFrame;
import edu.coeia.searching.LuceneSearcher ;
import edu.coeia.util.FileUtil;
import edu.coeia.tags.Tag;
import edu.coeia.tags.TagsDialog;
import edu.coeia.tags.TagsManager;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
public class SourceViewerDialog extends javax.swing.JDialog {
    private String keyword ;
    private LuceneSearcher searcher ;
    private Document currentDocument ;
    private final Frame parent ;
    private final TagsManager tagManger  ;
    private final Case caseObj ;
    private final CaseFacade caseManger; 
    
    /**
     * Lucene Document ID number list and the current id opened now
     */
    private List<Integer> documentsId = new ArrayList<Integer>();
    
    /*
     * the current index of the document list
     */
    private int currentListIndex ;
    
    /** Creates new form SourceViewerDialog */
    public SourceViewerDialog(java.awt.Frame parent, boolean modal, SearchResultParamter searchViewer) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this.parent);
        
        this.parent = parent ;
        this.tagManger = ((CaseFrame) this.parent).getTagsManager();
        this.caseObj  = ((CaseFrame) this.parent).getCaseFacade().getCase();
        this.caseManger = ((CaseFrame) this.parent).getCaseFacade();
        this.keyword = searchViewer.getKeyword();

        try {
            this.searcher = new LuceneSearcher(caseObj);
            
            this.addWindowListener(new WindowAdapter() { 
                @Override
                public void windowClosing(WindowEvent event) {
                    try {
                        searcher.closeSearcher();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        this.documentsId.addAll(searchViewer.getDocumentIds());
        this.currentListIndex = this.documentsId.indexOf(searchViewer.getCurrentDocumentId());
        
        this.showDocumentWithIndex(this.currentListIndex);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        tagButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        viewItemButton = new javax.swing.JButton();
        embeddedPanel = new javax.swing.JPanel();
        displayParentButton = new javax.swing.JButton();
        displayChildsButton = new javax.swing.JButton();
        viewerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Previewer Items Dialog");

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation"));

        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/back.png"))); // NOI18N
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        controlPanel.add(previousButton);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/next.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        controlPanel.add(nextButton);

        tagButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325657694_marked_price.png"))); // NOI18N
        tagButton.setText("Tag Item");
        tagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagButtonActionPerformed(evt);
            }
        });
        controlPanel.add(tagButton);

        exportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325657666_Export.png"))); // NOI18N
        exportButton.setText("Export Item");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        controlPanel.add(exportButton);

        viewItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325657843_folderopen1.png"))); // NOI18N
        viewItemButton.setText("View Item");
        viewItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemButtonActionPerformed(evt);
            }
        });
        controlPanel.add(viewItemButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.NORTH);

        embeddedPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Attachments and Embedded Files"));

        displayParentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274599246_text-x-log.png"))); // NOI18N
        displayParentButton.setText("Display Document Parent");
        displayParentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayParentButtonActionPerformed(evt);
            }
        });
        embeddedPanel.add(displayParentButton);

        displayChildsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/binary.png"))); // NOI18N
        displayChildsButton.setText("Display Document Childs");
        displayChildsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayChildsButtonActionPerformed(evt);
            }
        });
        embeddedPanel.add(displayChildsButton);

        getContentPane().add(embeddedPanel, java.awt.BorderLayout.SOUTH);

        viewerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Viewer"));

        javax.swing.GroupLayout viewerPanelLayout = new javax.swing.GroupLayout(viewerPanel);
        viewerPanel.setLayout(viewerPanelLayout);
        viewerPanelLayout.setHorizontalGroup(
            viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        viewerPanelLayout.setVerticalGroup(
            viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        getContentPane().add(viewerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        this.currentListIndex++;
        this.showDocumentWithIndex(this.currentListIndex);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        this.currentListIndex--;
        this.showDocumentWithIndex(this.currentListIndex);
    }//GEN-LAST:event_previousButtonActionPerformed

    private void tagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagButtonActionPerformed
        this.tagDocument(this.currentDocument);
    }//GEN-LAST:event_tagButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        this.exportDocument(this.currentDocument);
    }//GEN-LAST:event_exportButtonActionPerformed

    private void viewItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemButtonActionPerformed
        this.viewDocument(this.currentDocument);
    }//GEN-LAST:event_viewItemButtonActionPerformed

    private void displayParentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayParentButtonActionPerformed
        Item item = this.getItemForDocument(this.currentDocument);
        
        if ( item.getDocumentParentId() != 0 ) {
            System.out.println("have parent: " + item.getDocumentParentId());
            Item perentItem = ItemFactory.newInstance(getCurrentDocument(item.getDocumentParentId()), caseObj);
            System.out.println("parent id: " + perentItem.getDocumentId());
            FileItem parentFileItem = (FileItem) perentItem;
            
            System.out.println("path: " + parentFileItem.getFilePath());
        }
        else {
            System.out.println("this document have no parent");
        }
    }//GEN-LAST:event_displayParentButtonActionPerformed

    private void displayChildsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayChildsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayChildsButtonActionPerformed

    private void viewDocument(final Document document) {
        if ( IndexingConstant.isFileDocument(document) ) {
            try {
                String filePath = document.get(IndexingConstant.FILE_PATH);
                String fullPath = this.caseManger.getFullPath(filePath);
                this.openFile(fullPath);
            } catch (IOException ex) {
                Logger.getLogger(SourceViewerDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    private void openFile(final String path) throws IOException{
        File file = new File(path);
        if ( file.exists() ) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
    }
    
    private void tagDocument(final Document document) {
        StringBuilder result = new StringBuilder();
        
        if ( IndexingConstant.isFileDocument(document) ) {
            String fileName = document.get(IndexingConstant.FILE_NAME);
            String filePath = document.get(IndexingConstant.FILE_PATH);
            String date = document.get(IndexingConstant.FILE_DATE);
            String embedded = document.get(IndexingConstant.DOCUMENT_PARENT_ID);
            String mime = document.get(IndexingConstant.FILE_MIME);
            
            result.append("File: ").append(fileName).append("\n")
                .append("Location: ").append(filePath).append("\n")
                .append("Modification Time: ").append(date).append("\n")
                .append("Extension: ").append(mime).append("\n")
                .append("Contain: ").append(embedded).append(" Document(s)").append("\n");
        }
        
        TagsDialog tagDialog = new TagsDialog(this.parent, true);
        tagDialog.setContent(result.toString());
        tagDialog.setVisible(true);
        
        Tag tag = tagDialog.getTag();
        
        if ( tag !=  null ) {
            this.tagManger.addTag(tag);
            ((CaseFrame)this.parent).refreshTagsList();
        }
    }
    
    private void exportDocument(final Document document) {
        if ( IndexingConstant.isFileDocument(document) ) {
            String filePath = document.get(IndexingConstant.FILE_PATH);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(filePath));
            
            int result = fileChooser.showSaveDialog(this.parent);
            if ( result == JFileChooser.APPROVE_OPTION ) {
                File file = fileChooser.getSelectedFile();
                try {
                    String fullPath = this.caseManger.getFullPath(filePath);
                    FileUtil.saveObject(new FileInputStream(fullPath), file.getAbsolutePath());
                }
                catch(Exception e) { e.printStackTrace(); }
            }
        }
    }
    
    private void showDocumentWithIndex (final int id) {
        checkControlButtons();
        this.currentDocument = this.getCurrentDocument(this.documentsId.get(id));
        displayDocument(this.currentDocument );    
    }
    
    private void displayDocument (final Document document ) {
        JPanel panel = null;
        
        Item item = getItemForDocument(document);
        
        if ( IndexingConstant.isFileDocument(document) ) {
            panel = new FileSourceViewerPanel(this, item);
        }
        else if ( IndexingConstant.isChatDocument(document) ) {
            panel = new ChatSourceViewerPanel(this, item);
        }
        else if ( IndexingConstant.isOfflineEmailDocument(document) 
                    || IndexingConstant.isEmailDocument(document) ) {
            panel = new EmailSourceViewerPanel(this, item);
        }
        else if ( IndexingConstant.isImageDocument(document) ) {
            panel = new ImageSourceViewerPanel(this, item);
        }
        
        this.viewerPanel.setLayout(new BorderLayout());
        this.viewerPanel.add(panel, BorderLayout.CENTER);
        this.viewerPanel.revalidate();
    }
        
    private Document getCurrentDocument (final int docId ) {
        return this.searcher.getLuceneDocumentById(String.valueOf(docId));
    }
    
    private Item getItemForDocument(final Document document) {
        return ItemFactory.newInstance(document, this.caseObj);
    }
    
   
    /**
     * Enable or disable back/next button depend on current list id and max list id
     */
    private void checkControlButtons () {
        if ( this.documentsId.size() == 1 ) {
            this.previousButton.setEnabled(false);
            this.nextButton.setEnabled(false);
            return ;
        }
        
        if ( this.currentListIndex == 0 )
            this.previousButton.setEnabled(false);
        else
            this.previousButton.setEnabled(true);
        
        if ( this.currentListIndex == this.documentsId.size()-1 )
            this.nextButton.setEnabled(false);
        else
            this.nextButton.setEnabled(true);
        
        // remove any panel from render panel
        this.viewerPanel.removeAll();
    }
    
    /*
     * methods that used by custome panel (document, chat, email)
     * to get the current document and show it in a proper way 
     * specific to the type of the viewer
     */
    LuceneSearcher getLuceneSearch() { return this.searcher ; }
    String getQueryString() { return this.keyword ; }
    String getCurrentId() { return String.valueOf(this.documentsId.get(this.currentListIndex));  }
    Case getCase() { return this.caseObj; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton displayChildsButton;
    private javax.swing.JButton displayParentButton;
    private javax.swing.JPanel embeddedPanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton tagButton;
    private javax.swing.JButton viewItemButton;
    private javax.swing.JPanel viewerPanel;
    // End of variables declaration//GEN-END:variables
}
