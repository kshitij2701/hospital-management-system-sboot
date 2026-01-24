package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Appointment;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.service.AppointmentService;
import com.learningSpringBoot.spring_boot_app.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {



    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private WebhookService webhookService;

    // get request for fetching all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("Fetching the patients");
        return null;
    }

    // post request for creating a new appointment record
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointmentRequest) {
        System.out.println("creating new appointment");
        Appointment appointment = appointmentService.createAppointment(appointmentRequest);
        //prepare the webhook payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("appointmentId", appointment.getId());
        payload.put("patientId", appointment.getPatientId());
        payload.put("doctorId", appointment.getDoctorId());
        payload.put("appointmentDate", appointment.getDate());

        // send the webhook
        String webhookUrl = "http://localhost:8081/webhook";
        webhookService.sendWebhook(webhookUrl, payload);

        return appointment;

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
