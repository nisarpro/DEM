/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportOptionDialog.java
 *
 * Created on Jan 14, 2012, 7:41:41 AM
 */
package edu.coeia.reports;

import edu.coeia.cases.Case;
import edu.coeia.cases.CasePathHandler;
import edu.coeia.util.FilesPath;
import java.io.File;
import javax.swing.JPanel;

/**
 *
 * @author wajdyessam
 */
public class ReportOptionDialog extends javax.swing.JDialog {

    private JPanel centerReportPanel ;
    private ReportPanel reportPanel; 
    private CasePathHandler handler ;
    private Case aCase; 
    
    /** Creates new form ReportOptionDialog */
    public ReportOptionDialog(java.awt.Frame parent, boolean modal, JPanel panel, 
            ReportPanel reportPanel) {
        super(parent, modal);
        initComponents();
        
        this.centerReportPanel = panel;
        this.reportPanel = reportPanel;
        this.handler = this.reportPanel.getCasePathHandler();
        this.aCase = this.reportPanel.getCase();
        
        this.setCenterPanel(panel);
        this.pack();
        this.setLocationRelativeTo(parent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        cencelButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEM Report Options");

        centerPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Reports Options");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        cencelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/cancel.png"))); // NOI18N
        cencelButton.setText("Cancel");
        cencelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cencelButtonActionPerformed(evt);
            }
        });
        footerPanel.add(cencelButton);

        generateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/save.png"))); // NOI18N
        generateButton.setText("Generate Report");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        footerPanel.add(generateButton);

        getContentPane().add(footerPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cencelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cencelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cencelButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        ReportGenerator generator = (ReportGenerator) this.centerReportPanel;
        String result = generator.generateReport();
        System.out.println("result: " + result);
        generateReport(result);
    }//GEN-LAST:event_generateButtonActionPerformed

    private void setCenterPanel(JPanel panel) {
        this.centerPanel.removeAll();
        this.centerPanel.add(panel);
        this.centerPanel.revalidate();
        this.repaint();
    }
    
    private void generateReport(final String strXmlSource) {
        try {
            File file = new File(FilesPath.TEMPLATES+"\\filesystem_report.jasper");
            String strJasperFile = file.getAbsolutePath(); //"C:/Users/Farhan/Desktop/projects/DEM/templates/filesystem_report.jasper";
            String strReportOutputPath = aCase.getCaseLocation()+DisclosureReport.REPORTFOLDER;
            String strReportName = "filesystem";
            
            DisclosureReport disReport = new DisclosureReport(strJasperFile,
                                                              strXmlSource,
                                                              strReportOutputPath,strReportName);
            
            disReport.setOutputFileExtension(DisclosureReport.REPORT_TYPE.PDF);
            disReport.setRootXPath("/dem/detail/effectivefiles/file");
            disReport.Generate();
        }
        catch(Exception ex)
        {
            System.out.println("CAUSE: " + ex.getCause());
            System.out.println("MESSAGE" + ex.getMessage());
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cencelButton;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}