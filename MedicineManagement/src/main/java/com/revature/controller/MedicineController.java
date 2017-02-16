package com.revature.controller;

import com.revature.beans.Medicine;
import com.revature.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kawee on 2/15/2017.
 */

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

    private MedicineService service;

    @Autowired
    public void setService(MedicineService service) {
        this.service = service;
    }

    @RequestMapping(value = "/new",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicine save(@RequestBody Medicine medicine){
        return service.save(medicine);
    }

    @RequestMapping(value = "/all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicine> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicine findOne(@PathVariable Integer id){
        return service.findOne(id);
    }

/*    @RequestMapping(value = "/update")
    public Medicine update(@RequestBody Medicine medicine){
        return service.update(medicine);
    }*/
}
