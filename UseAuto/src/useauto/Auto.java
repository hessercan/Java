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
public abstract class Auto
{
    private final String Make;
    protected double Price;
    
    public Auto(String make)
    {
        Make = make;
    }
    
    public String getMake() 
    {
        return Make;
    }
    public Double getPrice()
    {
        return Price;
    }
    
    abstract void setPrice();
    
    public String AutoInfo()
    {
        return String.format("%s \nPrice: $%.2f", Make, Price); 
    }
}
