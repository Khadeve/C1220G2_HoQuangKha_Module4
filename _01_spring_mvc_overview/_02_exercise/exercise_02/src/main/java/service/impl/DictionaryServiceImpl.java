package service.impl;

import repository.DictionaryRepo;
import repository.impl.DictionaryRepoImpl;
import service.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {
    private DictionaryRepo dictionaryRepo = new DictionaryRepoImpl();

    @Override
    public String translate(String englishWord) {
        return dictionaryRepo.translate(englishWord);
    }
}
