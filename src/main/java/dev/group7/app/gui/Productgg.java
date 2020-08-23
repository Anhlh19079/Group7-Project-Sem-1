package dev.group7.app.gui;

import java.util.Scanner;

import dev.group7.app.bl.ProductBL;

public class Productgg {
    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();

    public static void menu_manageProduct() {
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

                String choice;
                System.out.print("Nhap lua chon: ");
                choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        ProductBL.insertPro();
                        break;
                    case "2":
                        mt.cls();
                        ProductBL.showProduct();
                        System.out.println("Updates!!!");
                        ProductBL.inputInfoUpdate();
                        break;
                    case "0":
                        System.out.println("Exit!!!");
                        w = false;
                        // System.exit(0);
                        break;
                    case "3":
                        // cls();

                        ProductBL.showProduct();
                        System.out.println("Enter any key to continue :");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("ban da nhap sai lua chon. vui long nhap lai!");
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