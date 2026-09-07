package com.zomato.controller;
import com.zomato.service.*;import jakarta.servlet.http.HttpSession;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;
@Controller public class OrderController {private final OrderService orders=new OrderService();private final CartService cart=new CartService();
@PostMapping("/order/place") public String place(HttpSession s,Model m){Integer u=(Integer)s.getAttribute("userId");if(u==null)return "redirect:/login";boolean ok=orders.placeOrder(u,cart.get(u));if(ok)cart.clear(u);m.addAttribute("message",ok?"Order placed successfully!":"Cart is empty.");m.addAttribute("orders",orders.getOrders(u));return "orders";}
@GetMapping("/orders") public String orders(HttpSession s,Model m){Integer u=(Integer)s.getAttribute("userId");if(u==null)return "redirect:/login";m.addAttribute("orders",orders.getOrders(u));return "orders";}
@PostMapping("/order/cancel") public String cancel(@RequestParam int orderId,HttpSession s){Integer u=(Integer)s.getAttribute("userId");if(u!=null)orders.cancel(u,orderId);return "redirect:/orders";}}
