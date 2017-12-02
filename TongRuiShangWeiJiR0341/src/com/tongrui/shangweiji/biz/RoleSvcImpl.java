package com.tongrui.shangweiji.biz;

import java.util.List;

import com.tongrui.shangweiji.data.CatAccRole;
import com.tongrui.shangweiji.data.CatAccRoleDAO;

//import org.hibernate.SessionFactory;
public class RoleSvcImpl implements RoleService{

	
	public void saveOrUpdate(CatAccRole instance){
		roleDAO.attachDirty(instance);
	}
	public void delete(CatAccRole persistentInstance){
		
		roleDAO.delete(persistentInstance);
	}
	
	public List findAll(){
		return roleDAO.findAll();
	}
	
	public void save(CatAccRole instance){
		roleDAO.save(instance);
		
	}
	
	public CatAccRole merge(CatAccRole detachedInstance) {
		return roleDAO.merge(detachedInstance);
	}
	
	public  CatAccRole  findById(Integer id){
		
		return roleDAO.findById(id);
	}
	
    public  CatAccRole  findByName(String name){
		//roleDAO.findByRoleName(name).iterator().hasNext()==true;
		return roleDAO.findByRoleName(name).iterator().hasNext()==true?  (CatAccRole) roleDAO.findByRoleName(name).iterator().next():null;
	}
	
	
	private CatAccRoleDAO roleDAO;

    public void setRoleDAO(CatAccRoleDAO dao) {
        this.roleDAO = dao;
    }
    
    
}
