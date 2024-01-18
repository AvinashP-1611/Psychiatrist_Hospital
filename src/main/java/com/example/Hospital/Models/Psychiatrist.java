package com.example.Hospital.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="psychiatrist")
public class Psychiatrist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int psychiatristId;

    @Size(min=3, max=20 ,message = "Please enter valid input")
    String psychiatristName;


    int age;

    @Size(min=10, max=10 ,message = "Please enter valid input")
    String phoneNumber;


    @Email(message = "Please enter valid input")
    String email;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    Hospital hospital;

   }
