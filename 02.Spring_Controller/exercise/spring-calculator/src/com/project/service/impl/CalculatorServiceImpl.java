package com.project.service.impl;

import com.project.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double operatorAdd(double num1, double num2)
    {
        return num1+num2;
    }
    @Override
    public double operatorSub(double num1, double num2)
    {
        return num1-num2;
    }
    @Override
    public double operatorMulti(double num1, double num2)
    {
        return num1*num2;
    }
    @Override
    public double operatorDivision(double num1, double num2)
    {
        return num1/num2;
    }

}
