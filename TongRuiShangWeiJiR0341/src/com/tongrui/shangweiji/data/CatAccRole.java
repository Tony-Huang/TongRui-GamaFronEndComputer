package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatAccRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatAccRole extends com.tongrui.shangweiji.data.Entity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private String description;
	private Set catAccUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatAccRole() {
	}

	/** minimal constructor */
	public CatAccRole(Integer id, String roleName) {
                this.id = id;
		this.roleName = roleName;
	}

	/** full constructor */
	public CatAccRole(Integer id, String roleName, String description, Set catAccUsers) {
                this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.catAccUsers = catAccUsers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getCatAccUsers() {
		return this.catAccUsers;
	}

	public void setCatAccUsers(Set catAccUsers) {
		this.catAccUsers = catAccUsers;
	}

}