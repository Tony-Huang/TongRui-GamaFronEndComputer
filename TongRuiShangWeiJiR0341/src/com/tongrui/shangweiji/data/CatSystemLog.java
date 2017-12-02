package com.tongrui.shangweiji.data;

import java.util.Date;

/**
 * CatSystemLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CatSystemLog extends com.tongrui.shangweiji.data.Entity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private CatSystemLogLevel catSystemLogLevel;
	private String logMessage;
	private String operator;
	private String notes;
	private String patientId;
	private String patientName;
	private Date happenTime;

	// Constructors

	/** default constructor */
	public CatSystemLog() {
	}

	/** full constructor */
	public CatSystemLog(CatSystemLogLevel catSystemLogLevel, String logMessage,
			String operator, String notes, String patientId,
			String patientName, Date happenTime) {
		this.catSystemLogLevel = catSystemLogLevel;
		this.logMessage = logMessage;
		this.operator = operator;
		this.notes = notes;
		this.patientId = patientId;
		this.patientName = patientName;
		this.happenTime = happenTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatSystemLogLevel getCatSystemLogLevel() {
		return this.catSystemLogLevel;
	}

	public void setCatSystemLogLevel(CatSystemLogLevel catSystemLogLevel) {
		this.catSystemLogLevel = catSystemLogLevel;
	}

	public String getLogMessage() {
		return this.logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getHappenTime() {
		return this.happenTime;
	}

	public void setHappenTime(Date happenTime) {
		this.happenTime = happenTime;
	}

}