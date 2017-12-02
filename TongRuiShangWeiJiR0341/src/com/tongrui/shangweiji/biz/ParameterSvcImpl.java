/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatAccUserDAO;
import com.tongrui.shangweiji.data.CatDeviceparamValue;
import com.tongrui.shangweiji.data.CatDeviceparamValueDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ParameterSvcImpl implements ParameterService{
    
     public void save(CatDeviceparamValue paramValue){
     paramValueDAO.save(paramValue);
     }
    public void update(CatDeviceparamValue paramValue){
        paramValueDAO.attachDirty(paramValue);
    }
    public CatDeviceparamValue findByName(String name){
       List paramVulues= paramValueDAO.findByName(name);
       if(paramVulues.size()>0){
           return  (CatDeviceparamValue)paramValueDAO.findByName(name).get(0);
       }
       else return null;
    }
    public List<CatDeviceparamValue> findByHQL(String hql) {
       List<CatDeviceparamValue> paramList= paramValueDAO.getHibernateTemplate().find(hql);
       if(paramList.size()>0){
           return paramList ;
       }
       else return null;
    }
    public List<CatDeviceparamValue> findAll(){
      return  paramValueDAO.findAll();
    }
    
    public void delete(CatDeviceparamValue paramValue){
    paramValueDAO.delete(paramValue);
    }
    
    public void deleteList(List<CatDeviceparamValue> paramList){
    for(int i = 0; i < paramList.size(); i++) {
        paramValueDAO.delete(paramList.get(i));
    }
    }
    
    public List<CatDeviceparamValue> findByTypeName(String typeName){
     return  paramValueDAO.findByTypeName(typeName);
    }
    
    
    CatDeviceparamValueDAO  paramValueDAO;
    
    
    public void setParamValueDAO(CatDeviceparamValueDAO paramValueDAO) {
        this.paramValueDAO = paramValueDAO;
    }
}
