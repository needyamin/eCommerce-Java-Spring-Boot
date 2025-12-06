package com.ecommerce.eCommerce.config;

import com.ecommerce.eCommerce.model.Product;
import com.ecommerce.eCommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Sample products are now inserted via Flyway migration V5__Insert_sample_products.sql
        // This ensures data consistency and version control
        // Only insert if migration didn't run (fallback)
        if (productRepository.count() == 0) {
            productRepository.save(new Product(
                "Laptop",
                "High-performance laptop with 16GB RAM and 512GB SSD",
                new BigDecimal("999.99"),
                10
            ));
            
            productRepository.save(new Product(
                "Smartphone",
                "Latest smartphone with 128GB storage and 48MP camera",
                new BigDecimal("699.99"),
                15
            ));
            
            productRepository.save(new Product(
                "Wireless Headphones",
                "Premium noise-cancelling wireless headphones",
                new BigDecimal("199.99"),
                20
            ));
            
            productRepository.save(new Product(
                "Smart Watch",
                "Fitness tracker with heart rate monitor and GPS",
                new BigDecimal("249.99"),
                12
            ));
            
            productRepository.save(new Product(
                "Tablet",
                "10-inch tablet with 64GB storage and stylus support",
                new BigDecimal("399.99"),
                8
            ));
        }
    }
}

