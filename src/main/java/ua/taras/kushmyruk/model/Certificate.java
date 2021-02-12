package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "e_certificate")
public class Certificate {
    @Id
    @Column(name = "certificate_number")
    private Long certificateNumber;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "end_school_date")
    private LocalDate endSchoolDate;
    @ElementCollection
    @CollectionTable(name = "discipline_score", joinColumns = {
            @JoinColumn(name = "discipline_name")
    }
    )
    @MapKeyColumn(name = "discipline")
    @Column(name = "score")
    private Map<String, Integer> disciplineScores;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

}
