/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import com.tongrui.shangweiji.data.CatTreatmentPlanFocus;

/**
 *
 * @author Administrator
 */
public interface ControllerService {
    public double getVR(short vr);
    public boolean setVR(short vr,double value);
    public double getSlotVariable(String name,short number);
    public boolean setSlotVariable(String name,short number,double value);
    
    public double getTable(short startPosition, short numberOfValues);
    public boolean setTable(short startPosition, short numberOfValues, double value);
    
    //床位信息
    public void updateBedInfo();
    //治疗头状态
    public void updateCurePolar();
    //治疗信息
    public void updateCureInfo();
    //治疗信息
    public void updateDeviceInfo();
    //下位机信息
    public void updateLowComputerInfo();
    //床位信息
    public BedInfo getBedInfo();
    //治疗头状态
    public CurePolar getCurePolar();
    //治疗信息
    public CureInfo getCureInfo();
    //治疗信息
    public DeviceInfo getDeviceInfo();
    //下位机信息
    public LowComputerInfo getLowComputerInfo();
    
    public void sendCommand(int cmd);
    public void sendCommand(int cmd, double value);
    public void sendCommand(int cmd, double value, int value2);

    public void sendArrayData(int cmd, double[] array, int length);
    public double[] getArrayData(int cmd, int length);
    
    public void sendData(int cmd, String parameterName, double value);

    public void sendAutoCureData(CatTreatmentPlanFocus selectedFocus);
    
    //VR102
    public boolean isEmergencyStop();
//    public boolean is();
    public boolean isManualPhotoStart();
    public boolean isCureEnabled();
    public boolean isPhotoEnabled();
//    public boolean is();
    public boolean isCureStoped();
//    public boolean is();
    public boolean isZ2Zero();
    public boolean isZ2Shield();
    public boolean isColli1Opend();
    public boolean isColli2Opend();
    public boolean isColli3Opend();
    public boolean isColli4Opend();
    public boolean isT2Zero();
    public boolean isT2Sheild();
    
    //VR103
    public boolean isY2LimitUp();
    public boolean isY2LimitDown();
    public boolean isY11Zero();
    public boolean isY11LimitUp();
    public boolean isY11LimitDwon();
    public boolean isZ11Zero();
    public boolean isZ11LimitOut();
    public boolean isZ11LimitIn();
    public boolean isX2LimitOut();
    public boolean isX2LimitIn();
    public boolean isX11Zero();
    public boolean isX11LimitLeft();
    public boolean isX11LimitRight();
    public boolean isX12Zero();
    public boolean isX12LimitLeft();
    public boolean isX12LimitRight();
    
    //VR104
    public boolean isX2Zero();
    public boolean isY2Zero();
    public boolean isServoError();
    //VR108
//    public boolean isAlarm1();
//    public boolean isAlarm2();
//    public boolean isAlarm3();
//    public boolean isAlarm4();
//    public boolean isAlarm5();
//    public boolean isAlarm6();
//    public boolean isAlarm7();
//    public boolean isAlarm8();
    public boolean isFQ1();
    public boolean isFQ2();
    public boolean isFQ3();
    public boolean isFQ4();
     //VR108
    public boolean isRoomGateOpen();
    public boolean isFQ5();
    public boolean isFQ6();
    public boolean isFQ7();
    public boolean isFQ8();
    
    //wys.to be finish
    public int isAcceptIGRT();

}
