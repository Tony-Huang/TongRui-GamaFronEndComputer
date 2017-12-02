package com.tongrui.shangweiji.data;

import java.util.HashSet;
import java.util.Set;

/**
 * CatTreatmentFractionState entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentFractionState extends
		com.tongrui.shangweiji.data.Entity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stateName;
	private String description;
	private Set catTreatmentPlanFractions = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatTreatmentFractionState() {
	}

	/** full constructor */
	public CatTreatmentFractionState(Integer id,String stateName, String description,
			Set catTreatmentPlanFractions) {
                this.id = id;
		this.stateName = stateName;
		this.description = description;
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
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

	public Set getCatTreatmentPlanFractions() {
		return this.catTreatmentPlanFractions;
	}

	public void setCatTreatmentPlanFractions(Set catTreatmentPlanFractions) {
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
	}
        
        public  String toString(){
         return this.stateName;
        }

}