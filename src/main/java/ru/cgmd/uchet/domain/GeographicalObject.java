package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "geographical_object")
public class GeographicalObject {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_geographical_object")
    private Long idGeographicalObject;

    @Column(nullable = false, name="name_geographical_object")
    private String nameGeographicalObject;

    public Long getIdGeographicalObject() { return idGeographicalObject; }

    public void setIdGeographicalObject(Long idGeographicalObject) { this.idGeographicalObject = idGeographicalObject; }

    public String getNameGeographicalObject() { return nameGeographicalObject; }

    public void setNameGeographicalObject(String nameGeographicalObject) { this.nameGeographicalObject = nameGeographicalObject; }
}
