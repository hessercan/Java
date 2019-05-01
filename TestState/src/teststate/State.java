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
public class State {
    private final String Name;
    private final int Population;
    private final City Capital;
    private final City Big;

    public State(String nom, int pop, String capName, int capPop, String bigName, int bigPop){
        Name = nom;
        Population = pop;
        Capital = new City(capName, capPop);
        Big = new City(bigName, bigPop);
    }

    public String getName(){
        return Name;
    }
    public int getPopulation(){
        return Population;
    }
    public String getCapName(){
        return Capital.getName();
    }
    public int getCapPop(){
        return Capital.getPop();
    }
        public String getBigName(){
        return Big.getName();
    }
    public int getBigPop(){
        return Big.getPop();
    }
}
