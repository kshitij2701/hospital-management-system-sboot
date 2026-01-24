package com.learningSpringBoot.spring_boot_app.repository;

import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// flow from service to repository.

// to implement pagination here patient repository extends jpa repository which in turn extending ListPagingAndSortingRepository
// so from here we can get pagination implementation and can be used where ever we need this concept in our app.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
