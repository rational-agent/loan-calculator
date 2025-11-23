package com.rationalagent.loancalculator.loan.exceptions;

public class LoanNotFoundException extends RuntimeException {

    public LoanNotFoundException(String message) {
        super(message);
    }

}
