/*



 */
package democandles;

/**
 *
 * @author mark
 */
public class Candle {
    private String Color;
    private double Height;
    protected double Price;
    
    public Candle(String color, double height){
        Color = color;
        Height = height;
        Price = setPrice();
    }
    private double setPrice(){
        return (Height * 2);
    }
    
    public String getColor(){
        return Color;
    }
    public double getHeight(){
        return Height;
    }
    public double getPrice(){
        return Price;
    }
    public void DisplayCandle(){
        System.out.println("Color:  " + Color);
        System.out.println("Height: " + Height + "in");
        System.out.println(String.format("Price:  $%.2f", Price));
    }
}
