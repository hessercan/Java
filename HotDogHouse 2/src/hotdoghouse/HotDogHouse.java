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
import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*; 

/**
 * @author mark
 */
public class HotDogHouse extends JFrame implements ActionListener
{
    // <editor-fold defaultstate="collapsed" desc="Delcarations">
    private final int FHEIGHT = 700;
    private final int FWIDTH = 900;
    private final String TITLE = "Mark's Hot Dog House";
    private final String COPYRIGHT = "Copyright © HesserCAN 2018";

    private final Dimension MENUBTND, ATOBTND, TENDERBTND, TENDERQBTND;
    
    private final JMenuBar mainBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem file_exit = new JMenuItem("Exit");
    
    private final JLabel titleLbl;
    
    GridBagConstraints c;
    int[][] tenderC;
    
    private JPanel jPTop, jPBottom, jPCenter, jPOrder, jPmodLabel, jPmiBtns, jPmcBtns, jPSelect, jPATO, jPTender;
    
    private final JTextArea orderTA = new JTextArea(38, 40);
    private final JScrollPane orderSP = new JScrollPane(orderTA);
    
    private final JTextField itemSelected = new JTextField(18);
    private final JTextField modSelected = new JTextField(18);
    private StringBuilder updateSB;
    
    //Menu Item Components
    private JButton[] miBtns;
    private final String[] miBtnStr = {"Regular\nHot Dog", "Foot-long\nHot Dog", "Italian\nSausage", "Kielbasa"};
    private final String[] miStr = {"Regular Hot Dog", "Foot-long Hot Dog", "Italian Sausage", "Kielbasa"};
    private final double[] miPrice = {2,3,3.5,3.5};
    private boolean[] miWasPressed;
    private boolean itemIsSelected;
    
    //Modifier Components
    private JButton[] mcBtns;
    private final String[] mcBtnStr = {"Ketchup", "Mustard", "Relish", "Onions", "Chili", "Peppers &\nOnions", "Cheese", "Clear"};
    private final String[] mcStr = {"Ketchup", "Mustard", "Relish", "Onions", "Chili", "Peppers & Onions", "Cheese", "Clear"};
    private final double[] mcPrice = {0,0,0,0,1,1,0.5};
    private boolean[] mcWasPressed;
    private String itemSelectStr, modSelectStr;
    
    //Order Components
    StringBuilder orderSB;
    private final JButton atoBtn = new JButton("Add to Order");
    private final JButton clearBtn = new JButton("Clear Order");
    private final JButton totalBtn = new JButton("Total");
    private int orderNum = 0;
    private String myOrderStr;
    private double subTotal = 0, salesTax = 0, gTotal = 0;
    private final double TAX = .06;
    
    //Tender Componets
    private StringBuilder tenderSB;
    private JTextField tenderTxt;
    double tenderAmt, cashTendered, creditTendered, change;
    boolean isTender, dotWP, endOrder;
    private JButton[] tenderBtns;
    private String[] tenderStr = {"1", "2", "3", "Exact Cash", "Next Dollar", 
        "4", "5", "6", "$5", "$10", "7", "8", "9", "$20", "$50", 
        ".", "0", "Clear", "Enter", "Credit/Debit"};
    private int decimalCounter;
    private String changeStr;
    private JLabel changeLbl;
    
    ArrayList<OrderItem> myOrder;
    //Customer Components
    private String custName;

    //Fonts
    private final Font titleFont = new Font("Arial", Font.BOLD, 24);
    private final Font copyFont = new Font("Arial", Font.PLAIN, 14);
    private final Font changeFont = new Font("Arial", Font.BOLD, 24);
    private final Font taFont = new Font("monospaced", Font.PLAIN, 12);
    
    //Write to File Components
    Path file = Paths.get(System.getProperty("user.home") 
                + "/Desktop/Order.txt"); 
    // </editor-fold>
    
    //credit card window
    //Work in Progress
    public Card credit;
    
