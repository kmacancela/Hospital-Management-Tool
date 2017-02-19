package com.revature.service;

import com.revature.beans.Prescription;
import com.revature.data.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionMongoService {

	private PrescriptionRepository repository;

	@Autowired
	public void setRepository(PrescriptionRepository repository) {
		this.repository = repository;
	}

	public Prescription findByPrescriptionId(Integer prescriptionId) {
		return repository.findByPrescriptionId(prescriptionId);
	}

	public List<Prescription> findByUserId(int userId) {
		return repository.findByUserId(userId);
	}

	public List<Prescription> findByPatientId(int patientId) {
		return repository.findByPatientId(patientId);
	}
	
	public <S extends Prescription> S save(S prescription){
		return repository.save(prescription);
	}
	
	public void deletePrescription(Integer prescriptionId){
		repository.delete(prescriptionId);
	}

}
