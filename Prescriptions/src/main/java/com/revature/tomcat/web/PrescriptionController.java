package com.revature.tomcat.web;

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

import com.revature.beans.Prescription;
import com.revature.tomcat.service.PrescriptionMongoService;

@RestController
public class PrescriptionController {

	private PrescriptionMongoService service;

	@Autowired
	public void setService(PrescriptionMongoService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value="/prescription/id/{prescriptionId}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Prescription> findByPrescriptionId(@PathVariable Integer prescriptionId){
		return new ResponseEntity<Prescription>(service.findByPrescriptionId(prescriptionId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/prescription/user/{userId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prescription>> findByUserId(@PathVariable int userId){
		return new ResponseEntity<List<Prescription>>(service.findByUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/prescription/patient/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prescription>> findByPatientId(@PathVariable int patientId){
		return new ResponseEntity<List<Prescription>>(service.findByPatientId(patientId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/prescription/save",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Prescription savePrescription(@RequestBody Prescription prescription){
		return service.save(prescription);
	}
}
