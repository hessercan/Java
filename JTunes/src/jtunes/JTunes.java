/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jtunes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author mark
 */
public class JTunes extends JFrame implements ItemListener
{
    int songNum, songPrice;
    int[] songAmount = {0,2,4,7,5,3,2,5,6,11,13,5,4};
    String result;
    
    JComboBox tunes;
    JLabel labelTunes = new JLabel("Song List");
    JLabel output = new JLabel();
    
    FlowLayout layout = new FlowLayout();
    
    public JTunes()
    {
        super("JTunes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        
        tunes = new JComboBox();
        tunes.setEditable(true);
        
        tunes.addItem("");
        tunes.addItem("Song 1");
        tunes.addItem("Song 2");
        tunes.addItem("Song 3");
        tunes.addItem("Song 4");
        tunes.addItem("Song 5");
        tunes.addItem("Song 6");
        tunes.addItem("Song 7");
        tunes.addItem("Song 8");
        tunes.addItem("Song 9");
        tunes.addItem("Song 10");
        tunes.addItem("Song 11");
        tunes.addItem("Song 12");
        tunes.addItemListener(this);
        
        panel.add(labelTunes);
        panel.add(tunes);
        
        panel.add(output);
        
        setContentPane(panel);
    }
   
    public void itemStateChanged(ItemEvent e)
    {
        Object source = e.getSource();
        
        if (source == tunes)
        {
            songNum = tunes.getSelectedIndex();
            songPrice = songAmount[songNum];
            result = "Total Price $" + songPrice;
            
            output.setText(result);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JTunes frame = new JTunes();
        frame.setSize(200,150);
        frame.setVisible(true);
    }
}
