package com.revature.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.revature.beans.Prescription;

public interface PrescriptionRepository extends MongoRepository<Prescription, Integer> {

	<S extends Prescription> S save (S prescription);
	
	Prescription findByPrescriptionId(Integer prescriptionId);
	
	List<Prescription> findByPatientId(int patientId);
	
	List<Prescription> findByUserId(int userId);
	
	//TODO add delete

	//TODO add create
}
