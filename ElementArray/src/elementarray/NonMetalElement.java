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
public class NonMetalElement extends Element
{
    public NonMetalElement(String n, String s, int an, double aw)
    {
        super(n, s, an, aw);
    }
    @Override
    String describeElement()
    {
        return String.format("%d %s\n%s\n%.4f\n"
                + "Nonmetals are poor conductors of electricity.",  
                super.getAtomicNum(), super.getSymbol(), super.getName(),
                super.getAtomicWeight());
    }
}
