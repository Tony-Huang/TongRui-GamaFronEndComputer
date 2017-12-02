package com.tongrui.shangweiji.data;

import java.util.Date;

/**
 * CatDeviceparamValueHistory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatDeviceparamValueHistory extends
		com.tongrui.shangweiji.data.Entity implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatDeviceparamValue catDeviceparamValue;
	private String name;
	private Float value;
	private Float uplimit;
	private Float lowlimit;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
        private Byte used;

    public Byte getUsed() {
        return used;
    }

    public void setUsed(Byte used) {
        this.used = used;
    }

	// Constructors

	/** default constructor */
	public CatDeviceparamValueHistory() {
	}

	/** minimal constructor */
	public CatDeviceparamValueHistory(CatDeviceparamValue catDeviceparamValue) {
		this.catDeviceparamValue = catDeviceparamValue;
	}

	/** full constructor */
	public CatDeviceparamValueHistory(CatDeviceparamValue catDeviceparamValue,
			String name, Float value, Float uplimit, Float lowlimit,
			Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
		this.catDeviceparamValue = catDeviceparamValue;
		this.name = name;
		this.value = value;
		this.uplimit = uplimit;
		this.lowlimit = lowlimit;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatDeviceparamValue getCatDeviceparamValue() {
		return this.catDeviceparamValue;
	}

	public void setCatDeviceparamValue(CatDeviceparamValue catDeviceparamValue) {
		this.catDeviceparamValue = catDeviceparamValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getUplimit() {
		return this.uplimit;
	}

	public void setUplimit(Float uplimit) {
		this.uplimit = uplimit;
	}

	public Float getLowlimit() {
		return this.lowlimit;
	}

	public void setLowlimit(Float lowlimit) {
		this.lowlimit = lowlimit;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}