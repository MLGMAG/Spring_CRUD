package net.mlgmag.Spring_Crud.service.service;

import net.mlgmag.Spring_Crud.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {

    User findByUsername(String username);

    User findByEmail(String email);

    Boolean validate(User user, Model model);

}
