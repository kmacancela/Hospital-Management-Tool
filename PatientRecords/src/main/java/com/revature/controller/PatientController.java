package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Patient;
import com.revature.service.PatientMongoService;

@RestController
public class PatientController {

	private PatientMongoService service;

	@Autowired
	public void setService(PatientMongoService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/patient/all",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>>findAll(){
		return new ResponseEntity<List<Patient>>(service.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/patient/id/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> getByPatientId(@PathVariable Integer patientId){
		return new ResponseEntity<Patient>(service.findByPatientId(patientId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/patient/save",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Patient savePatient(@RequestBody Patient patient){
		return service.save(patient);
		
	}
}
