/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegelist;

import javax.swing.JOptionPane;

/**
 *
 * @author mark
 */
public class CollegeEmployee extends Person {
   private final String SSN, Dept;
   private final double Salary;

   public CollegeEmployee(){
       super();
       SSN = setSSN();
       Salary = setSalary();
       Dept = setDept();
   }
   public CollegeEmployee(String fn, String ln, String st, int zip, String phone, 
           String ssn, double salary, String dept)
   {
       super(fn, ln, st, zip, phone);
       SSN = ssn;
       Salary = salary;
       Dept = dept;
   }
   private String setSSN(){
       return JOptionPane.showInputDialog(null, "SSN: ");
    
   }
   private double setSalary(){
       return Double.parseDouble(JOptionPane.showInputDialog(null, "Annual Salary: "));
   }
   private String setDept(){
       return JOptionPane.showInputDialog(null, "Department: ");
   }
   public String getSSN(){
       return SSN;
    
   }
   public double getSalary(){
       return Salary;
   }
   public String getDept(){
       return Dept;
   }
   
   @Override
   public void DisplayInfo(){ 
       JOptionPane.showMessageDialog(null, String.format("Name: %s %s \nAddress: %s \nZipcode: %d \nPhone: %s \n\nSSN: %s \nSalary: $%.2f \nDept: %s", 
               getFirstName(), getLastName(), getStreet(), getZipcode(), getPhoneNum(), SSN, Salary, Dept));
       
   }
}
