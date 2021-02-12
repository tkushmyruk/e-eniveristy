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
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Student student;
}
