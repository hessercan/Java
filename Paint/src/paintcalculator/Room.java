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
public class Room {
    double Length;
    double Width;
    double Height;
    double Area;

    
    public Room(double l, double w, double h) {
        Length = l;
        Width = w;
        Height = h;
        setArea();
    }
    
    private void setArea() {
        Area = (((Height * Width) * 2) + ((Height * Length) * 2));
    }
    
    public double getArea() {
        return Area;
    }
}
