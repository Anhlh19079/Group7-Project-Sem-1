package dev.group7.app.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.group7.app.dal.ProductDAL;
import dev.group7.app.persistance.Product;
import dev.group7.app.ui.Method;

public class ProductBL {
    public static ProductDAL productDAL = new ProductDAL();
    public static Method mt = new Method();
    static Scanner sc = new Scanner(System.in);

    public List<Product> getAll() {
        return productDAL.getAll();
    }

    public boolean addProduct(Product product) {
        return productDAL.insertProduct(product) > 0;
    }

    public void showProduct() {
        ProductBL pbls = new ProductBL();
        List<Product> lst = pbls.getAll();
        System.out.println("\nItem List: ");
        System.out.println(
            "+------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-40s |\n", "ID", "Tên Sản Phẩm", "Đơn Giá",
                "Số Lượng", "Status", "Mô Tả");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");
        if (lst.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Product p : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-40s | \n", p.getPro_id(), p.getPro_name(),
                    p.getUnitPrice(), p.getAmount(), p.getPro_status(), p.getDescription());
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");

    }

    // static List<Product> PR = new ArrayList<>();
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
        // sc.close();
        return product;
    }

    public void inputInfoUpdate() {

        while (true) {

            Product product = new Product();
            ProductDAL PD = new ProductDAL();
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
                    PD.update(product);
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

}