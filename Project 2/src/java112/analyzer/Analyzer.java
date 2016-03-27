package java112.analyzer;

import java.util.*;

/**
 * This is the Interface for the project. It is called Analyzer. It must be implemented
 * by any class that performs an analysis. It will contain two methods:
 * 1.) processToken(String token)
 * 2.) writeOutputFile(String inputFilePath, String outputFilePath)
 * 
 * @author Sean Fiscus
 */

public interface Analyzer {

    /**
     * This method determines how each analyzer will process tokens.
     *
     * @param token This is a single character from the text file provided by the user.
     */
     
    void processToken(String token);

    /**
     * This method determines the format for the output to the text file.
     *
     * @param inputFilePath The file path to the text document. This will be
     * entered by the user.
     */

    void writeOutputFile(String inputFilePath);

}