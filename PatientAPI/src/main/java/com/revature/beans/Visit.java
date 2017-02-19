package com.revature.beans;

//import org.springframework.data.annotation.Id;

public class Visit {

	//@Id
	private int visitId;
	private int patientId;
	private int userId;
	private String date;
	private int weight;
	private String bloodPressure;
	private int heartRate;
	private String visitReason;
	private String diagnosis;

	public Visit() {
		super();
	}

	public Visit(int visitId, int patientId, int userId, String date, int weight, String bloodPressure, int heartRate,
			String visitReason, String diagnosis) {
		super();
		this.visitId = visitId;
		this.patientId = patientId;
		this.userId = userId;
		this.date = date;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;
		this.visitReason = visitReason;
		this.diagnosis = diagnosis;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Visit [visitId=" + visitId + ", patientId=" + patientId + ", userId=" + userId + ", date=" + date
				+ ", weight=" + weight + ", bloodPressure=" + bloodPressure + ", heartRate=" + heartRate
				+ ", visitReason=" + visitReason + ", diagnosis=" + diagnosis + "]";
	}

}
