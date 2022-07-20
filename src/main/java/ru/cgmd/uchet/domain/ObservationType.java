package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "observation_type")
public class ObservationType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_observation_type")
    private Long idObservationType;

    @Column(nullable = false, name="name_observation_type")
    private String nameObservationType;

    public Long getIdObservationType() {
        return idObservationType;
    }

    public void setIdObservationType(Long idObservationType) {
        this.idObservationType = idObservationType;
    }

    public String getNameObservationType() {
        return nameObservationType;
    }

    public void setNameObservationType(String nameObservationType) {
        this.nameObservationType = nameObservationType;
    }
}
