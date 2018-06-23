package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.definition.UserService;
import net.mlgmag.Spring_Crud.enums.Authority;
import net.mlgmag.Spring_Crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
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
        model.addAttribute("authorities", Authority.values());
        model.addAttribute(new User());
        model.addAttribute("title", "Add User");
        return "User/userAdd";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userAdd(@ModelAttribute("user") User user, Model model) {

        if (userService.validate(user, model)) {
            model.addAttribute("authorities", Authority.values());
            model.addAttribute("title", "Add User");
            return "User/userAdd";
        }

        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update")
    public String userUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        User user = userService.findById(id).orElse(null);
        Objects.requireNonNull(user).setPassword(null);
        model.addAttribute("user", user);
        model.addAttribute("authorities", Authority.values());
        model.addAttribute("title", "Edit User");
        return "User/userUpdate";
    }

    @PostMapping("/update")
    public String userUpdate(@ModelAttribute("user") User user, Model model) {

        Optional<User> userOptional = userService.findById(user.getId());

        boolean Error = false;
        if (!user.getUsername().equals(userOptional.map(User::getUsername).orElse(null))) {
            if (userService.findByUsername(user.getUsername()).orElse(null) != null) {
                Error = true;
                model.addAttribute("DuplicateUsername", "Username already exist");
            }
        }

        if (!user.getEmail().equals(userOptional.map(User::getEmail).orElse(null))) {
            if (userService.findByEmail(user.getEmail()).orElse(null) != null) {
                Error = true;
                model.addAttribute("DuplicateEmail", "Email already exist");
            }
        }

        if (Error) {
            model.addAttribute("authorities", Authority.values());
            model.addAttribute("title", "Edit User");
            return "User/userUpdate";
        }

        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String userDelete(@RequestParam(value = "id") UUID id) {
        userService.findById(id).ifPresent(userService::delete);
        return "redirect:/user/list";
    }

    @GetMapping("/")
    public String userView(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("user", userService.findById(id).orElse(null));
        model.addAttribute("title", "User");
        return "User/userView";
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("title", "Users");
        return "User/usersList";
    }

}
