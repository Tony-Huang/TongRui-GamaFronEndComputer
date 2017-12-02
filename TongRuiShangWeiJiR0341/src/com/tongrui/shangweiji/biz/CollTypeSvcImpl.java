/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentCollType;
import com.tongrui.shangweiji.data.CatTreatmentCollTypeDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CollTypeSvcImpl implements CollTypeService {
    CatTreatmentCollTypeDAO collTypeDAO;

    public void setCollTypeDAO(CatTreatmentCollTypeDAO collTypeDAO) {
        this.collTypeDAO = collTypeDAO;
    }

    public CatTreatmentCollType findById(int id) {
        return collTypeDAO.findById(id);
    }

    public List<CatTreatmentCollType> findAll() {
        return collTypeDAO.findAll();
    }
    
}
