/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democabinrental;

/**
 *
 * @author mark
 */
public class DemoCabinRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CabinRental cabin1 = new CabinRental(1);
        CabinRental cabin4 = new CabinRental(4);
              
        HolidayCabinRental hcabin1 = new HolidayCabinRental(1);
        HolidayCabinRental hcabin4 = new HolidayCabinRental(4);
        
        System.out.println(String.format("Cabin %d: $%.2f", 
                cabin1.getCabinNumber(), cabin1.getRate()));
        System.out.println(String.format("Cabin %d: $%.2f", 
                cabin4.getCabinNumber(), cabin4.getRate()));
        System.out.println(String.format("Cabin %d: $%.2f", 
                hcabin1.getCabinNumber(), hcabin1.getRate()));
        System.out.println(String.format("Cabin %d: $%.2f", 
                hcabin4.getCabinNumber(), hcabin4.getRate()));
        
        
    }
    
}
