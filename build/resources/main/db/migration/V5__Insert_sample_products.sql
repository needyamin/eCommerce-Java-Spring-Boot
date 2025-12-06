-- Insert sample products (only if table is empty)
INSERT INTO products (name, description, price, stock)
SELECT * FROM (SELECT 'Laptop' as name, 'High-performance laptop with 16GB RAM and 512GB SSD' as description, 999.99 as price, 10 as stock) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Laptop')
LIMIT 1;

INSERT INTO products (name, description, price, stock)
SELECT * FROM (SELECT 'Smartphone' as name, 'Latest smartphone with 128GB storage and 48MP camera' as description, 699.99 as price, 15 as stock) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartphone')
LIMIT 1;

INSERT INTO products (name, description, price, stock)
SELECT * FROM (SELECT 'Wireless Headphones' as name, 'Premium noise-cancelling wireless headphones' as description, 199.99 as price, 20 as stock) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Wireless Headphones')
LIMIT 1;

INSERT INTO products (name, description, price, stock)
SELECT * FROM (SELECT 'Smart Watch' as name, 'Fitness tracker with heart rate monitor and GPS' as description, 249.99 as price, 12 as stock) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smart Watch')
LIMIT 1;

INSERT INTO products (name, description, price, stock)
SELECT * FROM (SELECT 'Tablet' as name, '10-inch tablet with 64GB storage and stylus support' as description, 399.99 as price, 8 as stock) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Tablet')
LIMIT 1;

