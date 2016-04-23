package java112.labs1;

import java.io.*;

public class LabSix {

    public static void main(String[] args) {
    	
    	LabSix parameters = new LabSix();
    	
    	if (args.length != 2) {
    	
    		System.out.println("Please enter two arguments on the command line, "
                + "an input file name and an output file name");
    	} else {
    	
    		parameters.run(args[0], args[1]);
    		
    	}
	
    }
    
    public void run(String readPath,String writePath) {
    	
    	String line = null;
        String output = "";
        BufferedReader in = null;
 
        try {
           
            in = new BufferedReader(new FileReader(readPath));
 
           
            while ((line = in.readLine()) != null) {
                output += line + "\n";
            }
 
                try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(writePath)))){
                     printWriter.print(output);
                     if (line == null) {
                        printWriter.close();
                     }
 
                } catch (IOException ioException) {
                    System.out.println("There was problem writing the file");
                    ioException.printStackTrace();
                } catch (Exception exception) {
                    System.out.println("There was an exception");
                    exception.printStackTrace();
                }
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("There was a problem opening the file");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("There was a problem reading the file");
            ioEx.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioEx2) {
                System.out.println("There was a problem closing the file");
                ioEx2.printStackTrace();
            }
        }
 
 
    }
    
}
    	
    	
    	/**
    	
        String line = null;
        String output = "";
        BufferedReader in = null;
        PrintWriter out = null;
        
        
        try {
			in = new BufferedReader(new FileReader(inputFile));
			while (in.ready()) {
			line = in.readLine();
			System.out.println(line);
			}
	
        try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
			out.println(output);
            out.close();
			
		} catch (IOException ex) {
			System.out.println("There was a writing the file");
			ex.printStackTrace();
		} 

      }
      
      */
     
