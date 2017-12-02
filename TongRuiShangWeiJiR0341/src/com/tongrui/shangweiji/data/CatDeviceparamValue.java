package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatDeviceparamValue entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatDeviceparamValue extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatDeviceparamType catDeviceparamType;
	private Byte used;
	private String name;
	private Float position;     //
	private Float value;        //
	private Float value2;       //
	private Float uplimit;
	private Float lowlimit;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	private Set catDeviceparamValueHistories = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatDeviceparamValue() {
	}

	/** minimal constructor */
	public CatDeviceparamValue(Byte used, String name) {
		this.used = used;
		this.name = name;
	}

	/** full constructor */
	public CatDeviceparamValue(CatDeviceparamType catDeviceparamType,
			Byte used, String name, Float value, Float uplimit, Float lowlimit,
			Date createdOn, String createdBy, Date modifiedOn,
			String modifiedBy, Set catDeviceparamValueHistories,
                        Float position, Float value2) {
		this.catDeviceparamType = catDeviceparamType;
		this.used = used;
		this.name = name;
		this.position = position;
		this.value = value;
		this.value2 = value2;
		this.uplimit = uplimit;
		this.lowlimit = lowlimit;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.catDeviceparamValueHistories = catDeviceparamValueHistories;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatDeviceparamType getCatDeviceparamType() {
		return this.catDeviceparamType;
	}

	public void setCatDeviceparamType(CatDeviceparamType catDeviceparamType) {
		this.catDeviceparamType = catDeviceparamType;
	}

	public Byte getUsed() {
		return this.used;
	}

	public void setUsed(Byte used) {
		this.used = used;
	}

	public String getName() {
		return this.name;
	}

    public Float getPosition() {
        return position;
    }

    public void setPosition(Float position) {
        this.position = position;
    }

    public Float getValue2() {
        return value2;
    }

    public void setValue2(Float value2) {
        this.value2 = value2;
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

	public Set getCatDeviceparamValueHistories() {
		return this.catDeviceparamValueHistories;
	}

	public void setCatDeviceparamValueHistories(Set catDeviceparamValueHistories) {
		this.catDeviceparamValueHistories = catDeviceparamValueHistories;
	}

}