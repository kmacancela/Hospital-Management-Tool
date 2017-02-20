package com.revature.web;

import com.revature.beans.User;
import com.revature.delegate.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = )
    public ResponseEntity<User> saveUser(User user) {

    }


    @RequestMapping(value = "/user/getAll",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getAllUsers() {

    }
}
