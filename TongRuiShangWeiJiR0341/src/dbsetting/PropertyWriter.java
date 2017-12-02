/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsetting;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Administrator
 */
public class PropertyWriter {
    static Properties props = new Properties(); 
    
    static String get(String name, String file) throws FileNotFoundException, IOException{
         InputStream in =new BufferedInputStream(new FileInputStream( file));  
         props.load(in);   
         in.close();   
         return props.getProperty(name);
      }
    
    static void write(String key, String value,String file) throws FileNotFoundException, IOException{
       makeSureFileExist( file);
       OutputStream fos = new FileOutputStream(file);   
            props.setProperty(key, value);   
            props.store(fos, null);   
            fos.close();   
    }
    
    static void write(Map<String,String> keyValues,String file) throws FileNotFoundException, IOException{
       makeSureFileExist( file);
       System.out.println("map.size="+keyValues.size() +" file="+file);
       OutputStream fos = new FileOutputStream(file); 
       Iterator<String> it =keyValues.keySet().iterator();
       while(it.hasNext()){
           String key = it.next();
           props.setProperty(key, keyValues.get(key));  
        
           }
           props.store(fos, null);   
            fos.close();   
    }
    
    private static void makeSureFileExist(String file) throws IOException{
     File propfile= new File(file);
        if(!propfile.exists()){
            propfile.createNewFile();
        }
     }
    
    
     
}
