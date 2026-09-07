package com.zomato.dao;

import com.zomato.model.Food;
import com.zomato.util.DBConnection;
import java.sql.*;import java.util.*;

public class FoodDAO {
    public List<Food> getAllFoods(){
        List<Food> list=new ArrayList<>(); String sql="SELECT f.*,r.name restaurant_name FROM foods f JOIN restaurants r ON f.restaurant_id=r.restaurant_id ORDER BY f.food_id";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
            while(rs.next()) list.add(new Food(rs.getInt("food_id"),rs.getInt("restaurant_id"),rs.getString("restaurant_name"),rs.getString("food_name"),rs.getString("description"),rs.getDouble("price"),rs.getString("category")));
        }catch(SQLException e){e.printStackTrace();} return list;
    }
    public Food getFood(int id){for(Food f:getAllFoods())if(f.getFoodId()==id)return f;return null;}
}