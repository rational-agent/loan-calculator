package com.rationalagent.loancalculator.repository;

import com.rationalagent.loancalculator.repository.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
