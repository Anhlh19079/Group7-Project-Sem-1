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

    public List<Product> getProductByName(String name) {
        List<Product> litspro = new ArrayList<>();
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement pstm = con
                    .prepareStatement("select * from Products where Products.Pro_name like ('%" + name + "%');");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                litspro.add(getProduct(rs));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return litspro;
    }
    

    public int update(Product product) throws SQLException {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "update Products SET cat_id =?,Pro_name =?,pro_pack=?, Unit_price = ?, Pro_amount = ?, Pro_description = ?, Pro_status = ? where Pro_id = ?;");) {
            pstm.setInt(1, product.getCategory_ID());
            pstm.setString(2, product.getPro_name());
            pstm.setString(3, product.getpro_pack());
            pstm.setDouble(4, product.getUnitPrice());
            pstm.setInt(5, product.getAmount());  
            pstm.setString(6, product.getDescription());
            pstm.setString(7, product.getPro_status());
            pstm.setInt(8, product.getPro_id());
            int rs = pstm.executeUpdate();
            if (rs == 1) {
                // System.out.println("Update Successful!");
            } else {
                System.out.println("Update fail!");
            }
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("loi update!");
            return 0;
        }
    }

    // ===============================================================================
    public Product getProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setPro_id(rs.getInt("pro_id"));
        product.setCategory_ID(rs.getInt("cat_id"));
        product.setPro_name(rs.getString("pro_name"));
        product.setpro_pack(rs.getString("pro_pack"));
        product.setUnitPrice(rs.getDouble("unit_price"));
        product.setAmount(rs.getInt("pro_amount"));
        product.setDescription(rs.getString("pro_description"));
        product.setPro_status(rs.getString("pro_status"));
        return product;
    }

    public List<Product> getcat_id() {
        List<Product> lbid = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from categories;")) {
            while (rs.next()) {
                lbid.add(getidcategories(rs));
            }
        } catch (SQLException ex) {
            lbid = null;
            System.out.println(ex.toString());
        }
        return lbid;
    }

    public Product getidcategories(ResultSet rs) throws SQLException {
        Product catid = new Product();
        catid.setCategory_ID(rs.getInt("cat_id"));
        return catid;
    }

    public int reProId() {
        int proid = 0;
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select pro_id from products order by pro_id desc limit 1;");) {
            if (rs.next()) {
                proid = rs.getInt("pro_id");
            } else {
                System.out.println("not set id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proid;
    }

    public boolean insertProduct(Product product) {
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement(
                        "insert into Products(cat_id,pro_name,pro_pack,unit_price,pro_amount,pro_description,pro_status) values (?,?,?,?,?,?,?)");) {
            pstm.setInt(1, product.getCategory_ID());
            pstm.setString(2, product.getPro_name());
            pstm.setString(3, product.getpro_pack());
            pstm.setDouble(4, product.getUnitPrice());
            pstm.setInt(5, product.getAmount());
            pstm.setString(6, product.getDescription());
            pstm.setString(7, product.getPro_status());
            pstm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("insert fail!");
            System.out.println(ex.toString());
            return false;

        }
    }

    // =========sizes and product_sizes
    public boolean insert_product_size(int idprod) {
        String sql = "insert into product_sizes (pro_id,size_id) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reProId());
            call.setInt(2, reproduct_sizes());

            call.executeUpdate();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }

    public boolean insert_size_name(String name) {
        String sql = "insert into sizes (size_id,size_name) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reproduct_sizes() + 1);
            call.setString(2, name);
            return call.execute();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // ======================
    public boolean insert_product_colors(int idprod) {
        String sql = "insert into product_colors (pro_id,col_id) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reProId());
            call.setInt(2, reproduct_colors());
            return call.execute();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean insert_color_name(String name) {
        String sql = "insert into colors (col_id,col_name) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reproduct_colors() + 1);
            call.setString(2, name);
            return call.execute();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // ======================
    public boolean insert_product_images(int idprod) {
        String sql = "insert into product_images (pro_id,ima_id) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reProId());
            call.setInt(2, reproduct_images());
            return call.execute();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean insert_ima_url(String url) {
        String sql = "insert into images (ima_id,ima_url) values (?,?)";
        try (PreparedStatement call = DBUtil.getConnection().prepareStatement(sql)) {
            call.setInt(1, reproduct_images() + 1);
            call.setString(2, url);
            return call.execute();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    // ================================
    // ====================return id size color image
    public int reproduct_sizes() {
        int prosize_id = 0;
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select size_id from sizes order by size_id desc limit 1;");) {
            if (rs.next()) {
                prosize_id = rs.getInt("size_id");
            } else {
                System.out.println("not set id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prosize_id;
    }

    // ------------------------------------
    public int reproduct_colors() {
        int procol_id = 0;
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select col_id from colors order by col_id desc limit 1;");) {
            if (rs.next()) {
                procol_id = rs.getInt("col_id");
            } else {
                System.out.println("not set id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return procol_id;
    }

    // -------------------------
    public int reproduct_images() {
        int proima_id = 0;
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select ima_id from images order by ima_id desc limit 1;");) {
            if (rs.next()) {
                proima_id = rs.getInt("ima_id");
            } else {
                System.out.println("not set id!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proima_id;
    }
}
