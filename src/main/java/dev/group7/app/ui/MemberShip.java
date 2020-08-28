package dev.group7.app.ui;

import java.sql.SQLException;
import java.util.Scanner;

import dev.group7.app.bl.OrderBL;
import dev.group7.app.bl.ProductBL;
import dev.group7.app.bl.UsersBL;
import dev.group7.app.dal.OrderDAL;
import dev.group7.app.dal.UsersDAL;

public class MemberShip {
    static UsersBL ubl = new UsersBL();
    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();
    static OrderUI odg = new OrderUI();
    static OrderBL obl = new OrderBL();
    static ProductBL pbl = new ProductBL();
    static ProductUI pui = new ProductUI();
    static OrderDAL odal = new OrderDAL();
    int id = 0;

    public void MenberShipMenu() throws SQLException {
        String Role = ubl.checkUser();
        UsersBL ubl = new UsersBL();
        id = UsersDAL.idus;
        if (Role == null) {
            ubl.checkUser();
        } else if (Role.equals("Admin")) {

            // System.out.println(id);
            AdminMenu();
        } else if (Role.equals("Customer")) {
            // System.out.println(id);

            CustomerMenu();
        } else {
            System.out.println("Error!");
        }

    }

    public static void CustomerMenu() throws SQLException {

        boolean w = true;
        while (w) {

            mt.cls();
            System.out.println("Login Successful!");
            System.out.println("UI Cus!");
            System.out.println("+--------------------------------------+");
            System.out.println("|            PF10 - Group 7            |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Search Clotings.                  |");
            System.out.println("| 2. Buy Items.                        |");
            System.out.println("| 3. View History Order.               |");
            System.out.println("| 0. Exit                              |");
            System.out.println("+--------------------------------------+");
            System.out.print("Input Your Choice: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    mt.cls();
                    pbl.showProduct();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;

                case "2":
                    mt.cls();
                    pbl.showProduct();
                    OrderBL.CreateOrder();
                    // OrderBL.addorder();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;

                case "3":
                    mt.cls();
                    odg.Manage_Order_Customer();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;

                case "0":
                    System.out.println("Exit!");
                    w = false;
                    break;
                default:
                    System.out.print("Nhap sai ! nhap lai: ");
                    sc.nextLine();

            }
        }

    }

    public static void AdminMenu() {

        boolean w = true;
        while (w) {
            mt.cls();
            System.out.println("Login Successful!");
            System.out.println("UI Adm!");
            System.out.println("+--------------------------------------+");
            System.out.println("|            PF10 - Group 7            |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Manage Products.                  |");
            System.out.println("| 2. Manage Order.                     |");
            System.out.println("| 3. View Users.                       |");
            System.out.println("| 0. Exit.                             |");
            System.out.println("+--------------------------------------+");
            System.out.print("Input Your Choice: ");
            String choice = sc.nextLine();
            // while (true) {

            switch (choice) {
                case "1":
                    mt.cls();
                    pui.menu_manageProduct();
                    break;

                case "2":
                    mt.cls();
                    odg.Manage_Order_Admin();
                    break;
                case "3":
                    mt.cls();
                    ubl.showUsers();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;
                case "0":
                    // System.out.println("Ket thuc chuong trinh!!!");
                    System.out.println("Exit!");
                    w = false;
                    break;

                default:
                    System.out.println("Nhap sai ! nhap lai: ");
                    sc.nextLine();
                    // break;
            }
            // break;
            // }
            // break;
        }
    }
}