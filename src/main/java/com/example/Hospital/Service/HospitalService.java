package com.example.Hospital.Service;

import com.example.Hospital.Models.Hospital;
import com.example.Hospital.Repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HospitalService {
    @Autowired
    HospitalRepo hospitalRepo;

    public void addHospital(Hospital name) {

        hospitalRepo.save(name);
    }

}
