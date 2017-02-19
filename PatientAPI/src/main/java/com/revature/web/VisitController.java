package com.revature.web;

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
	
	@RequestMapping(value="/visits/id/{visitId}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> findByVisitId(@PathVariable Integer visitId){
		return delegate.getVisitById(visitId);
	}
	
	@RequestMapping(value="/patients/id/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> findByPatientId(@PathVariable Integer patientId){
		return delegate.findPatientById(patientId);
	}
	
}
