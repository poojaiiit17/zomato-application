package com.zomato.model;

public class User {
    private int userId;
    private String name, email, password, phone, address;
    public User() {}
    public User(int userId, String name, String email, String password, String phone, String address) { this.userId=userId; this.name=name; this.email=email; this.password=password; this.phone=phone; this.address=address; }
    public int getUserId(){return userId;} public void setUserId(int v){userId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPassword(){return password;} public void setPassword(String v){password=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getAddress(){return address;} public void setAddress(String v){address=v;}
}