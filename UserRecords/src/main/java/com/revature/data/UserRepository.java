package com.revature.data;

import com.revature.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Sibrian on 2/15/17.
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    //Save a new User
    @Override
    <S extends User>S save (S User);

    //Get all Users
    @Override
    List<User> findAll();

    //Get by Id
    @Override
    User findOne(Integer integer);

    User findByUserLastName(String lName);

    /*
    ADD MORE AS NEEDED
     */
}
