package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Doctor> getAllDoctors() {
        System.out.println("Fetching the doctors");
        return doctorService.getAllDoctors();
    }

    // post request for creating doctor record
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println("creating doctor");
        return doctorService.createDoctor(doctor);
    }

    // get request to fetch doctor by id
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return doctorService.getDoctorById(id);
    }

    // delete request to delete a record of doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDoctor(@PathVariable Long id) {
        boolean deleted = doctorService.deleteDoctor(id);
        if (deleted) {
            return ResponseEntity.ok(
                    Map.of(
                    "status", "success",
                    "message", "Doctor deleted successfully",
                    "id", id
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of(
                    "status", "error",
                    "message", "Doctor with id " + id + " not found",
                    "id", id
                    )
            );
        }
    }

    // put request for updating record of doctor
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
}
