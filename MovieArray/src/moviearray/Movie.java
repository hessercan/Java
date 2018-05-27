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
public abstract class Movie 
{
    private final String title;
    private final double rating; 
    protected double price;

    public Movie(String t, double r)
    {
        title = t;
        rating = r;
    }
    
    abstract void setPrice();
    public abstract String toString();
        
    public String getTitle()
    {
        return title;
    }
    public double getRating()
    {
        return rating;
    }
    public double getPrice()
    {
        return price;
    }
}
