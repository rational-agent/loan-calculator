package com.rationalagent.loancalculator.service;

import com.rationalagent.loancalculator.calculator.CalculatorFactory;
import com.rationalagent.loancalculator.calculator.LoanCalculator;
import com.rationalagent.loancalculator.calculator.exceptions.LoanNotFoundException;
import com.rationalagent.loancalculator.calculator.exceptions.LoanSpecificationNotPresent;
import com.rationalagent.loancalculator.repository.LoanRepository;
import com.rationalagent.loancalculator.repository.MonthlyPaymentRepository;
import com.rationalagent.loancalculator.repository.PaymentRepository;
import com.rationalagent.loancalculator.repository.model.Loan;
import com.rationalagent.loancalculator.repository.model.LoanSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    CalculatorFactory factory;

    @Autowired
    LoanRepository repository;

    @Autowired
    MonthlyPaymentRepository monthlyPaymentRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public Loan calculate(Loan loan, Long id) {
        if (loan.getLoanSpecification() == null) {
            throw new LoanSpecificationNotPresent("Loan specification is missing");
        }
        LoanSpecification spec = loan.getLoanSpecification();
        LoanCalculator calculator = factory.createCalculator(spec.getAmortizationMethod());
        Loan calculatedLoan = calculator.calculateLoan(spec);

        return update(calculatedLoan, id);
    }

    public Loan create(Loan loan) {
        return repository.save(loan);
    }

    public Loan update(Loan loanUpdate, Long id) {
        if (loanUpdate.getLoanSpecification() == null) {
            throw new LoanSpecificationNotPresent("Loan specification is missing");
        }

        return repository.findById(id)
                .map(loan -> {
                    loan.setLoanSpecification(loanUpdate.getLoanSpecification());
                    loan.setAmortizationSummary(loanUpdate.getAmortizationSummary());
                    loan.setAmortizationSchedule(loanUpdate.getAmortizationSchedule());
                    return repository.save(loan);
                })
                .orElseThrow(() -> new LoanNotFoundException("Loan with id not found: " + id));
    }

    public List<Loan> readAll() {
        return repository.findAll();
    }

    public Loan read(Long id) {
        return repository.getOne(id);
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
