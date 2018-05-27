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
public class Student {
    private final int StudentID;
    private double GPA;
    private  String Major;
    private NameAndAddress StudentData;
    
    public Student(int id, double gpa, String major, 
            String first, String last, String street, String city, int zip){
        StudentID = id;
        GPA = gpa;
        Major = major;
        StudentData = new NameAndAddress(first, last, street, city, zip);
    }
    
    //Get Student Stats
    public int getSID(){
        return StudentID;
    }
    public double getGPA(){
        return GPA;
    }
    public String getMajor(){
        return Major;
    }
    
    //Get Student Name and Address
    public String getFirstName(){
        return StudentData.getFirstName();
    }
    public String getLastName(){
        return StudentData.getLastName();
    }
    public String getStreet(){
        return StudentData.getStreet();
    }
    public String getCity(){
        return StudentData.getCity();
    }
    public int getZipcode(){
        return StudentData.getZipcode();
    }
    
}