    /**
     * Default Constructor
     */
    public HotDogHouse()
    {
        Image icon = Toolkit.getDefaultToolkit().getImage("AppIcon.png");
        setIconImage(icon);
        setTitle(TITLE);
        titleLbl = new JLabel(TITLE);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(FWIDTH, FHEIGHT);
        setResizable(false);
        setLayout(new BorderLayout());
        
        //Dimensions
        MENUBTND = new Dimension(125, 50);
        ATOBTND = new Dimension(150, 50);
        TENDERBTND = new Dimension(50, 50);
        TENDERQBTND = new Dimension(100, 50);

        //Detects Screen Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenH = screenSize.height;
        int screenW = screenSize.width;
        //Places Window in the Center of the Screen
        setLocationRelativeTo(null);
        
        initComponents();

        createMenuBar();
        createMenuBtns();
        createTenderBtns();
        createFrame();
        addActionListeners();
        
        clearOrder();
        
        setVisible(true);
    }
    
    private void initComponents()
    {
        c = new GridBagConstraints();

        //Init Title
        titleLbl.setFont(titleFont);
        
        //Init Menu Item Components
        jPmiBtns = new JPanel(new GridLayout(1,4));
        miBtns = new JButton[miBtnStr.length];
        miWasPressed = new boolean[miBtnStr.length];
        itemSelectStr = "";
                
        //Init Modifier Components
        jPmcBtns = new JPanel(new GridLayout(2,4));
        mcBtns = new JButton[mcBtnStr.length];
        mcWasPressed = new boolean[mcBtnStr.length];
        modSelectStr = "";
        
        //Init Print Components
        orderSB = new StringBuilder();
        updateSB = new StringBuilder();
        
        //Init Order Components
        jPATO = new JPanel(new FlowLayout());
        atoBtn.setPreferredSize(ATOBTND);
        atoBtn.setFocusPainted(false);
        totalBtn.setPreferredSize(ATOBTND);
        totalBtn.setFocusPainted(false);
        clearBtn.setPreferredSize(ATOBTND);
        clearBtn.setFocusPainted(false);
        jPATO.add(atoBtn);
        jPATO.add(totalBtn);
        jPATO.add(clearBtn);
        orderNum = 100;
        itemIsSelected = false;
        isTender = false;
        endOrder = false;
        
        //Init Customer Info Components
        custName = "";     
        
        //Init Tender Components
        jPTender = new JPanel(new GridBagLayout());
        tenderC = new int[][] 
           {{0,0,1,1},{1,0,1,1},{2,0,1,1},
            {3,0,2,1},{5,0,2,1}, //Row 0
            {0,1,1,1},{1,1,1,1},{2,1,1,1},
            {3,1,2,1},{5,1,2,1}, //Row 1
            {0,2,1,1},{1,2,1,1},{2,2,1,1},
            {3,2,2,1},{5,2,2,1}, //Row 2
            {0,3,1,1},{1,3,1,1},{2,3,1,1},
            {3,3,2,1},{5,3,2,1}  //Row 3
        };
        decimalCounter = 0;
        
        credit = new Card();
        credit.process.addActionListener(this);
        credit.setVisible(false);
        
        //Init Order Array List
        myOrder = new ArrayList<>();
        
        changeLbl = new JLabel();
    }
    
    //Creates the Menu Bar
    private void createMenuBar()    
    {
        setJMenuBar(mainBar);
        mainBar.add(fileMenu);
        fileMenu.add(file_exit);
    }
    
    //Creates all the Menu Item Buttons
    private void createMenuBtns()
    {
        for (int i = 0; i < miBtnStr.length; i++)
        {
            miBtns[i] = new JButton("<html><p align=\"center\">" 
                    + miBtnStr[i].replaceAll("\n", "<br>") + "</p></html>");
            miBtns[i].setOpaque(true);
            miBtns[i].setBackground(Color.WHITE);
            miBtns[i].setPreferredSize(MENUBTND);
            miBtns[i].setFocusPainted(false);
            jPmiBtns.add(miBtns[i]); 
            miWasPressed[i] = false;
        }

        for (int i = 0; i < mcBtnStr.length; i++)
        {
            mcBtns[i] = new JButton("<html><p align=\"center\">" 
                    + mcBtnStr[i].replaceAll("\n", "<br>") + "</p></html>");
            mcBtns[i].setOpaque(true);
            mcBtns[i].setBackground(Color.WHITE);
            mcBtns[i].setPreferredSize(MENUBTND);
            mcBtns[i].setFocusPainted(false);
            jPmcBtns.add(mcBtns[i]); 
            mcWasPressed[i] = false;  
        }
    }
    
