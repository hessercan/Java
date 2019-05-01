/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package guifinal_markhesser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

/**
 * @author mark
 */
public class GUIFinal extends JFrame implements ActionListener
{
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final String TITLE = "Mark's Pizza";
    
    //Menu
    private JMenuBar mainBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem file_exit = new JMenuItem("Exit");

    //Panels
    private JPanel jP1, jP2, custPane, pizzaPane;

    //Labels
    JLabel titleLbl;
    
    //Customer Info
    JLabel[] custLbls;
    String[] custLblStr;
    
    //Pizza Info
    JLabel sizeLbl = new JLabel("Pizza Size: ");
    JLabel toppingLbl = new JLabel("Topping: ");
    JComboBox<String> pizzaSize = new JComboBox<>();
    JComboBox<String> pizzaToppings = new JComboBox<>();
    double[] pizzaPrice = {0,7,9,11,14};
    double[] toppingsPrice = {0 ,0, 1, 1.5, 1.5, 1, 1, 1, 1};
    double totalPrice = 0;
    JButton calculate = new JButton("Total");
    
    //Destination Radio
    ButtonGroup destination;
    JRadioButton[] destRB;
    String[] destRBStr;
    
    //TextBoxes
    JTextField[] custTxt;
    
    //Order
    JTextField totalTxt;
    Path file = Paths.get(System.getProperty("user.home") 
                + "/Desktop/Order.txt"); 
    String s = "";
    String delimiter = ",";
    
    
    
    //Fonts
    private Font titleFont = new Font("Arial", Font.BOLD, 20);
    
    public GUIFinal()
    {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        createMenus();
        
        createjP1();
        createjP2();

        createFrame();
        addActionListeners();
                
        setVisible(true);      
    }
    
    private void createMenus()
    {
        setJMenuBar(mainBar);
        mainBar.add(fileMenu);
        fileMenu.add(file_exit);
    }
    
   
    
    private void createFrame()
    {
        add(jP1, BorderLayout.NORTH);
        add(jP2, BorderLayout.CENTER);
    }
    
    private void createjP1()
    {
        jP1 = new JPanel(new FlowLayout());
        titleLbl = new JLabel();
        titleLbl.setText(TITLE);
        titleLbl.setFont(titleFont);
        jP1.add(titleLbl);
    }
    
    private void createjP2()
    {
        jP2 = new JPanel(new FlowLayout());
        
        destination = new ButtonGroup();
        destRB = new JRadioButton[3];
        destRBStr = new String[]{"For Here", "To Go", "Delivery"};
        for (int i = 0; i < destRB.length; i++)
        {
            destRB[i] = new JRadioButton(destRBStr[i]);
            destRB[i].addActionListener(this);
            destination.add(destRB[i]);
            jP2.add(destRB[i]);
        }
        destRB[2].setSelected(true);
        
        
        custPane = new JPanel(new GridLayout(6,2));
        custLbls = new JLabel[6];
        custTxt = new JTextField[6];
        custLblStr = new String[]{"Name: ", "Phone Number: ", "Street: ", "City: ", "State: ", "Zipcode: "}; 
        for (int i = 0; i < custLbls.length; i++)
        {
            custLbls[i] = new JLabel(custLblStr[i]);
            custLbls[i].setHorizontalAlignment(JLabel.RIGHT);
            custTxt[i] = new JTextField(14);
            custPane.add(custLbls[i]);
            custPane.add(custTxt[i]);
        }
        jP2.add(custPane);
        
        createPizzaPane();
        jP2.add(pizzaPane);
        
    }
    
    private void createPizzaPane()
    {
        pizzaPane = new JPanel(new GridLayout(3,2));
        totalTxt = new JTextField(14);
        
        pizzaSize.addItem("");
        pizzaSize.addItem("Small");
        pizzaSize.addItem("Medium");
        pizzaSize.addItem("Large");
        pizzaSize.addItem("Extra large");
        
        pizzaToppings.addItem("");
        pizzaToppings.addItem("Cheese");
        pizzaToppings.addItem("Pepperoni");
        pizzaToppings.addItem("Mushroom");
        pizzaToppings.addItem("Green Olives");
        pizzaToppings.addItem("Black Olives");
        pizzaToppings.addItem("Ham");
        pizzaToppings.addItem("Bacon");
        pizzaToppings.addItem("Italian Sausage");
        
        sizeLbl.setHorizontalAlignment(JLabel.RIGHT);
        toppingLbl.setHorizontalAlignment(JLabel.RIGHT);
        
        
        pizzaPane.add(sizeLbl);
        pizzaPane.add(pizzaSize);
        pizzaPane.add(toppingLbl);
        pizzaPane.add(pizzaToppings);
        pizzaPane.add(calculate);
        pizzaPane.add(totalTxt);

    }
    
    private void setDestination()
    {
        if (destRB[0].isSelected() || destRB[1].isSelected())
        {
            custTxt[2].setEditable(false);
            custTxt[3].setEditable(false);
            custTxt[4].setEditable(false);
            custTxt[5].setEditable(false);
            custTxt[2].setText("");
            custTxt[3].setText("");
            custTxt[4].setText("");
            custTxt[5].setText("");
        }
        else if(destRB[2].isSelected())
            for (int i = 0; i < custLbls.length; i++)
            {
                custTxt[i].setEditable(true);
            }
        
    }
    
    private void addActionListeners()    
    {
        file_exit.addActionListener(this);
        destRB[0].addActionListener(this);
        destRB[1].addActionListener(this);
        destRB[2].addActionListener(this);
        calculate.addActionListener(this);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GUIFinal frame = new GUIFinal();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int sizePrice = pizzaSize.getSelectedIndex();
        int itemPrice = pizzaToppings.getSelectedIndex();
        Object source = e.getSource();
        if(source == file_exit)
            System.exit(0);
        if(source == calculate)
        {
            totalPrice = sizePrice + itemPrice;
            totalTxt.setText(String.format(" $%.2f", totalPrice));
            WriteOrder();
        }
        if(source == destRB[0] || source == destRB[1] || source == destRB[2])
            setDestination(); 
    }
    
    //Work in Progress
    private void WriteOrder()
    {
        int psint = pizzaSize.getSelectedIndex();
        int ptint = pizzaToppings.getSelectedIndex();
        
        for (int i = 0; i < custTxt.length; i++)
        {
            s += custTxt[i].getText() + delimiter;
        }
        s += pizzaSize.getItemAt(psint).toString() + delimiter + pizzaToppings.getItemAt(ptint).toString() + delimiter + String.format("$%.2f", totalPrice);
        System.out.println(s);
        byte[] data = s.getBytes();
        OutputStream output = null;
        try
        {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND));
            output.write(data);
            
            output.flush();
            output.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
        s = "";
    }
}
