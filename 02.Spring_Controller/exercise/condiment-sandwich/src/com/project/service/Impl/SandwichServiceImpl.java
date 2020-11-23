package com.project.service.Impl;

import com.project.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class SandwichServiceImpl implements SandwichService {
    @Override
    public List<String> showAllCondiment(String[] condiment) {
        List<String> listCondiment = new ArrayList<>();
        Collections.addAll(listCondiment, condiment);
        return listCondiment;
    }
}
