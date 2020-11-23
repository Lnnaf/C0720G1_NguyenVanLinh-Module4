package com.project.service.impl;

import com.project.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceDivisionImpl implements CalculatorService {
    @Override
    public double operator(double num1, double num2) {
        return num1/num2;
    }
}
