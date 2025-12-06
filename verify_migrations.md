# Migration Verification Guide

## How to Verify Migrations Ran Successfully

### Method 1: Check Application Logs
When the application starts, you should see Flyway migration logs like:
```
Flyway migration successful
Migrating schema to version 1 - Create products table
Migrating schema to version 2 - Create orders table
...
```

### Method 2: Check Database Tables
Connect to MySQL and check if tables exist:
```sql
USE ecommerce;
SHOW TABLES;
```

You should see:
- products
- orders
- order_items
- cart_items
- flyway_schema_history

### Method 3: Check Flyway Schema History
```sql
SELECT * FROM flyway_schema_history;
```

This shows all executed migrations with their version numbers and execution times.

### Method 4: Verify Sample Data
```sql
SELECT * FROM products;
```

Should show 5 sample products inserted by migration V5.

## Migration Files Location
All migration files are in: `src/main/resources/db/migration/`

- V1__Create_products_table.sql
- V2__Create_orders_table.sql
- V3__Create_order_items_table.sql
- V4__Create_cart_items_table.sql
- V5__Insert_sample_products.sql

## Troubleshooting

If migrations fail:
1. Check MySQL is running: `Test-NetConnection localhost -Port 3306`
2. Verify credentials in `application.properties`
3. Check database exists or can be created
4. Review application logs for error messages

