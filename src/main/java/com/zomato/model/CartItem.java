package com.zomato.model;

public class CartItem {
    private int foodId, quantity; private String foodName, restaurantName; private double price;
    public CartItem() {}
    public CartItem(int foodId,String foodName,String restaurantName,double price,int quantity){this.foodId=foodId;this.foodName=foodName;this.restaurantName=restaurantName;this.price=price;this.quantity=quantity;}
    public int getFoodId(){return foodId;} public void setFoodId(int v){foodId=v;}
    public String getFoodName(){return foodName;} public void setFoodName(String v){foodName=v;}
    public String getRestaurantName(){return restaurantName;} public void setRestaurantName(String v){restaurantName=v;}
    public double getPrice(){return price;} public void setPrice(double v){price=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
    public double getTotal(){return price*quantity;}
}