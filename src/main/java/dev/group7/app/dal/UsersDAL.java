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
    static Scanner sc = new Scanner(System.in);

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
        user.setUserId(rs.getInt("User_ID"));
        user.setUserName(rs.getString("User_Name"));
        user.setUserPass(rs.getString("User_Pass"));
        user.setRole(rs.getString("User_Role"));
        return user;
    }

    public String checklogin(String username, String userpass) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from users where User_Name ='" + username + "'";
        String role = null;
        idus = -1;
        try (Connection con = DBUtil.getConnection();) {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                if (username.equals(rs.getString("User_Name"))) {
                    idus = rs.getInt("User_ID");

                } else {
                    System.out.println("Wrong Account!!!");
                    idus = -1;
                    break;
                }
            }
            if (idus == -1) {
                return null;
            } else {
                rs = stm.executeQuery("SELECT * FROM users where User_ID ='" + idus + "' ");
                while (rs.next()) {
                    if (userpass.equals(rs.getString("User_Pass"))) {
                        rs = stm.executeQuery("SELECT * FROM users where User_ID = '" + idus + "'");
                        while (rs.next()) {
                            // System.out.println("Valid Acc!");
                            idus = rs.getInt("User_ID");
                            role = rs.getString("User_Role");
                        }
                    } else {
                        System.out.println("Wrong Account!!!");
                    }
                }
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