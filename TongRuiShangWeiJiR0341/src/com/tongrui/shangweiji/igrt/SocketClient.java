package com.tongrui.shangweiji.igrt;

import java.net.*;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SocketClient extends Thread {
    private static final Log log = LogFactory.getLog(SocketClient.class);

    private String host;
    private int port;
    private static Socket client;
    private OutputStream cout;
    private DataInputStream cin;
    private boolean answerState = false;
    private boolean verifyState = false;
    private boolean isLinkState = false;
    private byte[] sendBuffer = new byte[228];
    private float receivedBedX, receivedBedY, receivedBedZ, receivedAngX, receivedAngY, receivedAngZ, receivedSum;
    private int receivedStatus, receivedStatusCheck;
    private float sendBedX, sendBedY, sendBedZ, sendAngX, sendAngY, sendAngZ, sendFloatSum;
    private int sendStatus, sendStatusCheck;
    
    private static int testCounter = 1;

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
        
        this.connect();
    }

    private void connect() {
        try {
            //client = new Socket(host,port); //wys.To be restore
            client = new Socket(InetAddress.getLocalHost(), port);
            //client = new Socket("192.168.1.101", port);

            cin = new DataInputStream(client.getInputStream());
            cout = client.getOutputStream();
            this.start();
            
            answerState = false;
            verifyState = false;
            isLinkState = true;
            
        } catch (IOException e) {
            isLinkState = false;
        }
        System.out.println("Socket link is " + isLinkState + ".");
    }

    public void disConnect() {
        isLinkState = false;
        answerState = false;
        verifyState = false;
        try {
            cin.close();
            cout.close();
            client.close();
            this.stop();
        } catch (IOException ex) {
            log.error("Can't disconnect the socket!", ex);
        }
    }

    public void run() {
        while (isLinkState) {
            try {
                for(int i = 0; i < 64*3; i++) cin.readByte();  //PatientID, PatientName and PlanName
                
                receivedBedX = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedBedX).toString());
                receivedBedY = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedBedY).toString());
                receivedBedZ = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedBedZ).toString());
                receivedAngX = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedAngX).toString());
                receivedAngY = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedAngY).toString());
                receivedAngZ = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedAngZ).toString());
                receivedSum = readFloatFromStream(cin);
                System.out.println(Float.valueOf(receivedSum).toString());

                receivedStatus = readIntFromStream(cin);
                System.out.println("" + receivedStatus);
                receivedStatusCheck = readIntFromStream(cin);
                System.out.println("" + receivedStatusCheck);
                System.out.println("\r\n");
                
                answerState = true;
                System.out.println("Receive from socket " + testCounter++ + " times");

                float sum = receivedBedX + receivedBedY + receivedBedZ + receivedAngX + receivedAngY + receivedAngZ;
                if (Math.abs(sum - receivedSum) < 0.001 && ((receivedStatus ^ receivedStatusCheck) == -1)) {
                    verifyState = true;
                } else {
                    verifyState = false;
                }

            } catch (IOException ex) {
                log.error("Can't read from socket!", ex);
                disConnect();
            }
        }
    }

    public static void main(String args[]) {
        new SocketClient("Input IGRT IP address here", 3000); //wys.to be changed
    }

    private int readIntFromStream(DataInputStream din) throws IOException //从指定文件中读取整数
    {
        int b[];
        b = new int[4];

        b[0] = din.readByte() & 0x000000ff;
        b[1] = din.readByte() & 0x000000ff;
        b[2] = din.readByte() & 0x000000ff;
        b[3] = din.readByte() & 0x000000ff;

        return (int) b[3] << 24 | b[2] << 16 | b[1] << 8 | b[0];
    }

    private float readFloatFromStream(DataInputStream din) throws IOException //从指定文件中读取整数
    {
        int b[];
        b = new int[4];

        b[0] = din.readByte() & 0x000000ff;
        b[1] = din.readByte() & 0x000000ff;
        b[2] = din.readByte() & 0x000000ff;
        b[3] = din.readByte() & 0x000000ff;
        return Float.intBitsToFloat(b[3] << 24 | b[2] << 16 | b[1] << 8 | b[0]);
    }

    public void setSendAngX(float sendAngX) {
        this.sendAngX = sendAngX;
    }

    public void setSendAngY(float sendAngY) {
        this.sendAngY = sendAngY;
    }

    public void setSendAngZ(float sendAngZ) {
        this.sendAngZ = sendAngZ;
    }

    public void setSendBedX(float sendBedX) {
        this.sendBedX = sendBedX;
    }

    public void setSendBedY(float sendBedY) {
        this.sendBedY = sendBedY;
    }

    public void setSendBedZ(float sendBedZ) {
        this.sendBedZ = sendBedZ;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    public float getReceivedAngX() {
        return receivedAngX;
    }

    public float getReceivedAngY() {
        return receivedAngY;
    }

    public float getReceivedAngZ() {
        return receivedAngZ;
    }

    public float getReceivedBedX() {
        return receivedBedX;
    }

    public float getReceivedBedY() {
        return receivedBedY;
    }

    public float getReceivedBedZ() {
        return receivedBedZ;
    }

    public int getReceivedStatus() {
        return receivedStatus;
    }

    public void clearAnswered() {
        answerState = false;
    }

    public boolean isAnswered() {
        return answerState;
    }

    public boolean isLinkOK() {
        return isLinkState;
    }

    public boolean isVerified() {
        return verifyState;
    }

    private void setCheckData() {
        this.sendFloatSum = 0;
        this.sendFloatSum += sendBedX;
        this.sendFloatSum += sendBedY;
        this.sendFloatSum += sendBedZ;
        this.sendFloatSum += sendAngX;
        this.sendFloatSum += sendAngY;
        this.sendFloatSum += sendAngZ;

        this.sendStatusCheck = ~sendStatus;
    }

    public boolean sendData() {
        int i = 0;
        for(i=0; i<sendBuffer.length; i++) sendBuffer[i] = 0; 
        
        i = 0;
        sendBuffer[i] = '0';        //PatientID
        sendBuffer[i + 1] = '1';
        sendBuffer[i + 2] = '2';
        sendBuffer[i + 3] = '3';
        sendBuffer[i + 4] = '4';
        sendBuffer[i + 5] = '5';
        sendBuffer[i + 6] = '6';
        sendBuffer[i + 7] = '7';
        i += 64;
        
        sendBuffer[i] = 'L';        //PatientName
        sendBuffer[i + 1] = 'i';
        sendBuffer[i + 2] = ' ';
        sendBuffer[i + 3] = 'L';
        sendBuffer[i + 4] = 'i';
        sendBuffer[i + 5] = 'z';
        sendBuffer[i + 6] = 'h';
        sendBuffer[i + 7] = 'e';
        sendBuffer[i + 7] = 'n';
        i += 64;
        
        sendBuffer[i] = 'P';        //PlanName
        sendBuffer[i + 1] = 'l';
        sendBuffer[i + 2] = 'a';
        sendBuffer[i + 3] = 'n';
        sendBuffer[i + 4] = 'N';
        sendBuffer[i + 5] = 'a';
        sendBuffer[i + 6] = 'm';
        sendBuffer[i + 7] = 'e';
        i += 64; 
                                    //Float data
        sendBedX = 1.1f;
        sendBedY = 1.2f;
        sendBedZ = 1.3f;
        sendAngX = 10.1f;
        sendAngY = 11.1f;
        sendAngZ = 12.1f;
        setCheckData();
        FloatToBuffer(sendBedX, i); i += 4;
        FloatToBuffer(sendBedY, i); i += 4;
        FloatToBuffer(sendBedZ, i); i += 4;
        FloatToBuffer(sendAngX, i); i += 4;
        FloatToBuffer(sendAngY, i); i += 4;
        FloatToBuffer(sendAngZ, i); i += 4;
        FloatToBuffer(sendFloatSum, i); i += 4;

        IntToBuffer(sendStatus, i); i += 4;
        IntToBuffer(sendStatusCheck, i); i += 4;

        if(!isLinkState) {
            return false;
        }
        
        try {
            this.cout.write(sendBuffer);
            this.cout.flush();
        } catch (IOException ex) {
            log.error("Can't send data from socket", ex);
            return false;
        }
        return true;
    }

    private void FloatToBuffer(float data, int i) {
        int k = Float.floatToIntBits(data);
        IntToBuffer(k, i);
    }

    private void IntToBuffer(int data, int i) {
        sendBuffer[i] = (byte) (data & 0xff);
        sendBuffer[i + 1] = (byte) (data >> 8 & 0xff);
        sendBuffer[i + 2] = (byte) (data >> 16 & 0xff);
        sendBuffer[i + 3] = (byte) (data >> 24 & 0xff);

    }
}
