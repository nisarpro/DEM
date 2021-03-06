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
package edu.coeia.main;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.cases.management.ApplicationManager;
import edu.coeia.chat.ChatPanel;
import edu.coeia.constants.ApplicationConstants;
import edu.coeia.constants.AuditingMessages;
import edu.coeia.constants.ResourceManager;
import edu.coeia.constants.SystemConstant;
import edu.coeia.filesystem.CaseInformationPanel;
import edu.coeia.filesystem.FileSystemPanel;
import edu.coeia.gutil.GuiUtil;
import edu.coeia.hashanalysis.HashLibraryManagerDialog;
import edu.coeia.indexing.dialogs.IndexingDialog;
import edu.coeia.internet.InternetSurfingPanel;
import edu.coeia.multimedia.MultimediaPanel;
import edu.coeia.offlinemail.EmailBrowsingPanel;
import edu.coeia.onlinemail.DownloadEmail;
import edu.coeia.reports.ReportPanel;
import edu.coeia.searching.CaseSearchPanel;
import edu.coeia.util.ApplicationLogging;
import edu.coeia.util.FileUtil;
import edu.coeia.util.Utilities;
import edu.coeia.verification.CaseVerificationDialog;
import edu.coeia.wizard.EmailConfiguration;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List; 
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * For Historical Memo :)
 * OfflineMinningFrame.java
 *
 * @author wajdyessam
 * 
 * Created on Apr 28, 2010, 11:10:01 AM
 * 
 */

public class CaseMainFrame extends javax.swing.JFrame {
    
    private final static Logger logger = ApplicationLogging.getLogger();
    
    private final CaseManagerFrame parentFrame; 
    private final CaseFacade caseFacade;
    private final String applicationTitle;
    
    // to update the panel after direct indexing 
    private final CaseInformationPanel caseManagerPanel;
    private final CaseSearchPanel caseSearchPanel ;
    private final FileSystemPanel fileSystemPanel;
    private final EmailBrowsingPanel emailPanel;
    private final InternetSurfingPanel internetPanel;
    private final ChatPanel chatPanel;
    private final ReportPanel reportPanel;
    private final MultimediaPanel multimediaPanel;
    
