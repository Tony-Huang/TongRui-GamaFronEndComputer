package com.tongrui.shangweiji.data.server;

import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentCollType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentCollType implements java.io.Serializable {

	// Fields

	private Integer id;
	private Float size;
	private Float outfactor;
	private Byte isUpdateByServer;
	private Set tmpTreatmentPlanFocuses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentCollType() {
	}

	/** minimal constructor */
	public TmpTreatmentCollType(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentCollType(Float size, Float outfactor,
			Byte isUpdateByServer, Set tmpTreatmentPlanFocuses) {
		this.size = size;
		this.outfactor = outfactor;
		this.isUpdateByServer = isUpdateByServer;
		this.tmpTreatmentPlanFocuses = tmpTreatmentPlanFocuses;
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

	public Byte getIsUpdateByServer() {
		return this.isUpdateByServer;
	}

	public void setIsUpdateByServer(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	public Set getTmpTreatmentPlanFocuses() {
		return this.tmpTreatmentPlanFocuses;
	}

	public void setTmpTreatmentPlanFocuses(Set tmpTreatmentPlanFocuses) {
		this.tmpTreatmentPlanFocuses = tmpTreatmentPlanFocuses;
	}

}