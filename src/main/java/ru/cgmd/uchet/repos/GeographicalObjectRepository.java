package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.GeographicalObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeographicalObjectRepository extends JpaRepository<GeographicalObject, Long> {

}
