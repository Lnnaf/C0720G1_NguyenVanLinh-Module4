package com.project.service;

import com.project.entity.WebUser;
import com.project.repository.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface WebUserService {
   void save(WebUser webUser);
}
