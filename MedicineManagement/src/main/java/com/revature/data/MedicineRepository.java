package com.revature.data;

import com.revature.beans.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by kawee on 2/15/2017.
 */
public interface MedicineRepository extends MongoRepository<Medicine, Integer> {

    // Create
    @Override
    <S extends Medicine> S save(S medicine);
    // Retrieve all
    @Override
    List<Medicine> findAll();
    // Retrieve by Id
    @Override
    Medicine findOne(Integer id);
    // update by Id
    <S extends Medicine> S update(S medicine);
}
