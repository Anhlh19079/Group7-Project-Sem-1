package dev.group7.app.persistance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {

    private int order_id;
    private int user_id;
    public Calendar c;
    private Users user;
    private String order_date;
    private double total_price;
    private String status;
    private int pro_id;
    private double unit_price;
    private int quantity;

    private static List<Product> products;
    private static List<Order> orderdetails;

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
        // System.out.println(user_id);
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

    public Users getUsers() {
        return user;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public static List<Order> getOrderdetail() {
        return orderdetails;
    }
    public void addOrderdetail(Order orderdetail) {
        if (orderdetails == null) {
            orderdetails = new ArrayList<>();
        }
        orderdetails.add(orderdetail);
    }
    // --//

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
}