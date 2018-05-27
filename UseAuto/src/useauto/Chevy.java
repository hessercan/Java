/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package useauto;

/**
 * @author mark
 */
public class Chevy extends Auto 
{
    public Chevy()
    {
        super("Chevy");
    }
    
    @Override
        void setPrice()
        {
            super.Price = 22000;
        }
}
