/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.cases;

/**
 *
 * @author wajdyessam
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class Case implements Serializable {

    // Requaird paramters for case
    private final String indexName;
    private final String indexLocation;
    private final String investigatorName;
    private final String description;
    private final Date createTime;
    private final long caseSize;
    // Optional Paramaters for case
    private boolean isIndex;
    private boolean isHash;
    private boolean isExportLibrary;
    private boolean isClusterWithCase;
    private boolean isClusterWithLibrary;
    private boolean isIndexArchive;
    private boolean isIndexEmbedded;
    private boolean isCacheImages;
    private boolean isExcludeFileSystems;
    private boolean isIndexChatSessions;
    private boolean isDetectBrowserRessions;
    
    // index history information
    private boolean indexStatus;
    private String lastIndexDate;
    private String indexingTime;
    private String caseSource;
    //private int dataIndexedCount, dataIndexedSize ;
    // Email Configuation
    private List<EmailConfig> emailInfo;

    private Case(Builder builder) {

        this.indexName = builder.indexName;
        this.indexLocation = builder.indexLocation;
        this.investigatorName = builder.investigatorName;
        this.description = builder.description;
        this.createTime = builder.createTime;
        this.caseSize = builder.caseSize;
        this.indexStatus = builder.indexStatus;
        this.lastIndexDate = builder.lastIndexDate;
        this.indexingTime = builder.indexingTime;
        this.caseSource = builder.caseSource;
        this.emailInfo = builder.emailInfo;

        this.isIndex = builder.isIndex;
        this.isHash = builder.isHash;
        this.isExportLibrary = builder.isExportLibrary;
        this.isClusterWithCase = builder.isClusterWithCase;
        this.isClusterWithLibrary = builder.isClusterWithLibrary;
        this.isIndexArchive = builder.isIndexArchive;
        this.isIndexEmbedded = builder.isIndexEmbedded;
        this.isCacheImages = builder.isCacheImages;
        this.isExcludeFileSystems = builder.isExcludeFileSystems;
        this.isIndexChatSessions  = builder.isIndexChatSessions;
        this.isDetectBrowserRessions  = builder.isDetectBrowserRessions;
    }

    public static class Builder {

        private final String indexName;
        private final String indexLocation;
        private final String investigatorName;
        private final String description;
        private final String caseSource;
        private final Date createTime;
        private final long caseSize;
        private boolean isIndex = false;
        private boolean isHash = false;
        private boolean isExportLibrary = false;
        private boolean isClusterWithCase = false;
        private boolean isClusterWithLibrary = false;
        private boolean isIndexArchive = false;
        private boolean isIndexEmbedded = false;
        private boolean isCacheImages = false;
        private boolean isExcludeFileSystems = false;
        private boolean isIndexChatSessions = false;
        private boolean isDetectBrowserRessions = false;
        private List<EmailConfig> emailInfo;
        // index history information
        private boolean indexStatus = false;
        private String lastIndexDate = "";
        private String indexingTime = "";
        //private int dataIndexedCount, dataIndexedSize ;

        public Builder(String indexName, String indexLocation, String investigatorName,
                String description, String caseSource, Date createTime, long caseSize) {
            this.indexName = indexName;
            this.indexLocation = indexLocation;
            this.investigatorName = investigatorName;
            this.description = description;
            this.caseSource = caseSource;
            this.createTime = createTime;
            this.caseSize = caseSize;
        }

        public Case build() {
            return new Case(this);
        }

        public Builder(String indexName, String indexLocation, String investigatorName, String description,
                String caseSource, long caseSize, Date creationDate) {
            this.indexName = indexName;
            this.indexLocation = indexLocation;
            this.investigatorName = investigatorName;
            this.description = description;
            this.caseSource = caseSource;
            this.caseSize = caseSize;
            this.createTime = creationDate;
        }

        public Builder isIndex(boolean val) {
            isIndex = val;
            return this;
        }

        public Builder isHash(boolean val) {
            isHash = val;
            return this;
        }

        public Builder isExportLibrary(boolean val) {
            isExportLibrary = val;
            return this;
        }

        public Builder isClusterWithCase(boolean val) {
            isClusterWithCase = val;
            return this;
        }

        public Builder isClusterWithLibrary(boolean val) {
            isClusterWithLibrary = val;
            return this;
        }

        public Builder isIndexArchive(boolean val) {
            isIndexArchive = val;
            return this;
        }

        public Builder isIndexEmbedded(boolean val) {
            isIndexEmbedded = val;
            return this;
        }

        public Builder isCacheImages(boolean val) {
            isCacheImages = val;
            return this;
        }

        public Builder isExcludeFileSystems(boolean val) {
            isExcludeFileSystems = val;
            return this;
        }

        public Builder createEmailConfig(List<EmailConfig> configList) {
            emailInfo = configList;
            return this;
        }
        public Builder isIndexChatSessions(boolean val)
        {
            isIndexChatSessions = val; 
            return this;
        }
        public Builder isDetectBrowserSessiond(boolean val)
        {
            isDetectBrowserRessions = val;
            return this;
        }
    }

    public boolean GetisHash() {
        return this.isHash;
    }

    public boolean GetisIndex() {

        return this.isIndex;
    }

    public boolean GetisExportLibrary() {

        return this.isExportLibrary;
    }

    public boolean GetisClusterWithCase() {

        return this.isClusterWithCase;
    }

   public boolean isIndexChatSessions() {
       return this.isIndexChatSessions;
   }
   public boolean isDectetBroswerSessions()
   {
       return this.isDetectBrowserRessions;
   }

    public boolean GetisExcludeFileSystems() {

        return this.isExcludeFileSystems;
    }

    public List<EmailConfig> GetEmailConfig() {

        return this.emailInfo;
    }

    // used to update case status after indexing
    // Wajdy: to be removed when find other way to store case information!
    public void setIndexStatus(boolean status) {
    }

    public void setLastIndexDate(String value) {
    }

    public void setIndexingTime(String value) {
    }

    public String getIndexName() {
        return this.indexName;
    }

    public List<EmailConfig> getEmailConfig() {
        return this.emailInfo;
    }

    public String getIndexLocation() {
        return this.indexLocation;
    }

    public String getInvestigatorName() {
        return this.investigatorName;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getIndexStatus() {
        return this.indexStatus;
    }

    public List<String> getDocumentInIndex() {

        List<String> list = new ArrayList<String>();
        list.add(caseSource);
        return list;
    }

    public List<String> getExtensionAllowed() {
        return Collections.emptyList();
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public long getCaseSize() {
        return this.caseSize;
    }

    public boolean getCacheImages() {
        return isCacheImages;
    }

    public boolean getCheckCompressed() {
        return isIndexArchive;
    }
    
    public boolean getCheckEmbedded() {
        return isIndexEmbedded;
    }

    public String getLastIndexDate() {
        return this.lastIndexDate;
    }

    public String getIndexingTime() {
        return this.indexingTime;
    }
}
