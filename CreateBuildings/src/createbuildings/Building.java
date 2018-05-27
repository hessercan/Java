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
public abstract class Building 
{
    private final double sqFt;
    private final int stories;
                
    public Building(double sf, int st)
    {
        sqFt = sf;
        stories = st;
    }
    
    public double getSqFt()
    {
        return sqFt;
    }
    public int getStories()
    {
        return stories;
    }
    
    public abstract String toString();
}
