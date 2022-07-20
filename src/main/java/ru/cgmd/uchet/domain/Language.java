package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_language")
    private Long idLanguage;

    @Column(nullable = false, name="name_language")
    private String nameLanguage;

    public Long getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Long idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public void setNameLanguage(String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }
}