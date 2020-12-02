package com.project.service.impl;

import com.project.entity.Bill;
import com.project.repository.BillRepository;
import com.project.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BillServiceImpl  implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public String getToDay() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public void saveBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll( pageable);
    }

    @Override
    public void remove(int id) {
        billRepository.deleteById(id);
    }

    @Override
    public Bill findById(int id) {
        return billRepository.getOne(id);
    }
}
