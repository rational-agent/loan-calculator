package com.rationalagent.loancalculator.loan.repository;

import com.rationalagent.loancalculator.loan.repository.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
