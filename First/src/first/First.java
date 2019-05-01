/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */
package first;

/**
 * @author mark
 */
import java.util.Scanner;
public class First {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i;
        System.out.println("These are even numbers from 20 to 40");
        for (i = 20; i <= 40; i+=2) {
            System.out.println(i);
        }
        System.out.println();
        
        System.out.println("These are all numbers from 1 to 100");
        i = 1;
        while (i <= 100) {
            System.out.println(i);
            i++;    
        }
        System.out.println();
        
        Add add1 = new Add(5.45,10.24);
        Add add2 = new Add(3.54F,4.76F);
        
        System.out.println(add1.getSum());
        System.out.println(add2.getSum());   
        
        System.out.println();
        double rad = 0;
        boolean isValid = true;
        
        Scanner scan;
        do {
            isValid = true;
            System.out.print("Please enter the Radius of the Circle: ");
            try {
                scan = new Scanner(System.in);
                rad = scan.nextDouble();
            } catch(java.util.InputMismatchException e) {
                    isValid = false;
                    System.out.println("That is not a valid radius.");
                    System.out.println();
            }
        } while (!isValid);
        
        System.out.println();
        System.out.println(String.format("Values of the Circle have been rounded to the 2nd decimal place."));
        
        Circle circle1 = new Circle(rad);
        circle1.getCircleData();
        
        System.out.println();
        Circle circle2 = new Circle();
        System.out.println(String.format("If the Radius of the Circle is %.2f.", circle2.Radius));
        System.out.println(String.format("The Area of the Circle is %.2f", circle2.getArea()));
    }
}
