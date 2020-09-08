package dev.group7.app.bl;

import java.sql.SQLException;
import java.util.List;
import dev.group7.app.dal.UsersDAL;
import dev.group7.app.persistance.Users;

public class UsersBL {

    public static UsersDAL udal = new UsersDAL();

    public List<Users> getAllus() {
        return udal.getAllUser();
    }

    public String checkUserLogin(String username, String userpass) throws SQLException {
        return udal.checklogin(username, userpass);
    }

}
