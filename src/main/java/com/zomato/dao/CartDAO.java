package com.zomato.dao;

import com.zomato.model.CartItem;import com.zomato.util.DBConnection;import java.sql.*;import java.util.*;

public class CartDAO {
    public void add(int userId,int foodId){String sql="INSERT INTO cart_items(user_id,food_id,quantity) VALUES(?,?,1) ON DUPLICATE KEY UPDATE quantity=quantity+1";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,userId);p.setInt(2,foodId);p.executeUpdate();}catch(SQLException e){e.printStackTrace();}}
    public List<CartItem> get(int userId){List<CartItem> l=new ArrayList<>();String s="SELECT f.food_id,f.food_name,r.name restaurant_name,f.price,ci.quantity FROM cart_items ci JOIN foods f ON ci.food_id=f.food_id JOIN restaurants r ON f.restaurant_id=r.restaurant_id WHERE ci.user_id=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,userId);ResultSet r=p.executeQuery();while(r.next())l.add(new CartItem(r.getInt(1),r.getString(2),r.getString(3),r.getDouble(4),r.getInt(5)));}catch(SQLException e){e.printStackTrace();}return l;}
    public void remove(int userId,int foodId){String s="DELETE FROM cart_items WHERE user_id=? AND food_id=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,userId);p.setInt(2,foodId);p.executeUpdate();}catch(SQLException e){e.printStackTrace();}}
    public void clear(int userId){String s="DELETE FROM cart_items WHERE user_id=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,userId);p.executeUpdate();}catch(SQLException e){e.printStackTrace();}}
}