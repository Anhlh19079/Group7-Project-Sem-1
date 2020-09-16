package dev.group7.app.ui.orderui;

import java.util.Scanner;
import dev.group7.app.bl.OrderBL;
import dev.group7.app.bl.ProductBL;
import dev.group7.app.bl.UsersBL;
import dev.group7.app.dal.OrderDAL;
import dev.group7.app.dal.UsersDAL;
import dev.group7.app.ui.Method;
import dev.group7.app.persistance.Order;
import java.util.List;
import java.util.ArrayList;
import dev.group7.app.persistance.Product;
import dev.group7.app.persistance.Users;
import java.util.Calendar;
import java.sql.SQLException;

public class OrderUI {
    static Scanner sc = new Scanner(System.in);
    static OrderBL obl = new OrderBL();
    static Method mt = new Method();
    static ProductBL pbl = new ProductBL();
    static OrderUI oui = new OrderUI();
    // static OrderDetailsUI odui = new OrderDetailsUI();
    static UsersBL ubl = new UsersBL();
    static int idus = 0;
    static OrderDAL odal = new OrderDAL();
    static int idod = odal.reOrderID();

    // ================-----------=================
    public void showAllOrder() {
        List<Order> lod = obl.OrderAll();
        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-10s | %-25s | %-25s | %-10s |\n", "Order_id", "User_id", "Order_date",
                "Total Price", "Status");
        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
        if (lod.isEmpty())
            System.out.println("Empty list!");
        for (Order o : lod) {
            System.out.printf("| %-10d | %-10d | %-25s | %-25.2f | %-10s |\n", o.getOrder_id(), o.getUser_id(),
                    o.getLocal_DT(), o.getTotal_price(), o.getStatus());
        }
        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
    }

    public void showAllOrderBid() {

        System.out.print("enter orderid you want to see: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Order> lbid = obl.orderbid(id);
        List<Order> ltotal = obl.ordertotal(id);
        List<Users> listCus = ubl.getInfoCus(id);
        for (Users user : listCus) {
            System.out.println("===========================================================================================");
            System.out.printf("| %-30s | %-26s | %-25s |\n", "Prepared by:", "Invoice by:", "Invoice details:");
            System.out.printf("| %-30s | %-26s | %-25s |\n", "Men's clothing store", user.getUserName(),
                    user.getUserphone());
            System.out.printf("| %-30s | %-26s | %-25s |\n", "", "", user.getUseremail());
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.printf("| %-30s | %-12s | %-11s | %-25s |\n", "Product Name", "Unit price", "Quantity",
                    "Total Price");
            System.out.println("+=========================================================================================+");
        }
        if (lbid.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            for (Order o : lbid) {
                System.out.printf("| %-30s | %-11s | %-11s | %-25s |\n", o.getProduct().getPro_name(),
                        o.getProduct().getUnitPrice()+" VND", o.getQuantity(),
                        o.getProduct().getUnitPrice() * o.getQuantity()+" VND");
            }
        }
        for (Order order2 : ltotal) {
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.printf("| %-40s   %-17s: %-25s |\n", "", "Total Price", order2.getTotal_price()+" VND");
            System.out.println("===========================================================================================");
        }

    }

    // =========================
    public void showorderbyuser() {

        System.out.print("enter orderid you want to see: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if (getidOrderbyUser(id)) {
                List<Order> lbid = obl.orderbid(id);
                List<Order> ltotal = obl.ordertotal(id);
                List<Users> listCus = ubl.getInfoCus(id);
                for (Users user : listCus) {
                    System.out.println("===========================================================================================");
                    System.out.printf("| %-30s | %-26s | %-25s |\n", "Prepared by:", "Invoice by:", "Invoice details:");
                    System.out.printf("| %-30s | %-26s | %-25s |\n", "Men's clothing store", user.getUserName(),
                            user.getUserphone());
                    System.out.printf("| %-30s | %-26s | %-25s |\n", "", "", user.getUseremail());
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.printf("| %-30s | %-12s | %-11s | %-25s |\n", "Product Name", "Unit price", "Quantity",
                            "Total Price");
                    System.out.println("+=========================================================================================+");
                }
                
                if (lbid.isEmpty()) {
                    System.out.println("Empty list!");
                } else {
                    for (Order o : lbid) {
        
                        System.out.printf("| %-30s | %-11s | %-11s | %-25s |\n", o.getProduct().getPro_name(),
                                o.getProduct().getUnitPrice()+" VND", o.getQuantity(),
                                o.getProduct().getUnitPrice() * o.getQuantity()+" VND");
                    }
                }
                for (Order order2 : ltotal) {
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.printf("| %-40s   %-17s: %-25s |\n", "", "Total Price", order2.getTotal_price()+" VND");
                    System.out.println("===========================================================================================");
                }
            }else{
                System.out.println("Your order id does not exist!");
                
            }
        } catch (Exception e) {
            System.out.println("Input wrong type!");
            
        }

    }

    // =========================
    public static boolean getidOrderbyUser(int id) {
   
        // System.out.print("enter order_id: ");
        // int idorder = Integer.parseInt(sc.nextLine());
        List<Order> order = obl.getbyiduser();
        for (Order orderid : order) {
            if (orderid.getOrder_id() == id) {

                return true;
            } 
        }

       
        return false;
    }

    public void showAllOrderById() {
        List<Order> lbid = obl.OrderById();
        System.out.println("\nOrder List ");
        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-10s | %-25s | %-25s | %-10s |\n", "Order_id", "User_id", "Order_date",
                "Total Price", "Status");
        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
        if (lbid.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            for (Order o : lbid) {
                System.out.printf("| %-10d | %-10d | %-25s | %-25.2f | %-10s |\n", o.getOrder_id(), o.getUser_id(),
                        o.getLocal_DT(), o.getTotal_price(), o.getStatus());
            }
        }

        System.out.println(
                "+----------------------------------------------------------------------------------------------+");
    }
    // ====================-------------====================

    public void UpdateStatusOrder() {
        while (true) {
            Order order = new Order();

            List<Order> LOD = new ArrayList<>();

            System.out.print("Enter Order_id(enter to quit) : ");
            int id = Integer.parseInt(sc.nextLine());
            order.setOrder_id(id);

            System.out.print("Enter Update Status : ");
            order.setStatus(sc.nextLine());

            System.out.print("Do you want to update your order?(y/n): ");
            String choice = mt.yesno();
            if (choice.equalsIgnoreCase("y")) {
                LOD.add(order);
                try {
                    obl.UpdateOrder(order);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error occurred, cannot update!");
            }
            System.out.print("Do you want to continue to update the Order(y/n): ");
            String x = mt.yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    // ========================------==========================

    // return product by id
    public Product getItem(int id) {

        List<Product> lst = pbl.getAllPro();
        Product rs_item = null;
        for (Product product : lst) {
            if (id == product.getPro_id()) {
                rs_item = product;
            }
        }
        if (rs_item.equals(null)) {
            return null;
        } else {
            return rs_item;
        }
    }

    // check that the id exists or not
    public boolean checkIdProduct(int id) {
        List<Product> lsp = pbl.getAllPro();
        boolean check = false;
        for (Product p : lsp) {
            if (id == p.getPro_id()) {
                return true;
            } else {
                check = false;
            }
        }
        return check;
    }

    public static Users getInforUsers(int id) {

        List<Users> lst = ubl.getAllus();
        Users rs_users = null;
        for (Users user : lst) {
            if (id == user.getUserId()) {
                rs_users = user;
            }
        }
        if (rs_users.equals(null)) {
            return null;
        } else {
            return rs_users;
        }
    }

    // tao order
    public static Order ordernew() {
        Order order = new Order();

        idus = UsersDAL.idus;// id người dùng đăng nhập
        Users user = new Users();
        user.setUserId(idus);
        user = getInforUsers(idus);

        order.setUsers(user);

        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        // Trả về giá trị từ 0 - 11
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        String order_date = day + "/" + (month + 1) + "/" + year;
        // set Date
        order.setLocal_DT(order_date);// set ngày tạo
        String status = "pending"; // Set status
        order.setStatus(status);
        return order;
    }

    static List<Order> listorderdetail = new ArrayList<>();

    // tao orderdetail
    public Order Orderdetailsnew() throws SQLException {
        Product product = new Product();
        Order orderdetail = new Order();
        int id;
        int amount = 0;// số sản phẩm mua
        while (true) {
            while (true) {
                System.out.print("Enter Product_id: ");
                try {
                    id = Integer.parseInt(sc.nextLine());
                    if (!checkIdProduct(id)) {
                        System.out.print("ID does not exist !\n Re-enter! ");
                    } else {
                        product = getItem(id);
                        System.out.println("You are choosing to buy the product " + product.getPro_name());
                        product.setPro_name(product.getPro_name());
                        product.setUnitPrice(product.getUnitPrice());
                        orderdetail.setProduct(product);
                        orderdetail.setPro_id(product.getPro_id());
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Input wrong data type!");
                    continue;
                }
            }
            boolean w = true;
            while (w) {
                System.out.print("Enter Quantity: ");
                try {

                    amount = Integer.parseInt(sc.nextLine());

                    if (amount > product.getAmount()) {
                        System.out.printf("The store has only %d items left", product.getAmount());
                        System.out.print("Enter any key to continue...");
                        sc.nextLine();
                        break;
                    } else {
                        if (amount > 0) {
                            int re_amount = product.getAmount() - amount;
                            product.setAmount(re_amount);
                            double unitp = product.getUnitPrice();
                            // set unit_price
                            orderdetail.setUnit_price(unitp);
                            // set Quantity
                            orderdetail.setQuantity(amount);
                            // total_price = orderdetail.getQuantity() * orderdetail.getUnit_price();
                            w = false;
                            break;
                        } else if (amount <= 0) {
                            System.out.println("Quantity must be greater than 0!\n");
                            System.out.print("Re-enter!\n");
                        } else {
                            System.out.print("Re-enter!\n");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Input wrong data type!");
                    continue;
                }

            }
            pbl.UpdatePro(product);
            return orderdetail;
        }
    }

    public static void getOrderdetainew(Order orderdt) {
        listorderdetail.add(orderdt);
    }

    // tao order-orderdetail
    public void CreateOrder() throws SQLException {
        String choice = null;
        // boolean w = true;
        do {
            Order taoOrderDt = Orderdetailsnew();
            getOrderdetainew(taoOrderDt);
            while (true) {
                System.out.print("Do you want to add products?(y/n): ");
                try {
                    choice = mt.yesno();
                    if (choice.equalsIgnoreCase("y")) {
                        break;
                    } else if (choice.equalsIgnoreCase("n")) {
                        // checkamount();
                        Order call_order = ordernew();
                        call_order.setTotal_price(re_total());
                        boolean rs_insert = obl.insert(call_order, listorderdetail);
                        if (rs_insert) {
                            System.out.println("Create Order Successful!!!>");
                            orderjustcreated(call_order, listorderdetail);

                            listorderdetail.clear();

                        } else {
                            System.out.println("Create Order Fail!!!>");
                        }
                        break;
                    } else {
                        System.out.print("Re-enter! ");
                        // sc.nextLine();
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        } while (choice.equalsIgnoreCase("y"));
    }

    // return order with totalprice
    public static double re_total() {
        // Order taoOrder = ordernew();
        double total = 0;
        for (Order orderdt : listorderdetail) {
            total += orderdt.getUnit_price() * orderdt.getQuantity();
        }

        return total;
    }

    public void orderjustcreated(Order order, List<Order> listorder) {
        System.out.println("===========================================================================================");
        System.out.printf("| %-30s | %-26s | %-25s |\n", "Prepared by:", "Invoice by:", "Invoice details:");
        System.out.printf("| %-30s | %-26s | %-25s |\n", "Men's clothing store", order.getUsers().getUserName(),
                order.getUsers().getUserphone());
        System.out.printf("| %-30s | %-26s | %-25s |\n", "", "", order.getUsers().getUseremail());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-30s | %-12s | %-11s | %-25s |\n", "Product Name", "Unit price", "Quantity",
                "Total Price");
        System.out.println("+=========================================================================================+");
        if (listorder.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            for (Order o : listorder) {
                System.out.printf("| %-30s | %-11s | %-11s | %-25s |\n", o.getProduct().getPro_name(),
                        o.getProduct().getUnitPrice()+" VND", o.getQuantity(),
                        o.getProduct().getUnitPrice() * o.getQuantity()+" VND");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-40s   %-17s: %-25s |\n", "", "Total Price", order.getTotal_price()+"VND");
        System.out.println("===========================================================================================");
    }

    // =============================----------===============================
    public void Manage_Order_Customer() {
        oui.showAllOrderById();
        System.out.print("Do you want view Order details?\nEnter (y/n): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            oui.showorderbyuser();

        } else {

        }
    }

    public void Manage_Order_Admin() {
        boolean w = true;
        while (w) {
            try {
                mt.cls();
                System.out.println("+======================================+");
                System.out.println("|            PF10 - Group 7            |");
                System.out.println("|      Welcome to Clothings Store      |");
                System.out.println("|             Manage Order             |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1.        Update Status Order        |");
                System.out.println("| 2.           View All Order          |");
                System.out.println("| 0.               Exits               |");
                System.out.println("+--------------------------------------+");
                System.out.print("Enter Your's Choice[1 , 2 or 0]: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();

                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|          Update Status Order         |");
                        System.out.println("+--------------------------------------+");
                        oui.showAllOrder();
                        oui.UpdateStatusOrder();
                        break;
                    case "2":
                        mt.cls();

                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|            Show All Order            |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("\nList Orders");
                        oui.showAllOrder();
                        System.out.print("Do you want view Order details?\nEnter (y/n): ");
                        String id = sc.nextLine();
                        if (id.equalsIgnoreCase("y")) {
                            oui.showAllOrderBid();
                        }
                        System.out.print("Enter any key to continue...");
                        sc.nextLine();
                        break;
                    case "0":
                        System.out.println("Exits!!");
                        w = false;
                        break;
                    default:
                        System.out.print("You entered incorrectly, please re-enter!\nPress any key...");
                }
            } catch (Exception e) {
            }
        }
    }
}