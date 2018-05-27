/*
 * Mark Hesser
 * HesserCAN 
 * mark@hessercan.com
 * www.hessercan.com
 */

package disapperingfriendsdemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author mark
 */
public class JDisappearingFriends extends JFrame implements ActionListener {
	int i = 1;
	JButton pressMe = new JButton("Press Me");
        JLabel a = new JLabel("Aaron");
	JLabel b = new JLabel("Heidi");
	JLabel c = new JLabel("Mark");
	JLabel d = new JLabel("Spencer");
	JLabel e = new JLabel("Lev");
	JLabel f = new JLabel("Roman");
        JLabel g = new JLabel("Dave");
        JLabel h = new JLabel("Zach");
        JLabel j = new JLabel("Andrew");
        JLabel k = new JLabel("Fred");
	
	public JDisappearingFriends() {
		super("Friends"); // sets title 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops program on window close
		setLayout(new FlowLayout());
		
		// adds Labels
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		add(f);
                add(g);
                add(h);
                add(j);
                add(k);
                add(pressMe);
                
                // sets Other Friends invisible
		f.setVisible(false);
                g.setVisible(false);
                h.setVisible(false);
                j.setVisible(false);
                k.setVisible(false);
                
		// keeps track of when button is pressed
		pressMe.addActionListener(this);
                
                
	}	

	// changes name based on button press
        @Override
	public void actionPerformed(ActionEvent event) {
            // adds and removes name based on value of i
            switch (i)
            { 
                case 10: 
                    k.setVisible(false);
                    j.setVisible(true);
                    i = 1;
                    break;
                case 9:                     
                    j.setVisible(false);
                    h.setVisible(true);
                    i = 10;
                    break;
                case 8:                     
                    h.setVisible(false);
                    g.setVisible(true);
                    i = 9;
                    break;
                case 7:                     
                    g.setVisible(false);
                    f.setVisible(true);
                    i = 8;
                    break;
                case 6:
                    f.setVisible(false);
                    e.setVisible(true);
                    i = 7;
                    break;
                case 5:
                    e.setVisible(false);
                    d.setVisible(true);
                    i = 6;
                    break;
                case 4:
                    d.setVisible(false);
                    c.setVisible(true);
                    i = 5;
                    break;
                case 3:
                    c.setVisible(false);
                    b.setVisible(true);
                    i = 4;
                    break;
                case 2:
                    b.setVisible(false);
                    a.setVisible(true);
                    i = 3;
                    break;
                default:
                    a.setVisible(false);
                    k.setVisible(true);
                    i = 2;
                    break;
            }
	}
}