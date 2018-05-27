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
public class CabinRental {
    private int CabinNumber;
    protected double Rate;
    final int CUTOFF = 4;
    final double LOWRATE = 950;
    final double HIGHRATE = 1100;
    
    public CabinRental(int num){
        CabinNumber = num;
        if(CabinNumber < CUTOFF)
            Rate = LOWRATE;
        else
            Rate = HIGHRATE;
    }
    
    public int getCabinNumber(){
        return CabinNumber;
    }
    public double getRate(){
        return Rate;
    }
}
