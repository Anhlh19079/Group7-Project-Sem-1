package dev.group7.app.gui;

import java.sql.SQLException;
import java.util.Scanner;

import dev.group7.app.bl.ProductBL;
import dev.group7.app.bl.UsersBL;

public class MemberShip {
static UsersBL ubl = new UsersBL();
    static Scanner sc  = new Scanner(System.in);
    static Method mt = new Method();
    
    public void MenberShipMenu() throws SQLException {
        String Role = ubl.checkUser();
        UsersBL ubl = new UsersBL();
        if (Role == null) {
            ubl.checkUser();
        } else if (Role.equals("Admin")) {
            AdminMenu();
        } else if (Role.equals("Customer")) {
            CustomerMenu();
        } else {
            System.out.println("Error!");
        }

    }

    public static void CustomerMenu() {
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
                ProductBL.showProduct();
                System.out.println("Enter any key to continue: ");
                sc.nextLine();
                    break;

                case "2":

                    break;
                case "3":
                    break;

                case "0":
                    System.out.println("Exit!");
                    w=false;
                    break;
                default:
                    System.out.print("Nhap sai ! nhap lai: ");
                    sc.nextLine();

            }
        }

    }

    public static void AdminMenu() {
       boolean w=true;
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
                    Productgg.menu_manageProduct();
                    break;

                case "2":

                    break;
                case "3":
                    mt.cls();
                    UsersBL.showUsers();
                    System.out.println("Enter any key to continue: ");
                    sc.nextLine();
                    break;
                case "0":
                    // System.out.println("Ket thuc chuong trinh!!!");
                    System.out.println("Exit!");
                    w=false;
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