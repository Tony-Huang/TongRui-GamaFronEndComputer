/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.logmanagement;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.SystemLogService;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.data.CatSystemLog;
import com.tongrui.shangweiji.data.CatSystemLogLevel;
import com.tongrui.shangweiji.ui.MainWindow;
import common.SystemInfo;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class LogRecorder {
    private static final int EVENT =1;
    private static final int ERROR_AND_WARNING =2; 
    private String errorState = ""; 
    
    //VR102
    private static boolean lastEmergencyStop = false;
    private static boolean lastCureEnabled = false;
    private static boolean lastPhotoEnabled = false;
    private static boolean lastCureStoped = false;
    private static boolean lastZ2Zero = false;
    private static boolean lastZ2Shield = false;
    private static boolean lastColli1Opend = false;
    private static boolean lastColli2Opend = false;
    private static boolean lastColli3Opend = false;
    private static boolean lastColli4Opend = false;
    private static boolean lastT2Zero = false;
    private static boolean lastT2Sheild = false;
    //VR103
    private static boolean lastY2LimitUp = false;
    private static boolean lastY2LimitDown = false;
    private static boolean lastY11Zero = false;
    private static boolean lastY11LimitUp = false;
    private static boolean lastY11LimitDwon = false;
    private static boolean lastZ11Zero = false;
    private static boolean lastZ11LimitOut = false;
    private static boolean lastZ11LimitIn = false;
    private static boolean lastX2LimitOut = false;
    private static boolean lastX2LimitIn = false;
    private static boolean lastX11Zero = false;
    private static boolean lastX11LimitLeft = false;
    private static boolean lastX11LimitRight = false;
    private static boolean lastX12Zero = false;
    private static boolean lastX12LimitLeft = false;
    private static boolean lastX12LimitRight = false;
    //VR104
    private static boolean lastX2Zero = false;
    private static boolean lastY2Zero = false;
    private static boolean lastServoError = false;
    //VR108
    private static boolean lastAlarm1 = false;
    private static boolean lastAlarm2 = false;
    private static boolean lastAlarm3 = false;
    private static boolean lastAlarm4 = false;
    private static boolean lastAlarm5 = false;
    private static boolean lastAlarm6 = false;
    private static boolean lastAlarm7 = false;
    private static boolean lastAlarm8 = false;
    private static boolean lastFQ1 = false;
    private static boolean lastFQ2 = false;
    private static boolean lastFQ3 = false;
    private static boolean lastFQ4 = false;
    //VR108
    private static boolean lastRoomGateOpen = false;
    private static boolean lastFQ5 = false;
    private static boolean lastFQ6 = false;
    private static boolean lastFQ7 = false;
    private static boolean lastFQ8 = false;
    
    private static int lastCheckState = 0; //After power on
    
    private static int logState = Constant.RESULT_YES;
    private static LogRecorder instantce = new LogRecorder();

    public String getErrorState() {
        return errorState;
    }

    public static int getLogState() {
        return logState;
    }

    public static void setLogState(int logState) {
        LogRecorder.logState = logState;
    }

    public static LogRecorder getInstantce() {
        return instantce;
    }
    
    public void logCheck() throws Throwable{
        boolean currentState;
        String currentMessage = "";
        
        //Error check
        /*Finished Error and Warning are as follow
        //VR102
        EmergencyStop();
        //CureEnabled();
        //PhotoEnabled();
        //CureStoped();
        //Z2Zero();
        //Z2Shield();
        //Colli1Opend();
        //Colli2Opend();
        /Colli3Opend();
        //Colli4Opend();
        //T2Zero();
        //T2Sheild();
        //VR103
        Y2LimitUp();
        Y2LimitDown();
        //Y11Zero();
        Y11LimitUp();
        Y11LimitDwon();
        //Z11Zero();
        Z11LimitOut();
        Z11LimitIn();
        X2LimitOut();
        X2LimitIn();
        //X11Zero();
        X11LimitLeft();
        X11LimitRight();
        //X12Zero();
        X12LimitLeft();
        X12LimitRight();
        //VR104
        //X2Zero();
        //Y2Zero();
        ServoError();
        //VR108
        Alarm1();
        Alarm2();
        Alarm3();
        Alarm4();
        Alarm5();
        Alarm6();
        Alarm7();
        Alarm8();
        FQ1();
        FQ2();
        FQ3();
        FQ4();
        //VR108
        RoomGateOpen();
        FQ5();
        FQ6();
        FQ7();
        FQ8();  */
        
        //Prepare basic log infomation for ERROR_AND_WARNING check
        CatSystemLogLevel systemLogLevel = new CatSystemLogLevel();
        systemLogLevel.setId(ERROR_AND_WARNING);
        CatSystemLog systemLog = new CatSystemLog();
        systemLog.setCatSystemLogLevel(systemLogLevel);
        systemLog.setHappenTime(new Date());
        systemLog.setPatientId(MainWindow.getPatientIdFromDB());
        systemLog.setPatientName(MainWindow.getPatientNameFromDB());
        if (SystemInfo.getCurrentUser() != null) {
            systemLog.setOperator(SystemInfo.getCurrentUser().getUserName());
        }
        
        //VR102
        currentState = ctrlSvcImplObj.isEmergencyStop();
        if (lastEmergencyStop != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Emergency stop");
                currentMessage = "Emergency stop";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Emergency stop");
            }
            systemLogSvc.save(systemLog);
        }
        lastEmergencyStop = currentState;
        
        //VR103
        currentState = ctrlSvcImplObj.isY2LimitUp();
        if (lastY2LimitUp != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Y2 reachs up-limit position");
                currentMessage = "Y2 reachs up-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Y2 leaves up-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastY2LimitUp = currentState;
        
        currentState = ctrlSvcImplObj.isY2LimitDown();
        if (lastY2LimitDown != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Y2 reachs down-limit position");
                currentMessage = "Y2 reachs down-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Y2 leaves down-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastY2LimitDown = currentState;
        
        currentState = ctrlSvcImplObj.isY11LimitUp();
        if (lastY11LimitUp != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Y11 reachs up-limit position");
                currentMessage = "Y11 reachs up-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Y11 leaves up-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastY11LimitUp = currentState;
        
        currentState = ctrlSvcImplObj.isY11LimitDwon();
        if (lastY11LimitDwon != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Y11 reachs down-limit position");
                currentMessage = "Y11 reachs down-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Y11 leaves down-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastY11LimitDwon = currentState;
        
        if(Constant.DEBUG_this_is_TouDao == true) {
            currentState = ctrlSvcImplObj.isZ11LimitOut();
            if (lastZ11LimitOut != currentState) {

                if (currentState) { //Reach to limit position
                    systemLog.setLogMessage("Z11 reachs outside-limit position");
                    currentMessage = "Z11 reachs outside-limit position";
                } else {            //leave out limit position
                    systemLog.setLogMessage("-Y2 leaves outside-limit position");
                }
                systemLogSvc.save(systemLog);
            }
            lastZ11LimitOut = currentState;

            currentState = ctrlSvcImplObj.isZ11LimitIn();
            if (lastZ11LimitIn != currentState) {

                if (currentState) { //Reach to limit position
                    systemLog.setLogMessage("Z11 reachs inside-limit position");
                    currentMessage = "Z11 reachs inside-limit position";
                } else {            //leave out limit position
                    systemLog.setLogMessage("-Z11 leaves inside-limit position");
                }
                systemLogSvc.save(systemLog);
            }
            lastZ11LimitIn = currentState;
        }
        
        currentState = ctrlSvcImplObj.isX2LimitOut();
        if (lastX2LimitOut != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("X2 reachs outside-limit position");
                currentMessage = "X2 reachs outside-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-X2 leaves outside-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastX2LimitOut = currentState;
        
        currentState = ctrlSvcImplObj.isX2LimitIn();
        if (lastX2LimitIn != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("X2 reachs inside-limit position");
                currentMessage = "X2 reachs inside-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-X2 leaves inside-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastX2LimitIn = currentState;
        
        currentState = ctrlSvcImplObj.isX11LimitLeft();
        if (lastX11LimitLeft != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("X11 reachs left-limit position");
                currentMessage = "X11 reachs left-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-X11 leaves left-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastX11LimitLeft = currentState;
        
        currentState = ctrlSvcImplObj.isX11LimitRight();
        if (lastX11LimitRight != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("X11 reachs right-limit position");
                currentMessage = "X11 reachs right-limit position";
            } else {            //leave out limit position
                systemLog.setLogMessage("-X11 leaves right-limit position");
            }
            systemLogSvc.save(systemLog);
        }
        lastX11LimitRight = currentState;
        
        if(Constant.DEBUG_this_is_TouDao == true) {
            currentState = ctrlSvcImplObj.isX12LimitLeft();
            if (lastX12LimitLeft != currentState) {

                if (currentState) { //Reach to limit position
                    systemLog.setLogMessage("X12 reachs left-limit position");
                    currentMessage = "X12 reachs left-limit position";
                } else {            //leave out limit position
                    systemLog.setLogMessage("-X12 leaves left-limit position");
                }
                systemLogSvc.save(systemLog);
            }
            lastX12LimitLeft = currentState;

            currentState = ctrlSvcImplObj.isX12LimitRight();
            if (lastX12LimitRight != currentState) {

                if (currentState) { //Reach to limit position
                    systemLog.setLogMessage("X12 reachs right-limit position");
                    currentMessage = "X12 reachs right-limit position";
                } else {            //leave out limit position
                    systemLog.setLogMessage("-X12 leaves right-limit position");
                }
                systemLogSvc.save(systemLog);
            }
            lastX12LimitRight = currentState;
        }
        
        //VR104
        currentState = ctrlSvcImplObj.isServoError();
        if (lastServoError != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Servo is error");
                currentMessage = "Servo is error";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Servo is error");
            }
            systemLogSvc.save(systemLog);
        }
        lastServoError = currentState;
        
        //VR108
        currentState = ctrlSvcImplObj.isServo1Err();
        if (lastAlarm1 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm1 happens");
                currentMessage = "Alarm1 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm1 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm1 = currentState;
        
        currentState = ctrlSvcImplObj.isServo2Err();
        if (lastAlarm2 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm2 happens");
                currentMessage = "Alarm2 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm2 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm2 = currentState;
        
        currentState = ctrlSvcImplObj.isServo3Err();
        if (lastAlarm3 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm3 happens");
                currentMessage = "Alarm3 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm3 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm3 = currentState;
        
        currentState = ctrlSvcImplObj.isServo4Err();
        if (lastAlarm4 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm4 happens");
                currentMessage = "Alarm4 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm4 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm4 = currentState;
        
        currentState = ctrlSvcImplObj.isServo5Err();
        if (lastAlarm5 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm5 happens");
                currentMessage = "Alarm5 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm5 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm5 = currentState;
        
        currentState = ctrlSvcImplObj.isServo6Err();
        if (lastAlarm6 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm6 happens");
                currentMessage = "Alarm6 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm6 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm6 = currentState;
        
        currentState = ctrlSvcImplObj.isServo7Err();
        if (lastAlarm7 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm7 happens");
                currentMessage = "Alarm7 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm7 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm7 = currentState;
        
        currentState = ctrlSvcImplObj.isServo8Err();
        if (lastAlarm8 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("Alarm8 happens");
                currentMessage = "Alarm8 happens";
            } else {            //leave out limit position
                systemLog.setLogMessage("-Alarm8 happens");
            }
            systemLogSvc.save(systemLog);
        }
        lastAlarm8 = currentState;
        
        //FQ break
        currentState = ctrlSvcImplObj.isFQ1();
        if (lastFQ1 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ1 breaks");
                currentMessage = "FQ1 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ1 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ1 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ2();
        if (lastFQ2 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ2 breaks");
                currentMessage = "FQ2 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ2 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ2 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ3();
        if (lastFQ3 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ3 breaks");
                currentMessage = "FQ3 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ3 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ3 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ4();
        if (lastFQ4 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ4 breaks");
                currentMessage = "FQ4 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ4 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ4 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ5();
        if (lastFQ5 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ5 breaks");
                currentMessage = "FQ5 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ5 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ5 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ6();
        if (lastFQ6 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ6 breaks");
                currentMessage = "FQ6 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ6 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ6 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ7();
        if (lastFQ7 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ7 breaks");
                currentMessage = "FQ7 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ7 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ7 = currentState;
        
        currentState = ctrlSvcImplObj.isFQ8();
        if (lastFQ8 != currentState) {
            
            if (currentState) { //Reach to limit position
                systemLog.setLogMessage("FQ8 breaks");
                currentMessage = "FQ8 breaks";
            } else {            //leave out limit position
                systemLog.setLogMessage("-FQ8 breaks");
            }
            systemLogSvc.save(systemLog);
        }
        lastFQ8 = currentState;
        
        int autoCheckState = ctrlSvcImplObj.getAutoCheckState();
        if (autoCheckState != lastCheckState && autoCheckState == Constant.AUTO_CHECK_ERROR) {
            systemLog.setLogMessage("Auto checking is error.");
            currentMessage = "Auto checking is error.";
            systemLogSvc.save(systemLog);
        }
        lastCheckState = autoCheckState;
        
        errorState = currentMessage;
    }
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance(); 
    private static SystemLogService systemLogSvc = ServiceLocator.getSystemLogService(); }
