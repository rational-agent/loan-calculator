package com.rationalagent.loancalculator.repository;

import com.rationalagent.loancalculator.repository.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
