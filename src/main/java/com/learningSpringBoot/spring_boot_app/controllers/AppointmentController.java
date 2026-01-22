package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Appointment;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    // get request for fetching all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("Fetching the patients");
        return null;
    }

    // post request for creating a new appointment record
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println("creating new appointment");
        return null;
    }

    // get request to fetch appointment by id
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return null;
    }

    // delete request to delete a record of appointment
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {

    }

    // put request for updating appointment details
    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable Long id) {

    }
}
