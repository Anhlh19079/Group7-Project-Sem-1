package dev.group7.app.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/ClothingsDB";
    private static String user = "root";
    private static String password = "01659663205a";

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static boolean executeStatement(final String sql) {
        boolean exeResult = false;
        try (Statement stm = DBUtil.getConnection().createStatement();) {
            exeResult = stm.execute(sql);
        } catch (final SQLException e) {
            exeResult = false;
        }
        return exeResult;
    }
}