/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jfontselector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JFontSelector extends JFrame implements ActionListener
{
    final int SMALL = 12;
    final int LARGE = 24;
    int size = SMALL;
    
    JButton btnArial = new JButton("Arial");
    JButton btnCentury = new JButton("Century");
    JButton btnHelvetica = new JButton("Helvetica");
    JButton btnCalibri = new JButton("Calibri");
    JButton btnTimes = new JButton("Times");
    JButton btnSize = new JButton("Resize");
    JLabel label = new JLabel("Example Text");
    
    Font arial = new Font("Arial", Font.PLAIN, size);
    Font century = new Font("Century", Font.PLAIN, size);
    Font helvetica = new Font("Helvetica", Font.PLAIN, size);
    Font calibri = new Font("Calibri", Font.PLAIN, size);
    Font times = new Font("Times", Font.PLAIN, size);
    Font myFont = arial;
    
    boolean isSmaller = true;

    public JFontSelector()
    {
        super("");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 180);
        
        add(btnArial);
        add(btnCentury);
        add(btnHelvetica);
        add(btnCalibri);
        add(btnTimes);
        add(btnSize);
        add(label);
        label.setFont(arial);
        
        btnArial.addActionListener(this);
        btnCentury.addActionListener(this);
        btnHelvetica.addActionListener(this);
        btnCalibri.addActionListener(this);
        btnTimes.addActionListener(this);
        btnSize.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnArial)
        {
            myFont = arial;
        }
        else if(e.getSource() == btnCentury)
        {
            myFont = century;
        }
        else if(e.getSource() == btnHelvetica)
        {
            myFont = helvetica;
        }
        else if(e.getSource() == btnCalibri)
        {
            myFont = calibri;
        }
        else if(e.getSource() == btnTimes)
        {
            myFont = times;
        }
        else if(e.getSource() == btnSize)
        {
            if(isSmaller)
            {
                myFont = myFont.deriveFont(Font.PLAIN, LARGE);
                isSmaller = false;
            }
            else if(!isSmaller)
            {
                myFont = myFont.deriveFont(Font.PLAIN, SMALL);
                isSmaller = true;
            }
        }
        label.setFont(myFont);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFontSelector frame = new JFontSelector();
        frame.setVisible(true);
    }
}
