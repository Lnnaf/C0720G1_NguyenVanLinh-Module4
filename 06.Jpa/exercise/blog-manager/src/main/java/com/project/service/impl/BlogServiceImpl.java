package com.project.service;

import com.project.entity.BlogEntity;
import com.project.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
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
    public void delete(BlogEntity blogEntity) {
        blogRepository.delete(blogEntity);
    }
}
