/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcarpet;

/**
 *
 * @author mark
 */
public class TestCarpet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carpet carpet1 = new Carpet(12, 14, "Prime");
        Carpet carpet2 = new Carpet(7, 13, "Choice");
        Carpet carpet3 = new Carpet(15, 8, "Standard");
        Carpet carpet4 = new Carpet(6, 4, "Stndard");
        
        System.out.println(carpet1.displayResults());
        System.out.println(carpet2.displayResults());
        System.out.println(carpet3.displayResults());
        System.out.println(carpet4.displayResults());
    }
    
}
