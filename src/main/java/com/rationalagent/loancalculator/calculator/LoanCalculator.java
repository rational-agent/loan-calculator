package com.rationalagent.loancalculator.calculator;

import com.rationalagent.loancalculator.loan.repository.model.Loan;
import com.rationalagent.loancalculator.loan.repository.model.LoanSpecification;
import com.rationalagent.loancalculator.loan.repository.model.MonthlyPayment;
import com.rationalagent.loancalculator.loan.repository.model.Payment;

import java.math.BigDecimal;
import java.util.List;


public interface LoanCalculator {

    BigDecimal MONTHS_IN_A_YEAR = new BigDecimal("12.00");

    Loan calculateLoan(LoanSpecification specification);

    Payment calculateFirstPrincipalPayment(LoanSpecification spec);

    Payment calculatePrincipalPayment(LoanSpecification spec);

    List<MonthlyPayment> calculateAmortizationSchedule(LoanSpecification spec);

    Integer calculateTermInMonths(LoanSpecification spec);

    BigDecimal calculateMonthlyInterestRate(LoanSpecification spec);

}
