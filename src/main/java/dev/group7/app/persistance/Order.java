package dev.group7.app.persistance;

import java.util.Calendar;

public class Order {

    private int order_id;
    private int user_id;
    public Calendar c;
    private Users user;
    private Product product;
    private String order_date;
    private double total_price;
    private String status;
    private int pro_id;
    private double unit_price;
    private int quantity;

    public Order() {
    }

    public Order(int order_id, int user_id, String order_date, double total_price, String status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.status = status;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setLocal_DT(String order_date) {
        this.order_date = order_date;
    }

    public String getLocal_DT() {

        return order_date;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUsers(Users user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product=product;
    }

    public Users getUsers() {
        return user;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public String toString(){
        return "|Order id:"+order_id +"-"+ user_id +"-Pro id"+ pro_id+"-Quantity:"+quantity+"|";
    }
}