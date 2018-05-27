/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintcalculator;

import javax.swing.JOptionPane;

/**
 *
 * @author mark
 */
public class Paint {
    private final double PaintCan = 350;
    private final double PriceperCan = 32;
    private double Area;
    double TotalCost;
    boolean isValid;
    
    public Paint(double area) {
        if (area > 0) {
            Area = area;
            isValid = true;
            setTotalCost();
        }
        else {
            isValid = false;
            TotalCost = 0;
        }
    }
    
    public void setTotalCost() {
        TotalCost = (Math.ceil(Area / PaintCan) * PriceperCan);
    }
    
    public double getTotalCost() {
        return TotalCost;
    }
}
