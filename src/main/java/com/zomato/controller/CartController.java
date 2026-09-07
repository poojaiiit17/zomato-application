package com.zomato.controller;
import com.zomato.service.CartService;import jakarta.servlet.http.HttpSession;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;
@Controller public class CartController {private final CartService service=new CartService();
@GetMapping("/cart") public String cart(HttpSession s,Model m){Integer u=(Integer)s.getAttribute("userId");if(u==null)return "redirect:/login";m.addAttribute("items",service.get(u));return "cart";}
@PostMapping("/cart/add") public String add(@RequestParam int foodId,HttpSession s){Integer u=(Integer)s.getAttribute("userId");if(u==null)return "redirect:/login";service.add(u,foodId);return "redirect:/cart";}
@GetMapping("/cart/remove") public String remove(@RequestParam int foodId,HttpSession s){Integer u=(Integer)s.getAttribute("userId");if(u!=null)service.remove(u,foodId);return "redirect:/cart";}}
