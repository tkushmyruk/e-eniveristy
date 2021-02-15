package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "e_student_order")
public class StudentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_order_id")
    private Long studentOrderId;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "studentOrder")
    private Student student;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "studentOrder")
    private Certificate studentCertificate;
    @OneToOne(cascade = {CascadeType.REFRESH} , mappedBy = "studentOrder")
    private Faculty faculty;
    @Enumerated
    @Column(name = "education_form")
    private EducationFrom educationFrom;

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public LocalDate getIssuDate() {
        return issueDate;
    }

    public void setIssuDate(LocalDate issuDate) {
        this.issueDate = issuDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Certificate getStudentCertificate() {
        return studentCertificate;
    }

    public void setStudentCertificate(Certificate studentCertificate) {
        this.studentCertificate = studentCertificate;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public EducationFrom getEducationFrom() {
        return educationFrom;
    }

    public void setEducationFrom(EducationFrom educationFrom) {
        this.educationFrom = educationFrom;
    }
}
