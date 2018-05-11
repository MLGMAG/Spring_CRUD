package net.mlgmag.Spring_Crud.service.genericService;

import net.mlgmag.Spring_Crud.model.User;
import org.springframework.ui.Model;

import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {

    User findByUsername(String username);

    User findByEmail(String email);

    Boolean validate(User user, Model model);

}
