package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_organization")
    private Long idOrganization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false, name = "id_country")
    private Country country;

    @Column(nullable = false, name="fullname_organization")
    private String fullnameOrganization;

    @Column(nullable = false, name="abbreviation_organization")
    private String abbreviationOrganization;

    public Long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(Long idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFullnameOrganization() {
        return fullnameOrganization;
    }

    public void setFullnameOrganization(String fullnameOrganization) {
        this.fullnameOrganization = fullnameOrganization;
    }

    public String getAbbreviationOrganization() {
        return abbreviationOrganization;
    }

    public void setAbbreviationOrganization(String abbreviationOrganization) {
        this.abbreviationOrganization = abbreviationOrganization;
    }

    public Organization() {
    }

    public Organization(Country country, String fullnameOrganization, String abbreviationOrganization) {
        this.country = country;
        this.fullnameOrganization = fullnameOrganization;
        this.abbreviationOrganization = abbreviationOrganization;
    }
}