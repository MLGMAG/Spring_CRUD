package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Role;
import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.repository.UserRepository;
import net.mlgmag.Spring_Crud.service.service.UserService;
import net.mlgmag.Spring_Crud.service.serviceImpl.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "User/userAdd";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/")
    public String userUpdatePage(@RequestParam(value = "id") UUID uuid, Model model) {
        List<Role> roles = Arrays.asList(Role.values());
        model.addAttribute("user", userService.getById(uuid));
        model.addAttribute("roles", roles);
        return "User/userUpdate";
    }

    @PostMapping("/update/")
    public String userUpdate(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/")
    public String userDelete(@RequestParam(value = "id") UUID uuid) {
        userService.delete(userService.getById(uuid));
        return "redirect:/user/list";
    }

    @GetMapping("/")
    public String userView(@RequestParam(value = "id") UUID uuid, Model model) {
        model.addAttribute("user", userService.getById(uuid));
        return "User/userView";
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "User/usersList";
    }
}
