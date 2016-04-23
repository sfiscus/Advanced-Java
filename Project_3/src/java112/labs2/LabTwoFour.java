package java112.labs2;

import java.util.*;
import java.io.*;

public class LabTwoFour {

    private Map<String, Integer> map;
    
    public static void main(String[] args) {
        LabTwoFour demo = new LabTwoFour();
        demo.run();
    } 

    public void run() {

        map = new HashMap<String, Integer>();

        map.put("abc", 4);
        map.put("123", 5);
        map.put("def", 6);
        map.put("abc", 10);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
          String key = entry.getKey();
          Integer value = entry.getValue();
          System.out.println(key + " => " + value);

      }

    }

}
