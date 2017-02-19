package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Patient;
import com.revature.beans.Visit;

@Service
public class PatientService {
	
	private EurekaClient discoveryClient;
	private String id;
	@Autowired
	public void setDiscoveryClient(EurekaClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}
	
	public ResponseEntity<Patient> findPatientById(Integer patientId){
		RestTemplate restTemplate = new RestTemplate();
		
		Application application = discoveryClient.getApplication("patient");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo patientInstanceInfo = list.get(0);
		
		String host = "http://"+ patientInstanceInfo.getHostName()+":"+patientInstanceInfo.getPort()+"/";
		final String URI = UriComponentsBuilder.fromHttpUrl(host).path("patient/id/").path(patientId.toString()).build().toString();
		
		Patient patient = null;
		ResponseEntity<Patient> response = null;
		
		try{
			response= restTemplate.getForEntity(URI, Patient.class);
			patient = response.getBody();
		}
		catch(RuntimeException e){
			response = new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
	
	public ResponseEntity<Visit> getVisitById(Integer visitId){
		RestTemplate restTemplate = new RestTemplate();
		
		Application application = discoveryClient.getApplication("visit");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo visitInstanceinfo = list.get(0);
		
		String visitHost = "http://"+visitInstanceinfo.getHostName()+":"+visitInstanceinfo.getPort()+"/";
		final String URI = UriComponentsBuilder.fromHttpUrl(visitHost).path("visit/id/")
				.path(visitId.toString()).build().toString();
		ResponseEntity<Visit> response = null;
		Visit visit = null;
		try{
			response= restTemplate.getForEntity(URI, Visit.class);
			visit = response.getBody();
		}
		catch(RuntimeException e){
			response  = new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Visit>(visit,HttpStatus.OK);
		
	}
	
	

}
