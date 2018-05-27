/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birdsighting;

/**
 *
 * @author mark
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Bird {

    //Sets Date Format
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    //Initilizes the Calendar
    private final Calendar c = Calendar.getInstance();
    
    private final String Species;
    private String Date;
    
    public Bird() {
        Species = "robin";
        this.setDate(0);
    }

    public Bird(String species, int day) {
        this.Species = species;
        this.setDate(day);
    }
    
    private void setDate(int day) {
        c.setTime(new Date(118,0,1)); //Sets Date to to January 1, 2018
        c.add(Calendar.DATE, day); //Adds number of days to date
        this.Date = sdf.format(c.getTime()); //Sets Date in String format
        
    }
    
    public String getSpecies(){
        return Species;
    }
    
    public String getDate(){
        return Date;
    }

}