    //Create All the Tender Buttons
    private void createTenderBtns()
    {
        tenderSB = new StringBuilder();
        tenderTxt = new JTextField(20);
        tenderBtns = new JButton[tenderStr.length];
        for (int i = 0; i < tenderStr.length; i++)
        {
            tenderBtns[i] = new JButton(String.format("%s", tenderStr[i]));
            tenderBtns[i].setOpaque(true);
            tenderBtns[i].setBackground(Color.WHITE);
            tenderBtns[i].setEnabled(false);
            tenderBtns[i].setFocusPainted(false);
            
            if(i == 3 || i == 4 || i == 8 || i == 9 || i == 13 || i == 14 || i == 18 || i == 19)
                tenderBtns[i].setPreferredSize(TENDERQBTND);
            else 
                tenderBtns[i].setPreferredSize(TENDERBTND);
            
            c.gridx = tenderC[i][0];
            c.gridy = tenderC[i][1];
            c.gridwidth = tenderC[i][2];
            c.gridheight = tenderC[i][3];
            jPTender.add(tenderBtns[i], c);
        }
    }
    
    //Adds the Components to the Frame
    private void createFrame()
    {
        //Add Frame Components
        jPTop = new JPanel(new FlowLayout());
        jPTop.add(titleLbl);
        add(jPTop, BorderLayout.NORTH);
        jPCenter = new JPanel(new FlowLayout());
        add(jPCenter, BorderLayout.CENTER);
        jPBottom = new JPanel(new FlowLayout());
        jPBottom.add(new JLabel(COPYRIGHT)).setFont(copyFont);
        add(jPBottom, BorderLayout.SOUTH);
        jPOrder = new JPanel(new FlowLayout());
        jPOrder.add(orderSP);
        add(jPOrder, BorderLayout.EAST);
        orderTA.setFont(taFont);
        orderTA.setEditable(false);
        
        //Add Labels for Selected item
        jPSelect = new JPanel(new GridLayout(2,2));
        itemSelected.setEditable(false);
        modSelected.setEditable(false);
        jPSelect.add(new JLabel("Item Selected"));
        jPSelect.add(new JLabel("Modifier Selected"));
        jPSelect.add(itemSelected);
        jPSelect.add(modSelected);
        
        //Add Center Components
        jPCenter.add(jPSelect);
        jPCenter.add(jPmiBtns);
        jPmodLabel = new JPanel(new FlowLayout());
        jPmodLabel.add(new JLabel("Additional Modifiers"));
        jPCenter.add(jPmodLabel);
        jPCenter.add(jPmcBtns);
        jPCenter.add(jPATO);
        jPCenter.add(tenderTxt);
        tenderTxt.setEditable(false);
        jPCenter.add(jPTender);
        
    }
    
        //Adds Action Listeners to all Components
    private void addActionListeners()
    {
        file_exit.addActionListener(this);
        
        for (JButton miBtn : miBtns)
        {
            miBtn.addActionListener(this);
        }
        for (JButton mcBtn : mcBtns)
        {
            mcBtn.addActionListener(this);
        }
        atoBtn.addActionListener(this);
        totalBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        
        for (JButton tenderBtn : tenderBtns)
        {
            tenderBtn.addActionListener(this);
        }
    }

    //Increments the order number by one
    //Clears the Order
    public void newOrder()
    {
        if(orderNum >= 199)
            orderNum = 100;
        else 
            orderNum++;
        
        clearOrder();
    }
    
    //Resets Variables and Creates new order
    private void clearOrder()
    {
        myOrder.clear();        
        custName = "";
        tenderSB.setLength(0);
        tenderTxt.setText("");
        isTender = false;
        dotWP = false;
        decimalCounter = 0;
        tenderAmt = 0;
        cashTendered = 0;
        creditTendered = 0;
        
        resetItemSelection();
        resetModSelection();
        resetTender();
        updateIS();
    }
    
