/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.indexing;

/**
 *
 * @author wajdyessam
 */

import java.io.File ;

final class ArchiveIndexer extends Indexer {
    
    private int parentId ;
    
    public static ArchiveIndexer newInstance (LuceneIndex luceneIndex, File file, String mimeType, 
           ImageExtractor imageExtractor, int parentId) {
        return new ArchiveIndexer(luceneIndex, file, mimeType, imageExtractor, parentId);
    }
        
    public static ArchiveIndexer newInstance (LuceneIndex luceneIndex, File file, String mimeType, 
            ImageExtractor imageExtractor) {
        return new ArchiveIndexer(luceneIndex, file, mimeType, imageExtractor, 0);
    }
        
    private ArchiveIndexer(LuceneIndex luceneIndex, File file, String mimeType, 
            ImageExtractor imageExtractor,int parentId) {
        super(luceneIndex, file,mimeType, imageExtractor);
        this.parentId = parentId ;
    }
        
    @Override
    public boolean doIndexing() {
        boolean status = false ;
        
        try {
            String folderName = this.tmpLocation;

            // extract all the archive content in temp folder
            TikaObjectExtractor.EmbeddedObjectHandler handler = TikaObjectExtractor.getExtractor(
                    this.file.getAbsolutePath(), folderName,
                    TikaObjectExtractor.OBJECT_TYPE.ARCHIVE).extract();

            if ( handler != null ) {
                for(TikaObjectExtractor.ObjectLocation location: handler.getLocations()) {
                    System.out.println("Extract: " + location.oldFilePath + " TO: " + location.newFilePath);
                    luceneIndex.indexFile(new File(location.newFilePath), parentId);
                }
            }

            status = true;
        }
        catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        
        return status; 
    }
}