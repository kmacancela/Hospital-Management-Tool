package com.revature.data;

import com.revature.beans.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by kawee on 2/15/2017.
 */
public interface MedicineRepository extends MongoRepository<Medicine, Integer> {

    <S extends Medicine> S save(S medicine);

    List<Medicine> findAll();

    Medicine findOne(Integer id);

    <S extends Medicine> S update(S medicine);
}
