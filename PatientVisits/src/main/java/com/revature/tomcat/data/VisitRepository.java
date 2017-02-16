package com.revature.tomcat.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.revature.tomcat.beans.Visit;

public interface VisitRepository extends MongoRepository<Visit, Integer>{
	
	<S extends Visit> S save (S visit);
	
	Visit findByVisitId(Integer visitId);
	
	List<Visit> findByPatientId(Integer patientId);

	List<Visit> findByUserId(Integer userId);
	
	//TODO add create and delete
	

}
