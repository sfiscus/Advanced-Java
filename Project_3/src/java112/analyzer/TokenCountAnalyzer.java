package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * Create a call with an id of TokenCountAnalyzer. This class will implement Analyzer. The class will
 * count the number of unique tokens. The output file will contain a row for each unique token.
 * Each row will have the token, a tab character, and the number of times that token occurred in the file.
 *
 * @author Sean Fiscus
 */

public class TokenCountAnalyzer implements Analyzer {

    // Create a Properties instance variable with an id of properties
    private Properties properties;

    // Create a Map object with an id of tokenCounts
    private Map<String, Integer> tokenCounts;

    /**
     * Create a Constructor for the UniqueTokenCountAnalyzer object. Use a TreeMap object and set
     * it equal to the variable tokenCounts.
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }

    /**
     * Create a Constructor with one parameter that is a Properties object. Then assign the
     * parameter reference to the Properties instance variable
     *
     * @param properties properties object
     */
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Create a get method for the Properties object. Call the method getProperties. This method gets
     * the properties attribute of the UniqueTokenCountAnalyzer object.
     *
     * @return The properties value
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Create a method with an id of tokenCounts. This method will return the tokenCounts map.
     *
     * @return Map of tokenCounts
     */
    public Map<String, Integer> tokenCounts() {

        //public Map tokenCounts() {
        return tokenCounts;
    }

    /**
     * Create a get method with an id of getTokenCounts. This method gets the tokenCounts attribute
     * of the UniqueTokenCountAnalyzer object.
     *
     * @return The tokenCounts value
     */
    public Map getTokenCounts() {
        return tokenCounts;
    }

    /**
     * Create a method with an id of processToken. The method will have a String parameter. The method determines
     * if the token is currently in the tokenCounts map.
     *
     * @param  token  token
     */
    public void processToken(String token) {

        // Create an int with an id of tokenCount and set it equal to 1.
        int count = 1;

        /**
         * Create an if statement that will test of the token exists in the map. If it does then the current value for
         * the key is incremented by 1. If the token is not in the map, then it is added as a key with a value of 1.
         */

        if (tokenCounts.containsKey(token)) {
            count = tokenCounts.get(token);
            count++;
            tokenCounts.put(token, count);
        } else {
            tokenCounts.put(token, count);
        }
    }


    /**
     * Create a method with an id of writeOutputFile. This method will have a String parameter.
     * This method calls a method to write the token information to the file. It also handles
     * exceptions for writing the output.
     *
     * @param  inputFilePath  input file path
     */
    public void writeOutputFile(String inputFilePath) {

        PrintWriter out = null;

        String outputFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.token.count");

        try {

            out = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFilePath)));

            writeTokens(out);

        } catch (IOException ioException) {

            ioException.printStackTrace();

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
     * Create a method with an id of writeTokens. This method writes all the unique tokens with
     * their counts into a file.
     *
     * @param  out  PrintWriter object
     */
    private void writeTokens(PrintWriter out) {

        // Create a String variable with an id of delimiter and set it equal to "\t"
        String delimiter = "\t";

        // Use enhanced for loop to take the place of for (int i = 0; i < 2; i++) {
        for (Map.Entry<String, Integer> entry : tokenCounts.entrySet()) {
            out.println(entry.getKey() + delimiter + entry.getValue());
        }
    }

}

