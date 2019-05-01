/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class OptionsPane extends JFrame implements ActionListener
{
    private final int WIDTH = 300;
    private final int HEIGHT = 400;
    
    private JMenuBar mainBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem file_exit = new JMenuItem("Exit");
    
    public OptionsPane()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        
        setVisible(true);
    }

    public void createMenus()
    {
        setJMenuBar(mainBar);
        mainBar.add(fileMenu);
        fileMenu.add(file_exit);
    }
    
    public void addActionListeners()
    {
        file_exit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == file_exit)
            System.exit(0);
    }
}
