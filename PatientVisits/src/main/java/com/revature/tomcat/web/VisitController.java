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

import com.revature.beans.Visit;
import com.revature.tomcat.service.VisitMongoService;

@RestController
public class VisitController {

	private VisitMongoService service;

	@Autowired
	public void setService(VisitMongoService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/visit/id/{visitId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> findByVisitId(@PathVariable int visitId){
		return new ResponseEntity<Visit>(service.findByVisitId(visitId),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/visit/user/{userId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visit>> findByUserId(@PathVariable int userId){
		return new ResponseEntity<List<Visit>>(service.findByUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/visit/patient/{patientId}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visit>> findByPatientId(@PathVariable int patientId){
		return new ResponseEntity<List<Visit>>(service.findByPatientId(patientId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/visit/save",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visit> saveVisit(@RequestBody Visit visit){
		return new ResponseEntity<Visit>(service.save(visit),HttpStatus.OK);
	}
	
	
}
