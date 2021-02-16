package ua.taras.kushmyruk.model;

import javax.persistence.*;

@Entity
@Table(name = "e_discipline")
public class Discipline {

    @Id
    @Column(name = "discipline_name")
    private String disciplineName;
    @Column(name = "disciplineScore")
    private Integer score;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "faculty_name")
    private Faculty faculty;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name= "certificate_id")
    private Certificate certificate;

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
