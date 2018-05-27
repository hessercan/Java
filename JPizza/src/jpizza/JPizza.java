/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jpizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JPizza extends JFrame implements ItemListener
{
    FlowLayout flow = new FlowLayout();
    
    JComboBox<String> itemMenu = new JComboBox<>();
    JComboBox<String> pizzaSize = new JComboBox<>();
    
    JLabel items = new JLabel("Item Menu");
    JLabel sizes = new JLabel("Pizza sizes");
    JLabel title = new JLabel("Mark's Pizza");
    
    JTextField totalFees = new JTextField(25);
    JTextField totalFees2 = new JTextField(25);
    JTextField totalFees3 = new JTextField(25);
    
    double[] fees = {0,7,9,11,14};
    double[] fees2 = {0 ,0, 1, 1.5, 1.5, 1, 1, 1, 1};
    double sizePrice = 0;
    double fee = 0;
    double fee2 = 0;
    double totalPrice = 0;
    
    String output;
    String output2;
    String output3;
    String msg = new String("  Size: ");
    String msg2 = new String("  Topping: ");
    String msg3 = new String("  Total: ");

    public JPizza()
    {
        super("Mark's Pizza");
        setLayout(flow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemMenu.addItemListener(this);
        pizzaSize.addItemListener(this);
        add(title);
        add(items);
        add(itemMenu);
        add(sizes);
        add(pizzaSize);
        itemMenu.addItem("");
        itemMenu.addItem("Cheese");
        itemMenu.addItem("Pepperoni");
        itemMenu.addItem("Mushroom");
        itemMenu.addItem("Green Olives");
        itemMenu.addItem("Black Olives");
        itemMenu.addItem("Ham");
        itemMenu.addItem("Bacon");
        itemMenu.addItem("Italian Sausage");
        pizzaSize.addItem("");
        pizzaSize.addItem("Small");
        pizzaSize.addItem("Medium");
        pizzaSize.addItem("Large");
        pizzaSize.addItem("Extra large");
        add(totalFees);
        add(totalFees2);
        add(totalFees3);
    }
    
    @Override
    public void itemStateChanged(ItemEvent event)
    {
        int sizePrice = pizzaSize.getSelectedIndex();
        int itemPrice = itemMenu.getSelectedIndex();
        Object source = event.getSource();

        if(source == pizzaSize)
        {
            fee = fees[sizePrice];
            String s1 = java.text.NumberFormat.getCurrencyInstance().format(fee);
            output = msg+ " " +s1;
            totalFees.setText(output);
        }

        if(source == itemMenu)
        {
            fee2 = fees2[itemPrice];

            String s2 = java.text.NumberFormat.getCurrencyInstance().format(fee2);
            output2 = msg2+ " " +s2;
            totalFees2.setText(output2);
        }

        totalPrice = fee + fee2;
        String s3 = java.text.NumberFormat.getCurrencyInstance().format(totalPrice);
        output3 = msg3+ " " +s3;
        totalFees3.setText(output3);
    }
    
    public static void main(String[] args) 
    {
        JFrame aFrame = new JPizza();
        aFrame.setSize(300, 200);
        aFrame.setVisible(true);
    }
}
