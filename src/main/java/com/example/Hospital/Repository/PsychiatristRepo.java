package com.example.Hospital.Repository;

import com.example.Hospital.Models.Psychiatrist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PsychiatristRepo extends JpaRepository<Psychiatrist,Integer> {
    Psychiatrist findById(int id);

//    @Query(value = "SELECT COUNT(hospital_id) from psychiatrist WHERE hospital_id=:id",nativeQuery = true)
//    int countHospitalFromHospitalId(int id);

    @Query(value = "SELECT * FROM psychiatrist WHERE hospital_id=:id",nativeQuery = true)
    List<Psychiatrist> findHospital(int id);
}
