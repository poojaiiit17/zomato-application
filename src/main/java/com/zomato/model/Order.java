package com.zomato.model;

public class Order {
    private int orderId; private double totalAmount; private String status, orderDate;
    public Order() {}
    public Order(int orderId,double totalAmount,String status,String orderDate){this.orderId=orderId;this.totalAmount=totalAmount;this.status=status;this.orderDate=orderDate;}
    public int getOrderId(){return orderId;} public void setOrderId(int v){orderId=v;}
    public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double v){totalAmount=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public String getOrderDate(){return orderDate;} public void setOrderDate(String v){orderDate=v;}
}