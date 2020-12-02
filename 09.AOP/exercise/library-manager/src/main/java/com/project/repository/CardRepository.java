package com.project.repository;

import com.project.entity.LibCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibCard,Integer> {
}
