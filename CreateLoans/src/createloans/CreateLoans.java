/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package createloans;

/**
 * @author mark
 */
public class CreateLoans 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Loan[] loans = new Loan[5];
        
        loans[0] = new PersonalLoan(1, "Hesser", 34000, 5);
        loans[1] = new BusinessLoan(2, "Ireland", 1560000, 5);
        loans[2] = new PersonalLoan(3, "Woods", 58600, 5);
        loans[3] = new BusinessLoan(4, "Bartges", 90000, 5);
        loans[4] = new PersonalLoan(5, "Confer", 10200, 5);
        
        String info = "";
        for (int i = 0; i < loans.length; i++)
        {
            if (loans.length == (i + 1))
                info += loans[i].toString() + "\n";
            else
                info += loans[i].toString() + "\n\n";
        }
        DisplayInfo(info);
    }
    
    static void DisplayInfo(String info)
    {
        System.out.println(info);
    }
}
