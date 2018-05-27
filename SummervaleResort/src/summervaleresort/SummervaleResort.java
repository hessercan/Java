/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package summervaleresort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class SummervaleResort extends JFrame implements ActionListener
{
    //Declarations
    //Strings
    private final String TITLE = "Summervale Resort";
    private final String COPYRIGHT = "© HesserCAN";
    private final String ROOM_SUITE_STR = "3 Bedroom Suites include Fully Loaded Kitchen @ $229/night";
    private final String ROOM_SINGLE_STR = "Singles include King Size and Sofa Bed @ $149/night";
    private final String DINE_REST_STR = "Today's Special is Steak with Mashed Potatoes - $14.99";
    private final String DINE_CAFE_STR = "Free Coffee to All Guests Sunday from 6AM to 10AM";
    private final String DINE_BAR_STR = "Karaoke Tonight, featuring $5 Monkey Boys until Midnight";
    private final String ACT_FISH_STR = "Fishing Equipment Rental available @ $9.99/hour";
    private final String ACT_SKI_STR = "Ski Rentals @ $7/hour or 50/day, Open 11AM to 10PM";
    private final String ACT_BOWL_STR = "Bowling Games @ $4/person, Shoe Rental @ $3/person";
    
    //Integars
    private final int WIDTH = 650;
    private final int HEIGHT = 200;    
    
    //Main Menu Bar
    private JMenuBar mainMenuBar = new JMenuBar();
    
    //Menus
    private final JMenu fileMenu = new JMenu("File");
    private final JMenu roomsMenu = new JMenu("Rooms");
    private final JMenu diningMenu = new JMenu("Dining");
    private final JMenu actMenu = new JMenu("Activities");
    
    //Menu Items
    //file
    private final JMenuItem file_Exit = new JMenuItem("Exit");
    //rooms
    private final JMenuItem room_Suite = new JMenuItem("Suite");
    private final JMenuItem room_Single = new JMenuItem("Single");
    //dining
    private final JMenuItem dine_Rest = new JMenuItem("Restaurant");
    private final JMenuItem dine_Cafe = new JMenuItem("Cafe");
    private final JMenuItem dine_Bar = new JMenuItem("Bar");
    //activities
    private final JMenuItem act_Fish = new JMenuItem("Fishing");
    private final JMenuItem act_Ski = new JMenuItem("Skiing");
    private final JMenuItem act_Bowl = new JMenuItem("Bowling");
    
    //Labels
    private JLabel title = new JLabel(TITLE);
    private JLabel info = new JLabel("");
    private JLabel copyright = new JLabel(COPYRIGHT);
    
    //Panels
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    
    //Fonts
    private Font title_Font = new Font("Courier New", Font.BOLD, 32);
    private Font info_Font = new Font("Courier New", Font.ITALIC, 16);
    private Font copyright_Font = new Font("Courier New", Font.PLAIN, 12);
     
    //Default Constructor
    public SummervaleResort()
    {
        setTitle(TITLE);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        
        //Create Menus
        createMenus();
        
        //Add Action Listeners
        addActionListeners();
        
        //add panels to regions
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        
        //panel1
        panel1.add(title);
        title.setLayout(new FlowLayout());
        title.setFont(title_Font);
        
        //panel2
        panel2.add(info);
        info.setLayout(new FlowLayout());
        info.setFont(info_Font);
        
        //panel3
        panel3.add(copyright);
        copyright.setLayout(new FlowLayout());
        copyright.setFont(copyright_Font);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        //File
        if(source == file_Exit)
            System.exit(0);
        //Rooms
        else if(source == room_Suite)
            info.setText(ROOM_SUITE_STR);
        else if(source == room_Single)
            info.setText(ROOM_SINGLE_STR);
        //Dining
        else if(source == dine_Rest)
            info.setText(DINE_REST_STR);
        else if(source == dine_Cafe)
            info.setText(DINE_CAFE_STR);
        else if(source == dine_Bar)
            info.setText(DINE_BAR_STR);
        //Activities
        else if(source == act_Fish)
            info.setText(ACT_FISH_STR);
        else if(source == act_Ski)
            info.setText(ACT_SKI_STR);
        else if(source == act_Bowl)
            info.setText(ACT_BOWL_STR);   
    }
    
    public void createMenus()
    {
        setJMenuBar(mainMenuBar);
        //Add main menu items
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(roomsMenu);
        mainMenuBar.add(diningMenu);
        mainMenuBar.add(actMenu);
        //Add file items
        fileMenu.add(file_Exit);
        //Add room items
        roomsMenu.add(room_Suite);
        roomsMenu.add(room_Single);
        //Add dining items
        diningMenu.add(dine_Rest);
        diningMenu.add(dine_Cafe);
        diningMenu.add(dine_Bar);
        //Add activities items
        actMenu.add(act_Fish);
        actMenu.add(act_Ski);
        actMenu.add(act_Bowl);
    }
    
    public void addActionListeners()
    {
        file_Exit.addActionListener(this);
        room_Suite.addActionListener(this);
        room_Single.addActionListener(this);
        dine_Rest.addActionListener(this);
        dine_Cafe.addActionListener(this);
        dine_Bar.addActionListener(this);
        act_Fish.addActionListener(this);
        act_Ski.addActionListener(this);
        act_Bowl.addActionListener(this);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        SummervaleResort frame = new SummervaleResort();
        frame.setVisible(true);
    }
}
