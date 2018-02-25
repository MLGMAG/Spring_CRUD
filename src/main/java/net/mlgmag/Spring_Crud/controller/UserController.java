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

import javax.validation.Valid;
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
        model.addAttribute("user", new User());
        return "User/userAdd";
    }

    @PostMapping("/add")
    public String userAdd(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            userService.validate(user, model);
            List<Role> roles = Arrays.asList(Role.values());
            model.addAttribute("roles", roles);
            return "User/userAdd";
        }

        if (!bindingResult.hasErrors()) {
            if (userService.validate(user, model)) {
                List<Role> roles = Arrays.asList(Role.values());
                model.addAttribute("roles", roles);
                return "User/userAdd";
            }
        }

        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/")
    public String userUpdatePage(@RequestParam(value = "id") UUID uuid, Model model) {
        List<Role> roles = Arrays.asList(Role.values());
        User user = userService.getById(uuid);
        user.setPassword(null);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "User/userUpdate";
    }

    @PostMapping("/update/")
    public String userUpdate(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        List<Role> roles = Arrays.asList(Role.values());

        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roles);
            return "User/userUpdate";
        }

        if (!bindingResult.hasErrors()) {
            boolean Error = false;
            if (!user.getUsername().equals(userService.getById(user.getId()).getUsername())) {
                if (userService.findByUsername(user.getUsername()) != null){
                    Error = true;
                    model.addAttribute("DuplicateUsername", "Username already exist");
                }
            }
            if (!user.getEmail().equals(userService.getById(user.getId()).getEmail())) {
                if (userService.findByEmail(user.getEmail()) != null){
                    Error = true;
                    model.addAttribute("DuplicateEmail", "Email already exist");
                }
            }
            if (!user.getPassword().equals(user.getConfirmPassword())) {
                Error = true;
                model.addAttribute("PasswordMatch", "Passwords don't match");
            }
            if (Error){
                model.addAttribute("roles", roles);
                return "User/userUpdate";
            }
        }

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
