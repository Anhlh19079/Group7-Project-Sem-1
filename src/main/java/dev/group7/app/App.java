package dev.group7.app;

import java.sql.Connection;
import java.sql.SQLException;
import dev.group7.app.dal.DBUtil;
import dev.group7.app.ui.Menu;

public class App {
    static Menu menu = new Menu();
    public static void main(String[] args) throws Exception {
        try (Connection connection = DBUtil.getConnection();) {
            System.out.println("Connected to MySql Server.\n");
            menu.MainMenu();      
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
    }
}
