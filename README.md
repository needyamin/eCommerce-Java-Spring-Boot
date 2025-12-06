# E-Commerce Application

A full-featured e-commerce web application built with Spring Boot, following MVC (Model-View-Controller) architecture pattern.

## 🚀 Features

- **Product Management**: Browse products, view details, and manage inventory
- **Shopping Cart**: Add products to cart, update quantities, and remove items
- **Order Processing**: Complete checkout flow with customer information
- **Order Management**: View and track orders
- **Database Migrations**: Automated database schema management with Flyway
- **MySQL Integration**: Persistent data storage with MySQL database

## 🛠️ Tech Stack

- **Framework**: Spring Boot 4.0.0
- **Language**: Java 17
- **Build Tool**: Gradle
- **Database**: MySQL 8.0+
- **Migration Tool**: Flyway
- **Template Engine**: Thymeleaf
- **ORM**: Spring Data JPA / Hibernate

## 📋 Prerequisites

Before running this application, ensure you have:

- **Java 17** or higher installed
- **MySQL 8.0+** installed and running
- **Gradle** (or use the included Gradle Wrapper)
- **phpMyAdmin** (optional, for database management)

## 🔧 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd eCommerce
```

### 2. Database Setup

1. **Start MySQL Server**
   - Ensure MySQL is running on `localhost:3306`
   - Or use Docker:
     ```bash
     docker run --name mysql-ecommerce -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eCommerceJava -p 3306:3306 -d mysql:8.0
     ```

2. **Configure Database Connection**
   - Open `src/main/resources/application.properties`
   - Update MySQL credentials:
     ```properties
     spring.datasource.username=root
     spring.datasource.password=your_password
     ```
   - Database name: `eCommerceJava` (will be created automatically)

### 3. Build the Project

```bash
# Windows
.\gradlew.bat clean build

# Linux/Mac
./gradlew clean build
```

### 4. Run the Application

```bash
# Windows
.\gradlew.bat bootRun

# Linux/Mac
./gradlew bootRun
```

The application will:
- Automatically create the `eCommerceJava` database if it doesn't exist
- Run Flyway migrations to create all tables
- Insert sample products
- Start on `http://localhost:8080`

## 📁 Project Structure

```
eCommerce/
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/eCommerce/
│   │   │   ├── config/          # Configuration classes
│   │   │   │   ├── DataInitializer.java
│   │   │   │   ├── FlywayConfig.java
│   │   │   │   └── WebMvcConfig.java
│   │   │   ├── controller/      # MVC Controllers
│   │   │   │   ├── CartController.java
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   └── ProductController.java
│   │   │   ├── model/           # Entity Models
│   │   │   │   ├── CartItem.java
│   │   │   │   ├── Order.java
│   │   │   │   ├── OrderItem.java
│   │   │   │   └── Product.java
│   │   │   ├── repository/      # Data Access Layer
│   │   │   │   ├── OrderRepository.java
│   │   │   │   └── ProductRepository.java
│   │   │   └── service/         # Business Logic Layer
│   │   │       ├── CartService.java
│   │   │       ├── OrderService.java
│   │   │       └── ProductService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── db/migration/    # Flyway migration files
│   │       │   ├── V1__Create_products_table.sql
│   │       │   ├── V2__Create_orders_table.sql
│   │       │   ├── V3__Create_order_items_table.sql
│   │       │   ├── V4__Create_cart_items_table.sql
│   │       │   └── V5__Insert_sample_products.sql
│   │       └── templates/       # Thymeleaf templates
│   │           ├── index.html
│   │           ├── products.html
│   │           ├── product-detail.html
│   │           ├── cart.html
│   │           ├── checkout.html
│   │           ├── order-success.html
│   │           └── orders.html
│   └── test/                    # Test files
└── build.gradle                 # Gradle build configuration
```

## 🗄️ Database Schema

### Tables

- **products**: Product catalog with name, description, price, and stock
- **orders**: Customer orders with shipping information
- **order_items**: Items within each order
- **cart_items**: Shopping cart items (for future session-based carts)
- **flyway_schema_history**: Migration tracking table

### Migrations

Database migrations are managed by Flyway and located in `src/main/resources/db/migration/`:

- `V1__Create_products_table.sql` - Creates products table
- `V2__Create_orders_table.sql` - Creates orders table
- `V3__Create_order_items_table.sql` - Creates order_items table
- `V4__Create_cart_items_table.sql` - Creates cart_items table
- `V5__Insert_sample_products.sql` - Inserts 5 sample products

## 🌐 Application URLs

Once running, access the application at:

- **Homepage**: http://localhost:8080/
- **Products**: http://localhost:8080/products
- **Cart**: http://localhost:8080/cart
- **Checkout**: http://localhost:8080/orders/checkout
- **Orders**: http://localhost:8080/orders

## 🔄 Development

### Hot Reload

Spring DevTools is configured for automatic application restart on code changes:
- Java class changes trigger a restart
- Template changes are reflected immediately
- Property file changes trigger a restart

### Adding New Migrations

1. Create a new SQL file in `src/main/resources/db/migration/`
2. Follow naming convention: `V{version}__{description}.sql`
   - Example: `V6__Add_user_table.sql`
3. Flyway will automatically run the migration on next startup

### Sample Products

The application comes with 5 sample products:
- Laptop ($999.99)
- Smartphone ($699.99)
- Wireless Headphones ($199.99)
- Smart Watch ($249.99)
- Tablet ($399.99)

## 🧪 Testing

Run tests with:

```bash
.\gradlew.bat test
```

## 📝 Configuration

### Application Properties

Key configuration in `src/main/resources/application.properties`:

- **Database**: MySQL connection settings
- **Flyway**: Migration configuration
- **JPA**: Hibernate settings
- **DevTools**: Hot reload settings

### Environment Variables

You can override database settings using environment variables or external configuration files.

## 🐛 Troubleshooting

### Database Connection Issues

- Verify MySQL is running: `Test-NetConnection localhost -Port 3306`
- Check credentials in `application.properties`
- Ensure database user has CREATE DATABASE privileges

### Migration Issues

- Check `flyway_schema_history` table for migration status
- Verify migration files are in `src/main/resources/db/migration/`
- Check application logs for Flyway errors

### Port Already in Use

If port 8080 is in use, change it in `application.properties`:
```properties
server.port=8081
```

## 📄 License

This project is open source and available under the MIT License.

## 👥 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📧 Contact

For questions or support, please open an issue in the repository.

---

**Built with ❤️ using Spring Boot**
