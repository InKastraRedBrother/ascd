package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_country")
    private Long idCountry;

    @Column(nullable = false, name="name_country")
    private String nameCountry;

    public Long getIdCountry() { return idCountry; }

    public void setIdCountry(Long idCountry) { this.idCountry = idCountry; }

    public String getNameCountry() { return nameCountry; }

    public void setNameCountry(String name_country) { this.nameCountry = name_country; }

    public Country() {
    }

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return nameCountry;
    }
}