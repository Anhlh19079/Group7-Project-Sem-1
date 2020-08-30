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

    public boolean addProduct(Product product) {
        return productDAL.insertProduct(product) > 0;
    }

    public int UpdatePro(Product product) throws SQLException {
        return productDAL.update(product);
    }

    public List<Product> getByName(String name) {
        return productDAL.getProductByName(name);
    }

}