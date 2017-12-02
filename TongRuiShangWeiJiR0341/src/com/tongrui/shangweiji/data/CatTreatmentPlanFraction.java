package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatTreatmentPlanFraction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPlanFraction extends
		com.tongrui.shangweiji.data.Entity implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatTreatmentPlan catTreatmentPlan;
	private CatTreatmentPatientCase catTreatmentPatientCase;
	private CatTreatmentFractionState catTreatmentFractionState;
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
	private String imagePath;
	private String register;
	private Set catTreatmentPlanFocuses = new HashSet(0);
        
        private Integer photoNumber;

	// Constructors

	/** default constructor */
	public CatTreatmentPlanFraction() {
	}

	/** full constructor */
	public CatTreatmentPlanFraction(CatTreatmentPlan catTreatmentPlan,
			CatTreatmentPatientCase catTreatmentPatientCase,
			CatTreatmentFractionState catTreatmentFractionState,
			Integer fractionNomber, Date dueDate, Byte isAppended,
			String appendDoctorName, String performerName, String notes,
			Byte isIgrtflag, Float igrtdx, Float igrtdy, Float igrtdz,
			String imagePath, String register, Set catTreatmentPlanFocuses) {
		this.catTreatmentPlan = catTreatmentPlan;
		this.catTreatmentPatientCase = catTreatmentPatientCase;
		this.catTreatmentFractionState = catTreatmentFractionState;
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
		this.imagePath = imagePath;
		this.register = register;
		this.catTreatmentPlanFocuses = catTreatmentPlanFocuses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatTreatmentPlan getCatTreatmentPlan() {
		return this.catTreatmentPlan;
	}

	public void setCatTreatmentPlan(CatTreatmentPlan catTreatmentPlan) {
		this.catTreatmentPlan = catTreatmentPlan;
	}

	public CatTreatmentPatientCase getCatTreatmentPatientCase() {
		return this.catTreatmentPatientCase;
	}

	public void setCatTreatmentPatientCase(
			CatTreatmentPatientCase catTreatmentPatientCase) {
		this.catTreatmentPatientCase = catTreatmentPatientCase;
	}

	public CatTreatmentFractionState getCatTreatmentFractionState() {
		return this.catTreatmentFractionState;
	}

	public void setCatTreatmentFractionState(
			CatTreatmentFractionState catTreatmentFractionState) {
		this.catTreatmentFractionState = catTreatmentFractionState;
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

	public Set getCatTreatmentPlanFocuses() {
		return this.catTreatmentPlanFocuses;
	}

	public void setCatTreatmentPlanFocuses(Set catTreatmentPlanFocuses) {
		this.catTreatmentPlanFocuses = catTreatmentPlanFocuses;
	}

    public Integer getPhotoNumber() {
        return photoNumber;
    }

    public void setPhotoNumber(Integer photoNumber) {
        this.photoNumber = photoNumber;
    }

}