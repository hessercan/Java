/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package createbuildings;

/**
 * @author mark
 */
public class School extends Building
{
    private final int classRooms;
    private final String gradeLevel;
    
    /**
     * @param sf
     * @param st
     * @param cr
     * @param gl
     * Default Elementary
        * 1 for Elementary, 
        * 2 for Middle School, 
        * 3 for High School 
    */
    public School(double sf, int st, int cr, int gl) 
    {
        super(sf, st);
        classRooms = cr;
        
        switch (gl)
        {
            case 1:
                gradeLevel = "Elementary School";
                break;
            case 2:
                gradeLevel = "Middle School";
                break;
            case 3:
                gradeLevel = "High School";
                break;
            default:
                gradeLevel = "Elementary School";
                break;
        }      
    }
    
    public int getNumClassRooms()
    {
        return classRooms;
    }

    public String getGradeLevel()
    {
        return gradeLevel;
    }
    @Override
    public String toString()
    {
        return String.format("%s \n%.2f SqFt \n%d Stories \n%d Class Rooms", 
                gradeLevel, super.getSqFt(), super.getStories(), classRooms);
    }
}
