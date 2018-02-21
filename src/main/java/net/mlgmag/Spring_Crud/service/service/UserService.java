package net.mlgmag.Spring_Crud.service.service;

import net.mlgmag.Spring_Crud.model.User;

import java.util.UUID;

public interface UserService extends GenericService<User, UUID> {
    User findByUsername(String username);
}
