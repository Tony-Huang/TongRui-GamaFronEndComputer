package com.tongrui.shangweiji.data;

/**
 * CatAccPrivilege entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatAccPrivilege extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatAccRole catAccRole;
	private CatAccOperation catAccOperation;
	private Byte active;

	// Constructors

	/** default constructor */
	public CatAccPrivilege() {
	}

	/** full constructor */
	public CatAccPrivilege(CatAccRole catAccRole,
			CatAccOperation catAccOperation, Byte active) {
		this.catAccRole = catAccRole;
		this.catAccOperation = catAccOperation;
		this.active = active;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatAccRole getCatAccRole() {
		return this.catAccRole;
	}

	public void setCatAccRole(CatAccRole catAccRole) {
		this.catAccRole = catAccRole;
	}

	public CatAccOperation getCatAccOperation() {
		return this.catAccOperation;
	}

	public void setCatAccOperation(CatAccOperation catAccOperation) {
		this.catAccOperation = catAccOperation;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}