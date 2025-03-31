package ManageUser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StorageLog extends StorageUserPassPo{

    /*private static ArrayList<LoginLogout> Log = new ArrayList<>(
           Arrays.asList(new LoginLogout("27/03/2025","GameBooBee","19:00"),
                   new LoginLogout("27/03/2025","GameBooBee","20:00","21:00")));*/
    
    private static ArrayList<LoginLogout> Log = new ArrayList<>();
    
    private static final String FILE_NAME = "Log.txt";

    public static void addLog(LoginLogout item){
        Log.add(item);
    }

    public static int getSizeOfLog() {
        return Log.size();
    }

    public static ArrayList<LoginLogout> getAllLog() {
        return Log;
    }

    public static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (LoginLogout Loginout : Log) {
                writer.write(Loginout.toString());
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
                    String date = parts[0];
                    String name = parts[1];
                    String login = parts[2];
                    Log.add(new LoginLogout(date, name, login));
                } else {
                    String date = parts[0];
                    String name = parts[1];
                    String login = parts[2];
                    String logout = parts[3];
                    Log.add(new LoginLogout(date, name, login ,logout));
                }
                line = reader.readLine();
            }

            System.out.println("Data loaded successfully from " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public static void clearFileLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isLoginExists(String Login) {
        for (LoginLogout LoginLogout : Log) {
            if (LoginLogout.getLogin().equals(Login)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void clearStorage() {
        Log.clear();
    }

    public static void main(String[] args) {
        clearFileLog();
    }
    
}
