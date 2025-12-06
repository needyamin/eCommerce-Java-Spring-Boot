package com.ecommerce.eCommerce.controller;

import com.ecommerce.eCommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("cartTotal", cartService.getCartTotal());
        return "cart";
    }
    
    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, 
                           @RequestParam(defaultValue = "1") Integer quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }
    
    @PostMapping("/update")
    public String updateCart(@RequestParam Long productId, 
                             @RequestParam Integer quantity) {
        cartService.updateCartItem(productId, quantity);
        return "redirect:/cart";
    }
    
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam Long productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }
}

