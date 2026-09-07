package com.zomato.service;
import com.zomato.dao.CartDAO;import com.zomato.model.CartItem;import java.util.*;
public class CartService {private final CartDAO dao=new CartDAO();public void add(int u,int f){dao.add(u,f);}public List<CartItem> get(int u){return dao.get(u);}public void remove(int u,int f){dao.remove(u,f);}public void clear(int u){dao.clear(u);}}