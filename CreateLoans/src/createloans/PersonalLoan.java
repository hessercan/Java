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
public class PersonalLoan extends Loan
{
    private final double PLIR = .01;
    
    /**
     *
     * @param ln
     * @param cl
     * @param loan
     * @param t
     */
    public PersonalLoan(int ln, String cl, double loan, int t)
    {
        super(ln, cl, loan, t);
        setInterestRate();
    }
    
    void setInterestRate()
    {
        interestRate = PLIR;
    }
}
