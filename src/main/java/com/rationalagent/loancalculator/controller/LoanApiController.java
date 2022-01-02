package com.rationalagent.loancalculator.controller;

import com.rationalagent.loancalculator.ApiError;
import com.rationalagent.loancalculator.repository.model.Loan;
import com.rationalagent.loancalculator.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoanApiController {

    @Autowired
    private LoanService service;

    @GetMapping("/loans")
    public List<Loan> readAll() {
        return service.readAll();
    }

    @GetMapping("/loans/{id}")
    public Loan read(@PathVariable("id") Long id) {
        return service.read(id);
    }

    @PostMapping("/loans")
    public Loan create() {
        return service.create(new Loan());
    }

    @PostMapping("/loans/{id}/calculate")
    public Loan calculate(@RequestBody @Valid Loan loan, @PathVariable("id") Long id) {
        return service.calculate(loan, id);
    }

    @PutMapping("/loans/{id}")
    public Loan update(@RequestBody Loan loan, @PathVariable("id") Long id) {
        return service.update(loan, id);
    }

    @DeleteMapping("/loans/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError myError(HttpServletRequest request, MethodArgumentNotValidException exception) {
        return new ApiError(
                HttpStatus.BAD_REQUEST,
                "The input data was invalid",
                exception.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(ObjectError::getDefaultMessage)
                        .collect(Collectors.toList())
        );
    }

}
