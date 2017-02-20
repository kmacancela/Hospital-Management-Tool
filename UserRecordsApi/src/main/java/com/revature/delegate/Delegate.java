package com.revature.delegate;

import com.revature.beans.Clinic;
import com.revature.beans.User;
import com.revature.service.UserRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sibrian on 2/19/17.
 */
@Component
public class Delegate {

    private UserRecordsService recordService;


    //USER METHODS
    @Autowired
    public void setRecordService(UserRecordsService recordService) {
        this.recordService = recordService;
    }

    public ResponseEntity<User> saveUser(User user) {
        return recordService.saveUser(user);
    }

    public ResponseEntity<List<User>> findAllUsers() {
        return recordService.findAllUsers();
    }

    public ResponseEntity<User> findUserById(Integer id) {
        return recordService.findUserById(id);
    }

    public ResponseEntity<User> findUserByLastName(String lName) {
        return recordService.findUserByLastName(lName);
    }

    //CLINIC METHODS
    public ResponseEntity<Clinic> saveClinic(Clinic clinic) {
        return recordService.saveClinic(clinic);
    }

    public ResponseEntity<List<Clinic>> findAllClinics() {
        return recordService.findAllClinics();
    }

    public ResponseEntity<Clinic> findClinicByName(String name) {
        return recordService.findClinicByName(name);
    }

    public ResponseEntity<Clinic> findClinicById(Integer id) {
        return recordService.findClinicById(id);
    }
}
