package service.impl;

import org.springframework.stereotype.Service;
import service.IDictionaryService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Override
    public String findWord(String keyWord) {
        Map<String, String> list = new HashMap<>();
        String result = null;
        list.put("hello", "Xin Chào");
        list.put("Love", "Tình Yêu");
        list.put("Bike", "Xe Máy");
        list.put("Planet", "Hành Tinh");

        for (Map.Entry<String, String> entry : list.entrySet()) {
            if (keyWord.equals(entry.getKey())) {
                result = list.get(keyWord);
                break;
            } else {
                result = "Can't find anything like that";
            }
        }
        return result;
    }
}
