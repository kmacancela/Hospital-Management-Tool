package com.revature.data;

import com.revature.beans.Clinic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Sibrian on 2/16/17.
 */
public interface ClinicRepository extends MongoRepository<Clinic, Integer> {

    //Save a new User
    @Override
    <S extends Clinic>S save (S User);

    //Get all Users
    @Override
    List<Clinic> findAll();

    //Get by Id
    @Override
    Clinic findOne(Integer integer);

    Clinic findByClinicName(String lName);

    /*
    ADD MORE AS NEEDED
     */
}
