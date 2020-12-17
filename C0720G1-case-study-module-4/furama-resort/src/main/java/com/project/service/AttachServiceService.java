package com.project.service;

import com.project.entity.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();
    void save(AttachService attachService);
    void delete(Integer id);
    AttachService findById(Integer id);
}
