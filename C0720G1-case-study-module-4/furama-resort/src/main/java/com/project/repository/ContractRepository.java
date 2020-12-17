package com.project.repository;

import com.project.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "SELECT * FROM furama_resort.contract where contract_end_date >= ? ",nativeQuery = true)
        List<Contract> findAllContractNotExpired(String today);
}
