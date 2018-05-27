/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package readfile;

import java.nio.file.*; 
import java.io.*;

/**
 * @author mark
 */
public class ReadFile
{
    public static void main(String[] args) 
    {
        Path file = Paths.get(System.getProperty("user.home") 
                + "/Desktop/Grades.txt"); 
        InputStream input = null;
        try
        {
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            while((s = reader.readLine()) != null)
            {
                System.out.println(s); 
            }
            input.close();
        }
        catch (IOException e) 
        {      
            System.out.println(e);
        }
    }
}
