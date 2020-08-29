package dev.group7.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dev.group7.app.bl.ProductBL;
import dev.group7.app.dal.DBUtil;
import dev.group7.app.ui.MemberShip;
import dev.group7.app.ui.Method;

public class App {
    public static void main(String[] args) throws Exception {

        try (Connection connection = DBUtil.getConnection();) {
            System.out.println("Connected to MySql Server.\n");

            Scanner sc = new Scanner(System.in);

            ProductBL pbl = new ProductBL();

            Method mt = new Method();
            MemberShip mbs = new MemberShip();
            while (true) {
                mt.cls();
                System.out.println("+--------------------------------------+");
                System.out.println("|            PF10 - Group 7            |");
                System.out.println("+--------------------------------------+");
                System.out.println("|       1. Manage MenberShip           |\n");
                System.out.println("|    2. View And Search Clothings      |\n");
                System.out.println("|             0. Exit                  |");
                System.out.println("+--------------------------------------+");
                System.out.print("Enter Your Choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        
                        mbs.MenberShipMenu();
                        break;
                    case "2":
                        pbl.showProduct();
                        System.out.println("Enter any key to continue : ");
                        sc.nextLine();
                        break;
                    case "0":
                        System.exit(0);
                        sc.close();
                        break;
                    default:
                        System.out.println("Nhap sai ! Nhap lai: ");
                        sc.nextLine();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
    }

}
