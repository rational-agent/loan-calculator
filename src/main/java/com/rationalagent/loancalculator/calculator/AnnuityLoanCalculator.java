package com.rationalagent.loancalculator.calculator;

import com.rationalagent.loancalculator.repository.model.Loan;
import com.rationalagent.loancalculator.repository.model.LoanSpecification;
import com.rationalagent.loancalculator.repository.model.MonthlyPayment;
import com.rationalagent.loancalculator.repository.model.Payment;

import java.math.BigDecimal;
import java.util.List;

public class AnnuityLoanCalculator implements LoanCalculator {


    @Override
    public Loan calculateLoan(LoanSpecification specification) {
        return null;
    }

    @Override
    public Payment calculateFirstPrincipalPayment(LoanSpecification spec) {
        return null;
    }

    @Override
    public Payment calculatePrincipalPayment(LoanSpecification spec) {
        return null;
    }

    @Override
    public List<MonthlyPayment> calculateAmortizationSchedule(LoanSpecification spec) {
        return null;
    }

    @Override
    public Integer calculateTermInMonths(LoanSpecification spec) {
        return null;
    }

    @Override
    public BigDecimal calculateMonthlyInterestRate(LoanSpecification spec) {
        return null;
    }
}
