package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.exception.ResourceNotFoundException;
import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.repository.DoctorRepository;
import com.learningSpringBoot.spring_boot_app.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Doctor> getAllDoctors(int page, int size) {
        try {
            logger.info("Fetching all doctors");
            //interact with the repository layer
            Pageable pageable = PageRequest.of(page, size);
            return doctorRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occured while fetching all doctors: {}", e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor( Doctor doctor) {
        try {
            logger.info("Creating New Doctor record");
            //interact with the repository layer
            doctorRepository.save(doctor);
            return doctor;
        } catch (Exception e) {
            logger.error("Error happened while creating Doctor: {}", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        logger.info("Fetching Doctor with id: {}", id);
        return doctorRepository.findById(id).orElseThrow(() -> {
            logger.warn("Doctor with id {} not found", id);
            return new ResourceNotFoundException(
                    "Doctor with id " + id + " not found"
            );
        });
    }

    public Doctor deleteDoctor(Long id) {
        logger.info("Deleting Doctor with id {}", id);
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> {
            logger.warn("Doctor with id {} not found", id);
            return new ResourceNotFoundException(
                    "Doctor with id " + id + " not found so Deletion not possible"
            );
        });
        doctorRepository.delete(doctor);
        logger.info("Doctor deleted successfully with id: {}", id);
        return doctor;
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        logger.info("Updating doctor info with id {}", id);
        Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Doctor not found with id " + id + " so how update possible"
                )
        );
        //interact with the repository layer
        // Optional<Patient> existingPatient = patientRepository.findById(id);

        if(doctor.getName() != null){
            existingDoctor.setName(doctor.getName());
        }
        if(doctor.getSpeciality() !=  null){
            existingDoctor.setSpeciality(doctor.getSpeciality());
        }
        if(doctor.getAge() !=  null){
            existingDoctor.setAge(doctor.getAge());
        }
        return doctorRepository.save(existingDoctor);
    }
}
