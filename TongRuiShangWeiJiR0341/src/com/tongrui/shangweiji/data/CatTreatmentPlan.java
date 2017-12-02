package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatTreatmentPlan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlan extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatTreatmentPlanState catTreatmentPlanState;
	private CatTreatmentPatientCase catTreatmentPatientCase;
	private Integer courseNumber;
	private String planName;
	private String diaglose;
	private String treatmentPart;
	private Integer focusCount;
	private Float dose;
	private Float referper;
	private String doctorName;
	private Date planDate;
	private Date planLockDate;
	private Integer serialNumber;
	private String approvalDoctorName;
	private Date approvalDate;
	private Set catTreatmentPlanFractions = new HashSet(0);
        
        private Integer fractionCount;

	// Constructors

	/** default constructor */
	public CatTreatmentPlan() {
	}

	/** full constructor */
	public CatTreatmentPlan(CatTreatmentPlanState catTreatmentPlanState,
			CatTreatmentPatientCase catTreatmentPatientCase,
			Integer courseNumber, String planName, String diaglose,
			String treatmentPart, Integer focusCount, Float dose,
			Float referper, String doctorName, Date planDate,
			Date planLockDate, Integer serialNumber, String approvalDoctorName,
			Date approvalDate, Set catTreatmentPlanFractions) {
		this.catTreatmentPlanState = catTreatmentPlanState;
		this.catTreatmentPatientCase = catTreatmentPatientCase;
		this.courseNumber = courseNumber;
		this.planName = planName;
		this.diaglose = diaglose;
		this.treatmentPart = treatmentPart;
		this.focusCount = focusCount;
		this.dose = dose;
		this.referper = referper;
		this.doctorName = doctorName;
		this.planDate = planDate;
		this.planLockDate = planLockDate;
		this.serialNumber = serialNumber;
		this.approvalDoctorName = approvalDoctorName;
		this.approvalDate = approvalDate;
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatTreatmentPlanState getCatTreatmentPlanState() {
		return this.catTreatmentPlanState;
	}

	public void setCatTreatmentPlanState(
			CatTreatmentPlanState catTreatmentPlanState) {
		this.catTreatmentPlanState = catTreatmentPlanState;
	}

	public CatTreatmentPatientCase getCatTreatmentPatientCase() {
		return this.catTreatmentPatientCase;
	}

	public void setCatTreatmentPatientCase(
			CatTreatmentPatientCase catTreatmentPatientCase) {
		this.catTreatmentPatientCase = catTreatmentPatientCase;
	}

	public Integer getCourseNumber() {
		return this.courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDiaglose() {
		return this.diaglose;
	}

	public void setDiaglose(String diaglose) {
		this.diaglose = diaglose;
	}

	public String getTreatmentPart() {
		return this.treatmentPart;
	}

	public void setTreatmentPart(String treatmentPart) {
		this.treatmentPart = treatmentPart;
	}

	public Integer getFocusCount() {
		return this.focusCount;
	}

	public void setFocusCount(Integer focusCount) {
		this.focusCount = focusCount;
	}

	public Float getDose() {
		return this.dose;
	}

	public void setDose(Float dose) {
		this.dose = dose;
	}

	public Float getReferper() {
		return this.referper;
	}

	public void setReferper(Float referper) {
		this.referper = referper;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getPlanLockDate() {
		return this.planLockDate;
	}

	public void setPlanLockDate(Date planLockDate) {
		this.planLockDate = planLockDate;
	}

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getApprovalDoctorName() {
		return this.approvalDoctorName;
	}

	public void setApprovalDoctorName(String approvalDoctorName) {
		this.approvalDoctorName = approvalDoctorName;
	}

	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Set getCatTreatmentPlanFractions() {
		return this.catTreatmentPlanFractions;
	}

	public void setCatTreatmentPlanFractions(Set catTreatmentPlanFractions) {
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
	}

    public Integer getFractionCount() {
        return fractionCount;
    }

    public void setFractionCount(Integer fractionCount) {
        this.fractionCount = fractionCount;
    }
        
        

}