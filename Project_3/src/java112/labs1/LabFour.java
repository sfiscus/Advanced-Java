package java112.labs1;

import java.io.*;

public class LabFour {

    public static void main(String[] args) {
        LabFour validate = new LabFour();
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            validate.run(args[0]);
        }
    }

    public void run (String argument) {
        read(argument);
    }
    
    public void read (String fileName) {
        String line = null;
        BufferedReader in = null;

        try {
			in = new BufferedReader(new FileReader(fileName));
			while (in.ready()) {
			line = in.readLine();
			System.out.println(line);
			}
		} catch (IOException ex) {
			System.out.println("There was a problem reading the file");
			ex.printStackTrace();
		} 
      
    }    
}
