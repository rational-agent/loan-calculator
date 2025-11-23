package com.rationalagent.loancalculator.loan.controller;

import com.rationalagent.loancalculator.loan.exceptions.LoanNotFoundException;
import com.rationalagent.loancalculator.loan.exceptions.LoanSpecificationNotPresent;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LoanNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String loanNotFoundHandler(LoanNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LoanSpecificationNotPresent.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String loanSpecificationNotPresentHandler(LoanSpecificationNotPresent ex) {
        return ex.getMessage();
    }
}