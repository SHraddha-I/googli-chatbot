package com.shraddha.chatbot.controller;

import com.shraddha.chatbot.model.User;
import com.shraddha.chatbot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/chat";
        }
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
