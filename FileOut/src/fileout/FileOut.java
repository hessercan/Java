/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package fileout;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

/**
 * @author mark
 */
public class FileOut 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Path file = Paths.get(System.getProperty("user.home") 
                + "/Desktop/Grades.txt");
        String s = "ABCDF";
        byte[] data = s.getBytes();
        OutputStream output = null;
        try
        {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND));
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
