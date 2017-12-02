/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;

/**
 *
 * @author Administrator
 */
public class ControllerServer extends Thread {

    ServerSocket server = null;
    Socket sk = null;
    

    public ControllerServer() {
        try {
            server = new ServerSocket(Constant.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Listenning...");
        while (true) {
            try {
                sk = server.accept();
                System.out.println(sk +"client on...");
                ServerThread th = new ServerThread(sk);
                th.start();
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ControllerServer().start();
    }

    class ServerThread extends Thread {
        BufferedReader rdr = null;
        PrintWriter wtr = null;
        Socket sk = null;

        public ServerThread(Socket sk) {
            this.sk = sk;
        }

        //Sending back the received message
        public void run() {
            try {
                wtr = new PrintWriter(sk.getOutputStream());
                while (true) {
                    String i ="";
                    rdr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                    //byte [] b = new byte[261];
                    //System.out.println(sk.getInputStream().read(b));
                    //System.out.println(new String(b));
          
                    String line = rdr.readLine();
                    System.out.println("client-request ：" + line);

                    if (line.toUpperCase().equals(Constant.OFF_TEXT)) {
                        wtr.println(Constant.OFF_CODE + "\n");
                        wtr.flush();
                        break;
                    }  
                    wtr.println(line + "\n");
                    wtr.flush();
                }
                System.out.println(sk+"client off...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
