/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Administrator
 */
public class MyCustomDriverManagerDataSource extends DriverManagerDataSource {

    public MyCustomDriverManagerDataSource() {
        super();
       
    }
    
    @Override
     public String getPassword(){
      String clearPasswd = EncryptUtil.decrypt(super.getPassword());
      return clearPasswd;
     }
    
}
