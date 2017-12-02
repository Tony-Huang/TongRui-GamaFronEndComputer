/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz.server;

import com.tongrui.shangweiji.data.server.TmpTreatmentPatientCase;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface TmpPatientService {

    List<TmpTreatmentPatientCase> findAll();
    public List<TmpTreatmentPatientCase> findByIsUpdateByServer(Object condition);
    public void update(TmpTreatmentPatientCase pCase);
    
}
