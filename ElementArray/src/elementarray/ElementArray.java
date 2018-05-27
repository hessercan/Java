/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package elementarray;

import javax.swing.*;

/**
 * @author mark
 */
public class ElementArray 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Element[] elements = new Element[4];
        elements[0] = new MetalElement("Iron", "Fe", 26, 55.845);
        elements[1] = new MetalElement("Copper", "Cu", 29, 63.546);
        elements[2] = new NonMetalElement("Helium", "He", 2, 4.0026);
        elements[3] = new NonMetalElement("Neon", "Ne", 10, 20.180);
        
        String info = "";
        for (int i = 0; i < elements.length; i++)
        {
            if (elements.length == (i + 1))
                info += elements[i].describeElement() + "\n";
            else 
                info += elements[i].describeElement() + "\n\n";
        }
        DisplayElementInfo(info);
    }
    static void DisplayElementInfo(String info)
    {
        System.out.println(info);
        JOptionPane.showMessageDialog(null, info, "Element Desription", 1);
    }
}
