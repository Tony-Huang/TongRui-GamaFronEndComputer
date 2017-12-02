/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

/**
 *
 * @author Administrator
 */
public class CureInfo implements java.io.Serializable{
    //累计治疗时间
    private double AccumulateCurePeriod;
    //累计辐照时间
    private double  AccumulateRadiatePeriod;
    //定时器
    private double radioTimer1;
    private double radioTimer2;

    public double getAccumulateCurePeriod() {
        return AccumulateCurePeriod;
    }

    public void setAccumulateCurePeriod(double AccumulateCurePeriod) {
        this.AccumulateCurePeriod = AccumulateCurePeriod;
    }

    public double getAccumulateRadiatePeriod() {
        return AccumulateRadiatePeriod;
    }

    public void setAccumulateRadiatePeriod(double AccumulateRadiatePeriod) {
        this.AccumulateRadiatePeriod = AccumulateRadiatePeriod;
    }

    public double getRadioTimer2() {
        return radioTimer2;
    }

    public void setRadioTimer2(double timer) {
        this.radioTimer2 = timer;
    }

    public double getRadioTimer1() {
        return radioTimer1;
    }

    public void setRadioTimer1(double timer) {
        this.radioTimer1 = timer;
    }

}
