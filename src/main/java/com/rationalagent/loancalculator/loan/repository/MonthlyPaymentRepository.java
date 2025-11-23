package com.rationalagent.loancalculator.loan.repository;

import com.rationalagent.loancalculator.loan.repository.model.MonthlyPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyPaymentRepository extends JpaRepository<MonthlyPayment, Long> {
}
