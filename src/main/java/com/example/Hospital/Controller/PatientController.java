package com.example.Hospital.Controller;

import com.example.Hospital.Response.AllDetails;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/addPatient")
    public ResponseEntity addPatient(@RequestBody Patient patient, @RequestParam int id){
        Patient savePatient=patientService.addPatient(patient,id);
        return new ResponseEntity(savePatient, HttpStatus.CREATED);
    }

    //get all details
    @GetMapping("/getAllDetails")
    public ResponseEntity getAll(@RequestParam int id){
        AllDetails total=patientService.getAll(id);
        return new ResponseEntity(total, HttpStatus.FOUND);
    }
}
