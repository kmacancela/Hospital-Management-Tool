package com.revature.service;

import com.revature.beans.User;
import com.revature.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sibrian on 2/15/17.
 */
@Service
public class UserMongoService {

    private UserRepository userRepo;

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findOne(Integer integer) {
        return userRepo.findOne(integer);
    }

    public User findByLastName(String lName) {
        return userRepo.findByUserLastName(lName);
    }
}
