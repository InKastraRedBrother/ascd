package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ObservationDiscipline;
import ru.cgmd.uchet.repos.ObservationDisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObservationDisciplineService {
    @Autowired
    private ObservationDisciplineRepository observationDisciplineRepository;

    public List<ObservationDiscipline> listAll() {
        return observationDisciplineRepository.findAll();
    }

    public void save(ObservationDiscipline observationDiscipline) {
        observationDisciplineRepository.save(observationDiscipline);
    }

    public ObservationDiscipline get(long idObservationDiscipline) {
        return observationDisciplineRepository.findById(idObservationDiscipline).get();
    }

    public void delete(long idObservationDiscipline) {
        observationDisciplineRepository.deleteById(idObservationDiscipline);
    }
}