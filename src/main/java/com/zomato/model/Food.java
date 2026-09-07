package com.zomato.model;

public class Food {
    private int foodId, restaurantId; private String restaurantName, foodName, description, category; private double price;
    public Food() {}
    public Food(int foodId,int restaurantId,String restaurantName,String foodName,String description,double price,String category){this.foodId=foodId;this.restaurantId=restaurantId;this.restaurantName=restaurantName;this.foodName=foodName;this.description=description;this.price=price;this.category=category;}
    public int getFoodId(){return foodId;} public void setFoodId(int v){foodId=v;}
    public int getRestaurantId(){return restaurantId;} public void setRestaurantId(int v){restaurantId=v;}
    public String getRestaurantName(){return restaurantName;} public void setRestaurantName(String v){restaurantName=v;}
    public String getFoodName(){return foodName;} public void setFoodName(String v){foodName=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getCategory(){return category;} public void setCategory(String v){category=v;}
    public double getPrice(){return price;} public void setPrice(double v){price=v;}
}