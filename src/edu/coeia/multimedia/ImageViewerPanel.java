/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImageViewerPanel.java
 *
 * Created on Jan 25, 2012, 11:14:19 AM
 */
package edu.coeia.multimedia;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.items.FileItem;
import edu.coeia.items.ItemFactory;
import edu.coeia.main.CaseMainFrame;
import edu.coeia.searching.LuceneSearcher;
import edu.coeia.tasks.ImageLoadingTask;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPanel;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
public class ImageViewerPanel extends javax.swing.JPanel {
    private final Case aCase;
    
    private int SCALE_FACTOR = 120;
    private int PAD_FACTOR = 2;
    private int ROWS_NUMBER = 10;
    private int IMAGE_PER_PAGE = 80;
    
    private int totalNumberOfImages ;
    private int totalNumberOfPages;
    
    private boolean isImageSizeIsComputed;   // get number of images in case, its computed one time
    private int currentImageNo;
    private int currentImagePage;
    
    private final CaseFacade caseFacade ;
    private final List<Integer> currentIds; 
    private final CaseMainFrame caseFrame; 
    
    /** Creates new form ImageViewerPanel */
    public ImageViewerPanel(final CaseFacade caseFacade, final CaseMainFrame caseFrame) {
        initComponents();
        this.caseFacade = caseFacade;
        this.aCase = this.caseFacade.getCase();
        this.currentIds = new ArrayList<Integer>();
        this.caseFrame = caseFrame;
        this.setImageViewerOptions();
        this.nextLabel.setEnabled(false);
        this.backLabel.setEnabled(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageOptionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scaleTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        padTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rowsTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        imagerPerPageTextField = new javax.swing.JTextField();
        applyOptionButton = new javax.swing.JButton();
        ImagePanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        nextLabel = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        pageLabel = new javax.swing.JLabel();
        renderPanel = new javax.swing.JPanel();
        filterPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        filterImageTextField = new javax.swing.JTextField();
        loadImageButton = new javax.swing.JButton();
        StatusPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        imagePathTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        imageSizeTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lastModificationTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        hasGeoTaggingTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        metadataTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/multimedia/Bundle"); // NOI18N
        ImageOptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ImageViewerPanel.ImageOptionPanel.border.title"))); // NOI18N

        jLabel1.setText(bundle.getString("ImageViewerPanel.jLabel1.text")); // NOI18N

        scaleTextField.setText(bundle.getString("ImageViewerPanel.scaleTextField.text")); // NOI18N

        jLabel2.setText(bundle.getString("ImageViewerPanel.jLabel2.text")); // NOI18N

        padTextField.setText(bundle.getString("ImageViewerPanel.padTextField.text")); // NOI18N

        jLabel3.setText(bundle.getString("ImageViewerPanel.jLabel3.text")); // NOI18N

        rowsTextField.setText(bundle.getString("ImageViewerPanel.rowsTextField.text")); // NOI18N

        jLabel4.setText(bundle.getString("ImageViewerPanel.jLabel4.text")); // NOI18N

        imagerPerPageTextField.setText(bundle.getString("ImageViewerPanel.imagerPerPageTextField.text")); // NOI18N

        applyOptionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/save.png"))); // NOI18N
        applyOptionButton.setText(bundle.getString("ImageViewerPanel.applyOptionButton.text")); // NOI18N
        applyOptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyOptionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImageOptionPanelLayout = new javax.swing.GroupLayout(ImageOptionPanel);
        ImageOptionPanel.setLayout(ImageOptionPanelLayout);
        ImageOptionPanelLayout.setHorizontalGroup(
            ImageOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImageOptionPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ImageOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(padTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(rowsTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(imagerPerPageTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(scaleTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                .addGroup(ImageOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(applyOptionButton))
                    .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ImageOptionPanelLayout.setVerticalGroup(
            ImageOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageOptionPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(padTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagerPerPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(applyOptionButton)
                .addGap(205, 205, 205))
        );

        add(ImageOptionPanel, java.awt.BorderLayout.WEST);

        ImagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ImageViewerPanel.ImagePanel.border.title"))); // NOI18N
        ImagePanel.setLayout(new java.awt.BorderLayout());

        nextLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        nextLabel.setForeground(new java.awt.Color(0, 51, 204));
        nextLabel.setText(bundle.getString("ImageViewerPanel.nextLabel.text")); // NOI18N
        nextLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextLabelMouseClicked(evt);
            }
        });

        backLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        backLabel.setForeground(new java.awt.Color(0, 51, 204));
        backLabel.setText(bundle.getString("ImageViewerPanel.backLabel.text")); // NOI18N
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });

        pageLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        pageLabel.setForeground(new java.awt.Color(0, 51, 204));
        pageLabel.setText(bundle.getString("ImageViewerPanel.pageLabel.text")); // NOI18N

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextLabel)
                .addGap(64, 64, 64)
                .addComponent(pageLabel)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backLabel)
                    .addComponent(nextLabel)
                    .addComponent(pageLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ImagePanel.add(controlPanel, java.awt.BorderLayout.SOUTH);

        renderPanel.setLayout(new java.awt.BorderLayout());
        ImagePanel.add(renderPanel, java.awt.BorderLayout.CENTER);

        jLabel5.setText(bundle.getString("ImageViewerPanel.jLabel5.text")); // NOI18N

        filterImageTextField.setText(bundle.getString("ImageViewerPanel.filterImageTextField.text")); // NOI18N

        loadImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/kview.png"))); // NOI18N
        loadImageButton.setText(bundle.getString("ImageViewerPanel.loadImageButton.text")); // NOI18N
        loadImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterImageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(filterImageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadImageButton))
                .addGap(20, 20, 20))
        );

        ImagePanel.add(filterPanel, java.awt.BorderLayout.NORTH);

        add(ImagePanel, java.awt.BorderLayout.CENTER);

        StatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("ImageViewerPanel.StatusPanel.border.title"))); // NOI18N

        jLabel6.setText(bundle.getString("ImageViewerPanel.jLabel6.text")); // NOI18N

        imagePathTextField.setEditable(false);
        imagePathTextField.setText(bundle.getString("ImageViewerPanel.imagePathTextField.text")); // NOI18N

        jLabel7.setText(bundle.getString("ImageViewerPanel.jLabel7.text")); // NOI18N

        imageSizeTextField.setEditable(false);
        imageSizeTextField.setText(bundle.getString("ImageViewerPanel.imageSizeTextField.text")); // NOI18N

        jLabel8.setText(bundle.getString("ImageViewerPanel.jLabel8.text")); // NOI18N

        lastModificationTextField.setEditable(false);
        lastModificationTextField.setText(bundle.getString("ImageViewerPanel.lastModificationTextField.text")); // NOI18N

        jLabel9.setText(bundle.getString("ImageViewerPanel.jLabel9.text")); // NOI18N

        hasGeoTaggingTextField.setEditable(false);
        hasGeoTaggingTextField.setText(bundle.getString("ImageViewerPanel.hasGeoTaggingTextField.text")); // NOI18N

        jLabel10.setText(bundle.getString("ImageViewerPanel.jLabel10.text")); // NOI18N

        metadataTextArea.setColumns(20);
        metadataTextArea.setEditable(false);
        metadataTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        metadataTextArea.setRows(5);
        metadataTextArea.setEnabled(false);
        jScrollPane1.setViewportView(metadataTextArea);

        javax.swing.GroupLayout StatusPanelLayout = new javax.swing.GroupLayout(StatusPanel);
        StatusPanel.setLayout(StatusPanelLayout);
        StatusPanelLayout.setHorizontalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(imagePathTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageSizeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastModificationTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(hasGeoTaggingTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        StatusPanelLayout.setVerticalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastModificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hasGeoTaggingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(StatusPanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageButtonActionPerformed
        this.currentImageNo = 0;
        this.currentImagePage = 0;
        
        ImageLoadingTask task = new ImageLoadingTask(this.caseFacade, this);
        task.startTask();
    }//GEN-LAST:event_loadImageButtonActionPerformed

    private void applyOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyOptionButtonActionPerformed
       this.setImageViewerOptions();
    }//GEN-LAST:event_applyOptionButtonActionPerformed

    private void nextLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextLabelMouseClicked
        if ( this.currentImagePage == this.totalNumberOfPages )
            return ;
                
        this.currentImagePage++;
        this.currentImageNo += this.IMAGE_PER_PAGE;

        ImageLoadingTask task = new ImageLoadingTask(this.caseFacade, this);
        task.startTask();
    }//GEN-LAST:event_nextLabelMouseClicked

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        if ( this.currentImagePage == 0 )
            return ;
        
        this.currentImagePage--;
        this.currentImageNo -= this.IMAGE_PER_PAGE;

        ImageLoadingTask task = new ImageLoadingTask(this.caseFacade, this);
        task.startTask();    
    }//GEN-LAST:event_backLabelMouseClicked

    private void setImageViewerOptions() {
        SCALE_FACTOR = Integer.parseInt(this.scaleTextField.getText().trim());
        PAD_FACTOR = Integer.parseInt(this.padTextField.getText().trim());
        ROWS_NUMBER = Integer.parseInt(this.rowsTextField.getText().trim());
        IMAGE_PER_PAGE = Integer.parseInt(this.imagerPerPageTextField.getText().trim());
    }
    
    public void setStatusInformation(final ImageIconWithDocumentId selectedImage) {
        try {
            LuceneSearcher searcher = new LuceneSearcher(this.aCase);
            Document currentDocument = searcher.getLuceneDocumentById(String.valueOf(selectedImage.getId()));
            
            FileItem item = (FileItem) ItemFactory.newInstance(currentDocument, caseFacade, false);
            String fileName = item.getFileName();
            String filePath = item.getFilePath();
            String date = item.getFileDate();
            String metadata = item.getMetadata();
            
            this.imagePathTextField.setText(filePath);
            this.imageSizeTextField.setText(fileName);
            this.lastModificationTextField.setText(date);
            this.hasGeoTaggingTextField.setText(String.valueOf(GeoTagging.hasGoeTag(filePath)));
            this.metadataTextArea.setText(metadata);
            
            searcher.closeSearcher();
        } catch (Exception ex) {
            Logger.getLogger(ImageViewerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkImageControllingButtons() {
        if ( this.currentImagePage == 0 && 
             this.currentImagePage == this.totalNumberOfPages ) {
            nextLabel.setEnabled(false);
            backLabel.setEnabled(false);
        }
        
        else if ( this.currentImagePage == 0  ) {
            nextLabel.setEnabled(true);
            backLabel.setEnabled(false);
        }
        
        else if ( this.currentImagePage == this.totalNumberOfPages ) {
            nextLabel.setEnabled(false);
            backLabel.setEnabled(true);
        }
        else {
            nextLabel.setEnabled(true);
            backLabel.setEnabled(true);
        }
        
        // update pages label
        this.pageLabel.setText(String.format("(%d/%d)", this.currentImagePage, this.totalNumberOfPages));
    }
    
   public void computeNumberOfPages() { 
        this.currentImageNo = 0;
        this.currentImagePage = 0 ;
        this.totalNumberOfPages = this.totalNumberOfImages / this.IMAGE_PER_PAGE ;
    }
    
    public static final class FilteredList extends JList {

        private final JTextField textField;

        public FilteredList(final JTextField field) {
            super();

            this.textField = field;
            this.setModel(new FilteredModel());
            setDocumentListener();
        }

        @Override
        public void setModel(ListModel model) {
            if (!(model instanceof FilteredModel)) {
                throw (new IllegalArgumentException());
            }

            super.setModel(model);
        }

        public void addItem(Object o) {
            ((FilteredModel) getModel()).addElement(o);
        }

        public void update() {
            ((FilteredModel) getModel()).refilter();
        }

        private class FilteredModel extends AbstractListModel {

            public FilteredModel() {
                super();
                items = new ArrayList<ImageIconWithDocumentId>();
                fItems = new ArrayList<ImageIconWithDocumentId>();
            }

            public Object getElementAt(int index) {
                if (index < fItems.size()) {
                    return fItems.get(index);
                } else {
                    return null;
                }
            }

            public int getSize() {
                return fItems.size();
            }

            public void addElement(Object o) {
                items.add((ImageIconWithDocumentId) o);
            }

            private void refilter() {
                fItems.clear();
                String term = textField.getText().trim();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getDescription().indexOf(term, 0) != -1) {
                        fItems.add(items.get(i));
                    }
                }

                fireContentsChanged(this, 0, getSize());
            }
            private List<ImageIconWithDocumentId> items;
            private List<ImageIconWithDocumentId> fItems;
        }

        private void setDocumentListener() {
            this.textField.getDocument().addDocumentListener(
            new DocumentListener() {

                public void changedUpdate(DocumentEvent e) {
                    ((FilteredModel) getModel()).refilter();
                }

                public void insertUpdate(DocumentEvent e) {
                    ((FilteredModel) getModel()).refilter();
                }

                public void removeUpdate(DocumentEvent e) {
                    ((FilteredModel) getModel()).refilter();
                }
            });
        }
    }

    public static class ImageIconWithDocumentId extends ImageIcon {

        private final int documentId;

        public ImageIconWithDocumentId(BufferedImage img, String name, int docId) {
            super(img, name);
            this.documentId = docId;
        }

        public int getId() {
            return this.documentId;
        }
    }

    public static class MyCellRenderer extends JLabel implements ListCellRenderer {

        public MyCellRenderer() {
            this.setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {

            ImageIconWithDocumentId icon = (ImageIconWithDocumentId) value;

            //this.setText(icon.getDescription());
            this.setIcon(icon);
            this.setVerticalTextPosition(SwingConstants.BOTTOM);
            this.setHorizontalTextPosition(SwingConstants.CENTER);
            this.setAlignmentX(20);
            this.setAlignmentY(20);
            
            if (isSelected) {
                this.setBackground(Color.GRAY);
                this.setForeground(Color.WHITE);
            } else {
                this.setBackground(Color.WHITE);
                this.setForeground(Color.GRAY);
            }

            return this;
        }
    }

    public void setIds(final List<Integer> ids) {
        this.currentIds.clear();
        this.currentIds.addAll(ids);
    }
    
    public List<Integer> getIds() { return Collections.unmodifiableList(this.currentIds); }
    public JPanel getRenderPanel() { return this.renderPanel;  }
    public int getScaleFactor() { return this.SCALE_FACTOR; }
    public int getPadFactor() { return this.PAD_FACTOR ; }
    public int getRowsNumber() { return this.ROWS_NUMBER; }
    public int getImagePerPage() { return this.IMAGE_PER_PAGE; }
    public int getCurrentImagePage() { return this.currentImagePage; }
    public int getCurrentImageNo() { return this.currentImageNo; }
    public int getTotalNumberOfImages() { return this.totalNumberOfImages; }
    public int getTotalNumberOfPages() { return this.totalNumberOfPages; }
    public JTextField getFilterTextField() { return this.filterImageTextField; }
    public boolean isImageSizeIsComputed() { return this.isImageSizeIsComputed; }
    public void setImageSizeFlag() { this.isImageSizeIsComputed = true; }
    public void setTotalNumberOfImages(int total) { this.totalNumberOfImages = total; }
    public CaseMainFrame getCaseFrame() { return this.caseFrame ; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImageOptionPanel;
    private javax.swing.JPanel ImagePanel;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JButton applyOptionButton;
    private javax.swing.JLabel backLabel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextField filterImageTextField;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JTextField hasGeoTaggingTextField;
    private javax.swing.JTextField imagePathTextField;
    private javax.swing.JTextField imageSizeTextField;
    private javax.swing.JTextField imagerPerPageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastModificationTextField;
    private javax.swing.JButton loadImageButton;
    private javax.swing.JTextArea metadataTextArea;
    private javax.swing.JLabel nextLabel;
    private javax.swing.JTextField padTextField;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JPanel renderPanel;
    private javax.swing.JTextField rowsTextField;
    private javax.swing.JTextField scaleTextField;
    // End of variables declaration//GEN-END:variables
}



