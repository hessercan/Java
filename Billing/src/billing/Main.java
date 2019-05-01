/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */
package billing;

/**
 *
 * @author mark
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Billing bill1 = new Billing(3.00);
        Billing bill2 = new Billing(4.00, 2);
        Billing bill3 = new Billing(10.00, 3, 5.00);
    
        System.out.println(String.format("The total for bill 1 is $%.2f", bill1.getTotal()));
        System.out.println(String.format("The total for bill 2 is $%.2f", bill2.getTotal()));
        System.out.println(String.format("The total for bill 3 is $%.2f", bill3.getTotal()));
    } 
}
