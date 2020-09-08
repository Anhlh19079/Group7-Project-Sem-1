package dev.group7.app.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dev.group7.app.dal.DBUtil;
import dev.group7.app.ui.productui.ProductUI;
import dev.group7.app.ui.userui.MemberShip;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ProductUI pui = new ProductUI();
    MemberShip mbs = new MemberShip();
    Method mt = new Method();

    public void MainMenu() {
        try (Connection connection = DBUtil.getConnection();) {
            System.out.println("Connected to MySql Server.\n");
            Scanner sc = new Scanner(System.in);
            while (true) {
                mt.cls();
                System.out.println("+======================================+");
                System.out.println("|            PF10 - Group 7            |");
                System.out.println("|      Welcome to Clothings Store      |");
                System.out.println("+--------------------------------------+");
                System.out.println("|       1. Manage MemberShip           |\n");
                System.out.println("|    2. View And Search Clothings      |\n");
                System.out.println("|             0. Exit                  |");
                System.out.println("+--------------------------------------+");
                System.out.print("Enter Your Choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|                Login                 |");
                        System.out.println("+--------------------------------------+");
                        mbs.MemberShipMenu();
                        // mbs.mbs();
                        break;
                    case "2":
                        mt.cls();
                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|            View and Search           |");
                        System.out.println("+--------------------------------------+");
                        pui.showProduct();
                        pui.SearchProByName();
                        System.out.println("Enter any key to continue : ");
                        sc.nextLine();
                        break;
                    case "0":
                        System.out.println("Exit!");
                        System.exit(0);
                        sc.close();
                        break;
                    default:
                        System.out.print("Enter incorrectly, re-enter: ");
                        sc.nextLine();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
    }

}