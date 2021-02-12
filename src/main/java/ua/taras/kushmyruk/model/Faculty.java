package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "e_faculty")
public class Faculty {
    @Id
    @Column(name = "faculty_name")
    private String facultyName;
    @Column(name = "free_places")
    private int freePlaces;
    @Column(name = "scholarship_places")
    private int scholarshipPlaces;
    @OneToOne(cascade = {CascadeType.REFRESH})
    private Address facultyAddress;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "univeristy_name")
    private University university;
    @OneToMany(cascade = {CascadeType.REFRESH}, mappedBy = "faculty")
    private Set<Discipline> facultyDisciplines;
    @OneToMany(cascade = {CascadeType.REFRESH}, mappedBy = "faculty")
    private List<Student> student;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

    @PrePersist
    public void prePersistDisciplines(){
        if(facultyDisciplines == null){
            List<Discipline> defaultDisceplines = new ArrayList<>();
            facultyDisciplines = new HashSet<>(Arrays.asList(
                    new Discipline("Literature"),
                    new Discipline("Maths"),
                    new Discipline("Biology"),
                    new Discipline("Physics"),
                    new Discipline("Philosophy"),
                    new Discipline("Philology"),
                    new Discipline("Law"),
                    new Discipline("Politics"),
                    new Discipline("Geography"),
                    new Discipline("Chemistry"),
                    new Discipline("History"),
                    new Discipline("Life safety fundamentals"),
                    new Discipline("Computer science")
                    ));
        }
    }

}
