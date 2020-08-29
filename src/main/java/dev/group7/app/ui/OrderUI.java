package dev.group7.app.ui;

import java.util.Scanner;


import dev.group7.app.bl.OrderBL;

public class OrderUI {
    static Scanner sc = new Scanner(System.in);
    OrderBL obl = new OrderBL();
    Method mt = new Method();

    public void Manage_Order_Customer() {
        obl.showByID();
    }

    public void Manage_Order_Admin() {
        boolean w = true;
        while (w) {
            try {
                System.out.println("+----------------------------+");
                System.out.println("| 1.  Update Status Order    |");
                System.out.println("| 2.    View All Order       |");
                System.out.println("| 0.         Exits           |");
                System.out.println("+----------------------------+");
                System.out.print("Enter Your's Choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                    mt.cls();
                    OrderBL.showAllOrder();
                    OrderBL.UpdateStatusOrder();
                        break;

                    case "2":
                        mt.cls();
                        System.out.println("\nList Orders");
                        OrderBL.showAllorder_oredrdt();
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