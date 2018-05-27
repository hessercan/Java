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
public class Cylinder extends Circle
{
    private final double height;
    private double area, volume;
    
    public Cylinder(String c, double r, double h)
    {
        super(c, r);
        height = h;
        setArea(); setVolume();
    }
    
    public void setArea()
    {
        area = (2 * Math.PI * getRadius() * height) + 
                2 * Math.PI * Math.pow(getRadius(), 2);
    }
    public void setVolume()
    {
        volume = Math.PI * Math.pow(getRadius(), 2) * height;
    }
    
    public double getHeight()
    {
        return height;
    }
    public double getArea()
    {
        return area;
    }
    public double getVolume()
    {
        return volume;
    }
    
    @Override
    public String toString()
    {
        return String.format("Color: %s \nRadius: %.2f \nHeight: %.2f "
                + "\nArea: %.2f \nVolume: %.2f", 
                getColor(), getRadius(), height, area, volume);
    }
}
