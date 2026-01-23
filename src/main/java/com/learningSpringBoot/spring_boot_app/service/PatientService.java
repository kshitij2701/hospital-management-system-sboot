package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Patient> getAllPatients() {
        try {
            logger.info("Fetching all patients");
            //interact with the repository layer
            return patientRepository.findAll();
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
        try {
            logger.info("Fetching Patient with id: {}", id);
            //interact with the repository layer
            Optional<Patient> patient = patientRepository.findById(id); // optional providing null safety
            return patient.orElse(null);
        } catch (Exception e) {
            logger.error("An error occured while fetching Patient with id {} : {}",id, e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            logger.info("Deleting patient with id {}", id);
            //interact with the repository layer
            if (!patientRepository.existsById(id)) {
                logger.warn("Cannot delete. Patient not found with id: {}", id);
                return;
            }
            patientRepository.deleteById(id);
            logger.info("Patient deleted successfully with id: {}", id);
        } catch (Exception e) {
            logger.error("Error while deleting Patient with id {} : {} ", id,  e.getMessage());
        }
    }

    public Patient updatePatient(Long id, Patient patient) {
        try {
            logger.info("Updating patient info with id {}", id);
            //interact with the repository layer
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if(existingPatient.isPresent()){
                Patient p = existingPatient.get();
                if(patient.getName() != null){
                    p.setName(patient.getName());
                }
                if(patient.getGender() !=  null){
                    p.setGender(patient.getGender());
                }
                if(patient.getAge() !=  null){
                    p.setAge(patient.getAge());
                }
                patientRepository.save(p);
                return p;

            } else {
                logger.warn("Patient with id: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error while updating patient with id {} : {}", id, e.getMessage());
            return null;
        }
    }


}
