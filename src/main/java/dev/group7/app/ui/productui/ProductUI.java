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
            System.out.print("Nhap Pro_name:");
            String name = sc.nextLine();
            List<Product> listpro = pbl.getByName(name);
            System.out.println("\nItem List: ");
            System.out.println(
                    "+-------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-35s | \n", "ID", "Tên Sản Phẩm", "Đơn Giá",
                    "Số Lượng", "Status", "Mô Tả");
            System.out.println(
                    "+-------------------------------------------------------------------------------------------------------------------------------+");
            if (listpro.isEmpty())
                System.out.println("Danh sach Trong!");
            for (Product p : listpro) {
                System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-35s | \n", p.getPro_id(),
                        p.getPro_name(), p.getUnitPrice(), p.getAmount(), p.getPro_status(), p.getDescription());
            }
            System.out.println(
                    "+-------------------------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void showProduct() {
        List<Product> lst = pbl.getAllPro();
        System.out.println("\nItem List: ");
        System.out.println(
                "+-------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-35s | \n", "ID", "Tên Sản Phẩm", "Đơn Giá",
                "Số Lượng", "Status", "Mô Tả");
        System.out.println(
                "+-------------------------------------------------------------------------------------------------------------------------------+");
        if (lst.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Product p : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-35s | \n", p.getPro_id(), p.getPro_name(),
                    p.getUnitPrice(), p.getAmount(), p.getPro_status(), p.getDescription());
        }
        System.out.println(
                "+-------------------------------------------------------------------------------------------------------------------------------+");

    }

    public void insertPro() {
        while (true) {
            ProductBL proBL = new ProductBL();
            if (proBL.addProduct(inputProduct())) {
                System.out.println("Insert product complete!");
            } else {
                System.out.println("Insert product failed!");
            }
            System.out.println("Continue Insert?(y/n)");
            String choice1 = mt.yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static Product inputProduct() {
        Product product = new Product();

        System.out.print("Pro_name: ");
        product.setPro_name(sc.nextLine());

        System.out.print("Unit Price: ");
        Double gia = Double.parseDouble(sc.nextLine());
        product.setUnitPrice(gia);

        System.out.print("Amount: ");
        int sl = Integer.parseInt(sc.nextLine());
        product.setAmount(sl);

        System.out.print("Description: ");
        product.setDescription(sc.nextLine());

        System.out.print("Pro_status: ");
        product.setPro_status(sc.nextLine());
        return product;
    }

    public void inputInfoUpdate() {

        while (true) {

            Product product = new Product();
            List<Product> PR = new ArrayList<>();

            System.out.print("Nhap Product_id : ");
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

            System.out.println("ban co muon update san pham(y/n)?");
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
                System.out.println("Error occurred, cannot update!");
            }
            System.out.println("Do you want to continue to update the product?(y/n)");
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
                System.out.println("+--------------------------------------+");
                System.out.println("|             PF10 - Group 7           |");
                System.out.println("+--------------------------------------+");
                System.out.println("| 1.          Insert Product           |");
                System.out.println("| 2.          Update product           |");
                System.out.println("| 3.          ShowAllProduct           |");
                System.out.println("| 0.               Exit                |");
                System.out.println("+--------------------------------------+");
                System.out.print("Nhap lua chon: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        mt.cls();
                        pui.insertPro();
                        break;
                    case "2":
                        mt.cls();
                        pui.showProduct();
                        System.out.println("Updates!!!");
                        pui.inputInfoUpdate();
                        break;
                    case "0":
                        System.out.println("Exit!!!");
                        w = false;
                        break;
                    case "3":
                        mt.cls();
                        pui.showProduct();
                        System.out.println("Enter any key to continue :");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("You entered incorrectly, please re-enter!\nPress anykey...");
                        sc.nextLine();
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}