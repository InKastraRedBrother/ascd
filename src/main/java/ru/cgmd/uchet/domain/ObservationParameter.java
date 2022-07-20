package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "observation_parameter")
public class ObservationParameter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_observation_parameter")
    private Long idObservationParameter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_observation_parameter_group")
    private ObservationParameterGroup observationParameterGroup;

    @Column(nullable = false, name="name_observation_parameter")
    private String nameObservationParameter;

    public Long getIdObservationParameter() {
        return idObservationParameter;
    }

    public void setIdObservationParameter(Long idObservationParameter) {
        this.idObservationParameter = idObservationParameter;
    }

    public ObservationParameterGroup getObservationParameterGroup() {
        return observationParameterGroup;
    }

    public void setObservationParameterGroup(ObservationParameterGroup observationParameterGroup) {
        this.observationParameterGroup = observationParameterGroup;
    }

    public String getNameObservationParameter() {
        return nameObservationParameter;
    }

    public void setNameObservationParameter(String nameObservationParameter) {
        this.nameObservationParameter = nameObservationParameter;
    }
}
