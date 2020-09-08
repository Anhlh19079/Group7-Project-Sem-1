package dev.group7.app.ui.userui;

import dev.group7.app.bl.UsersBL;
import dev.group7.app.ui.Method;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
import dev.group7.app.persistance.Users;

public class UserUI {
    static UsersBL ubl = new UsersBL();
    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();

    public String checkUser() throws SQLException {
        String Role = "";
        boolean w = true;
        try {
            while (w) {
                System.out.print("Enter Username: ");
                String name = sc.nextLine();

                System.out.print("Enter PassWord: ");
                String pass = sc.nextLine();

                if (name.trim().isEmpty() || pass.trim().isEmpty()) {
                    System.out.println("Please enter enough information!");
                    while (w) {
                        System.out.print("Do you want to continue?(y/n): ");
                        String choice = mt.yesno();
                        if (choice.equalsIgnoreCase("n")) {
                            w = false;
                            break;
                        } else if (choice.equalsIgnoreCase("Y")) {
                            break;
                        } else {
                            System.out.println("Only 'y' or 'n' ");
                        }
                    }
                } else {
                    Role = ubl.checkUserLogin(name, pass);
                   
                    if (Role == null) {
                        System.out.println("Account or password is incorrect, please re-enter");
                        System.out.print("Enter to continue...");
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

    public void showUsers() {
        List<Users> lus = ubl.getAllus();
        System.out.println("\nUsers List: ");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-25s | %-15s | %-20s | %-20s | %-10s | %-12s | \n", "ID", "User Name", "User Password","User Phone","User Email", "Role","Status");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------+");
        if (lus.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Users us : lus) {
            System.out.printf("| %-10d | %-25s | %-15s | %-20s | %-20s | %-10s | %-12s | \n", us.getUserId(), us.getUserName(),
                    us.getUserPass(),us.getUserphone(),us.getUseremail(), us.getRole(),us.getUserstatus());
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------+");
    }

    
}