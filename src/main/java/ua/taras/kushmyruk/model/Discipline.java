package ua.taras.kushmyruk.model;

import javax.persistence.*;

@Entity
@Table(name = "discipline")
public class Discipline {

    @Id
    @Column(name = "discipline_name")
    private String disciplineName;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "faculty_name")
    private Faculty faculty;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name= "certificate_id")
    private Certificate certificate;

    public Discipline(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Discipline() {
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}
