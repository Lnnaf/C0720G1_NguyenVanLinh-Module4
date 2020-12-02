package com.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
@Aspect
public class LibraryLogger {
    @AfterThrowing(pointcut = "execution(public * com.project.service.BookService.*(..))",throwing = "e")
    public void checkError(JoinPoint joinPoint, Exception e) {
//check here
    }
}
