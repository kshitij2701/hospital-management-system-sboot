package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.exception.ResourceNotFoundException;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// flow moves from controller to service layer where actual logic part works

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;


    // now trying to implemnt pagination over here because let suppose there will be thousands or lakhs of records of patient
    // and if we hit api for getting all patient then performance of system might go down and api will take time to respond as its a large record or dataset.
    // so pagination concept does that we pass query params for page number and size number of records want to see on that page.

//    public List<Patient> getAllPatients() {
//        try {
//            logger.info("Fetching all patients");
//            //interact with the repository layer
//            return patientRepository.findAll();
//        } catch (Exception e) {
//            logger.error("An error occured while fetching all Patients: {}", e.getMessage());
//            return null;
//        }
//    }


    public Page<Patient> getAllPatients(int page, int size) {
        try {
            logger.info("Fetching all patients");
            //interact with the repository layer
            Pageable pageable = PageRequest.of(page, size);
            return patientRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occured while fetching all Patients: {}", e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            logger.info("Creating New Patient");
            //interact with the repository layer
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            logger.error("Error happened while creating Patient: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {

            logger.info("Fetching Patient with id: {}", id);
            return patientRepository.findById(id).orElseThrow(() -> {
                logger.warn("Patient with id {} not found", id);
                return new ResourceNotFoundException(
                        "Patient with id " + id + " not found"
                );
            });
            //interact with the repository layer
            //  Optional<Patient> patient = patientRepository.findById(id); // optional providing null safety
            // return patient.orElse(null);
    }

    public Patient deletePatient(Long id) {

            logger.info("Deleting patient with id {}", id);
            //interact with the repository layer
            Patient patient = patientRepository.findById(id).orElseThrow(() -> {
                logger.warn("Patient with id {} not found", id);
                return new ResourceNotFoundException(
                        "Patient with id " + id + " not found so Deletion not possible"
                );
            });
            patientRepository.delete(patient);
            logger.info("Patient deleted successfully with id: {}", id);
            return patient;

    }

    public Patient updatePatient(Long id, Patient patient) {

            logger.info("Updating patient info with id {}", id);
            Patient existingPatient = patientRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Patient not found with id " + id + " so how update possible"
                    )
            );

            //interact with the repository layer
            // Optional<Patient> existingPatient = patientRepository.findById(id);

            if(patient.getName() != null){
                existingPatient.setName(patient.getName());
            }
            if(patient.getGender() !=  null){
                existingPatient.setGender(patient.getGender());
            }
            if(patient.getAge() !=  null){
                existingPatient.setAge(patient.getAge());
            }
            return patientRepository.save(existingPatient);
    }


}
