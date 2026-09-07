CREATE DATABASE IF NOT EXISTS zomato_db;
USE zomato_db;

CREATE TABLE IF NOT EXISTS users (
 user_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL UNIQUE,
 password VARCHAR(100) NOT NULL,
 phone VARCHAR(15),
 address VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS restaurants (
 restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(120) NOT NULL,
 address VARCHAR(255),
 rating DECIMAL(2,1) DEFAULT 4.0
);

CREATE TABLE IF NOT EXISTS foods (
 food_id INT PRIMARY KEY AUTO_INCREMENT,
 restaurant_id INT NOT NULL,
 food_name VARCHAR(120) NOT NULL,
 description VARCHAR(500),
 price DECIMAL(10,2) NOT NULL,
 category VARCHAR(50),
 FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
);

CREATE TABLE IF NOT EXISTS cart_items (
 cart_item_id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT NOT NULL,
 food_id INT NOT NULL,
 quantity INT NOT NULL DEFAULT 1,
 UNIQUE KEY user_food (user_id,food_id),
 FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
 FOREIGN KEY (food_id) REFERENCES foods(food_id)
);

CREATE TABLE IF NOT EXISTS orders (
 order_id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT NOT NULL,
 total_amount DECIMAL(10,2) NOT NULL,
 status VARCHAR(20) NOT NULL DEFAULT 'PLACED',
 order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS order_items (
 order_item_id INT PRIMARY KEY AUTO_INCREMENT,
 order_id INT NOT NULL,
 food_id INT NOT NULL,
 quantity INT NOT NULL,
 price DECIMAL(10,2) NOT NULL,
 FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
 FOREIGN KEY (food_id) REFERENCES foods(food_id)
);

INSERT IGNORE INTO users(name,email,password,phone,address) VALUES
('Pooja','pooja@gmail.com','1234','9876543210','Bengaluru');

INSERT IGNORE INTO restaurants(restaurant_id,name,address,rating) VALUES
(1,'Spice Garden','MG Road, Bengaluru',4.5),
(2,'Food Corner','Indiranagar, Bengaluru',4.2),
(3,'Pizza Hub','Koramangala, Bengaluru',4.4);

INSERT IGNORE INTO foods(food_id,restaurant_id,food_name,description,price,category) VALUES
(1,1,'Paneer Chilli','Spicy paneer with capsicum and onion',180,'North Indian'),
(2,1,'Veg Fried Rice','Fried rice with fresh vegetables',150,'Chinese'),
(3,2,'Masala Dosa','Crispy dosa with potato masala',120,'South Indian'),
(4,2,'Veg Biryani','Aromatic rice with vegetables',200,'Biryani'),
(5,3,'Margherita Pizza','Classic cheese and tomato pizza',250,'Pizza'),
(6,3,'Farmhouse Pizza','Pizza loaded with fresh vegetables',320,'Pizza');
