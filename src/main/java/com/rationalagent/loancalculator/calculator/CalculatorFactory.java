package com.rationalagent.loancalculator.calculator;

import com.rationalagent.loancalculator.repository.model.AmortizationMethod;

public interface CalculatorFactory {

    LoanCalculator createCalculator(AmortizationMethod method);
}
