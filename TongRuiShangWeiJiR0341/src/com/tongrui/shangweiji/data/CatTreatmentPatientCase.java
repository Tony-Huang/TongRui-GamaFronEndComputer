package com.tongrui.shangweiji.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CatTreatmentPatientCase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatTreatmentPatientCase extends com.tongrui.shangweiji.data.Entity
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String patientId;
	private Byte sex;
	private Integer age;
	private Integer height;
	private Integer weight;
	private Date birthDay;
	private String address;
	private String phone;
	private String notes;
	private Set catTreatmentPlans = new HashSet(0);
	private Set catTreatmentPlanFractions = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatTreatmentPatientCase() {
	}

	/** minimal constructor */
	public CatTreatmentPatientCase(String patientId) {
		this.patientId = patientId;
	}

	/** full constructor */
	public CatTreatmentPatientCase(String name, String patientId, Byte sex,
			Integer age, Integer height, Integer weight, Date birthDay,
			String address, String phone, String notes, Set catTreatmentPlans,
			Set catTreatmentPlanFractions) {
		this.name = name;
		this.patientId = patientId;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.birthDay = birthDay;
		this.address = address;
		this.phone = phone;
		this.notes = notes;
		this.catTreatmentPlans = catTreatmentPlans;
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Byte getSex() {
		return this.sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set getCatTreatmentPlans() {
		return this.catTreatmentPlans;
	}

	public void setCatTreatmentPlans(Set catTreatmentPlans) {
		this.catTreatmentPlans = catTreatmentPlans;
	}

	public Set getCatTreatmentPlanFractions() {
		return this.catTreatmentPlanFractions;
	}

	public void setCatTreatmentPlanFractions(Set catTreatmentPlanFractions) {
		this.catTreatmentPlanFractions = catTreatmentPlanFractions;
	}

}