package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// flow moves from controller to service layer where actual logic part works

@Service
public class PatientService {

    public List<Patient> getAllPatients() {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Patient createPatient( Patient patient) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public void updatePatient(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }


}
