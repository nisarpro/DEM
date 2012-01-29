/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.task;

import edu.coeia.cases.Case;
import edu.coeia.cases.ApplicationManager;
import edu.coeia.cases.CaseManager;
import edu.coeia.cases.CaseManagerFrame;
import edu.coeia.util.FilesPath;
import edu.coeia.util.GUIFileFilter;
import edu.coeia.util.ZipUtil;

import java.io.File;

import javax.swing.JFileChooser;

/**
 *
 * @author wajdyessam
 */
public class CaseImporterTask implements Task{
    private final TaskThread thread;
    private final CaseManagerFrame frame;
    private File file;
    
    public CaseImporterTask(final CaseManagerFrame frame) {
        this.thread = new TaskThread(this);
        this.frame = frame;
    }
    
    @Override
    public void startTask() {
        final GUIFileFilter SWING_DEM_FILTER = new GUIFileFilter("DEM CASE", 
            FilesPath.DEM_CASE_EXTENSION);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(SWING_DEM_FILTER);

        int result = fileChooser.showOpenDialog(null);
        if ( result == JFileChooser.APPROVE_OPTION ) {
            file = fileChooser.getSelectedFile();
            this.thread.execute();
        }
    }
    
    @Override
    public void doTask() throws Exception {
        importCaseAction();
    }
    
    @Override
    public boolean isCancelledTask() {
        return this.thread.isCancelledThread();
    }
    
    private void importCaseAction() throws Exception{
        ZipUtil zipper = new ZipUtil(this);
        String fileNameWithOutExt = file.getName().toString().replaceFirst("[.][^.]+$", "");
        String destPath = ApplicationManager.Manager.getCasesPath() + File.separator + fileNameWithOutExt;
        zipper.decompress(file.getAbsolutePath(), destPath);

        File filePath = new File(destPath).listFiles()[0];
        String path = filePath.listFiles()[0].getAbsolutePath();

        String line = fileNameWithOutExt + " - " + path;
        Case aCase = ApplicationManager.Manager.getCase(line);
        aCase.setCaseLocation(path);
        
        String prefLocation = aCase.getCaseLocation() + File.separator +  FilesPath.DEM_CASE_PREFERENCE;
        CaseManager caseManger = CaseManager.newInstance(aCase);
        caseManger.updateCase(aCase.getCaseName(), path);
        caseManger.importHistory(prefLocation);
        
        this.frame.readCases();
    }
}
