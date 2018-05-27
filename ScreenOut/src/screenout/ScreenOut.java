/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package screenout;

import java.io.*;

/**
 * @author mark
 */
public class ScreenOut 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String s = "ABCDE";
        byte[] data = s.getBytes();
        OutputStream output = null;
        try 
        {
            output = System.out;
            output.write(data);
            output.flush();
            output.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
    }
}
