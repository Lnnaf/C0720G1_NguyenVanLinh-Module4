package com.project.annotation_custom;

import com.project.common.ValidateAge;
import com.project.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

public class ValidateAgeAnnotation  implements ConstraintValidator<ValidateAge, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("")){
            return false;
        }else{ LocalDate now = LocalDate.now();
            LocalDate bd = LocalDate.parse(value);
            return now.compareTo(bd) - 18 > 0;}

    }

}
