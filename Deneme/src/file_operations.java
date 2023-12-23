import java.io.*;
import java.util.Scanner;

public class file_operations  {
    private String val;

    file_operations() {
        this.val = val;
    }

    public void fileCreate() throws IOException {
        File passwordFile = new File("Sifreler.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }
        
    }
    public void fileWrite(String writing) throws IOException {
        File passwordFile = new File("Sifreler.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }

        FileWriter fWrite = new FileWriter(passwordFile, true);
        BufferedWriter passwordWrite = new BufferedWriter(fWrite);
        passwordWrite.write(writing);
        passwordWrite.newLine(); 
        passwordWrite.close();
    }
    public void fileWriteUsernames(String writing) throws IOException {
        File passwordFile = new File("Usernames.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }

        FileWriter fWrite = new FileWriter(passwordFile, true);
        BufferedWriter passwordWrite = new BufferedWriter(fWrite);
        passwordWrite.write(writing);
        passwordWrite.newLine(); 
        passwordWrite.close();
    }
    
    public void fileWriteForManager(String writing) throws IOException {
        File passwordFile = new File("SifrelerManagers.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }

        FileWriter fWrite = new FileWriter(passwordFile, true);
        BufferedWriter passwordWrite = new BufferedWriter(fWrite);
        passwordWrite.write(writing);
        passwordWrite.newLine();                 
        passwordWrite.close();
    }
    public boolean fileReadForManagers(String enteredUsername) throws IOException {
        File fileForRead = new File("SifrelerManagers.txt");
        FileReader fReader = new FileReader(fileForRead);
        String line;
        BufferedReader readFile = new BufferedReader(fReader);

        while ((line = readFile.readLine()) != null) {
            if (line.equals(enteredUsername)) {
                return true; 
            }
        }
        return false;
        
    }
    public boolean fileRead(String enteredUsername) throws IOException {
        File fileForRead = new File("Sifreler.txt");
        FileReader fReader = new FileReader(fileForRead);
        String line;
        BufferedReader readFile = new BufferedReader(fReader);

        while ((line = readFile.readLine()) != null) {
            if (line.equals(enteredUsername)) {
                return true; 
            }
        }     
        return false;
    }
}

