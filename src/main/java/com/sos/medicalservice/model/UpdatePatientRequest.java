package com.sos.medicalservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientRequest {
    public int patientId;
    public String firstName;
    public String lastName;
    public Integer doctorId;
}
