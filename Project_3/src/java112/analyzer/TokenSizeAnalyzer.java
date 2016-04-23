package java112.analyzer;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;


/**
 * This is one of the Analyzer classes which is called TokenSizeAnalyzer. 
 * This analyzer will determine the size distribution of the tokens in the input file.  
 * The first part of the output will be a listing of sizes of tokens and the 
 * number of tokens that are that size. The second part of the output will
 * display a histogram of the results. The display will be adjusted
 * for each file. The value of each asterisk will be changed so that 
 * the histogram doesn’t exceed the max length in the properties file and
 * it will minimally display at least one “*”. This class also implements Analyzer.
 *
 * CHANGES REQUIRED: For the project I was to use the Collections.max method to 
 * optimize performance for the project. I created a method with an id of 
 * calculateMaximumAmount to solve this problem.
 * 
 *@author Sean Fiscus
 */

public class TokenSizeAnalyzer implements Analyzer {

    // Create a Map instance variable with an id of tokenSizes
    private Map<Integer, Integer> tokenSizes;

    // Create a properties instance variable with an id of properties
    private Properties properties;

    // Create an int variable with an id of maximumSize
    private int maximumSize;

    
    // Construct a new TokenSizeAnalyzer object.
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }

    /**
     * Constructs a new TokenSizeAnalyzer object.
     *
     * @param properties Properties object containing properties required by the program.
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        maximumSize = 76;
    }

    /**
     * Gets the value stored in tokenSizes
     *
     * @return tokenSizes a TreeMap of all word lengths in the input file mapped
     *         to their frequency.
     */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }

    /**
     * Gets the value stored in maximumSize
     *
     * @return maximumSize the highest frequency word length.
     */
    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * CHANGE FOR PROJECT 3
     * Was told to look in the Collections for a simpler solution for finding the 
     * maximum value for the tokenSize. After some research I found the Collections.max
     * method. This should also help optimize the runtime. 
     */
    public double calculateMaximumAmount() {
		
		double maxAmount = 0;
		
        /**
         * The max(Collection<? extends T>, Comparator<? super T>) method is used 
         * to return the maximum element of the given collection, according to the 
         * order induced by the specified comparator			
        */	
		maxAmount = (double)getMaximumSize()/Collections.max(tokenSizes.values());
		
		return maxAmount;	
	}

    /**
     * Stores current token length and updates its respective frequency.
     *
     * @param token the current token in the input file.
     */
    public void processToken(String token) {
        
        // Create an int with an id of currentTokenLength and set it equal to the token.length()
        int currentTokenLength = token.length();
        processTokenHelper(currentTokenLength);

        /**
         * Create an int with an id of tokenLengthReps and set it equal to 
         * tokenSizes.get(currentTokenLength);
         */
        int tokenLengthReps = tokenSizes.get(currentTokenLength);

        /**
         * Create an if statement that will determine if the tokenLength is 
         * larger than the maximumSize int variable
         */
        if (tokenLengthReps > maximumSize) {
            maximumSize = tokenSizes.get(currentTokenLength);
        }
    }

    /**
     * Manages the writing process of found unique tokens to the output file.
     * Uses PrintWriter to output a file of all of the unique tokens in the
     * input text file. Included in the method is exception handling to
     * catch multiple error that have the potential to be thrown. 
     * 
     * @param inputFile path to the file to be read from.
     */
    public void writeOutputFile(String inputFilePath) {

        String outputFile = properties.getProperty("output.dir") +
                            properties.getProperty("output.file.token.size");

        PrintWriter writer = null;
        try {
            writer = createOutputFile(outputFile);
            writeTotalsToFile(writer);
            writer.println();
            writer.println();
            writeHistograms(writer);
        } catch (IOException iOE) {
            System.out.println("Error Writing to " + outputFile);
            iOE.printStackTrace();
        } catch (Exception exception) {
            System.out.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception exception) {

                exception.printStackTrace();
            }
        }
    }

    /**
     * Updates the frequncy of the current token length. Includes an if statement 
     * that includes the containsKey method. This method returns true if this map 
     * contains a mapping for the specified key.
     * 
     * @param tokenLength the length of the current token.
     */
    private void processTokenHelper(int tokenLength) {
        if (tokenSizes.containsKey(tokenLength)) {
            int tokenLengthReps = tokenSizes.get(tokenLength);
            tokenSizes.put(tokenLength, ++tokenLengthReps);
        } else {
            tokenSizes.put(tokenLength, 1);
        }
    }

    /**
     * Instatiates a PrintWriter object for writing to the given output file.
     *
     * @param outputFile path of the file to be written to.
     * @throws IOException if a problem is encountered while accessing the
     *                     specified ouput file.
     * @return             a PrinterWriter object to write to the file.
     */
    private PrintWriter createOutputFile(String outputFile) throws IOException {
        return new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
    }

    /**
     * Writes out the frequency of all found token lengths. Originally tried 
     * using a while statement with an Iterator but included an enhanced for loop
     * for better optimization. Kept the code just commented it out to show what
     * did. 
     * 
     * @param writer PrintWriter object used to write to the output file.
     */
    private void writeTotalsToFile(PrintWriter writer) {
        Set set = tokenSizes.entrySet();
        String delimiter = "\t";

        // Use of Iterator for the while loop that is no longer being used.
        // Iterator iterator = set.iterator();
    
        for(Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            writer.println(entry.getKey() + delimiter + entry.getValue());
        }    

        /**
         * This is a while loop I used in project 1 but Paula told me to use an 
         * enhanced for loop instead. 
         * 
         * while (iterator.hasNext()) {
         *   Map.Entry me = (Map.Entry) iterator.next();
         *   writer.println(me.getKey() + "\t" + me.getValue());
         * }
        */
    }

    
    /**
     * Writes out the histograms to the file. Originally tried 
     * using a while statement with an Iterator but included an enhanced for loop
     * for better optimization. Kept the code just commented it out to show what
     * did. 
     * 
     * @param writer PrintWriter object used to write to the output file.
     */
    private void writeHistograms(PrintWriter writer) {
        Set set = tokenSizes.entrySet();
        String delimiter = "\t";
        double amount = 0;
		double histogramAmount = 0;

        // Use of Iterator for the while loop that is no longer being used.
        // Iterator iterator = set.iterator();

        // Implement the calculateMaximumAmount method for PROJECT 3 CORRECTION
        for(Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            amount = calculateMaximumAmount();
			histogramAmount = (double) entry.getValue() * amount;
            writer.println(entry.getKey() + delimiter + printHistogram(histogramAmount));
        }        

        /**
         * This is a while loop I used in project 1 but Paula told me to use an 
         * enhanced for loop instead. 
         *
         * while (iterator.hasNext()) {
         *   Map.Entry me = (Map.Entry) iterator.next();
         *   int tokenValue = (int) me.getValue();
         *   writer.println(me.getKey() + "\t" + printHistogram(tokenValue));
         * }
         */
    }

    /**
     * Creates histogram graph bar of frequency for a token length.
     *
     * @return histogram a String of stars representing the frequency of a token length.
     */
    private String printHistogram(double tokenValue) {
        double histogramValue = maximumSize;
        double totalHistograms = Math.round(tokenValue / histogramValue);
        if (totalHistograms == 0) { 
            totalHistograms = 1; 
        }

        String histograms = "";
        for (int i = 0; i < totalHistograms; i++) {
            histograms += "*";
        }
        return histograms;
    }
}
