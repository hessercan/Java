/*
 * Mark Hesser
 * HesserCAN
 * mark@hessercan.com
 * www.hessercan.com
 */
package teststate;

/**
 *
 * @author mark
 */
public class City {
    private final String Name;
    private final int Population;

    public City(String name, int pop){
        Name = name;
        Population = pop;

    }

    public String getName(){
        return Name;
    }
    public int getPop(){
        return Population;
    }

}
