package net.mlgmag.Spring_Crud.service.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
