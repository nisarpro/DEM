/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IndexingDialog.java
 *
 * Created on Sep 10, 2011, 9:01:08 AM
 */
package edu.coeia.indexing;


import edu.coeia.util.FilesPath;
import edu.coeia.cases.Case;
import edu.coeia.gutil.IndexGUIComponent;
import edu.coeia.gutil.JTableUtil;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wajdyessam
 */
public class IndexingDialog extends javax.swing.JDialog {

    private List<String> imagesPath ;

    private CrawlerThread indexerThread ;
    private boolean startIndexButtonFlag = true ;
    
    private Case caseObj;
    private boolean startIndexNow ;
    
    /** Creates new form IndexingDialog */
    public IndexingDialog(java.awt.Frame parent, boolean modal, Case aCase, boolean startIndexNow) {
        super(parent, modal);
        initComponents();
        
        this.startIndexNow = startIndexNow ;
        
        // set start and end button
        startIndexButton.setEnabled(startIndexButtonFlag);
        stopIndexingButton.setEnabled(! startIndexButtonFlag);
        
        this.imagesPath = new ArrayList<String>();
        this.caseObj = aCase;
        
        // display indexing information if already indexing
        if ( caseObj.getIndexStatus() ) {
            indexDateLbl.setText(caseObj.getLastIndexDate());
            timeLbl.setText(caseObj.getIndexingTime());
        }
        
        // close thread if the thread running and user close the window
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
                stopIndex();
            }
        });
        
        if (this.startIndexNow) {
            startIndex();
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

        indexPanel = new javax.swing.JPanel();
        progressStatusPanel = new javax.swing.JPanel();
        progresLabelPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        currentFileLbl = new javax.swing.JLabel();
        numberOfFilesLbl = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        numberOfErrorFilesLbl = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        sizeOfFileLbl = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        fileExtensionLbl = new javax.swing.JLabel();
        bigSizeMsgLbl = new javax.swing.JLabel();
        indexControlPanel = new javax.swing.JPanel();
        startIndexButton = new javax.swing.JButton();
        stopIndexingButton = new javax.swing.JButton();
        progressPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        InfinatePanel = new javax.swing.JPanel();
        loggingPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        indexTable = new javax.swing.JTable();
        indexHistoryPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        indexDateLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Case Indexing Window");

        indexPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        indexPanel.setLayout(new java.awt.BorderLayout());

        progressStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Index File System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        progressStatusPanel.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel23.setText("Current File:");

        currentFileLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        currentFileLbl.setForeground(new java.awt.Color(0, 0, 255));
        currentFileLbl.setText(" ");

        numberOfFilesLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        numberOfFilesLbl.setForeground(new java.awt.Color(0, 0, 255));
        numberOfFilesLbl.setText(" ");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel27.setText("Number of Files in Index:");

        numberOfErrorFilesLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        numberOfErrorFilesLbl.setForeground(new java.awt.Color(0, 0, 255));
        numberOfErrorFilesLbl.setText(" ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel25.setText("File Size:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel41.setText("Number of Files Cannot Indexed:");

        sizeOfFileLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        sizeOfFileLbl.setForeground(new java.awt.Color(0, 0, 255));
        sizeOfFileLbl.setText(" ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel24.setText("File Extension:");

        fileExtensionLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        fileExtensionLbl.setForeground(new java.awt.Color(0, 0, 255));
        fileExtensionLbl.setText(" ");

        bigSizeMsgLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        bigSizeMsgLbl.setForeground(new java.awt.Color(255, 0, 0));
        bigSizeMsgLbl.setText(" ");

        javax.swing.GroupLayout progresLabelPanelLayout = new javax.swing.GroupLayout(progresLabelPanel);
        progresLabelPanel.setLayout(progresLabelPanelLayout);
        progresLabelPanelLayout.setHorizontalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(progresLabelPanelLayout.createSequentialGroup()
                        .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentFileLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(progresLabelPanelLayout.createSequentialGroup()
                        .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bigSizeMsgLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, progresLabelPanelLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numberOfFilesLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, progresLabelPanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(sizeOfFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numberOfErrorFilesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fileExtensionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        progresLabelPanelLayout.setVerticalGroup(
            progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progresLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(currentFileLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(sizeOfFileLbl)
                    .addComponent(fileExtensionLbl)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(progresLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(numberOfFilesLbl)
                    .addComponent(jLabel41)
                    .addComponent(numberOfErrorFilesLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bigSizeMsgLbl)
                .addContainerGap())
        );

        progressStatusPanel.add(progresLabelPanel, java.awt.BorderLayout.NORTH);

        startIndexButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        startIndexButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/database.png"))); // NOI18N
        startIndexButton.setText("Start Indexing");
        startIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startIndexButtonActionPerformed(evt);
            }
        });

        stopIndexingButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stopIndexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        stopIndexingButton.setText("Stop Indexing");
        stopIndexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopIndexingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout indexControlPanelLayout = new javax.swing.GroupLayout(indexControlPanel);
        indexControlPanel.setLayout(indexControlPanelLayout);
        indexControlPanelLayout.setHorizontalGroup(
            indexControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, indexControlPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(startIndexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(stopIndexingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        indexControlPanelLayout.setVerticalGroup(
            indexControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(indexControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopIndexingButton)
                    .addComponent(startIndexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        progressStatusPanel.add(indexControlPanel, java.awt.BorderLayout.SOUTH);

        InfinatePanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressPanelLayout.createSequentialGroup()
                        .addComponent(InfinatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(progressPanelLayout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfinatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        progressStatusPanel.add(progressPanel, java.awt.BorderLayout.CENTER);

        indexPanel.add(progressStatusPanel, java.awt.BorderLayout.NORTH);

        loggingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "logging", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        indexTable.setAutoCreateRowSorter(true);
        indexTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "File Type", "File Path", "Indexing Status"
            }
        ));
        jScrollPane1.setViewportView(indexTable);

        javax.swing.GroupLayout loggingPanelLayout = new javax.swing.GroupLayout(loggingPanel);
        loggingPanel.setLayout(loggingPanelLayout);
        loggingPanelLayout.setHorizontalGroup(
            loggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );
        loggingPanelLayout.setVerticalGroup(
            loggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggingPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        indexPanel.add(loggingPanel, java.awt.BorderLayout.CENTER);

        indexHistoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indexing History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Last Indexing Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Indexing Finishing Time:");

        timeLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        timeLbl.setForeground(new java.awt.Color(0, 0, 255));
        timeLbl.setText(" ");

        indexDateLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        indexDateLbl.setForeground(new java.awt.Color(0, 0, 255));
        indexDateLbl.setText(" ");

        javax.swing.GroupLayout indexHistoryPanelLayout = new javax.swing.GroupLayout(indexHistoryPanel);
        indexHistoryPanel.setLayout(indexHistoryPanelLayout);
        indexHistoryPanelLayout.setHorizontalGroup(
            indexHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexHistoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indexDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(timeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        indexHistoryPanelLayout.setVerticalGroup(
            indexHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexHistoryPanelLayout.createSequentialGroup()
                .addGroup(indexHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(indexHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(indexDateLbl))
                    .addComponent(timeLbl)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        indexPanel.add(indexHistoryPanel, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(indexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(indexPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startIndexButtonActionPerformed
        startIndex();
    }//GEN-LAST:event_startIndexButtonActionPerformed

    private void stopIndexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopIndexingButtonActionPerformed
        stopIndex();
    }//GEN-LAST:event_stopIndexingButtonActionPerformed

    private void startIndex () {
        File indexLocation = new File ( caseObj.getIndexLocation() + "\\" + FilesPath.INDEX_PATH );

        startIndexButton.setEnabled(! startIndexButtonFlag);
        stopIndexingButton.setEnabled(startIndexButtonFlag);

        JTableUtil.removeAllRows(indexTable);
        
        IndexGUIComponent indexGUI = new IndexGUIComponent(progressBar,indexTable,indexDateLbl
            ,timeLbl,currentFileLbl, sizeOfFileLbl, numberOfFilesLbl, fileExtensionLbl, numberOfErrorFilesLbl,bigSizeMsgLbl, startIndexButton,
            stopIndexingButton);

        indexerThread = new CrawlerThread(indexLocation,indexGUI,caseObj,imagesPath, this);
        indexerThread.execute();
    }
    
    private void stopIndex() {
        if ( indexerThread != null) {
            indexerThread.clearFields();
            indexerThread.cancel(true);
            indexerThread = null ;
        }
        
        this.setVisible(false);
    }
    
    public void closeDialog() {
        stopIndex();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InfinatePanel;
    private javax.swing.JLabel bigSizeMsgLbl;
    private javax.swing.JLabel currentFileLbl;
    private javax.swing.JLabel fileExtensionLbl;
    private javax.swing.JPanel indexControlPanel;
    private javax.swing.JLabel indexDateLbl;
    private javax.swing.JPanel indexHistoryPanel;
    private javax.swing.JPanel indexPanel;
    private javax.swing.JTable indexTable;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loggingPanel;
    private javax.swing.JLabel numberOfErrorFilesLbl;
    private javax.swing.JLabel numberOfFilesLbl;
    private javax.swing.JPanel progresLabelPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JPanel progressStatusPanel;
    private javax.swing.JLabel sizeOfFileLbl;
    private javax.swing.JButton startIndexButton;
    private javax.swing.JButton stopIndexingButton;
    private javax.swing.JLabel timeLbl;
    // End of variables declaration//GEN-END:variables
}
