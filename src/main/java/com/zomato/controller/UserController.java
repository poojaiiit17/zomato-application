package com.zomato.controller;

import com.zomato.model.User;
import com.zomato.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService service = new UserService();

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession s, Model m) {
        User u = service.login(email, password);
        if (u == null) {
            m.addAttribute("error", "Invalid email or password");
            return "login";
        }
        s.setAttribute("userId", u.getUserId());
        s.setAttribute("userName", u.getName());
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User u, Model m) {
        if (service.register(u)) {
            m.addAttribute("message", "Registration successful. Please login.");
            return "login";
        }
        m.addAttribute("error", "Registration failed. Email may already exist.");
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession s) {
        s.invalidate();
        return "redirect:/login";
    }
}