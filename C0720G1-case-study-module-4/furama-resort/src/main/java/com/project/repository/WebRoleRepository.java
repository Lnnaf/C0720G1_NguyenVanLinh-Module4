package com.project.repository;

import com.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WebRoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select role_name from role join user_role on role.role_id = user_role.role_id join user on user_role.username = user.username where user.username =?",nativeQuery = true)
    List<String> getAllRoleName(String username);
}
