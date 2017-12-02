/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatTreatmentFractionState;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface FractionStateService {
   CatTreatmentFractionState findById(int id);
  CatTreatmentFractionState  findByName(String name);
   List<CatTreatmentFractionState> findAll();
}
