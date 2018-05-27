/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demohorses;

/**
 *
 * @author mark
 */
public class Horse {
    private final String Name;
    private final String Color;
    private final int BirthYear;
    
    public Horse(String name, String color, int year){
        Name = name;
        Color = color;
        BirthYear = year;
    }
    
    public String getName(){
        return Name;
    }
    public String getColor(){
        return Color;
    }
    public int getBirthYear(){
        return BirthYear;
    }
    
    public void Display(){
        System.out.println("Horse Name: " + Name);
        System.out.println("Color: " + Color);
        System.out.println("Birth Year: " + BirthYear);
    }
}
