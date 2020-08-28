package dev.group7.app.ui;

import java.util.Scanner;

import dev.group7.app.bl.OrderBL;
import dev.group7.app.bl.ProductBL;
import dev.group7.app.bl.UsersBL;

public class ProductUI {
    // static Scanner sc = new Scanner(System.in);
    // static Method mt = new Method();
    static UsersBL ubl = new UsersBL();
    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();
    static OrderUI odg = new OrderUI();
    static OrderBL obl = new OrderBL();
    static ProductBL pbl = new ProductBL();
    static ProductUI pui= new ProductUI();

    public void menu_manageProduct() {
        boolean w = true;
        while (w) {
            mt.cls();
            try {
                System.out.println("+-------------------------------------+");
                System.out.println("| 1. Insert Product                   |");
                System.out.println("| 2. Update product                   |");
                System.out.println("| 3. ShowAllProduct                   |");
                System.out.println("| 0. Exit                             |");
                System.out.println("+-------------------------------------+");
                System.out.print("Nhap lua chon: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        pbl.insertPro();
                        break;
                    case "2":
                        mt.cls();
                        pbl.showProduct();
                        System.out.println("Updates!!!");
                        pbl.inputInfoUpdate();
                        break;
                    case "0":
                        System.out.println("Exit!!!");
                        w = false;
                        // System.exit(0);
                        break;
                    case "3":
                        mt.cls();

                        pbl.showProduct();
                        System.out.println("Enter any key to continue :");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("You entered incorrectly, please re-enter!\nPress any key...");
                        sc.nextLine();
                        // break;
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            // break;
        }
    }
}