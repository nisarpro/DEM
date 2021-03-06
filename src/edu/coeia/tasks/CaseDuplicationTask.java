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
package edu.coeia.tasks;


import edu.coeia.cases.Case;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.hashanalysis.HashAnalysisPanel;
import edu.coeia.constants.IndexingConstant;
import edu.coeia.constants.ApplicationConstants;

import java.io.File;

import java.util.Collection;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.lucene.index.IndexReader ;
import org.apache.lucene.store.Directory ;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.document.Document ;
import org.apache.lucene.document.Field;


/**
 *
 * @author wajdyessam
 */
public class CaseDuplicationTask implements Task{
    private final BackgroundProgressDialog dialog ;
    private final Case aCase;
    private final HashAnalysisPanel panel;
    
    public CaseDuplicationTask(final Case aCase, final HashAnalysisPanel panel) {
        this.dialog = new BackgroundProgressDialog(null, true, this);
        this.aCase = aCase;
        this.panel = panel;
    }
    
    @Override
    public void startTask() {
        this.dialog.startThread();
    }
    
    @Override
    public void doTask() throws Exception {
        this.doCaseDuplicationAnalysis();
    }
    
    @Override
    public boolean isCancelledTask() {
        return this.dialog.isCancelledThread();
    }
    
    private void doCaseDuplicationAnalysis() {
        try {
            boolean isFoundDuplication = this.findCaseDuplication();
            
            if ( !isFoundDuplication ) {
                JOptionPane.showMessageDialog(null, "There is no duplication in this case");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean findCaseDuplication() throws Exception {
        this.fillCaseDuplicationMap();  // read from index and fill the duplication map
        
        boolean isFoundDuplication = false; 
        Map<String, Collection<String>> m = this.panel.getCaseDuplicationMap().asMap();
        
        for(Map.Entry<String, Collection<String>> mapEntry: m.entrySet()){
            String key = mapEntry.getKey();
            Collection<String> documents = mapEntry.getValue();
            
            if ( documents.size() > 1 ) { // find duplication  
                isFoundDuplication = true;
                Object[] data = {key, documents.size()};
                JTableUtil.addRowToJTable(this.panel.getCaseDuplicationTable(), data);
            }
            
            documents = null;
        }
        
        return isFoundDuplication;
    }
        
    private void fillCaseDuplicationMap() throws Exception {
        String indexDir = this.aCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_INDEX_FOLDER;
        Directory dir = FSDirectory.open(new File(indexDir));
        IndexReader indexReader = IndexReader.open(dir);
        
        try {
            for (int i=0; i<indexReader.maxDoc(); i++) {
                Document document = indexReader.document(i);
                if ( document != null ) {
                    Field field = document.getField(IndexingConstant.DOCUMENT_HASH);
                    if ( field != null && field.stringValue() != null) {
                    String documentHash = field.stringValue();
                    this.panel.getCaseDuplicationMap().put(documentHash, document.get(IndexingConstant.DOCUMENT_ID));
                    }
                }
            }
        }
        finally {
            indexReader.close();
        }
    }
    
}
