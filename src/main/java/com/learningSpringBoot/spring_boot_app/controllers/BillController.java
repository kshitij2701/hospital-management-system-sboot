package com.learningSpringBoot.spring_boot_app.controllers;

import com.learningSpringBoot.spring_boot_app.models.Bill;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    // get request for fetching all bills
    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Fetching the patients");
        return null;
    }

    // post request for creating bill record
    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        System.out.println("creating patient");
        return null;
    }

    // get request to fetch bill by id
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        System. out.println("Fetching id by ID");
        return null;
    }

    // delete request to delete a bill by id
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {

    }

    // put request for updating bill details
    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id) {

    }
}
