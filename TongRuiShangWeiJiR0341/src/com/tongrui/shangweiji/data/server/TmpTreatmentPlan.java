package com.tongrui.shangweiji.data.server;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentPlan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlan implements java.io.Serializable {

	// Fields

	private Integer id;
	private TmpTreatmentPlanState tmpTreatmentPlanState;
	private TmpTreatmentPatientCase tmpTreatmentPatientCase;
	private Integer courseNumber;
	private String planName;
	private String diaglose;
	private String treatmentPart;
	private Integer focusCount;
	private Integer fractionCount;
	private Float dose;
	private Float referper;
	private String doctorName;
	private Date planDate;
	private Date planLockDate;
	private Integer serialNumber;
	private String approvalDoctorName;
	private Date approvalDate;
	private Float planX;
	private Float planY;
	private Float planZ;
	private Byte isUpdateByServer;
	private Byte isUpdateByUpper;
	private Set tmpTreatmentPlanFractions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentPlan() {
	}

	/** minimal constructor */
	public TmpTreatmentPlan(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentPlan(TmpTreatmentPlanState tmpTreatmentPlanState,
			TmpTreatmentPatientCase tmpTreatmentPatientCase,
			Integer courseNumber, String planName, String diaglose,
			String treatmentPart, Integer focusCount, Integer fractionCount,
			Float dose, Float referper, String doctorName, Date planDate,
			Date planLockDate, Integer serialNumber, String approvalDoctorName,
			Date approvalDate, Float planX, Float planY, Float planZ,
			Byte isUpdateByServer, Byte isUpdateByUpper,
			Set tmpTreatmentPlanFractions) {
		this.tmpTreatmentPlanState = tmpTreatmentPlanState;
		this.tmpTreatmentPatientCase = tmpTreatmentPatientCase;
		this.courseNumber = courseNumber;
		this.planName = planName;
		this.diaglose = diaglose;
		this.treatmentPart = treatmentPart;
		this.focusCount = focusCount;
		this.fractionCount = fractionCount;
		this.dose = dose;
		this.referper = referper;
		this.doctorName = doctorName;
		this.planDate = planDate;
		this.planLockDate = planLockDate;
		this.serialNumber = serialNumber;
		this.approvalDoctorName = approvalDoctorName;
		this.approvalDate = approvalDate;
		this.planX = planX;
		this.planY = planY;
		this.planZ = planZ;
		this.isUpdateByServer = isUpdateByServer;
		this.isUpdateByUpper = isUpdateByUpper;
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TmpTreatmentPlanState getTmpTreatmentPlanState() {
		return this.tmpTreatmentPlanState;
	}

	public void setTmpTreatmentPlanState(
			TmpTreatmentPlanState tmpTreatmentPlanState) {
		this.tmpTreatmentPlanState = tmpTreatmentPlanState;
	}

	public TmpTreatmentPatientCase getTmpTreatmentPatientCase() {
		return this.tmpTreatmentPatientCase;
	}

	public void setTmpTreatmentPatientCase(
			TmpTreatmentPatientCase tmpTreatmentPatientCase) {
		this.tmpTreatmentPatientCase = tmpTreatmentPatientCase;
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

	public Integer getFractionCount() {
		return this.fractionCount;
	}

	public void setFractionCount(Integer fractionCount) {
		this.fractionCount = fractionCount;
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

	public Set getTmpTreatmentPlanFractions() {
		return this.tmpTreatmentPlanFractions;
	}

	public void setTmpTreatmentPlanFractions(Set tmpTreatmentPlanFractions) {
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
	}

}