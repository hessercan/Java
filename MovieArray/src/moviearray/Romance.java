/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package moviearray;

/**
 * @author mark
 */
public class Romance extends Movie
{
    private final String type = "Romance";
    
    public Romance(String t, double r)
    {
        super(t, r);
        setPrice();
    }
    
    @Override
    public void setPrice()
    {
        super.price = 17.99;
    }
    
    public String getType()
    {
        return type;
    }
    
    @Override
    public String toString()
    {
        return String.format("Movie Title: %s \nGenre: %s \nRating: %.1f "
                + "\nPrice: $%.2f", super.getTitle(), getType(), 
                super.getRating(), super.getPrice());
    }
}
