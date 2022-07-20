package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.ObservationDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationDisciplineRepository  extends JpaRepository<ObservationDiscipline, Long> {
}
