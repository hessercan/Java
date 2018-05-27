/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package jvacationrental;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mark
 */
public class JVacationRental extends JFrame implements ItemListener
{
   FlowLayout flow = new FlowLayout();
   final String COMPANY_NAME = "Lambert's Vacation Rentals";
   final int PARKPRICE = 600, POOLPRICE = 750, LAKEPRICE = 825;
   int totalPrice = 0;
   ButtonGroup locationGroup = new ButtonGroup();
   JCheckBox parkBox = new JCheckBox("Parkside",false);
   JCheckBox poolBox = new JCheckBox("Poolside", false);
   JCheckBox lakeBox = new JCheckBox("Lakeside", false);
   final int ONEPRICE = 0, TWOPRICE = 75, THREEPRICE = 150;
   ButtonGroup bedroomGroup = new ButtonGroup();
   JCheckBox oneBox = new JCheckBox("1 bedroom", false);
   JCheckBox twoBox = new JCheckBox("2 bedrooms", false);
   JCheckBox threeBox = new JCheckBox("3 bedrooms", false);
   final int NOMEALSPRICE = 0, MEALSPRICE = 200;
   ButtonGroup mealGroup = new ButtonGroup();
   JCheckBox noMealsBox = new JCheckBox("No meals",false);
   JCheckBox mealsBox = new JCheckBox("Meals included",false);
   JTextField txtTotalPrice = new JTextField(10);
   String output;
   public JVacationRental()
   {
      super("Vacation rentals");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(flow);
      
      //Add buttons to groups
      locationGroup.add(parkBox);
      locationGroup.add(poolBox);
      locationGroup.add(lakeBox);
      bedroomGroup.add(oneBox);
      bedroomGroup.add(twoBox);
      bedroomGroup.add(threeBox);
      mealGroup.add(noMealsBox);
      mealGroup.add(mealsBox);
      
      //add Item Listeners
      parkBox.addItemListener(this);
      poolBox.addItemListener(this);
      lakeBox.addItemListener(this);
      twoBox.addItemListener(this);
      threeBox.addItemListener(this);
      noMealsBox.addItemListener(this);
      mealsBox.addItemListener(this);
      
      //add buttons to frame
      add(parkBox);
      add(poolBox);
      add(lakeBox);
      add(oneBox);
      add(twoBox);
      add(threeBox);
      add(noMealsBox);
      add(mealsBox);
      
      //set initial Total Price
      txtTotalPrice.setText(" ");
      add(txtTotalPrice);
   }
   
   @Override
   public void itemStateChanged(ItemEvent check)
   {
    Object source = check.getItem();
    if(source == parkBox)
    {
       int select = check.getStateChange();
       if(select == ItemEvent.SELECTED)
          totalPrice += PARKPRICE;
       else if(select == ItemEvent.DESELECTED)
          totalPrice -= PARKPRICE;
       output = " $" + totalPrice;
       txtTotalPrice.setText(output);
      }
      else if(source == poolBox)
      {
	int select = check.getStateChange();
	if(select == ItemEvent.SELECTED)
	      totalPrice += POOLPRICE;
	else if(select == ItemEvent.DESELECTED)
	      totalPrice -= POOLPRICE;
	output = " $" + totalPrice;
	txtTotalPrice.setText(output);
      }
      else if(source == lakeBox)
      {
	 int select = check.getStateChange();
	 if(select == ItemEvent.SELECTED)
	    totalPrice += LAKEPRICE;
	 else if(select == ItemEvent.DESELECTED)
   	    totalPrice -= LAKEPRICE;
   	 output = " $" + totalPrice;
	 txtTotalPrice.setText(output);
      }
      else if(source == oneBox)
      {
	 int select = check.getStateChange();
	 if(select == ItemEvent.SELECTED)
	      totalPrice += ONEPRICE;
	 else if(select == ItemEvent.DESELECTED)
   	      totalPrice -= ONEPRICE;
   	 output = " $" + totalPrice;
	 txtTotalPrice.setText(output);
      }
      else if(source == twoBox)
      {
	int select = check.getStateChange();
	if(select == ItemEvent.SELECTED)
	    totalPrice += TWOPRICE;
	else if(select == ItemEvent.DESELECTED)
   	      totalPrice -= TWOPRICE;
   	output = " $" + totalPrice;
	txtTotalPrice.setText(output);
      }
      else if(source == threeBox)
      {
	int select = check.getStateChange();
	if(select == ItemEvent.SELECTED)
	    totalPrice += THREEPRICE;
	else if(select == ItemEvent.DESELECTED)
	    totalPrice -= THREEPRICE;
	output = " $" + totalPrice;
	txtTotalPrice.setText(output);
      }
      else if(source == noMealsBox)
      {
	int select = check.getStateChange();
	if(select == ItemEvent.SELECTED)
	      totalPrice += NOMEALSPRICE;
	else if(select == ItemEvent.DESELECTED)
   	    totalPrice -= NOMEALSPRICE;
   	output = " $" + totalPrice;
	    txtTotalPrice.setText(output);
      }
      else if(source == mealsBox)
      {
	 int select = check.getStateChange();
	 if(select == ItemEvent.SELECTED)
	      totalPrice += MEALSPRICE;
	 else if(select == ItemEvent.DESELECTED)
	      totalPrice -= MEALSPRICE;
	 output = " $" + totalPrice;
	 txtTotalPrice.setText(output);
      }
   }
   
   public static void main()
   {
      JVacationRental aFrame = new JVacationRental();
      aFrame.setSize(350,200);
      aFrame.setVisible(true);
   }
}
