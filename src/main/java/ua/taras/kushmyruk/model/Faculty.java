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
    private Set<Discipline> requiredDisciplines;
    @OneToMany(cascade = {CascadeType.REFRESH}, mappedBy = "faculty")
    private List<Student> candidates;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public int getScholarshipPlaces() {
        return scholarshipPlaces;
    }

    public void setScholarshipPlaces(int scholarshipPlaces) {
        this.scholarshipPlaces = scholarshipPlaces;
    }

    public Address getFacultyAddress() {
        return facultyAddress;
    }

    public void setFacultyAddress(Address facultyAddress) {
        this.facultyAddress = facultyAddress;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Set<Discipline> getRequiredDisciplines() {
        return requiredDisciplines;
    }

    public void setRequiredDisciplines(Set<Discipline> requiredDisciplines) {
        this.requiredDisciplines = requiredDisciplines;
    }

    public List<Student> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Student> candidates) {
        this.candidates = candidates;
    }

    public StudentOrder getStudentOrder() {
        return studentOrder;
    }

    public void setStudentOrder(StudentOrder studentOrder) {
        this.studentOrder = studentOrder;
    }
}
