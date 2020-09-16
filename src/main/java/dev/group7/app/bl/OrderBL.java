package dev.group7.app.bl;

import java.sql.SQLException;
import java.util.List;
import dev.group7.app.dal.OrderDAL;
import dev.group7.app.persistance.Order;

public class OrderBL {
    static OrderDAL ORD = new OrderDAL();

    public boolean insert(Order order, List<Order> listodt) {

        return ORD.insertOrder(order, listodt);
    }

    public List<Order> OrderAll() {
        return ORD.getAllOrders();
    }

    public int UpdateOrder(Order order) throws SQLException {
        return ORD.updateOrder(order);
    }

    public List<Order> OrderById() {
        return ORD.getAllOrdersById();
    }
    public List<Order> orderbid(int id) {
        return ORD.getOrderCustomerById(id);
    }
    public List<Order> ordertotal(int id){
        return ORD.getTotalPriceOfOrder(id);
    }

    public List<Order> getbyiduser(){
        return ORD.getidbyusers();
    }
}
