package com.project.service;

import com.project.entity.BlogEntity;
import com.project.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {
    void save(BlogEntity blog);
    List<BlogEntity> findAll();
    Page<BlogEntity> findAll(Pageable pageable);
    BlogEntity findById(int id);
    Page<BlogEntity> findAllByCategory_id(int id,Pageable pageable);
    List<BlogEntity> findAllByCategory_id(int id);
    void delete(BlogEntity blogEntity);
    Page<BlogEntity>findAllByNameContaining(String name, Pageable pageable);
}
