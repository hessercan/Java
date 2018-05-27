/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teststudent;

/**
 *
 * @author mark
 */
public class NameAndAddress {
    private String FirstName;
    private String LastName;
    private String Street;
    private String City;
    private int Zipcode;
    
    public NameAndAddress(String first, String last, 
            String street, String city, int zip){
        FirstName = first;
        LastName = last;
        Street = street;
        City = city;
        Zipcode = zip;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getStreet(){
        return Street;
    }
    public String getCity(){
        return City;
    }
    public int getZipcode(){
        return Zipcode;
    }
    
    
    
}
