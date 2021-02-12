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
    private LocalDate issuDate;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "studentOrder")
    private Student student;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "studentOrder")
    private Certificate studentCertificate;
    @OneToOne(cascade = {CascadeType.REFRESH} , mappedBy = "studentOrder")
    private Faculty faculty;
    @Enumerated
    @Column(name = "education_form")
    private EducationFrom educationFrom;
}
