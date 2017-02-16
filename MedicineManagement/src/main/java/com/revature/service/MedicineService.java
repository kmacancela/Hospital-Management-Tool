package com.revature.service;

import com.revature.beans.Medicine;
import com.revature.data.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kawee on 2/15/2017.
 */

@Service
public class MedicineService {

    private MedicineRepository repository;

    @Autowired
    public void setRepository(MedicineRepository repository) {
        this.repository = repository;
    }

    public Medicine save(Medicine medicine){
        return repository.save(medicine);
    }
    public List<Medicine> findAll(){
        return repository.findAll();
    }
    public Medicine findOne(Integer id){
        return repository.findOne(id);
    }
    public Medicine update(Medicine medicine){
        return repository.update(medicine);
    }
}
