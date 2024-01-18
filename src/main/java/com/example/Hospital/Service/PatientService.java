package com.example.Hospital.Service;

import com.example.Hospital.Response.AllDetails;
import com.example.Hospital.Models.Hospital;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Psychiatrist;
import com.example.Hospital.Response.PsychiatristList;
import com.example.Hospital.Repository.HospitalRepo;
import com.example.Hospital.Repository.PatientRepo;
import com.example.Hospital.Repository.PsychiatristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

    @Autowired
    PsychiatristRepo psychiatristRepo;

    @Autowired
    HospitalRepo hospitalRepo;

    public Patient addPatient(Patient patient, int psychiatristId) {

        Psychiatrist s=psychiatristRepo.findById(psychiatristId);
        if(s==null) throw new RuntimeException("Id Not Found");
        patient.setPsychiatrist(s);

        return patientRepo.save(patient);
    }

    public AllDetails getAll(int id) {
      Hospital hospital=hospitalRepo.findById(id); //get hospital name

      AllDetails allDetails=new AllDetails();

      allDetails.setHospitalName(hospital.getHospitalName());
        int totalCount=0;
        List<Psychiatrist> list=psychiatristRepo.findHospital(id);
      allDetails.setPsychiatristCount(list.size());

      List<PsychiatristList> adding=new ArrayList<>();
      for(Psychiatrist p : list){
          PsychiatristList psychiatristList=new PsychiatristList();
          psychiatristList.setPsychiatristName(p.getPsychiatristName());
          int currentCount=patientRepo.findCountPatient(p.getPsychiatristId());
          psychiatristList.setPatientCount(currentCount);
          psychiatristList.setPsychiatristNumber(p.getPhoneNumber());
          adding.add(psychiatristList);
          totalCount+=currentCount;
      }
      allDetails.setPatientCount(totalCount);
      allDetails.setPsychiatristList(adding);

      return allDetails;

    }

}
