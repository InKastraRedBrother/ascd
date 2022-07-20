package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.GeographicalObject;
import ru.cgmd.uchet.repos.GeographicalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeographicalObjectService {
    @Autowired
    private GeographicalObjectRepository geographicalObjectRepository;

    public List<GeographicalObject> listAll() {
        return geographicalObjectRepository.findAll();
    }

    public void save(GeographicalObject geographicalObject) {
        geographicalObjectRepository.save(geographicalObject);
    }

    public GeographicalObject get(long idGeographicalObject) {
        return geographicalObjectRepository.findById(idGeographicalObject).get();
    }

    public void delete(long idGeographicalObject) {
        geographicalObjectRepository.deleteById(idGeographicalObject);
    }
}