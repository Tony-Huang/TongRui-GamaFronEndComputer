/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.net.Socket;
/**
 *
 * @author Administrator
 */
public class DataSender {
    
    
    public static void main(String[]  args)  throws Exception{
     ExecutorService se= Executors.newCachedThreadPool();
     se.submit(   new Runnable(){
      public void run(){
          try{
         Socket sk = new Socket("localhost",3030);
          sk.getInputStream();
          //sk.getOutputStream().write();
          
          } catch (Exception e) {
             e.printStackTrace();
             }
          }
     });
             
    
    }
}
