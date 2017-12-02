package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatDeviceparamType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatDeviceparamType extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Set catDeviceparamValues = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatDeviceparamType() {
	}

	/** minimal constructor */
	public CatDeviceparamType(Integer id, String name) {
                this.id = id;
		this.name = name;
	}

	/** full constructor */
	public CatDeviceparamType(Integer id, String name, String description,
			Set catDeviceparamValues) {
                this.id = id;
		this.name = name;
		this.description = description;
		this.catDeviceparamValues = catDeviceparamValues;
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

	public Set getCatDeviceparamValues() {
		return this.catDeviceparamValues;
	}

	public void setCatDeviceparamValues(Set catDeviceparamValues) {
		this.catDeviceparamValues = catDeviceparamValues;
	}

}