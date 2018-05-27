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
public class Leaf implements Turner
{
    @Override
    public void turn()
    {
        System.out.println("Change colors");
    }
}
