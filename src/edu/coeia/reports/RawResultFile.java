/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.reports;

import edu.coeia.cases.Case;
import edu.coeia.cases.CaseFacade;
import edu.coeia.constants.ApplicationConstants;
import edu.coeia.gutil.JTableUtil;
import edu.coeia.tags.Tag;
import edu.coeia.tags.TagsManager;
import edu.coeia.util.DateUtil;
import edu.coeia.util.FileUtil;

import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;

import org.apache.commons.io.FileUtils;

/**
 *
 * @author Farhan
 */
public class RawResultFile {

    public static DatasourceXml getExtensionFrequencyXmlFile(Map<String, Double> map, Case currentCase) {
        // iterator over map
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();
        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\fileextension_report.jasper";
        sourceXml.m_strXPath = "/dem/detail/effectiveextensions/ext";
        sourceXml.m_strReportName = "fileextension";

        String strOutputPath = mainRawfilePath + "\\fileextension.xml";
        String retOutput = "";
        String strLocation = currentCase.getCaseLocation();
        String strCaseXml = "<dem><case>"
                + "<name>" + currentCase.getCaseName() + "</name>"
                + "<author>" + currentCase.getDescription() + "</author>"
                + "<source> " + strLocation + "</source>"
                + "</case>";

        String filesdata = "";
        int icounter = 1;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String extension = entry.getKey();
            double frequecy = entry.getValue();

            // operations here...
            filesdata +=
                    "<ext>"
                    + "<sno>" + icounter + "</sno>"
                    + "<extension>" + extension + "</extension>"
                    + "<frequency>" + frequecy + "</frequency>"
                    + "</ext>";
            icounter++;
        }

