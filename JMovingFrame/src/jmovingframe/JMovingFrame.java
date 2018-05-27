/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jmovingframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JMovingFrame extends JFrame implements ActionListener
{
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    int count;
    
    JButton btn1 = new JButton("Move Label");
    
    JLabel lbl1 = new JLabel("I can move!");
    
    public JMovingFrame()
    {
        setTitle("Moving Label");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(200, 100);
        
        count = 0;
        
        panel2.add(lbl1);
        panel1.add(lbl1);
        panel3.add(btn1);
        
        add(panel1, BorderLayout.WEST);
        add(panel2, BorderLayout.EAST);
        add(panel3, BorderLayout.SOUTH);
        
        btn1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(count % 2 == 0)
        {
            panel1.setVisible(false);
            panel2.setVisible(true);
            panel2.add(lbl1);
            count++;
        }
        else
        {
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel1.add(lbl1);
            count++;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JMovingFrame frame = new JMovingFrame();
        frame.setVisible(true);
    }


}
