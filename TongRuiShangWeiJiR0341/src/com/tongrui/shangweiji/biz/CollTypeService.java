/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentCollType;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface CollTypeService {
   CatTreatmentCollType findById(int id);
   List<CatTreatmentCollType> findAll();    
}
