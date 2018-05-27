/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jlandmarkframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JLandmarkFrame extends JFrame
{
    BorderLayout layout = new BorderLayout();
    private JButton nb = new JButton("Glacier National Park");
    private JButton sb = new JButton("Everglades");
    private JButton eb = new JButton("Statue of Liberty");
    private JButton wb = new JButton("Grand Canyon");
    private JButton cb = new JButton("Mount Rushmore");
    
    public JLandmarkFrame()
    {
       setLayout(new BorderLayout());
       add(nb, BorderLayout.NORTH);
       add(sb, BorderLayout.SOUTH);
       add(eb, BorderLayout.EAST);
       add(wb, BorderLayout.WEST);
       add(cb, BorderLayout.CENTER);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JLandmarkFrame frame = new JLandmarkFrame();
          frame.setSize(500, 250);
          frame.setVisible(true);
    }
}
