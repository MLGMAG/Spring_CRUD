package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.service.genericService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("authorities", userService.findAllAuthority());
        model.addAttribute("user", new User());
        model.addAttribute("title", "Add User");
        return "User/userAdd";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute("user") User user, Model model) {

        if (userService.validate(user, model)) {
            model.addAttribute("authorities", userService.findAllAuthority());
            model.addAttribute("title", "Add User");
            return "User/userAdd";
        }

        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/")
    public String userUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        User user = userService.findById(id);
        user.setPassword(null);
        model.addAttribute("user", user);
        model.addAttribute("authorities", userService.findAllAuthority());
        model.addAttribute("title", "Edit User");
        return "User/userUpdate";
    }

    @PostMapping("/update/")
    public String userUpdate(@ModelAttribute("user") User user, Model model) {

        boolean Error = false;
        if (!user.getUsername().equals(userService.findById(user.getId()).getUsername())) {
            if (userService.findByUsername(user.getUsername()) != null) {
                Error = true;
                model.addAttribute("DuplicateUsername", "Username already exist");
            }
        }

        if (!user.getEmail().equals(userService.findById(user.getId()).getEmail())) {
            if (userService.findByEmail(user.getEmail()) != null) {
                Error = true;
                model.addAttribute("DuplicateEmail", "Email already exist");
            }
        }

        if (Error) {
            model.addAttribute("authorities", userService.findAllAuthority());
            model.addAttribute("title", "Edit User");
            return "User/userUpdate";
        }

        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/")
    public String userDelete(@RequestParam(value = "id") UUID id) {
        userService.delete(userService.findById(id));
        return "redirect:/user/list";
    }

    @GetMapping("/")
    public String userView(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("user", userService.findById(id));
        System.out.println(userService.findById(id));
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
