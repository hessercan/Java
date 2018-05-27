/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democandles;

/**
 *
 * @author mark
 */
public class ScentedCandle extends Candle {
    private String Scent;
    
    public ScentedCandle(String color, double height, String scent){
        
        super(color, height);
        super.Price = setPrice();
        Scent = scent;
    }
    
    private double setPrice(){
        return (super.getHeight() * 3);
    }
    
    public String getColor(){
        return super.getColor();
    }
    public double getHeight(){
        return super.getHeight();
    }
    public double getPrice(){
        return super.getPrice();
    }
    
    public void DisplayCandle(){
        System.out.println("Color:  " + super.getColor());
        System.out.println("Height: " + super.getHeight() + "in");
        System.out.println(String.format("Price:  $%.2f", super.getPrice()));
        System.out.println("Scent:  " + Scent);
    }
    
}
