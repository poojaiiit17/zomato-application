package com.zomato.controller;

import com.zomato.service.FoodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodController {

    private final FoodService service = new FoodService();

    @GetMapping("/dashboard")
    public String dashboard(HttpSession s, Model m) {
        if (s.getAttribute("userId") == null)
            return "redirect:/login";

        m.addAttribute("foods", service.getAllFoods());
        m.addAttribute("userName", s.getAttribute("userName"));
        return "dashboard";
    }

    @GetMapping("/food/{id}")
    public String food(@PathVariable("id") int id, HttpSession s, Model m) {
        if (s.getAttribute("userId") == null)
            return "redirect:/login";

        m.addAttribute("food", service.getFood(id));
        return "food";
    }
}
