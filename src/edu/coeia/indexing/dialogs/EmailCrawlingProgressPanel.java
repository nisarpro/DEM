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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wajdyessam
 */
public class EmailCrawlingProgressPanel extends javax.swing.JPanel {

    /** Creates new form OfflineEmailCrawlingProgressPanel */
    public EmailCrawlingProgressPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        agentTypeTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        currentFolderTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fromTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        toTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        currentMessageSubjectTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        messageDateTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        attachmentsTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 241));
        jPanel2.setMinimumSize(new java.awt.Dimension(160, 241));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/indexing/dialogs/Bundle"); // NOI18N
        jLabel8.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel8.text")); // NOI18N
        jPanel2.add(jLabel8);

        agentTypeTextField.setText(bundle.getString("EmailCrawlingProgressPanel.agentTypeTextField.text")); // NOI18N
        agentTypeTextField.setEnabled(false);
        jPanel2.add(agentTypeTextField);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel10.text")); // NOI18N
        jPanel2.add(jLabel10);

        currentFolderTextField.setText(bundle.getString("EmailCrawlingProgressPanel.currentFolderTextField.text")); // NOI18N
        currentFolderTextField.setEnabled(false);
        jPanel2.add(currentFolderTextField);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel1.text")); // NOI18N
        jPanel2.add(jLabel1);

        fromTextField.setText(bundle.getString("EmailCrawlingProgressPanel.fromTextField.text")); // NOI18N
        fromTextField.setEnabled(false);
        jPanel2.add(fromTextField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel2.text")); // NOI18N
        jPanel2.add(jLabel2);

        toTextField.setText(bundle.getString("EmailCrawlingProgressPanel.toTextField.text")); // NOI18N
        toTextField.setEnabled(false);
        jPanel2.add(toTextField);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel11.text")); // NOI18N
        jPanel2.add(jLabel11);

        currentMessageSubjectTextField.setText(bundle.getString("EmailCrawlingProgressPanel.currentMessageSubjectTextField.text")); // NOI18N
        currentMessageSubjectTextField.setEnabled(false);
        jPanel2.add(currentMessageSubjectTextField);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel12.text")); // NOI18N
        jPanel2.add(jLabel12);

        messageDateTextField.setText(bundle.getString("EmailCrawlingProgressPanel.messageDateTextField.text")); // NOI18N
        messageDateTextField.setEnabled(false);
        jPanel2.add(messageDateTextField);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText(bundle.getString("EmailCrawlingProgressPanel.jLabel14.text")); // NOI18N
        jPanel2.add(jLabel14);

        attachmentsTextArea.setColumns(20);
        attachmentsTextArea.setEditable(false);
        attachmentsTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        attachmentsTextArea.setRows(5);
        attachmentsTextArea.setEnabled(false);
        jScrollPane2.setViewportView(attachmentsTextArea);

        jPanel2.add(jScrollPane2);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void setAgentType(final String name) { this.agentTypeTextField.setText(name); }
    public void setCurrentFolder(final String folder) { this.currentFolderTextField.setText(folder); }
    public void setCurrentMessageSubject(final String subject) { this.currentMessageSubjectTextField.setText(subject); }
    public void setMessageDate(final String date) { this.messageDateTextField.setText(date); }
    public void setFrom(final String from) { this.fromTextField.setText(from); }
    public void setTo(final String to) { this.toTextField.setText(to); }
    
    public void setAttachment(final List<String> attachmentsName) {
        this.attachmentsTextArea.setText("");
        
        for(String attachment: attachmentsName) {
            this.attachmentsTextArea.append(attachment);
            this.attachmentsTextArea.append("\n");
        }
    }
        
    public static class EmailCrawlingData {
        private final String agentType;
        private final String currentFolder;
        private final String subject;
        private final String date;
        private final String hasAttachment;
        private final String from;
        private final String to;
        private final List<String> attachments;
        
        public EmailCrawlingData(final String agentType, final String currentFolder,
                final String subject, final String date, final String hasAttachment,
                final String from, final String to, final List<String> attachments) {
            this.agentType = agentType;
            this.currentFolder = currentFolder;
            this.subject = subject;
            this.date = date;
            this.hasAttachment = hasAttachment;
            this.from = from;
            this.to = to;
            this.attachments = new ArrayList<String>();
            this.attachments.addAll(Collections.unmodifiableList(attachments));
        }
        
        public String getAgentType() { return this.agentType; }
        public String getCurrentFolder() { return this.currentFolder; }
        public String getSubject() { return this.subject; }
        public String getDate() { return this.date; }
        public String getHasAttachment() { return this.hasAttachment ;}
        public String getFrom() { return this.from ; }
        public String getTo() { return this.to; }
        public List<String> getAttachments() { return Collections.unmodifiableList(this.attachments); }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agentTypeTextField;
    private javax.swing.JTextArea attachmentsTextArea;
    private javax.swing.JTextField currentFolderTextField;
    private javax.swing.JTextField currentMessageSubjectTextField;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField messageDateTextField;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}
