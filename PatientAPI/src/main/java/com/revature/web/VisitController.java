package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Patient;
import com.revature.beans.Prescription;
import com.revature.beans.Visit;
import com.revature.delegate.Delegate;

@RestController
public class VisitController {

	private Delegate delegate;

	@Autowired
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	

	@RequestMapping(value="/patients/id/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> findByPatientId(@PathVariable Integer patientId){
		return delegate.findPatientById(patientId);
	}
	
	@RequestMapping(value="/patients/all",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> findAllPatients(){
		return delegate.findAllPatients();
	}
	
	@RequestMapping(value="/patients/save", method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		return delegate.savePatient(patient);
	}
	
	@RequestMapping(value="/visits/id/{visitId}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> findByVisitId(@PathVariable Integer visitId){
		return delegate.getVisitById(visitId);
	}
	
	@RequestMapping(value="/visits/user/{userId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visit>> findVisitsByUserId(@PathVariable Integer userId){
		return delegate.findVisitsByUserId(userId);
	}
	
	@RequestMapping(value="/visits/patient/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visit>> findVisitsByPatientId(@PathVariable Integer patientId){
		return delegate.findVisitsByPatientId(patientId);
	}
	
	@RequestMapping(value="/visits/save",method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> saveVisit(@RequestBody Visit visit){
		return delegate.saveVisit(visit);
	}
	
	@RequestMapping(value="/prescriptions/id/{prescriptionId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Integer prescriptionId){
		return delegate.findPrescriptionById(prescriptionId);
	}
	
	@RequestMapping(value="/prescriptions/user/{userId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prescription>> findPrescriptionByUserId(@PathVariable Integer userId){
		return delegate.findPrescriptionsByUserId(userId);
	}
	
	@RequestMapping(value="/prescriptions/patient/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prescription>> findPrescriptionByPatientId(@PathVariable Integer patientId){
		return delegate.findPrescriptionsByPatientId(patientId);
	}
	
	@RequestMapping(value="/prescriptions/id/{prescriptionId}",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription){
		return delegate.savePrescription(prescription);
	}	
	
	
}
