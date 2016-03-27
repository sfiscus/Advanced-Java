package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * This is one of the Analyzer classes which is called UniqueTokenAnalyzer. It will implement 
 * the Analyzer interface.
 *
 * @author Sean Fiscus
 */

public class UniqueTokenAnalyzer implements Analyzer {

    //	Create a Set instance variable with an id of uniqueTokenList
    private Set<String> uniqueTokenList;

    // Create a properties instance variable with an id of properties
    private Properties properties;

    // Constructor for UniqueTokenAnalyzer
    public UniqueTokenAnalyzer() {
        uniqueTokenList = new TreeSet<String>();
    }

    /** Create a Constructor with one parameter that is a Properties object. Then assign the
     *  parameter reference to the Properties instance variable
     *
     *  @param properties properties object
     */
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns uniqueTokenList instance variable.
     *
     * @return A set of all the unique tokens in the input text file.
     */
     
    public Set getUniqueTokensList() {
        return uniqueTokenList;
    }

    /**
     * Recieves tokens from the AnalyzeFile class and puts them into a TreeSet.
     *
     * @param token A single token from the input file.
     */
     
    public void processToken(String token) {
        uniqueTokenList.add(token);
    }

    /**
     * Uses PrintWriter to output a file of all of the unique tokens in the
     * input text file. Included in the method is exception handling to
     * catch multiple error that have the potential to be thrown.
     *
     * @param inputFilePath The input file path originally provided by the user.
     * @param outputFilePath The destination path for the output text file.
     */
     
    public void writeOutputFile(String inputFilePath) {

        PrintWriter out = null;

        String outputFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.unique");

        try {
            out = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFilePath)));

            loopThroughTokens(out);

            System.out.println("Unique Token List output to " +
                    outputFilePath + ".");

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
     * Writes each token in the TreeSet uniqueTokenList to the output file.
     *
     * @param out The PrintWriter created in the writeOutputFile method.
     */
    private void loopThroughTokens(PrintWriter out) {

        for (Object element : uniqueTokenList) {
            out.println(element);
        }
    }
}
