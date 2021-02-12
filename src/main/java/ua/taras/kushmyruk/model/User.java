package ua.taras.kushmyruk.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "e_usr")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private  Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "user_email")
    private String email;
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn (name = "user_id"))
    @Enumerated
    private Set<UserRole> userRoles;


}
