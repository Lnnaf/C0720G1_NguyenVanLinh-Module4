package com.project.repository;

import com.project.entity.BlogEntity;
import com.project.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {
Page<BlogEntity> findAllByCategory_Id(int id, Pageable pageable);
List<BlogEntity> findAllByCategory_Id(int id);
Page<BlogEntity> findAllByNameContaining(String name,Pageable pageable);
}
