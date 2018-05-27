/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package demoturner;

/**
 * @author mark
 */
public class DemoTurner2 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Leaf leaf = new Leaf();
        Page page = new Page();
        Pancake pancake = new Pancake();
        Milk milk = new Milk();
        Car car = new Car();
        
        leaf.turn();
        page.turn();
        pancake.turn();
        milk.turn();
        car.turn();
    }
}
