package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Patient;
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
	
	@RequestMapping(value="/visits/id/{visitId}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> findByVisitId(@PathVariable Integer visitId){
		return delegate.getVisitById(visitId);
	}
	
	@RequestMapping(value="/visits/user/{userId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visit>> findVisitByUserId(@PathVariable Integer userId){
		return delegate.findVisitByUserId(userId);
	}
	
	
}
