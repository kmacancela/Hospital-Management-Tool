package com.revature.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.beans.Patient;
import com.revature.beans.Prescription;
import com.revature.beans.Visit;
import com.revature.service.PatientService;

@Component
public class Delegate {

	private PatientService patientService;

	@Autowired
	public void setService(PatientService patientService) {
		this.patientService = patientService;
	}

	public ResponseEntity<Patient> findPatientById(Integer patientId) {
		return patientService.findPatientById(patientId);
	}

	public ResponseEntity<List<Patient>> findAllPatients() {
		return patientService.findAllPatients();
	}

	public ResponseEntity<Patient> savePatient(Patient patient) {
		return patientService.savePatient(patient);
	}

	public ResponseEntity<Visit> getVisitById(Integer visitId) {
		return patientService.getVisitById(visitId);
	}
	
	public ResponseEntity<List<Visit>> findVisitsByUserId(Integer userId){
		return patientService.findVisitsByPatientId(userId);
	}

	public ResponseEntity<List<Visit>> findVisitsByPatientId(Integer patientId){
		return patientService.findVisitsByPatientId(patientId);
	}
	
	public ResponseEntity<Visit> saveVisit(Visit visit){
		return patientService.saveVisit(visit);
	}
	
	public ResponseEntity<Prescription> findPrescriptionById(Integer prescriptionId){
		return patientService.findPrescriptionById(prescriptionId);
	}
	
	public ResponseEntity<List<Prescription>> findPrescriptionsByUserId(Integer userId){
		return patientService.findPrescriptionsByUserId(userId);
	}
	
	public ResponseEntity<List<Prescription>> findPrescriptionsByPatientId(Integer patientId){
		return patientService.findPrescriptionsByPatientId(patientId);
	}
	
	public ResponseEntity<Prescription> savePrescription(Prescription prescription){
		return patientService.savePrescription(prescription);
	}
 	
}
