package dev.group7.app.ui.userui;

import java.sql.SQLException;
import java.util.Scanner;
import dev.group7.app.dal.UsersDAL;
import dev.group7.app.ui.Method;
import dev.group7.app.ui.orderui.OrderUI;
import dev.group7.app.ui.productui.ProductUI;

public class MemberShip {
    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();
    static OrderUI oui = new OrderUI();
    static ProductUI pui = new ProductUI();
    static UserUI uiu = new UserUI();
    int id = 0;

    public void MemberShipMenu() throws SQLException {
        String Role = uiu.checkUser();
        id = UsersDAL.idus;
        if (Role == null) {

            uiu.checkUser();
        } else if (Role.equals("Admin")) {
            AdminMenu();
        } else if (Role.equals("Customer")) {
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
            System.out.println("=============== Customer ===============");
            System.out.println("+======================================+");
            System.out.println("|      Welcome to Clothings Store      |");
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
                    System.out.println("+======================================+");
                    System.out.println("|            PF10 - Group 7            |");
                    System.out.println("|      Welcome to Clothings Store      |");
                    System.out.println("|               Search                 |");
                    System.out.println("+--------------------------------------+");
                    
                    pui.showProduct();
                    pui.SearchProByName();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;

                case "2":
                    mt.cls();
                    System.out.println("+======================================+");
                    System.out.println("|            PF10 - Group 7            |");
                    System.out.println("|      Welcome to Clothings Store      |");
                    System.out.println("|              Buy item                |");
                    System.out.println("+--------------------------------------+");
                    pui.showProduct();
                    oui.CreateOrder();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;

                case "3":
                    mt.cls();
                    System.out.println("+======================================+");
                    System.out.println("|            PF10 - Group 7            |");
                    System.out.println("|      Welcome to Clothings Store      |");
                    System.out.println("|          View History Order          |");
                    System.out.println("+--------------------------------------+");
                    oui.Manage_Order_Customer();
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
            System.out.println("================ Admin =================");
            System.out.println("+======================================+");
            System.out.println("|      Welcome to Clothings Store      |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Manage Products.                  |");
            System.out.println("| 2. Manage Order.                     |");
            System.out.println("| 3. View Users.                       |");
            System.out.println("| 0. Exit.                             |");
            System.out.println("+--------------------------------------+");
            System.out.print("Input Your Choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    mt.cls();
                    pui.menu_manageProduct();
                    break;

                case "2":
                    mt.cls();
                    oui.Manage_Order_Admin();
                    break;
                case "3":
                    mt.cls();
                    uiu.showUsers();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;
                case "0":
                    System.out.println("Exit!");
                    w = false;
                    break;

                default:
                    System.out.println("Enter incorrectly, re-enter: ");
                    sc.nextLine();
                    // break;
            }
        }
    }
}