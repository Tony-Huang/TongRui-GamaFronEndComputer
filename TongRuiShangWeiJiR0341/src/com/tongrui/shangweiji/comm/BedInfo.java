/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

/**
 *
 * @author Administrator
 */
public class BedInfo implements java.io.Serializable{
    
    //床位变形量
    private double bedDifference;
    
    //头架左右
    private double headFrameLR_X11;
    //头架左右状态
    private int headFrameLRState_X11;
    
    //头架上下
    private double headFrameUD_Y11;
    //头架上下状态
    private int headFrameUDState_Y11;
           
    //头架进出
    private double headFrameInOut_Z11;
    //头架进出状态
    private int headFrameInOutState_Z11;
    
    //床位进出
    private double bedInOut_X2;
    //床位进出状态
    private int bedInOutState_X2;
    
    //床位随动
    private double bedFollowUp_X12;
    //床位随动状态
    private int bedFollowUpState_X12;

    public double getBedDifference() {
        return bedDifference;
    }

    public void setBedDifference(double bedDifference) {
        this.bedDifference = bedDifference;
    }

    public double getBedFollowUp_X12() {
        return bedFollowUp_X12;
    }

    public void setBedFollowUp_X12(double bedFollowUp) {
        this.bedFollowUp_X12 = bedFollowUp;
    }

    public int getBedFollowUpState_X12() {
        return bedFollowUpState_X12;
    }

    public void setBedFollowUpState_X12(int bedFollowUpState) {
        this.bedFollowUpState_X12 = bedFollowUpState;
    }

    public double getBedInOut_X2() {
        return bedInOut_X2;
    }

    public void setBedInOut_X2(double bedInOut) {
        this.bedInOut_X2 = bedInOut;
    }

    public int getBedInOutState_X2() {
        return bedInOutState_X2;
    }

    public void setBedInOutState_X2(int bedInOutState) {
        this.bedInOutState_X2 = bedInOutState;
    }

    public double getHeadFrameInOut_Z11() {
        return headFrameInOut_Z11;
    }

    public void setHeadFrameInOut_Z11(double headFrameInOut) {
        this.headFrameInOut_Z11 = headFrameInOut;
    }

    public int getHeadFrameInOutState_Z11() {
        return headFrameInOutState_Z11;
    }

    public void setHeadFrameInOutState_Z11(int headFrameInOutState) {
        this.headFrameInOutState_Z11 = headFrameInOutState;
    }

    public double getHeadFrameLR_X11() {
        return headFrameLR_X11;
    }

    public void setHeadFrameLR_X11(double headFrameLR) {
        this.headFrameLR_X11 = headFrameLR;
    }

    public int getHeadFrameLRState_X11() {
        return headFrameLRState_X11;
    }

    public void setHeadFrameLRState_X11(int headFrameLRState) {
        this.headFrameLRState_X11 = headFrameLRState;
    }

    public double getHeadFrameUD_Y11() {
        return headFrameUD_Y11;
    }

    public void setHeadFrameUD_Y11(double headFrameUD) {
        this.headFrameUD_Y11 = headFrameUD;
    }

    public int getHeadFrameUDState_Y11() {
        return headFrameUDState_Y11;
    }

    public void setHeadFrameUDState_Y11(int headFrameUDState) {
        this.headFrameUDState_Y11 = headFrameUDState;
    }
    
}
