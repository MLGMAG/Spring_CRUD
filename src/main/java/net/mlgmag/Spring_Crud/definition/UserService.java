package net.mlgmag.Spring_Crud.definition;

import net.mlgmag.Spring_Crud.model.User;
import org.springframework.ui.Model;

import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {

    void registration(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    Boolean usernameValidation(String username, Model model);

    Boolean emailValidation(String email, Model model);

}
