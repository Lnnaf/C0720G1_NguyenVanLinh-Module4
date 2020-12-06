package com.project.service.impl;

import com.project.entity.Items;
import com.project.repository.ItemRepository;
import com.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Items> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Items findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }
}
