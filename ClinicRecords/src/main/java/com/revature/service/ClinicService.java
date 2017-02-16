package com.revature.service;

import com.revature.beans.Clinic;
import com.revature.data.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sibrian on 2/16/17.
 */
@Service
public class ClinicService {

    private ClinicRepository clinicRepo;

    @Autowired
    public void setClinicRepo(ClinicRepository clinicRepo) {
        this.clinicRepo = clinicRepo;
    }

    public Clinic save(Clinic clinic) {
        return clinicRepo.save(clinic);
    }

    public List<Clinic> findAll() {
        return clinicRepo.findAll();
    }

    public Clinic findOne(Integer integer) {
        return clinicRepo.findOne(integer);
    }

    public Clinic findByName(String name) {
        return clinicRepo.findByClinicName(name);
    }
}
