package com.tongrui.shangweiji.data.server;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TmpTreatmentPatientCase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TmpTreatmentPatientCase implements java.io.Serializable {

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
	private Byte isUpdateByServer;
	private Set tmpTreatmentPlanFractions = new HashSet(0);
	private Set tmpTreatmentPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public TmpTreatmentPatientCase() {
	}

	/** minimal constructor */
	public TmpTreatmentPatientCase(String patientId, Byte isUpdateByServer) {
		this.patientId = patientId;
		this.isUpdateByServer = isUpdateByServer;
	}

	/** full constructor */
	public TmpTreatmentPatientCase(String name, String patientId, Byte sex,
			Integer age, Integer height, Integer weight, Date birthDay,
			String address, String phone, String notes, Byte isUpdateByServer,
			Set tmpTreatmentPlanFractions, Set tmpTreatmentPlans) {
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
		this.isUpdateByServer = isUpdateByServer;
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
		this.tmpTreatmentPlans = tmpTreatmentPlans;
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

	public Byte getIsUpdateByServer() {
		return this.isUpdateByServer;
	}

	public void setIsUpdateByServer(Byte isUpdateByServer) {
		this.isUpdateByServer = isUpdateByServer;
	}

	public Set getTmpTreatmentPlanFractions() {
		return this.tmpTreatmentPlanFractions;
	}

	public void setTmpTreatmentPlanFractions(Set tmpTreatmentPlanFractions) {
		this.tmpTreatmentPlanFractions = tmpTreatmentPlanFractions;
	}

	public Set getTmpTreatmentPlans() {
		return this.tmpTreatmentPlans;
	}

	public void setTmpTreatmentPlans(Set tmpTreatmentPlans) {
		this.tmpTreatmentPlans = tmpTreatmentPlans;
	}

}