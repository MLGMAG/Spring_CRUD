package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;

    @NotBlank(message = "First name can't be empty")
    private String firstName;

    @NotBlank(message = "Last name can't be empty")
    private String lastName;

    @Indexed(unique = true)
    @NotBlank(message = "Username name can't be empty")
    @Size(min = 6, max = 32, message = "Size must be from 6 to 32 characters")
    private String username;

    @Indexed(unique = true)
    @Email(message = "Invalid email")
    @NotBlank(message = "Email can't be empty")
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 8, message = "Minimum password size is 8")
    private String password;

    @Transient
    private String confirmPassword;

    private Role role;

}
