package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // get request for fetching all doctors
    @GetMapping
    public Page<Doctor> getAllDoctors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        System.out.println("Fetching the doctors");
        return doctorService.getAllDoctors(page, size);
    }

    // post request for creating doctor record
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println("creating doctor record");
        return doctorService.createDoctor(doctor);
    }

    // get request to fetch doctor by id
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // delete request to delete a record of doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.deleteDoctor(id));
    }

    // put request for updating record of doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
}
