/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.DispatchEvents;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;

/**
 *
 * @author Administrator
 */
public class CommActiveX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ComThread.InitSTA();

        ActiveXComponent trio_pc = new ActiveXComponent("TRIOPC.TrioPCCtrl.1");
        Variant success;
        try {
            // make sure we are here....
            //Dispatch.call(trio_pc, "AboutBox");
            Variant str = Dispatch.call(trio_pc, "ProductVersion");
            System.out.println("ProductVersion is " + str);
            str = Dispatch.call(trio_pc, "ProductName");
            System.out.println("ProductName is " + str);

            // connect to the controller
            Dispatch.put(trio_pc, "HostAddress", "192.168.0.250");
            success = Dispatch.call(trio_pc, "IsOpen", 0);
            System.out.println("IsOpen returns " + success.getInt());
            success = Dispatch.call(trio_pc, "Open", 2, 0);
            System.out.println("Open returns " + success);
            if (success.getBoolean()) {
                success = Dispatch.call(trio_pc, "IsOpen", 0);
                System.out.println("IsOpen returns " + success.getInt());
                System.out.println("Connected to " + Dispatch.get(trio_pc, "HostAddress"));

                // set vr
                double d = Math.PI;
                short addr = 100;
                //success = Dispatch.call(trio_pc, "SetVR", addr, d);
                //System.out.println("SetVR is " + success);

                // get vr
                Variant v = new Variant(0.0, true);
                success = Dispatch.call(trio_pc, "GetVR", addr, v);
                System.out.println("GetVR is " + success);

                System.out.println("Sent=" + d + " Received=" + v.getDoubleRef());
                if (Math.abs(d - v.getDoubleRef()) < 0.0001)
                    System.out.println("VR value correct");
                else
                    System.out.println("VR value error");

                // set table ==============================
                addr = 100;
                double da[] = {1.0,2.0,3.0,4.0,5.0};
                success = Dispatch.call(trio_pc, "SetTable", addr, 5, da);
                System.out.println("SetTable is " + success);

                // read table array
                SafeArray sa = new SafeArray(Variant.VariantDouble, 5);
                v = new Variant(sa, true);
                success = Dispatch.call(trio_pc, "GetTable", addr, 5, v);
                System.out.println("GetTable is " + success);

                // compare.
                // These are integer values so we can compare directly
                System.out.println("Table is:");
                Boolean b = true;
                for (int i = 0; i < 5; i++) {
                    System.out.println("    " + (addr + i) + " [Sent=" + da[i] + " Received=" + sa.getDouble(i) + "]");
                    b &= (da[i] == sa.getDouble(i));
                }
                if (b)
                    System.out.println("TABLE values correct");
                else
                    System.out.println("At least one TABLE value error");

                // close the controller connection
                Dispatch.call(trio_pc, "Close");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ComThread.Release();
        }
    }
}

/*
run：
ProductVersion is 2,10,1,1359
ProductName is TrioPC ActiveX Control Module
Open returns true
Connected to 192.168.0.250
SetVR is true
GetVR is true
Sent=3.1416 Received=3.1416
VR value correct
SetTable is true
GetTable is true
Table is:
    100 [Sent=1.0 Received=1.0]
    101 [Sent=2.0 Received=2.0]
    102 [Sent=3.0 Received=3.0]
    103 [Sent=4.0 Received=4.0]
    104 [Sent=5.0 Received=5.0]
TABLE values correct
 */