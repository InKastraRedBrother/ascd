package ru.cgmd.uchet.domain;

import javax.persistence.*;

@Entity
@Table(name = "project_or_program")
public class ProjectOrProgram {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_name_project_or_program")
    private Long idProjectOrProgram;

    @Column(nullable = false, name="choice_project_or_program")
    private String choiceProjectOrProgram;
    @Column(nullable = false, name="fullname_project_or_program")
    private String fullnameProjectOrProgram;
    @Column(nullable = false, name="abbreviation_project_or_program")
    private String abbreviationProjectOrProgram;

    public Long getIdProjectOrProgram() {
        return idProjectOrProgram;
    }

    public void setIdProjectOrProgram(Long idProjectOrProgram) {
        this.idProjectOrProgram = idProjectOrProgram;
    }

    public String getChoiceProjectOrProgram() {
        return choiceProjectOrProgram;
    }

    public void setChoiceProjectOrProgram(String choiceProjectOrProgram) {
        this.choiceProjectOrProgram = choiceProjectOrProgram;
    }

    public String getFullnameProjectOrProgram() {
        return fullnameProjectOrProgram;
    }

    public void setFullnameProjectOrProgram(String fullnameProjectOrProgram) {
        this.fullnameProjectOrProgram = fullnameProjectOrProgram;
    }

    public String getAbbreviationProjectOrProgram() {
        return abbreviationProjectOrProgram;
    }

    public void setAbbreviationProjectOrProgram(String abbreviationProjectOrProgram) {
        this.abbreviationProjectOrProgram = abbreviationProjectOrProgram;
    }
}