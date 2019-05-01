/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package hotdoghouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author mark
 */
public class Card extends JFrame implements ActionListener
{
    // <editor-fold defaultstate="collapsed" desc="Delcarations">
    private final int CWIDTH = 500;
    private final int CHEIGHT = 300;
    private String cardType, name, cardNum, expDate, cvv, zipcode;
    
    private JPanel pane;
    private final String[] labelStr;
        
    private JLabel[] labels;
    private JTextField[] text;
    private JButton charge;
    public JButton process;
    
    public boolean isValid = false;
    
    GridBagConstraints c;
    private int[][] paneC;
    // </editor-fold>

    /**
     * Default Constructor
     */
    public Card()
    {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
               
        setSize(CWIDTH, CHEIGHT);
        setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenH = screenSize.height;
        int screenW = screenSize.width;
        
        setLocationRelativeTo(null);
        
        labelStr = new String[]
                {"Name: ", "CC Number: ", "Exp Date: ", "CVV: ", "Zipcode: "};
        
        initCredit(); 
    }
    
    /**
     * Initializes Components
     */
    private void initCredit()
    {
        pane = new JPanel(new GridBagLayout());
        paneC = new int [][]
            {{0,0,1,1},
             {0,1,1,1},
             {0,2,1,1},
             {0,3,1,1},
             {0,4,1,1},
             {1,5,4,2}
            };
        c = new GridBagConstraints();
        
        labels = new JLabel[labelStr.length];
        text = new JTextField[labelStr.length];
        c.fill = GridBagConstraints.NONE;
        for (int i = 0; i < labelStr.length; i++)
        {
            labels[i] = new JLabel(labelStr[i]);
            text[i] = new JTextField(16);
            
            c.anchor = GridBagConstraints.EAST;
            c.gridx = paneC[i][0];
            c.gridy = paneC[i][1];
            c.gridwidth = paneC[i][2];
            c.gridheight = paneC[i][3];
            pane.add(labels[i], c);
            c.anchor = GridBagConstraints.WEST;
            c.gridx = paneC[i][0] + 1;
            c.gridy = paneC[i][1];
            c.gridwidth = paneC[i][2] + 4;
            c.gridheight = paneC[i][3];
            pane.add(text[i],c);
        }
        charge = new JButton("Charge");
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = paneC[5][0];
        c.gridy = paneC[5][1];
        c.gridwidth = paneC[5][2];
        c.gridheight = paneC[5][3];
        charge.setPreferredSize(new Dimension(150, 50));
        charge.setFocusPainted(false);
        pane.add(charge, c);
        
        process = new JButton("Process");
        charge.addActionListener(this);
        
        add(process);
        process.setVisible(false);
        add(pane);
        
    }
    
    /**
     * Processes the Card
     */
    private void processCharge()
    {
        try
        {
            if (!text[1].getText().isEmpty())
            {
                if (isValid(text[1].getText()))
                {
                    name = text[0].getText();
                    cardNum = text[1].getText();
                    cardType = detectCType(cardNum);
                    expDate = text[2].getText();
                    cvv = text[3].getText();
                    zipcode = text[4].getText();
                    
                    if(name.isEmpty() || expDate.isEmpty() || cvv.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please Fill out all required fields", "Declined", 1);
                    } else
                    {
                        if(checkDate(expDate))
                            isValid = true;
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The Customers Card is Expired.", "Declined", 1);
                        }
                    }
                } else
                {
                    JOptionPane.showMessageDialog(null, "The Customers Card has been Declined.", "Declined", 2);
                }
            }
            else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number", "Error", 2);
                }
        }
        catch (Exception error)
        {
            JOptionPane.showMessageDialog(null, "An Error has Occured", "Error", 2);
        }
    }
    
    /**
     * Returns the Card Type as String
     * @return Card Type
     */
    public String getVendor()
    {
        return cardType;
    }
    
    /**
     * Returns Masked Card Number as String
     * @return Masked Card Number
     */
    public String getCardNumber()
    {
        char[] cc = cardNum.toCharArray();
        return "XXXX XXXX XXXX " + cc[12] + cc[13] + cc[14] + cc[15];
    }
    
    /**
     * Resets Card Components
     */
    public void resetCard()
    {
        for(JTextField t : text)
        {
            t.setText("");
        }
        text[0].requestFocus();
        isValid = false;
        setVisible(false);
    }
    
    /**
    * Validates Card Numbers
    * @param cc Card Number
    * @return isValid boolean
    */
    public boolean isValid(String cc)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = cc.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(cc.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
    
    /**
     * Compares the Date to today and returns true if the date is not expired
     * @param date Expiration Date
     * @return Date Expiration Status (true/false)
     */
    public boolean checkDate(String date)
    {
        DateTimeFormatter MMyy = DateTimeFormatter.ofPattern("MMyy");
        DateTimeFormatter MMyyyy = DateTimeFormatter.ofPattern("MMyyyy");
        LocalDate now = LocalDate.now();
        YearMonth today = YearMonth.parse(now.format(MMyy), MMyy);
                
        boolean dateOK = false;
        try
        {
            YearMonth expiry = YearMonth.parse(date.replaceAll("/", ""), MMyy);
            if (expiry.getMonthValue() >= today.getMonthValue() && expiry.getYear() >= today.getYear())
            {
                dateOK = true;
            }
            
        } catch (Exception e1)
        {
            try
            {
                YearMonth expiry = YearMonth.parse(date.replaceAll("/", ""), MMyyyy);
                if (expiry.getMonthValue() >= today.getMonthValue() && expiry.getYear() >= today.getYear())
                {
                    dateOK = true;
                }
            }
            catch (Exception e2)
            {
                
            }
        }    
        return dateOK;
    }
    
    /**
    * Automatically Detects the Card Type
    * and returns it as a String
    * @param cc Card Number
    */
    private String detectCType(String cc)
    {
        if (cc.startsWith("4"))
            return "Visa";
        else if (cc.startsWith("5"))
            return "MasterCard";
        else if (cc.startsWith("6"))
            return "Discover";
        else if (cc.startsWith("37"))
            return "American Express";
        else
            return "UNKNOWN";
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == charge)
        {
            processCharge();
            if(isValid)
                process.doClick();
        }
    }
}
