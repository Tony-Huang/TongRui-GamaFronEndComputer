/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.comm.Constant;
import common.SystemInfo;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class TPSTimer {
    private long interval = 60000;
    private long delay = 500;
    private int stateOfTPS_DB = Constant.RESULT_NULL; //TPS or DB
    private int stateOfCRC = Constant.RESULT_NULL;
    
    private static TPSTimer instance = new TPSTimer();

    public static TPSTimer getInstance() {
        return instance;
    }

    public int getStateOfCRC() {
        return stateOfCRC;
    }

    public int getStateOfTPS_DB() {
        return stateOfTPS_DB;
    }
    
    public void run(){
     Timer timer = new Timer();
     
     timer.schedule(new TimerTask() {

            public void run() {
                System.out.println("----->>>>>>>>>>>>>>>>>>>>>> start TPS " + " <<<<<<<<<<<<<<<<<<<<<<-----");
                try {
                    processTpsFolder();
                } catch (Throwable e) {
                    e.printStackTrace();
                }

            }
        },
                delay,
                interval);
    }
    
    
    private void processTpsFolder() throws Throwable{
       String tpsfolderStr = SystemInfo.getTPSFolder();
       File tpsFolder = new File(tpsfolderStr);
       File bkupFolder = new File(tpsFolder,"/backup");
       if(!tpsFolder.exists()){ 
           tpsFolder.mkdirs();
       }
       if(!bkupFolder.exists()){
          bkupFolder.mkdir();
       }
       
       File[] tpsfiles =tpsFolder.listFiles(new FileFilter(){
            public boolean accept(File file) {
              return file.getName().toLowerCase().endsWith(".out");
                        }
                 });
       
       for(File tpsfile:tpsfiles){
           System.out.println("file="+tpsfile.getAbsolutePath() +"  ;fileName="+tpsfile.getName());
           
           try{
                //save data to db
                boolean rs = false;;
                try {
                    rs = this.processTpsFile(tpsfile);
                } catch (Exception ex) {
                    Logger.getLogger(TPSTimer.class.getName()).log(Level.SEVERE, null, ex);
                    stateOfTPS_DB = Constant.RESULT_NO;
                    throw ex;
                }            
                stateOfTPS_DB = Constant.RESULT_YES;
                if (rs) { //Process is successful
                    //move file to bakcup folder
                    File dstFile = new File(bkupFolder, tpsfile.getName());
                    this.copyToFile(tpsfile, dstFile);

                    //delete original file
                    tpsfile.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
    }
    
    private boolean processTpsFile(File file) throws Throwable{
       TPSFileParser parser = TPSFileParser.getInstanceTPS();
       TPSFileReader tpsReader = new TPSFileReader();
       CalcCRC crc = new CalcCRC();
       boolean result = false;
       
       List<String> content = tpsReader.readFile(file);
       if(crc.isCrcCorrect(content)) {
            stateOfCRC = Constant.RESULT_YES;
            try {
                if(parser.parse(content)) {
                    ServiceLocator.getPatientService().saveOrUpdate(parser.getPatient());
                    result = true;
                }
            } catch (Throwable ex) {
                Logger.getLogger(TPSTimer.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
       } else {
           stateOfCRC = Constant.RESULT_NO;
       }
       return result;
    }
    
    private  void copyToFile(File source, File target) throws IOException {
      FileChannel in = new FileInputStream(source).getChannel();
      FileChannel out = new FileOutputStream(target).getChannel();
     
       out.transferFrom(in, 0, in.size());
       in.close();
       out.close();
    }
    
     public static void main(String[] args)  throws Exception{
         TPSTimer tt= new TPSTimer();
          tt.run();
     
     }
  
    
    
}
