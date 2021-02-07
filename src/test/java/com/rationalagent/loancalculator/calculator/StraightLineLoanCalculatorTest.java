package com.rationalagent.loancalculator.calculator;

import com.rationalagent.loancalculator.repository.model.AmortizationMethod;
import com.rationalagent.loancalculator.repository.model.AmortizationSummary;
import com.rationalagent.loancalculator.repository.model.LoanSpecification;
import com.rationalagent.loancalculator.repository.model.MonthlyPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightLineLoanCalculatorTest {

    private LoanCalculator loanCalculator;
    LoanCalculatorFactory factory = new LoanCalculatorFactory();

    LoanSpecification spec = new LoanSpecification(
            new BigDecimal("500000.00"),
            new BigDecimal("1.75"),
            LocalDate.of(2020, 1, 15),
            LocalDate.of(2050, 1, 1),
            15,
            AmortizationMethod.LINEAR
    );

    @BeforeEach
    void beforeEach() {
        loanCalculator = factory.createCalculator(spec.getAmortizationMethod());
    }

    @Test
    void shouldCalculateTermInMonths() {
        assertEquals(361, loanCalculator.calculateAmortizationSchedule(spec).size());
    }

    // TODO: create separate method for the amortization summary
    @Test
    void shouldCalculateAmortizationSummary() {
        AmortizationSummary as = loanCalculator.calculateLoan(spec).getAmortizationSummary();
        assertEquals(spec.getPrincipal(), as.getLoanAmount());
    }

    @Test
    void dayOfMonthShouldBeEqualToPayDay() {
        assertEquals(spec.getPayDay(),
                loanCalculator.calculateLoan(spec).getAmortizationSchedule()
                        .stream()
                        .map(payment -> payment.getPaymentDate().getDayOfMonth())
                        .distinct()
                        .collect(Collectors.toList())
                        .get(0));
    }

    @Test
    void allInterestAmountsShouldBeDifferent() {
        assertEquals(loanCalculator.calculateAmortizationSchedule(spec).size(),
                loanCalculator
                        .calculateAmortizationSchedule(spec)
                        .stream()
                        .map(MonthlyPayment::getInterestPayment)
                        .distinct()
                        .count());
    }

    @Test
    void allRemainingAmountsShouldBeDifferent() {
        assertEquals(loanCalculator.calculateAmortizationSchedule(spec).size(),
                loanCalculator
                        .calculateAmortizationSchedule(spec)
                        .stream()
                        .map(MonthlyPayment::getRemainingLoanAmount)
                        .distinct()
                        .count());
    }

/*    @Test
    void sumOfPrincipalPaymentsAndPrincipalErrorShouldBeEqualToLoanAmount() {
        assertEquals(calculatedMortgage.getLoanAmount(),
                calculatedMortgage
                        .getAmortizationSchedule()
                        .stream()
                        .filter(monthlyPayment -> monthlyPayment.getPayments().stream().filter(payment -> payment.getType().equals(PaymentType.PRINCIPAL_PAYMENT)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                //.add(calculatedMortgage.getAmortizationSummary().getLoanAmountRoundingError())
        );
    }*/
}
