package net.mlgmag.Spring_Crud.controller;

import net.mlgmag.Spring_Crud.model.User;
import net.mlgmag.Spring_Crud.service.genericService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class OtherController {

    private final UserService userService;

    @Autowired
    public OtherController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "Other/home";
    }

    @GetMapping("/signUp")
    public String signUpPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Sign Up");
        return "Other/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user") User user, Model model) {

        if (userService.validate(user, model)) {
            model.addAttribute("title", "Sign Up");
            return "Other/signUp";
        }

        user.setAuthorityId(userService.findAuthorityByName("USER").getId());

        userService.save(user);
        return "redirect:/signIn?regSuccess";
    }

    @GetMapping("/signIn")
    public String signInPage(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "logout", required = false) String logout,
                             @RequestParam(value = "regSuccess", required = false) String regSuccess,
                             Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("regSuccess", regSuccess != null);
        model.addAttribute("title", "Sign In");
        return "Other/signIn";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/signIn?logout";
    }
}
