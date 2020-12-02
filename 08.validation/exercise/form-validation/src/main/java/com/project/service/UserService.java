package com.project.service;

import com.project.entity.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    List<User> findAll();
}
