package com.tongrui.shangweiji.data;

import java.util.Date;

/**
 * CatTreatmentPlanFocus entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanFocus extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatTreatmentPlanFraction catTreatmentPlanFraction;
	private Integer focusNumber;
	private Date focusStartTime;
	private Date focusEndTime;
	private Float planX;
	private Float planY;
	private Float planZ;
	private Float couchX;
	private Float couchY;
	private Float couchZ;
	private Integer collType;
	private Float planCurePeriod;
	private Float curePeriod;

        private Short enabled;
	// Constructors

	/** default constructor */
	public CatTreatmentPlanFocus() {
	}

	/** full constructor */
	public CatTreatmentPlanFocus(
			CatTreatmentPlanFraction catTreatmentPlanFraction,
			Integer focusNumber, Date focusStartTime, Date focusEndTime,
			Float planX, Float planY, Float planZ, Float couchX, Float couchY,
			Float couchZ, Integer collType, Float planCurePeriod, Float curePeriod) {
		this.catTreatmentPlanFraction = catTreatmentPlanFraction;
		this.focusNumber = focusNumber;
		this.focusStartTime = focusStartTime;
		this.focusEndTime = focusEndTime;
		this.planX = planX;
		this.planY = planY;
		this.planZ = planZ;
		this.couchX = couchX;
		this.couchY = couchY;
		this.couchZ = couchZ;
		this.collType = collType;
		this.planCurePeriod = planCurePeriod;
		this.curePeriod = curePeriod;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatTreatmentPlanFraction getCatTreatmentPlanFraction() {
		return this.catTreatmentPlanFraction;
	}

	public void setCatTreatmentPlanFraction(
			CatTreatmentPlanFraction catTreatmentPlanFraction) {
		this.catTreatmentPlanFraction = catTreatmentPlanFraction;
	}

	public Integer getFocusNumber() {
		return this.focusNumber;
	}

	public void setFocusNumber(Integer focusNumber) {
		this.focusNumber = focusNumber;
	}

	public Date getFocusStartTime() {
		return this.focusStartTime;
	}

	public void setFocusStartTime(Date focusStartTime) {
		this.focusStartTime = focusStartTime;
	}

	public Date getFocusEndTime() {
		return this.focusEndTime;
	}

	public void setFocusEndTime(Date focusEndTime) {
		this.focusEndTime = focusEndTime;
	}

	public Float getPlanX() {
		return this.planX;
	}

	public void setPlanX(Float planX) {
		this.planX = planX;
	}

	public Float getPlanY() {
		return this.planY;
	}

	public void setPlanY(Float planY) {
		this.planY = planY;
	}

	public Float getPlanZ() {
		return this.planZ;
	}

	public void setPlanZ(Float planZ) {
		this.planZ = planZ;
	}

	public Float getCouchX() {
		return this.couchX;
	}

	public void setCouchX(Float couchX) {
		this.couchX = couchX;
	}

	public Float getCouchY() {
		return this.couchY;
	}

	public void setCouchY(Float couchY) {
		this.couchY = couchY;
	}

	public Float getCouchZ() {
		return this.couchZ;
	}

	public void setCouchZ(Float couchZ) {
		this.couchZ = couchZ;
	}

	public Integer getCollType() {
		return this.collType;
	}

	public void setCollType(Integer collType) {
		this.collType = collType;
	}

	public Float getPlanCurePeriod() {
		return this.planCurePeriod;
	}

	public void setPlanCurePeriod(Float planCurePeriod) {
		this.planCurePeriod = planCurePeriod;
	}

	public Float getCurePeriod() {
		return this.curePeriod;
	}

	public void setCurePeriod(Float curePeriod) {
		this.curePeriod = curePeriod;
	}

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }
        
        

}