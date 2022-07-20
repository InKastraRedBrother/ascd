package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.ObservationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationTypeRepository extends JpaRepository<ObservationType, Long> {
}
