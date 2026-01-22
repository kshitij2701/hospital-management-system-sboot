package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    public List<Doctor> getAllDoctors() {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor( Doctor doctor) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public void updateDoctor(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
