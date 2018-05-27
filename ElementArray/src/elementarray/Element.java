/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package elementarray;

/**
 * @author mark
 */
public abstract class Element 
{
    private final String name, symbol;
    private final int atomicNum;
    private final double atomicWeight;
    
    public Element(String n, String s, int an, double aw)
    {
        name = n;
        symbol = s;
        atomicNum = an;
        atomicWeight = aw;
    }
    public String getName()
    {
        return name;
    }
    public String getSymbol()
    {
        return symbol;
    }
    public int getAtomicNum()
    {
        return atomicNum;
    }
    public double getAtomicWeight()
    {
        return atomicWeight;
    }
    
    abstract String describeElement();
}
