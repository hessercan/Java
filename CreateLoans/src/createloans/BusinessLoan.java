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
public class BusinessLoan extends Loan
{
    private final double BLIR = .02;
    
    /**
     *
     * @param ln
     * @param cl
     * @param loan
     * @param t
     */
    public BusinessLoan(int ln, String cl, double loan, int t)
    {
        super(ln, cl, loan, t);
        setInterestRate();
    }
    
    void setInterestRate()
    {
        interestRate = BLIR;
    }
}
