package com.sos.medicalservice.controller;

import com.sos.medicalservice.entity.Doctor;
import com.sos.medicalservice.entity.Patient;
import com.sos.medicalservice.exception.ValueNotFoundException;
import com.sos.medicalservice.model.UpdatePatientRequest;
import com.sos.medicalservice.service.DoctorService;
import com.sos.medicalservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/findAllPatients")
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping(value = "/findPatient/{id}")
    public Patient findPatient(@PathVariable int id) throws ValueNotFoundException {
        return patientService.findPatient(id);
    }

    @PostMapping(value = "/addPatient/{id}")
    public Patient addPatient(@PathVariable int id, @RequestBody final Patient patient) throws ValueNotFoundException {
        return patientService.addPatient(patient, id);
    }

    @PutMapping(value = "/updatePatient")
    public Patient updatePatient(@RequestBody final UpdatePatientRequest request) throws ValueNotFoundException {
        return patientService.updatePatient(request);
    }

    @DeleteMapping(value = "/deletePatient/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "Patient deleted";
    }
}
