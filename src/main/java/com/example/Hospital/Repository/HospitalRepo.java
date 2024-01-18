package com.example.Hospital.Repository;

import com.example.Hospital.Models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
    Hospital findById(int id);
}
