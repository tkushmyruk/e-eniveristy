package ua.taras.kushmyruk.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "e_student")
public class Student extends User {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "student")
    private Address address;
    @OneToOne(cascade = {CascadeType.REFRESH}, mappedBy = "student")
    private Passport passport;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "faculty_name")
    private Faculty faculty;
}
