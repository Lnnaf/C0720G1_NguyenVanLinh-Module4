package com.project.service.impl;

import com.project.entity.WebUser;
import com.project.repository.WebUserRepository;
import com.project.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class WebUserServiceImpl implements WebUserService {
    @Autowired
    private WebUserRepository webUserRepository;

    @Override
    public void save(WebUser webUser) {
        System.out.println(webUser.getEncrytedPassword());
        String hashedPw = BCrypt.hashpw(webUser.getEncrytedPassword(), BCrypt.gensalt());
        webUser.setEncrytedPassword(hashedPw);
        webUserRepository.save(webUser);
    }
}
