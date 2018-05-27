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
public class Milk implements Turner
{
    @Override
    public void turn()
    {
        System.out.println("Expiring");
    }
}
