package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.exception.ResourceNotFoundException;
import com.learningSpringBoot.spring_boot_app.exception.SlotAlreadyBookedException;
import com.learningSpringBoot.spring_boot_app.models.Appointment;
import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.repository.AppointmentRepository;
import com.learningSpringBoot.spring_boot_app.repository.DoctorRepository;
import com.learningSpringBoot.spring_boot_app.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Appointment> getAllAppointments(int page, int size) {
        try {
            logger.info("Fetching all appointments");
            //interact with the repository layer
            Pageable pageable = PageRequest.of(page, size);
            return appointmentRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occured while fetching all appointments: {}", e.getMessage());
            return null;
        }
    }

//    public Appointment createAppointment( Appointment appointmentRequest) {
//        try {
//            System.out.println("Appointment confirmed and booked");
//            logger.info("Appointment confirmed with doctorId: {} for patient with id: {}", appointmentRequest.getDoctorId(), appointmentRequest.getPatientId());
//            //interact with the repository layer
//            return appointmentRequest;
//        } catch (Exception e) {
//            System.out.println("Error message: " + e.getMessage());
//            return null;
//        }
//    }


    @Transactional
    public Appointment createAppointment(Appointment appointmentRequest) {

        // 1️⃣ Validate patient
        if (!patientRepository.existsById(appointmentRequest.getPatientId())) {
            throw new ResourceNotFoundException(
                    "Patient not found with id " + appointmentRequest.getPatientId());
        }

        // 2️⃣ Validate doctor
        if (!doctorRepository.existsById(appointmentRequest.getDoctorId())) {
            throw new ResourceNotFoundException(
                    "Doctor not found with id " + appointmentRequest.getDoctorId());
        }

        // 3️⃣ Check slot availability
        if (appointmentRepository
                .existsByDoctorIdAndAppointmentDateAndTimeSlot(
                        appointmentRequest.getDoctorId(),
                        appointmentRequest.getAppointmentDate(),
                        appointmentRequest.getTimeSlot())) {

            throw new SlotAlreadyBookedException(
                    "Doctor already has an appointment for this slot! Please choose other slot");
        }

        logger.info("Appointment booked successfully");
        // 4️⃣ Save appointment
        return appointmentRepository.save(appointmentRequest);
    }




    public Appointment getAppointmentById(Long id) {
        logger.info("Fetching Appointment with id: {}", id);
        return appointmentRepository.findById(id).orElseThrow(() -> {
            logger.warn("Appointment with id {} not found", id);
            return new ResourceNotFoundException(
                    "Appointment with id " + id + " not found"
            );
        });
    }

    public Appointment deleteAppointment(Long id) {

        logger.info("Deleting appointment with id {}", id);
        //interact with the repository layer
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> {
            logger.warn("Appointment with id {} not found", id);
            return new ResourceNotFoundException(
                    "Appointment with id " + id + " not found so Deletion not possible"
            );
        });
        appointmentRepository.delete(appointment);
        logger.info("Appointment deleted successfully with id: {}", id);
        return appointment;

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
