package com.tongrui.shangweiji.ui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;
import javax.swing.JOptionPane;

public class ReadIdCard implements Runnable, SerialPortEventListener {
    private String str = "";
    private MainWindow mainWin  = null;
    Thread readThread;
    
    static CommPortIdentifier portId;
    SerialPort sPort;
    static Enumeration portList;
    InputStream is;

    private int i = 1;
    boolean findCOM1 = false;

    public ReadIdCard() {
        portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals("COM1")) {
                    findCOM1 = true;
                    break;
                }
            }
        }

        if(!findCOM1) {
            JOptionPane.showMessageDialog(null, "COM1 initiate failure! Can't read patient ID.");
            return;
        }
        
        try {
            sPort = (SerialPort) portId.open("SimpleReadApp", 2000);
        } catch (PortInUseException e) {}
        try {
            is = sPort.getInputStream();
        } catch (IOException e) {}
        
    	try {
                sPort.addEventListener(this);
    	} catch (TooManyListenersException e) {}
        sPort.notifyOnDataAvailable(true);
    
        try {
            sPort.setSerialPortParams(9600,
                SerialPort.DATABITS_7,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_EVEN);
        } catch (UnsupportedCommOperationException e) {}
        readThread = new Thread(this);
        readThread.start();
    }

    public void run() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {}
    }

    public void serialEvent(SerialPortEvent e) {
            switch (e.getEventType()) {
                case SerialPortEvent.BI:            //通讯中断
                case SerialPortEvent.CD:            //载波检测.
                case SerialPortEvent.CTS:           //清除发送.
                case SerialPortEvent.DSR:           //数据设备准备好.
                case SerialPortEvent.FE:            //帧错误.
                case SerialPortEvent.OE:            //溢位错误.
                case SerialPortEvent.PE:            //奇偶校验错.
                case SerialPortEvent.RI:            //振铃指示.
                case SerialPortEvent.OUTPUT_BUFFER_EMPTY: //输出缓冲区已清空.
                    break;
                    
                //有一批/帧数据到达时，或每收到8个字节此消息会一次有效.
                case SerialPortEvent.DATA_AVAILABLE:
                    byte[] readBuffer = new byte[20];
                    int numBytes = 0;
                    try {
                        Thread.sleep(2*15); //wys.TBV
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ReadIdCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        while (is.available() > 0) {
                            numBytes = is.read(readBuffer);
                        }
                        str = "";
                        for(i=0; i<numBytes; i++)
                        {
                            str += (char)readBuffer[i];
                        }
                        mainWin = MainWindow.getInstance();
                        if(mainWin != null) {
                            mainWin.updateBy_PCard(str);
                        } else {
                            System.out.println(str);
                        }
                    } catch (IOException e2) {}
                    
                    break;
           }
        }
    
    public static void main(String args[]) {
        ReadIdCard sr = new ReadIdCard();
    }
}
