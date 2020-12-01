package com.project.service;

import com.project.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    void delete(Category category);
    Optional<Category> findById(int id);
}
