package com.project.service;

import com.project.entity.Items;

import java.util.List;

public interface ItemService {
    List<Items> findAll();
    Items findById(int id);
}
