package net.mlgmag.Spring_Crud.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
