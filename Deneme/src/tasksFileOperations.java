import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tasksFileOperations extends file_operations {
	tasksFileOperations(){
		super();
		
	}
	public void fileWriteCompletedTasks(String writing) throws IOException{
		File passwordFile = new File("CompletedTasks.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }

        FileWriter fWrite = new FileWriter(passwordFile, true);
        BufferedWriter passwordWrite = new BufferedWriter(fWrite);
        passwordWrite.write(writing);
        passwordWrite.newLine(); 
        passwordWrite.close();
	}
	public void fileDeleteCompletedTasks(int index, String fileName) throws IOException {
        File taskFile = new File(fileName);

        if (!taskFile.exists()) {
            taskFile.createNewFile();
        }

        File tempFile = new File("TempTasks.txt");
        BufferedReader taskReader = new BufferedReader(new FileReader(taskFile));
        BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        int currentIndex = 0;

        while ((currentLine = taskReader.readLine()) != null) {
            currentIndex++;
            if (currentIndex == index) {
            	continue;
                
            }
            tempWriter.write(currentLine);
            tempWriter.newLine();
        }

        taskReader.close();
        tempWriter.close();
        
        
        if (!taskFile.delete()) {
            return;
        }

        if (!tempFile.renameTo(taskFile)) {
        }
    }
	
	public static void fileCreateSpeciesEmployees(String employeesName) throws IOException {
        String fileName = employeesName + "_gorevler.txt";
        File employeesTasks = new File(fileName);
        if (!employeesTasks.exists()) {
        	employeesTasks.createNewFile();
        }
        
    }
	public static void fileWriteSpeciesEmployees(String task, String fileName) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); 
	    try  {
	        writer.write(task);
	        writer.newLine(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        writer.close();
	    }
	}
	//@overloading
	public static void fileWriteSpeciesEmployees(String task, BufferedWriter writer) throws IOException {
	    try {
	        writer.write(task);
	        writer.newLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public void fileWrite(String writing) throws IOException{
		File passwordFile = new File("Tasks.txt");

        if (!passwordFile.exists()) {
            passwordFile.createNewFile();
        }

        FileWriter fWrite = new FileWriter(passwordFile, true);
        BufferedWriter passwordWrite = new BufferedWriter(fWrite);
        passwordWrite.write(writing);
        passwordWrite.newLine(); 
        passwordWrite.close();
		
	}

}


