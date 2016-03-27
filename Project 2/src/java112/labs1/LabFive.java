package java112.labs1;

import java.io.*;

public class LabFive {

    public static void main(String[] args) {
        LabFive validate = new LabFive();

        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, "
                + "a file name and a message");
        } else {
            validate.run(args[0],args[1]);
        }

    }

    public void run(String fileName,String message) {
  
        /**
        	try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
        		writer.println(message);
        	} catch (FileNotFoundException fileNotFoundException) {
        		System.out.println("There was a problem opening the file:");
        		fileNotFoundException.printStackTrace();
        	} catch (IOException ioException) {
        		System.out.println("There was a problem writing the file:");
        		ioException.printStackTrace();
        	} catch (Exception exception) {
        		System.out.println("There was a problem other than an IoException:");
        		exception.printStackTrace();
        	}
        */
        
        PrintWriter out = null;
        
        try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			out.println(message);
            out.close();
			
		} catch (IOException ex) {
			System.out.println("There was a problem reading the file");
			ex.printStackTrace();
		} 
      
    }    
   
}
