package com.project.controller;

import com.project.entity.BlogEntity;
import com.project.entity.Category;
import com.project.service.BlogService;
import com.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("apiBlog")
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list-blog")
    public ResponseEntity<List<BlogEntity>> getAllBlog(){
        List<BlogEntity> listBlog = blogService.findAll();
        if(listBlog.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(listBlog,HttpStatus.ACCEPTED);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<BlogEntity> getDetail(@PathVariable Integer id){
        BlogEntity blogEntity = blogService.findById(id);
        return new ResponseEntity<>(blogEntity,HttpStatus.ACCEPTED);
    }
    @GetMapping("category")
    public  ResponseEntity<List<Category>> getAllCategory(){
        List<Category> listCategory = categoryService.findAll();
        if(listCategory.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(listCategory,HttpStatus.OK);
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<BlogEntity>> getBlogByCategoryId(@PathVariable Integer id){
        List<BlogEntity> listBlog = blogService.findAllByCategory_id(id);
        if(listBlog.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(listBlog,HttpStatus.ACCEPTED);
    }

}
