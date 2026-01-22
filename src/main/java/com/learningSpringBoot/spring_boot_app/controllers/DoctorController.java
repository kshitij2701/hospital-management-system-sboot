package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    // get request for fetching all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        System.out.println("Fetching the doctors");
        return null;
    }

    // post request for creating doctor record
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println("creating doctor");
        return null;
    }

    // get request to fetch doctor by id
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return null;
    }

    // delete request to delete a record of doctor
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {

    }

    // put request for updating record of doctor
    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id) {
        System.out.println("updating doctor info");
    }
}
