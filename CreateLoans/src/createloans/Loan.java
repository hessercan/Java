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
public abstract class Loan implements LoanConstants
{
    private final int loanNum, term;
    private final String custLast;
    private final double loanAmt;
    protected double interestRate;
    
    //Default Constructor

    /**
     *
     * @param ln
     * @param cl
     * @param loan
     * @param t
     */
    public Loan(int ln, String cl, double loan, int t)
    {
        loanNum = ln;
        custLast = cl;
        
        //Sets Loan Amount based on input
        //Doesn't allow over Max
        if (loan > MAX_LOAN)
            loanAmt = MAX_LOAN;
        else if (loan < 0) 
            loanAmt = 0;
        else
            loanAmt = loan;
        
        if (t > 0)
        {
            if (t == SHORT_TERM)
                term = SHORT_TERM;
            else if (t == MEDIUM_TERM)
                term = MEDIUM_TERM;
            else if (t >= LONG_TERM)
                term = LONG_TERM;
            else
                term = SHORT_TERM;
        }
        else
            term = SHORT_TERM;
    }
    
    public int getLoanNum()
    {
        return loanNum;
    }
    public String getCustLast()
    {
        return custLast;
    }
    public double getLoanAmt()
    {
        return loanAmt;
    }
    public String getLoanTermStr()
    {
        switch (term)
        {
            case LONG_TERM:
                return "Long Term (Five Years)";
            case MEDIUM_TERM:
                return "Medium Term (Three Years)";
            default:
                return "Short Term (One Year)";
        }
    }
    
    //Forces InterestRate to be set by the Children.
    abstract void setInterestRate();
    
    @Override
    public String toString()
    {
        return String.format("Loan Number: %d\nCustomer: %s \nLoan: $%.2f "
                + "\nInterest Rate: %.0f%% \nTerm: %s", 
                loanNum, custLast, loanAmt, (interestRate * 100), getLoanTermStr());
    }
}
