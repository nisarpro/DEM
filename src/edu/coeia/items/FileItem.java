/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.items;

/**
 *
 * @author wajdyessam
 */
public final class FileItem extends Item{
    
    public FileItem(final int documentId, final int documentParentId, final String hash,
            final String fileName, final String filePath, final String fileContent, 
            final String fileDate, final String fileMimeType) {
   
        super(documentId, documentParentId, hash);
        
        this.fileName = fileName ;
        this.filePath = filePath; 
        this.fileContent = fileContent;
        this.fileDate = fileDate;
        this.fileMimeType = fileMimeType;
        this.description = getDescription();
    }
    
    public String getFileName()  { return this.fileName ; }
    public String getFilePath() { return this.filePath; }
    public String getFileContent() { return this.fileContent ;}
    public String getFileDate() { return this.fileDate ;}
    public String getFileMimeType() { return this.fileMimeType ;}
           
    @Override
    public Object[] getDisplayData() {
        Object[] object = new Object[] {this.documentId, this.fileName, this.fileDate, this.description , this.filePath};
        return object;
    }
    
    @Override
    protected String getDescription() {
        String result = "";
        
        if ( this.documentParentId != 0 )
            result = "File Embedded";
        else
            result = "File";
        
        return result;
    }
    
    public void setDescription(final String desc) {
        this.description = desc;
    }
    
    private final String fileName ;
    private final String filePath;
    private final String fileContent; 
    private final String fileDate ;
    private final String fileMimeType;
    private String description;
}
