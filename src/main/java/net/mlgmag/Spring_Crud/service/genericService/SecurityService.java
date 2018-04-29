package net.mlgmag.Spring_Crud.service.genericService;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
