package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatTreatmentPlanState entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanState extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stateName;
	private String description;
	private Set catTreatmentPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatTreatmentPlanState() {
	}

	/** minimal constructor */
	public CatTreatmentPlanState(Integer id,String stateName) {
                this.id = id;
		this.stateName = stateName;
	}

	/** full constructor */
	public CatTreatmentPlanState(Integer id,String stateName, String description,
			Set catTreatmentPlans) {
                this.id = id;
		this.stateName = stateName;
		this.description = description;
		this.catTreatmentPlans = catTreatmentPlans;
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

	public Set getCatTreatmentPlans() {
		return this.catTreatmentPlans;
	}

	public void setCatTreatmentPlans(Set catTreatmentPlans) {
		this.catTreatmentPlans = catTreatmentPlans;
	}

}