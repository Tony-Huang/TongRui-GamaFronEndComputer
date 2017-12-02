package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatSystemLogLevel entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatSystemLogLevel extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Set catSystemLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatSystemLogLevel() {
	}

	/** minimal constructor */
	public CatSystemLogLevel(Integer id, String name) {
                this.id = id;
		this.name = name;
	}

	/** full constructor */
	public CatSystemLogLevel(Integer id, String name, String description, Set catSystemLogs) {
                this.id = id;
		this.name = name;
		this.description = description;
		this.catSystemLogs = catSystemLogs;
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

	public Set getCatSystemLogs() {
		return this.catSystemLogs;
	}

	public void setCatSystemLogs(Set catSystemLogs) {
		this.catSystemLogs = catSystemLogs;
	}

}