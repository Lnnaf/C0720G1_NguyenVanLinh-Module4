package com.project.service;

import com.project.entity.MailConfig;

import java.util.List;

public interface MailConfigService {
    List<String> getLanguage();
    List<String> getSizePage();
}
