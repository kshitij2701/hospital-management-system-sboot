package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Appointment;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.service.AppointmentService;
import com.learningSpringBoot.spring_boot_app.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public Page<Appointment> getAllAppointments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        System.out.println("Fetching the patients");
        return appointmentService.getAllAppointments(page, size);
    }

    // post request for creating a new appointment record
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointmentRequest) {
        System.out.println("creating new appointment");
        Appointment appointment = appointmentService.createAppointment(appointmentRequest);
        //prepare the webhook payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("appointmentId", appointment.getId());
        payload.put("patientId", appointment.getPatientId());
        payload.put("doctorId", appointment.getDoctorId());
        payload.put("appointmentDate", appointment.getAppointmentDate());
        payload.put("appointmentTimeSlot", appointment.getTimeSlot());

        // send the webhook
        String webhookUrl = "http://localhost:8081/webhook";
        webhookService.sendWebhook(webhookUrl, payload);

        return ResponseEntity.ok(appointment);

    }

    // get request to fetch appointment by id
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    // delete request to delete a record of appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.deleteAppointment(id));
    }

//    // put request for updating appointment details
//    @PutMapping("/{id}")
//    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
//        return ResponseEntity.ok(appointmentService.updateAppointment(id));
//    }

}
