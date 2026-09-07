package com.zomato.service;
import com.zomato.dao.OrderDAO;import com.zomato.model.*;import java.util.*;
public class OrderService {private final OrderDAO dao=new OrderDAO();public boolean placeOrder(int u,List<CartItem> i){return dao.placeOrder(u,i);}public List<Order> getOrders(int u){return dao.getOrders(u);}public void cancel(int u,int id){dao.cancel(u,id);}}