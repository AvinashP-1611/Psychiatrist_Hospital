package com.example.Hospital.Controller;

import com.example.Hospital.Models.Hospital;
import com.example.Hospital.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @PostMapping("/add")
    public ResponseEntity addHospital(@RequestBody Hospital name){
        hospitalService.addHospital(name);
        return new ResponseEntity("save successfully", HttpStatus.CREATED);
    }

}
