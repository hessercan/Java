/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blooddata;

/**
 *
 * @author mark
 */
public class Patient {
    private int IDnum;
    private int Age;
    private String BloodType;
    private String RhFactor;
    
    public Patient(){
        IDnum = 0;
        Age = 1;
        BloodType = "O";
        RhFactor = "+";
    }
    public Patient(int id, int age, String type, String rh){
        this.IDnum = id;
        this.Age = age;
        this.BloodType = type;
        this.RhFactor = rh;
    }
    public int getIDnum(){
        return IDnum;
    }
    public int getAge(){
        return Age;
    }
    public String getBloodType(){
        return BloodType;
    }    
    public String getRhFactor(){
        return RhFactor;
    }
}
