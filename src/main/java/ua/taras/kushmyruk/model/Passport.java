package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "e_passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passport_id")
    private Long passportId;
    @Column(name = "passport_seria")
    private String passportSeria;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "passport_issue_date")
    private LocalDate issueDate;
    @Column(name = "registration_office_name")
    private String registrationOfficeName;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Student student;

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getRegistrationOfficeName() {
        return registrationOfficeName;
    }

    public void setRegistrationOfficeName(String registrationOfficeName) {
        this.registrationOfficeName = registrationOfficeName;
    }
}
