package com.tongrui.shangweiji.biz;

import java.util.List;

import com.tongrui.shangweiji.data.CatAccRole;

public interface RoleService {

	public void saveOrUpdate(CatAccRole instance);
	public void delete(CatAccRole persistentInstance);
	public List findAll();
	public void save(CatAccRole instance);
	
       public  CatAccRole  findById(Integer id);
       public  CatAccRole  findByName(String name);
       public CatAccRole merge(CatAccRole detachedInstance);
	
}
