/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlunch;

/**
 *
 * @author mark
 */
public class TestLunch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lunch lunch1 = new Lunch();
        Lunch lunch2 = new Lunch("Ham Sandwich", "Mac n Cheese", "Milk");
        
        lunch1.displayLunch();
        System.out.println();
        lunch2.displayLunch();
    }
    
    
    
}
