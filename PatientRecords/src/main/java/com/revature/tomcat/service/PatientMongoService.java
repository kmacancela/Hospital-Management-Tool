package com.revature.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.tomcat.beans.Patient;
import com.revature.tomcat.data.PatientRepository;

@Service
public class PatientMongoService {

	private PatientRepository repository;

	@Autowired
	public void setRepository(PatientRepository repository) {
		this.repository = repository;
	}
	
	public List<Patient> findAll(){
		return repository.findAll();
	}
	
	public Patient findByPatientId(Integer patientId){
		return repository.findByPatientId(patientId);
	}
	
	public <S extends Patient> S save(S patient){
		return repository.save(patient);
	}
	
	
	
}
