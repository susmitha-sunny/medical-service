package com.sos.medicalservice.service;

import com.sos.medicalservice.entity.Doctor;
import com.sos.medicalservice.entity.Patient;
import com.sos.medicalservice.exception.ValueNotFoundException;
import com.sos.medicalservice.model.UpdatePatientRequest;
import com.sos.medicalservice.repository.DoctorRepository;
import com.sos.medicalservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorService doctorService;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatient(int id) throws ValueNotFoundException {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new ValueNotFoundException("Patient not found");
        }
    }

    public Patient addPatient(Patient patient, int id) throws ValueNotFoundException {
        patient.setDoctor(doctorService.findDoctor(id));
        return patientRepository.save(patient);
    }

    public Patient updatePatient(UpdatePatientRequest request) throws ValueNotFoundException {
        Patient updatePatient;
        Optional<Patient> optionalDbPatient = patientRepository.findById(request.getPatientId());
        if (optionalDbPatient.isPresent()) {
            Doctor newdoctor = doctorService.findDoctor(request.getDoctorId());
            updatePatient = new Patient(request.getPatientId(), request.getFirstName(), request.getLastName(), newdoctor);
            return patientRepository.save(updatePatient);
        } else {
            throw new ValueNotFoundException("Patient not found");
        }
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
