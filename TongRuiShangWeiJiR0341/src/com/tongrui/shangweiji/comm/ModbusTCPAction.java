/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import com.tongrui.shangweiji.comm.*;
import java.io.FilterInputStream;
import java.io.OutputStream;

/**
 *
 * @author Administrator
 */

class ModbusTCPAction {

    final int BUFFER_LENGTH = 254 + 13 + 11; //254 is max data length in byte; 13 is offset of writing; 11 is reserved
    final int VR_OPERATION = 1;              //VR[0]的值指明当前是对VR还是TABLE操作.
    final int TABLE_OPERATION = 2;           //VR[0]的值指明当前是对VR还是TABLE操作.
    public final int COMMAND01 = 0x0001;
    public final int COMMAND02 = 0x0002;
    public final int COMMAND03 = 0x0004;
    public final int COMMAND04 = 0x0008;
    public final int COMMAND05 = 0x0010;
    public final int COMMAND06 = 0x0020;
    public final int COMMAND07 = 0x0040;
    public final int COMMAND08 = 0x0080;
    public final int COMMAND09 = 0x0100;
    public final int COMMAND10 = 0x0200;
    public final int COMMAND11 = 0x0400;
    public final int COMMAND12 = 0x0800;
    public final int COMMAND13 = 0x1000;
    public final int COMMAND14 = 0x2000;
    public final int COMMAND15 = 0x4000;
    public final int COMMAND16 = 0x8000;
    
    public static short VR[] = new short[300];
    public static short TABLE[] = new short[300];
    
    private byte obuf[] = new byte[BUFFER_LENGTH];
    private byte ibuf[] = new byte[BUFFER_LENGTH];
    private short currentCMD = 0;
    
    
    private OutputStream os =null;
    private FilterInputStream in =null;
    
    public ModbusTCPAction(OutputStream os_ ,FilterInputStream in_) {
        this.os=os_;
        this.in = in_;
    }

    public void setCurrentCMD(short currentCMD) {
        this.currentCMD = currentCMD;
    }
    
    public void setOs(OutputStream os_){
        os = os_;
    }
    public void setIn(FilterInputStream in_){
        in=in_;
    }
    
    public static void main(String argv[]) {
            ModbusTCPAction comm = new ModbusTCPAction(null,null);
            while (true) {
                comm.commandCheck();   //上层也可直接调用public sendCommand()发送命令
                comm.readFromController(100,100,100);
                comm.readFromController(200,100,100);
                comm.readFromController(300,100,100);
            }
    }

    public void refreashVR00() {
        //Notice: the words_number <= 127
        try {
            int length = readPackage(0, 1);
            // send request
            os.write(obuf, 0, length);      //totall are 12 bytes
            // read response
            int bytes_read = in.read(ibuf, 0, BUFFER_LENGTH);  //wys?.need waiting for complete reading?

            parseVR0Response(bytes_read, 0, 1);
        } catch (Exception e) {
            System.out.println("exception :" + e);
        }
    }
    
