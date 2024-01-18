package com.example.Hospital.Repository;

import com.example.Hospital.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepo extends JpaRepository<Patient,Integer> {
    @Query(value = "SELECT COUNT(patient_name) FROM patient WHERE psychiatrist_id=:id",nativeQuery = true)
    int findCountPatient(int id);
}
