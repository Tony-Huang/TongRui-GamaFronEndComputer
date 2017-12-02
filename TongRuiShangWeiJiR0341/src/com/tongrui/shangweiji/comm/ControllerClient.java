/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class ControllerClient extends Thread {
    private static final Log log = LogFactory.getLog(ControllerClient.class);
    short VR[] = new short[150];
    
    Socket sk = null;
    //BufferedReader reader = null;
    //PrintWriter wtr = null;
    BufferedReader input = null;
    
    
    
    OutputStream os = null;
    FilterInputStream in=null;
    
    boolean connectStats = false;
    StringBuilder sb = null;
    BlockingQueue que= null;
    String mode=null;
    
    ModbusTCPAction commObj = null;
    
    private static final ControllerClient instance = new ControllerClient(); 
    
    private ControllerClient(){
        this.start();
    }

    public static ControllerClient getInstance(){
        return instance;
    }
   
    //按照adrs，port。以及cmd的交互模式构建对象。
    public ControllerClient(String addr,int port,String mode) throws ConnectException {
        this.mode = mode;
        if (mode.toUpperCase().equals(Constant.MODE.INPUT.toString()))
            input = new BufferedReader(new InputStreamReader(System.in));
        else
            que = new ArrayBlockingQueue(Constant.QUEUE_SIZE); 
        try {
            sk = new Socket(addr,port);
            os = sk.getOutputStream();
            in = new BufferedInputStream(sk.getInputStream());
            commObj= new ModbusTCPAction(os,in);
            connectStats = true;
        } catch (Exception e) {
            throw new ConnectException();
        }

    }
    
    //cmd放入队列中
    public void putCommand(String cmd){
        try {
            que.put(cmd);
        } catch (InterruptedException ex) {
            log.error(null, ex);
        }
    }
    //从队列中取出cmd
    private String takeCommand() throws IOException, InterruptedException{
        if (mode.toUpperCase().equals(Constant.MODE.INPUT.toString())) {
            return input.readLine();
        }
        else {
            return (String)que.take();
        }
    }

    public void run() {
          try {
            //wtr = new PrintWriter(sk.getOutputStream());
            //reader = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            while (connectStats) {
                String cmd = this.takeCommand();
                if (cmd != null & cmd.length() > 0) {
                    //wtr.println(cmd);
                    //wtr.flush();
                    //向服务器发请求
                    commObj.sendCommand(MIN_PRIORITY, MIN_PRIORITY);
                }
                //获取服务器返回信息
                while (true) {
                    //commObj.
                    /*
                    String line = reader.readLine();
                    if (line.length() > 0) {
                        if (line.equals(Constant.OFF_CODE)) {
                            connectStats = false;
                        }
                        System.out.println("server-response：" + line);
                    } else {
                        break;
                    }*/
                }
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        ControllerClient tc=null;
        try {
            String m="INPUT";
            m = Constant.MODE.QUEUE.toString();
            System.out.println(m);
            tc = new ControllerClient(Constant.SERVER_ADDS,Constant.SERVER_PORT,m);
            tc.start();
        } catch (ConnectException ex) {
            log.error(null, ex);
        }
        /*
        if (false){
            Thread.sleep(2000);
            for(int i=0;i<100;i++)
                tc.putCommand(""+i);
            tc.putCommand("exit");
        }*/
        
    }
    
    
    public short getVR(int address) {
        short int16;
        
        switch(address) {
            case 100:
                int16 = VR[100]; //range is 0 to 9999
                break;
            case 102:
                int16 = VR[102]; //only 2 state
                break;
            case 103:
                int16 = VR[103]; //only 3 state
                break;
            case 104:
                int16 = VR[104]; //only 4 state
                break;
            case 105:
                int16 = VR[105]; //only 5 state
                break;
            case 106:
                int16 = VR[106]; //only 6 state
                break;
            default:
                System.out.println("VR address is wrong");
                int16 = -1;    //无效标志
        }
        return int16;
    }
   
}
