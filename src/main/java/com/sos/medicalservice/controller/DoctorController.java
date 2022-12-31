package com.sos.medicalservice.controller;

import com.sos.medicalservice.entity.Doctor;
import com.sos.medicalservice.exception.ValueNotFoundException;
import com.sos.medicalservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/findAllDoctors")
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping(value = "/findDoctor/{id}")
    public Doctor findDoctor(@PathVariable int id) throws ValueNotFoundException {
        return doctorService.findDoctor(id);
    }

    @PostMapping(value = "/addDoctor")
    public Doctor addDoctor(@RequestBody final Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping(value = "/updateDoctor")
    public Doctor updateDoctor(@RequestBody final Doctor doctor) throws ValueNotFoundException {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping(value = "/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted";
    }
}
