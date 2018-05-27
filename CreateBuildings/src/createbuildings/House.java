/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package createbuildings;

/**
 * @author mark
 */
public class House extends Building
{
    private int beds; 
    private double baths;
    
    public House(double sf, int st, int be, double ba) 
    {
        super(sf, st);
        beds = be;
        baths = ba;
    }
    public int getNumBeds()
    {
        return beds;
    }
    public double getNumBaths()
    {
        return baths;
    }
    @Override
    public String toString()
    {
        return String.format("House \n%.2f SqFt \n%d Stories \n%d Beds, "
                + "%.1f Baths", super.getSqFt(), super.getStories(), 
                beds, baths);
    }
}
