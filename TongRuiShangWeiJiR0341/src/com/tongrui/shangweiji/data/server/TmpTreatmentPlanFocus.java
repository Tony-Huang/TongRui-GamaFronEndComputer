package com.tongrui.shangweiji.data.server;

import java.util.Date;

/**
 * TmpTreatmentPlanFocus entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanFocus implements java.io.Serializable {

	// Fields

	private Integer id;
	private TmpTreatmentPlanFraction tmpTreatmentPlanFraction;
	private TmpTreatmentCollType tmpTreatmentCollType;
	private Integer focusNumber;
	private Short enabled;
	private Date focusStartTime;
	private Date focusEndTime;
	private Float planX;
	private Float planY;
	private Float planZ;
	private Float couchX;
	private Float couchY;
	private Float couchZ;
	private Float planCurePeriod;
	private Float curePeriod;
	private Byte isUpdateByServer;
	private Byte isUpdateByUpper;

	// Constructors

	/** default constructor */
	public TmpTreatmentPlanFocus() {
	}

	/** minimal constructor */
	public TmpTreatmentPlanFocus(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentPlanFocus(
			TmpTreatmentPlanFraction tmpTreatmentPlanFraction,
			TmpTreatmentCollType tmpTreatmentCollType, Integer focusNumber,
			Short enabled, Date focusStartTime, Date focusEndTime, Float planX,
			Float planY, Float planZ, Float couchX, Float couchY, Float couchZ,
			Float planCurePeriod, Float curePeriod, Byte isUpdateByServer,
			Byte isUpdateByUpper) {
		this.tmpTreatmentPlanFraction = tmpTreatmentPlanFraction;
		this.tmpTreatmentCollType = tmpTreatmentCollType;
		this.focusNumber = focusNumber;
		this.enabled = enabled;
		this.focusStartTime = focusStartTime;
		this.focusEndTime = focusEndTime;
		this.planX = planX;
		this.planY = planY;
		this.planZ = planZ;
		this.couchX = couchX;
		this.couchY = couchY;
		this.couchZ = couchZ;
		this.planCurePeriod = planCurePeriod;
		this.curePeriod = curePeriod;
		this.isUpdateByServer = isUpdateByServer;
		this.isUpdateByUpper = isUpdateByUpper;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TmpTreatmentPlanFraction getTmpTreatmentPlanFraction() {
		return this.tmpTreatmentPlanFraction;
	}

	public void setTmpTreatmentPlanFraction(
			TmpTreatmentPlanFraction tmpTreatmentPlanFraction) {
		this.tmpTreatmentPlanFraction = tmpTreatmentPlanFraction;
	}

	public TmpTreatmentCollType getTmpTreatmentCollType() {
		return this.tmpTreatmentCollType;
	}

	public void setTmpTreatmentCollType(
			TmpTreatmentCollType tmpTreatmentCollType) {
		this.tmpTreatmentCollType = tmpTreatmentCollType;
	}

	public Integer getFocusNumber() {
		return this.focusNumber;
	}

	public void setFocusNumber(Integer focusNumber) {
		this.focusNumber = focusNumber;
	}

	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
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

	public Byte getIsUpdateByServer() {
		return this.isUpdateByServer;
	}

	public void setIsUpdateByServer(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	public Byte getIsUpdateByUpper() {
		return this.isUpdateByUpper;
	}

	public void setIsUpdateByUpper(Byte isUpdateByUpper) {
		this.isUpdateByUpper = isUpdateByUpper;
	}

}