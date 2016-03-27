package java112.analyzer;

import java.util.*;
import java.io.*;
import java.io.File;

/**
 * This is one of the Analyzer classes which is called SummaryReport. It will implement 
 * the Analyzer interface.
 *
 * @author Sean Fiscus
 */

public class SummaryReport implements Analyzer {

    // Create an int instance variable with an id of totalTokensCount
    private int totalTokensCount;

    // Create a properties instance variable with an id of properties
    private Properties properties;

    // Create an empty Constructor without parameters
    public SummaryReport() {

    }

    /** Create a Constructor with one parameter that is a Properties object. Then assign the
     *  parameter reference to the Properties instance variable
     */
    public SummaryReport(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns totalTokensCount instance variable.
     *
     * @return The current count of total tokens from the text file.
     */
     
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     * Increments the totalTokensCount instance variable.
     *
     * @param token A single token from the input file.
     */
     
    public void processToken(String token) {
        totalTokensCount++;
    }

    /**
     * Uses PrintWriter to output the summary report. Calls outputSummaryReport
     * method for specific format. Included in the method is exception handling to
     * catch multiple error that have the potential to be thrown.
     *
     * @param inputFilePath The input file path originally provided by the user.
     */
     
    public void writeOutputFile(String inputFilePath) {

        PrintWriter out = null;

        String outputFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.summary");

        try {
            out = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFilePath)));

            outputSummaryReport(inputFilePath, out);

        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception exception) {

                exception.printStackTrace();
            }
        }
    }

    /**
     * This method will print everything that should show up in the summary report.
     *
     * @param out The PrintWriter instantiated in writeOutputFile.
     * @param inputFilePath The input file path originally provided by the user.
     */
     
    private void outputSummaryReport(String inputFilePath, PrintWriter out) {

        Date date = new Date();

        File path = new File(inputFilePath);

        out.println("Application: " + properties.getProperty("application.name"));
        out.println("Author: " + properties.getProperty("author"));
        out.println("Email: " + properties.getProperty("author.email.address"));
        out.println("Input file: " + path.getAbsolutePath());
        out.println("Analyzed on: " + date);
        out.println("Total Token Count: " + totalTokensCount);

        /**
         * out.println("Application: TokenParser");
         * out.println("Author: Sean Fiscus, M 5:30pm");
         * out.println("Email: Sfiscus@madisoncollege.edu");
         * out.println("Input file: " + path.getAbsolutePath());
         * out.println("Analyzed on: " + date);
         * out.println("Total token count: " + totalTokensCount);

         * System.out.println("Summary Report output to " + outputFilePath + ".");
         */
    }
}
