/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatSystemLog;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface SystemLogService {
    public void save(CatSystemLog systemLog);
    List<CatSystemLog> findAll(); 
    List<CatSystemLog> findBySearchCriteria(String logLevel, String start, String end);
}
