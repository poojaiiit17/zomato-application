package com.zomato.service;
import com.zomato.dao.FoodDAO;import com.zomato.model.Food;import java.util.*;
public class FoodService {private final FoodDAO dao=new FoodDAO();public List<Food> getAllFoods(){return dao.getAllFoods();}public Food getFood(int id){return dao.getFood(id);}}