package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "e_certificate")
public class Certificate {
    @Id
    @Column(name = "certificate_number")
    private String certificateNumber;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "end_school_date")
    private LocalDate endSchoolDate;
    @OneToMany(mappedBy = "certificate")
    private Set<Discipline> disciplines;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDate getEndSchoolDate() {
        return endSchoolDate;
    }

    public void setEndSchoolDate(LocalDate endSchoolDate) {
        this.endSchoolDate = endSchoolDate;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public StudentOrder getStudentOrder() {
        return studentOrder;
    }

    public void setStudentOrder(StudentOrder studentOrder) {
        this.studentOrder = studentOrder;
    }
}
