package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.models.Appointment;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    public List<Appointment> getAllAppointments() {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment( Appointment appointment) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public void updateAppointment(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
