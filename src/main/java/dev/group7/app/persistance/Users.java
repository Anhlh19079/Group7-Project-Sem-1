package dev.group7.app.persistance;

public class Users {
    public int User_id;
    public String Username;
    public String Userpass;
    public String Userphone;
    public String Useremail;
    public String Role;
    public String Userstatus;

    public Users() {
    };

    public Users(int User_id, String Username, String Userpass,String Userphone,String Useremail, String Role,String Userstatus) {
        this.User_id = User_id;
        this.Username = Username;
        this.Userpass = Userpass;
        this.Userphone=Userphone;
        this.Useremail=Useremail;
        this.Role = Role;
        this.Userstatus = Userstatus;
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

    public void setUserphone(String Userphone) {
        this.Userphone = Userphone;
    }

    public String getUserphone() {
        return Userphone;
    }

    public void setUseremail(String Useremail) {
        this.Useremail = Useremail;
    }

    public String getUseremail() {
        return Useremail;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getRole() {
        return Role;
    }

    public void setUserstatus(String Userstatus) {
        this.Userstatus = Userstatus;
    }

    public String getUserstatus() {
        return Userstatus;
    }
}