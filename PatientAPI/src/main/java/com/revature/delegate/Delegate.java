package com.revature.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.beans.Patient;
import com.revature.beans.Visit;
import com.revature.service.PatientService;

@Component
public class Delegate {

	private PatientService patientService;

	@Autowired
	public void setService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public ResponseEntity<Visit> getVisitById(Integer visitId){return patientService.getVisitById(visitId);}
	
	public ResponseEntity<Patient> findPatientById(Integer patientId){return patientService.findPatientById(patientId);}
	
	
	
	
}
