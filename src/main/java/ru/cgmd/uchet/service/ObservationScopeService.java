package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ObservationScope;
import ru.cgmd.uchet.repos.ObservationScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObservationScopeService {
    @Autowired
    private ObservationScopeRepository observationScopeRepository;

    public List<ObservationScope> listAll() {
        return observationScopeRepository.findAll();
    }

    public void save(ObservationScope observationScope) {
        observationScopeRepository.save(observationScope);
    }

    public ObservationScope get(long idObservationScope) {
        return observationScopeRepository.findById(idObservationScope).get();
    }

    public void delete(long idObservationScope) {
        observationScopeRepository.deleteById(idObservationScope);
    }

}