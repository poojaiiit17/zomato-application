# Zomato Application

A beginner-friendly Java Spring MVC + MySQL food-ordering application built in the same layered style as the Amazon application.

## Features
- User registration and login
- User dashboard
- Browse food and restaurant information
- View food details
- Add food to cart
- Remove food from cart
- Place order
- View order history
- Cancel placed order (Zomato equivalent of return product)

## Project structure
```text
src/main/java/com/zomato/
  controller/   -> request handling and pages
  dao/          -> MySQL queries
  model/        -> Java objects
  service/      -> business logic
  util/         -> database connection
  main/         -> Spring Boot main class
src/main/resources/
  templates/    -> Thymeleaf UI
  static/css/   -> styling
database/zomato_db.sql -> database and sample data
```

## Run in IntelliJ
1. Create the MySQL database by running `database/zomato_db.sql`.
2. Open `src/main/java/com/zomato/util/DBConnection.java` and set `PASSWORD` to your MySQL password.
3. Reload Maven.
4. Run `ZomatoApplication.java`.
5. Open `http://localhost:8080`.

Demo login after SQL setup: `pooja@gmail.com` / `1234`.
