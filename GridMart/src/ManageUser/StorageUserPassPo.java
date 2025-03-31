package ManageUser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class StorageUserPassPo {

    private static ArrayList<UserPassPo> UserPassPo = new ArrayList<>(
           Arrays.asList(new UserPassPo("GameBooBee","1234","Manager")));

    private static final String FILE_NAME = "UserPassPo.txt";

    public static void addUserPassPo(UserPassPo item){
        UserPassPo.add(item);
    }

    public static int getSizeOfUserPassPo() {
        return UserPassPo.size();
    }

    public static ArrayList<UserPassPo> getAllUserPass() {
        return UserPassPo;
    }

    public static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (UserPassPo UserPass : UserPassPo) {
                writer.write(UserPass.toString());
                writer.newLine();
            }
            System.out.println("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            line = reader.readLine();
            while (line!= null) {
                String[] parts = line.split(" - ");
                if (parts.length == 3) {
                    String Username = parts[0];
                    String Password = parts[1];
                    String Position = parts[2];
                    if (!isUserExists(Username)) {
                        UserPassPo.add(new UserPassPo(Username, Password, Position));
                    }
                }
                line = reader.readLine();
            }

            System.out.println("Data loaded successfully from " + FILE_NAME);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearFileUserPassPo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUserExists(String name) {
        for (UserPassPo UserPass : UserPassPo) {
            if (UserPass.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void clearStorage() {
        UserPassPo.clear();
    }
    
    public static void removeUsername(String name) {
    Iterator <UserPassPo> iterator = UserPassPo.iterator();
    
    while (iterator.hasNext()) {
        UserPassPo upp = iterator.next();
        
        if (upp.getUsername().equals(name)) {
            iterator.remove();
            System.out.println("Removed: " + upp);
            return;
        }
    }
        System.out.println("Drink with name '" + name + "' not found.");
    }
    
    /*public static void main(String[] args) {
        clearFileUserPassPo();
    }*/
    
    public static void EditUsername(String username,String newpass,String newposition){
        for (UserPassPo UserPass : UserPassPo) {
            if (UserPass.getUsername().equals(username)){
                    UserPass.setPassword(newpass);
                    UserPass.setPosition(newposition);
            }
        }
    }
    
}


    
    

