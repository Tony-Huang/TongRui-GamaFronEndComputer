package com.tongrui.shangweiji.data;

/**
 * CatTreatmentCollType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentCollType extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {
	// Fields

	private Integer id;
	private Float size;
	private Float outfactor;

	// Constructors

	/** default constructor */
	public CatTreatmentCollType() {
	}

	/** full constructor */
	public CatTreatmentCollType(Integer id, Float size, Float outfactor) {
                this.id = id;
		this.size = size;
		this.outfactor = outfactor;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getSize() {
		return this.size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public Float getOutfactor() {
		return this.outfactor;
	}

	public void setOutfactor(Float outfactor) {
		this.outfactor = outfactor;
	}

}