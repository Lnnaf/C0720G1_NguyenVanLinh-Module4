package com.project.service.impl;

import com.project.entity.BlogEntity;
import com.project.entity.Category;
import com.project.repository.BlogRepository;
import com.project.repository.CategoryRepository;
import com.project.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void save(BlogEntity blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<BlogEntity> findAll() {
       return blogRepository.findAll();
    }

    @Override
    public Page<BlogEntity> findAll(Pageable pageable) {
        return  blogRepository.findAll(pageable);
    }

    @Override
    public BlogEntity findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<BlogEntity> findAllByCategory_id(int id,Pageable pageable) {
        return blogRepository.findAllByCategory_Id(id,pageable);
    }

    @Override
    public List<BlogEntity> findAllByCategory_id(int id) {
        return blogRepository.findAllByCategory_Id(id);
    }

    @Override
    public void delete(BlogEntity blogEntity) {
        blogRepository.delete(blogEntity);
    }

    @Override
    public Page<BlogEntity> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name,pageable);
    }
}
