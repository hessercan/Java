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
public class Bread {
    private final String BreadType;
    
    public Bread(){
        this.BreadType = "white";
    }
    
    public Bread(String breadtype){
        this.BreadType = breadtype;
    }
    
    public String getBreadType(){
        return BreadType;
    }
    
}
