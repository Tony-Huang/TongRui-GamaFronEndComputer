/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class TmpLocator {
	private static ApplicationContext getAppContext(){
		
		ApplicationContext application
		=new ClassPathXmlApplicationContext("applicationContextTmp.xml");
		return application;
	}
        
         public static TmpPatientService getTmpDBService(){
               return (TmpPatientService)getAppContext().getBean("TmpPatientService");
         } 
          
    
}
