package com.tongrui.shangweiji.data.server;

import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentFractionState entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentFractionState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stateName;
	private String description;
	private Byte isUpdateByServer;
	private Set tmpTreatmentPlanFractions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentFractionState() {
	}

	/** minimal constructor */
	public TmpTreatmentFractionState(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentFractionState(String stateName, String description,
			Byte isUpdateByServer, Set tmpTreatmentPlanFractions) {
		this.stateName = stateName;
		this.description = description;
		this.isUpdateByServer = isUpdateByServer;
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getIsUpdateByServer() {
		return this.isUpdateByServer;
	}

	public void setIsUpdateByServer(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	public Set getTmpTreatmentPlanFractions() {
		return this.tmpTreatmentPlanFractions;
	}

	public void setTmpTreatmentPlanFractions(Set tmpTreatmentPlanFractions) {
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
	}

}