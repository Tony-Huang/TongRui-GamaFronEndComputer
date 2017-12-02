/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Administrator
 */
public class DateUtil {
    
    public static String getDateString(Date date){
        if(date ==null) return "";
      DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = dateFormat.format(date);
      return dateStr;
    }
    
    public static String getDateTimeString(Date date){
        if(date==null) return "";
      DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String dateStr = dateFormat.format(date);
      return dateStr;
    }
    
     public static Date getDatetime(String datetime)  {
      DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date= null;
      try{
      date = dateFormat.parse(datetime);
      } catch (Exception e){
       e.printStackTrace();  
      }
      finally{
       return date;
      }
    }
     
     public static Date getDate(String datestr)  {
      DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
      Date date= null;
      try{
        date =dateFormat.parse(datestr);
        } catch(Exception e){
          e.printStackTrace();
         }
      finally{
        return date;
      }
    }
     
    
     
    public static void main(String[] args){
     String dateStr = getDateString(new Date());
     System.out.println( "today is:"+dateStr);
     
     String dateimeStr = getDateTimeString(new Date());
     System.out.println( "now is:"+dateimeStr);
     
     Date datetime = getDatetime("2012-09-08 12:54:05");
     System.out.println(datetime);
     
     Date date = getDate("2012-09-08");
     System.out.println(date);
    }
    
    
}
