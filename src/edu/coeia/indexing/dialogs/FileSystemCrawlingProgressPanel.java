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
package edu.coeia.indexing.dialogs;

import edu.coeia.constants.ResourceManager;
import java.awt.ComponentOrientation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wajdyessam
 */
public class FileSystemCrawlingProgressPanel extends javax.swing.JPanel{

    /** Creates new form FileSystemCrawlingProgressPanel */
    public FileSystemCrawlingProgressPanel() {
        initComponents();
        this.applyComponentOrientation(ComponentOrientation.getOrientation(ResourceManager.getLanguage()));
    }

    public void setCurrentFile(final String fileName) { this.currentFileTextField.setText(fileName); }
    public void setFileSize(final String size) { this.fileSizeTextField.setText(size); }
    public void setFileExtension(final String ext) { this.fileExtensionTextField.setText(ext) ; }
    public void setFileDate(final String date) { this.fileDateTextField.setText(date); }
    
    public void setEmbeddedDocuments(final List<String> documents) {
        this.embeddedDocumentsTextArea.setText("");
        
        for(String doc: documents) {
            this.embeddedDocumentsTextArea.append(doc);
            this.embeddedDocumentsTextArea.append("\n");
        }
    }
    
    public void clear() {
        this.setFileExtension("");
        this.setCurrentFile("");
        this.setFileSize("");
    }
    
    public static class FileSystemCrawlerData {
        private final String fileName;
        private final String fileSize;
        private final String fileExtension;
        private final String fileDate;
        private final List<String> embeddedDocs;
        
        public FileSystemCrawlerData(final String fileName, final String fileSize, 
                final String fileExtension, final String fileDate,
                final List<String> embeddedDocs) {
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileExtension = fileExtension;
            this.fileDate = fileDate;
            this.embeddedDocs = new ArrayList<String>();
            //this.embeddedDocs.addAll(Collections.unmodifiableList(embeddedDocs));
        }
        
        public String getFileName() { return this.fileName; }
        public String getFileSize() { return this.fileSize; }
        public String getFileExtension() { return this.fileExtension; }
        public String getFileDate() { return this.fileDate ;}
        public List<String> getEmbeddedDocuments() {  return Collections.unmodifiableList(this.embeddedDocs); }
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
        jLabel26 = new javax.swing.JLabel();
        currentFileTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        fileSizeTextField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        fileExtensionTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fileDateTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        embeddedDocumentsTextArea = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/indexing/dialogs/Bundle"); // NOI18N
        jLabel26.setText(bundle.getString("FileSystemCrawlingProgressPanel.jLabel26.text")); // NOI18N
        jPanel1.add(jLabel26);

        currentFileTextField.setText(bundle.getString("FileSystemCrawlingProgressPanel.currentFileTextField.text")); // NOI18N
        currentFileTextField.setEnabled(false);
        jPanel1.add(currentFileTextField);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText(bundle.getString("FileSystemCrawlingProgressPanel.jLabel27.text")); // NOI18N
        jPanel1.add(jLabel27);

        fileSizeTextField.setText(bundle.getString("FileSystemCrawlingProgressPanel.fileSizeTextField.text")); // NOI18N
        fileSizeTextField.setEnabled(false);
        jPanel1.add(fileSizeTextField);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText(bundle.getString("FileSystemCrawlingProgressPanel.jLabel28.text")); // NOI18N
        jPanel1.add(jLabel28);

        fileExtensionTextField.setText(bundle.getString("FileSystemCrawlingProgressPanel.fileExtensionTextField.text")); // NOI18N
        fileExtensionTextField.setEnabled(false);
        jPanel1.add(fileExtensionTextField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(bundle.getString("FileSystemCrawlingProgressPanel.jLabel2.text")); // NOI18N
        jPanel1.add(jLabel2);

        fileDateTextField.setEditable(false);
        jPanel1.add(fileDateTextField);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("FileSystemCrawlingProgressPanel.jLabel1.text")); // NOI18N
        jPanel1.add(jLabel1);

        embeddedDocumentsTextArea.setColumns(20);
        embeddedDocumentsTextArea.setEditable(false);
        embeddedDocumentsTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        embeddedDocumentsTextArea.setRows(5);
        embeddedDocumentsTextArea.setEnabled(false);
        jScrollPane1.setViewportView(embeddedDocumentsTextArea);

        jPanel1.add(jScrollPane1);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentFileTextField;
    private javax.swing.JTextArea embeddedDocumentsTextArea;
    private javax.swing.JTextField fileDateTextField;
    private javax.swing.JTextField fileExtensionTextField;
    private javax.swing.JTextField fileSizeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
