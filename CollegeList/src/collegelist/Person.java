/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegelist;

/**
 *
 * @author mark
 */
import javax.swing.*;
public class Person {
    private final String FirstName, LastName, Street, PhoneNum;
    private final int Zipcode; 
    
   public Person(){
        FirstName = setFirstName();
        LastName = setLastName();
        Street = setStreet();
        Zipcode = setZipcode();
        PhoneNum = setPhoneNum();
    }
    public Person(String fn, String ln, String st, int zip, String phone){
        FirstName = fn;
        LastName = ln;
        Street = st;
        Zipcode = zip;
        PhoneNum = phone;
    }
    
    private String setFirstName(){
        return JOptionPane.showInputDialog(null, "First Name:");
    }
    private String setLastName(){
        return JOptionPane.showInputDialog(null, "Last Name:");
    }
    private String setStreet(){
        return JOptionPane.showInputDialog(null, "Street Address:");
    }
    private int setZipcode(){
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Zipcode:"));
    }
    private String setPhoneNum(){
        return JOptionPane.showInputDialog(null, "XXX-XXX-XXXX", "Phone Number:");
    }
    
    protected String getFirstName(){
        return FirstName;
    }
    protected String getLastName(){
        return LastName;
    }
    protected String getStreet(){
        return Street;
    }
    protected int getZipcode(){
        return Zipcode;
    }
    protected String getPhoneNum(){
        return PhoneNum;
    }
    
    public void DisplayInfo(){
        JOptionPane.showMessageDialog(null, String.format("Name: %s %s \nAddress: %s \nZipcode: %d \nPhone: %s", 
                FirstName, LastName, Street, Zipcode, PhoneNum));
    }
}
