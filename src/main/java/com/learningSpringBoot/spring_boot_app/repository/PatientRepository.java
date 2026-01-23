package com.learningSpringBoot.spring_boot_app.repository;

import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// flow from service to repository.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
