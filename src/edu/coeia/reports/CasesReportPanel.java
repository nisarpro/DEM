/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListAllCasesReportPanel.java
 *
 * Created on Jan 14, 2012, 7:57:20 AM
 */
package edu.coeia.reports;

/**
 *
 * @author wajdyessam
 */
public class CasesReportPanel extends javax.swing.JPanel implements ReportGenerator{

    private ReportPanel reportPanel ;
    
    /** Creates new form ListAllCasesReportPanel */
    public CasesReportPanel(ReportPanel panel) {
        initComponents();
        this.reportPanel = panel;
    }

    @Override
    public String generateReport() {
        return "this is listing of all cases report";
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

        jLabel1.setText("this report will display all the cases information with its create time and the auther");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
