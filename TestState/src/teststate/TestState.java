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
public class TestState {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        State PA = new State("PA", 12810482, "Harrisburg", 48904, "Philadelphia", 15680000);
        
        System.out.println("State Name: " + PA.getName());
        System.out.println("State Population: " + PA.getPopulation());
        System.out.println("Capital City: " + PA.getCapName());
        System.out.println("Capital Population: " + PA.getCapPop());
        System.out.println("Most Populous City: " + PA.getBigName());
        System.out.println("City Population: " + PA.getBigPop());

    }
    
}
