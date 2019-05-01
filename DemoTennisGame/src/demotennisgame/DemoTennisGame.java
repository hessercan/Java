/*
 * Mark Hesser
 * HesserCAN
 * mark@hessercan.com
 * www.hessercan.com
 */
package demotennisgame;

/**
 *
 * @author mark
 */
public class DemoTennisGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TennisGame game1 = new TennisGame("Fred", "Wilma", 1, 4);
        DoublesTennisGame game2 = new DoublesTennisGame("Fred", "Wilma", "Barney", "Betty", 3, 2);

        game1.DisplayResults();
        System.out.println();
        game2.DisplayResults();
    }

}
