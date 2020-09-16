package dev.group7.app.bl;

import java.sql.SQLException;
import java.util.List;
import dev.group7.app.dal.ProductDAL;
import dev.group7.app.persistance.Product;

public class ProductBL {
    public static ProductDAL productDAL = new ProductDAL();

    public List<Product> getAllPro() {
        return productDAL.getAll();
    }

    // public boolean addProduct(Product product) {
    //     return productDAL.insertProduct(product) > 0;
    // }

    public int UpdatePro(Product product) throws SQLException {
        return productDAL.update(product);
    }

    public List<Product> getByName(String name) {
        return productDAL.getProductByName(name);
    }


    //==
    public boolean addProduct(Product product) {
        return productDAL.insertProduct(product);
    }
    public boolean insertpsize(int id) {
        return productDAL.insert_product_size(id);
    }

    public boolean insertsize(String size) {
        return productDAL.insert_size_name(size);
    }

    public boolean insertpcolor(int id) {
        return productDAL.insert_product_colors(id);
    }

    public boolean insertcolor(String color) {
        return productDAL.insert_color_name(color);
    }

    public boolean insertpimage(int id) {
        return productDAL.insert_product_images(id);
    }

    public boolean insertimage(String url) {
        return productDAL.insert_ima_url(url);
    }

    public int reproductid(){
        return productDAL.reProId();
    }
    public List<Product> getcategories(){
        return productDAL.getcat_id();
    }
}