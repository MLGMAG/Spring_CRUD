package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Role;
import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String userAddPage(Model model) {
        List<Role> roles = Arrays.asList(Role.values());
        model.addAttribute("roles", roles);
        return "userAdd";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute("user") User user,
                          @ModelAttribute("role") Role role) {

        user.setRole(role);
        System.out.println(user);
        userService.save(user);

        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "usersList";
    }

    @GetMapping("/{id}")
    public String userView(@PathVariable("id") UUID id, Model model) {

        model.addAttribute("user", userService.getById(id));
        return "userView";
    }

    @GetMapping("/update/{id}")
    public String userUpdatePage(@PathVariable("id") UUID uuid, Model model) {
        List<Role> roles = Arrays.asList(Role.values());
        model.addAttribute("user", userService.getById(uuid));
        model.addAttribute("roles", roles);
        return "userUpdate";
    }

    @PostMapping("/update/{id}")
    public String userUpdate(@PathVariable("id") UUID uuid,
                             @ModelAttribute("user") User user,
                             @ModelAttribute("role") Role role) {

        user.setId(uuid);
        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable("id") UUID uuid) {
        userService.delete(userService.getById(uuid));
        return "redirect:/user/list";
    }
}
