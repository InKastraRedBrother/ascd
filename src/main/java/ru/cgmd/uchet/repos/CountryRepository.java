package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}