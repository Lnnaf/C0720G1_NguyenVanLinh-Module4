package com.project.service.impl;

import com.project.entity.MailConfig;
import com.project.repository.MailConfigRepository;
import com.project.service.MailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailConfigServiceImpl implements MailConfigService {
    @Autowired
    private MailConfigRepository mailConfigRepository;

    @Override
    public List<String> getLanguage() {
        return mailConfigRepository.getLanguage();
    }

    @Override
    public List<String> getSizePage() {
        return mailConfigRepository.getSizePage();
    }
}
