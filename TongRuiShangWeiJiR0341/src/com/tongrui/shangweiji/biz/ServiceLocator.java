package com.tongrui.shangweiji.biz;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.tongrui.shangweiji.data.CatAccRole;
import com.tongrui.shangweiji.data.CatAccUser;
import com.tongrui.shangweiji.data.CatTreatmentPlan;
import java.util.List;
public class ServiceLocator {
	private static ApplicationContext application = null;// new ClassPathXmlApplicationContext("applicationContext.xml");
        static{
          try{
            application = new ClassPathXmlApplicationContext("applicationContext.xml");
          } catch(Throwable t){ t.printStackTrace();}
        }
	
	private static ApplicationContext getAppContext(){
		if(application!=null) return application;
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		return app;
	}
        
        
	public static RoleService getRoleService(){
		return (RoleService)getAppContext().getBean("RoleService");
		
	}
        
        public static UserService getUserService(){
		return (UserService)getAppContext().getBean("UserService");
		
	}
        
	public static ParameterService getParameterService(){
		return (ParameterService)getAppContext().getBean("ParameterService");
		
	}
	         
        public static ParamHistoryService getParameterHistoryService(){
		return (ParamHistoryService)getAppContext().getBean("ParamHistoryService");
	}

        public static ParameterTypeService getParameterTypeService(){
		return (ParameterTypeService)getAppContext().getBean("ParameterTypeService");
     }
          
         public static PatientService getPatientService(){
               return (PatientService)getAppContext().getBean("PatientService");
         } 
          
        public static  TreatmentPlanService getTreatmentPlanService(){
             return (TreatmentPlanService)getAppContext().getBean("TreatmentPlanService");
         }
         
	 public static CollTypeService getCollTypeService(){
		return (CollTypeService)getAppContext().getBean("CollTypeService");
		
	 }

         public static SystemLogService getSystemLogService() {
             return (SystemLogService)getAppContext().getBean("SystemLogService");
         }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	       // testUpdate();
	       //testSave();
            int paramvs=getParameterService().findByTypeName("bed_ps").size();
            int patientSize= getPatientService().findAll().size();
            int planSize= getTreatmentPlanService().findAll().size();

           List<CatTreatmentPlan> plans=  getTreatmentPlanService().findAll();
           for(CatTreatmentPlan pl : plans){
            int plid= pl.getId();
            String name= pl.getCatTreatmentPatientCase().getName();
            System.out.println("planid="+plid +"patintName="+name);
           }
           
           System.out.println("--- size="+paramvs);
           System.out.println("---patient size="+patientSize);
            System.out.println("---plan size="+planSize);
           
		System.out.println("---  success -----");
	}

}
