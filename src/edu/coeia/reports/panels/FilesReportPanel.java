/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListAllFilesReportPanel.java
 *
 * Created on Jan 14, 2012, 7:44:49 AM
 */
package edu.coeia.reports.panels;

import edu.coeia.reports.ReportPanel;
import edu.coeia.reports.DatasourceXml;
import edu.coeia.reports.IndexUtil;
import edu.coeia.reports.RawResultFile;

import java.io.IOException;

/**
 *
 * @author wajdyessam
 */
public class FilesReportPanel extends javax.swing.JPanel implements ReportGenerator{

    private final ReportPanel reportPanel ;
    
    /** Creates new form ListAllFilesReportPanel */
    public FilesReportPanel(ReportPanel panel) {
        initComponents();
        this.reportPanel = panel;
    }

    @Override
    public DatasourceXml generateReport() throws IOException {
        DatasourceXml objXmlSource =new DatasourceXml();
        
        objXmlSource = 
                RawResultFile.getFileSystemXmlFile(
                    IndexUtil.getAllFilePaths(this.reportPanel.getCaseFacade())
                    ,this.reportPanel.getCaseFacade()
                );
        return objXmlSource;
    }
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("This report will listting all the files inside the case and its size and the creation");

        jLabel2.setText("date for each file");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
