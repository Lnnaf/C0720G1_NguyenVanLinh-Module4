package com.project.repository;

import com.project.entity.WebRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WebRoleRepository extends JpaRepository<WebRole,Integer> {
    @Query(value = "select name from role join user_role on role.id_role = user_role.id_role join user on user_role.id_user = user.id_user where user.id_user =?1",nativeQuery = true)
    List<String> getAllRoleName(Integer idUser);
}
