package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * Create a class with an id of BigWordAnalyzer this Analyzer will only store unique tokens that are greater
 * than or equal to a specified number. The specified number for the minimum length token must come from the project
 * Properties object and can’t be hard-coded into the class. The file will have one token on each
 * line. There will not be any duplicates in the file. This class implements the Analyzer interface.
 *
 * @author Sean Fiscus
 */

public class BigWordAnalyzer implements Analyzer {

    // Create a private Properties instance variable with an id of properties
    private Properties properties;

    // Create a private Set with an id of bigWords
    private Set<String> bigWords;

    // Create a private int with an id of minimumWordLength
    private int minimumWordLength;


    // Create a Constructor for the BigWordAnalyzer object using a TreeSet similar to the UniqueTokenAnalyzer
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }


    /**
     * Create a Constructor for the BigWordAnalyzer object with one parameter that is a Properties object.
     * Then assign the parameter reference to the Properties instance variable.
     *
     * @param properties properties object
     */
    public BigWordAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        minimumWordLength =
                Integer.parseInt(properties.getProperty(
                        "bigwords.minimum.length"));
    }


    /**
     * Create a method with an id of getProperties. It will return the properties value.
     *
     * @return The properties value
     */
    public Properties getProperties() {
        return properties;
    }


    /**
     * Create a get method with an id of getMinimumWordLength. It will returns the value of minimumWordLength.
     *
     * @return The minimumWordLength value
     */
    public int getMinimumWordLength() {
        return minimumWordLength;
    }


    /**
     * The final instance variable that can be used for this class. This method will get the bigWords attribute
     * of the BigWordAnalyzer object.
     *
     *@return The bigWords value
     */
    public Set<String> getBigWords() {
        return bigWords;
    }


    /**
     * Create a method with an id of processToken with a String parameter. The method adds each unique token
     * to bigWords.
     *
     * @param token String token
     */
    public void processToken(String token) {

        /**
         * Create an if statement to test if the length of the token is greater than or equal to
         * the minimumWordLength.
         */

        if (token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }


    /**
     * Create a method with an id of writeOutputFile with a parameter for the inputFilePath. This
     * method calls a method to write the token information to the file. Included in the method is
     * exception handling to catch multiple error that have the potential to be thrown.
     *
     * @param inputFilePath input file path
     */
    public void writeOutputFile(String inputFilePath) {

        PrintWriter out = null;

        String outputFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.bigwords");

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
     * Create a method with an id of writeTokens and include a parameter. This method writes all the
     * unique tokens into a file.
     *
     *@param  out  PrintWriter
     */
    private void writeTokens(PrintWriter out) {

        // Create enhanced for loop
        for (String token: bigWords) {
            out.println(token);
        }

    }

}

