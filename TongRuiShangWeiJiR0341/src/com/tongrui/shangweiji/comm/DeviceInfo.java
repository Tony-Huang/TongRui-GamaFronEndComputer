/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

/**
 *
 * @author Administrator
 */
public class DeviceInfo implements java.io.Serializable {

    //电源供给
    private int powerSupportBy;
    //治疗或模拟状态
    private int simulateOrCure;
    //治疗室屏蔽门状态
    private int cureRoomShieldState;
    //设备屏蔽门位置
    private double deviceShieldPosition_Y2;
    //设备屏蔽门状态
    private double deviceShieldState_Y2;

    public int getCureRoomShieldState() {
        return cureRoomShieldState;
    }

    public void setCureRoomShieldState(int cureRoomShieldState) {
        this.cureRoomShieldState = cureRoomShieldState;
    }

    public int getPowerSupport() {
        return getPowerSupportBy();
    }

    public void setPowerSupport(int powerSupport) {
        this.setPowerSupportBy(powerSupport);
    }

    public int getSimulateOrCure() {
        return simulateOrCure;
    }

    public void setSimulateOrCure(int simulateOrCure) {
        this.simulateOrCure = simulateOrCure;
    }

    /**
     * @return the powerSupportBy
     */
    public int getPowerSupportBy() {
        return powerSupportBy;
    }

    /**
     * @param powerSupportBy the powerSupportBy to set
     */
    public void setPowerSupportBy(int powerSupportBy) {
        this.powerSupportBy = powerSupportBy;
    }

    /**
     * @return the deviceShieldPosition_Y2
     */
    public double getDeviceShieldPosition_Y2() {
        return deviceShieldPosition_Y2;
    }

    /**
     * @param deviceShieldPosition_Y2 the deviceShieldPosition_Y2 to set
     */
    public void setDeviceShieldPosition_Y2(double deviceShieldPosition) {
        this.deviceShieldPosition_Y2 = deviceShieldPosition;
    }

    /**
     * @return the deviceShieldState_Y2
     */
    public double getDeviceShieldState_Y2() {
        return deviceShieldState_Y2;
    }

    /**
     * @param deviceShieldState_Y2 the deviceShieldState_Y2 to set
     */
    public void setDeviceShieldState_Y2(double deviceShieldState) {
        this.deviceShieldState_Y2 = deviceShieldState;
    }
}
