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

    public List<Order> OrderDetailsById() {
        return ORD.getAllOrderDetalsById();
    }

    public List<Order> ALLOrderDetails() {
        return ORD.getAllOrderDetals();
    }

    public static List<Order> OrderById() {
        return ORD.getAllOrdersById();
    }

}
