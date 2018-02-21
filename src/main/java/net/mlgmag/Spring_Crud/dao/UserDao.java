package net.mlgmag.Spring_Crud.dao;

import net.mlgmag.Spring_Crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDao extends GenericDao<User, UUID> {
    User findByUsername(String username);
}
