/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatAccUser;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserService {
    public void save(CatAccUser user);
    public void update(CatAccUser user);
    public CatAccUser findByName(String name);
    public List<CatAccUser> findAll();
    public List<CatAccUser> findByHql(String hql);
    public void delete(CatAccUser user);
}
