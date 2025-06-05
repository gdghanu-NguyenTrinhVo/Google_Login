package com.example.Google_Login.controller;

import com.example.Google_Login.entity.User;
import com.example.Google_Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.handleUserLogin(principal);
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));
        return "home";
    }

}
