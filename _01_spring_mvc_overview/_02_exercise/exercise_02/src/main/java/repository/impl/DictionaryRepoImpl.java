package repository.impl;

import repository.DictionaryRepo;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepoImpl implements DictionaryRepo {
    private static Map<String, String> mapDb = new HashMap<>();

    static {
        mapDb.put("hello", "Xin chao");
        mapDb.put("association", "Su ket hop");
        mapDb.put("tool", "Cong cu");
        mapDb.put("building", "Toa nha");
    }

    @Override
    public String translate(String englishWord) {
        for (Map.Entry<String, String> word : mapDb.entrySet()) {
            if (word.getKey().equals(englishWord)) {
                return word.getValue();
            }
        }
        return null;
    }
}
