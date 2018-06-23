package net.mlgmag.Spring_Crud.service.genericService;

import net.mlgmag.Spring_Crud.model.User;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean validate(User user, Model model);

}
