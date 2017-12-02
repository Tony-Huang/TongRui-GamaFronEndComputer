/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.biz;

import com.tongrui.shangweiji.data.CatAccUser;
import com.tongrui.shangweiji.data.CatAccUserDAO;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class UserSvcImpl implements UserService{
    public void save(CatAccUser user){
       userDAO.save(user);
     }
    public void update(CatAccUser user){
      userDAO.attachDirty(user);
    }
    public CatAccUser findByName(String name){
       List<CatAccUser>  users=  userDAO.findByUserName(name);
       System.out.println(users);
      if ( users.iterator().hasNext()){
         return users.iterator().next();
      }
      else return null;
    }
    
    public List<CatAccUser> findAll(){
     List<CatAccUser>  list=userDAO.findAll();
     return list;
    }
    
    public List<CatAccUser> findByHql(String hql) {
        List<CatAccUser> list = userDAO.getHibernateTemplate().find(hql);
        return list;
    }
     
    public void delete(CatAccUser user){
        if(user!=null)
     userDAO.delete(user);
    }
    
    CatAccUserDAO userDAO;

    public void setUserDAO(CatAccUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    
}
