package com.project.repository.impl;

import com.project.entity.MailConfig;
import com.project.repository.MailConfigRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MailConfigRepositoryImpl implements MailConfigRepository {
    static List<String> listLanguage = new ArrayList<>();
    static List<String> listSizePage = new ArrayList<>();
    static{
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        listSizePage.add("5");
        listSizePage.add("10");
        listSizePage.add("15");
        listSizePage.add("25");
        listSizePage.add("50");
        listSizePage.add("100");
    }

    @Override
    public List<String> getLanguage() {
        return listLanguage;
    }

    @Override
    public List<String> getSizePage() {
        return listSizePage;
    }


}
