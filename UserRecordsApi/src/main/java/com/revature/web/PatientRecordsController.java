package com.revature.web;

import com.revature.beans.Clinic;
import com.revature.beans.User;
import com.revature.delegate.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sibrian on 2/19/17.
 */
@RestController
public class PatientRecordsController {

    private Delegate delegate;

    @Autowired
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @RequestMapping(value = "/user/save",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return delegate.saveUser(user);
    }


    @RequestMapping(value = "/user/getAll",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAllUsers() {
        return delegate.findAllUsers();
    }

    @RequestMapping(value = "/user/search/id/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        return delegate.findUserById(id);
    }

    @RequestMapping(value = "/user/search/name/{lName}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserByLastName(@PathVariable String lName) {
        return delegate.findUserByLastName(lName);
    }

    /**
     * CLINIC ENDPOINTS
     */
    @RequestMapping(value = "/clinic/save",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clinic> saveClinic(@PathVariable Clinic clinic) {
            return delegate.saveClinic(clinic);
    }

    @RequestMapping(value = "/clinic/getAll",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clinic>> findAllClinics() {
        return delegate.findAllClinics();
    }

    @RequestMapping(value = "/clinic/search/name/{name}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clinic> findClinicByName(@PathVariable String name) {
        return delegate.findClinicByName(name);
    }

    @RequestMapping(value = "/clinic/search/id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clinic> findClinicById(@PathVariable String id) {
        return delegate.findClinicByName(id);
    }
}


























