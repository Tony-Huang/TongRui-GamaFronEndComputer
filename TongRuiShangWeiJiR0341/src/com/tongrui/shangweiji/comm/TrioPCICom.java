/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;
import java.text.DecimalFormat;

/**
 *
 * @author Administrator
 */
public class TrioPCICom {

    ActiveXComponent trio_pc = null;

    public TrioPCICom() {
      //  trioPCIComThreadInIt();
     //   trio_pc = new ActiveXComponent(Constant.APP_NAME);
    }
    
    public static void trioPCIComThreadInIt(){
        ComThread.InitSTA();
    }
    
    public static void trioPCIComThreadRelease(){
        ComThread.Release();
    }
    
    public boolean conn() throws ConnExcetpion {
        if (!isConn()) {
            Dispatch.put(trio_pc, Constant.APP_HOSTADDR, Constant.SERVER_ADDS);
            Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_OPEN, Constant.APP_PORTPYTE, Constant.APP_PORTMODE);
            System.out.println("Open returns " + result);
            if (result.getBoolean()) {
                return true;
            } else {
                throw new ConnExcetpion();
            }
        } else {
            return true;
        }
    }

    public double getVR(short addr) throws GetDataException, ConnExcetpion {
        conn();
        Variant v = new Variant(0.0, true);
        getTrioVR(addr, v);
        DecimalFormat df = new DecimalFormat("0.00");
        
        return  Double.valueOf(df.format(v.getDoubleRef()));

    }

    public boolean setVR(short addr, double v) throws SetDataException, ConnExcetpion {
        conn();
        Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_SETVR, addr, v);
        if (result.getBoolean()) {
            return true;
        } else {
            throw new SetDataException();
        }
    }

    public double[] getTable(short addr, int size) throws GetDataException {
        SafeArray sa = new SafeArray(Variant.VariantDouble, size);
        Variant v = new Variant(sa, true);
        Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_GETTABLE, addr, size, v);
        if (result.getBoolean()) {
            Boolean b = true;
            double vs[] = new double[size];
            for (int i = 0; i < size; i++) {
                vs[i] = sa.getDouble(i);
            }
            return vs;
        } else {
            throw new GetDataException();
        }


    }

    public boolean setTable(short addr, int size, double[] vs) throws SetDataException, ConnExcetpion {
        conn();
        //short addr = 100;
        //double da[] = {1.0,2.0,3.0,4.0,5.0};
        Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_SETTABLE, addr, size, vs);
        if (result.getBoolean()) {
            return true;
        } else {
            throw new SetDataException();
        }
    }

    private void getTrioVR(short addr, Variant v) throws GetDataException {
        Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_GETVR, addr, v);
        if (result.getBoolean()) {
            ;
        } else {
            throw new GetDataException();
        }
    }

    private boolean isConn() {
        Variant result = Dispatch.call(trio_pc, Constant.APP_METHOD_ISOPEN, Constant.APP_PORTMODE);
        if (result.getInt()>0) {
            return true;
        } else {
            return false;
        }
    }
}
