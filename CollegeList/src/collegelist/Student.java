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
public class Student extends Person {
    private final String Major, GPA;
    
    public Student(){
        super();
        Major = setMajor();
        GPA = setGPA();
    }
    public Student(String fn, String ln, String st, int zip, String phone, String major, String gpa){
        super(fn, ln, st, zip, phone);
        Major = major;
        GPA = gpa;
    }
    
    private String setMajor(){
        return JOptionPane.showInputDialog(null, "Major: ");
    }
    private String setGPA(){
        return JOptionPane.showInputDialog(null, "X.X", "GPA: ");
    }
    public String getMajor(){
        return Major;
    }
    public String getGPA(){
        return GPA;
    }
      
    @Override
    public void DisplayInfo(){
        JOptionPane.showMessageDialog(null, String.format("Name: %s %s \nAddress: %s \nZipcode: %d \nPhone: %s \n\nMajor: %s \nGPA: %s", 
                getFirstName(), getLastName(), getStreet(), getZipcode(), getPhoneNum(), Major, GPA));
    }
}
