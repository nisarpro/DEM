/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OfflineEmailCrawlingProgressPanel.java
 *
 * Created on Jan 14, 2012, 2:27:04 PM
 */
package edu.coeia.indexing;

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
        jLabel9 = new javax.swing.JLabel();
        emailPathTextField = new javax.swing.JTextField();
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
        jLabel13 = new javax.swing.JLabel();
        hasAttachmentTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        attachmentsTextArea = new javax.swing.JTextArea();

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText(" Email Agent:");
        jPanel2.add(jLabel8);

        agentTypeTextField.setText(" ");
        agentTypeTextField.setEnabled(false);
        jPanel2.add(agentTypeTextField);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Email Path:");
        jPanel2.add(jLabel9);

        emailPathTextField.setText(" ");
        emailPathTextField.setEnabled(false);
        jPanel2.add(emailPathTextField);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Current Folder:");
        jPanel2.add(jLabel10);

        currentFolderTextField.setText(" ");
        currentFolderTextField.setEnabled(false);
        jPanel2.add(currentFolderTextField);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("From:");
        jPanel2.add(jLabel1);

        fromTextField.setText(" ");
        fromTextField.setEnabled(false);
        jPanel2.add(fromTextField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("To:");
        jPanel2.add(jLabel2);

        toTextField.setText(" ");
        toTextField.setEnabled(false);
        jPanel2.add(toTextField);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("Current Message Subject:");
        jPanel2.add(jLabel11);

        currentMessageSubjectTextField.setText(" ");
        currentMessageSubjectTextField.setEnabled(false);
        jPanel2.add(currentMessageSubjectTextField);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText("Message Date:");
        jPanel2.add(jLabel12);

        messageDateTextField.setText(" ");
        messageDateTextField.setEnabled(false);
        jPanel2.add(messageDateTextField);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setText("Has Attachment:");
        jPanel2.add(jLabel13);

        hasAttachmentTextField.setText(" ");
        hasAttachmentTextField.setEnabled(false);
        jPanel2.add(hasAttachmentTextField);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setText("Attachments Name:");
        jPanel2.add(jLabel14);

        attachmentsTextArea.setColumns(20);
        attachmentsTextArea.setEditable(false);
        attachmentsTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        attachmentsTextArea.setRows(5);
        attachmentsTextArea.setEnabled(false);
        jScrollPane2.setViewportView(attachmentsTextArea);

        jPanel2.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setAgentType(final String name) { this.agentTypeTextField.setText(name); }
    public void setEmailPath(final String path) { this.emailPathTextField.setText(path); }
    public void setCurrentFolder(final String folder) { this.currentFolderTextField.setText(folder); }
    public void setCurrentMessageSubject(final String subject) { this.currentMessageSubjectTextField.setText(subject); }
    public void setMessageDate(final String date) { this.messageDateTextField.setText(date); }
    public void setHasAttachment(final String state) { this.hasAttachmentTextField.setText(state); }
    public void setFrom(final String from) { this.fromTextField.setText(from); }
    public void setTo(final String to) { this.toTextField.setText(to); }
    
    public void setAttachment(final List<String> attachmentsName) {
        for(String attachment: attachmentsName) {
            this.attachmentsTextArea.append(attachment);
            this.attachmentsTextArea.append("\n");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agentTypeTextField;
    private javax.swing.JTextArea attachmentsTextArea;
    private javax.swing.JTextField currentFolderTextField;
    private javax.swing.JTextField currentMessageSubjectTextField;
    private javax.swing.JTextField emailPathTextField;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JTextField hasAttachmentTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField messageDateTextField;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}