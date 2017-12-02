/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentPlan;
import com.tongrui.shangweiji.data.CatTreatmentPlanDAO;
import com.tongrui.shangweiji.data.CatTreatmentPlanFractionDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public  class TreatmentPlanSvcImpl implements TreatmentPlanService{

    @Override
    public List<CatTreatmentPlan> findAll() {
       return planDAO.findAll();
    }
    
    CatTreatmentPlanDAO planDAO;
    private CatTreatmentPlanFractionDAO  planFractionDAO;

    public void setPlanDAO(CatTreatmentPlanDAO planDAO) {
        this.planDAO = planDAO;
        
    } 
    
   public  CatTreatmentPlan findById(int id){
     return  planDAO.findById(id);
    }
    
   public  List<CatTreatmentPlan> findByStateId(int id){
     return  planDAO.findByStateId(id);
    }
    
   public  CatTreatmentPlan findBySerialNumber(int serialNo){
     List<CatTreatmentPlan> lst=  planDAO.findBySerialNumber(new Integer(serialNo));
     if(lst.size()>0)
         return lst.get(0);
     else return null;
    }
    
    public List<CatTreatmentPlan> findBySearchCriteria(String name,Integer planId,
           Date start, Date end){
        return planDAO.findBySearchCriteria(name, planId, start, end);
    } 
    
     
   public List<CatTreatmentPlan> findBySearchCriteria(String name,Integer planId, String start, String end){
      return planDAO.findBySearchCriteria(name, planId, start, end);
   }

    /**
     * @return the planFractionDAO
     */
    public CatTreatmentPlanFractionDAO getPlanFractionDAO() {
        return planFractionDAO;
    }

    /**
     * @param planFractionDAO the planFractionDAO to set
     */
    public void setPlanFractionDAO(CatTreatmentPlanFractionDAO planFractionDAO) {
        this.planFractionDAO = planFractionDAO;
    }

    @Override
    public void updateNotes(String notes, Integer id) {
        planFractionDAO.updateNotes(notes, id); //按要求,备注写到分次表中
    }
    
    @Override
    public void update(CatTreatmentPlan plan) {
        planDAO.update(plan);
    }
}
