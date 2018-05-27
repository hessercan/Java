/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegelist;

import javax.swing.*;

/**
 *
 * @author mark
 */
public class Faculty extends CollegeEmployee{
    private boolean Tenured;
    
    public Faculty(){
       super();
       int option = JOptionPane.showConfirmDialog(null, "Is the Faculty Member Tenured?", "Faculty",                  
               JOptionPane.YES_NO_OPTION);
       Tenured = option == 0;
    }
    public Faculty(String fn, String ln, String st, int zip, String phone, 
           String ssn, double salary, String dept, int tenure)
    {
       super(fn, ln, st, zip, phone, ssn, salary, dept);
       Tenured = tenure == 0;
    }
    @Override
    public void DisplayInfo(){ 
        String isTenured;
        if (Tenured)
            isTenured = "Yes";
        else 
            isTenured = "No";
            
        JOptionPane.showMessageDialog(null, String.format("Name: %s %s \nAddress: %s \nZipcode: %d \nPhone: %s \n\nSSN: %s \nSalary: $%.2f \nDept: %s \n\nTenured: %s", 
               getFirstName(), getLastName(), getStreet(), getZipcode(), getPhoneNum(), getSSN(), getSalary(), getDept(), isTenured));
       
   }
}
