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
public class CollegeList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person[] mark = new Person[4];
        mark[0] = new Person("Mark", "Hesser", "141 Tow Hill Rd", 16870, "814-777-7539");
        mark[1] = new CollegeEmployee("Mark", "Hesser", "141 Tow Hill Rd", 16870, "814-777-7539", "123-456-7890", 50000, "IT");
        mark[2] = new Faculty("Mark", "Hesser", "141 Tow Hill Rd", 16870, "814-777-7539", "123-456-7890", 50000, "IT", 1);
        mark[3] = new Student("Mark", "Hesser", "141 Tow Hill Rd", 16870, "814-777-7539", "IT", "3.4");
        for (Person person : mark){
            person.DisplayInfo();
        }
    }
    
}
