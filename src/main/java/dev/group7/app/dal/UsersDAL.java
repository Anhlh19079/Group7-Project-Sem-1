package dev.group7.app.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.group7.app.persistance.Users;

public class UsersDAL {

    public static int idus = -1;

    public List<Users> getAllUser() {
        String sql = "select * from users";
        List<Users> lus = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lus.add(getUsers(rs));
            }
        } catch (SQLException ex) {
            lus = null;
            System.out.println(ex.toString());
        }
        return lus;
    }

    public static Users getUsers(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setUserId(rs.getInt("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setUserPass(rs.getString("user_pass"));
        user.setUserphone(rs.getString("user_phone"));
        user.setUseremail(rs.getString("user_email"));
        user.setRole(rs.getString("user_role"));
        user.setUserstatus(rs.getString("user_status"));

        return user;
    }

    public String checklogin(String username, String userpass) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from users where user_name ='" + username + "'";
        String role = null;
        String status = null;
        idus = -1;
        try (Connection con = DBUtil.getConnection();) {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                if (username.equals(rs.getString("user_name"))) {
                    idus = rs.getInt("user_id");

                } else {
                    System.out.println("Wrong Account!!!");
                    idus = -1;
                    break;
                }
            }
            if (idus == -1) {
                return null;
            } else {
                rs = stm.executeQuery("SELECT * FROM users where user_id ='" + idus + "' ");
                while (rs.next()) {
                    if (userpass.equals(rs.getString("user_pass"))) {
                        rs = stm.executeQuery("SELECT * FROM users where user_id = '" + idus + "'");
                        while (rs.next()) {
                            System.out.println("Valid Acc!");
                            idus = rs.getInt("user_id");
                            role = rs.getString("user_role");
                            status = rs.getString("user_status");
                        }
                    } else {
                        System.out.println("Wrong Account!!!");
                    }
                }
            }
            if (status.trim().equals("inactive")) {
                role = "";
                System.out.println("Account your inactive!\nEnter any key to continue...");
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return role;
    }

    // ---------------------------------------------------------------//

}