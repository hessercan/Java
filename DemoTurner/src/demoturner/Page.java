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
public class Page implements Turner
{
    @Override
    public void turn()
    {
        System.out.println("Going to the next page");
    }
}
