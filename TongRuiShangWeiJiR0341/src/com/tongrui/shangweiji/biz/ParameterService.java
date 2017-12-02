/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatDeviceparamValue;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ParameterService {
      public void save(CatDeviceparamValue paramValue);
    public void update(CatDeviceparamValue paramValue);
    public CatDeviceparamValue findByName(String name);
    public List<CatDeviceparamValue> findByHQL(String hql);
    public List<CatDeviceparamValue> findAll();
    
    public void delete(CatDeviceparamValue user);
    public void deleteList(List<CatDeviceparamValue> paramList);
    
    public List<CatDeviceparamValue> findByTypeName(String typeName);
}
