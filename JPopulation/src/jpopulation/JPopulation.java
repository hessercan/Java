/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jpopulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/**
 * @author mark
 */
public class JPopulation extends JFrame implements ItemListener
{
    FlowLayout flow = new FlowLayout();
    
    JComboBox<String> cityMenu = new JComboBox<>();
    
    JLabel populationLabel = new JLabel("Population: ");
    JLabel cityPopLabel = new JLabel();
    
    String[] cityList = {"", "Philadelphia", "Pittsburgh", "Allentown", "Erie", 
        "Reading", "Lancaster", "Harrisburg", "Altoona", "York", "State College"};
    double[] cityPop = {0, 1526006, 305704, 118032, 101786, 88082, 
        59322, 49528, 46320, 43718, 42034};
    
    DecimalFormat df = new DecimalFormat("#,###");
    
    public JPopulation()
    {
        super("JPopulation");
        setLayout(flow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 150);
        
        cityMenu.addItemListener(this);
        
        for (String item : cityList)
        {
            cityMenu.addItem(item);
        }
        
        add(cityMenu);
        add(populationLabel);
        add(cityPopLabel);
    }
    
    @Override
    public void itemStateChanged(ItemEvent event)    
    {
        Object source = event.getSource();
        int cityIndex = cityMenu.getSelectedIndex();
        
        if (source == cityMenu)
        {
            cityPopLabel.setText(df.format(cityPop[cityIndex]));
        }
    }
    
    public static void main(String[] args) 
    {
        JPopulation frame = new JPopulation();
        frame.setVisible(true);
    }
}
