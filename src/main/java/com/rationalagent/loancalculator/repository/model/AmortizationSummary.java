package com.rationalagent.loancalculator.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AmortizationSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalAmount;
    private BigDecimal loanAmount;
    private BigDecimal loanAmountRoundingError;
    private BigDecimal totalInterest;
    private BigDecimal interestRoundingError;

    public AmortizationSummary() {
    }

    public AmortizationSummary(BigDecimal totalAmount, BigDecimal loanAmount, BigDecimal loanRoundingError, BigDecimal totalInterest, BigDecimal interestRoundingError) {
        this.totalAmount = totalAmount;
        this.loanAmount = loanAmount;
        this.loanAmountRoundingError = loanRoundingError;
        this.totalInterest = totalInterest;
        this.interestRoundingError = interestRoundingError;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanAmountRoundingError(BigDecimal loanAmountRoundingError) {
        this.loanAmountRoundingError = loanAmountRoundingError;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public void setInterestRoundingError(BigDecimal interestRoundingError) {
        this.interestRoundingError = interestRoundingError;
    }

    public BigDecimal getLoanAmountRoundingError() {
        return loanAmountRoundingError;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public BigDecimal getInterestRoundingError() {
        return interestRoundingError;
    }
}