        retOutput = strCaseXml
                + "<detail>"
                + "<effectiveextensions>"
                + filesdata
                + "</effectiveextensions>"
                + "</detail>"
                + "</dem>";

        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, retOutput);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getCasesXmlFile(List<Case> cases, Case currentCase) throws IOException {

        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();
        sourceXml.m_strJasperFile = "\\cases_report.jasper";
        sourceXml.m_strXPath = "/dem/cases/case";
        sourceXml.m_strReportName = "cases";

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        String strOutputPath = mainRawfilePath + "\\cases.xml";
        String retOutput = "";
        String strLocation = currentCase.getCaseLocation();
        String strCaseXml = "<dem><cases>";
        String casess = "";

        for (Case aCase : cases) {
            String caseName = aCase.getCaseName();
            String caseLocation = aCase.getCaseLocation();
            caseLocation = caseLocation.replace(':', '\\');
            String caseCreatingTime = DateUtil.formatedDateWithTime(aCase.getCreateTime());
            String caseAuther = aCase.getInvestigatorName();
            String caseDescription = aCase.getDescription();
            long caseSize = CaseFacade.newInstance(aCase).getCaseHistory().getCaseSize();
            casess += "<case>"
                    + "<path>" + caseLocation + "</path>"
                    + "<creator>" + caseAuther + "</creator>"
                    + "<name>" + caseName + "</name>"
                    + "<description>" + caseDescription + "</description>"
                    + "<size>" + caseSize + "</size>"
                    + "<date>" + caseCreatingTime + "</date>"
                    + "</case>";
            // operations here
        }

        strCaseXml += casess + "</cases></dem>";

        try {
            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getFileSystemXmlFile(List<String> list, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\filesystem_report.jasper";
        sourceXml.m_strXPath = "/dem/detail/effectivefiles/file";
        sourceXml.m_strReportName = "filesystem";

        String strOutputPath = mainRawfilePath + "\\filesystem.xml";
        String retOutput = "";

        String strLocation = currentCase.getCaseLocation();
        strLocation = strLocation.replace(':', '\\');

        String strCaseXml = "<dem><case>"
                + "<name>" + currentCase.getCaseName() + "</name>"
                + "<author>" + currentCase.getDescription() + "</author>"
                + "<source> " + strLocation + "</source>"
                + "</case>";

        String files = "";

        Iterator<String> iterator = list.iterator();
        int icounter = 1;
        while (iterator.hasNext()) {
            String strPath = iterator.next();
            File file = new File(strPath);
            strPath.replace(':', '/');

            long filesize = file.length();
            long filesizeInKB = filesize / 1024;


            Date date = new Date(file.lastModified());
            int mid = strPath.lastIndexOf(".");
            String ext = strPath.substring(mid + 1, strPath.length());
            files +=
                    "<file>"
                    + "<sno>" + icounter + "</sno>"
                    + "<path>" + strPath + "</path>"
                    + "<size>" + filesizeInKB + "kb</size>"
                    + "<moddate>" + date + "</moddate>"
                    + "<extension>" + ext + "</extension>"
                    + "</file>";
            icounter++;
        }

        retOutput = strCaseXml
                + "<detail>"
                + "<effectivefiles>"
                + files
                + "</effectivefiles>"
                + "</detail>"
                + "</dem>";

        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, retOutput);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getTaggedItems(TagsManager tags, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\taggeditems_report.jasper";
        sourceXml.m_strXPath = "/dem/filetags/tag";
        sourceXml.m_strReportName = "taggeditems";

        String strOutputPath = mainRawfilePath + "\\taggeditems.xml";

        List<Tag> taggeditems = tags.getTags();


        String strCaseXml = "<dem><case>"
                + "<name>" + currentCase.getCaseName() + "</name>"
                + "<author>" + currentCase.getDescription() + "</author>"
                + "<source> </source>"
                + "</case><filetags>";


        for (Tag t : taggeditems) {

            strCaseXml += "<tag><name>" + t.getName() + "</name>"
                    + "<moddate>" + t.getDate() + "</moddate>"
                    + "<message>" + t.getMessage() + "</message>"
                    + "</tag>";
        }

        strCaseXml += "</filetags></dem>";

        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getSignatureItems(JTable Table, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\filesignature_report.jasper";
        sourceXml.m_strXPath = "/filesign/sign";
        sourceXml.m_strReportName = "filesignature";

        String strOutputPath = mainRawfilePath + "\\filesignature.xml";

        Object[][] data = JTableUtil.getTableData(Table);


        int r = Table.getRowCount();
        int c = Table.getColumnCount();

        for (int i = 0; i < r; i++) {
            for (int x = 0; x < c; x++) {
                if (data[i][x] == null) {
                    data[i][x] = new String();
                }
            }
        }
        String strCaseXml = "<filesign>";
        for (int i = 0; i < r; i++) {
            strCaseXml += "<sign><filename>" + data[i][0] + "</filename>"
                    + "<status>" + data[i][2] + "</status>"
                    + "<suspected>" + data[i][3] + "</suspected>"
                    + "<fileextensions>" + data[i][4] + "</fileextensions>"
                    + "<signatures>" + data[i][1] + "</signatures>"
                    + "</sign>";
        }
        strCaseXml += "</filesign>";


        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getDatabaseSignatures(JTable Table, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\databasesignature_report.jasper";
        sourceXml.m_strXPath = "/filedb/db";
        sourceXml.m_strReportName = "databasesignatures";

        String strOutputPath = mainRawfilePath + "\\databasesignatures.xml";

        Object[][] data = JTableUtil.getTableData(Table);


        int r = Table.getRowCount();
        int c = Table.getColumnCount();

        for (int i = 0; i < r; i++) {
            for (int x = 0; x < c; x++) {
                if (data[i][x] == null) {
                    data[i][x] = new String();
                }
            }
        }


        String strCaseXml = "<filedb>";
        for (int i = 0; i < r; i++) {
            strCaseXml += "<db><fileext>" + data[i][0] + "</fileext>"
                    + "<filesign>" + data[i][1] + "</filesign>"
                    + "<filetype>" + data[i][2] + "</filetype>"
                    + "<filecatg>" + data[i][3] + "</filecatg>"
                    + "</db>";
        }
        strCaseXml += "</filedb>";


        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getHashAnalysisHashLibrary(JTable Table, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\hashanalysis_report.jasper";
        sourceXml.m_strXPath = "/hashfile/file";
        sourceXml.m_strReportName = "hashanalysis_report";

        String strOutputPath = mainRawfilePath + "\\hashanalysis_report.xml";

        Object[][] data = JTableUtil.getTableData(Table);


        int r = Table.getRowCount();
        int c = Table.getColumnCount();

        for (int i = 0; i < r; i++) {
            for (int x = 0; x < c; x++) {
                if (data[i][x] == null) {
                    data[i][x] = new String();
                }
            }
        }


        String strCaseXml = "<hashfile>";
        for (int i = 0; i < r; i++) {
            strCaseXml += "<file><filename>" + data[i][0] + "</filename>"
                    + "<filepath>" + data[i][1] + "</filepath>"
                    + "<hashset>" + data[i][2] + "</hashset>"
                    + "<hashvalue>" + data[i][3] + "</hashvalue>"
                    + "</file>";
        }
        strCaseXml += "</hashfile>";


        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getHashAnalysisinCase(JTable Table, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\hashanalysis_incase_report.jasper";
        sourceXml.m_strXPath = "/hashfile/file";
        sourceXml.m_strReportName = "hashanalysis_incase_report";

        String strOutputPath = mainRawfilePath + "\\hashanalysis_incase_report.xml";

        Object[][] data = JTableUtil.getTableData(Table);


        int r = Table.getRowCount();
        int c = Table.getColumnCount();

        for (int i = 0; i < r; i++) {
            for (int x = 0; x < c; x++) {
                if (data[i][x] == null) {
                    data[i][x] = new String();
                }
            }
        }


        String strCaseXml = "<hashfile>";
        for (int i = 0; i < r; i++) {
            strCaseXml += "<file><filename>" + data[i][0] + "</filename>"
                    + "<filepath>" + data[i][1] + "</filepath>"
                    + "<date>" + data[i][2] + "</date>"
                    + "<hashvalue>" + data[i][3] + "</hashvalue>"
                    + "</file>";
        }
        strCaseXml += "</hashfile>";


        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }

    public static DatasourceXml getTextClouds(JTable Table, Case currentCase) {
        String mainRawfilePath = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_ROW_REPORT_FOLDER;
        String cookedReportFolder = currentCase.getCaseLocation() + File.separator + ApplicationConstants.CASE_REPORTS_FOLDER;
        
        DatasourceXml sourceXml = new DatasourceXml();

        if (!FileUtil.isDirectoryExists(mainRawfilePath)) {
            FileUtil.createFolder(mainRawfilePath);
        }

        if (!FileUtil.isDirectoryExists(cookedReportFolder)) {
            FileUtil.createFolder(cookedReportFolder);
        }

        sourceXml.m_strJasperFile = "\\commonfrequency.jasper";
        sourceXml.m_strXPath = "/wordclouds/cloud";
        sourceXml.m_strReportName = "commonfrequency";

        String strOutputPath = mainRawfilePath + "\\commonfrequency_report.xml";

        Object[][] data = JTableUtil.getTableData(Table);


        int r = Table.getRowCount();
        int c = Table.getColumnCount();

        for (int i = 0; i < r; i++) {
            for (int x = 0; x < c; x++) {
                if (data[i][x] == null) {
                    data[i][x] = new String();
                }
            }
        }


        String strCaseXml = "<wordclouds>";
        for (int i = 0; i < r; i++) {
            strCaseXml += "<cloud><word>" + data[i][0] + "</word>"
                    + "<frequency>" + data[i][1] + "</frequency>"
                    + "</cloud>";

        }
        strCaseXml += "</wordclouds>";


        try {

            File file = new File(strOutputPath);
            FileUtils.writeStringToFile(file, strCaseXml);
        } catch (IOException e) {
            e.printStackTrace();
            strOutputPath = "";
        }

        sourceXml.m_strXmlPath = strOutputPath;

        return sourceXml;
    }
}
