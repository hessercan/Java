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
public class TestPatient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Patient fred = new Patient();
        Patient wilma = new Patient(2, 40, "A", "-");
                
        System.out.println(String.format("ID: %d, Age: %d, Blood Type: %s, Rh Factor: %s", 
                fred.getIDnum(), fred.getAge(), fred.getBloodType(), fred.getRhFactor()));
        System.out.println(String.format("ID: %d, Age: %d, Blood Type: %s, Rh Factor: %s", 
                wilma.getIDnum(), wilma.getAge(), wilma.getBloodType(), wilma.getRhFactor()));
    }
    
}
