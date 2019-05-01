/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package hotdoghouse;

/**
 * @author mark
 */
public class OrderItem 
{
    private String itemName;
    private double itemPrice;
    private String[] modifiers;
    private double[] modPrice;
    private double totalPrice;
    
    /**
     *
     * @param in Item Name
     * @param ip Item Price
     * @param mod Modifiers
     * @param mp Modifiers Price
     */
    public OrderItem(String in, double ip, String[] mod, double[] mp)
    {
        itemName = in;
        itemPrice = ip;
        modifiers = mod;
        modPrice = mp;
        
        setTotalPrice();
    }
    
    //sets the total price of the item
    private void setTotalPrice()
    {
        totalPrice = 0;
        totalPrice += itemPrice;
        for (double mp : modPrice)
        {
            totalPrice += mp;
        }
    }
    
    //Returns the total Price of the Item
    public double getPrice()
    {
        return totalPrice;
    }
    
    //Returns the Name of the Item
    public String getItemName()
    {
        return itemName;
    }

    //Returns the Price of the Item
    public double getItemPrice()
    {
        return itemPrice;
    }

    //Returns the Array of Modifiers
    public String[] getModifers()
    {
        return modifiers;
    }

    //Returns the Array of Modifier Prices
    public double[] getModPrice()
    {
        return modPrice;
    }
}
