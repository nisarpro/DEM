/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.task;

import edu.coeia.cases.Case;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.indexing.IndexingConstant;
import edu.coeia.items.EmailItem;
import edu.coeia.items.ItemFactory;
import edu.coeia.offlinemail.EmailBrowsingPanel;
import edu.coeia.util.FilesPath;

import java.io.File;
import java.io.IOException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author wajdyessam
 */
public class EmailLoadingTask  implements Task{
    private final TaskThread thread;
    private final Case aCase;
    private final EmailBrowsingPanel panel;
    
    public EmailLoadingTask(final Case aCase, final EmailBrowsingPanel panel) {
        this.thread = new TaskThread(this);
        this.aCase = aCase;
        this.panel = panel;
    }
    
    @Override
    public void startTask() {
        this.thread.execute();
    }
    
    @Override
    public void doTask() throws Exception {
        this.loadEmail();
    }
    
    @Override
    public boolean isCancelledTask() {
        return this.thread.isCancelledThread();
    }
    
    private void loadEmail() throws Exception {
        if ( this.panel.isOfflineEmailSelected() ) {
            String relativePath = String.valueOf(this.panel.getList().getSelectedValue());
            this.getAllMessaageInOfflineEmailPath(relativePath);
        }
        else if ( this.panel.isOnlineEmailSelected() ) {
            String username = String.valueOf(this.panel.getList().getSelectedValue());
            this.getAllMessageInOnlineEmailPath(username);
        }
    }
    
    private void getAllMessaageInOfflineEmailPath(final String path) throws IOException, ParseException {
        List<Integer> ids = new ArrayList<Integer>();
        
        String indexDir = this.aCase.getCaseLocation() + "\\" + FilesPath.INDEX_PATH;
        Directory dir = FSDirectory.open(new File(indexDir));
        IndexReader indexReader = IndexReader.open(dir);
        
        for (int i=0; i<indexReader.maxDoc(); i++) {
            if ( this.isCancelledTask() )
                return ;
                     
            Document document = indexReader.document(i);
            if ( document != null ) {
                Field field = document.getField(IndexingConstant.OFFLINE_EMAIL_PATH);
                if ( field != null && field.stringValue() != null) {
                   String tmp = field.stringValue();
                   
                   if ( tmp.endsWith(path)) {
                        EmailItem item = (EmailItem) ItemFactory.newInstance(document, panel.getCaseFacade());
                        JTableUtil.addRowToJTable(panel.getTable(), item.getDisplayData());
                        ids.add(Integer.valueOf(item.getDocumentId()));
                   }
                }
            }
        }
        
        this.panel.setResultIds(ids);
        indexReader.close();
    }
        
    
    private void getAllMessageInOnlineEmailPath(final String username) throws IOException, ParseException {
        List<Integer> ids = new ArrayList<Integer>();
        
        String indexDir = this.aCase.getCaseLocation() + "\\" + FilesPath.INDEX_PATH;
        Directory dir = FSDirectory.open(new File(indexDir));
        IndexReader indexReader = IndexReader.open(dir);
        
        for (int i=0; i<indexReader.maxDoc(); i++) {
            if ( this.isCancelledTask() )
                return ;
                        
            Document document = indexReader.document(i);
            if ( document != null ) {
                Field field = document.getField(IndexingConstant.ONLINE_EMAIL_USER_NAME);
                if ( field != null && field.stringValue() != null) {
                   String tmp = field.stringValue();
                   
                   if ( tmp.equals(username)) {
                        EmailItem item = (EmailItem) ItemFactory.newInstance(document, panel.getCaseFacade());
                        JTableUtil.addRowToJTable(panel.getTable(), item.getDisplayData());
                        ids.add(Integer.valueOf(item.getDocumentId()));
                   }
                }
            }
        }
        
        this.panel.setResultIds(ids);
        indexReader.close();
    }
}
