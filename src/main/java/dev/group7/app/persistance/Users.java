package dev.group7.app.persistance;

public class Users {
    public int User_id;
    public String Username;
    public String Userpass;
    public String Role;

    public Users() {
    };

    public Users(int User_id, String Username, String Userpass, String Role) {
        this.User_id = User_id;
        this.Username = Username;
        this.Userpass = Userpass;
        this.Role = Role;
    }

    public void setUserId(int User_id) {
        this.User_id = User_id;
    }

    public int getUserId() {
        return User_id;
    }

    public void setUserName(String Username) {
        this.Username = Username;
    }

    public String getUserName() {
        return Username;
    }

    public void setUserPass(String Userpass) {
        this.Userpass = Userpass;
    }

    public String getUserPass() {
        return Userpass;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getRole() {
        return Role;
    }
}