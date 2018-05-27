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
public class Carpet {
    private final double Width;
    private final double Length;
    private final String Quality;
    private double Total;

    public Carpet(double width, double length, String quality){
        Width = width;
        Length = length;
        Quality = quality.toLowerCase();
        setPrice(Quality);
    }

    private void setPrice(String quality){
        final double price;
        if (quality.equals("prime")){
            price = 17;
        } else if (quality.equals("choice")){
            price = 12;
        } else if (quality.equals("standard")){
            price = 10;
        } else {
            price = 0;
        }
        Total = (Length * Width) * price;
    }
    
    public double getWidth(){
        return Width;
    }
    public double getLength(){
        return Length;
    }
    public String getQuality(){
        return Quality;
    }
    public double getTotal(){
        return Total;
    }
    
    
    public String displayResults(){
        final String result;
        if (Total > 0){
            result = String.format("Your carpet, that is %.2fft wide "
                + "and %.2fft long, of %s quality will cost you $%.2f.", 
                Width, Length, Quality, Total);
        } else {
            result = String.format("Your carpet is %.2fft wide and %.2fft long."
                    + "Invalid Quality Selection... "
                    + "\nPlease choose from Prime, Choice, and Standard.", 
                    Width, Length);
        }
        return result;
    }



}
