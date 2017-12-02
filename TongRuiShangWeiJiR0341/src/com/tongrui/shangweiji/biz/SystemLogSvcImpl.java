/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatSystemLog;
import com.tongrui.shangweiji.data.CatSystemLogDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SystemLogSvcImpl implements SystemLogService {
    CatSystemLogDAO systemLogDAO;

    public void setSystemLogDAO(CatSystemLogDAO systemLogDAO) {
        this.systemLogDAO = systemLogDAO;
    }
    
    public List<CatSystemLog> findAll() {
        return systemLogDAO.findAll();
    }

    public List<CatSystemLog> findBySearchCriteria(String logLevel, String start, String end) {
        return systemLogDAO.findBySearchCriteria(logLevel, start, end);
    }
    
    public void save(CatSystemLog systemLog){
        systemLogDAO.save(systemLog);
    }
}
