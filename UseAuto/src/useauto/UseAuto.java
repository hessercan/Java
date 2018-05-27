/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package useauto;

import javax.swing.*;

/**
 * @author mark
 */
public class UseAuto 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Auto[] cars = new Auto[2];
        cars[0] = new Ford();
        cars[1] = new Chevy();
        
        String info = "";
        for (int i = 0; i < cars.length; i++)
        {
            cars[i].setPrice();
            if (cars.length == (i + 1))
            {
                info += (cars[i].AutoInfo() + "\n");
            }
            else
                info += (cars[i].AutoInfo() + "\n\n");
        }
        DisplayCarInfo(info);
    }

    static void DisplayCarInfo(String info)
    {
        System.out.println(info);
        JOptionPane.showMessageDialog(null, info, "Cars", 1);
    }
}
