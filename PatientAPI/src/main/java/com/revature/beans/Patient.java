package com.revature.beans;

import java.util.List;
import java.util.Map;
import org.springframework.data.annotation.Id;

public class Patient {

	@Id
	private int patientId;
	private String patientFirstName;
	private String patientLastName;
	private String phoneNumber;
	private List<String> medicalHistory;
	private Map<String, String> pastVisits;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientFirstName, String patientLastName, String phoneNumber,
			List<String> medicalHistory, Map<String, String> pastVisits) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.phoneNumber = phoneNumber;
		this.medicalHistory = medicalHistory;
		this.pastVisits = pastVisits;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(List<String> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Map<String, String> getPastVisits() {
		return pastVisits;
	}

	public void setPastVisits(Map<String, String> pastVisits) {
		this.pastVisits = pastVisits;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", phoneNumber=" + phoneNumber + ", medicalHistory=" + medicalHistory
				+ ", pastVisits=" + pastVisits + "]";
	}

	
}
