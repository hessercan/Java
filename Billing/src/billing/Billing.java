/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billing;

/**
 *
 * @author mark
 */
public class Billing {
    double Price;
    double Quantity;
    double Coupon;
    double Total;
    final private double tax = .08;
    
    public Billing(double price) {
        this.Price = price;
        this.Quantity = 1;
        this.Coupon = 0;
        this.Total = computeBill();
    }
    
    public Billing(double price, double quantity){
        this.Price = price;
        this.Quantity = quantity;
        this.Coupon = 0;
        this.Total = computeBill();
    }
    
    public Billing(double price, double quantity, double coupon) {
        this.Price = price;
        this.Quantity = quantity;
        this.Coupon = coupon;
        this.Total = computeBill();
    }
    
    private double computeBill() {
        double total = (((Price * Quantity) - Coupon) * (1 + tax));
        return total;
    }   
    
    public double getTotal() {
        return this.Total;
    }
    
}
