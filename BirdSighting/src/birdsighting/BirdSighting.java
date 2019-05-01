/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */
package birdsighting;

/**
 *
 * @author mark
 */
public class BirdSighting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bird robin = new Bird();
        Bird duck = new Bird("duck", 91);
        
        System.out.println(String.format("The Bird Species is %s and it was found on %s", robin.getSpecies(), robin.getDate()));
        System.out.println(String.format("The Bird Species is %s and it was found on %s", duck.getSpecies(), duck.getDate()));
        
        
    }
    
}
