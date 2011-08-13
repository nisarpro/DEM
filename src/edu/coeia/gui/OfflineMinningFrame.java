
package edu.coeia.gui;

import edu.coeia.cases.Case;
import edu.coeia.utility.Utilities;
import edu.coeia.gui.utilties.GuiUtil ;
import edu.coeia.gui.chat.ChatPanel;
import edu.coeia.gui.email.EmailPanel;
import edu.coeia.gui.filesystem.FileSystemPanel;
import edu.coeia.gui.images.ImagesViewerPanel;
import edu.coeia.gui.internet.InternetSurfingPanel;

import java.awt.Toolkit ;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame ;
import javax.swing.JOptionPane;

import java.io.IOException ;

import java.util.List; 
import java.util.ArrayList ;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * OfflineMinningFrame.java
 *
 * @author wajdyessam
 * 
 * Created on Apr 28, 2010, 11:10:01 AM
 * 
 */

public class OfflineMinningFrame extends javax.swing.JFrame {
    private Case index ;
    
    private final String APPLICATION_NAME = "Digital Evidence Miner (Beta Version): ";
    private String applicationTitle;
   
    private List<String> listOfOpeningCase ;

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private FileHandler handler ;
    
    /** Creates new form OfflineMinningFrame 
     * 
     * @param AIndex case opened in CaseManager
     * @param list a list of all openings case
     */
    public OfflineMinningFrame(Case AIndex, List<String> list) {
        initComponents();

        /**
         * Set Application Logging (Console and File)
         */
        try {
            handler = new FileHandler("GUI.log");
            logger.addHandler(handler);
            logger.log(Level.INFO, "DEM Main Frame");
        }
        catch (Exception e ) { logger.log(Level.SEVERE, "Uncaught exception", e);}
        
        /*
         * set frame resizable and set frame title
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        this.applicationTitle = "File System Search Window";
        this.setIconImage(kit.getImage(this.getClass().getResource("resources/dem-icon.png")));
        this.setTitle(APPLICATION_NAME + applicationTitle);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        /*
         * initializing class
         */
        this.index = AIndex ;
        this.listOfOpeningCase = list;
        
        /**
         * Remove Case Name From the list when Frame Closed
         */
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosed (WindowEvent event){
                doChecking();
            }

            @Override
            public void windowClosing (WindowEvent event){
                doChecking();
            }

            public void doChecking () {
                try {
                    if ( index != null ) {
                        String caseName = index.getIndexName() ;

                        if ( !caseName.isEmpty() )
                            listOfOpeningCase.remove(caseName);
                        }
                }
                catch (Exception e){
                    logger.log(Level.SEVERE, "Uncaught exception", e);
                }
            }
        });

        // add gui panels
        FileSystemPanel fileSystemPanel = new FileSystemPanel(this.index, this);
        EmailPanel emailPanel = new EmailPanel(this.index, this);
        InternetSurfingPanel internetPanel = new InternetSurfingPanel(this.index);
        ChatPanel chatPanel = new ChatPanel(this.index);
        ImagesViewerPanel imgPanel = new ImagesViewerPanel(this.index);
        
        this.CardPanel.add(fileSystemPanel, "fileSystemCard");
        this.CardPanel.add(emailPanel, "emailCard");
        this.CardPanel.add(internetPanel, "internetSurfingCard");
        this.CardPanel.add(chatPanel, "chatCard");
        this.CardPanel.add(imgPanel, "imagesViewerCard");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        indexGroupButton = new javax.swing.ButtonGroup();
        headerGroupButton = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        fileSystemToggleButton = new javax.swing.JToggleButton();
        emailToggleButton = new javax.swing.JToggleButton();
        internetSurfingToggleButton = new javax.swing.JToggleButton();
        chatToggleButton = new javax.swing.JToggleButton();
        imageViewerToggleButton = new javax.swing.JToggleButton();
        CardPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        windowsMenuItem = new javax.swing.JMenuItem();
        recentMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Digital Evidence Miner ");
        setIconImages(null);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        headerGroupButton.add(fileSystemToggleButton);
        fileSystemToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        fileSystemToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/search.png"))); // NOI18N
        fileSystemToggleButton.setText("File System Search");
        fileSystemToggleButton.setFocusable(false);
        fileSystemToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fileSystemToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fileSystemToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSystemToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(fileSystemToggleButton);

        headerGroupButton.add(emailToggleButton);
        emailToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        emailToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/email.png"))); // NOI18N
        emailToggleButton.setText("Email Search");
        emailToggleButton.setFocusable(false);
        emailToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emailToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        emailToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(emailToggleButton);

        headerGroupButton.add(internetSurfingToggleButton);
        internetSurfingToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        internetSurfingToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/webButton.png"))); // NOI18N
        internetSurfingToggleButton.setText("Internet Surfing");
        internetSurfingToggleButton.setFocusable(false);
        internetSurfingToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        internetSurfingToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        internetSurfingToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internetSurfingToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(internetSurfingToggleButton);

        headerGroupButton.add(chatToggleButton);
        chatToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        chatToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/Chat.png"))); // NOI18N
        chatToggleButton.setText("Instant Chat Search");
        chatToggleButton.setFocusable(false);
        chatToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chatToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        chatToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(chatToggleButton);

        headerGroupButton.add(imageViewerToggleButton);
        imageViewerToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        imageViewerToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/gui/resources/kview.png"))); // NOI18N
        imageViewerToggleButton.setText("Images Viewer");
        imageViewerToggleButton.setFocusable(false);
        imageViewerToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageViewerToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imageViewerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageViewerToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(imageViewerToggleButton);

        CardPanel.setLayout(new java.awt.CardLayout());

        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        exitMenuItem.setText(" Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        toolsMenu.setText("Tools");
        toolsMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        windowsMenuItem.setText("Windows Information");
        windowsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(windowsMenuItem);

        recentMenuItem.setText("Recent Documents");
        recentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recentMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(recentMenuItem);

        jMenuBar1.add(toolsMenu);

        aboutMenu.setText("About");
        aboutMenu.setFont(new java.awt.Font("Tahoma", 1, 11));

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(helpMenuItem);
        aboutMenu.add(jSeparator1);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuItem);

        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("DEM");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowsMenuItemActionPerformed
        try {
            ArrayList<String> data = Utilities.readProgramOutputStream("systeminfo.exe");

            WindowsInfoDialog wid = new WindowsInfoDialog(OfflineMinningFrame.this, true, data);
            wid.setVisible(true);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
    }//GEN-LAST:event_windowsMenuItemActionPerformed

    private void recentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recentMenuItemActionPerformed
        RecentDialog rd = new RecentDialog(OfflineMinningFrame.this, true);
        rd.setVisible(true);
    }//GEN-LAST:event_recentMenuItemActionPerformed
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "please return to CoEIA web site",
                "to get more help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "All right is reserved to CoEIA 2010",
                "about product", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void fileSystemToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSystemToggleButtonActionPerformed
        GuiUtil.showPanel("fileSystemCard",CardPanel);
        this.setTitle(APPLICATION_NAME + "File System Search Window");
    }//GEN-LAST:event_fileSystemToggleButtonActionPerformed

    private void emailToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailToggleButtonActionPerformed
       GuiUtil.showPanel("emailCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Email Search Window");
    }//GEN-LAST:event_emailToggleButtonActionPerformed

    private void internetSurfingToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internetSurfingToggleButtonActionPerformed
       GuiUtil.showPanel("internetSurfingCard",CardPanel);
       this.setTitle(APPLICATION_NAME + "Internet Surfing Search Window");
    }//GEN-LAST:event_internetSurfingToggleButtonActionPerformed

    private void chatToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatToggleButtonActionPerformed
        GuiUtil.showPanel("chatCard",CardPanel);
        this.setTitle(APPLICATION_NAME + "Instance Chat Search Window");
    }//GEN-LAST:event_chatToggleButtonActionPerformed

    private void imageViewerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageViewerToggleButtonActionPerformed
         GuiUtil.showPanel("imagesViewerCard", CardPanel);
         this.setTitle(APPLICATION_NAME + "Image Viewer Window");
    }//GEN-LAST:event_imageViewerToggleButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JToggleButton chatToggleButton;
    private javax.swing.JToggleButton emailToggleButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToggleButton fileSystemToggleButton;
    private javax.swing.ButtonGroup headerGroupButton;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JToggleButton imageViewerToggleButton;
    private javax.swing.ButtonGroup indexGroupButton;
    private javax.swing.JToggleButton internetSurfingToggleButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem recentMenuItem;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenuItem windowsMenuItem;
    // End of variables declaration//GEN-END:variables
}