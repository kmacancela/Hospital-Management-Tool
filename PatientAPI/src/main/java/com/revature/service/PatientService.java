package com.revature.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
//*********************************Patient Code*******************************************//
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
	
	public ResponseEntity<List<Patient>> findAllPatients(){
		RestTemplate restTemplate = new RestTemplate();
		Application application = discoveryClient.getApplication("patient");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo patientInstanceInfo = list.get(0);
		String host = "http://"+patientInstanceInfo.getHostName()+":"+patientInstanceInfo.getPort()+"/";
		final String URI = UriComponentsBuilder.fromHttpUrl(host).path("patient/all").build().toString();
		ResponseEntity<Patient[]> response = null;
		List<Patient> patients = new ArrayList<Patient>();
		
		try{
			response = restTemplate.getForEntity(URI, Patient[].class);
			patients = Arrays.asList(response.getBody());
		}catch(RuntimeException e){
			response = new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Patient> savePatient(Patient patient){
		RestTemplate restTemplate = new RestTemplate();
		Application application = discoveryClient.getApplication("patient");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo patientInstanceInfo = list.get(0);
		
		String host = "http://"+patientInstanceInfo.getHostName()+":"+patientInstanceInfo.getPort()+"/";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Patient> response = new HttpEntity<Patient>(patient,headers);
		final String URI = UriComponentsBuilder.fromHttpUrl(host).path("patient/save").build().toString();
		ResponseEntity<Patient> patientResponse = restTemplate.exchange(URI, HttpMethod.PUT, response, Patient.class);
		return patientResponse;
	}
	
	//************************************Visit Code ***************************************************//
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
			response  = new ResponseEntity<Visit>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Visit>(visit,HttpStatus.OK);
	}
	
	public ResponseEntity<List<Visit>> findVisitsByUserId(Integer userId){
		RestTemplate restTemplate = new RestTemplate();
		Application application = discoveryClient.getApplication("visit");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo visitInstanceInfo = list.get(0);
		
		String host = "http://"+visitInstanceInfo.getHostName()+":"+visitInstanceInfo.getPort()+"/";
		final String URI = UriComponentsBuilder.fromHttpUrl(host).path("visit/user/")
				.path(userId.toString()).build().toString();
		ResponseEntity<Visit[]> response = null;
		List<Visit>  visits = new ArrayList<Visit>();
		try{
			response = restTemplate.getForEntity(URI, Visit[].class);
			visits = Arrays.asList(response.getBody());
		}catch(Exception e){
			response  = new ResponseEntity<Visit[]>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Visit>>(visits, HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<Visit>> findVisitsByPatientId(Integer patientId){
		RestTemplate restTemplate = new RestTemplate();
		Application application = discoveryClient.getApplication("visit");
		List<InstanceInfo> list = application.getInstances();
		
		InstanceInfo visitInstanceInfo = list.get(0);
		
		String host = "http://"+visitInstanceInfo.getHostName()+":"+visitInstanceInfo.getPort()+"/";
		final String URI = UriComponentsBuilder.fromHttpUrl(host).path("visit/patient/")
				.path(patientId.toString()).build().toString();
		ResponseEntity<Visit[]> response = null;
		List<Visit> visits = new ArrayList<Visit>();
		try{
			response = restTemplate.getForEntity(URI, Visit[].class);
			visits = Arrays.asList(response.getBody());
		}catch (RuntimeException e){
			response = new ResponseEntity<Visit[]>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Visit>>(visits, HttpStatus.OK);
	}
	
	

}
