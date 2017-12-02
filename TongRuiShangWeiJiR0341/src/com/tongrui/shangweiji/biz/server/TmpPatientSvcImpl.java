/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz.server;

import com.tongrui.shangweiji.data.server.TmpTreatmentPatientCase;
import com.tongrui.shangweiji.data.server.TmpTreatmentPatientCaseDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TmpPatientSvcImpl implements TmpPatientService {
    
    @Override
    public List<TmpTreatmentPatientCase> findAll() {
       return tmpTreatmentPatientCaseDAO.findAll();
    }
    
    public List<TmpTreatmentPatientCase> findByIsUpdateByServer(Object condition) {
       return tmpTreatmentPatientCaseDAO.findByIsUpdateByServer(condition);
    }
    
    TmpTreatmentPatientCaseDAO tmpTreatmentPatientCaseDAO;

    public void setTmpTreatmentPatientCaseDAO(TmpTreatmentPatientCaseDAO tmpTreatmentPatientCaseDAO) {
        this.tmpTreatmentPatientCaseDAO = tmpTreatmentPatientCaseDAO;
    }

    public void update(TmpTreatmentPatientCase pCase){
        tmpTreatmentPatientCaseDAO.attachDirty(pCase);
    }
}
