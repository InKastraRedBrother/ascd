package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "observation_scope")
public class ObservationScope {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_observation_scope")
    private Long idObservationScope;

    @Column(nullable = false, name="name_observation_scope")
    private String nameObservationScope;

    public Long getIdObservationScope() {
        return idObservationScope;
    }

    public void setIdObservationScope(Long idObservationScope) {
        this.idObservationScope = idObservationScope;
    }

    public String getNameObservationScope() {
        return nameObservationScope;
    }

    public void setNameObservationScope(String nameObservationScope) {
        this.nameObservationScope = nameObservationScope;
    }
}
