/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jcolorframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JColorFrame extends JFrame implements ActionListener
{
    private JButton btn1 = new JButton("Click Here");
    private JButton btnNorth = new JButton("North");
    private JButton btnSouth = new JButton("South");
    private JButton btnEast = new JButton("East");
    private JButton btnWest = new JButton("West");
    
    public JColorFrame()
    {
        setLayout(new BorderLayout());
        setSize(300, 300);
        
        add(btn1, BorderLayout.CENTER);
        add(btnNorth, BorderLayout.NORTH);
        add(btnSouth, BorderLayout.SOUTH);
        add(btnEast, BorderLayout.EAST);
        add(btnWest, BorderLayout.WEST);
        
        btnNorth.setOpaque(true);
        btnSouth.setOpaque(true);
        btnEast.setOpaque(true);
        btnWest.setOpaque(true);
        btn1.setOpaque(true);
        
        btnNorth.setBackground(Color.WHITE);
        btnSouth.setBackground(Color.WHITE);
        btnEast.setBackground(Color.WHITE);
        btnWest.setBackground(Color.WHITE);
        btn1.setBackground(Color.YELLOW);
        
        btnNorth.setEnabled(false);
        btnSouth.setEnabled(false);
        btnEast.setEnabled(false);
        btnWest.setEnabled(false);
        
        btn1.addActionListener(this);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int region = (int)(Math.random() * 4) + 1;
        if(e.getSource() == btn1)
        {
            switch (region)
            {
                case 1:
                    btnNorth.setBackground(Color.RED);
                    btnSouth.setBackground(Color.WHITE);
                    btnEast.setBackground(Color.WHITE);
                    btnWest.setBackground(Color.WHITE);
                    break;
                case 2:
                    btnNorth.setBackground(Color.WHITE);
                    btnSouth.setBackground(Color.GREEN);
                    btnEast.setBackground(Color.WHITE);
                    btnWest.setBackground(Color.WHITE);
                    break;
                case 3:
                    btnNorth.setBackground(Color.WHITE);
                    btnSouth.setBackground(Color.WHITE);
                    btnEast.setBackground(Color.BLUE);
                    btnWest.setBackground(Color.WHITE);
                    break;
                case 4:
                    btnNorth.setBackground(Color.WHITE);
                    btnSouth.setBackground(Color.WHITE);
                    btnEast.setBackground(Color.WHITE);
                    btnWest.setBackground(Color.CYAN);
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JColorFrame frame = new JColorFrame();
        frame.setVisible(true);
    }
}
