package com.project.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "webUsers")
    Set<Role> roles;
    @OneToMany(mappedBy = "webUser")
    Set<Employee> employees;

    public WebUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
