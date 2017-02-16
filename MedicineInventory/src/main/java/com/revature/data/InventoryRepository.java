package com.revature.data;

import com.revature.beans.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by kawee on 2/16/2017.
 */
public interface InventoryRepository extends MongoRepository<Inventory, Integer> {

    <S extends Inventory> S save(S inventoryItem);

    List<Inventory> findAll();

    Inventory findOne(Integer id);

    //void update(Inventory inventoryItem);
}


