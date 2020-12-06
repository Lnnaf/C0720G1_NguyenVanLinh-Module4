package com.project.entity;

import com.project.annotation_custom.ValidateAgeAnnotation;
import com.project.common.ValidateAge;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Entity(name="user")
public class User  {
    @Id()
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotEmpty
    @Size(min=5,max = 45)
    private String user_first_name;
    @NotEmpty
    @Size(min=5,max = 45)
    private String user_last_name;
    @NotEmpty
    @Pattern(regexp="(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "Wrong number format")
    private String phone;
    @NotEmpty
    @ValidateAge
    private String date;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
