package java112.demo;

import java.io.*;

public class ReadDemoEve {

    // static methods can be called on the class itself
    // static methods can't use anything that isn't static
    // need to instaniate an object in order to call
    public static void main(String[] args) {
        ReadDemoEve demo = new ReadDemoEve();
        demo.read();
        
    }

    public void read() {
        String line = null;
        BufferedReader in = null;    
        /**
        FileReader reader = new FileReader("foo.in");
        BufferedReader in = new BufferedReader(reader);
        */

        try {
            // line 25 is equivalent to lines 19 and 20
            in = new BufferedReader(new FileReader("foo.in"));
            while (in.ready()) {
                line = in.readLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("Could not find the file");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("Could not read the file");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something bad happened");
            exception.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ioEx2) {
                System.out.println("Could not read the file");
                ioEx2.printStackTrace();
            }
        }
    }

}
