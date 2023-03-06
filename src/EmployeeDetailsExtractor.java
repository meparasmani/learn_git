import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeDetailsExtractor {
    public static void main(String[] args) {
    	    	
        String inputFile = "employees.csv";
        String managersFile = "managers.csv";
        String singleNameFile = "single_name_employees.csv";
        String line = "";
        FileWriter managersWriter; 
        FileWriter singleNameWriter; 
        Scanner sc;
        
		try {
			File f = new File(inputFile);
			sc = new Scanner(f);
			managersWriter = new FileWriter(managersFile);
		    singleNameWriter = new FileWriter(singleNameFile);
		    
		    while(sc.hasNextLine()) {
	        	line = sc.nextLine();
	        	String st[] = line.split(",");
	        	
	        	if(st[1].equals("Manager") && st[2].equals("R&D")) {
	        		managersWriter.write(line+"\n");
	        	}
	        	
	        	if(!st[0].contains(" ")) {
	        		singleNameWriter.write(line+"\n");
	        	}
	        }
		    sc.close();
		    managersWriter.close();
		    singleNameWriter.close();
		    System.out.println("Files have been created");
		} 
		catch (IOException e) {
			System.out.println("Error has occured...");
			e.printStackTrace();
		}         
    }
}

