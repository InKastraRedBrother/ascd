package ru.cgmd.uchet.service;

import ru.cgmd.uchet.domain.Organization;
import ru.cgmd.uchet.repos.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> listAll() {
        return organizationRepository.findAll();
    }

    public void save(Organization organization) {
        organizationRepository.save(organization);
    }

    public Organization get(long idOrganization) {
        return organizationRepository.findById(idOrganization).get();
    }

    public void delete(long idOrganization) {
        organizationRepository.deleteById(idOrganization);
    }
}