    //Response to a Menu Item button being pressed
    private void itemWasPressed(int index)
    {   
        
        for (int i = 0; i < miWasPressed.length; i++)
        {
            if(i != index)
            {
                miWasPressed[i] = false;
                miBtns[i].setBackground(Color.WHITE);
            }
        }

        miWasPressed[index] = !miWasPressed[index];
        
        if (miWasPressed[index])
        {
            itemIsSelected = true;
            itemSelectStr = String.format("\n*%s ($%.2f)\n", miStr[index], miPrice[index]);
            itemSelected.setText(miStr[index]);
            miBtns[index].setBackground(Color.YELLOW);
        }
        else
        {
            itemIsSelected = false;
            itemSelectStr = "";
            itemSelected.setText("");
            miBtns[index].setBackground(Color.WHITE);
            
        }
        resetModSelection();
        updateIS();
        updateOrder();
    }
    
    //Response to a modifier button being pressed
    private void modWasPressed(int index)
    {
        if (index == 7)
        {
            resetModSelection();
            updateIS();
        } else
        {
            mcWasPressed[index] = !mcWasPressed[index];

            //Set Mod Selected Text
            if (mcWasPressed[index])
            {
                modSelected.setText(mcStr[index]);
                mcBtns[index].setBackground(Color.YELLOW);
            } else
            {
                modSelected.setText("");
                mcBtns[index].setBackground(Color.WHITE);
            }
        }
        modSelectStr = "";

        for (int i = 0; i < mcWasPressed.length - 1; i++)
        {
            if (mcWasPressed[i])
            {

                if (mcPrice[i] != 0)
                {
                    modSelectStr += String.format(" - add %s ($%.2f)\n", mcStr[i], mcPrice[i]);
                } else
                {
                    modSelectStr += String.format(" - add %s\n", mcStr[i]);
                }
            }
        }
        
        updateOrder();
    }
    
    //Response to the Total button being pressed
    private void totalWasPressed()
    {
        if(itemIsSelected)
            addToOrder();
        
        resetItemSelection();
        resetModSelection();
        resetTender();
        printMyOrder();
        printTotal();
    }
    
    /**
     * Response to a tender key being pressed
     * @param index relates to the button that was pressed
     */
    private void tenderKey(int index)
    {
        switch(index)
        {
            //Numeric Pad
            case 0:  //1
            case 1:  //2
            case 2:  //3
            case 5:  //4
            case 6:  //5
            case 7:  //6
            case 10: //7
            case 11: //8
            case 12: //9
            case 16: //0
            {
                if(dotWP)
                {
                    if(decimalCounter < 2)
                    {
                        tenderSB.append(tenderStr[index]);
                        decimalCounter++;
                    }
                }
                else
                    tenderSB.append(tenderStr[index]);
                break;
            }
            
            case 15: //Dot
            {
                if(!dotWP)
                {
                    tenderSB.append(tenderStr[index]);
                    dotWP = true;
                }
                break;
            } 
            
            //Tender Quick Actions
            case 3: {
                tenderAmt = gTotal;
                printMyOrder();
                printTotal();
                tenderOrder();
                break;
            } //Exact Cash
            case 4: {
                tenderAmt = Math.ceil(gTotal);
                printMyOrder();
                printTotal();
                tenderOrder();
                break;
            }  //Next Dollar
            case 8: {
                tenderAmt = 5;
                if ((cashTendered % 5) != 0)
                    cashTendered = 0;
                tenderOrder();
                break; 
            } //$5
            case 9: {
                tenderAmt = 10;
                if ((cashTendered % 10) != 0)
                    cashTendered = 0;
                tenderOrder();
                break; 
            } //$10
            case 13: {
                tenderAmt = 20;
                if ((cashTendered % 20) != 0)
                    cashTendered = 0;
                tenderOrder();
                break; 
            } //$20
            case 14: {
                tenderAmt = 50;
                if ((cashTendered % 50) != 0)
                    cashTendered = 0;
                tenderOrder();
                break; 
            } //$50

            case 17: {
                dotWP = false;
                decimalCounter = 0;
                tenderSB.setLength(0);
                tenderAmt = 0;
                cashTendered = 0;
                break;
            } //Clear
            case 18: {
                try
                {
                    tenderAmt = Double.parseDouble(tenderSB.toString());
                    
                }
                catch(NumberFormatException error)
                {
                    tenderAmt = 0;
                }
                
                tenderOrder();
                break;
            } //Enter
            case 19: {
                credit.setVisible(true);
                break;
            } //Credit (Work in Progess)
            default: break; 
        }
        
        tenderTxt.setText(tenderSB.toString());
    }
    
