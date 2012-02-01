/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.items;

import edu.coeia.cases.Case;
import static edu.coeia.indexing.IndexingConstant.* ;

import org.apache.lucene.document.Document;

/**
 *
 * @author wajdyessam
 */
public class ItemFactory {
    
    public static Item newInstance (final Document document, final Case aCase) {       
        if ( isFileDocument(document)) {
            return buildFileItem(document);
        }

        if ( isEmailDocument(document)) {
            return buildOnlineEmailItem(document);
        }

        if ( isOfflineEmailDocument(document)) {
            return buildOfflineEmailItem(document);
        }
        
        if ( isChatDocument(document)) {
            return buildChatItem(document);
        }
        
        throw new UnsupportedOperationException("There is no item for this type of document");
    }
    
    private static Item buildFileItem(final Document document) {
        int documentId = Integer.parseInt(document.get(DOCUMENT_ID));
        int documentParentId = Integer.parseInt(document.get(DOCUMENT_PARENT_ID));
        String documentHash = document.get(DOCUMENT_HASH);
        
        String filePath = document.get(FILE_PATH);
        String fileName = document.get(FILE_NAME);
        String fileContent = document.get(FILE_CONTENT);
        String fileDate = document.get(FILE_DATE);
        String fileMime = document.get(FILE_MIME);
        String description = document.get(DOCUMENT_DESCRIPTION);
        
        FileItem item = new FileItem(documentId, documentParentId, documentHash, description,
            fileName, filePath, fileContent, fileDate, fileMime);
        
        return item;
    }
    
    private static Item buildChatItem(final Document document) {
        int documentId = Integer.parseInt(document.get(DOCUMENT_ID));
        int documentParentId = Integer.parseInt(document.get(DOCUMENT_PARENT_ID));
        String documentHash = document.get(DOCUMENT_HASH);
        String description = document.get(DOCUMENT_DESCRIPTION);
        
        String chatFrom = document.get(CHAT_FROM);
        String chatTo = document.get(CHAT_TO);
        String chatTime = document.get(CHAT_TIME);
        String chatMessage = document.get(CHAT_MESSAGE);

        String chatAgent = document.get(CHAT_AGENT);
        String chatFile = document.get(CHAT_FILE);
        String chatLength = document.get(CHAT_LENGTH);
        String chatMessagePath = document.get(CHAT_MESSAGE_PATH);
        
        return new ChatItem(documentId, documentParentId, documentHash,description, 
            chatFrom, chatTo, chatTime, chatMessage,
            chatAgent, chatFile, chatLength, chatMessagePath);
    }
    
    private static Item buildOnlineEmailItem(final Document document) {
        int documentId = Integer.parseInt(document.get(DOCUMENT_ID));
        int documentParentId = Integer.parseInt(document.get(DOCUMENT_PARENT_ID));
        String documentHash = document.get(DOCUMENT_HASH);
        String description = document.get(DOCUMENT_DESCRIPTION);
        
        String emailSendDate = document.get(ONLINE_EMAIL_SENT_DATE);
        String emailFolderName = document.get(ONLINE_EMAIL_FOLDER_NAME);
        String emailSubject = document.get(ONLINE_EMAIL_SUBJECT);
        String emailFrom = document.get(ONLINE_EMAIL_FROM);
        String emailTo = document.get(ONLINE_EMAIL_TO);
        String emailId = document.get(ONLINE_EMAIL_MESSAGE_ID);
        boolean hasAttachment = Boolean.valueOf(document.get(ONLINE_EMAIL_ATTACHMENT_PATH));
        String user = document.get(ONLINE_EMAIL_USER_NAME);
        
        return new EmailItem(documentId, documentParentId, documentHash,description,
                emailFrom, emailTo, emailSubject, emailSendDate, emailFolderName, hasAttachment,user);
    }
    
    private static Item buildOfflineEmailItem(final Document document) {
        int documentId = Integer.parseInt(document.get(DOCUMENT_ID));
        int documentParentId = Integer.parseInt(document.get(DOCUMENT_PARENT_ID));
        String documentHash = document.get(DOCUMENT_HASH);
        String description = document.get(DOCUMENT_DESCRIPTION);
        
        String emailSendDate = document.get(OFFLINE_EMAIL_CLIENT_SUBMIT_TIME);
        String emailFolderName = document.get(OFFLINE_EMAIL_FOLDER_NAME);
        String emailSubject = document.get(OFFLINE_EMAIL_SUBJECT);
        String emailFrom = document.get(OFFLINE_EMAIL_SENT_REPRESENTING_NAME);
        String emailTo = document.get(OFFLINE_EMAIL_DISPLAY_TO);
        String emailId = document.get(OFFLINE_EMAIL_ID);
        boolean hasAttachment = Boolean.valueOf(document.get(ONLINE_EMAIL_ATTACHMENT_PATH));
        String user = document.get(OFFLINE_EMAIL_PATH);
        
        EmailItem item = new EmailItem(documentId, documentParentId, documentHash, description,
                emailFrom, emailTo, emailSubject, emailSendDate, emailFolderName, hasAttachment, user);
        
        return item;
    }
}
