package com.project.repository;

import com.project.entity.MailConfig;

import java.util.List;

public interface MailConfigRepository {
    List<String> getLanguage();
    List<String> getSizePage();

}