    /**
     * Uses String Builder to append item being worked on to the Text Area
     */
    private void updateOrder()
    {
        printMyOrder();
        updateSB.setLength(0);
        updateSB.append(itemSelectStr);
        updateSB.append(modSelectStr);
        orderSB.append(updateSB);
        printTotal();
    }
        
    /**
     * Enables and Disables Tender Buttons and Menu Item Buttons
     */
    private void updateIS()
    {
        if (itemIsSelected)
        {
            for (JButton mcBtn : mcBtns)
            {
                mcBtn.setEnabled(true);
            }
            atoBtn.setEnabled(true);
            totalBtn.setEnabled(true);
            clearBtn.setEnabled(true);
        } else if (!itemIsSelected && myOrder.isEmpty())
        {
            for (int i = 0; i < mcBtns.length; i++)
            {
                mcBtns[i].setBackground(Color.WHITE);
                mcBtns[i].setEnabled(false);
                mcWasPressed[i] = false;
            }
            atoBtn.setEnabled(false);
            totalBtn.setEnabled(false);
            clearBtn.setEnabled(false);
            
        } else
        {
            for (int i = 0; i < mcBtns.length; i++)
            {
                mcBtns[i].setBackground(Color.WHITE);
                mcBtns[i].setEnabled(false);
                mcWasPressed[i] = false;
            }
            atoBtn.setEnabled(false);
        }
    }
    
    //Creates a new Order Object based on what buttons were pressed.
    private void addToOrder()
    {
        if (itemIsSelected)
        {
            String in = "";
            double ip = 0;
            for (int i = 0; i < miWasPressed.length; i++)
            {
                if (miWasPressed[i])
                {
                    in = miStr[i];
                    ip = miPrice[i];
                }
            }

            int modLength = 0;
            for (boolean mc : mcWasPressed)
            {
                if (mc)
                {
                    modLength++;
                }
            }
            String[] mod = new String[modLength];
            double[] mp = new double[modLength];

            int mI = 0;
            for (int i = 0; i < mcWasPressed.length; i++)
            {
                if (mcWasPressed[i])
                {
                    mod[mI] = mcStr[i];
                    mI++;
                }
            }

            mI = 0;
            for (int i = 0; i < mcWasPressed.length; i++)
            {
                if (mcWasPressed[i])
                {
                    mp[mI] = mcPrice[i];
                    mI++;
                }
            }

            myOrder.add(new OrderItem(in, ip, mod, mp));
        }

        printMyOrder();
        printTotal();
        resetItemSelection();
        resetModSelection();
        updateIS();
    }

    /**
     * Regenerates the order StringBuilder from the myOrder Array
     * Calculates the sub Total of the Order and sets it to the Text Area
     */
    private void printMyOrder()
    {
        subTotal = 0;
        gTotal = 0;
        orderSB.setLength(0);
        
        //Adds order number to receipt
        orderSB.append(String.format("Order Number: %d\n", orderNum));
        
        if(custName != "") //Adds customer name to receipt
            orderSB.append(String.format("Customer: %s\n", custName));
        
        if(!myOrder.isEmpty())
        {
            myOrder.forEach((oi) ->
            {
                String in = oi.getItemName();
                double ip = oi.getItemPrice();
                String[] mod = oi.getModifers();
                double[] mp = oi.getModPrice();
                subTotal += oi.getPrice();

                orderSB.append(String.format("\n%s ($%.2f)\n", in, ip));
                for (int i = 0; i < mod.length; i++)
                {
                    if (mp[i] != 0)
                    {
                        orderSB.append(String.format(" - add %s ($%.2f)\n", mod[i], mp[i]));
                    } else
                    {
                        orderSB.append(String.format(" - add %s\n", mod[i]));
                    }
                }
            });
        }
    }

