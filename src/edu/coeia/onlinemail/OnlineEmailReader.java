package edu.coeia.onlinemail;

import edu.coeia.indexing.EmailDownDialogue;
import edu.coeia.util.FileUtil;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static edu.coeia.util.PreconditionsChecker.*;

import java.io.IOException;

import java.io.InputStream;
import java.sql.SQLException;


import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.text.Normalizer;

import java.util.Collections;
import java.util.Date;

import javax.mail.Session;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Store;
import javax.mail.Part;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.MessagingException;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

class ProgressData {

    private String From;
    private String SentDate;
    private String CreationDate;
    private List<String> CC;
    private List<String> BCC;
    private String Attachments;
    private String Subject;
    private List<String> to;
    

    public ProgressData() {
    }

    public ProgressData(String From, List<String> To, String Subject, String SentDate,
            String CreationDate, List<String> CC, List<String> BCC, String Attachments) {
        this.From = From;
        this.SentDate = SentDate;
        this.CreationDate = CreationDate;
        this.CC = CC;
        this.BCC = BCC;
        this.Attachments = Attachments;
        this.Subject = Subject;
        this.to = To;
        
    }

    public String getSubject() {
        return this.Subject;
    }

    public String getTo() {

        String to = new String();
        for (String s : this.to) {
            to = s;
        }
        return to;
    }

    public String getFrom() {
        return this.From;
    }

    public String getSentDate() {
        return this.SentDate;
    }

    public String getCreationDate() {
        return this.CreationDate;
    }

    public List<String> getCC() {
        return this.CC;
    }

    public List<String> getBCC() {
        return this.BCC;
    }

    public String getAttachments() {
        return this.Attachments;
    }
}

/**
 * Email Reader - Read a Gmail Email using Java Mail API
 * and Store all the message in List for processing
 * @auther Wajdy Essam
 * @version 1.0 18-7-2011
 */
public class OnlineEmailReader extends SwingWorker<Void, ProgressData> {

    private EmailDownDialogue emaildialogue;
    private boolean emailFinished;
    /**
     * static factory that read all message from user account and store it in list
     * @param username the name of the account
     * @param password the password of the account
     * @return EmailReader object that contain all the messages in list
     */
    public static OnlineEmailReader newInstance(EmailDownDialogue dialogue, final String userName, final String password,
            String attachmentsPath, String dbPath) throws SQLException, NoSuchProviderException, MessagingException, IOException {

        // check null values
        checkNull("username must be not null", userName);
        checkNull("password must be not null", password);
        checkNull("attachmentsPath must be not null", attachmentsPath);
        checkNull("dbPath must be not null", dbPath);

        // check empty string
        checkNotEmptyString("username must be not empty string", userName);
        checkNotEmptyString("password must be not empty string", password);
        checkNotEmptyString("attachmentsPath must be not empty string", attachmentsPath);
        checkNotEmptyString("dbPath must be not empty string", dbPath);

        return new OnlineEmailReader(dialogue, userName, password, attachmentsPath, dbPath);
    }

