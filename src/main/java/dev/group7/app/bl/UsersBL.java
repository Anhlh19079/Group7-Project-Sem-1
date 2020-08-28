package dev.group7.app.bl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.group7.app.dal.UsersDAL;
import dev.group7.app.persistance.Users;
import dev.group7.app.ui.Method;

public class UsersBL {

    public static UsersDAL udal = new UsersDAL();
    public static Users users = new Users();
    public static Method mt = new Method();
    public static ProductBL bl = new ProductBL();

    

    public List<Users> getAllus() {
        return udal.getAllUser();
    }

    // static List<Users> lus = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void showUsers() {
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

    public static List<Users> unpi = new ArrayList<>();
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
                        return Role ;
                    }
                }
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return Role;
    }

    //-----------------------------------------//
    // public static int checkUser() throws SQLException {
    //     String Role = "";
    //     int id =-1;
    //     // while (true) {
    //     boolean w = true;
    //     // while (true) {
    //     try {
    //         while (w) {
    //             UsersDAL udal = new UsersDAL();
    //             System.out.print("Nhap User Name: ");
    //             String name = sc.nextLine();

    //             System.out.print("Nhap PassWord: ");
    //             String pass = sc.nextLine();

    //             if (name.trim().isEmpty() || pass.trim().isEmpty()) {
    //                 System.out.println("Please enter enough information!");
    //                 while (w) {

    //                     System.out.print("Do you want to continue?(y/n): ");
    //                     String choice = mt.yesno();
    //                     if (choice.equalsIgnoreCase("N")) {
    //                         w=false;
    //                         break;
    //                     } else if (choice.equalsIgnoreCase("Y")) {
    //                         break;
    //                     } else {
    //                         System.out.println("Only 'y' or 'n' ");
    //                         // break;
    //                     }
    //                 }
    //             } else {
    //                 id = udal.checkloginid(name, pass);
    //                 if (id <1) {
    //                     System.out.println("Account or password is incorrect, please re-enter");
    //                     System.out.println("Enter to continue!");
    //                     sc.nextLine();
    //                 } else {
    //                     // Role = udal.checklogin(name, pass);
    //                     System.out.println("Valid Acc!");
    //                     return id ;
    //                 }
    //             }
    //         }
    //     } catch (SQLException e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }
    //     return id;
    // }
    // public static String returnRole() throws SQLException {
    //     String role;
    //     UsersBL.checkUser();


    //     return role;
    // }
    // public int checkid(){
    //     int id=0;
    //     boolean w = true;
    //     try {
    //         while (w) {
    //             UsersDAL udal = new UsersDAL();
    //             Users us = new Users();
    //             System.out.print("Nhap User Name: ");
    //             String name = sc.nextLine();

    //             System.out.print("Nhap PassWord: ");
    //             String pass = sc.nextLine();

    //             if (name.trim().isEmpty() || pass.trim().isEmpty()) {
    //                 System.out.println("Please enter enough information!");
    //                 while (w) {

    //                     System.out.print("Do you want to continue?(y/n): ");
    //                     String choice = mt.yesno();
    //                     if (choice.equalsIgnoreCase("N")) {
    //                         w=false;
    //                         break;
    //                     } else if (choice.equalsIgnoreCase("Y")) {
    //                         break;
    //                     } else {
    //                         System.out.println("Only 'y' or 'n' ");
    //                         // break;
    //                     }
    //                 }
    //             } else {
    //                 id = udal.checklogin(name, pass);
    //                 if (id == null) {
    //                     System.out.println("Account or password is incorrect, please re-enter");
    //                     System.out.println("Enter to continue!");
    //                     sc.nextLine();
    //                 } else {
    //                     System.out.println("Valid Acc!");
    //                     return id ;
    //                 }
    //             }
    //         }
    //     } catch (SQLException e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }
    //     return id;
        
    // }
}
