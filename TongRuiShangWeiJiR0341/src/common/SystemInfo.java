package common;


import com.tongrui.shangweiji.data.CatAccUser;
import com.tongrui.shangweiji.data.CatTreatmentPlanFraction;
import com.tongrui.shangweiji.ui.Login;
import java.util.ResourceBundle;
import java.util.Properties;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class SystemInfo {
    
    public static String localdb="localjdbc.properties";
    public static String downdb ="downjdbc.properties";
    
    private  static Properties props ;
    static{
     props= new Properties();
     try{
     props.load(SystemInfo.class.getClassLoader().getResourceAsStream("sysconfig.properties"));
     } catch(Exception e){
       e.printStackTrace();
     }
      
    }
    //ResourceBundle resources = ResourceBundle.getBundle("resources_cn");
    
    public static  ResourceBundle getEnglishResource(){
      return  ResourceBundle.getBundle("resources_en");
    }
     public static  ResourceBundle getChineseResource(){
      return  ResourceBundle.getBundle("resources_en");
    }
     
     public static  ResourceBundle getUserWantedResource(){
       Login login =null;
       int langid=login.getInstance().getSelectedLangIndex();
       java.util.ResourceBundle bundle=java.util.ResourceBundle.getBundle("resources_cn");;
       //langid = 0 : Chinese ; langid=1: English
       if(langid ==1){
            bundle=java.util.ResourceBundle.getBundle("resources_en");;
       }
     return bundle;
       
     }
     
     private static CatAccUser currentuser;
     private static CatTreatmentPlanFraction currentPlanFraction; 
     
     public static CatAccUser getCurrentUser(){
       return currentuser;
     }
    
      public static void setCurrentUser(CatAccUser user){
        currentuser=user;
      }
      
      
      public static final String getTPSFolder(){
        return props.getProperty("TPSFolder");
      }

    /**
     * @return the currentPlanFraction
     */
    public static CatTreatmentPlanFraction getCurrentPlanFraction() {
        return currentPlanFraction;
    }

    /**
     * @param aCurrentPlanFraction the currentPlanFraction to set
     */
    public static void setCurrentPlanFraction(CatTreatmentPlanFraction aCurrentPlanFraction) {
        currentPlanFraction = aCurrentPlanFraction;
    }
}
