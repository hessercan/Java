/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democandles;

/**
 *
 * @author mark
 */
public class DemoCandles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Candle candle = new Candle("White", 12);
        ScentedCandle scent = new ScentedCandle("Blue", 9, "Blueberry");
        
        candle.DisplayCandle();
        System.out.println();
        scent.DisplayCandle();
    }
    
}
