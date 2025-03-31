package ManageUser;

import java.io.Serializable;

public class UserPassPo extends User implements Serializable{
    

    public UserPassPo(){
        
    }

    public UserPassPo(String username, String password, String position) {
        this.username = username;
        this.password = password;
        this.position = position;
        
    }

    @Override
    public String toString() {
        return username + " - " + password + " - " + position;
    }

}
