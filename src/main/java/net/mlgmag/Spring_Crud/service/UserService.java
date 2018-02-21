package net.mlgmag.Spring_Crud.service;

import net.mlgmag.Spring_Crud.dao.GenericDao;
import net.mlgmag.Spring_Crud.model.User;

import java.util.UUID;

public interface UserService extends GenericDao<User, UUID> {

    User finedByUsername(String username);
}
