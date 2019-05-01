/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */
package first;

/**
 * @author mark
 */
import java.lang.Math;
public class Circle {
    double Radius;
    double Diameter;
    double Area;
    double Circumference;
    
    public Circle() {
        Radius = 1;
    }
    
    public Circle(double r) {
        Radius = r;
        Diameter = Radius * 2;
    }
    
    public double getArea() {
        Area = Math.PI * Math.pow(Radius, 2);
        return Area;
    }
    
    public double getCircumference() {
        Circumference = (2 * Math.PI * Radius);
        return Circumference;
    }
    
    public void getCircleData() {
        getArea();
        getCircumference();
        
        System.out.println(String.format("If the Radius of the Circle is %.2f.", Radius));
        System.out.println(String.format("The Diameter of the Circle is %.2f.", Diameter));
        System.out.println(String.format("The Area of the Circle is %.2f.", Area));
        System.out.println(String.format("The Circumference of the Circle is %.2f.", Circumference));
    }
}
