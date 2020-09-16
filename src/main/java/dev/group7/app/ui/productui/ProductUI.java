package dev.group7.app.ui.productui;

import java.util.Scanner;

import dev.group7.app.bl.ProductBL;
import dev.group7.app.ui.Method;
import dev.group7.app.persistance.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductUI {

    static Scanner sc = new Scanner(System.in);
    static Method mt = new Method();
    static ProductBL pbl = new ProductBL();
    static ProductUI pui = new ProductUI();

    public void SearchProByName() {
        try {
            System.out.print("Enter Pro_name:");
            String name = sc.nextLine();
            List<Product> listpro = pbl.getByName(name);
            System.out.println("\nItem List: ");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-5s | %-30s | %-8s | %-15s | %-8s | %-35s | %-10s | \n", "ID", "Product Name", "Pack",
                    "Unit Price", "Amount", "Description", "Status");
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------------------------------------+");
            if (listpro.isEmpty())
                System.out.println("The list is empty!");
            for (Product p : listpro) {
                System.out.printf("| %-5s | %-30s | %-8s | %-15s | %-8s | %-35s | %-10s | \n", p.getPro_id(),
                        p.getPro_name(), p.getpro_pack(), p.getUnitPrice() + " VND", p.getAmount(), p.getDescription(),
                        p.getPro_status());
            }
            System.out.println(
                    "+-----------------------------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void showProduct() {
        List<Product> lst = pbl.getAllPro();
        System.out.println("\nItem List: ");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-5s | %-30s | %-8s | %-15s | %-8s | %-35s | %-10s | \n", "ID", "Product Name", "Pack","Unit Price", "Amount", "Description", "Status");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------------------------------------------+");
        if (lst.isEmpty())
            System.out.println("The list is empty!");
        for (Product p : lst) {
            System.out.printf("| %-5s | %-30s | %-8s | %-15s | %-8s | %-35s | %-10s | \n", p.getPro_id(),
                    p.getPro_name(), p.getpro_pack(), p.getUnitPrice() + " VND", p.getAmount(), p.getDescription(),
                    p.getPro_status());
        }
        System.out.println(
                "+-----------------------------------------------------------------------------------------------------------------------------------+");

    }
    // ==============================================================================================================
    // public void insertPro() {
    // while (true) {
    // ProductBL proBL = new ProductBL();
    // if (proBL.addProduct(inputProduct())) {
    // System.out.println("Insert product complete!");
    // } else {
    // System.out.println("Insert product failed!");
    // }
    // System.out.print("Continue Insert?(y/n):");
    // String choice1 = mt.yesno();
    // if (choice1.equalsIgnoreCase("N")) {
    // break;
    // }
    // }
    // }

    // public static Product inputProduct() {
    // Product product = new Product();

    // System.out.print("Pro_name(enter to quit): ");
    // product.setPro_name(sc.nextLine());

    // System.out.print("Unit Price(enter to quit): ");
    // Double gia = Double.parseDouble(sc.nextLine());
    // product.setUnitPrice(gia);

    // System.out.print("Amount: ");
    // int sl = Integer.parseInt(sc.nextLine());
    // product.setAmount(sl);

    // System.out.print("Description: ");
    // product.setDescription(sc.nextLine());

    // System.out.print("Pro_status: ");
    // product.setPro_status(sc.nextLine());
    // return product;
    // }
    public static boolean getcat(int id) {
        List<Product> cat = pbl.getcategories();
        for (Product product : cat) {
            if (product.getCategory_ID() == id) {
                return true;
            }
        }
        return false;
    }

    public static Product inputProduct() {
        Product product = new Product();
        try {
            while (true) {
                System.out.print("Cat_id[1-3]: ");
                try {
                    int catid = Integer.parseInt(sc.nextLine());
                    if (getcat(catid)) {
                        product.setCategory_ID(catid);
                        break;
                    } else {
                        System.out.print("Re-enter[1-3]!\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.toString());
                }

            }

            System.out.print("Pro_name(enter to quit): ");
            product.setPro_name(sc.nextLine());

            System.out.print("Pack: ");
            product.setpro_pack(sc.nextLine());

            System.out.print("Unit Price(enter to quit): ");
            Double gia = Double.parseDouble(sc.nextLine());
            product.setUnitPrice(gia);

            System.out.print("Amount: ");
            int sl = Integer.parseInt(sc.nextLine());
            product.setAmount(sl);

            System.out.print("Description: ");
            product.setDescription(sc.nextLine());

            System.out.print("Pro_status: ");
            product.setPro_status(sc.nextLine());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return product;
    }

    public void insertPro() {
        mt.cls();
        String choice = null;
        do {

            Product productdt = inputProduct();

            boolean result = pbl.addProduct(productdt);
            while (true) {
                System.out.print("Do you want add size,color,image-url for product?(y/n): ");
                String yorn = mt.yesno();
                if (yorn.equalsIgnoreCase("y")) {

                    themproduct_sizesandsizes();
                    while (true) {
                        System.out.print("Add colors?(y/n): ");
                        String c = mt.yesno();
                        if (c.equalsIgnoreCase("y")) {
                            themproduct_colorandcolor();
                            break;
                        } else if (c.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Only y or n! Re-enter");
                        }
                    }
                    while (true) {
                        System.out.print("Add image-url?(y/n): ");
                        String i = mt.yesno();
                        if (i.equalsIgnoreCase("y")) {
                            themproduct_imaandima();
                            break;
                        } else if (i.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.println("Only y or n! Re-enter");
                        }
                    }

                    break;
                } else if (yorn.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Onlyy y or n! Re-eter");
                }
            }

            if (result) {
                System.out.println("Insert product Successful!!!>");

            } else {
                System.out.println("Create Order Fail!!!>");
            }
            System.out.print("Do you want continue insert?(y/n): ");
            try {
                choice = mt.yesno();
                if (choice.equalsIgnoreCase("n")) {
                    break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        } while (choice.equalsIgnoreCase("y"));
    }

    // ===========add==============
    static int productid = pbl.reproductid();

    public static void themproduct_sizesandsizes() {
        String key = null;
        do {

            System.out.print("enter size: ");
            String sizename = sc.nextLine();
            pbl.insertsize(sizename);
            pbl.insertpsize(productid);
            boolean w = true;
            while (w) {
                System.out.print("Continue add size?: ");
                try {
                    key = mt.yesno();
                    if (key.equalsIgnoreCase("n")) {
                        break;
                    } else if (key.equalsIgnoreCase("y")) {
                        w = false;
                        break;
                    } else {
                        System.out.println("Only y or n ,re-enter!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } while (key.equalsIgnoreCase("y"));
    }

    // -------------
    public static void themproduct_colorandcolor() {
        String key = null;
        do {

            System.out.print("enter color: ");
            String colorname = sc.nextLine();
            pbl.insertcolor(colorname);
            pbl.insertpcolor(productid);
            boolean w = true;
            while (w) {
                System.out.print("Continue add color?: ");
                try {
                    key = mt.yesno();
                    if (key.equalsIgnoreCase("n")) {
                        break;
                    } else if (key.equalsIgnoreCase("y")) {
                        w = false;
                        break;
                    } else {
                        System.out.println("Only y or n ,re-enter!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } while (key.equalsIgnoreCase("y"));
    }

    // --------------
    public static void themproduct_imaandima() {

        String key = null;
        do {

            System.out.print("enter image-url: ");
            String imaurl = sc.nextLine();
            pbl.insertimage(imaurl);
            pbl.insertpimage(productid);
            boolean w = true;
            while (w) {
                System.out.print("Continue add url?: ");
                try {
                    key = mt.yesno();
                    if (key.equalsIgnoreCase("n")) {
                        break;
                    } else if (key.equalsIgnoreCase("y")) {
                        w = false;
                        break;
                    } else {
                        System.out.println("Only y or n ,re-enter!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } while (key.equalsIgnoreCase("y"));
    }

    // ===================================================================================================================
    public void inputInfoUpdate() {

        while (true) {

            Product product = new Product();
            List<Product> PR = new ArrayList<>();

            System.out.print("Enter Product_id (enter to quit): ");
            int id = Integer.parseInt(sc.nextLine());
            product.setPro_id(id);

            System.out.print("Update Pro_name: ");
            product.setPro_name(sc.nextLine());

            System.out.print("Update Unit_price: ");
            double price = Double.parseDouble(sc.nextLine());
            product.setUnitPrice(price);

            System.out.print("Update Amount: ");
            int amount = Integer.parseInt(sc.nextLine());
            product.setAmount(amount);

            System.out.print("Update Description: ");
            product.setDescription(sc.nextLine());

            System.out.print("Update Status: ");
            product.setPro_status(sc.nextLine());

            System.out.print("Do you want to Update product?(y/n): ");
            String choice = mt.yesno();
            if (choice.equalsIgnoreCase("y")) {
                PR.add(product);
                try {
                    pbl.UpdatePro(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.print("Error occurred, cannot update!");
            }
            System.out.print("Do you want to continue to update the product?(y/n): ");
            String x = mt.yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void menu_manageProduct() {
        boolean w = true;
        while (w) {
            mt.cls();
            try {
                System.out.println("+======================================+");
                System.out.println("|            PF10 - Group 7            |");
                System.out.println("|      Welcome to Clothings Store      |");
                System.out.println("|            Manage Product            |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1.          Insert Product           |");
                System.out.println("| 2.          Update product           |");
                System.out.println("| 3.          ShowAllProduct           |");
                System.out.println("| 0.               Exit                |");
                System.out.println("+--------------------------------------+");
                System.out.print("Enter your choice[1 , 2 , 3 or 0]: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();

                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|            Insert Product            |");
                        System.out.println("+--------------------------------------+");
                        pui.insertPro();
                        break;
                    case "2":
                        mt.cls();
                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|            Update Product            |");
                        System.out.println("+--------------------------------------+");
                        pui.showProduct();
                        pui.inputInfoUpdate();
                        break;
                    case "0":
                        System.out.println("Exit!!!");
                        w = false;
                        break;
                    case "3":
                        mt.cls();
                        System.out.println("+======================================+");
                        System.out.println("|            PF10 - Group 7            |");
                        System.out.println("|      Welcome to Clothings Store      |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|             View Product             |");
                        System.out.println("+--------------------------------------+");
                        pui.showProduct();
                        while (true) {
                            System.out.print("Do you want search product?(y/n): ");
                            String ch = sc.nextLine();
                            if (ch.equalsIgnoreCase("y")) {
                                pui.SearchProByName();
                                break;
                            } else if (ch.equalsIgnoreCase("n")) {
                                break;
                            } else {
                                System.out.println("Only y or n,re-enter!");
                            }
                        }
                        System.out.print("Enter any key to continue...");
                        sc.nextLine();
                        break;
                    default:
                        System.out.print("You entered incorrectly, please re-enter!\nPress anykey...");
                        sc.nextLine();
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}