package com.rationalagent.loancalculator.repository.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType type;
    private BigDecimal paymentUnrounded;
    private BigDecimal paymentRounded;
    private BigDecimal paymentRoundingError;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment() {
    }

    public Payment(PaymentType type, BigDecimal principal) {
        this.type = type;
        this.paymentUnrounded = principal;
        this.paymentRounded = principal.setScale(2, RoundingMode.HALF_EVEN);
        this.paymentRoundingError = paymentUnrounded.subtract(paymentRounded);
    }

    public PaymentType getType() {
        return type;
    }

    public BigDecimal getPaymentUnrounded() {
        return paymentUnrounded;
    }

    public BigDecimal getPaymentRounded() {
        return paymentRounded;
    }

    public BigDecimal getPaymentRoundingError() {
        return paymentRoundingError;
    }
}
