package dev.group7.app.ui.orderui;

import java.util.Scanner;

import dev.group7.app.bl.OrderBL;
import dev.group7.app.bl.ProductBL;
import dev.group7.app.bl.UsersBL;
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
    static int idus = 0;
    static Users user = new Users();
    static UsersBL ubl = new UsersBL();
    static UsersDAL udal = new UsersDAL();
    static OrderUI oui = new OrderUI();
    static OrderDetailsUI odui = new OrderDetailsUI();

    // public static boolean insertO_OD(){
    // return obl.CreateOrder();
    // }
    public void UpdateStatusOrder() {
        while (true) {
            Order order = new Order();

            List<Order> LOD = new ArrayList<>();

            System.out.print("Nhap Order_id : ");
            int id = Integer.parseInt(sc.nextLine());
            order.setOrder_id(id);

            System.out.print("Update Status: ");
            order.setStatus(sc.nextLine());

            System.out.println("ban co muon update status order(y/n)?");
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
            System.out.println("Do you want to continue to update the Order?(y/n)");
            String x = mt.yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAllOrder() {
        List<Order> lod = obl.OrderAll();
        System.out.println("\nItem List: ");
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

    // ==========------==========
    // tao order
    public static Order ordernew() {
        Order order = new Order();

        idus = UsersDAL.idus;// id người dùng đăng nhập
        Users user = new Users();
        user.setUserId(idus);
        // set user_ID
        order.setUsers(user);

        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        // Trả về giá trị từ 0 - 11
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        String order_date = day + "/" + (month + 1) + "/" + year;
        // set Date
        order.setLocal_DT(order_date);// set ngày tạo
        String status = "0"; // Set status
        order.setStatus(status);
        return order;

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

    // tao orderdetail
    public Order Orderdetailsnew() throws SQLException {
        Product product = new Product();
        Order orderdetail = new Order();
        int id;
        int dem = 0;// đếm sản phẩm thứ ?
        int amount = 0;// số sản phẩm mua
        while (true) {
            while (true) {
                System.out.print("Nhap Product_id '" + (dem + 1) + "': ");
                id = Integer.parseInt(sc.nextLine());
                if (!checkIdProduct(id)) {
                    System.out.println("ID does not exist !\n Nhap Lai: ");
                } else {
                    product = getItem(id);
                    orderdetail.setPro_id(product.getPro_id());
                    break;
                }
            }

            boolean w = true;
            while (w) {
                System.out.print("Nhap so luong: ");
                amount = Integer.parseInt(sc.nextLine());

                if (amount > product.getAmount()) {
                    System.out.printf("The store has only %d items left\nEnter any key...", product.getAmount());
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
                    } else if (amount < 0) {
                        System.out.println("Quantity must be greater than 0!\n");
                        System.out.print("Nhap lai: ");
                    } else {
                        System.out.print("Nhap lai: ");
                    }
                }
            }
            pbl.UpdatePro(product);
            return orderdetail;
        }
    }

    public void getOrderdetainew(Order orderdt) {

        listorderdetail.add(orderdt);
    }

    // tao order-orderdetail
    public void CreateOrder() throws SQLException {
        String choice = null;
        // boolean w = true;
        do {
            Order taoOrderDt = Orderdetailsnew();
            getOrderdetainew(taoOrderDt);
            System.out.print("Ban co muon them san pham?(y/n): ");
            choice = mt.yesno();

            if (choice.equalsIgnoreCase("y")) {

            } else if (choice.equalsIgnoreCase("n")) {
                Order call_order = re_total();
                boolean rs_insert = obl.insert(call_order, listorderdetail);
                if (rs_insert) {
                    System.out.println("Create Order Successful!!!>");
                } else {
                    System.out.println("Create Order Fail!!!>");
                }
            } else {
                System.out.print("Nhap lai: ");
                sc.nextLine();
            }
        } while (choice.equalsIgnoreCase("y"));
    }

    static double total;
    static List<Order> listorderdetail = new ArrayList<>();

    // return order with totalprice
    public static Order re_total() {
        Order taoOrder = ordernew();
        for (Order orderdt : listorderdetail) {
            total += orderdt.getUnit_price() * orderdt.getQuantity();
        }
        taoOrder.setTotal_price(total);
        return taoOrder;
    }
    //===========----------===========
    // ==========================
    public void Manage_Order_Admin() {
        boolean w = true;
        while (w) {
            try {
                System.out.println("+--------------------------------------+");
                System.out.println("|             PF10 - Group 7           |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1.        Update Status Order        |");
                System.out.println("| 2.           View All Order          |");
                System.out.println("| 0.               Exits               |");
                System.out.println("+--------------------------------------+");
                System.out.print("Enter Your's Choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        oui.showAllOrder();
                        oui.UpdateStatusOrder();
                        break;
                    case "2":
                        mt.cls();
                        System.out.println("\nList Orders");
                        oui.showAllOrder();
                        odui.showOrderdetails();
                        System.out.println("Enter any key to continue :");
                        sc.nextLine();
                        break;
                    case "0":
                        System.out.println("Exits!!");
                        w = false;
                        break;
                    default:
                        System.out.println("You entered incorrectly, please re-enter!\nPress any key...");

                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}