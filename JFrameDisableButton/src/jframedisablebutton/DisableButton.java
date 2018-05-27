/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jframedisablebutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class DisableButton extends JFrame implements ActionListener
{
        final int FRAME_WIDTH = 200;
        final int FRAME_HEIGHT = 100;
        JButton button = new JButton("Press Me");
        int i;
       
        public DisableButton()
        {
            super("Disable Button");
            
            setSize(FRAME_WIDTH, FRAME_HEIGHT); // sets default height and width
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            add(button);
            button.setVisible(true);
            
            button.addActionListener(this);
            i = 1;
        }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch(i)
        {
            case 8: button.setEnabled(false);
                break;
            default: i++;
                break;
        }
    }
  
}
