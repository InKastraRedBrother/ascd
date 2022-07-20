package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.ObservationParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationParameterRepository extends JpaRepository<ObservationParameter, Long> {
}
