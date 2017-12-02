/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentPatientCase;
import com.tongrui.shangweiji.data.CatTreatmentPatientCaseDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PatientSvcImpl implements PatientService {

    @Override
    public List<CatTreatmentPatientCase> findAll() {
        return patientDAO.findAll();
    }
    
    CatTreatmentPatientCaseDAO patientDAO;
    
    public void setPatientDAO( CatTreatmentPatientCaseDAO patientDAO){
      this.patientDAO = patientDAO;
    }
    
    public CatTreatmentPatientCase findByPatientID(String patientID){
       CatTreatmentPatientCase p =null;
       List<CatTreatmentPatientCase>  ps =this.patientDAO.findByPatientId(patientID);
       if(ps.size() > 0){
         return ps.get(0);
       }
       return p;
    }
    
    public  void saveOrUpdate(CatTreatmentPatientCase patient){
      //this.patientDAO.save(patient);
        this.patientDAO.attachDirty(patient);
    }
    
}
