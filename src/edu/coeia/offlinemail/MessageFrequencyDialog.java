/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MessageFrequencyDialog.java
 *
 * Created on Jul 4, 2010, 1:33:06 PM
 */

package edu.coeia.offlinemail;

/**
 *
 * @author wajdyessam
 */

import java.awt.BorderLayout ;
import java.awt.Toolkit ;


import com.pff.PSTFile ;

import edu.coeia.gutil.InfiniteProgressPanel;
import java.util.ArrayList ;
import javax.swing.JPanel;

public class MessageFrequencyDialog extends javax.swing.JDialog {
    String folderName, pstPath, from, to, userName;
    PSTFile pst ;
    
    /** Creates new form MessageFrequencyDialog */
    public MessageFrequencyDialog(java.awt.Frame parent, boolean modal, ArrayList<Message> msgs,
            String folderName, PSTFile testPST,  String path,
            String from, String to, String fromUser) {

        super(parent, modal);

        this.folderName = folderName;
        this.pst = testPST;
        this.pstPath = path;
        this.from = from;
        this.to = to;
        this.userName = fromUser;
       
        this.setUndecorated(true);
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize()); // maximize JDialog

        initComponents();

        for (Message msg: msgs ) {
            messageFreqNameComboBox.addItem(msg.getSenderName());
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

        jPanel2 = new javax.swing.JPanel();
        numLbl = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        messageFreqNameComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        messageFrequencyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        numLbl.setFont(new java.awt.Font("Arial", 1, 11));
        numLbl.setForeground(new java.awt.Color(0, 0, 204));
        numLbl.setText(" ");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        showButton.setText("Show Message Frequency");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Name:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageFreqNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLbl)
                    .addComponent(jLabel2)
                    .addComponent(messageFreqNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeButton)
                    .addComponent(showButton))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        messageFrequencyPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(messageFrequencyPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageFrequencyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        messageFrequencyPanel.removeAll();

        String otherName = (String) messageFreqNameComboBox.getSelectedItem();

        InfiniteProgressPanel i = new InfiniteProgressPanel("Messages Communication Between " + userName +
                " And " + otherName + " ...");
        this.setGlassPane(i);
        i.start();

        EmailVisualizationThread thread = new EmailVisualizationThread(this, i, folderName, pst, pstPath, from, to, EmailVisualizationThread.FolderType.COMMUNICATION,
                userName, otherName);
        thread.execute();
}//GEN-LAST:event_showButtonActionPerformed

    public void setPanel (JPanel panel) {
        messageFrequencyPanel.add(panel, BorderLayout.CENTER);
        messageFrequencyPanel.revalidate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox messageFreqNameComboBox;
    private javax.swing.JPanel messageFrequencyPanel;
    private javax.swing.JLabel numLbl;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

}