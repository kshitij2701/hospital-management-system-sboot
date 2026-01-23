package com.learningSpringBoot.spring_boot_app.repository;

import com.learningSpringBoot.spring_boot_app.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilllRepository extends JpaRepository<Bill, Long> {

}
