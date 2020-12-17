package com.project.repository;

import com.project.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser,String> {
    WebUser findByUsername(String username);
}
