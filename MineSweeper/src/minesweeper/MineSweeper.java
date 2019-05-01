/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package minesweeper;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class MineSweeper extends JFrame implements ActionListener
{
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private GridLayout mineGrid;
    
    //Main Menu
    private JMenuBar mainBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem file_newgame = new JMenuItem("New Game");
    private JMenuItem file_exit = new JMenuItem("Exit");
    private JMenuItem file_options = new JMenuItem("Options");
    
    private JPanel jP1 = new JPanel();
    private JPanel jP2 = new JPanel();
    private JPanel jP3 = new JPanel();
    
    //HUD
    private GridBagLayout hudLayout;
    private GridBagConstraints hudGBC;
    private int[][] hudConst;
    private JPanel[] HUD;
    private JLabel[] hudTimer;
    
    //Game Board
    protected int gridLength = 10;
    protected JButton[][] gameBtns;
    private boolean[][] hasMineE, hasMineN, hasMineH, hasMine;
    private ArrayList<Integer> X, Y;
    private int iCount; // indicator count
    private int[][] indicators;
    private Font iFont = new Font("Arial",Font.BOLD,18);
    
    //Timer
    private class Timer extends Thread 
    {
        @Override
        public void run() 
        {
            startTime = System.currentTimeMillis();
            do  
            {
                long elapsedTime = System.currentTimeMillis() - startTime;
                long elapsedSeconds = elapsedTime / 1000;  // to seconds conversion 
                hudTimer[1].setText(Long.toString(elapsedSeconds));  // update timer
            } while(firstClick == false); // stop condition            
        }
    }
    private boolean firstClick = true;
    private long startTime;
    private long elapsedSeconds;
    
    public MineSweeper()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        
        mineGrid = new GridLayout(5, 5);
        
        createMenus();
        addActionListeners();
  
        setVisible(true);
    }
    
    private void createMenus()
    {
        setJMenuBar(mainBar);
        mainBar.add(fileMenu);
        fileMenu.add(file_newgame);
        fileMenu.add(file_options);
        fileMenu.add(file_exit);
    }
    
    private void createGameBoard()
    {
        
    }
    
    private void addActionListeners()
    {
        file_newgame.addActionListener(this);
        file_options.addActionListener(this);
        file_exit.addActionListener(this);
    }
    
    private void NewGame()
    {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == file_newgame)
            NewGame();
        
        if(source == file_exit)
            System.exit(0);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MineSweeper game = new MineSweeper();
    }
}
