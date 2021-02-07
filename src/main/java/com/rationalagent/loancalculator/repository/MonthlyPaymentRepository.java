package com.rationalagent.loancalculator.repository;

import com.rationalagent.loancalculator.repository.model.MonthlyPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyPaymentRepository extends JpaRepository<MonthlyPayment, Long> {
}
