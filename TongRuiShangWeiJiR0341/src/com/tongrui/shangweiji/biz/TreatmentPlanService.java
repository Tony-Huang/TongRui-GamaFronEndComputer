/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentPlan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface TreatmentPlanService {
   public  List<CatTreatmentPlan> findAll();
    
    public  CatTreatmentPlan findById(int id);
    
    public  List<CatTreatmentPlan> findByStateId(int id);

    public  CatTreatmentPlan findBySerialNumber(int serialNo);
   
   public List<CatTreatmentPlan> findBySearchCriteria(String name,Integer planId,
           Date start, Date end);
   
   public List<CatTreatmentPlan> findBySearchCriteria(String name,Integer planId, String start, String end);

   public void updateNotes(String notes, Integer id) ;
   
   public void update(CatTreatmentPlan instance) ;
}
