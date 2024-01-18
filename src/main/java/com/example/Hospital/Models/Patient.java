package com.example.Hospital.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int patientId;

    @Size(min=3, max=20 ,message = "Please enter valid input")
    String patientName;


    int age;


    String patientNumber;

    @ManyToOne
    @JoinColumn(name = "psychiatristId")
    Psychiatrist psychiatrist;
}