    /**
     * Calculates the Sales Tax and Order Total 
     * and adds it to the order Text Area
     */
    private void printTotal()
    {
        salesTax = subTotal * TAX;
        gTotal = subTotal + salesTax;
        
        if(subTotal != 0)
        {
            orderSB.append(String.format("\nSub Total:\t\t$%.2f", subTotal));
            orderSB.append(String.format("\nSales Tax:\t\t$%.2f\n", salesTax));
            orderSB.append(String.format("\nTotal:    \t\t$%.2f\n", gTotal));
        }
        
        myOrderStr = orderSB.toString();
        orderTA.setText(myOrderStr);
    }
     
    /**
     * Prompts the user to enter a Customer name
     * If none is provided the user is put back to edit order
     * A name is required to tender
     */
    private void promptCustName()
    {
        custName = JOptionPane.showInputDialog(null, "Customer Name: ");
        if(custName.isEmpty())
        {
            custName = "";
            isTender = true;
        }
        else
        {
            updateOrder();
        }
    }
    
    /**
     * Processes the amount tendered and calculates the appropriate response
     */
    private void tenderOrder()
    {
        
        if(credit.isValid)
        {
            creditTendered = gTotal - cashTendered;
            
            if(cashTendered > 0)
                orderSB.append(String.format("\nCash Tendered:\t\t$%.2f\n", cashTendered));
            
            orderSB.append(String.format("\nPAID: Credit (Approved) $%.2f\n", creditTendered));
            orderSB.append("Card Type: ").append(credit.getVendor()).append("\n");
            orderSB.append("Account #: ").append(credit.getCardNumber()).append("\n");
            orderSB.append("\n----------------------------------\n");
            orderTA.setText(orderSB.toString());
            credit.resetCard();
            writeOrderToFile();
            newOrder();
        } else 
        {
            cashTendered += tenderAmt;
            
            if (cashTendered >= gTotal)
            {
                change = gTotal - cashTendered;

                //Inverts negative if change is not zero
                if (change == 0)
                {
                    change = 0;
                } else
                {
                    change = -(change);
                }

                orderSB.append(String.format("\nCash Tendered:\t\t$%.2f\n", cashTendered));
                orderSB.append(String.format("Change:\t\t\t$%.2f"
                        + "\n----------------------------------\n", change));
                myOrderStr = orderSB.toString();
                orderTA.setText(myOrderStr);
                orderTA.append("end of order");
                writeOrderToFile();
                displayChange();
                newOrder();
            }
            else
            {
                orderTA.append(String.format("\nCash:\t\t\t$%.2f", -(tenderAmt)));
                dotWP = false;
                decimalCounter = 0;
                tenderSB.setLength(0);
            }
        }
    }
    
    /**
     * Displays a dialog with the Change
     */
    private void displayChange()
    {
        changeStr = String.format("Cash Tendered: $%.2f\nChange: $%.2f", cashTendered, change);
        changeLbl.setText("<html><p align=\"right\">" 
                    + changeStr.replaceAll("\n", "<br>") + "</p></html>");
        changeLbl.setFont(changeFont);
        JOptionPane.showMessageDialog(null, changeLbl);
    }
    
