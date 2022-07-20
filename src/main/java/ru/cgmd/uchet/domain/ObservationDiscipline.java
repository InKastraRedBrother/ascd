package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "observation_discipline")
public class ObservationDiscipline {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_observation_discipline")
    private Long idObservationDiscipline;

    @Column(nullable = false, name="name_observation_discipline")
    private String nameObservationDiscipline;

    public Long getIdObservationDiscipline() {
        return idObservationDiscipline;
    }

    public void setIdObservationDiscipline(Long idObservationDiscipline) {
        this.idObservationDiscipline = idObservationDiscipline;
    }

    public String getNameObservationDiscipline() {
        return nameObservationDiscipline;
    }

    public void setNameObservationDiscipline(String nameObservationDiscipline) {
        this.nameObservationDiscipline = nameObservationDiscipline;
    }
}