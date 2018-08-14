package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.definition.UserService;
import net.mlgmag.Spring_Crud.enums.Authority;
import net.mlgmag.Spring_Crud.model.User;
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
        model.addAttribute("authorities", Authority.values());
        model.addAttribute(new User());
        model.addAttribute("title", "Add User");
        return "User/userAdd";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute("user") User user, Model model) {

        if (userService.saveValidation(user, model)) {
            model.addAttribute("authorities", Authority.values());
            model.addAttribute("title", "Add User");
            return "User/userAdd";
        }

        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update")
    public String userUpdatePage(@RequestParam(value = "id") UUID id, Model model) {
        User user = userService.findById(id);
        user.setPassword(null);
        model.addAttribute("user", user);
        model.addAttribute("authorities", Authority.values());
        model.addAttribute("title", "Edit User");
        return "User/userUpdate";
    }

    @PostMapping("/update")
    public String userUpdate(@ModelAttribute("user") User user, Model model) {

        if (userService.updateValidation(user, model)) {
            model.addAttribute("authorities", Authority.values());
            model.addAttribute("title", "Edit User");
            return "User/userAdd";
        }

        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String userDelete(@RequestParam(value = "id") UUID id) {
        userService.delete(userService.findById(id));
        return "redirect:/user/list";
    }

    @GetMapping("/")
    public String userView(@RequestParam(value = "id") UUID id, Model model) {
        model.addAttribute("user", userService.findById(id));
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
