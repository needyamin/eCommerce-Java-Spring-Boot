package com.ecommerce.eCommerce.service;

import com.ecommerce.eCommerce.model.CartItem;
import com.ecommerce.eCommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    
    @Autowired
    private ProductService productService;
    
    // In-memory cart storage (in a real app, this would be stored in session or database)
    private List<CartItem> cartItems = new ArrayList<>();
    
    public void addToCart(Long productId, Integer quantity) {
        Optional<Product> productOpt = productService.getProductById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            
            // Check stock availability
            if (product.getStock() < quantity) {
                return; // Not enough stock
            }
            
            // Check if product already in cart
            Optional<CartItem> existingItem = cartItems.stream()
                    .filter(item -> item.getProduct().getId().equals(productId))
                    .findFirst();
            
            if (existingItem.isPresent()) {
                CartItem item = existingItem.get();
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity <= product.getStock()) {
                    item.setQuantity(newQuantity);
                }
            } else {
                cartItems.add(new CartItem(product, quantity));
            }
        }
    }
    
    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }
    
    public void updateCartItem(Long productId, Integer quantity) {
        cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> {
                    if (quantity > 0 && quantity <= item.getProduct().getStock()) {
                        item.setQuantity(quantity);
                    }
                });
    }
    
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    
    public BigDecimal getCartTotal() {
        return cartItems.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public void clearCart() {
        cartItems.clear();
    }
    
    public int getCartItemCount() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }
}

