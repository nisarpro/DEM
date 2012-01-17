/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.indexing;

import edu.coeia.extractors.ImageExtractor;
import edu.coeia.extractors.TikaExtractor;
import edu.coeia.hash.HashCalculator;
import edu.coeia.util.FileUtil;
import edu.coeia.util.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;

/**
 *
 * @author wajdyessam
 */
final class NonDocumentIndexer extends Indexer{
    
    /*
     * static factory method to get an instance of DocumentIndexer
     */
    public static NonDocumentIndexer newInstance (LuceneIndex luceneIndex, File file, String mimeType, 
            ImageExtractor imageExtractor) {
        return new NonDocumentIndexer(luceneIndex, file, mimeType, imageExtractor, 0);
    }
     
    /*
     * static factory method to get an instance of DocumentIndexer
     */
    public static NonDocumentIndexer newInstance (LuceneIndex luceneIndex, File file, String mimeType, 
            ImageExtractor imageExtractor, int parentId) {
        return new NonDocumentIndexer(luceneIndex, file, mimeType, imageExtractor, parentId);
    }
    
    private NonDocumentIndexer(LuceneIndex luceneIndex, File file, String mimeType, 
            ImageExtractor imageExtractor,int parentId) {
        super(luceneIndex, file,mimeType, imageExtractor);
        this.setParentId(parentId);
    }
    
    @Override
    public boolean doIndexing() {
        boolean status = false ;
        
        try {
            TikaExtractor extractor = TikaExtractor.getExtractor(this.getFile(), this.getMimeType(),
                    TikaExtractor.EXTRACT_TYPE.METADATA);
            
            Map<String, String> metadata = extractor.getMetadata();
            
            Document doc = getDocument("", metadata); // add parentid and parent metadata here
            status = this.indexDocument(doc);
        }
        catch(Exception e){
            throw new UnsupportedOperationException(e.getMessage());
        }

        return status;
    }
    
    private boolean indexDocument(final Document doc) throws CorruptIndexException, IOException {
        boolean status  = false;
        
        int objectId = this.getId();

        if (doc != null) {
            this.getLuceneIndex().getWriter().addDocument(doc);    // index file
            this.increaseId();      // increase the id counter if file indexed successfully

            // cache images with id as parent id
            if ( this.isImageCache() ) {
                this.getImageExtractor().extractImages(this, this.getFile(), objectId);
            }

            status = true;
        }
        
        return status;
    }
        
    private Document getDocument(String content, Map<String, String> metadata) {
        Document doc = new Document();
        
        // generic document fields
        doc.add(new Field(IndexingConstant.DOCUMENT_ID, String.valueOf(this.getId()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT, IndexingConstant.getDocumentType(IndexingConstant.DOCUMENT_TYPE.FILE), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT_PARENT_ID, String.valueOf(this.getParentId()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.DOCUMENT_HASH, HashCalculator.calculateFileHash(this.getFile().getAbsolutePath()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        
        // specific document fields
        doc.add(new Field(IndexingConstant.FILE_PATH, this.getPathHandler().getRelativePath(this.getFile().getPath()), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_NAME, this.getFile().getName() , Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_DATE, DateTools.timeToString(this.getFile().lastModified(), DateTools.Resolution.MINUTE),Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_CONTENT, content, Field.Store.YES, Field.Index.ANALYZED));
        doc.add(new Field(IndexingConstant.FILE_MIME, FileUtil.getExtension(this.getFile()), Field.Store.YES, Field.Index.NOT_ANALYZED) );
        
        // unkown metadata extracted by Tika
        for(Map.Entry<String, String> entry: metadata.entrySet()) {
            String name =  Utilities.getEmptyStringWhenNullString(entry.getKey());
            String value = Utilities.getEmptyStringWhenNullString(entry.getValue());

            doc.add(new Field(name, value, Field.Store.YES, Field.Index.ANALYZED)); 
        }
        
        return doc;
    }
    
}
