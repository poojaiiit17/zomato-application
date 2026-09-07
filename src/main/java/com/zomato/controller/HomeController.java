package com.zomato.controller;
import jakarta.servlet.http.HttpSession;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeController {@GetMapping("/") public String home(HttpSession s){return s.getAttribute("userId")!=null?"redirect:/dashboard":"redirect:/login";}}
