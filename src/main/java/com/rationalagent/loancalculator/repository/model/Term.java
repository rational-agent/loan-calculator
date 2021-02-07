package com.rationalagent.loancalculator.repository.model;

public class Term {

    private final int inMonths;
    private final int inYears;

    public Term(int inMonths, int inYears) {
        this.inMonths = inMonths;
        this.inYears = inYears;
    }

    public int getInMonths() {
        return inMonths;
    }

    public int getInYears() {
        return inYears;
    }
}
