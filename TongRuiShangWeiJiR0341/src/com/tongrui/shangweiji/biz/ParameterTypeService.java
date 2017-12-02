/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatDeviceparamType;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ParameterTypeService {
    public CatDeviceparamType findByName(String name);
    public List<CatDeviceparamType> findAll();
    
}
