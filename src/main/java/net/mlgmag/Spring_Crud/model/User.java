package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "username", columnDefinition = "VARCHAR(32)", unique = true)
    private String username;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Column(name = "email", columnDefinition = "VARCHAR(255)", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "authorities", nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authorities;

    @Column(name = "NonExpired")
    private boolean isAccountNonExpired;
    @Column(name = "NonLocked")
    private boolean isAccountNonLocked;
    @Column(name = "CredentialsNonExpired")
    private boolean isCredentialsNonExpired;
    @Column(name = "Enabled")
    private boolean isEnabled;
}
