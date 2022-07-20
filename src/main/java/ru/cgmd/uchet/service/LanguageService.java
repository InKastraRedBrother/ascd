package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.Language;
import ru.cgmd.uchet.repos.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> listAll() {
        return languageRepository.findAll();
    }

    public void save(Language language) {
        languageRepository.save(language);
    }

    public Language get(long idLanguage) {
        return languageRepository.findById(idLanguage).get();
    }

    public void delete(long idLanguage) {
        languageRepository.deleteById(idLanguage);
    }
}