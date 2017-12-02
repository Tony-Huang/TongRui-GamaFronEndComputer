/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentPatientCase;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface PatientService {
    List<CatTreatmentPatientCase> findAll();
    
    public CatTreatmentPatientCase findByPatientID(String patientID);
    
    public  void saveOrUpdate(CatTreatmentPatientCase patient);
    
}
