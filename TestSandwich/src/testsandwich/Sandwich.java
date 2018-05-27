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
public class Sandwich {
    private final double BasePrice = 4.99;
    private final double PATax = .06;
    private final double Total;
    private final Bread bread;
    private final SandwichFilling filling;
    
    public Sandwich(){
        bread = new Bread();
        filling = new SandwichFilling();
        Total = setPrice(BasePrice, PATax);
    }
    public Sandwich(String breadtype, String fillingtype) {
        this.bread = new Bread(breadtype);
        this.filling = new SandwichFilling(fillingtype);
        Total = setPrice(BasePrice, PATax);
    }
    
    private double setPrice(double baseprice, double tax) {
        double price = (baseprice * (1 + tax));
        return price;
    }
    
    public double getTotal() {
        return Total;
    }
    
    public double getTax() {
        return PATax;
    }
    
    public String getBreadType() {
        return bread.getBreadType();
    }
    
    public String getFillingType() {
        return filling.getFillingType();
    }
    
}
