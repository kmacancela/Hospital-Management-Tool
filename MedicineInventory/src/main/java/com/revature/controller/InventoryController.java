package com.revature.controller;

import com.revature.beans.Inventory;
import com.revature.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kawee on 2/16/2017.
 */

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    private InventoryService service;

    @Autowired
    public void setService(InventoryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/new",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventory save(@RequestBody Inventory inventoryItem){
        return service.save(inventoryItem);
    }

    @RequestMapping(value = "/all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Inventory> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventory findById(@PathVariable(value = "id") Integer id){
        return service.findById(id);
    }

    @RequestMapping(value = "/update",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Inventory inventoryItem) {
        service.update(inventoryItem);
    }
}
