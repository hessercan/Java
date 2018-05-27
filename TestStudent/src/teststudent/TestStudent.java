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
public class TestStudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student mark = new Student(1, 3.5, "IT", "Mark", "Hesser", 
                "141 Tow Hill Rd", "Port Matilda", 16870);
        
        System.out.println("Student ID: " + mark.getSID());
        System.out.println(String.format("Name: %s %s", 
                mark.getFirstName(), mark.getLastName()));
        System.out.println("Current GPA: " + mark.getGPA());
        System.out.println("Street Address: " + mark.getStreet());
        System.out.println("City: " + mark.getCity());
        System.out.println("Zip: " + mark.getZipcode());  }
    
}
