package com.example.Hospital.Service;

import com.example.Hospital.Models.Hospital;
import com.example.Hospital.Models.Psychiatrist;
import com.example.Hospital.Repository.HospitalRepo;
import com.example.Hospital.Repository.PsychiatristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsychiatristService {
    @Autowired
    PsychiatristRepo psychiatristRepo;

    @Autowired
    HospitalRepo hospitalRepo;

    public Psychiatrist addPsychiatrist(Psychiatrist psychiatrist,int hospitalId) {
        Hospital hospital=hospitalRepo.findById(hospitalId);
        psychiatrist.setHospital(hospital);
        Psychiatrist save=psychiatristRepo.save(psychiatrist);
        return save;
    }
}
