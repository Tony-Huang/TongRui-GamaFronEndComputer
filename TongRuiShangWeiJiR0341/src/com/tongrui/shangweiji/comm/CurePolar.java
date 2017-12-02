/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

/**
 *
 * @author Administrator
 */
public class CurePolar implements java.io.Serializable{
    //射源体位置
    private double sourcePosition_T2;
    //准直体位置
    private double collimatorPosition_Z2;
    //射源体旋转状态
    private int sourceROState_T2;
    //准直体旋转状态
    private int collimatorROState_Z2;
    //射源体屏蔽位状态
    private int sourceShieldPosState_t2; //Shield state
    //准直体屏蔽位状态
    private int collShieldPosState_z2; //Shield state

    public double getCollimatorPosition_Z2() {
        return collimatorPosition_Z2;
    }

    public void setCollimatorPosition_Z2(double collimatorPosition) {
        this.collimatorPosition_Z2 = collimatorPosition;
    }

    public int getCollimatorROState_Z2() {
        return collimatorROState_Z2;
    }

    public void setCollimatorROState_Z2(int collimatorROState) {
        this.collimatorROState_Z2 = collimatorROState;
    }

    public int getCollShieldPosState_Z2() {
        return collShieldPosState_z2;
    }

    public void setCollShieldPosState_Z2(int collShieldPositionState) {
        this.collShieldPosState_z2 = collShieldPositionState;
    }

    public double getSourcePosition_T2() {
        return sourcePosition_T2;
    }

    public void setSourcePosition_T2(double sourcePosition) {
        this.sourcePosition_T2 = sourcePosition;
    }

    public int getSourceROState_T2() {
        return sourceROState_T2;
    }

    public void setSourceROState_T2(int sourceROState) {
        this.sourceROState_T2 = sourceROState;
    }

    public int getSourceShieldPosState_T2() {
        return sourceShieldPosState_t2;
    }

    public void setSourceShieldPosState_T2(int sourceShieldPosState) {
        this.sourceShieldPosState_t2 = sourceShieldPosState;
    }

  
}
