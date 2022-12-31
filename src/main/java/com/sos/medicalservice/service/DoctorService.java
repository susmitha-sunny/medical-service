package com.sos.medicalservice.service;

import com.sos.medicalservice.entity.Doctor;
import com.sos.medicalservice.exception.ValueNotFoundException;
import com.sos.medicalservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctor(int id) throws ValueNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        } else {
            throw new ValueNotFoundException("Doctor not found");
        }
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) throws ValueNotFoundException {
        if(doctorRepository.findById(doctor.getDoctorId()).isPresent()) {
            return doctorRepository.save(doctor);
        } else {
            throw new ValueNotFoundException("Doctor not found");
        }
    }


    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
