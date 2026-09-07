package com.zomato.dao;

import com.zomato.model.User;
import com.zomato.util.DBConnection;
import java.sql.*;

public class UserDAO {
    public User login(String email,String password){
        String sql="SELECT * FROM users WHERE email=? AND password=?";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,email);ps.setString(2,password);ResultSet rs=ps.executeQuery();
            if(rs.next()) return new User(rs.getInt("user_id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getString("phone"),rs.getString("address"));
        }catch(SQLException e){e.printStackTrace();} return null;
    }
    public boolean register(User u){
        String sql="INSERT INTO users(name,email,password,phone,address) VALUES(?,?,?,?,?)";
        try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){ps.setString(1,u.getName());ps.setString(2,u.getEmail());ps.setString(3,u.getPassword());ps.setString(4,u.getPhone());ps.setString(5,u.getAddress());return ps.executeUpdate()>0;}catch(SQLException e){e.printStackTrace();return false;}
    }
}