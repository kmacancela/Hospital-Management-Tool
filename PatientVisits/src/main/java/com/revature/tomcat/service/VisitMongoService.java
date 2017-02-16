package com.revature.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Visit;
import com.revature.data.VisitRepository;

@Service
public class VisitMongoService {

	private VisitRepository repository;

	@Autowired
	public void setRepository(VisitRepository repository) {
		this.repository = repository;
	}

	public <S extends Visit> S save(S visit) {
		return repository.save(visit);
	}

	public Visit findByVisitId(Integer visitId) {
		return repository.findByVisitId(visitId);
	}

	public List<Visit> findByPatientId(int patientId) {
		return repository.findByPatientId(patientId);
	}

	public List<Visit> findByUserId(int userId) {
		return repository.findByUserId(userId);
	}

}
