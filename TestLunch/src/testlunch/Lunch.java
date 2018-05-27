/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlunch;

/**
 *
 * @author mark
 */
public class Lunch {
    private String Entree;
    private String Side;
    private String Drink;
    
    public Lunch(){
        Entree = "Meat Loaf";
        Side = "Mash Potatoes";
        Drink = "Iced Tea";
    }
    public Lunch(String entree, String side, String drink){
        Entree = entree;
        Side = side;
        Drink = drink;
    }
    
    public String getEntree(){
        return Entree;
    }
    public String getSide(){
        return Side;
    }
    public String getDrink(){
        return Drink;
    }
    
    public void displayLunch(){
        System.out.println("Entree: " + Entree);
        System.out.println("Side:   " + Side);
        System.out.println("Drink:  " + Drink);
    }
}
