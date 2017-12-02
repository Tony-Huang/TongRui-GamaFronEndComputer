/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentFractionState;
import com.tongrui.shangweiji.data.CatTreatmentFractionStateDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class FractionStateSvcImpl   implements  FractionStateService{
    
    CatTreatmentFractionStateDAO fracStateDAO;

    public void setFracStateDAO(CatTreatmentFractionStateDAO fracStateDAO) {
        this.fracStateDAO = fracStateDAO;
    }
  public  CatTreatmentFractionState findById(int id){
       return   fracStateDAO.findById(id);
     }
   
  public  CatTreatmentFractionState  findByName(String name){
      List<CatTreatmentFractionState>  states= fracStateDAO.findByStateName(name);
      if(states.size()>0)
          return states.get(0);
      else return null;
   }
   
  public  List<CatTreatmentFractionState> findAll(){
      return fracStateDAO.findAll();
   }
    
    
}
