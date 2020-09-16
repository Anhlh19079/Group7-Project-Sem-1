package dev.group7.app.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.sql.CallableStatement;
import dev.group7.app.bl.ProductBL;
import dev.group7.app.persistance.Order;
import dev.group7.app.persistance.Product;
import dev.group7.app.persistance.Users;
import dev.group7.app.ui.orderui.OrderUI;

public class OrderDAL {
    

    static ProductBL pbl = new ProductBL();
    static UsersDAL udal = new UsersDAL();
    static OrderUI oui = new OrderUI();

    public List<Order> getOrderCustomerById(int id) {
        CallableStatement cstm = null;
        List<Order> litsorder = new ArrayList<>();
        try {
            String sql = "{call showorderbid (" + id + ")}";
            Connection con = DBUtil.getConnection();
            cstm = con.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {

                litsorder.add(getordrbid(rs));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return litsorder;
    }

    public static Order getordrbid(ResultSet rs) throws SQLException {
        Order odtid = new Order();
        Users user = new Users();
        Product product = new Product();
       
        user.setUserName(rs.getString("user_name"));
        user.setUserphone(rs.getString("user_phone"));
        user.setUseremail(rs.getString("user_email"));
        odtid.setUsers(user);
        product.setPro_name(rs.getString("pro_name"));
        product.setUnitPrice(rs.getDouble("unit_price"));
        odtid.setProduct(product);
        // odtid.setUnit_price(rs.getDouble("Unit_price"));
        odtid.setQuantity(rs.getInt("quantity"));
        odtid.setTotal_price(rs.getDouble("total"));
        odtid.setTotal_price(rs.getDouble("order_totalPrice"));

        return odtid;
    }

    public List<Order> getTotalPriceOfOrder(int id) {
        
        List<Order> listtotal = new ArrayList<>();
        try {
            String sql = "select * from orders where order_id="+id;
            Connection con = DBUtil.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                listtotal.add(gettotalprice(rs));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listtotal;
    }
    public static Order gettotalprice(ResultSet rs) throws SQLException {
        Order ordertotal = new Order();
       
        ordertotal.setTotal_price(rs.getDouble("order_totalPrice"));

        return ordertotal;
    }
    public List<Order> getAllOrders() {
        String sql = "select * from orders";
        List<Order> lod = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lod.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lod = null;
            System.out.println(ex.toString());
        }
        return lod;
    }

    public List<Order> getAllOrdersById() {
        int idus = 0;
        idus += udal.idus;
        List<Order> lbid = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from orders where orders.User_ID=" + idus)) {
            while (rs.next()) {
                lbid.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lbid = null;
            System.out.println(ex.toString());
        }
        return lbid;
    }
    public List<Order> getidbyusers() {
        int idus = 0;
        idus += udal.idus;
        List<Order> lbid = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select order_id from orders o inner join users u on o.user_id=u.user_id where u.user_id =" + idus)) {
            while (rs.next()) {
                lbid.add(getid(rs));
            }
        } catch (SQLException ex) {
            lbid = null;
            System.out.println(ex.toString());
        }
        return lbid;
    }
    public static Order getid(ResultSet rs) throws SQLException {
        Order odtid = new Order();
        odtid.setOrder_id(rs.getInt("Order_id"));
        

        return odtid;
    }
    

    public List<Order> getAllOrderDetalsById() {
        int idus = 0;
        idus += udal.idus;
        String sql = ("select od.Order_id,u.User_ID ,p.Pro_id, od.Unit_price , od.Quantity from users as u inner join orders as o on u.User_ID=o.User_ID inner join orderdetails as od on o.Order_id = od.Order_id inner join products as p on od.Pro_id = p.Pro_id where u.User_ID = "
                + idus);
        List<Order> ldt = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                ldt.add(getOrderdtByid(rs));
            }
        } catch (SQLException ex) {
            ldt = null;
            System.out.println(ex.toString());
        }
        return ldt;
    }

    public static Order getOrderdtByid(ResultSet rs) throws SQLException {
        Order odtid = new Order();
        odtid.setOrder_id(rs.getInt("Order_id"));
        odtid.setUser_id(rs.getInt("User_id"));
        odtid.setPro_id(rs.getInt("Pro_id"));
        odtid.setUnit_price(rs.getDouble("Unit_price"));
        odtid.setQuantity(rs.getInt("Quantity"));

        return odtid;
    }

    public static Order getOrderdt(ResultSet rs) throws SQLException {
        Order odt = new Order();
        odt.setOrder_id(rs.getInt("Order_id"));
        odt.setPro_id(rs.getInt("Pro_id"));
        odt.setUnit_price(rs.getDouble("Unit_price"));
        odt.setQuantity(rs.getInt("Quantity"));

        return odt;
    }

    public static Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrder_id(rs.getInt("Order_id"));
        order.setUser_id(rs.getInt("User_id"));
        order.setLocal_DT(rs.getString("Order_date"));
        order.setTotal_price(rs.getDouble("Order_totalPrice"));
        order.setStatus(rs.getString("Order_status"));

        return order;
    }

    // ---//
    public int reOrderID() {
        int orderid = 0;
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select Order_id from Orders order by Order_id desc limit 1;");) {
            if (rs.next()) {
                orderid = rs.getInt("Order_id");
            } else {
                System.out.println("not set id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderid;
    }

    public boolean insertOrder(Order order, List<Order> listdt) {
        try (Connection con = DBUtil.getConnection(); Statement stm = con.createStatement();) {
            // insert Order
            try (PreparedStatement pstm = con.prepareStatement(
                    "insert into Orders(Order_id,User_ID, Order_date,Order_totalPrice,Order_status) values (?,?,?,?,?);");) {
                pstm.setInt(1, reOrderID() + 1);
                pstm.setInt(2, order.getUsers().getUserId());
                pstm.setString(3, order.getLocal_DT());
                pstm.setDouble(4, order.getTotal_price());
                pstm.setString(5, order.getStatus());
                pstm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Insert order fail1");
                System.out.println(ex.toString());
                ex.printStackTrace();
            }
            // insert OrderDetails
            for (Order odt : listdt) {
                try (PreparedStatement pstm = con.prepareStatement(
                        "insert into OrderDetails(Order_id, Pro_id, Unit_price, Quantity) values(?,?,?,?)");) {
                    pstm.setInt(1, reOrderID());
                    pstm.setInt(2, odt.getPro_id());
                    pstm.setDouble(3, odt.getUnit_price());
                    pstm.setInt(4, odt.getQuantity());
                    pstm.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Insert oddetail fail1");
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public int updateOrder(Order order) throws SQLException {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con
                        .prepareStatement("update Orders SET Order_status = ? where Order_id = ?;");) {
            pstm.setString(1, order.getStatus());
            pstm.setInt(2, order.getOrder_id());

            int rs = pstm.executeUpdate();
            if (rs == 1) {
                System.out.println("Update order Successful!");
            } else {
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;
        }
    }
}