package com.zomato.service;
import com.zomato.dao.UserDAO;import com.zomato.model.User;
public class UserService {private final UserDAO dao=new UserDAO();public User login(String e,String p){return dao.login(e,p);}public boolean register(User u){return dao.register(u);}}