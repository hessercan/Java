/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usebook;

/**
 *
 * @author mark
 */
public abstract class Book {
    protected final String Title;
    protected double Price;
    
    public Book(String t){
        Title = t;
    }
    public String getTitle(){
        return Title;
    }
    public double getPrice(){
        return Price;
    }
    abstract void setPrice();
    public String BookInfo()
        {
            return String.format("Book Title: %s \nPrice: $%.2f", Title, Price);
        }
}
