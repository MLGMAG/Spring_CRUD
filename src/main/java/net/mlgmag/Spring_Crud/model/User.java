package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "first_name", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "First name can't be empty")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Last name can't be empty")
    private String lastName;

    @Column(name = "username", columnDefinition = "VARCHAR(32)")
    @NotBlank(message = "Username name can't be empty")
    @Size(min = 6, max = 32, message = "Size must be from 6 to 32 characters")
    private String username;

    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    @Email(message = "Invalid email")
    @NotBlank(message = "Email can't be empty")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password can't be empty")
    @Size(min = 8, message = "Minimum password size is 8")
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

}
