package com.revature.service;

import com.revature.beans.Inventory;
import com.revature.data.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kawee on 2/16/2017.
 */

@Service
public class InventoryService {

    private InventoryRepository repository;

    @Autowired
    public void setRepository(InventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory save(Inventory inventoryItem){
        return repository.save(inventoryItem);
    }

    public List<Inventory> findAll(){
        return repository.findAll();
    }

    public Inventory findOne(Integer id){
        return repository.findOne(id);
    }
}
