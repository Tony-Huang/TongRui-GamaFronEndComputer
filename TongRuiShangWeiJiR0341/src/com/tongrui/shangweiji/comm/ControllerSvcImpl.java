/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import com.tongrui.shangweiji.data.CatTreatmentPlanFocus;
import com.tongrui.shangweiji.ui.logmanagement.LogRecorder;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class ControllerSvcImpl {
    private static final Log log = LogFactory.getLog(ControllerSvcImpl.class);

    private static ControllerSvcImpl ctrlSvcImplObj = new ControllerSvcImpl();
    public static ControllerSvcImpl getInstance() {
        return ctrlSvcImplObj;
    }

    //private static int DEBUG_Linked_Trio = 1; //With_Trio_Cotroller
    public static final int DEBUG_Linked_Trio = 0; //No_Trio_Cotroller

    private Random random = new Random();
    BedInfo bedinfo = new BedInfo();
    CurePolar curePolar = new CurePolar();
    CureInfo cureinfo = new CureInfo();
    DeviceInfo deviceinfo = new DeviceInfo();
    LowComputerInfo lowComputerInfo = new LowComputerInfo();
    TrioPCICom csr = new TrioPCICom();

    public void updateBedInfo() {
        if (Constant.DEBUG_this_is_TouDao == true) {
            ctrlSvcImplObj.bedinfo.setBedFollowUp_X12(getTrioVrValue(Constant.ADDR_POS_X12));
            ctrlSvcImplObj.bedinfo.setHeadFrameInOut_Z11(getTrioVrValue(Constant.ADDR_POS_Z11));
        }
        ctrlSvcImplObj.bedinfo.setBedInOut_X2(getTrioVrValue(Constant.ADDR_POS_X2));
        ctrlSvcImplObj.bedinfo.setBedDifference(getTrioVrValue(Constant.ADDR_DIFFERENCE_Y11));
        ctrlSvcImplObj.bedinfo.setHeadFrameLR_X11(getTrioVrValue(Constant.ADDR_POS_X11));
        ctrlSvcImplObj.bedinfo.setHeadFrameUD_Y11(getTrioVrValue(Constant.ADDR_POS_Y11));

        if (Constant.DEBUG_this_is_TouDao == true) {
            ctrlSvcImplObj.bedinfo.setBedFollowUpState_X12(getTrioVrState(Constant.MOVING_STATE_X12));
            ctrlSvcImplObj.bedinfo.setHeadFrameInOutState_Z11(getTrioVrState(Constant.MOVING_STATE_Z11));
        }
        ctrlSvcImplObj.bedinfo.setBedInOutState_X2(getTrioVrState(Constant.MOVING_STATE_X2));
        ctrlSvcImplObj.bedinfo.setHeadFrameLRState_X11   (getTrioVrState(Constant.MOVING_STATE_X11));
        ctrlSvcImplObj.bedinfo.setHeadFrameUDState_Y11   (getTrioVrState(Constant.MOVING_STATE_Y11));

        log.debug("New ctrlSvcImplObj.bedinfo.getHeadFrameLR_X11() is: " + ctrlSvcImplObj.bedinfo.getHeadFrameLR_X11());
    }

    public BedInfo getBedInfo() {
        return ctrlSvcImplObj.bedinfo;
    }

    public void updateLowComputerInfo() {
        ctrlSvcImplObj.lowComputerInfo.setMovingState(getTrioVrState(Constant.ADDR_MOVING_STATE));
        ctrlSvcImplObj.lowComputerInfo.setVR101   (   getTrioVrState(Constant.ADDR_AUTO_CHECK));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR102(   getTrioVrState(Constant.ADDR_IO_VR102));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR103(   getTrioVrState(Constant.ADDR_IO_VR103));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR104(   getTrioVrState(Constant.ADDR_IO_VR104));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR105(   getTrioVrState(Constant.ADDR_IO_VR105));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR106(   getTrioVrState(Constant.ADDR_IO_VR106));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR107(   getTrioVrState(Constant.ADDR_IO_VR107));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR108(   getTrioVrState(Constant.ADDR_IO_VR108));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR109(   getTrioVrState(Constant.ADDR_IO_VR109));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR120(   getTrioVrState(Constant.ADDR_IO_VR120));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR158(   getTrioVrState(Constant.ADDR_IO_VR158));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR159(   getTrioVrState(Constant.ADDR_IO_VR159));
        ctrlSvcImplObj.lowComputerInfo.setIO_VR160(   getTrioVrState(Constant.ADDR_IO_VR160));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR110(getTrioVrState(Constant.ADDR_SERVO_VR110));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR111(getTrioVrState(Constant.ADDR_SERVO_VR111));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR112(getTrioVrState(Constant.ADDR_SERVO_VR112));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR113(getTrioVrState(Constant.ADDR_SERVO_VR113));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR114(getTrioVrState(Constant.ADDR_SERVO_VR114));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR115(getTrioVrState(Constant.ADDR_SERVO_VR115));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR116(getTrioVrState(Constant.ADDR_SERVO_VR116));
        ctrlSvcImplObj.lowComputerInfo.setSERVO_VR117(getTrioVrState(Constant.ADDR_SERVO_VR117));

        LogRecorder lr = LogRecorder.getInstantce(); //wys.should move to mainWindow, can't save to DB, only display
        try {
            lr.logCheck();   //wys. to be moved to other place
        } catch (Throwable ex) {
            Logger.getLogger(ControllerSvcImpl.class.getName()).log(Level.SEVERE, null, ex);
            lr.setLogState(Constant.RESULT_NO);
            return;
        }
        lr.setLogState(Constant.RESULT_YES);
    }

    public LowComputerInfo getLowComputerInfo() {
        return ctrlSvcImplObj.lowComputerInfo;
    }

    public void updateCurePolar() {
        ctrlSvcImplObj.curePolar.setCollShieldPosState_Z2(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.curePolar.setCollimatorPosition_Z2(getTrioVrValue(Constant.ADDR_POS_Z2));
        ctrlSvcImplObj.curePolar.setCollimatorROState_Z2(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.curePolar.setSourceShieldPosState_T2(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.curePolar.setSourcePosition_T2(getTrioVrValue(Constant.ADDR_POS_T2));
        ctrlSvcImplObj.curePolar.setSourceROState_T2(getTrioVrState(Constant.ADDR_WYS_TBD));
    }

    public CurePolar getCurePolar() {
        return ctrlSvcImplObj.curePolar;
    }

    public void updateCureInfo() {
        ctrlSvcImplObj.cureinfo.setAccumulateCurePeriod(getTrioVrValue(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.cureinfo.setAccumulateRadiatePeriod(getTrioVrValue(Constant.ADDR_REF_RAD_PERIOD));
        ctrlSvcImplObj.cureinfo.setRadioTimer1(getTrioVrValue(Constant.ADDR_TIMER1));
        ctrlSvcImplObj.cureinfo.setRadioTimer2(getTrioVrValue(Constant.ADDR_TIMER2));
    }

    public CureInfo getCureInfo() {
        return ctrlSvcImplObj.cureinfo;
    }

    public void updateDeviceInfo() {
        ctrlSvcImplObj.deviceinfo.setPowerSupport(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.deviceinfo.setSimulateOrCure(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.deviceinfo.setCureRoomShieldState(getTrioVrState(Constant.ADDR_WYS_TBD));
        ctrlSvcImplObj.deviceinfo.setDeviceShieldPosition_Y2(getTrioVrValue(Constant.ADDR_POS_Y2));
        ctrlSvcImplObj.deviceinfo.setDeviceShieldState_Y2(getTrioVrState(Constant.ADDR_WYS_TBD));
    }

    public DeviceInfo getDeviceInfo() {
        return ctrlSvcImplObj.deviceinfo;
    }

    private synchronized int getTrioVrState(short addr) {
        int result = 0;
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            result = random.nextInt(2);
            return result;
        }
        try {
            double v = csr.getVR(addr);
            result = Double.valueOf(v).intValue();
        } catch (GetDataException ex) {
            log.error(null, ex);
        } catch (ConnExcetpion ex) {
            log.error(null, ex);
        }
        return result;
    }

    private synchronized double getTrioVrValue(short addr) {
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return random.nextInt(10000) / 100.0;
        }
        double result = 0.0;
        try {
            double v = csr.getVR(addr);
            System.out.println("getVr: " + v);
            result = v/100; //缩小100倍
        } catch (GetDataException ex) {
            log.error(null, ex);
        } catch (ConnExcetpion ex) {
            log.error(null, ex);
        }
        return result;
    }

    public int getAutoCheckState() {
        return ctrlSvcImplObj.lowComputerInfo.getVR101();
    }
    //VR102
    public boolean isEmergencyStop(){return (lowComputerInfo.getIO_VR102() & Constant.BIT_EMG_STOP) != 0; }
//    public boolean is()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_PLC_CLOSE_SOURCE) != 0; }
    public boolean isManualPhotoStart()               {return (lowComputerInfo.getIO_VR102() & Constant.BIT_MANUAL_PHOTO_START) != 0; }
    public boolean isCureEnabled()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_CURE_ENABLE) != 0; }
    public boolean isPhotoEnabled() {return (lowComputerInfo.getIO_VR102() & Constant.BIT_PHOTO_ENABLE) != 0; }
//    public boolean is()       {return (lowComputerInfo.getIO_VR102() & Constant.BIT_CURE_START) != 0; }
    public boolean isCureStoped()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_CURE_STOP) != 0; }
//    public boolean is()   {return (lowComputerInfo.getIO_VR102() & Constant.BIT_SAFE_LOCKS) != 0; }
    public boolean isZ2Zero()       {return (lowComputerInfo.getIO_VR102() & Constant.BIT_Z2_ZERO) != 0; }
    public boolean isZ2Shield()     {return (lowComputerInfo.getIO_VR102() & Constant.BIT_Z2_SHIELD) != 0; }
    public boolean isColli1Opend()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_COLL_1) != 0; }
    public boolean isColli2Opend()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_COLL_2) != 0; }
    public boolean isColli3Opend()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_COLL_3) != 0; }
    public boolean isColli4Opend()  {return (lowComputerInfo.getIO_VR102() & Constant.BIT_COLL_4) != 0; }
    public boolean isT2Zero()        {return (lowComputerInfo.getIO_VR102() & Constant.BIT_T2_ZERO) != 0; }
    public boolean isT2Sheild()     {return (lowComputerInfo.getIO_VR102() & Constant.BIT_T2_SHIELD) != 0; }
    //VR103
    public boolean isY2LimitUp()     {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Y2_LIMIT_UP) != 0; }
    public boolean isY2LimitDown()  {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Y2_LIMIT_DOWN) != 0; }
    public boolean isY11Zero()       {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Y11_ZERO) != 0; }
    public boolean isY11LimitUp()   {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Y11_LIMIT_UP) != 0; }
    public boolean isY11LimitDwon() {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Y11_LIMIT_DOWN) != 0; }
    public boolean isZ11Zero()       {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Z11_ZERO) != 0; }
    public boolean isZ11LimitOut()  {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Z11_LIMIT_OUT) != 0; }
    public boolean isZ11LimitIn()   {return (lowComputerInfo.getIO_VR103() & Constant.BIT_Z11_LIMIT_IN) != 0; }
    public boolean isX2LimitOut()   {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X2_LIMIT_OUT) != 0; }
    public boolean isX2LimitIn()     {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X2_LIMIT_IN) != 0; }
    public boolean isX11Zero()       {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X11_ZERO) != 0; }
    public boolean isX11LimitLeft() {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X11_LIMIT_LEFT) != 0; }
    public boolean isX11LimitRight(){return (lowComputerInfo.getIO_VR103() & Constant.BIT_X11_LIMIT_RIGHT) != 0; }
    public boolean isX12Zero()       {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X12_ZERO) != 0; }
    public boolean isX12LimitLeft() {return (lowComputerInfo.getIO_VR103() & Constant.BIT_X12_LIMIT_LEFT) != 0; }
    public boolean isX12LimitRight(){return (lowComputerInfo.getIO_VR103() & Constant.BIT_X12_LIMIT_RIGHT) != 0; }
    //VR104
    public boolean isX2Zero()        {return (lowComputerInfo.getIO_VR104() & Constant.BIT_X2_ZERO) != 0; }
    public boolean isY2Zero()        {return (lowComputerInfo.getIO_VR104() & Constant.BIT_Y2_ZERO) != 0; }
    public boolean isServoError()    {return (lowComputerInfo.getIO_VR104() & Constant.BIT_SERVO_ERROR) != 0; }
    //VR105
    public boolean isTrioError()    {return (lowComputerInfo.getIO_VR105() & Constant.BIT_TRIO_ERROR) != 0; }
    //VR106
    public boolean isOverallError()    {return (lowComputerInfo.getIO_VR106() & Constant.BIT_OVERALL_ERR) != 0; }
    //VR108
    public boolean isServo1Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_1) != 0; }
    public boolean isServo2Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_2) != 0; }
    public boolean isServo3Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_3) != 0; }
    public boolean isServo4Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_4) != 0; }
    public boolean isServo5Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_5) != 0; }
    public boolean isServo6Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_6) != 0; }
    public boolean isServo7Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_7) != 0; }
    public boolean isServo8Err()       {return (lowComputerInfo.getIO_VR108() & Constant.BIT_ERR_8) != 0; }
    public boolean isFQ1()          {return (lowComputerInfo.getIO_VR108() & Constant.BIT_FQ_1) != 0; }
    public boolean isFQ2()          {return (lowComputerInfo.getIO_VR108() & Constant.BIT_FQ_2) != 0; }
    public boolean isFQ3()          {return (lowComputerInfo.getIO_VR108() & Constant.BIT_FQ_3) != 0; }
    public boolean isFQ4()          {return (lowComputerInfo.getIO_VR108() & Constant.BIT_FQ_4) != 0; }
     //VR109
    public boolean isRoomGateOpen()       {return (lowComputerInfo.getIO_VR109() & Constant.BIT_ROOM_GAGE_OPEN) != 0; }
    public boolean isFQ5()       {return (lowComputerInfo.getIO_VR109() & Constant.BIT_FQ_5) != 0; }
    public boolean isFQ6()       {return (lowComputerInfo.getIO_VR109() & Constant.BIT_FQ_6) != 0; }
    public boolean isFQ7()       {return (lowComputerInfo.getIO_VR109() & Constant.BIT_FQ_7) != 0; }
    public boolean isFQ8()       {return (lowComputerInfo.getIO_VR109() & Constant.BIT_FQ_8) != 0; }

    public boolean hasSomeWarn() {
        boolean result  = false;
        if((lowComputerInfo.getIO_VR102() & Constant.BIT_EMG_STOP) != 0) {
            result = true;
        }
        else if((lowComputerInfo.getIO_VR103() & 0x0dbdb) != 0) {
            result = true;
        }
        return result;
    }

    public boolean hasSomeError() {
        boolean result  = false;
        if((lowComputerInfo.getIO_VR104() & Constant.BIT_SERVO_ERROR) != 0) {
            result = true;
        }
        else if((lowComputerInfo.getIO_VR105() & Constant.BIT_TRIO_ERROR) != 0) {
            result = true;
        }
        else if((lowComputerInfo.getIO_VR108() & 0x0fff) != 0) {
            result = true;
        }
        else if((lowComputerInfo.getIO_VR109() & 0x0f00) != 0) {
            result = true;
        }
       return result;
    }

    public static void main(String[] args) throws InterruptedException {
        ControllerSvcImpl c = new ControllerSvcImpl();
        for (int i = 0; i < 6; i++) {
            Thread.sleep(3000);
            System.out.println(c.getTrioVrValue(Constant.ADDR_POS_X2));

        }
    }

