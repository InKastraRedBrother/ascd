package ru.cgmd.uchet.repos;

import ru.cgmd.uchet.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    void findByCountryIdCountry(long idCountry);
}
