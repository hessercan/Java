/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintcalculator;

/**
 *
 * @author mark
 */
import java.util.Scanner;
import javax.swing.*;
public class PaintCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double length;
        double width;
        double height;
        String input;
        
        try {
            input = JOptionPane.showInputDialog(null, "Enter the Length of the Room in Sq Ft");
            length = Double.parseDouble(input);
        }
        catch (java.lang.NumberFormatException e) {
            length = 0;
        }
        try {
            input = JOptionPane.showInputDialog(null, "Enter the Width of the Room in Sq Ft");
            width = Double.parseDouble(input);
        }
        catch (java.lang.NumberFormatException e) {
            width = 0;
        }
        try {
            input = JOptionPane.showInputDialog(null, "Enter the Height of the Room in Sq Ft");
            height = Double.parseDouble(input);
        }
        catch (java.lang.NumberFormatException e) {
            height = 0;
        }
        
        Room room1 = new Room(length, width, height);
        Paint paint1 = new Paint(room1.getArea());
        
        System.out.println(String.format("Area: %.2f sqft", room1.getArea()));
        if (paint1.isValid) {
            System.out.println(String.format("Total Cost: $%.2f", paint1.getTotalCost()));
            JOptionPane.showMessageDialog(null, String.format("If would cost $%.2f to paint %.2f SqFt.", paint1.getTotalCost(), room1.getArea()));
        }
        else
        {
            System.out.println("Invalid Dimensions");
            JOptionPane.showMessageDialog(null, "Invalid Dimensions");
        }
    }
}
