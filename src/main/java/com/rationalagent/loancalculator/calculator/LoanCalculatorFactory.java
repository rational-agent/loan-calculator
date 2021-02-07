package com.rationalagent.loancalculator.calculator;


import com.rationalagent.loancalculator.calculator.exceptions.UnknownLoanTypeException;
import com.rationalagent.loancalculator.repository.model.AmortizationMethod;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorFactory implements CalculatorFactory {

    public LoanCalculator createCalculator(AmortizationMethod method) {
        switch (method) {
            case LINEAR:
                return new StraightLineLoanCalculator();
            case ANNUITY:
                return new AnnuityLoanCalculator();
            default:
                throw new UnknownLoanTypeException("Loan calculator of type " + method.name() + " not implemented.");
        }
    }

}
