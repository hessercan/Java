/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package createcircle;

/**
 * @author mark
 */
public class Circle 
{
    private double radius;
    private String color;
    
    public Circle (String c, double r)
    {
        color = c;
        radius = r;
    }
    public String getColor()
    {
        return color;
    }
    public double getRadius()
    {
        return radius;
    }
    
    @Override
    public String toString()
    {
        return String.format("Color: %s \nRadius: %.2f \n", color, radius);
    }
}
