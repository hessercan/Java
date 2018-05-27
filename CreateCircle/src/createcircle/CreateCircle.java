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
public class CreateCircle 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Circle[] c = new Circle[2];
        c[0] = new Circle("Red", 2);
        c[1] = new Cylinder("Red", 2, 2);
    
        String info = "";
        for (int i = 0; i < c.length; i++)
        {
            if (c.length == (i + 1))
                info += c[i].toString() + "\n";
            else
                info += c[i].toString() + "\n\n";
        }
        DisplayInfo(info);
    }
    
    static void DisplayInfo(String info)
    {
        System.out.println(info);
    }
}

/*
The Cylinder class inherits the Color and Radius variables from the Superclass,
as well as the getColor and getRadius Methods. The subclass Cylinder defines
the initizlizes the height variables defines the getHeight and getVolume methods 
to retrieve those values. I have added the setArea and setVolume methods that 
are used to calculated the area and volume of a Cylinder using the Radius and 
Height variables with the Math.PI and Math.pow functions.
*/
