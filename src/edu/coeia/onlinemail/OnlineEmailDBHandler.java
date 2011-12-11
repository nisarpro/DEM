package edu.coeia.onlinemail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import edu.coeia.util.FileUtil;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.File;

import java.util.Collections;
import static edu.coeia.util.PreconditionsChecker.*;

/**
 * EmailDatabase write EmailMessage to Email Database
 * @auther Wajdy Essam
 * @version 1.0
 */
public class OnlineEmailDBHandler {

    public OnlineEmailDBHandler(String databasePath) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        boolean isDBFound = FileUtil.isDirectoryExists(databasePath);
        this.createDB(isDBFound, databasePath);

    }

    public void createDB(boolean nDB, String databasePath)
            throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {

        databasePath = checkNull("database path must be not null", databasePath);

        DB_URL = DB_NAME + databasePath;

        if (!nDB) {
            DB_URL += ";create=true";
            System.out.println("Creating Database ");
        } else {
            System.out.println("Opening Existing Database ");
        }

        connectDB();

        if (!nDB) {
            makeDBStructure();
        }
    }

    public List<OnlineEmailMessage> getAllMessages() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {


        String select = "SELECT * FROM emails ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<OnlineEmailMessage> mEmails = new ArrayList<OnlineEmailMessage>();
        OnlineEmailMessage message = null;

        while (resultSet.next()) {
    
            String paths = resultSet.getString("PATH");
            List<String> listPaths = Collections.emptyList();
            if (!paths.isEmpty()) {
                String[] arrPaths = paths.split(",");
                listPaths = Arrays.asList(arrPaths);
            }

            String bcc = resultSet.getString("BCC");
            List<String> bccList = Collections.emptyList();
            if (!bcc.isEmpty()) {
                String[] bccArray = bcc.split(",");
                bccList = Arrays.asList(bccArray);

            }

            String cc = resultSet.getString("CC");
            List<String> ccList = Collections.emptyList();

            if (!cc.isEmpty()) {
                String[] ccArray = cc.split(",");
                ccList = Arrays.asList(ccArray);
            }
            
            
            String to = resultSet.getString("To");
            List<String> toList = Collections.emptyList();

            if (!to.isEmpty()) {
                String[] toArray = cc.split(",");
                toList = Arrays.asList(toArray);
            }
            message = OnlineEmailMessage.newInstance(resultSet.getInt("EMAILID"),
                    resultSet.getString("USERNAME"),
                    resultSet.getString("FROM_ADDRESS"),
                    resultSet.getString("TO_ADDRESS"),
                    bccList, 
                    ccList, 
                    resultSet.getString("SUBJECT"),
                    resultSet.getAsciiStream("BODY_MESSAGE"), 
                    resultSet.getString("SENT_DATE"),
                    resultSet.getString("CREATED_DATE"), 
                    listPaths, resultSet.getString("Folder_Name"));

            mEmails.add(message);
        }
        resultSet.close();
        statement.close();

        return mEmails;

    }

    public void inserteEmail(int id,String Username, String From, String To, String Subject, String Body,
            String Created_Date, String Sent_Date, String CC, String BCC, String Path, String FolderName)
            throws SQLException, UnsupportedEncodingException {

        String s = "insert into emails values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement psInsert = connection.prepareStatement(s);
        psInsert.setString(1, Username);
        psInsert.setInt(2, id);
        psInsert.setString(3, From);
        psInsert.setString(4, To);
        psInsert.setString(5, Subject);
        InputStream is = new ByteArrayInputStream(Body.getBytes());
        psInsert.setAsciiStream(6, is);
        psInsert.setString(7, Created_Date);
        psInsert.setString(8, Sent_Date);
        psInsert.setString(9, CC);
        psInsert.setString(10, BCC);
        psInsert.setString(11, Path);
        psInsert.setString(12, FolderName);

        psInsert.executeUpdate();
        psInsert.close();
    }

    public void closeDB() throws SQLException {
        connection.close();
        DriverManager.getConnection("jdbc:derby:;shutdown=true");
    }

    public void connectDB() throws ClassNotFoundException, InstantiationException,
            SQLException, IllegalAccessException {
        Class.forName(DB_DRIVER).newInstance();
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    private void makeDBStructure() throws SQLException {
        Statement statement_ = connection.createStatement();



        String emailTables =
                "CREATE TABLE emails ("
                + "USERNAME VARCHAR(500),"
                + "EMAILID DECIMAL(20) NOT NULL, "
                + "FROM_ADDRESS VARCHAR(500), "
                + "TO_ADDRESS VARCHAR (800),  "
                + "SUBJECT VARCHAR(500),"
                + "BODY_MESSAGE CLOB(10 M),"
                + "CREATED_DATE VARCHAR(100),"
                + "SENT_DATE VARCHAR(100),"
                + "CC VARCHAR(5000),"
                + "BCC VARCHAR(5000),"
                + "PATH VARCHAR(5000),"
                + "FOLDER_NAME VARCHAR(400)"
                + ")";


        statement_.execute(emailTables);
        statement_.close();
    }

    public static boolean isDBExists(String Path) {
        File file = new File(Path);
        boolean isDB = false;

        if (file.exists()) {
            if (file.isDirectory()) {
                isDB = true;
            }
        }

        return isDB;
    }
    private String DB_URL;
    private static String DB_NAME = "jdbc:derby:";
    private static String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String DB_USER = "";
    private static String DB_PASS = "";
    private Connection connection;
}