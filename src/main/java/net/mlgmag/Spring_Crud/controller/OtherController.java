package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.Role;
import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.service.service.SecurityService;
import net.mlgmag.Spring_Crud.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class OtherController {

    private final UserService userService;

    private final SecurityService securityService;

    @Autowired
    public OtherController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/")
    public String home() {
        return "Other/home";
    }

    @GetMapping("/singUp")
    public String singUpPage(Model model) {
        model.addAttribute("user", new User());
        return "Other/singUp";
    }

    @PostMapping("/singUp")
    public String singUp(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            userService.validate(user, model);
            return "Other/singUp";
        }

        if (!bindingResult.hasErrors()) {
            if (userService.validate(user, model)) {
                return "Other/singUp";
            }
        }

        user.setRole(Role.User);
        userService.save(user);

//        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/user/list";
    }

    @GetMapping("/singIn")
    public String singIn(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("messages", "Logged out successfully.");
        }

        return "Other/singIn";
    }

}
