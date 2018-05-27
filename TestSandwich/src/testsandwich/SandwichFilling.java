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
public class SandwichFilling {
    private final String FillingType;
    
    public SandwichFilling(){
        this.FillingType = "egg salad";
    }
    public SandwichFilling(String fillingtype){
        this.FillingType = fillingtype;
    }
    
    public String getFillingType(){
        return FillingType;
    }
}
