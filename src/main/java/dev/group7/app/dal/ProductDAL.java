package dev.group7.app.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.group7.app.persistance.Product;

public class ProductDAL {

    public List<Product> getAll() {
        String sql = "select * from products";
        List<Product> lst = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getProduct(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }
    

    public int insertProduct(Product product) {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "insert into Products(Pro_name, Unit_price, Pro_amount, Pro_status, Pro_description) values (?,?,?,?,?)");) {
            pstm.setString(1, product.getPro_name());
            pstm.setDouble(2, product.getUnitPrice());
            pstm.setInt(3, product.getAmount());
            pstm.setString(4, product.getPro_status());
            pstm.setString(5, product.getDescription());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("insert fail!");
            System.out.println(ex.toString());
            return 0;

        }
    }

    public Product getProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setPro_id(rs.getInt("Pro_id"));
        product.setPro_name(rs.getString("Pro_name"));
        product.setUnitPrice(rs.getDouble("Unit_price"));
        product.setAmount(rs.getInt("Pro_amount"));
        product.setPro_status(rs.getString("Pro_status"));
        product.setDescription(rs.getString("Pro_description"));

        return product;
    }

    public int update(Product product) throws SQLException {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "update Products SET Pro_name =?, Unit_price = ?, Pro_amount = ?, Pro_status = ?, Pro_description = ? where Pro_id = ?;");) {

            pstm.setString(1, product.getPro_name());
            pstm.setDouble(2, product.getUnitPrice());
            pstm.setInt(3, product.getAmount());
            pstm.setString(4, product.getPro_status());
            pstm.setString(5, product.getDescription());
            pstm.setInt(6, product.getPro_id());

           int rs = pstm.executeUpdate();
           if (rs==1) {
            //    System.out.println("Update Successful!");
           }else{
               System.out.println("Update fail!");
           }
           return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;
            
        }
    }



    
}
        
        