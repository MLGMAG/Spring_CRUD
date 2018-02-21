package net.mlgmag.Spring_Crud;

import net.mlgmag.Spring_Crud.model.Role;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Role> roles;
        roles = Arrays.asList(Role.values());

        Role role = roles.get(1);

        System.out.println(roles);
        System.out.println();
    }
}
