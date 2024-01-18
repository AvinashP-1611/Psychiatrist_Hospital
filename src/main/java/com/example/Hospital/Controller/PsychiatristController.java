package com.example.Hospital.Controller;

import com.example.Hospital.Models.Psychiatrist;
import com.example.Hospital.Service.PsychiatristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psychiatrist")
public class PsychiatristController {
    @Autowired
    PsychiatristService
            psychiatristService;

    @PostMapping("/addPsychiatrist")
    public ResponseEntity addPsychiatrist(@RequestBody Psychiatrist psychiatrist, @RequestParam int hospitalId){
        Psychiatrist savePsychiatrist=psychiatristService.addPsychiatrist(psychiatrist,hospitalId);
        return new ResponseEntity(savePsychiatrist, HttpStatus.CREATED);
    }
}
