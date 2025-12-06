package com.ecommerce.eCommerce.controller;

import com.ecommerce.eCommerce.model.Order;
import com.ecommerce.eCommerce.service.CartService;
import com.ecommerce.eCommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private CartService cartService;
    
    @GetMapping("/checkout")
    public String checkoutForm(Model model) {
        if (cartService.getCartItems().isEmpty()) {
            return "redirect:/cart";
        }
        model.addAttribute("order", new Order());
        model.addAttribute("cartTotal", cartService.getCartTotal());
        return "checkout";
    }
    
    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order) {
        orderService.createOrder(order);
        return "redirect:/orders/success";
    }
    
    @GetMapping("/success")
    public String orderSuccess() {
        return "order-success";
    }
    
    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }
}

