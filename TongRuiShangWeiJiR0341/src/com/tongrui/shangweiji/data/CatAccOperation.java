package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatAccOperation entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatAccOperation extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Set catAccPrivileges = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatAccOperation() {
	}

	/** minimal constructor */
	public CatAccOperation(String name) {
		this.name = name;
	}

	/** full constructor */
	public CatAccOperation(String name, String description, Set catAccPrivileges) {
		this.name = name;
		this.description = description;
		this.catAccPrivileges = catAccPrivileges;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getCatAccPrivileges() {
		return this.catAccPrivileges;
	}

	public void setCatAccPrivileges(Set catAccPrivileges) {
		this.catAccPrivileges = catAccPrivileges;
	}

}