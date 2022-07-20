package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "observation_parameter_group")
public class ObservationParameterGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_observation_parameter_group")
    private Long idObservationParameterGroup;

    @Column(nullable = false, name="name_observation_parameter_group")
    private String nameObservationParameterGroup;

    public Long getIdObservationParameterGroup() {
        return idObservationParameterGroup;
    }

    public void setIdObservationParameterGroup(Long idObservationParameterGroup) {
        this.idObservationParameterGroup = idObservationParameterGroup;
    }

    public String getNameObservationParameterGroup() {
        return nameObservationParameterGroup;
    }

    public void setNameObservationParameterGroup(String nameObservationParameterGroup) {
        this.nameObservationParameterGroup = nameObservationParameterGroup;
    }
}
