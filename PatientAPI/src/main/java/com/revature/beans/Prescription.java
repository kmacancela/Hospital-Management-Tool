package com.revature.beans;

import org.springframework.data.annotation.Id;

public class Prescription {

	@Id
	private int prescriptionId;
	private int patientId;
	private int visitId;
	private int userId;
	private int medicineId;
	private int quantity;

	public Prescription() {
		super();
	}

	public Prescription(int prescriptionId, int patientId, int visitId, int userId, int medicineId, int quantity) {
		super();
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.visitId = visitId;
		this.userId = userId;
		this.medicineId = medicineId;
		this.quantity = quantity;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", patientId=" + patientId + ", visitId=" + visitId
				+ ", userId=" + userId + ", medicineId=" + medicineId + ", quantity=" + quantity + "]";
	}

}
