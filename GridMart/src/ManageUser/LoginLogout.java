package ManageUser;

import java.io.Serializable;

public class LoginLogout extends Log implements Serializable{
    

    public LoginLogout(){
        
    }

    public LoginLogout(String date, String name, String login) {
        this.date = date;
        this.name = name;
        this.login = login;
        this.logout = "";
        
    }
    
    public LoginLogout(String date, String name, String login, String logout) {
        this.date = date;
        this.name = name;
        this.login = login;
        this.logout = logout;
    }
    
    @Override
    public String toString() {
        return date + " - " + name + " - " + login + " - " + logout;
    }
    
}
