/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package createdormfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*; 

/**
 * @author mark
 */
public class CreateDormFile extends JFrame implements ActionListener
{
    //Declarations
    //Strings
    private final String TITLE = "Dorm Information";
    private final String COPYRIGHT = "© HesserCAN";

    //Window Size
    private final int WIDTH = 300;
    private final int HEIGHT = 250;    
    
    //Main Menu Bar
    private JMenuBar mainMenuBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem file_exit = new JMenuItem("Exit");
    private final JMenuItem file_save = new JMenuItem("Save");
    
    //Panels
    private JPanel header = new JPanel();
    private JPanel footer = new JPanel();
    private JPanel body = new JPanel();
    
    //Labels
    private JLabel title = new JLabel(TITLE);
    private JLabel copyright = new JLabel(COPYRIGHT);
    private JLabel idlbl = new JLabel("Room Number: ");
    private JLabel fnlbl = new JLabel("First Name: ");
    private JLabel lnlbl = new JLabel("Last Name: ");
    
    //TextBoxes
    private JTextField idtxt = new JTextField(12);
    private JTextField fntxt = new JTextField(14);
    private JTextField lntxt = new JTextField(14);
    
    //Buttons
    private JButton savebtn = new JButton("Save");
    
    //Fonts
    private Font title_Font = new Font("Courier New", Font.BOLD, 20);
    private Font copyright_Font = new Font("Courier New", Font.PLAIN, 12);
    
    //Save
    private String s = "";
    private final String delimiter = ",";
    private Path file = Paths.get(System.getProperty("user.home") 
            + "/Desktop/Dorms.txt");
    
    public CreateDormFile()
    {
        setLayout(new BorderLayout());
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        idtxt.setText("1");
        add(header, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);
        add(body, BorderLayout.CENTER);
        
        createMenu();
        createBody();
        addActionListeners();
        addHeaderFooter();
        setVisible(true);
    }
    
    public void createMenu()
    {
        setJMenuBar(mainMenuBar);
        mainMenuBar.add(fileMenu);
        fileMenu.add(file_save);
        fileMenu.add(file_exit);
    }
    
    public void createBody()
    {
        //body.setLayout(new FlowLayout());
        body.add(idlbl);
        body.add(idtxt);
        body.add(fnlbl);
        body.add(fntxt);
        body.add(lnlbl);
        body.add(lntxt);
        body.add(savebtn);
    }
    
    public void addActionListeners()
    {
        file_save.addActionListener(this);
        file_exit.addActionListener(this);
        savebtn.addActionListener(this);
    }
    
    public void addHeaderFooter()
    {
        header.add(title);
        title.setLayout(new FlowLayout());
        title.setFont(title_Font);
        
        footer.add(copyright);
        copyright.setLayout(new FlowLayout());
        copyright.setFont(copyright_Font);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == file_exit)
            System.exit(0);
        else if(source == file_save || source == savebtn)
        {
            try
            {
                int roomNum = Integer.parseInt(idtxt.getText());
                if(roomNum < 1 || roomNum > 99)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid room number between 1 and 99.", "Invalid Room Number", 2);   
                    idtxt.requestFocusInWindow();
                }
                else if(fntxt.getText().isEmpty() || lntxt.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please enter the Students First and Last Name. "
                            + "\nAll Fields are required and cannot be left blank.", "Invalid Name", 2);
                    fntxt.requestFocusInWindow();
                }
                else 
                {
                    SaveDormFile(roomNum, fntxt.getText(), lntxt.getText());
                    roomNum++;
                    idtxt.setText("" + roomNum);
                    fntxt.setText("");
                    lntxt.setText("");
                    fntxt.requestFocusInWindow();
                } 
            }
            catch(NumberFormatException enumformat)
            {
                JOptionPane.showMessageDialog(null, "Room Number must only contain Numbers and cannot be blank. "
                        + "\nPlease enter a valid room number between 1 and 99.", "Invalid Room Number", 2);   
                    idtxt.requestFocusInWindow();
            }
            catch(HeadlessException eheadless)
            {
                System.out.println("Message: " + eheadless); 
            }
                
        }
        else
            System.out.println("Error!");
    }
    
    public void SaveDormFile(int id, String fn, String ln)
    {
        try
        {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            s = id + delimiter + fn + delimiter + ln;
            writer.write(s, 0, s.length());
            writer.newLine();
            writer.flush();
            writer.close();
            output.flush();
            output.close();
        }
        catch(IOException e3)
        {
            System.out.println("Message: " + e3); 
        }       
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        CreateDormFile frame = new CreateDormFile();
    }
}
