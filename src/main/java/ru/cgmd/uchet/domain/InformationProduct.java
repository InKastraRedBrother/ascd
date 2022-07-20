package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "information_product")
public class InformationProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_information_product")
    private Long idInformationProduct;

    @ManyToOne(fetch = FetchType.LAZY) //страна
    @JoinColumn (name = "id_country")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY) //язык
    @JoinColumn (name = "id_language")
    private  Language language;

    @ManyToOne(fetch = FetchType.LAZY) //дисциплина наблюдений
    @JoinColumn (name = "id_observation_discipline")
    private ObservationDiscipline observationDiscipline;

    @ManyToOne(fetch = FetchType.LAZY) //проект или программа
    @JoinColumn (name = "id_project_or_program")
    private ProjectOrProgram projectOrProgram;

    @ManyToOne(fetch = FetchType.LAZY) //вид наблюдений
    @JoinColumn (name = "id_observation_type")
    private ObservationType observationType;

    @ManyToOne(fetch = FetchType.LAZY) //параметры наблюдений
    @JoinColumn (name = "id_observation_parameter")
    private ObservationParameter observationParameter;

    @ManyToOne(fetch = FetchType.LAZY) //группа параметров наблюдений
    @JoinColumn (name = "id_observation_parameter_group")
    private ObservationParameterGroup observationParameterGroup;

    @ManyToOne(fetch = FetchType.LAZY) //сфера наблюдений
    @JoinColumn (name = "id_observation_scope")
    private ObservationScope observationScope ;

    @ManyToOne(fetch = FetchType.LAZY) //географический объект
    @JoinColumn (name = "id_geographical_object")
    private GeographicalObject geographicalObject ;

    @ManyToOne(fetch = FetchType.LAZY) //организация
    @JoinColumn (name = "id_organization")
    private Organization organization ;

    @ManyToOne(fetch = FetchType.LAZY) //пользователь
    @JoinColumn (name = "id_usr")
    private User user;

    @Column(nullable = false, name="inventory_number")
    private String inventoryNumber;

    @Column(nullable = false, name="fullname_cdrom")
    private String fullnameCdrom;

    @Column(nullable = false, name="abbreviation_cdrom")
    private String abbreviationCdrom;

    @Column(nullable = false, name="date_observation_start")
    private String dateObservationStart;

    @Column(nullable = false, name="date_observation_end")
    private String dateObservationEnd;

    @Column(nullable = false, name="brief_content")
    private String briefContent;

    @Column(nullable = false, name="volume")
    private String volume;

    @Column(nullable = false, name="received_date")
    private String receivedDate;

    @Column(nullable = false, name="date_of_entering")
    private String dateOfEntering;

    @Column(name="upload_file")
    private String uploadFile;

    public Long getIdInformationProduct() { return idInformationProduct; }

    public void setIdInformationProduct(Long idInformationProduct) { this.idInformationProduct = idInformationProduct; }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public ObservationDiscipline getObservationDiscipline() {
        return observationDiscipline;
    }

    public void setObservationDiscipline(ObservationDiscipline observationDiscipline) {
        this.observationDiscipline = observationDiscipline;
    }

    public ProjectOrProgram getProjectOrProgram() {
        return projectOrProgram;
    }

    public void setProjectOrProgram(ProjectOrProgram projectOrProgram) {
        this.projectOrProgram = projectOrProgram;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    public ObservationParameter getObservationParameter() {
        return observationParameter;
    }

    public void setObservationParameter(ObservationParameter observationParameter) {
        this.observationParameter = observationParameter;
    }

    public ObservationParameterGroup getObservationParameterGroup() {
        return observationParameterGroup;
    }

    public void setObservationParameterGroup(ObservationParameterGroup observationParameterGroup) {
        this.observationParameterGroup = observationParameterGroup;
    }

    public ObservationScope getObservationScope() {
        return observationScope;
    }

    public void setObservationScope(ObservationScope observationScope) {
        this.observationScope = observationScope;
    }

    public GeographicalObject getGeographicalObject() {
        return geographicalObject;
    }

    public void setGeographicalObject(GeographicalObject geographicalObject) {
        this.geographicalObject = geographicalObject;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getFullnameCdrom() {
        return fullnameCdrom;
    }

    public void setFullnameCdrom(String fullnameCdrom) {
        this.fullnameCdrom = fullnameCdrom;
    }

    public String getAbbreviationCdrom() {
        return abbreviationCdrom;
    }

    public void setAbbreviationCdrom(String abbreviationCdrom) {
        this.abbreviationCdrom = abbreviationCdrom;
    }

    public String getDateObservationStart() {
        return dateObservationStart;
    }

    public void setDateObservationStart(String dateObservationStart) {
        this.dateObservationStart = dateObservationStart;
    }

    public String getDateObservationEnd() {
        return dateObservationEnd;
    }

    public void setDateObservationEnd(String dateObservationEnd) {
        this.dateObservationEnd = dateObservationEnd;
    }

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getDateOfEntering() {
        return dateOfEntering;
    }

    public void setDateOfEntering(String dateOfEntering) {
        this.dateOfEntering = dateOfEntering;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    public InformationProduct() {
    }

    public InformationProduct(Country country, Language language, ObservationDiscipline observationDiscipline, ProjectOrProgram projectOrProgram, ObservationType observationType, ObservationParameter observationParameter, ObservationParameterGroup observationParameterGroup, ObservationScope observationScope, GeographicalObject geographicalObject, Organization organization, String inventoryNumber, String fullnameCdrom, String abbreviationCdrom, String dateObservationStart, String dateObservationEnd, String briefContent, String volume, String receivedDate) {
        this.country = country;
        this.language = language;
        this.observationDiscipline = observationDiscipline;
        this.projectOrProgram = projectOrProgram;
        this.observationType = observationType;
        this.observationParameter = observationParameter;
        this.observationParameterGroup = observationParameterGroup;
        this.observationScope = observationScope;
        this.geographicalObject = geographicalObject;
        this.organization = organization;
        this.inventoryNumber = inventoryNumber;
        this.fullnameCdrom = fullnameCdrom;
        this.abbreviationCdrom = abbreviationCdrom;
        this.dateObservationStart = dateObservationStart;
        this.dateObservationEnd = dateObservationEnd;
        this.briefContent = briefContent;
        this.volume = volume;
        this.receivedDate = receivedDate;
    }
}
