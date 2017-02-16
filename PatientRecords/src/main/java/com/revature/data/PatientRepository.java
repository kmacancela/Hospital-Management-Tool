package com.revature.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.revature.beans.Patient;



public interface PatientRepository extends MongoRepository<Patient, Integer>{
	
	@Override
	List<Patient> findAll();
	
	Patient findByPatientId(Integer patientId);
	
	@Override
	<S extends Patient> S save(S patient);
	
	//TODO add delete

}
