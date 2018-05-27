/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package moviearray;

/**
 * @author mark
 */
public class MovieArray 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Movie[] movies = new Movie[10];
        movies[0] = new Horror("Halloween", 7.8);
        movies[1] = new Romance("Titanic", 7.8);
        movies[2] = new Horror("The Conjuring", 7.5);
        movies[3] = new Romance("The Notebook", 7.9);
        movies[4] = new Horror("IT", 7.5);
        movies[5] = new Romance("Love Actually", 7.6);
        movies[6] = new Horror("The Exorcist", 8);
        movies[7] = new Romance("When Harry Met Sally...", 7.6);
        movies[8] = new Horror("The Shining", 8.4);
        movies[9] = new Romance("Breakfast at Tiffany's", 7.7);
        
        String info = "";
        for (int i = 0; i < movies.length; i++)
        {
            if (movies.length == (i + 1))
                info += movies[i].toString() + "\n";
            else
                info += movies[i].toString() + "\n\n";
        }
        DisplayInfo(info);
    }
    
    static void DisplayInfo(String info)
    {
        System.out.println(info);
    }
}
