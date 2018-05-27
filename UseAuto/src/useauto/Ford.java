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
public class Ford extends Auto 
{
    public Ford()
    {
        super("Ford");
    }
    
    @Override
        void setPrice()
        {
            super.Price = 20000;
        }
}
