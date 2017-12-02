package com.tongrui.shangweiji.data.server;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentPlanFraction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPlanFraction implements java.io.Serializable {

	// Fields

	private Integer id;
	private TmpTreatmentPlan tmpTreatmentPlan;
	private TmpTreatmentPatientCase tmpTreatmentPatientCase;
	private TmpTreatmentFractionState tmpTreatmentFractionState;
	private Integer fractionNomber;
	private Date dueDate;
	private Byte isAppended;
	private String appendDoctorName;
	private String performerName;
	private String notes;
	private Byte isIgrtflag;
	private Float igrtdx;
	private Float igrtdy;
	private Float igrtdz;
	private Integer photoNumber;
	private String imagePath;
	private String register;
	private Byte isUpdateByServer;
	private String isUpdateByUpper;
	private Set tmpTreatmentPlanFocuses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentPlanFraction() {
	}

	/** minimal constructor */
	public TmpTreatmentPlanFraction(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentPlanFraction(TmpTreatmentPlan tmpTreatmentPlan,
			TmpTreatmentPatientCase tmpTreatmentPatientCase,
			TmpTreatmentFractionState tmpTreatmentFractionState,
			Integer fractionNomber, Date dueDate, Byte isAppended,
			String appendDoctorName, String performerName, String notes,
			Byte isIgrtflag, Float igrtdx, Float igrtdy, Float igrtdz,
			Integer photoNumber, String imagePath, String register,
			Byte isUpdateByServer, String isUpdateByUpper,
			Set tmpTreatmentPlanFocuses) {
		this.tmpTreatmentPlan = tmpTreatmentPlan;
		this.tmpTreatmentPatientCase = tmpTreatmentPatientCase;
		this.tmpTreatmentFractionState = tmpTreatmentFractionState;
		this.fractionNomber = fractionNomber;
		this.dueDate = dueDate;
		this.isAppended = isAppended;
		this.appendDoctorName = appendDoctorName;
		this.performerName = performerName;
		this.notes = notes;
		this.isIgrtflag = isIgrtflag;
		this.igrtdx = igrtdx;
		this.igrtdy = igrtdy;
		this.igrtdz = igrtdz;
		this.photoNumber = photoNumber;
		this.imagePath = imagePath;
		this.register = register;
		this.isUpdateByServer = isUpdateByServer;
		this.isUpdateByUpper = isUpdateByUpper;
		this.tmpTreatmentPlanFocuses = tmpTreatmentPlanFocuses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TmpTreatmentPlan getTmpTreatmentPlan() {
		return this.tmpTreatmentPlan;
	}

	public void setTmpTreatmentPlan(TmpTreatmentPlan tmpTreatmentPlan) {
		this.tmpTreatmentPlan = tmpTreatmentPlan;
	}

	public TmpTreatmentPatientCase getTmpTreatmentPatientCase() {
		return this.tmpTreatmentPatientCase;
	}

	public void setTmpTreatmentPatientCase(
			TmpTreatmentPatientCase tmpTreatmentPatientCase) {
		this.tmpTreatmentPatientCase = tmpTreatmentPatientCase;
	}

	public TmpTreatmentFractionState getTmpTreatmentFractionState() {
		return this.tmpTreatmentFractionState;
	}

	public void setTmpTreatmentFractionState(
			TmpTreatmentFractionState tmpTreatmentFractionState) {
		this.tmpTreatmentFractionState = tmpTreatmentFractionState;
	}

	public Integer getFractionNomber() {
		return this.fractionNomber;
	}

	public void setFractionNomber(Integer fractionNomber) {
		this.fractionNomber = fractionNomber;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Byte getIsAppended() {
		return this.isAppended;
	}

	public void setIsAppended(Byte isAppended) {
		this.isAppended = isAppended;
	}

	public String getAppendDoctorName() {
		return this.appendDoctorName;
	}

	public void setAppendDoctorName(String appendDoctorName) {
		this.appendDoctorName = appendDoctorName;
	}

	public String getPerformerName() {
		return this.performerName;
	}

	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Byte getIsIgrtflag() {
		return this.isIgrtflag;
	}

	public void setIsIgrtflag(Byte isIgrtflag) {
		this.isIgrtflag = isIgrtflag;
	}

	public Float getIgrtdx() {
		return this.igrtdx;
	}

	public void setIgrtdx(Float igrtdx) {
		this.igrtdx = igrtdx;
	}

	public Float getIgrtdy() {
		return this.igrtdy;
	}

	public void setIgrtdy(Float igrtdy) {
		this.igrtdy = igrtdy;
	}

	public Float getIgrtdz() {
		return this.igrtdz;
	}

	public void setIgrtdz(Float igrtdz) {
		this.igrtdz = igrtdz;
	}

	public Integer getPhotoNumber() {
		return this.photoNumber;
	}

	public void setPhotoNumber(Integer photoNumber) {
		this.photoNumber = photoNumber;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Byte getIsUpdateByServer() {
		return this.isUpdateByServer;
	}

	public void setIsUpdateByServer(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	public String getIsUpdateByUpper() {
		return this.isUpdateByUpper;
	}

	public void setIsUpdateByUpper(String isUpdateByUpper) {
		this.isUpdateByUpper = isUpdateByUpper;
	}

	public Set getTmpTreatmentPlanFocuses() {
		return this.tmpTreatmentPlanFocuses;
	}

	public void setTmpTreatmentPlanFocuses(Set tmpTreatmentPlanFocuses) {
		this.tmpTreatmentPlanFocuses = tmpTreatmentPlanFocuses;
	}

}