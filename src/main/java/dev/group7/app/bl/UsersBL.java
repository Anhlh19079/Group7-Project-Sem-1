package dev.group7.app.bl;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import dev.group7.app.dal.UsersDAL;
import dev.group7.app.gui.Method;
import dev.group7.app.persistance.Users;

public class UsersBL {

    public static UsersDAL udal = new UsersDAL();
    public static Users users = new Users();
    public static Method mt = new Method();
    public static ProductBL bl = new ProductBL();

    // public static void logg() {
    // try {
    // System.out.print("Nhap User Name:");
    // String usename = sc.nextLine();
    // System.out.println("Nhap Password: ");
    // String usepass = sc.nextLine();
    // String check = udal.checklogin(usename, usepass);
    // if (check.equals("Admin")) {
    // pro.AdminMenu();
    // } else if (check.equals("Customer")) {
    // pro.CustomerMenu();
    // } else {
    // System.out.println("ko co role");
    // }

    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }

    public List<Users> getAllus() {
        return udal.getAllUser();
    }

    // static List<Users> lus = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void showUsers() {
        UsersBL ubl = new UsersBL();
        List<Users> lus = ubl.getAllus();
        System.out.println("\nUsers List: ");
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-25s | %-15s | %-10s | \n", "ID", "User Name", "User Password", "Role");
        System.out.println("+-----------------------------------------------------------------------+");
        if (lus.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Users us : lus) {
            System.out.printf("| %-10s | %-25s | %-15s | %-10s | \n", us.getUserId(), us.getUserName(),
                    us.getUserPass(), us.getRole());
        }
        System.out.println("+-----------------------------------------------------------------------+");

    }

    public String checkUser() throws SQLException {
        String Role = "";
        // while (true) {
        boolean w = true;
        // while (true) {

        try {
            while (w) {
                UsersDAL udal = new UsersDAL();
                System.out.print("Nhap User Name: ");
                String name = sc.nextLine();

                System.out.print("Nhap PassWord: ");
                String pass = sc.nextLine();

                if (name.trim().isEmpty() || pass.trim().isEmpty()) {
                    System.out.println("Please enter enough information!");
                    while (w) {

                        System.out.print("Do you want to continue?(y/n): ");
                        String choice = mt.yesno();
                        if (choice.equalsIgnoreCase("N")) {
                            w=false;
                            break;
                        } else if (choice.equalsIgnoreCase("Y")) {
                            break;
                        } else {
                            System.out.println("Only 'y' or 'n' ");
                            // break;
                        }
                    }
                } else {
                    Role = udal.checklogin(name, pass);
                    if (Role == null) {
                        System.out.println("Account or password is incorrect, please re-enter");
                        System.out.println("Enter to continue!");
                        sc.nextLine();
                    } else {
                        System.out.println("Valid Acc!");
                        return Role;
                    }
                }
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return Role;
    }
}
