package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This is the main controlling class for the project. The class is called AnalyzerFile 
 * The class will receive an input file path from the main method of the AnalyzerDriver 
 * class. It will also have instance variables for each Analyzer class. It then 
 * parses through the text file given in the input file path and creates two seperate 
 * reports. The first report states the total number of tokens in the file and the second 
 * states the total number of unique tokens in the file. Lastly the class outputs 
 * these reports to the output folder.
 *
 * @author Sean Fiscus
 *
 */

/** 
 * Things to change for this class for Project 2
 * Change the processProperties method name to createAnalyzers
 */

public class AnalyzeFile {

    // Create a constant for the valid number of command-line arguments	
    private static final int VALID_ARGUMENTS_COUNT = 2;

    // Create an instance variable that holds the path to the input file
    private String inputFilePath;

    // Create a properties instance variable with an id of properties
    private Properties properties;

    // Create an ArrayList with an id of analyzers
    private ArrayList<Analyzer> analyzers;

    /**
    // Create an instance variable for the Analyzer class called summaryReport
    private SummaryReport summaryReport;
    
     // Create an instance variable for the Analyzer class called uniqueTokenAnalyzer
    private UniqueTokenAnalyzer uniqueTokenAnalyzer;
     */

    /**
     * This method is the main calling method for the class. It will call the
     * testArguments(), processProperties(), openInputFile(), and writeAllOutputFiles() methods.
     *
     * @param arguments The input file path provided that will be entered by the user.
     */
     
    public void runAnalysis(String[] arguments) {
        
        // Call testArguments()
        testArguments(arguments);

        // Call createAnalyzers()
        createAnalyzers();
        
        // Call openInputFile()
        openInputFile();
        
        // Call writeAllOutputFile()
        writeAllOutputFiles();
    }

    /**
     * This method will test if the correct number of arguements have been entered 
     * by the user when running the applilcation. If the correct number of arguments
     * have been entered then the program will continue to run. If the correct 
     * number of arguments have not been entered a error message appears.
     *
     * @param arguments The input file path provided that will be entered by the user.
     */    

    private void testArguments(String[] arguments) {

        // Create an if statment to test if the user entered the appropriate number of arguments
        if (arguments.length != VALID_ARGUMENTS_COUNT) {
            System.out.println("Please enter file path of analysis file " +
                    "along with the properties configuration file path");
            return;
        }
        
        // Set the inputFilePath instance variable equal to first index spot of the arguments array
        inputFilePath = arguments[0];

        // Set the propertiesFilePath instance variable equal to the second index spot of the arguments array
        String propertiesFilePath = arguments[1];

        // Call getProperties()
        getProperties(propertiesFilePath);

    }

    /**
     * Create a method with an id of processProperties. It will load the Properties object and to pass it to the analyzers.
     * Instantiate each Analyzer and load the Properties object.
     */
    
    // Change the method name from processProperties to createAnalyzers 
    private void createAnalyzers() {

        // Instantiate a new ArrayList object with an id of analyzers
        analyzers = new ArrayList<Analyzer>();

        // Use the new object to instantiate the Analyzers from each class.
        analyzers.add(new SummaryReport(properties));
        analyzers.add(new UniqueTokenAnalyzer(properties));
        analyzers.add(new BigWordAnalyzer(properties));
        analyzers.add(new TokenCountAnalyzer(properties));
    }

    /**
     * Creat a method with an id of getProperties. This method will have a String parameter that will
     * represent the properties file path. It will load the properties as well as include exception
     * handling. Going to use getResourceAsStream, it will returns an input stream for reading the
     * specified resource, but requires a parameter.
     * @param propertiesFilePath
     */
    private void getProperties(String propertiesFilePath) {

        // String filepath is "/analyzer.properties"

        // Instantitate a new Properties object with an id of properties
        properties = new Properties();

        /*
         * Use a try catch to load the properties object and include exception handling.
         * If there are problems loading the property file.
         */

        try {
            properties.load(
                    this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not found.");
            fileNotFound.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IO Error can't read the file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Opens the inputFile and includes exception handling to catch multiple errors
     * that have the potential to be thrown.
     */
     
    private void openInputFile() {

        BufferedReader input = null;
        
        try {
            input = new BufferedReader(new FileReader(inputFilePath));

            parseTokensFromInputFile(input);

        } catch (java.io.FileNotFoundException fnfe) {
            System.out.println("Failed to read input file");
            fnfe.printStackTrace();
        } catch (java.io.IOException ioEx) {
            System.out.println("There was a problem reading the file");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("General Error");
            exception.printStackTrace();
        } finally {

            try {
                if (input != null) {
                    input.close();
                }
            } catch (java.io.IOException ioe) {
                System.out.println("Failed to close input file");
                ioe.printStackTrace();
            }
        }
    }

    /**
     * This method will loop through all the lines of the input file and generate
     * individual tokens.
     *
     * @param input The variable created in the openInputFile class.
     * @throws IOException
     */
     
    private void parseTokensFromInputFile(BufferedReader input)
            throws IOException {

        // Create a variable called inputLine which will have a value of ""    	
        String inputLine = "";
        
        // Create an array called tokenArray which will hold all the tokens
        String[] tokenArray = null;
        
        // Create a variable called token which will have a value of ""
        String token = "";

        /**
         * Create a while loop that will run when the Stream is ready to read.
         */
        while (input.ready()) {

            inputLine = input.readLine();
            tokenArray = inputLine.split("\\W");

            /** Call the sendTokensToAnalyzers method with the tokenArray as 
             * the parameter.
             */
            sendTokensToAnalyzers(tokenArray);
        }
    }

    /**
     * Create a method called sendTokensToAnalyzer with the String[] tokenArray
     * as the parameter. The method will contain a for statement for each generated
     * token that is passed to all Analyzer instances via the processToken method.
     *
     * @param tokenArray The variable created in the parseTokensFromInputFile class.
     */
     
    private void sendTokensToAnalyzers(String[] tokenArray) {

        // Use enhanced for loop instead of using for (int i = 0; i < tokenArray.length; i++) {
        for (String token: tokenArray) {

            if (token.length() > 0) {
                analyzeTokens(token);
            }
        }
    }

    /**
     *  Method loops through all of the Analyzers in the analyzers ArrayList and
     *  calls the processToken method for each analyzer to process tokens.
     *
     *@param  token  token
     */
    private void analyzeTokens(String token) {

        // Use enhanced for loop to take place of for (int i = 0; i < 2; i++) {
        for (Analyzer newAnalyzer: analyzers) {

            newAnalyzer.processToken(token);
        }
    }

    /**
     * Create a method called writeAllOutputFiles. This method will call the writeOutputFile
     * for each Analyzer class. Which will states where the two reports will be placed.
     */
     
    private void writeAllOutputFiles() {

        // Use enhanced for loop to take place of for (int i = 0; i < 2; i++) {
        for (Analyzer newAnalyzer: analyzers) {
            newAnalyzer.writeOutputFile(inputFilePath);
        }

        System.out.println("The files you requested have been generated.");
    }

        /**
         * summaryReport.writeOutputFile(inputFilePath,
         *      "output/summary_report.txt");
         * uniqueTokenAnalyzer.writeOutputFile(inputFilePath,
         *      "output/unique_tokens.txt");
         */
}
