package com.tongrui.shangweiji.data;

/**
 * CatAccUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatAccUser extends com.tongrui.shangweiji.data.Entity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private CatAccRole catAccRole;
	private String userName;
	private String password;
	private String description;
	private Byte active;

	// Constructors

	/** default constructor */
	public CatAccUser() {
	}

	/** minimal constructor */
	public CatAccUser(String userName, String password, Byte active) {
		this.userName = userName;
		this.password = password;
		this.active = active;
	}

	/** full constructor */
	public CatAccUser(CatAccRole catAccRole, String userName, String password,
			String description, Byte active) {
		this.catAccRole = catAccRole;
		this.userName = userName;
		this.password = password;
		this.description = description;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

}