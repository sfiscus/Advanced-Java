package java112.labs1;

/** 
 * This is the first lab for Advanced Java
 * @author Sean Fiscus
 **/

public class MysteryClassOne {
    
    public static void main(String[] args) {

    System.out.println(args[0]);

    MysteryClassOne demo = new MysteryClassOne();
    
    System.out.println(demo.mysteryMethodOne());    

    }

    public int mysteryMethodOne() {
        return 1;

    }     
}
