/*
 * Mark Hesser
 * HesserCAN
 * www.hessercan.com
 * mark@hessercan.com
 */
package usebook;

/**
 * @author mark
 */
import javax.swing.*;

public class UseBooks
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Book[] books = new Book[10];
        books[0] = new Fiction("After Anna");
        books[1] = new NonFiction("Surely You're Joking, Mr. Feynman!");
        books[2] = new Fiction("Shoot First");
        books[3] = new NonFiction("When Breath Becomes Air");
        books[4] = new Fiction("The Fallen");
        books[5] = new NonFiction("Guns, Germs, and Steel");
        books[6] = new Fiction("The Bean Trees");
        books[7] = new NonFiction("Meditations");
        books[8] = new Fiction("The Hidden Flower");
        books[9] = new NonFiction("A Brief History of Time");

        String info = "";
        for (int i = 0; i < 10; i++)
        {
            books[i].setPrice();
            if (books.length == (i + 1))
            {
                info += (books[i].BookInfo() + "\n");
            }
            else
                info += (books[i].BookInfo() + "\n\n");
        }
        DisplayBookInfo(info);
    }

    static void DisplayBookInfo(String info)
    {
        System.out.println(info);
        JOptionPane.showMessageDialog(null, info, "Book Title", 1);
    }
}
