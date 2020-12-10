package com.project.repository;

import com.project.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface WebUserRepository extends JpaRepository<WebUser,Integer> {
    WebUser findByUsername(String username);
}
