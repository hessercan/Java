/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststate;

/**
 *
 * @author mark
 */
public class City {
    private final String Name;
    private final int Population;
    
    public City(String name, int pop){
        Name = name;
        Population = pop;
        
    }
    
    public String getName(){
        return Name;
    }
    public int getPop(){
        return Population;
    }
    
}
