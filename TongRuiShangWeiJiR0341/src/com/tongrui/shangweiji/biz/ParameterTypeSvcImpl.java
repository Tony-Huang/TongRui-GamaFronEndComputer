/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatDeviceparamType;
import com.tongrui.shangweiji.data.CatDeviceparamTypeDAO;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class ParameterTypeSvcImpl implements ParameterTypeService {
    
    public CatDeviceparamType findByName(String typeName){
      List<CatDeviceparamType> paramType= paramTypeDAO.findByName(typeName);
       if(paramType.size()>0){
           return  paramType.get(0);
       }
       else return null;
        
    }
 
    public List<CatDeviceparamType> findAll(){
        return null;
    }
    
    CatDeviceparamTypeDAO  paramTypeDAO;

    public void setParamTypeDAO(CatDeviceparamTypeDAO paramTypeDAO) {
        this.paramTypeDAO = paramTypeDAO;
    }
    
    
}
