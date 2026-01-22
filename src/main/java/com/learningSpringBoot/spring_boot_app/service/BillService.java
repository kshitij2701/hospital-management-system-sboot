package com.learningSpringBoot.spring_boot_app.service;


import com.learningSpringBoot.spring_boot_app.models.Bill;
import com.learningSpringBoot.spring_boot_app.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    public List<Bill> getAllBills() {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Bill createBill( Bill bill) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public void updateBill(Long id) {
        try {
            System.out.println("info service layer");
            //interact with the repository layer
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
