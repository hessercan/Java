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
public class CreateBuildings 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Building[] buildings = new Building[6];
        buildings[0] = new House(100, 1, 2, 1.5);
        buildings[1] = new School(3000, 1, 20, 1);
        buildings[2] = new House(200, 2, 3, 2.5);
        buildings[3] = new School(3000, 2, 30, 2);
        buildings[4] = new House(300, 3, 4, 2.5);
        buildings[5] = new School(3000, 3, 40, 3);
        
        String info = "";
        for (int i = 0; i < buildings.length; i++)
        {
            if (buildings.length == (i + 1))
                info += buildings[i].toString() + "\n";
            else
                info += buildings[i].toString() + "\n\n";
        }
        DisplayInfo(info);
    }
    
    static void DisplayInfo(String info)
    {
        System.out.println(info);
    }
}
