package com.revature.controllers;

import com.revature.beans.Clinic;
import com.revature.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sibrian on 2/16/17.
 */
@RestController
public class ClinicController {

    private ClinicService clinicService;

    @Autowired
    public void setClinicService(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = "/clinic",
                method = RequestMethod.POST,
                consumes = {MediaType.APPLICATION_JSON_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public Clinic save(@RequestBody Clinic clinic) {
        return clinicService.save(clinic);
    }

    @RequestMapping(value = "/getAll",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Clinic> findAllClinics() {
        return clinicService.findAll();
    }

    @RequestMapping(value = "/search/{name}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public Clinic getClinicByName(@PathVariable String name) {
        return clinicService.findByName(name);
    }

    @RequestMapping(value = "/search/{id}",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public Clinic getClinicById(@PathVariable int id) {
        return clinicService.findOne(id);
    }
}
