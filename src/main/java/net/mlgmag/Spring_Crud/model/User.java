package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import net.mlgmag.Spring_Crud.enums.Authority;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "username", columnDefinition = "VARCHAR(32)", unique = true)
    private String username;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Column(name = "email", columnDefinition = "VARCHAR(255)", unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(60)")
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "authority", columnDefinition = "VARCHAR(255)", nullable = false)
    private Set<Authority> authorities;

    @Column(name = "NonExpired", columnDefinition = "boolean")
    private boolean isAccountNonExpired;
    @Column(name = "NonLocked", columnDefinition = "boolean")
    private boolean isAccountNonLocked;
    @Column(name = "CredentialsNonExpired", columnDefinition = "boolean")
    private boolean isCredentialsNonExpired;
    @Column(name = "Enabled", columnDefinition = "boolean")
    private boolean isEnabled;

}