//=============================================================
    public synchronized void sendCommand(int cmd) {
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }
        switch (cmd) {
            case Constant.MANUL_AXILES_STOP: { //Stop moving
                try {
                    csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, 0); //wys.Stop the button-moving
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.CURE_AUTO_SUSPEND: {
                try {
                    csr.setVR(Constant.ADDR_CURE_AUTO_ACTION, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_T2Z2_ROTATE: {
                try {
                    csr.setVR(Constant.ADDR_T2Z2_ASYN_SYN, 0); //Synchronic rotate
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.VALUE_WYS_TBD);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_T2_ROTATE: {
                try {
                    csr.setVR(Constant.ADDR_T2Z2_ASYN_SYN, 1); //only T2 rotate
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_T2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_T2_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_T2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_Z2_ROTATE: {
                try {
                    csr.setVR(Constant.ADDR_T2Z2_ASYN_SYN, 1); //only Z2 rotate
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_Z2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Z2_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_Z2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_X11_LEFT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_X11);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X11_RIGHT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_X11);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X11_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_X11);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_Y11_UP: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_Y11);
                    System.out.println("csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_Y11);");
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y11_DOWN: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_Y11);
                    System.out.println("csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_Y11);");
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y11_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_Y11);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_Z11_IN: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_Z11);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Z11_OUT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_Z11);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Z11_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_Z11);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_X12_LEFT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_X12);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X12_RIGHT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_X12);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X12_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_X12);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_X2_IN: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_X2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X2_OUT: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_X2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X2_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_X2);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.MANUL_Y2_UP: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_POSITIVE_Y2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y2_DOWN: {
                try {
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.BIT_AXILE_NEGATIVE_Y2);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y2_ZERO: {
                try {
                    csr.setVR(Constant.ADDR_BACK2_ZERO, Constant.BIT_AXILE_POSITIVE_Y2);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.REFERENCE_DEVICE_BACK: {
                try {
                    csr.setVR(Constant.ADDR_WYS_TBD, 2);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }

            case Constant.CURE_AUTO_CHECK: {
                try {
                    csr.setVR(Constant.ADDR_AUTO_CHECK, 22);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
        }
    }

    public synchronized void sendCommand(int cmd, double value) {
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }
        value *= 100; //括大100倍
        switch (cmd) {
            case Constant.MANUL_X11_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_X11);
                    csr.setVR(Constant.ADDR_MANUL_POINT_X11, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y11_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_Y11);
                    csr.setVR(Constant.ADDR_MANUL_POINT_Y11, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Z11_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_Z11);
                    csr.setVR(Constant.ADDR_MANUL_POINT_Z11, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X12_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_X12);
                    csr.setVR(Constant.ADDR_MANUL_POINT_X12, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_X2_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_X2);
                    csr.setVR(Constant.ADDR_MANUL_POINT_X2, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Y2_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_Y2);
                    csr.setVR(Constant.ADDR_MANUL_POINT_Y2, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_Z2_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_Z2);
                    csr.setVR(Constant.ADDR_MANUL_POINT_Z2, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_T2_POINT: {
                try {
                    csr.setVR(Constant.ADDR_TO_POINT, Constant.BIT_AXILE_POSITIVE_T2);
                    csr.setVR(Constant.ADDR_MANUL_POINT_T2, value);
                    //csr.setVR(Constant.ADDR_ADJUST_STOP, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.PARA_CHANGE_SOURCE_POS1: {//Change source compensate, that's 1# position.
                try {
                    csr.setVR(Constant.ADDR_CHANGE_SOURCE_POS1, value);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
            case Constant.MANUL_CHANGE_UNIT_k: { //next source point
                try {
                    csr.setVR(Constant.ADDR_CHANGE_SOURCE_IDX , value);
                    csr.setVR(Constant.ADDR_CHANGE_SOURCE_CMD, 1);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
                break;
            }
        }
    }

    public synchronized void sendCommand(int cmd, double value, int value2) {
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }

        value *= 100; //括大100倍
        switch (cmd) {
            case Constant.MANUL_T2Z2_ROTATE: {
                try {
                    //value: 开源时间
                    //value2: collimaterNo.
                    csr.setVR(Constant.ADDR_T2Z2_ASYN_SYN, 0); //Synchronic rotate
                    csr.setVR(Constant.ADDR_BUTTON_MOVE, Constant.VALUE_WYS_TBD);
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }

                break;
            }
            case Constant.REFERENCE_RADIATE_START: {
                try {
                    //value: 辐照时间
                    //value2: collimaterNo.
                    csr.setVR(Constant.ADDR_REF_RAD_PERIOD, value);
                    csr.setVR(Constant.ADDR_REF_START, 1);
                    break;
                } catch (SetDataException ex) {
                    log.error(null, ex);
                } catch (ConnExcetpion ex) {
                    log.error(null, ex);
                }
            }
            case Constant.MANUL_SCREW_NEXT: { //next screw point
//                try {
//                } catch (SetDataException ex) {
//                    log.error(null, ex);
//                } catch (ConnExcetpion ex) {
//                    log.error(null, ex);
//                }
                break;
            }
        }
    }

    public synchronized void sendAutoCureData(CatTreatmentPlanFocus selectedFocus) {
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }
        try {
            csr.setVR(Constant.ADDR_FOCUS_POS_X11, selectedFocus.getPlanX());
            csr.setVR(Constant.ADDR_FOCUS_POS_Y11, selectedFocus.getPlanY());
            csr.setVR(Constant.ADDR_FOCUS_POS_X2, selectedFocus.getPlanZ());
            csr.setVR(Constant.ADDR_COLL_NUMBER, selectedFocus.getCollType());
            csr.setVR(Constant.ADDR_RADIO_PERIOD, selectedFocus.getCurePeriod());
            csr.setVR(Constant.ADDR_RADIO_COMPENSATE, 1); //wys?.TBD 在这里传吗?
            csr.setVR(Constant.ADDR_CURE_COLL_POS, 30);   //wys?.TBD 在这里传吗?
            csr.setVR(Constant.ADDR_CURE_START_END, 1);
        } catch (SetDataException ex) {
            log.error(null, ex);
        } catch (ConnExcetpion ex) {
            log.error(null, ex);
        }
    }

    public void sendLeadScrewParam(int cmd, double[] array, int length) {
        switch (cmd) {
            case Constant.PARA_COMPENSATE_X2: {
                sendTableData(Constant.TABLE_COMPENSATE_X2, array, length);
                break;
            }
            case Constant.PARA_COMPENSATE_X2i: {
                sendTableData(Constant.TABLE_COMPENSATE_X2i, array, length);
                break;
            }
            case Constant.PARA_COMPENSATE_X11: {
                sendTableData(Constant.TABLE_COMPENSATE_X11, array, length);
                break;
            }
            case Constant.PARA_COMPENSATE_X11i: {
                sendTableData(Constant.TABLE_COMPENSATE_X11i, array, length);
                break;
            }
            case Constant.PARA_COMPENSATE_Y11: {
                sendTableData(Constant.TABLE_COMPENSATE_Y11, array, length);
                break;
            }
            case Constant.PARA_COMPENSATE_Y11i: {
                sendTableData(Constant.TABLE_COMPENSATE_Y11i, array, length);
                break;
            }
        }
    }

    public synchronized void sendBedParam(int cmd, String parameterName, double value) {
        System.out.println("CommandId = " + cmd + ", paraName is:" + parameterName + "; value is " + value);
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }
        switch (cmd) {
            case Constant.PARA_UP_BED_POS: {
                if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_UP_BED_POS_Y11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_UP_BED_POS_Z11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_UP_BED_POS_X2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_UP_BED_POS_Y2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_DOWN_BED_POS: {
                if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_CHANGE_FOCUS_POS: {
                if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_REF_POINT_POS: {
                if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_REF_POINT_Y11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_REF_POINT_Z11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_REF_POINT_X2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_REF_POINT_ADJ: {
                if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_RADIO_COMPENSATE: {
                if (parameterName.equals("1#")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("2#")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("3#")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("4#")) {
                    try {
                        csr.setVR(Constant.ADDR_WYS_TBD, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_ZERO_BIAS: {
                if (parameterName.equals("X11")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_X11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_Y11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_Z11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X12")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_X12, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_X2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_Y2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z2")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_Z2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("T2")) {
                    try {
                        csr.setVR(Constant.ADDR_ZERO_BIAS_T2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_MANUL_SPEED: {
                if (parameterName.equals("X11")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_X11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_Y11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_Z11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X12")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_X12, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_X2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_Y2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z2")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_Z2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("T2")) {
                    try {
                        csr.setVR(Constant.ADDR_MANUL_SPEED_T2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

            case Constant.PARA_AUTO_SPEED: {
                if (parameterName.equals("X11")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_X11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y11")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_Y11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z11")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_Z11, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X12")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_X12, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("X2")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_X2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Y2")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_Y2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("Z2")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_Z2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                } else if (parameterName.equals("T2")) {
                    try {
                        csr.setVR(Constant.ADDR_AUTO_SPEED_T2, value);
                    } catch (SetDataException ex) {
                        log.error(null, ex);
                    } catch (ConnExcetpion ex) {
                        log.error(null, ex);
                    }
                }
                break;
            }

        }
    }

    private synchronized void sendTableData(short addr, double[] array, int length) {
        System.out.println();
        System.out.println("TableAddr = " + addr + "; length = " + length);
        for (int i = 0; i < length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
        if (DEBUG_Linked_Trio == 0) { //Without Trio Controller
            return;
        }

        try {
            csr.setTable(addr, length, array);
        } catch (SetDataException ex) {
            log.error(null, ex);
        } catch (ConnExcetpion ex) {
            log.error(null, ex);
        }
    }

    private double[] getTableData(short startPosition, short numberOfValues) {
        try {
            return csr.getTable(startPosition, numberOfValues);
        } catch (GetDataException ex) {
            log.error(null, ex);
            return null;
        }
    }
}
