package com.project.service;

import com.project.entity.BlogEntity;

import java.util.List;

public interface BlogService {
    void save(BlogEntity blog);
    List<BlogEntity> findAll();
    BlogEntity findById(int id);
    void delete(BlogEntity blogEntity);
}