    /** Creates new form OfflineMinningFrame 
     * 
     * @param aCase case opened in CaseFacade
     * @param list a list of all openings case
     */
    public CaseMainFrame(final CaseManagerFrame frame, final CaseFacade caseFacade) {       
        initComponents();        
        
        logger.info(String.format("OfflineMining Frame Constructor, Open Case: %s" , caseFacade.getCase().getCaseName()));
        caseFacade.audit(AuditingMessages.OPEN_CASE);
        
        /*
         * set frame resizable and set frame title
         */
        this.applicationTitle = "File System Search Window";
        this.parentFrame = frame;
        this.initFrame();
        
        /*
         * initializing class
         */
        
        this.caseFacade = caseFacade;
        
        /**
         * Remove Case Name From the list when Frame Closed
         */
        this.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent event){
                promptUserToSaveCase();
                closeCaseFrame();
            }
        });
        
        // add gui panels
        this.fileSystemPanel = new FileSystemPanel(this);
        this.emailPanel = new EmailBrowsingPanel(this);
        this.internetPanel = new InternetSurfingPanel(this);
        this.chatPanel = new ChatPanel(this);
        this.multimediaPanel = new MultimediaPanel(this);
        this.caseSearchPanel = new CaseSearchPanel(this);
        this.reportPanel = new ReportPanel(this);
        this.caseManagerPanel = new CaseInformationPanel(this);
        
        // set card panels
        this.CardPanel.add(this.fileSystemPanel, "fileSystemCard");
        this.CardPanel.add(this.emailPanel, "emailCard");
        this.CardPanel.add(this.internetPanel, "internetSurfingCard");
        this.CardPanel.add(this.chatPanel, "chatCard");
        this.CardPanel.add(this.multimediaPanel, "MultimediaViewer");
        this.CardPanel.add(this.caseSearchPanel, "searchCard");
        this.CardPanel.add(this.caseManagerPanel, "caseManagerCard");
        this.CardPanel.add(this.reportPanel, "reportCard");
        
        // init user interface components
        this.searchToggleButtonActionPerformed(null);
        this.setTitle(SystemConstant.APPLICATION_NAME + "Case Manager Window");
        
        this.applyComponentOrientation(ComponentOrientation.getOrientation(ResourceManager.getLanguage()));        
        GuiUtil.showPanel("caseManagerCard",CardPanel);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerGroupButton = new javax.swing.ButtonGroup();
        styleRadioGroup = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        caseManagerToggleButton = new javax.swing.JToggleButton();
        searchToggleButton = new javax.swing.JToggleButton();
        fileSystemToggleButton = new javax.swing.JToggleButton();
        emailToggleButton = new javax.swing.JToggleButton();
        internetSurfingToggleButton = new javax.swing.JToggleButton();
        chatToggleButton = new javax.swing.JToggleButton();
        imageViewerToggleButton = new javax.swing.JToggleButton();
        reportToggleButton = new javax.swing.JToggleButton();
        CardPanel = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        hashLibraryMenuItem = new javax.swing.JMenuItem();
        caseVerificationMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        caseIndexingMenuItem = new javax.swing.JMenuItem();
        reDownloadingEmailMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        windowsMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        viewLogMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("edu/coeia/main/Bundle"); // NOI18N
        setTitle(bundle.getString("CaseMainFrame.title")); // NOI18N
        setIconImages(null);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        headerGroupButton.add(caseManagerToggleButton);
        caseManagerToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        caseManagerToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274612774_kservices.png"))); // NOI18N
        caseManagerToggleButton.setText(bundle.getString("CaseMainFrame.caseManagerToggleButton.text")); // NOI18N
        caseManagerToggleButton.setFocusable(false);
        caseManagerToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        caseManagerToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        caseManagerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseManagerToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(caseManagerToggleButton);

        headerGroupButton.add(searchToggleButton);
        searchToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/Copy of search.png"))); // NOI18N
        searchToggleButton.setText(bundle.getString("CaseMainFrame.searchToggleButton.text")); // NOI18N
        searchToggleButton.setFocusable(false);
        searchToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(searchToggleButton);

        headerGroupButton.add(fileSystemToggleButton);
        fileSystemToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fileSystemToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/file-manager.png"))); // NOI18N
        fileSystemToggleButton.setText(bundle.getString("CaseMainFrame.fileSystemToggleButton.text")); // NOI18N
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
        emailToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        emailToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325574974_message-already-read.png"))); // NOI18N
        emailToggleButton.setText(bundle.getString("CaseMainFrame.emailToggleButton.text")); // NOI18N
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
        internetSurfingToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        internetSurfingToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/web.png"))); // NOI18N
        internetSurfingToggleButton.setText(bundle.getString("CaseMainFrame.internetSurfingToggleButton.text")); // NOI18N
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
        chatToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chatToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325574948_amsn.png"))); // NOI18N
        chatToggleButton.setText(bundle.getString("CaseMainFrame.chatToggleButton.text")); // NOI18N
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
        imageViewerToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imageViewerToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1325574870_iPhoto.png"))); // NOI18N
        imageViewerToggleButton.setText(bundle.getString("CaseMainFrame.imageViewerToggleButton.text")); // NOI18N
        imageViewerToggleButton.setFocusable(false);
        imageViewerToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imageViewerToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        imageViewerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageViewerToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(imageViewerToggleButton);

        headerGroupButton.add(reportToggleButton);
        reportToggleButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reportToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/coeia/main/resources/1274614668_filesave.png"))); // NOI18N
        reportToggleButton.setText(bundle.getString("CaseMainFrame.reportToggleButton.text")); // NOI18N
        reportToggleButton.setFocusable(false);
        reportToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(reportToggleButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        CardPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        CardPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(CardPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText(bundle.getString("CaseMainFrame.fileMenu.text")); // NOI18N
        fileMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        exitMenuItem.setText(bundle.getString("CaseMainFrame.exitMenuItem.text")); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        optionsMenu.setText(bundle.getString("CaseMainFrame.optionsMenu.text")); // NOI18N
        optionsMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        hashLibraryMenuItem.setText(bundle.getString("CaseMainFrame.hashLibraryMenuItem.text")); // NOI18N
        hashLibraryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashLibraryMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(hashLibraryMenuItem);

        caseVerificationMenuItem.setText(bundle.getString("CaseMainFrame.caseVerificationMenuItem.text")); // NOI18N
        caseVerificationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseVerificationMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(caseVerificationMenuItem);
        optionsMenu.add(jSeparator3);

        caseIndexingMenuItem.setText(bundle.getString("CaseMainFrame.caseIndexingMenuItem.text")); // NOI18N
        caseIndexingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseIndexingMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(caseIndexingMenuItem);

        reDownloadingEmailMenuItem.setText(bundle.getString("CaseMainFrame.reDownloadingEmailMenuItem.text")); // NOI18N
        reDownloadingEmailMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reDownloadingEmailMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(reDownloadingEmailMenuItem);

        mainMenuBar.add(optionsMenu);

        toolsMenu.setText(bundle.getString("CaseMainFrame.toolsMenu.text")); // NOI18N
        toolsMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        windowsMenuItem.setText(bundle.getString("CaseMainFrame.windowsMenuItem.text")); // NOI18N
        windowsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(windowsMenuItem);
        toolsMenu.add(jSeparator2);

        viewLogMenuItem.setText(bundle.getString("CaseMainFrame.viewLogMenuItem.text")); // NOI18N
        viewLogMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLogMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(viewLogMenuItem);

        mainMenuBar.add(toolsMenu);

        aboutMenu.setText(bundle.getString("CaseMainFrame.aboutMenu.text")); // NOI18N
        aboutMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        helpMenuItem.setText(bundle.getString("CaseMainFrame.helpMenuItem.text")); // NOI18N
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(helpMenuItem);
        aboutMenu.add(jSeparator1);

        aboutMenuItem.setText(bundle.getString("CaseMainFrame.aboutMenuItem.text")); // NOI18N
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutMenuItem);

        mainMenuBar.add(aboutMenu);

        setJMenuBar(mainMenuBar);

        getAccessibleContext().setAccessibleName(bundle.getString("CaseMainFrame.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowsMenuItemActionPerformed
        this.displayWindowsInformation();
    }//GEN-LAST:event_windowsMenuItemActionPerformed
    
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.closeCaseFrame();
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
        this.setTitle(SystemConstant.APPLICATION_NAME + "File System Search Window");
    }//GEN-LAST:event_fileSystemToggleButtonActionPerformed

    private void emailToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailToggleButtonActionPerformed
       GuiUtil.showPanel("emailCard",CardPanel);
       this.setTitle(SystemConstant.APPLICATION_NAME + "Email Search Window");
    }//GEN-LAST:event_emailToggleButtonActionPerformed

    private void internetSurfingToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internetSurfingToggleButtonActionPerformed
       GuiUtil.showPanel("internetSurfingCard",CardPanel);
       this.setTitle(SystemConstant.APPLICATION_NAME + "Internet Surfing Search Window");
    }//GEN-LAST:event_internetSurfingToggleButtonActionPerformed

    private void chatToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatToggleButtonActionPerformed
        GuiUtil.showPanel("chatCard",CardPanel);
        this.setTitle(SystemConstant.APPLICATION_NAME + "Instance Chat Search Window");
    }//GEN-LAST:event_chatToggleButtonActionPerformed

    private void imageViewerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageViewerToggleButtonActionPerformed
         GuiUtil.showPanel("MultimediaViewer", CardPanel);
         this.setTitle(SystemConstant.APPLICATION_NAME + "Multimedeia Viewer Window");
    }//GEN-LAST:event_imageViewerToggleButtonActionPerformed

    private void viewLogMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLogMenuItemActionPerformed
        try {
            Utilities.selectObjectInExplorer(ApplicationConstants.APPLICATION_LOG_PATH);
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Exception When Opening Folder", e);
        }
    }//GEN-LAST:event_viewLogMenuItemActionPerformed

    private void caseIndexingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseIndexingMenuItemActionPerformed
        showIndexDialog(false);
    }//GEN-LAST:event_caseIndexingMenuItemActionPerformed

    private void searchToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchToggleButtonActionPerformed
       GuiUtil.showPanel("searchCard",CardPanel);
       this.setTitle(SystemConstant.APPLICATION_NAME + "Search Window");
       this.caseSearchPanel.setFocusInAdvancedSearchPanel();
    }//GEN-LAST:event_searchToggleButtonActionPerformed

    private void caseManagerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseManagerToggleButtonActionPerformed
       GuiUtil.showPanel("caseManagerCard",CardPanel);
       this.setTitle(SystemConstant.APPLICATION_NAME + "Case Manager Window");
    }//GEN-LAST:event_caseManagerToggleButtonActionPerformed

    private void reportToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportToggleButtonActionPerformed
       GuiUtil.showPanel("reportCard",CardPanel);
       this.setTitle(SystemConstant.APPLICATION_NAME + "Report Manager Window");
    }//GEN-LAST:event_reportToggleButtonActionPerformed

    private void hashLibraryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashLibraryMenuItemActionPerformed
        HashLibraryManagerDialog dailog = new HashLibraryManagerDialog(this, true);
        dailog.setVisible(true);
    }//GEN-LAST:event_hashLibraryMenuItemActionPerformed

    private void reDownloadingEmailMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reDownloadingEmailMenuItemActionPerformed
        this.emailDownloaderAction();
    }//GEN-LAST:event_reDownloadingEmailMenuItemActionPerformed

    private void caseVerificationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseVerificationMenuItemActionPerformed
        CaseVerificationDialog dialog = new CaseVerificationDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_caseVerificationMenuItemActionPerformed
    
    private void emailDownloaderAction() {
        List<EmailConfiguration> emailInfos = this.getCase().getEmailConfigurations();
 
        if (emailInfos.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "There is no Email Information", "No Email in Case", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (EmailConfiguration s : emailInfos) {
            try {
                DownloadEmail downloder = new DownloadEmail(this.getCase(), s);
                downloder.download(this);
            } 
            catch (Exception ex) {
                Logger.getLogger(CaseMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void displayWindowsInformation() {
        this.getRootPane().getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.getRootPane().getGlassPane().setVisible(true);
        this.getRootPane().getGlassPane().requestFocusInWindow();
        
        new Thread(new Runnable() { 
            @Override
            public void run() {
                try {
                    final List<String> data = FileUtil.readProgramOutputStream("systeminfo.exe");
                    
                    EventQueue.invokeLater(new Runnable() { 
                        @Override
                        public void run() {
                            WindowsInfoDialog wid = new WindowsInfoDialog(CaseMainFrame.this, true, data);
                            wid.setVisible(true);
                            
                            CaseMainFrame.this.getRootPane().getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        }
                    });
                }
                catch (IOException e) {
                    logger.log(Level.SEVERE, "Uncaught exception", e);
                }
            }
        }).start();

    }
    
    public void showIndexDialog(boolean startIndex) {
        IndexingDialog indexPanel = new IndexingDialog(this, true, this.getCaseFacade(), startIndex);
        indexPanel.setLocationRelativeTo(this);
        indexPanel.setVisible(true);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                caseManagerPanel.displayCaseInformationPanel();
                caseManagerPanel.displayMutableCaseInformationPanel();
            }
        }).start();
        
    }
    
    private void closeCaseFrame() {
        try {
            if ( this.getCase() != null ) {
                String caseName = this.getCase().getCaseName() ;

                if ( !caseName.isEmpty() )
                    ApplicationManager.Manager.removeCaseFromOpeningCase(caseName);
                
                this.caseFacade.closeCase();
            }
        }
        catch (Exception e){
            logger.log(Level.SEVERE, "Uncaught exception", e);
        }
    }
    
    /**
     * Ask User to save case if he add new tags
     * and not save the case
     */
    private void promptUserToSaveCase() {
        if ( this.caseFacade.isTagsDatabaseModified() ) {
            askForSavingMessage();
        }
    }
    
    /**
     * the message ask user for save the case
     */
    private void askForSavingMessage() {
        int value = JOptionPane.showConfirmDialog(this,
                    "The case is not saved, Do you want to save it?",
                    applicationTitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    
        if ( value == JOptionPane.YES_OPTION ) {
            this.caseManagerPanel.saveCaseModifications();
        }
    }
    
    private void initFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        this.setIconImage(kit.getImage(this.getClass().getResource("resources/dem-icon.png")));
        this.setTitle(SystemConstant.APPLICATION_NAME + applicationTitle);
        this.setResizable(true);
        this.setSize(850, 650);
    }
    
    private Case getCase() { return this.caseFacade.getCase() ; }
    public CaseFacade getCaseFacade() { return this.caseFacade; }
    public CaseManagerFrame getParentFrame() { return this.parentFrame; }
    
    public void refreshTagsList() {
        this.caseManagerPanel.initializingTagsPanel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem caseIndexingMenuItem;
    private javax.swing.JToggleButton caseManagerToggleButton;
    private javax.swing.JMenuItem caseVerificationMenuItem;
    private javax.swing.JToggleButton chatToggleButton;
    private javax.swing.JToggleButton emailToggleButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToggleButton fileSystemToggleButton;
    private javax.swing.JMenuItem hashLibraryMenuItem;
    private javax.swing.ButtonGroup headerGroupButton;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JToggleButton imageViewerToggleButton;
    private javax.swing.JToggleButton internetSurfingToggleButton;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem reDownloadingEmailMenuItem;
    private javax.swing.JToggleButton reportToggleButton;
    private javax.swing.JToggleButton searchToggleButton;
    private javax.swing.ButtonGroup styleRadioGroup;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenuItem viewLogMenuItem;
    private javax.swing.JMenuItem windowsMenuItem;
    // End of variables declaration//GEN-END:variables
}