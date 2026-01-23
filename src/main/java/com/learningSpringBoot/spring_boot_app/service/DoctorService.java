package com.learningSpringBoot.spring_boot_app.service;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import com.learningSpringBoot.spring_boot_app.repository.DoctorRepository;
import com.learningSpringBoot.spring_boot_app.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        try {
            logger.info("Fetching all doctors");
            //interact with the repository layer
            return doctorRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occured while fetching all doctors: {}", e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor( Doctor doctor) {
        try {
            logger.info("Creating New Doctor");
            //interact with the repository layer
            doctorRepository.save(doctor);
            return doctor;
        } catch (Exception e) {
            logger.error("Error happened while creating Doctor: {}", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            logger.info("Fetching Doctor with id: {}", id);
            //interact with the repository layer
            Optional<Doctor> doctor = doctorRepository.findById(id); // optional providing null safety
            return doctor.orElse(null);
        } catch (Exception e) {
            logger.error("An error occured while fetching Patient with id {} : {}",id, e.getMessage());
            return null;
        }
    }

    public boolean deleteDoctor(Long id) {
        try {
            logger.info("Deleting Doctor with id {}", id);
            //interact with the repository layer
            if (!doctorRepository.existsById(id)) {
               logger.warn("Cannot delete Doctor not found with id: {}", id);
               return false;
            }
            doctorRepository.deleteById(id);
            logger.info("Doctor deleted successfully with id: {}", id);
            return true;
        } catch (Exception e) {
            logger.error("Error while deleting Doctor with id {} : {} ", id,  e.getMessage());
            return false;
        }
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        try {
            logger.info("Updating doctor info with id {}", id);
            //interact with the repository layer
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if(existingDoctor.isPresent()){
                Doctor d = existingDoctor.get();
                if(doctor.getName() != null){
                    d.setName(doctor.getName());
                }
                if(doctor.getSpeciality() !=  null){
                    d.setSpeciality(doctor.getSpeciality());
                }
                if(doctor.getAge() !=  null){
                    d.setAge(doctor.getAge());
                }
                doctorRepository.save(d);
                return d;

            } else {
                logger.warn("Doctor with id: {} not found", id);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error while updating doctor with id {} : {}", id, e.getMessage());
            return null;
        }
    }


}
