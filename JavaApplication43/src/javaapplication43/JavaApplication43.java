/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package javaapplication43;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * @author mark
 */
public class JavaApplication43 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyy");
        LocalDate now = LocalDate.now();
        YearMonth today = YearMonth.parse(now.format(formatter), formatter);
        
        System.out.println(today);
    }
}
