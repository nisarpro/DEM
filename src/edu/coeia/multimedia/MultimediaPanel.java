/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MultimediaPanel.java
 *
 * Created on Jan 3, 2012, 10:16:25 AM
 */
package edu.coeia.multimedia;

import edu.coeia.cases.CaseFacade;
import edu.coeia.main.CaseMainFrame;

import javax.swing.JFrame;

public class MultimediaPanel extends javax.swing.JPanel {
    private final CaseMainFrame caseFrame ;
    private final CaseFacade caseFacade;

    /** Creates new form MultimediaPanel */
    public MultimediaPanel(final JFrame frame) {
        initComponents();
        
        this.caseFrame = (CaseMainFrame) frame;
        this.caseFacade =  this.caseFrame.getCaseFacade();
        
        MultimediaViewerPanel audioPanel = new MultimediaViewerPanel(this.caseFacade,
                MultimediaViewerPanel.TYPE.AUDIO);
        
        MultimediaViewerPanel videoPanel = new MultimediaViewerPanel(this.caseFacade,
                MultimediaViewerPanel.TYPE.VIDEO);
                
        MultimediaViewerPanel archivePanel = new MultimediaViewerPanel(this.caseFacade,
                MultimediaViewerPanel.TYPE.ARCHIVE);
        
        MultimediaViewerPanel imageViewer = new MultimediaViewerPanel(this.caseFacade,
                MultimediaViewerPanel.TYPE.IMAGE);
        
        ImageViewerPanel imageThumbnailViewer = new ImageViewerPanel(this.caseFacade,
                this.caseFrame);
        
        this.multimediaTappedPane.addTab("Image Thumbnail Viewer", imageThumbnailViewer);
        this.multimediaTappedPane.addTab("Image Viewer", imageViewer);
        this.multimediaTappedPane.addTab("Audio Viewer", audioPanel);
        this.multimediaTappedPane.addTab("Archieve Viewer", archivePanel);
        this.multimediaTappedPane.addTab("Video Viewer", videoPanel);
    }
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        multimediaTappedPane = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(multimediaTappedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(multimediaTappedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane multimediaTappedPane;
    // End of variables declaration//GEN-END:variables
}
