package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.ObservationParameterGroup;
import ru.cgmd.uchet.repos.ObservationParameterGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObservationParameterGroupService {
    @Autowired
    private ObservationParameterGroupRepository observationParameterGroupRepository;

    public List<ObservationParameterGroup> listAll() {
        return observationParameterGroupRepository.findAll();
    }

    public void save(ObservationParameterGroup observationParameterGroup) {
        observationParameterGroupRepository.save(observationParameterGroup);
    }

    public ObservationParameterGroup get(long idObservationParameterGroup) {
        return observationParameterGroupRepository.findById(idObservationParameterGroup).get();
    }

    public void delete(long idObservationParameterGroup) {
        observationParameterGroupRepository.deleteById(idObservationParameterGroup);
    }
}