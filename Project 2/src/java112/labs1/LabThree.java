package java112.labs1;

public class LabThree {

    public static void main(String[] args) {
        LabThree information = new LabThree();
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");    
        } else {
            information.run(args[0]);
        }
    }

    public void run(String argument) {
        System.out.println("input: " + argument);
    }
}
