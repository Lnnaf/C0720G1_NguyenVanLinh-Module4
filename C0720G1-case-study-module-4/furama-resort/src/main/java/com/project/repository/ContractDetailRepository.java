package com.project.repository;

import com.project.entity.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
