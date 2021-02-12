package ua.taras.kushmyruk.model;

import javax.persistence.*;

@Entity
@Table(name = "e_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passport_id")
    private Long addressId;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private String building;
    @Column(name = "apartment")
    private String apartment;
    @Column(name = "post_code")
    private String postCode;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Student student;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(columnDefinition = "faculty_name")
    private Faculty faculty;
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "university_name")
    private University university;
}
