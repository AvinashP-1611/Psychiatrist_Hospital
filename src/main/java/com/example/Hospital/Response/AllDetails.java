package com.example.Hospital.Response;

import com.example.Hospital.Response.PsychiatristList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AllDetails {
    String hospitalName;

    int psychiatristCount;

    int patientCount;

    List<PsychiatristList> psychiatristList;

}
