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
public class Car implements Turner
{
    @Override
    public void turn()
    {
        System.out.println("Turning");
    }
}
