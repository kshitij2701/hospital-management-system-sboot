package com.learningSpringBoot.spring_boot_app.repository;

import com.learningSpringBoot.spring_boot_app.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
