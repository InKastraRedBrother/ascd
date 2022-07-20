package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ObservationParameter;
import ru.cgmd.uchet.repos.ObservationParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObservationParameterService {
    @Autowired
    private ObservationParameterRepository observationParameterRepository;

    public List<ObservationParameter> listAll() {
        return observationParameterRepository.findAll();
    }

    public void save(ObservationParameter observationParameter) {
        observationParameterRepository.save(observationParameter);
    }

    public ObservationParameter get(long idObservationParameter) {
        return observationParameterRepository.findById(idObservationParameter).get();
    }

    public void delete(long idObservationParameter) {
        observationParameterRepository.deleteById(idObservationParameter);
    }
}