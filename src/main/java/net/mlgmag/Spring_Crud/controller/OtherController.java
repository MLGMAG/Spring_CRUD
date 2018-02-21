package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.service.SecurityService;
import net.mlgmag.Spring_Crud.service.UserService;
import net.mlgmag.Spring_Crud.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OtherController {

    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @Autowired
    public OtherController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/singUp")
    public String singUpPage() {
        return "singUp";
    }

    @PostMapping("/singUp")
    public String singUp(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "SingUp";
        }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return "redirect:/";
    }

    @GetMapping("/singIn")
    public String singIn(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("massage", "Logged out successfully.");
        }

        return "singIn";
    }

}
