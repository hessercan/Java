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
public class RaceHorse extends Horse
{
    private final int NumRaces;
    
    public RaceHorse(String name, String color, int year, int races){
        super(name, color, year);
        NumRaces = races;
    }
    
    public int getNumRaces(){
        return NumRaces;
    }
    
    public void Display(){
        super.Display();
        System.out.println("Number of Races Completed: " + NumRaces);
    }
}
