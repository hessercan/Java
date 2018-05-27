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
public class TestCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(4);
        Circle circle3 = new Circle(34);
        
        System.out.println(String.format("If the Radius of the Circle is %.2f "
                + "\nThe Diameter is %.2f \nThe Area is %.2f and the Circumference is %.2f",
                circle1.getRadius(), circle1.getDiameter(), circle1.getArea(), circle1.getCircumference()));
        System.out.println(String.format("If the Radius of the Circle is %.2f "
                + "\nThe Diameter is %.2f \nThe Area is %.2f and the Circumference is %.2f",
                circle2.getRadius(), circle2.getDiameter(), circle2.getArea(), circle2.getCircumference()));
        System.out.println(String.format("If the Radius of the Circle is %.2f "
                + "\nThe Diameter is %.2f \nThe Area is %.2f and the Circumference is %.2f",
                circle3.getRadius(), circle3.getDiameter(), circle3.getArea(), circle3.getCircumference()));        
    }
    
}
