/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.ui.MainWindow;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TmpDBTimer {
    private long interval = 6000;
    private long delay = 1500;
    
    public void run(){
     Timer timer = new Timer();
     
        timer.schedule(new TimerTask() {

            public void run() {
                System.out.println("----->>>>>>>>>>>>>>>>>>>>>> SvrDB TPS <<<<<<<<<<<<<<<<<<<<<<-----");
                try {
                 //   processTmpDB();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },
                delay,
                interval);
    }

    private void processTmpDB(){
        TmpDBReader instance = TmpDBReader.getInstanceTmpDB();
        try {
            instance.dataTransfer();
            instance.setIsExceptionDB(false); //No DB exception
        } catch (Throwable ex) {
            Logger.getLogger(TmpDBTimer.class.getName()).log(Level.SEVERE, null, ex);
            instance.setIsExceptionDB(true); //DB exception
        }
        
    }
    
    public static void main(String args[]) {
        TmpDBTimer tmpDBtimer = new TmpDBTimer();
        tmpDBtimer.run();
    }

}
