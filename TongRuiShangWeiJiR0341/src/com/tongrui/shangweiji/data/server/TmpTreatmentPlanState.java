package com.tongrui.shangweiji.data.server;

import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentPlanState entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanState implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stateName;
	private String description;
	private Byte isUpdateByServer;
	private Set tmpTreatmentPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentPlanState() {
	}

	/** minimal constructor */
	public TmpTreatmentPlanState(String stateName, Byte isUpdateByServer) {
		this.stateName = stateName;
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentPlanState(String stateName, String description,
			Byte isUpdateByServer, Set tmpTreatmentPlans) {
		this.stateName = stateName;
		this.description = description;
		this.isUpdateByServer = isUpdateByServer;
		this.tmpTreatmentPlans = tmpTreatmentPlans;
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

	public Set getTmpTreatmentPlans() {
		return this.tmpTreatmentPlans;
	}

	public void setTmpTreatmentPlans(Set tmpTreatmentPlans) {
		this.tmpTreatmentPlans = tmpTreatmentPlans;
	}

}