package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ObservationType;
import ru.cgmd.uchet.repos.ObservationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObservationTypeService {
    @Autowired
    private ObservationTypeRepository observationTypeRepository;

    public List<ObservationType> listAll() {
        return observationTypeRepository.findAll();
    }

    public void save(ObservationType observationType) {
        observationTypeRepository.save(observationType);
    }

    public ObservationType get(long idObservationType) {
        return observationTypeRepository.findById(idObservationType).get();
    }

    public void delete(long idObservationType) {
        observationTypeRepository.deleteById(idObservationType);
    }

}