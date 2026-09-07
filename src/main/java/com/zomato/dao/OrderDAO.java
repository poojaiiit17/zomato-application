package com.zomato.dao;

import com.zomato.model.*;import com.zomato.util.DBConnection;import java.sql.*;import java.util.*;

public class OrderDAO {
    public boolean placeOrder(int userId,List<CartItem> items){
        if(items.isEmpty())return false; double total=0;for(CartItem i:items)total+=i.getTotal();
        String os="INSERT INTO orders(user_id,total_amount,status) VALUES(?,?,?)", is="INSERT INTO order_items(order_id,food_id,quantity,price) VALUES(?,?,?,?)";
        try(Connection c=DBConnection.getConnection()){c.setAutoCommit(false);try(PreparedStatement p=c.prepareStatement(os,Statement.RETURN_GENERATED_KEYS)){p.setInt(1,userId);p.setDouble(2,total);p.setString(3,"PLACED");p.executeUpdate();ResultSet k=p.getGeneratedKeys();k.next();int id=k.getInt(1);try(PreparedStatement q=c.prepareStatement(is)){for(CartItem i:items){q.setInt(1,id);q.setInt(2,i.getFoodId());q.setInt(3,i.getQuantity());q.setDouble(4,i.getPrice());q.addBatch();}q.executeBatch();}c.commit();return true;}}catch(SQLException e){e.printStackTrace();return false;}
    }
    public List<Order> getOrders(int userId){List<Order> l=new ArrayList<>();String s="SELECT order_id,total_amount,status,DATE_FORMAT(order_date,'%Y-%m-%d %H:%i') order_date FROM orders WHERE user_id=? ORDER BY order_id DESC";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,userId);ResultSet r=p.executeQuery();while(r.next())l.add(new Order(r.getInt(1),r.getDouble(2),r.getString(3),r.getString(4)));}catch(SQLException e){e.printStackTrace();}return l;}
    public void cancel(int userId,int orderId){String s="UPDATE orders SET status='CANCELLED' WHERE order_id=? AND user_id=? AND status='PLACED'";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(s)){p.setInt(1,orderId);p.setInt(2,userId);p.executeUpdate();}catch(SQLException e){e.printStackTrace();}}
}