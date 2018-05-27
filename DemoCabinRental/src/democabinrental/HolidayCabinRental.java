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
public class HolidayCabinRental extends CabinRental {
    public HolidayCabinRental(int num){
        super(num);
        final int SURCHARGE = 150;
        Rate += SURCHARGE;
    }
}
