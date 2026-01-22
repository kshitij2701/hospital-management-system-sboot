package com.learningSpringBoot.spring_boot_app.controllers;

// when we run application first or hit the api on postman the first entry point is controller
// then flow goes to service layer and repository layer which actually interact with the database

import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    // dependency injection patient controller dependent on patient service
    @Autowired
    private PatientService patientService;

    // get request for fetching all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        System.out.println("Fetching the patients");
        return patientService.getAllPatients();
    }

    // post request for creating patient record
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        System.out.println("creating patient");
        return patientService.createPatient(patient);
    }

    // get request to fetch patient by id
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return patientService.getPatientById(id);
    }

    // delete request to delete a record of patient
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    // put request for updating record of patient
    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id) {
        patientService.updatePatient(id);
    }




}