    public OnlineEmailReader(EmailDownDialogue dialogue, final String userName, final String password, String attachmentsPath, String dbPath) throws SQLException, NoSuchProviderException, MessagingException, IOException {
        this.userName = userName;
        this.password = password;
        this.attachmentsPath = attachmentsPath;
        this.emaildialogue = dialogue;


        Connect();


        this.emaildialogue.addWindowListener(new WindowListener() {

            public void windowClosed(WindowEvent e) {

                cancel(true);

            }

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });

        boolean create = OnlineEmailDBHandler.isDBExists(dbPath);

        if (create) {
            System.out.println("Open Exisiting DB");
        } else {
            System.out.println("Create new DB");
        }


        try {
            db = new OnlineEmailDBHandler(!create, dbPath);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * return Iterator to get EmailMesaages
     * throw NoSuchProviderException, MessagingException, IOException
     */
    public EmailIterator createIterator() throws NoSuchProviderException, MessagingException, IOException, SQLException {

        return new EmailIterator(this);
    }

    @Override
    protected Void doInBackground() throws Exception {

        int count = 0;

        if (isCancelled()) {
            emailFinished = false;
            return null;
        }

        javax.mail.Folder[] folders = store.getDefaultFolder().list("*");
        for (javax.mail.Folder folder : folders) {

            if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {

                System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
                folder.open(Folder.READ_WRITE);

            } else if (javax.mail.Folder.HOLDS_FOLDERS != 0) {

                continue;
            }

            Message[] messages = folder.getMessages();

            for (Message message : messages) {
        
                if (isCancelled()) {
                    emailFinished = false;
                    return null;
                }
                // Get cc
                List<String> cclist = getAddress(message, Message.RecipientType.BCC);
                String ccBuilder = getFormattedString(cclist);

                // Get Bcc
                List<String> bcclist = getAddress(message, Message.RecipientType.CC);
                String bccBuilder = getFormattedString(bcclist);

                int messageId = messages.length - count++;
                String from = getFromAddress(message.getFrom()[0].toString());
                List<String> to = getAddress(message, Message.RecipientType.TO);
                if(to == null) to = new ArrayList<String>();
                String subject = message.getSubject();
                String body = "";

//                try {
//                    body = getMessageContent(message);
//                } catch (MessagingException ex) {
//
//                    ex.printStackTrace();
//
//                }
                
              
                
                Date sentDate = message.getSentDate();
                if (sentDate == null) sentDate = new Date();
                Date receiveDate = message.getReceivedDate();
                if (receiveDate == null ) receiveDate = new Date();
                
                System.out.println("SentDate : " + sentDate);
                System.out.println("ReceiveDate : " + receiveDate);
                System.out.println("------------From------\n" + from);
                System.out.println();
                for (String d : cclist) {

                    System.out.println("------------CC------\n" + d);

                }
                for (String s : bcclist) {
                    System.out.println("------------BCC------\n" + s);

                }
                System.out.println("------------Subject------\n" + subject);
                
               // dumpPart(message);
                System.out.println("------------Body------\n" + body);

                // Save Attachment
                List<String> Paths = getAttachments(message);
                String pathBuilder = getFormattedString(Paths);

                try {
                    // Save Message in DB 
                    db.inserteEmail(messageId, from, subject, body, sentDate.toString(), receiveDate.toString(), ccBuilder, bccBuilder, pathBuilder.toString(), folder.getFullName());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

               try{
                   ProgressData PData = new ProgressData(from, to, subject, sentDate.toString(), receiveDate.toString(),
                        cclist, bcclist, pathBuilder);

                publish(PData);
               }
               catch (Exception ex )
               {
                   ex.printStackTrace();
               }

            }
        }
        
        emailFinished = true;
         
        return null;

    }

    @Override
    protected void done() {
        
        if(emailFinished)
        {
        JOptionPane.showMessageDialog(emaildialogue, "Finished downladoing emails", "Done", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(emaildialogue, "Cancelled Email Downloading", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            db.closeDB();
        } catch (SQLException ex) {
            Logger.getLogger(OnlineEmailReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        emaildialogue.setVisible(false);

    }

    @Override
    protected void process(List<ProgressData> chunks) {

        if (isCancelled()) {
            emailFinished = false;
            return;
        }

        for (ProgressData pd : chunks) {
            emaildialogue.getFrom().setText(pd.getFrom());

            for (String s1 : pd.getCC()) {
                emaildialogue.getCC().setText(s1 + "\n");
            }

            for (String s2 : pd.getBCC()) {
                emaildialogue.getBCC().setText(s2 + "\n");
            }
            emaildialogue.getSubject().setText(pd.getSubject());
            emaildialogue.getTo().setText(pd.getTo());
            emaildialogue.getAttachments().setText(pd.getAttachments());
            emaildialogue.getSentDate().setText(pd.getSentDate());
            emaildialogue.getCreationDate().setText(pd.getCreationDate());

        }


    }

    class EmailIterator {

        public EmailIterator(OnlineEmailReader reader) {
            this.reader = reader;
        }

        public void first() {
            this.iterator = this.reader.messageList.iterator();
            next();
        }

        public void next() {
            try {
                this.current = this.iterator.next();
            } catch (NoSuchElementException e) {
                this.current = null;
            }
        }

        public boolean hasNext() {
            return this.current == null;
        }

        public OnlineEmailMessage currentItem() {
            return this.current;
        }
        private OnlineEmailReader reader;
        private Iterator<OnlineEmailMessage> iterator;
        private OnlineEmailMessage current;
    }

    public void Connect() throws NoSuchProviderException, MessagingException {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.partialfetch", "false");

        Session session = Session.getDefaultInstance(props, null);
        store = session.getStore("imaps");
        store.connect(PROTOCOL, "xgameprogrammer@gmail.com","windows98");


    }

    private void ListAllFolders() throws MessagingException {
        Folder[] folder = store.getDefaultFolder().list("*");
        for (Folder fd : folder) {
            if ((fd.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
                System.out.println(fd.getFullName() + ": " + fd.getMessageCount());
            }
        }
    }

    String getFormattedString(List<String> list) {
        StringBuilder result = new StringBuilder();
        if (list != null) {


            for (int i = 0; i < list.size(); i++) {
                result.append(list.get(i));

                if (i < list.size() - 1) {
                    result.append(',');
                }
            }
        } else {

            return "";

        }


        return result.toString();
    }

    private List<String> getAddress(Message message, Message.RecipientType type)
            throws MessagingException {

        List<String> addressList = new ArrayList<String>();
        Address[] recipients = message.getRecipients(type);

        if (recipients != null) {
            for (Address address : recipients) {
                addressList.add(address.toString());
            }
        }

        return addressList;
    }

    private List<String> getAttachments(Message temp) throws IOException, MessagingException {

        attachments = new ArrayList<String>();

        Object objRef = temp.getContent();
        if (!(objRef instanceof Multipart)) {
            return Collections.emptyList();
        }

        Multipart multipart = (Multipart) temp.getContent();
        System.out.println("Number of Attachments: " + multipart.getCount());

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                continue; // dealing with attachments only
            }

            String decoded = MimeUtility.decodeText(bodyPart.getFileName());

            String filename = Normalizer.normalize(decoded, Normalizer.Form.NFC);
            InputStream is = bodyPart.getInputStream();

            if (is == null) {
                continue;
            }

            System.out.println("file name" + filename);
            FileUtil.saveObject(bodyPart.getInputStream(), filename, attachmentsPath);
            attachments.add(filename);

        }

        return attachments;
    }

    private String getFromAddress(String fromAdd) {
        Pattern p = Pattern.compile("[A-Z0-9\\._%\\+\\-]+@[A-Z0-9\\.\\-]+\\.[A-Z]{2,4}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fromAdd);

        while (m.find()) {
            fromAdd = (m.group());
        }

        return fromAdd;
    }

    private String getMessageContent(Message message) throws IOException, MessagingException {
        Object content = message.getContent();
        StringBuilder messageContent = new StringBuilder();
        if (content instanceof String) {
            return content.toString();
        } else if (content instanceof Multipart) {

            Multipart multipart = (Multipart) content;

            for (int i = 0; i < multipart.getCount(); i++) {
                Part part = (Part) multipart.getBodyPart(i);

                messageContent.append(part.getContent().toString());

                return "";


            }
        }
        return messageContent.toString();
    }
    
    
       public static void dumpPart(Part p) throws Exception {
	 
	String ct = p.getContentType();
	try {
	    pr("CONTENT-TYPE: " + (new ContentType(ct)).toString());
	} catch (ParseException pex) {
	    pr("BAD CONTENT-TYPE: " + ct);
	}
	String filename = p.getFileName();
	if (filename != null)
	    pr("FILENAME: " + filename);

	/*
	 * Using isMimeType to determine the content type avoids
	 * fetching the actual content data until we need it.
	 */
	if (p.isMimeType("text/plain")) {
	    pr("This is plain text");
	    pr("---------------------------");
	   
	System.out.println((String)p.getContent());
	} else if (p.isMimeType("multipart/*")) {
	    pr("This is a Multipart");
	    pr("---------------------------");
	    Multipart mp = (Multipart)p.getContent();
	    level++;
	    int count = mp.getCount();
	    for (int i = 0; i < count; i++)
		dumpPart(mp.getBodyPart(i));
	    level--;
	} else if (p.isMimeType("message/rfc822")) {
	    pr("This is a Nested Message");
	    pr("---------------------------");
	    level++;
	    dumpPart((Part)p.getContent());
	    level--;
	} else {
	     
		/*
		 * If we actually want to see the data, and it's not a
		 * MIME type we know, fetch it and check its Java type.
		 */
		Object o = p.getContent();
		if (o instanceof String) {
		    pr("This is a string");
		    pr("---------------------------");
		    System.out.println((String)o);
                }
	    
	}
 
    }
    public static void pr(String s) {
	
	    System.out.print(indentStr.substring(0, level * 2));
	System.out.println(s);
    }
    private final String userName;
    private final String password;
    private static final String PROTOCOL = "imap.gmail.com";
    private Store store;
    private List<OnlineEmailMessage> messageList = new ArrayList<OnlineEmailMessage>();
    private List<String> attachments;
    private String attachmentsPath;
    private OnlineEmailDBHandler db;
    static String indentStr = "                                               ";
    static int level = 0;
}
