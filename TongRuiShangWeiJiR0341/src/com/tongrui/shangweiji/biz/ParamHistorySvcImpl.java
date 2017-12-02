/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatDeviceparamValueHistory;
import com.tongrui.shangweiji.data.CatDeviceparamValueHistoryDAO;

/**
 *
 * @author Administrator
 */
public class ParamHistorySvcImpl implements ParamHistoryService{
    
   public void save(CatDeviceparamValueHistory instance){
      paramValueHistoryDAO.save(instance);
    }
   
   CatDeviceparamValueHistoryDAO  paramValueHistoryDAO;
   
   public void setParamValueHistoryDAO( CatDeviceparamValueHistoryDAO  paramValueHistoryDAO){
       this.paramValueHistoryDAO=paramValueHistoryDAO;
   }
   
}
