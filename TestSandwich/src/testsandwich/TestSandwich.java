/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsandwich;

/**
 *
 * @author mark
 */
import javax.swing.*;
public class TestSandwich {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String breadtype;
        String fillingtype;
        
        breadtype = JOptionPane.showInputDialog(null, "Please enter your Bread Type.");
        fillingtype = JOptionPane.showInputDialog(null, "Please enter your Sandwich Filling.");
        
        Sandwich sandwich1 = new Sandwich();
        Sandwich sandwich2 = new Sandwich(breadtype, fillingtype);
        
        System.out.println(String.format("The %s sandwich on %s bread will cost $%.2f", sandwich1.getFillingType(), sandwich1.getBreadType(), sandwich1.getTotal()));
        System.out.println(String.format("The %s sandwich on %s bread will cost $%.2f", sandwich2.getFillingType(), sandwich2.getBreadType(), sandwich2.getTotal()));
        
        JOptionPane.showMessageDialog(null, String.format("The %s sandwich on %s bread will cost $%.2f", sandwich1.getFillingType(), sandwich1.getBreadType(), sandwich1.getTotal()));
        JOptionPane.showMessageDialog(null, String.format("The %s sandwich on %s bread will cost $%.2f", sandwich2.getFillingType(), sandwich2.getBreadType(), sandwich2.getTotal()));
        
    }
    
}