    /**
     * Writes the receipt to file and console 
     */
    private void writeOrderToFile()
    {
        orderSB.insert(0, "\n" + TITLE + "\n\n");
        myOrderStr = orderSB.toString();
        try{
            try (OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND)))
            {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output)))
                {
                    writer.write(myOrderStr, 0, myOrderStr.length());
                    writer.newLine();
                }
                output.flush();
            }
        } catch (IOException e)
        {
            System.out.println("Message: " + e);
        }
        System.out.println(orderSB.toString());
    }
    
    /**
     * Resets the Menu Item selection components
     */
    private void resetItemSelection()
    {
        for (int i = 0; i < miWasPressed.length; i++)
        {
            miWasPressed[i] = false;
        }
        for (JButton miB : miBtns)
        {
            miB.setBackground(Color.WHITE);
        }
        
        itemSelected.setText("");
        itemSelectStr = "";
        itemIsSelected = false;
    }

    /**
     * Resets the Modifier components
     */
    private void resetModSelection()
    {

        for (int i = 0; i < mcWasPressed.length; i++)
        {
            mcWasPressed[i] = false;
        }
        for (JButton mcB : mcBtns)
        {
            mcB.setBackground(Color.WHITE);
        }
        modSelected.setText("");
        modSelectStr = "";
    }
    
    /**
     * Resets the tender and order components based on which is needed
     */
    private void resetTender()
    {
        for (JButton miBtn : miBtns)
        {
            miBtn.setEnabled(!isTender);
        }
        for (JButton tenderBtn : tenderBtns)
        {
            tenderBtn.setEnabled(isTender);
        }
        if(isTender)
        {
            totalBtn.setText("Edit Order");
            tenderSB.setLength(0);
            dotWP = false;
        }
        else
            totalBtn.setText("Total");
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        if(source == file_exit)
            System.exit(0);
            
        if(source == miBtns[0])
        {
            itemWasPressed(0);
        }
        if(source == miBtns[1])
        {
            itemWasPressed(1);
        }
        if(source == miBtns[2])
        {
            itemWasPressed(2);
        }
        if(source == miBtns[3])
        {
            itemWasPressed(3);
        }
        if(source == mcBtns[0])
        {
            modWasPressed(0);
        }
        if(source == mcBtns[1])
        {
            modWasPressed(1);
        }
        if(source == mcBtns[2])
        {
            modWasPressed(2);
        }
        if(source == mcBtns[3])
        {
            modWasPressed(3);
        }
        if(source == mcBtns[4])
        {
            modWasPressed(4);
        }
        if(source == mcBtns[5])
        {
            modWasPressed(5);
        }
        if(source == mcBtns[6])
        {
            modWasPressed(6);
        }
        if(source == mcBtns[7])
        {
            modWasPressed(7);
        }
        if(source == atoBtn)
        {
            addToOrder();
        }
        if(source == totalBtn)
        {
            if(custName == "")
                promptCustName();
            isTender = !isTender;
            totalWasPressed();
        }
        if(source == clearBtn)
        {
            clearOrder();
            printMyOrder();
            printTotal();
        }
        if(source == tenderBtns[0]) //1
            tenderKey(0);
        if(source == tenderBtns[1]) //2
            tenderKey(1);
        if(source == tenderBtns[2]) //3
            tenderKey(2);
        if(source == tenderBtns[3]) //Exact Cash
            tenderKey(3);
        if(source == tenderBtns[4]) //Next Dollar
            tenderKey(4);
        if(source == tenderBtns[5]) //4
            tenderKey(5);
        if(source == tenderBtns[6]) //5
            tenderKey(6);
        if(source == tenderBtns[7]) //6
            tenderKey(7);
        if(source == tenderBtns[8]) //$5
            tenderKey(8);
        if(source == tenderBtns[9]) //$10
            tenderKey(9);
        if(source == tenderBtns[10]) //7
            tenderKey(10);
        if(source == tenderBtns[11]) //8
            tenderKey(11);
        if(source == tenderBtns[12]) //9
            tenderKey(12);
        if(source == tenderBtns[13]) //$20
            tenderKey(13);
        if(source == tenderBtns[14]) //$50
            tenderKey(14);
        if(source == tenderBtns[15]) //Dot
            tenderKey(15);
        if(source == tenderBtns[16]) //0
            tenderKey(16);
        if(source == tenderBtns[17]) //Clear
            tenderKey(17);
        if(source == tenderBtns[18]) //Enter
            tenderKey(18);
        if(source == tenderBtns[19]) //Credit
            tenderKey(19);
        if(source == credit.process)
        {
            credit.setVisible(false);
            tenderOrder();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        HotDogHouse dog = new HotDogHouse();
    }
}
