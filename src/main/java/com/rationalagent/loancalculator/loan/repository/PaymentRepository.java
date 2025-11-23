package com.rationalagent.loancalculator.loan.repository;

import com.rationalagent.loancalculator.loan.repository.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
