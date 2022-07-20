package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.Country;
import ru.cgmd.uchet.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public Country get(long idCountry) {
        return countryRepository.findById(idCountry).get();
    }

    public void delete(long idCountry) {
        countryRepository.deleteById(idCountry);
    }
}