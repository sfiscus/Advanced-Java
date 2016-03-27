package java112.labs1;

import java.util.*;

import java.io.*;

public class LabEight {
	
	TreeSet<String> myList;
	
	public static void main(String[] args) {
	
		LabEight checker = new LabEight();
		
		if (args.length != 1) {
			System.out.println("Please enter one argument on the command line, an output file name");
		} else {
			checker.run(args[0]);
		}
	
	}
	
	public void run(String outputPath) {
		
		myList = new TreeSet<String>();
		
		myList.add("one");
		myList.add("one");
		myList.add("five");
		myList.add("two");
		myList.add("four");
		myList.add("two");
		myList.add("three");
		myList.add("three");
		myList.add("four");
		myList.add("three");
		
		writeListToOutputFile(outputPath);
				
	}
	
	public void writeListToOutputFile(String outputPath) {
		
			
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputPath)))) {
			
			for (String listItem : myList) {
				out.println(listItem);
			}			
		 
			// out.close();
        } catch (IOException ioException) {
        		System.out.println("There was a problem writing the file:");
        		ioException.printStackTrace();
        } catch (Exception exception) {
        		System.out.println("There was a problem other than an IoException:");
        		exception.printStackTrace();
        }
        	
	}

}
