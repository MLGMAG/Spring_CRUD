package net.mlgmag.Spring_Crud.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
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

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role=" + role +
                '}';
    }
}
