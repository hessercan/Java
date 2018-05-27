/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircle;

/**
 *
 * @author mark
 */
public class Circle {
    private double Radius;
    private double Diameter;
    private double Area;
    private double Circumference;
    
    public Circle() {
        setRadius(1);
    }
    
    public Circle(double r) {
        setRadius(r);
    }
    
    private void setRadius(double r){
        Radius = r;
        setDiameter();
        setArea();
        setCircumference();
    }
    public double getRadius(){
        return Radius;
    }
    
    private void setDiameter() {
        Diameter = Radius * 2;
    }
    
    public double getDiameter() {
        return Diameter;
    }
    
    private void setArea() {
        Area = Math.PI * Math.pow(Radius, 2);
    }
    
    public double getArea() {
        return Area;
    }
    
    private void setCircumference(){
        Circumference = (2 * Math.PI * Radius);
    }
    
    public double getCircumference() {
        return Circumference;
    }
}
