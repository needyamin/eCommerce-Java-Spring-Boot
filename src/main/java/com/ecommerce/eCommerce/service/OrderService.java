package com.ecommerce.eCommerce.service;

import com.ecommerce.eCommerce.model.CartItem;
import com.ecommerce.eCommerce.model.Order;
import com.ecommerce.eCommerce.model.OrderItem;
import com.ecommerce.eCommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private ProductService productService;
    
    public Order createOrder(Order order) {
        // Convert cart items to order items
        List<CartItem> cartItems = cartService.getCartItems();
        
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(cartItem.getProduct(), cartItem.getQuantity());
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
            
            // Update product stock
            cartItem.getProduct().setStock(
                    cartItem.getProduct().getStock() - cartItem.getQuantity()
            );
            productService.saveProduct(cartItem.getProduct());
        }
        
        Order savedOrder = orderRepository.save(order);
        cartService.clearCart();
        
        return savedOrder;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}

