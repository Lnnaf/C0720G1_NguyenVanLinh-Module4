package com.project.service.impl;

import com.project.entity.LibCard;
import com.project.repository.CardRepository;
import com.project.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public List<LibCard> findAll() {
        return cardRepository.findAll();
    }
}
