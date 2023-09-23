package pl.umcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.umcs.entity.Authority;
import pl.umcs.entity.User;
import pl.umcs.services.AuthorityService;
import pl.umcs.services.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private  UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @GetMapping({"/register","/adminregister"})
    public String registerForm(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model){

        String info = info(user);

        if (!info.isEmpty()) {

            model.addAttribute("info", info);

            return "register";

        }
        else{ user.getAuthorities().add(new Authority(user, "ROLE_USER"));

            userService.saveUser(user);

            Authority authority=user.getAuthorities().get((user.getAuthorities().size()-1));

            authorityService.saveAuthority(authority);

        return "redirect:login";
        }
    }
    @PostMapping("/adminregister")
    public String saveAdmin(@ModelAttribute("user") User user, Model model) {

        String info = info(user);

        if (!info.isEmpty()) {

            model.addAttribute("info", info);

            return "register";
        }
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));

        user.getAuthorities().add(new Authority(user, "ROLE_ADMIN"));

        userService.saveUser(user);

        return "redirect:/login";
    }
    private String info(User user) {

        if (userService.getUser(user.getUsername()) != null) {

            return "użytkownik o takiej nazwie istnieje";
        }
        else if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {

            return "wypełnij wszystkie pola";
        }
        return "";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