    private void commandCheck() {
        if (0 != (currentCMD & (short) COMMAND01)) {
            sendCommand(100, 100); //wys.TBD
            currentCMD &= (short) (~COMMAND01);
        }
        if (0 != (currentCMD & (short) COMMAND02)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND02);
        }
        if (0 != (currentCMD & (short) COMMAND03)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND03);
        }
        if (0 != (currentCMD & (short) COMMAND04)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND04);
        }
        if (0 != (currentCMD & (short) COMMAND05)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND05);
        }
        if (0 != (currentCMD & (short) COMMAND06)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND06);
        }
        if (0 != (currentCMD & (short) COMMAND07)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND07);
        }
        if (0 != (currentCMD & (short) COMMAND08)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND08);
        }
        if (0 != (currentCMD & (short) COMMAND09)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND09);
        }
        if (0 != (currentCMD & (short) COMMAND10)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND10);
        }
        if (0 != (currentCMD & (short) COMMAND11)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND11);
        }
        if (0 != (currentCMD & (short) COMMAND12)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND12);
        }
        if (0 != (currentCMD & (short) COMMAND13)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND13);
        }
        if (0 != (currentCMD & (short) COMMAND14)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND14);
        }
        if (0 != (currentCMD & (short) COMMAND15)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND15);
        }
        if (0 != (currentCMD & (short) COMMAND16)) {
            //add sendCommand() here
            currentCMD &= (short) (~COMMAND16);
        }
    }

    //Read data from controller to VR[] or Table[]
    private void readFromController(int source_address, int target_address, int words_number) {
        //Notice: the words_number <= 127
        try {
            //OutputStream os = es.getOutputStream();
            //FilterInputStream is = new BufferedInputStream(es.getInputStream());

            int length = readPackage(source_address, words_number);
            // send request
            os.write(obuf, 0, length);      //totall are 12 bytes
            // read response
            int bytes_read = in.read(ibuf, 0, BUFFER_LENGTH);  //wys?.need waiting for complete reading?

            parseReadResponse(bytes_read, target_address, words_number);
        } catch (Exception e) {
            System.out.println("exception :" + e);
        }
    }
    
    //上层也可直接调用此函数而发送命令
    public void sendCommand(int source_address, int target_address) {
        writeToController(source_address, target_address, 1);
    }
    
    //Write data to controller from VR[] or Table[]
    private void writeToController(int source_address, int target_address, int words_number) {
        //Notice: the words_number <= 127
        try {
            //OutputStream os = es.getOutputStream();
            //FilterInputStream is = new BufferedInputStream(es.getInputStream());

            int length = writePackage(source_address, target_address, words_number);

            // send request
            os.write(obuf, 0, length); //13 is number of byte from obuf[0] to obuf[12]
            // read response
            int bytes_read = in.read(ibuf, 0, BUFFER_LENGTH);

            parseWriteResponse(bytes_read);
        } catch (Exception e) {
            System.out.println("exception :" + e);
        }
    }

    private int writePackage(int source_address, int target_address, int words_number) {
        int i;
        for (i = 0; i < 4; i++) {
            obuf[i] = 0;                 //Header
        }
        obuf[4] = (byte) ((7 + 2*words_number) >> 8);     //High:Following bytes number
        obuf[5] = (byte) ((7 + 2*words_number) & 0xff);   //Low: Following bytes number, 7 is number of byte from obuf[6] to obuf[12]
        obuf[6] = -1;                    //Trio209 defautl unit address
        obuf[7] = 0x10;                  //FunctionCode, write multiple registers
        obuf[8] = (byte) (target_address >> 8);   //address: High
        obuf[9] = (byte) (target_address & 0xff); //address: Low
        obuf[10] = 0;                    //High of register number
        obuf[11] = (byte) words_number;  //Low  of register number, <= 127 for the Trio controller
        obuf[12] = (byte) (2*words_number); //number of data bytes below, <= 254 for the Trio controller

        if (VR[0] == VR_OPERATION) {
            for (i = 0; i < words_number; i++) {
                obuf[i + 13] = (byte) (VR[source_address + i] >> 8);   //High, 8bits
                obuf[i + 14] = (byte) (VR[source_address + i] & 0xff); //Low, 8bits
            }
        } else if (VR[0] == TABLE_OPERATION) {
            for (i = 0; i < words_number; i++) {
                obuf[i + 13] = (byte) (TABLE[source_address + i] >> 8);   //High, 8bits
                obuf[i + 14] = (byte) (TABLE[source_address + i] & 0xff); //Low, 8bits
            }
        } else {
            System.out.println("VR[0] is neither VR_OPERATION nor TABLE_OPERATION");
        }

        return 13 + 2 * words_number;  //package length in byte: 13 is number of byte from obuf[0] to obuf[12]
    }

    private void parseWriteResponse(int lenght) {
        if (lenght < 10) {
            if (lenght == 0) {
                System.out.println("unexpected close of connection at remote end");
            } else if (0 != (ibuf[7] & 0x80)) {
                System.out.println("Modbus exception response - type " + ibuf[8]);
            } else {
                System.out.println("response was too short - " + lenght + " chars");
            }
        } else if (lenght != 12) {
            System.out.println("incorrect response size is " + lenght + " expected size is 12");
        } else {
            System.out.println("Writing VR[] or TABLE[] words is ok");
        }
    }

    private int readPackage(int source_address, int words_number) {
        int i;
        for (i = 0; i < 4; i++) {
            obuf[i] = 0;                    //header
        }
        obuf[4] = 0;                        //lengthH
        obuf[5] = 6;                        //lengthL: Following 6 bytes
        obuf[6] = -1;                       //Trio209 defautl unit address
        obuf[7] = 3;                        //Fuction code: read multiple registers
        obuf[8] = (byte) (source_address >> 8);      //High
        obuf[9] = (byte) (source_address & 0xff);    //Low
        obuf[10] = (byte) (words_number >> 8);   //High
        obuf[11] = (byte) (words_number & 0xff); //Low

        return 12;  //length of the package in byte
    }

    private void parseReadResponse(int read_length, int target_address, int words_number) {
        if (read_length < 9) {
            if (read_length == 0) {
                System.out.println("unexpected close of connection at remote end");
            } else {
                System.out.println("response was too short: " + read_length + " bytes");
            }
        } else if (0 != (ibuf[7] & 0x80)) {
            System.out.println("Modbus exception response - type " + ibuf[8]);
        } else if (read_length != (9 + 2 * words_number)) {
            System.out.println("incorrect response size is " + read_length + ", expected " + (9 + 2 * words_number));
        } else {
            if (VR[0] == VR_OPERATION) {
                for (int i = 0; i < words_number; i++) {
                    VR[target_address + i] = (short) (ibuf[2*i + 9] << 8 + ibuf[2*i] + 10);
                    System.out.println("VR[" + target_address + i + "] = " + VR[target_address + i]);
                }
            } else if (VR[0] == TABLE_OPERATION) {
                for (int i = 0; i < words_number; i++) {
                    TABLE[target_address + i] = (short) (ibuf[2*i + 9] << 8 + ibuf[2*i] + 10);
                    System.out.println("TABLE[" + target_address + i + "] = " + TABLE[target_address + i]);
                }
            } else {
                System.out.println("VR[0] is neither VR_OPERATION nor TABLE_OPERATION");
            }
        }
    }
    
    private void parseVR0Response(int read_length, int target_address, int words_number) {
        if (read_length < 9) {
            if (read_length == 0) {
                System.out.println("unexpected close of connection at remote end");
            } else {
                System.out.println("response was too short: " + read_length + " bytes");
            }
        } else if (0 != (ibuf[7] & 0x80)) {
            System.out.println("Modbus exception response - type " + ibuf[8]);
        } else if (read_length != (9 + 2 * words_number)) {
            System.out.println("incorrect response size is " + read_length + ", expected " + (9 + 2 * words_number));
        } else {
            //Only save to VR[0] instead of TABLE[0]
            for (int i = 0; i < words_number; i++) {
                VR[target_address + i] = (short) (ibuf[2 * i + 9] << 8 + ibuf[2 * i] + 10);
                System.out.println("VR[" + target_address + i + "] = " + VR[target_address + i]);
            }
        }
    }
}